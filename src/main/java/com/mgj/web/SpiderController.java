package com.mgj.web;

import com.mgj.entity.MicroBlog;
import com.mgj.service.MicroBlogService;
import com.mgj.utils.MicroBlogUtil;
import com.mgj.utils.RequestUrl;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@Controller
public class SpiderController {

	@Value("${appid}")
	private String appid;
	@Value("${microBlogNum}")
	private Integer microBlogNum;

	@Autowired
    private MicroBlogService microBlogService;
	@RequestMapping("getMicroBlog")
	@ResponseBody
	public List<MicroBlog> getMicroBlog() throws UnsupportedEncodingException, InterruptedException {
		String httpUrl ="http://s.weibo.com/top/summary?cate=realtimehot";
        Document page = MicroBlogUtil.get_page(httpUrl);
        List<MicroBlog> list = null;
        boolean bool=false;
        try{
            list=MicroBlogUtil.Analysis_page(page, microBlogNum);
             bool=microBlogService.insertTo(list);
        }catch (Exception e){
            System.out.println("微博爬虫失败---》"+e.getMessage());
        }
        log.info(list.toString());
        System.out.println(bool);
        return list;
	}

	@RequestMapping("todayInHistory")
	@ResponseBody
	public String todayInHistory(@RequestBody String YD) throws UnsupportedEncodingException {

		String[] split = YD.split("-");
		for (int i = 0; i < split.length; i++) {
			YD=Integer.parseInt(split[1])+"/"+Integer.parseInt(split[2]);
		}
		String jsonResult="";
		String httpUrl = "https://api.shenjian.io/todayOnhistory/queryEvent/";
		String date=URLEncoder.encode(YD,"UTF-8");
		String httpArg = "appid="+appid+"&date="+date;
		jsonResult = RequestUrl.request(httpUrl, httpArg);
		/*log.info(jsonResult);*/
		return jsonResult;
	}
}
