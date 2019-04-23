package com.mgj.service;

import com.mgj.dao.MicroBlogDao;
import com.mgj.entity.MicroBlog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mist on 2019/4/22.
 */
@Slf4j
@Service
public class MicroBlogService {
    @Autowired
    private MicroBlogDao microBlogDao;

    /**
     * 保存数据到数据库
     * @param list
     * @return
     */
    public boolean insertTo(List<MicroBlog> list) {
        if(list==null){
            return false;
        }
        List<String> hasList =microBlogDao.queryAllMicroBlogTitle();
        List<MicroBlog> deleteList=new ArrayList<MicroBlog>();
        for (MicroBlog no : list) {
            for (String has : hasList){
                if(no.getTitle().equals(has)){
                    deleteList.add(no);
                    continue;
                }
            }
        }
        if(deleteList!=null){
            list.removeAll(deleteList);
        }
        boolean bool=true;
        int flag = microBlogDao.insertTo(list);
        if(flag<=0){
            bool=false;
        }
        return bool;
    }

    public List<MicroBlog> getMicroBlog() {
        return microBlogDao.getMicroBlog();
    }
}
