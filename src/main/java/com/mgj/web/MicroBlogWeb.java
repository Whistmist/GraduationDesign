package com.mgj.web;

import com.mgj.entity.MicroBlog;
import com.mgj.service.MicroBlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by mist on 2019/5/24.
 */
@Controller
@Slf4j
public class MicroBlogWeb {
    @Autowired
    private MicroBlogService microBlogService;

    @RequestMapping("queryMicroBlog")
    @ResponseBody
    public List<MicroBlog> getMicroBlog(){
        List<MicroBlog> list= microBlogService.queryMicroBlog();
        if(list==null){
            return null;
        }
        log.info(list.toString());
        return list;
    }
}
