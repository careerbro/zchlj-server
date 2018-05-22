package com.main.careerbro.common.utils;

import com.main.careerbro.modules.college.entity.College;
import com.main.careerbro.modules.college.service.CollegeService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Lucene相关操作
 *
 * @author vinbrattany
 *
 */
public class LuceneUtils {
    // 索引存放路径
    // private static final String PATH =
    // "/Users/vinbrattany/Desktop/test/index";
    private static final Directory directory = new RAMDirectory();

    public Directory getDirectory() {
        return directory;
    }
//	public static  <T> T name(Class<T> className) {
//		T s = SpringContextHolder.getBean(className);
//		return s;
//	}

    // 建立索引
    public static void index() {
        long start = System.currentTimeMillis();

        CollegeService collegeService = SpringConfigTool.getApplicationContext().getBean(CollegeService.class);
        List<College> dataCollege = collegeService.getAllCollege();
        /*1） 标准分词技术（StandardAnalyzer）：标准分词技术对英文来说是不错的，把单词分成一个一个的词根，但是对于中文来说，只是简单的把中文分成一个一个的汉字。

        2）IK中文分词器（IKAnalyzer）：结合词典分词和文法分析算法的中文分词技术，能够对词典进行扩展，是一个很好的中文分词器。

        3）空格分词器（WhitespaceAnalyzer）：按照空格切分字符串。

        4）简单分词器（SimpleAnalyzer）：根据标点符号分词。

        5）二分法分词器（CJKAnalyzer）：二分法分词技术中每个汉字都会和它前边和后边的汉字组成一个词，也就是说每个汉字都会出现两次，除了首字和末字（前提是纯汉字，没有英文，因为英文会根据词根来分词），这种分词技术会有太多的词，会产生太多冗余。

        6）关键词分词器（KeywordAnalyzer）：不进行分割。

        7）被忽略词分词器（StopAnalyzer）：被忽略词如标点符号，这种分词技术和SimpleAnalyzer结果很像。
        */

        Analyzer analyzer = new StandardAnalyzer();//标准分词
        //创建索引写入配置
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);


        try {
            //创建索引写入对象
            IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
            indexWriter.deleteAll();
            //创建Document对象，存储索引

//            Document doc = new Document();
            // 4、为Document添加Field，是Document的一个子元素
            int i = 0;
            for (College cb
                    : dataCollege) {
                Document doc = new Document();
                addField2Document(doc, cb);
                //将doc对象保存到索引库中
                indexWriter.addDocument(doc);
                i++;
            }

            indexWriter.commit();
            //关闭流
            indexWriter.close();

            long end = System.currentTimeMillis();
            System.out.println("创建了"+i+"个索引花费了" + (end - start) + " 毫秒");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // 搜索
    public static List<HashMap<String, String>> search(String string) throws IOException, ParseException {

        List<HashMap<String, String>> data = new ArrayList<>();

        Analyzer ikAnalyzer = new IKAnalyzer();
        Analyzer enAnalyzer = new EnglishAnalyzer();
        // 1. 创建MultiFieldQueryParser搜索对象
        QueryParser cnQueryParser = new QueryParser("cName",ikAnalyzer);
        QueryParser enQueryParser = new QueryParser("eName",enAnalyzer);
        // 2、创建IndexReader
        IndexReader reader = DirectoryReader.open(directory);
        // 3、根据IndexReader创建IndexSearcher
        IndexSearcher searcher = new IndexSearcher(reader);
        // 4丶创建搜索对象
        Query cnQuery =  cnQueryParser.parse(string);
        Query enQuery =  enQueryParser.parse(string);
        // 5、根据searcher搜索并且返回TopDocs
        TopDocs cnTdoc = searcher.search(cnQuery, 10);// 只会显示10条内容
        TopDocs enTdoc = searcher.search(enQuery, 10);

        // 6、根据TopDocs获取ScoreDoc对象
        ScoreDoc sdocs[] = cnTdoc.scoreDocs.length>enTdoc.scoreDocs.length? cnTdoc.scoreDocs : enTdoc.scoreDocs;
        for (ScoreDoc s : sdocs) {
//            if (s.score > 0.2) {
                HashMap<String, String> hashMap = new HashMap<>();
                // 7、根据searcher行业ScoreDoc获取具体的Document对象
                Document document = searcher.doc(s.doc);

                // 8、根据Document对象获取所需要的值
                String cName = document.get("cName");
                String id = document.get("id");
                String eName = document.get("eName");
                hashMap.put("id", id);
                hashMap.put("cName", cName);
                hashMap.put("eName", eName);
//                hashMap.put("label", cName);
                data.add(hashMap);
//            }
        }
        // 9、关闭reader
        reader.close();
        return data;

    }

    // 添加

    public static void add() {
        CollegeService CollegeService = SpringConfigTool.getApplicationContext().getBean(CollegeService.class);
        List<College> collegeList = CollegeService.getAllCollege();
        IndexWriter writer = null;
        try {
            writer = new IndexWriter(directory, new IndexWriterConfig(new IKAnalyzer()));
            Document doc = new Document();
            // 添加
            for (College college:
            collegeList) {
                addField2Document(doc, college);
                writer.addDocument(doc);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 删除


//    public static void delete(College College) {
//        IndexWriter writer = null;
//        try {
//            writer = new IndexWriter(directory, new IndexWriterConfig( new IKAnalyzer()));
//            writer.deleteDocuments(new Term("id", College.getId()));// 这里表示删除索引为..的id
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (writer != null) {
//                try {
//                    writer.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    // 更新


//    public static void updata(College College) {
//        IndexWriter writer = null;
//        try {
//            writer = new IndexWriter(directory, new IndexWriterConfig( new IKAnalyzer()));
//
//			/*
//			 * lucene并没有提供更新，这里的更新操作其实是如下两个操作的合集 先删除之后再添加，所以不是在之前的位置更新 测试之后我们会发现回收站中有一个索引
//			 */
//            Document document = new Document();
//            addField2Document(document, College);
//            writer.updateDocument(new Term("id", College.getId()), document);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (writer != null) {
//                try {
//                    writer.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    // 清空回收站
//    public static void forcrDelete() {
//        IndexWriter writer = null;
//        try {
//            writer = new IndexWriter(directory, new IndexWriterConfig(new IKAnalyzer()));
//
//            writer.forceMergeDeletes();// 强制清除回收站
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (writer != null) {
//                try {
//                    writer.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    // 从回收站中回复
//    public void undelete() {
//
//        try {
//            // 使用IndexReader恢复，第二个参数表示readOnly，默认为true，这里我们设置为false
//            IndexReader reader = IndexReader.open(directory, false);
//            reader.undeleteAll();// 这里是恢复所有
//            reader.close();
//        } catch (StaleReaderException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    private static void addField2Document(Document doc, College college) {
        //不分词,不索引,储存
        doc.add(new StoredField("id", college.getId()));
        //分词,索引,不储存
        doc.add(new TextField("cName", college.getCName(), Field.Store.YES));
        doc.add(new TextField("eName", college.getEName(), Field.Store.YES));
    }

    // 删除文件
//    private static void delFile(String path) {
//        // boolean flag = false;
//        File file = new File(path);
//        // if (!file.exists()) {
//        // return flag;
//        // }
//        // if (!file.isDirectory()) {
//        // return flag;
//        // }
//        String[] tempList = file.list();
//        File temp = null;
//        if (null!=tempList&&tempList.length>0)
//        for (String aTempList : tempList) {
//            if (path.endsWith(File.separator)) {
//                temp = new File(path + aTempList);
//            } else {
//                temp = new File(path + File.separator + aTempList);
//            }
//            if (temp.isFile()) {
//                temp.delete();
//            }
//            if (temp.isDirectory()) {
//                delFile(path + "/" + aTempList);// 先删除文件夹里面的文件
//                delFolder(path + "/" + aTempList);// 再删除空文件夹
//                // flag = true;
//            }
//        }
//        // return flag;
//    }
//
//    // 删除文件夹
//    private static void delFolder(String folderPath) {
//        try {
//            delFile(folderPath); // 删除完里面所有内容
//            String filePath = folderPath;
//            filePath = filePath;
//            java.io.File myFilePath = new java.io.File(filePath);
//            myFilePath.delete(); // 删除空文件夹
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
