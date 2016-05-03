package com.ssq.dao;

import com.ssq.po.TotalBallPO;

public interface TotalBallDao {

	public TotalBallPO selectTotalBall(Integer id);
	
	public TotalBallPO insertTotalBall(TotalBallPO tbpo);
	
	public void deleteTotalBall();
	
	
}
