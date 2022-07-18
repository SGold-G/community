package com.community.dao;

import com.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> getDiscussByUid(int userId,int offset,int limit);
    //@Param注解用于给参数设置别名
    //如果只有一个参数，并且在if中使用则必须使用别用
    int getDiscussCount(@Param("userId") int userId);

}
