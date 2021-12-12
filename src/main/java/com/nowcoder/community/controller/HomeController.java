package com.nowcoder.community.controller;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Page;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
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
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;
    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        page.setRows(discussPostService.findDiscussPostCount(0));
        page.setPath("/index");
        List<DiscussPost> list = discussPostService.findDiscussPosts(0,page.getOffset(), page.getLimit());
        List<Map<String,Object>> discussposts = new ArrayList<>();
        for(DiscussPost posts : list){
            Map<String,Object> map = new HashMap<>();
            map.put("post",posts);
            User user = userService.findUserById(posts.getUserId());
            map.put("user",user);
            discussposts.add(map);
        }
        model.addAttribute("discuss",discussposts);
        return "index";
    }

}
