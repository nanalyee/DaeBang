package com.ssafy.vue.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BusDto : 버스정류소정보", description = "버스정류소의 상세 정보를 나타낸다.")
public class BusDto {
	@ApiModelProperty(value = "정류소ID")
	private int stop_id;
	@ApiModelProperty(value = "정류소이름")
	private int stop_name;
	
	public BusDto() {}
	public BusDto(int stop_id, int stop_name) {
		this.stop_id = stop_id;
		this.stop_name = stop_name;
	}
	public int getStop_id() {
		return stop_id;
	}
	public void setStop_id(int stop_id) {
		this.stop_id = stop_id;
	}
	public int getStop_name() {
		return stop_name;
	}
	public void setStop_name(int stop_name) {
		this.stop_name = stop_name;
	}
	
	@Override
	public String toString() {
		return "BusDto [stop_id=" + stop_id + ", stop_name=" + stop_name + "]";
	}

	

	
}