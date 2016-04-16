package com.ssq.po;

import java.util.Date;

public class TotalBallPO {

	private int id ;
	
	private Date opendate;
	
	private int red1;
	private int red2;
	private int red3;
	private int red4;
	private int red5;
	private int red6;
	private int blue;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOpendate() {
		return opendate;
	}
	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
	public int getRed1() {
		return red1;
	}
	public void setRed1(int red1) {
		this.red1 = red1;
	}
	public int getRed2() {
		return red2;
	}
	public void setRed2(int red2) {
		this.red2 = red2;
	}
	public int getRed3() {
		return red3;
	}
	public void setRed3(int red3) {
		this.red3 = red3;
	}
	public int getRed4() {
		return red4;
	}
	public void setRed4(int red4) {
		this.red4 = red4;
	}
	public int getRed5() {
		return red5;
	}
	public void setRed5(int red5) {
		this.red5 = red5;
	}
	public int getRed6() {
		return red6;
	}
	public void setRed6(int red6) {
		this.red6 = red6;
	}
	public int getBlue() {
		return blue;
	}
	public void setBlue(int blue) {
		this.blue = blue;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.opendate.toString()).append(":").append(this.red1).append(",").append(this.red2).append(",")
				.append(this.red3).append(",").append(this.red4).append(",").append(this.red5).append(",")
				.append(this.red6).append("|").append(this.blue);
		return sb.toString();
	}
	
	
	
}
