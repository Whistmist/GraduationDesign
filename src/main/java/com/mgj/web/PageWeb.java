package com.mgj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mist on 2019/4/20.
 */
@Controller
public class PageWeb {
    @RequestMapping("microblog")
    public String microblog() {
        return "phtml/microblog";
    }
    @RequestMapping("weibo")
    public String weibo() {
        return "phtml/index";
    }
    @RequestMapping("hotpoint")
    public String hotpoint() {
        return "phtml/hotpoint";
    }
}
