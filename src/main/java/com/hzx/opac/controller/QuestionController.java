package com.hzx.opac.controller;

import com.hzx.opac.api.HttpResult;
import com.hzx.opac.domain.Question;
import com.hzx.opac.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    /**
     * 获取问题的详情
     * @param questionId
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public HttpResult questionDetail(Integer questionId) {
        HttpResult<Question> response = new HttpResult<Question>();
        return response;
    }

    /**
     * 获取最新的问题列表
     * @param since
     * @return
     */
    @RequestMapping(value = "/latest", method = RequestMethod.GET)
    @ResponseBody
    public HttpResult getLatest(Integer since){
        HttpResult<List<Question>> response = new HttpResult<List<Question>>();
        return response;
    }

    /**
     * 获取用户关注的问题列表
     * @param since
     * @return
     */
    @RequestMapping(value = "/myconcern", method = RequestMethod.GET)
    @ResponseBody
    public HttpResult getConcern(Integer since){
        HttpResult<List<Question>> response = new HttpResult<List<Question>>();
        return response;
    }

    /**
     * 用户提问问题
     * @param info
     * @return
     */
    @RequestMapping(value = "/ask", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult ask(@RequestBody String info){
        HttpResult<Question> response = new HttpResult<Question>();
        return response;
    }

    /**
     * 用户关注某一问题
     * @param userId
     * @param questionId
     * @return
     */
    @RequestMapping(value = "/concern", method = RequestMethod.GET)
    @ResponseBody
    public HttpResult concern(Integer userId, Integer questionId){
        HttpResult<Question> response = new HttpResult<Question>();
        return response;
    }

}
