package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface DiscussMapper {
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);
    int selectDiscussPostCount(@Param("userId")int userId);
}
