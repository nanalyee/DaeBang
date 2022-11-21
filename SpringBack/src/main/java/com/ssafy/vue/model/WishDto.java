package com.ssafy.vue.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WishDto : 관심지역정보", description = "관심지역 정보를 나타낸다.")
public class WishDto {
	@ApiModelProperty(value = "관심지역번호")
	private int wishno;
	@ApiModelProperty(value = "이름")
	private String wishname;
	@ApiModelProperty(value = "타입")
	private String wishtype;
	@ApiModelProperty(value = "구군")
	private String gugunname;
	@ApiModelProperty(value = "법정동")
	private String dongname;
	@ApiModelProperty(value = "위도")
	private String lat;
	@ApiModelProperty(value = "경도")
	private String lng;
	@ApiModelProperty(value = "등록한 유저 id")
	private String userid;
	@ApiModelProperty(value = "TIME")
	private String joindate;

	public WishDto() {
	}

	public WishDto(int wishno, String wishname, String wishtype, String gugunname, String dongname, String lat,
			String lng, String userid, String joindate) {
		this.wishno = wishno;
		this.wishname = wishname;
		this.wishtype = wishtype;
		this.gugunname = gugunname;
		this.dongname = dongname;
		this.lat = lat;
		this.lng = lng;
		this.userid = userid;
		this.joindate = joindate;
	}

	public int getWishno() {
		return wishno;
	}

	public void setWishno(int wishno) {
		this.wishno = wishno;
	}

	public String getWishname() {
		return wishname;
	}

	public void setWishname(String wishname) {
		this.wishname = wishname;
	}

	public String getWishtype() {
		return wishtype;
	}

	public void setWishtype(String wishtype) {
		this.wishtype = wishtype;
	}

	public String getGugunname() {
		return gugunname;
	}

	public void setGugunname(String gugunname) {
		this.gugunname = gugunname;
	}

	public String getDongname() {
		return dongname;
	}

	public void setDongname(String dongname) {
		this.dongname = dongname;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "WishDto [wishno=" + wishno + ", wishname=" + wishname + ", wishtype=" + wishtype + ", gugunname="
				+ gugunname + ", dongname=" + dongname + ", lat=" + lat + ", lng=" + lng + ", userid=" + userid
				+ ", joindate=" + joindate + "]";
	}

}