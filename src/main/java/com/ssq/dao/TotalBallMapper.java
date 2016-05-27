package com.ssq.dao;

import com.ssq.po.TotalBall;

public interface TotalBallMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TotalBall record);

    int insertSelective(TotalBall record);

    TotalBall selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TotalBall record);

    int updateByPrimaryKey(TotalBall record);
}