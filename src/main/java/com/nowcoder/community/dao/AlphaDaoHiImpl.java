package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AlphaDaoHiImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hi";
    }
}
