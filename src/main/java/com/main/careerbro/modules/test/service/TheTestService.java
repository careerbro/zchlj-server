package com.main.careerbro.modules.test.service;


import com.main.careerbro.modules.test.dao.TheTestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TheTestService {
	@Autowired
	TheTestDao testDao;

	public List<Map<String, String>> getAllCompanys() {
//		return testDao.getAllCompanys();
		List<Map<String, String>> arrayList = new ArrayList<>();
		return arrayList;
	}

	public List<Map<String, String>> getCount() {
//		return testDao.getCount();
		return null;
	}

	public List<Map<String, String>> getCountFromOffice() {
//		return testDao.getCountFromOffice();
		return null;
	}



}

//import java.util.List;
//import java.util.Map;
//
//public interface TheTestService{
//
//	/**
//	 * @return all companys
//	 */
//	public List<Map<String, String>> getAllCompanys() ;
//
//	/**
//	 *
//	 * @return count
//	 */
//	public List<Map<String, String>> getCount() ;
//
//	/**
//	 *
//	 * @return count of office
//	 */
//	public List<Map<String, String>> getCountFromOffice();
//}
