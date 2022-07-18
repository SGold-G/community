package com.community.service;

import com.community.dao.DiscussPostMapper;
import com.community.dao.UserMapper;
import com.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    //查找评论集合
    public List<DiscussPost> getDiscussPosts(int userId, int offset, int limit){
        List<DiscussPost> list = discussPostMapper.getDiscussByUid(userId,offset,limit);
        return list;
    }
    //查找评论总数
    public int getDiscussCount(int userId){
        return discussPostMapper.getDiscussCount(userId);
    }
}
