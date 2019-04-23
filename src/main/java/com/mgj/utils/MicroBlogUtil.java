package com.mgj.utils;

import com.mgj.entity.MicroBlog;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mist on 2019/4/22.
 */
public class MicroBlogUtil {

    /**
     * 获取网页源码
     * @param url
     * @return
     * @throws InterruptedException
     */
    public static Document get_page(String url) throws InterruptedException{
        try {
            return Jsoup.connect(url).timeout(1000).get();
        } catch (IOException e) {
            System.out.println("url或网络连接错误"+e.getMessage());
            return null;
        }
    }



    /**
     * 解析微博网页详细源码
     * @param page_html
     * @returns
     */
    public static List<MicroBlog> Analysis_page(Document page_html, Integer microBlogNum) throws InterruptedException {
        Elements tbody = page_html.getElementsByTag("tbody");
        Elements trs = tbody.select("tr");
        List<MicroBlog> list=new ArrayList<MicroBlog>();
        for (int i = 9; i < microBlogNum; i++) {
            Elements tds = trs.get(i).select("td");
            String href = tds.get(1).select("a").attr("href");
            String title = tds.get(1).select("a").text();
            System.out.println("href--->"+href);
            if(href!=""&&"javascript:void(0);".equals(href)) {
                href= tds.get(1).select("a").attr("href_to");
            }if("javascript:void(0);".equals(href)){
                continue;
            }
            href ="https://s.weibo.com"+href;
            Document page = get_page(href);
            String string = page.getElementsByTag("img").get(0).attr("src");
            String text2 =tds.get(2).text();
            /*String number = tds.get(1).select("span").text();  175862人阅读*/
            String number ="";
            if(!page.select("div.total").isEmpty()){
                number= page.select("div.total").get(0).text();//阅读6.4亿 讨论176万
            }
            String inform = page.select("div.card.card-topic-lead.s-pg16").select("p").toString();
            list.add(new MicroBlog(i,title,inform.toString(),href,string,text2,number));
        }
        return list;
    }

    public static List<MicroBlog> getTopTen(Document page, int num) {
        Elements elementsByTag = page.getElementsByTag("tbody");
        Elements trs = elementsByTag.select("tr");
        List<MicroBlog> list=new ArrayList<MicroBlog>();
        for (int i = 0; i < num; i++) {
            Elements tds = trs.get(i).select("td");
            String title = tds.get(1).select("a").text();
            String href = tds.get(1).select("a").attr("href");
            if(href!=""&&"javascript:void(0);".equals(href)) {
                href= tds.get(1).select("a").attr("href_to");
            }
            href ="https://s.weibo.com"+href;
            String text2 =tds.get(2).text();
            list.add(new MicroBlog(i,title,href,text2));
        }
        System.out.println(list);
        return  list;
    }
}
