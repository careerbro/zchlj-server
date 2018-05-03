package com.main.careerbro.modules.attention.controller;

import com.main.careerbro.modules.attention.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("attention")
@Controller
public class AttentionController {
    @Autowired
    AttentionService attentionService;
}
