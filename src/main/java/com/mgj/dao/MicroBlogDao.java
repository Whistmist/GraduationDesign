package com.mgj.dao;

import com.mgj.entity.MicroBlog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by mist on 2019/4/22.
 */
@Mapper
public interface MicroBlogDao {

    int insertTo(List<MicroBlog> list);

    List<MicroBlog> getMicroBlog();
}
