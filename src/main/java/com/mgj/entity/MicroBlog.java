package com.mgj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mist on 2019/4/22.
 * 序号---->1
 * 微博标题-->知情人否认唐嫣怀孕
   微博导语--><p><strong>导语：</strong>知情人否认唐嫣怀孕猜测，称：“没有怀孕！真的没有啦！”。 ?</p>
   微博链接-->https://s.weibo.com/weibo?q=%23%E7%9F%A5%E6%83%85%E4%BA%BA%E5%90%A6%E8%AE%A4%E5%94%90%E5%AB%A3%E6%80%80%E5%AD%95%23&Refer=top
   图片链接-->//wx2.sinaimg.cn/large/61e7f4aaly1g2bei13xr7j206j06j76n.jpg
   微博热度---->新
   关注人数---->2242097
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MicroBlog {
    //微博标识id
    private Integer id;
    //微博标题
    private String title;
    //微博导语
    private String inform;
    //微博链接
    private String url;
    //微博图片
    private String img;
    //微博热度
    private String attention;
    //微博关注人数
    private String number;

    public MicroBlog(Integer id, String title, String url, String attention) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.attention = attention;
    }
}
