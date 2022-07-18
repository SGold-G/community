package com.community.controller;

import com.community.dao.UserMapper;
import com.community.entity.DiscussPost;
import com.community.entity.Page;
import com.community.entity.User;
import com.community.service.DiscussPostService;
import com.community.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String IndexPage(Model model, Page page){
        page.setRows(discussPostService.getDiscussCount(0));
        page.setPath("/index");


        List<DiscussPost> list = discussPostService.getDiscussPosts(0,page.getOffset(),page.getLimit());
        List<Map<String,Object>> discussPostLists = new ArrayList<>();
        for (DiscussPost post: list){
            Map<String,Object> map = new HashMap<>();
            map.put("post",post);
            User user = userService.selectById(post.getUserId());
            map.put("user",user);
            discussPostLists.add(map);
        }
        model.addAttribute("discussPostLists",discussPostLists);
        return "/index";
    }
}
