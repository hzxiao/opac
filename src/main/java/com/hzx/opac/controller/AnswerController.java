package com.hzx.opac.controller;

import com.hzx.opac.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/answer")
public class AnswerController {

    @Autowired
    private CommentService commentService;


}
