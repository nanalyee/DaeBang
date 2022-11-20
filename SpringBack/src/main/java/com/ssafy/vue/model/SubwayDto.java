package com.ssafy.vue.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SubwayDto : 지하철정보", description = "대전 도시철도 1호선의 상세 정보를 나타낸다.")
public class SubwayDto {
	@ApiModelProperty(value = "역 코드")
	private String stationCode;
	@ApiModelProperty(value = "역 이름")
	private String stationName;
	@ApiModelProperty(value = "승강 시설")
	private String elevatorFac;
	@ApiModelProperty(value = "역 주소")
	private String stationAddr;
	@ApiModelProperty(value = "출입구")
	private String stationExit;
	@ApiModelProperty(value = "역 구조")
	private String stationStruct;
	@ApiModelProperty(value = "역 전화번호")
	private String stationTel;
	@ApiModelProperty(value = "역 면적")
	private String stationArea;
	@ApiModelProperty(value = "자전거보관소")
	private String bikeStorageYn;
	@ApiModelProperty(value = "E/V 유무")
	private String elevatorYn;
	@ApiModelProperty(value = "수유실 유무")
	private String lactationRoomYn;
	@ApiModelProperty(value = "유실물센터")
	private String lostPropertyCenterYn;
	@ApiModelProperty(value = "휠체어 충전")
	private String wheelchairChargingYn;
	@ApiModelProperty(value = "물품보관실")
	private String supplyRoomYn;
	
	public SubwayDto() {}
	
	public SubwayDto(String stationCode, String stationName, String elevatorFac, String stationAddr, String stationExit,
			String stationStruct, String stationTel, String stationArea, String bikeStorageYn, String elevatorYn,
			String lactationRoomYn, String lostPropertyCenterYn, String wheelchairChargingYn, String supplyRoomYn) {
		this.stationCode = stationCode;
		this.stationName = stationName;
		this.elevatorFac = elevatorFac;
		this.stationAddr = stationAddr;
		this.stationExit = stationExit;
		this.stationStruct = stationStruct;
		this.stationTel = stationTel;
		this.stationArea = stationArea;
		this.bikeStorageYn = bikeStorageYn;
		this.elevatorYn = elevatorYn;
		this.lactationRoomYn = lactationRoomYn;
		this.lostPropertyCenterYn = lostPropertyCenterYn;
		this.wheelchairChargingYn = wheelchairChargingYn;
		this.supplyRoomYn = supplyRoomYn;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getElevatorFac() {
		return elevatorFac;
	}

	public void setElevatorFac(String elevatorFac) {
		this.elevatorFac = elevatorFac;
	}

	public String getStationAddr() {
		return stationAddr;
	}

	public void setStationAddr(String stationAddr) {
		this.stationAddr = stationAddr;
	}

	public String getStationExit() {
		return stationExit;
	}

	public void setStationExit(String stationExit) {
		this.stationExit = stationExit;
	}

	public String getStationStruct() {
		return stationStruct;
	}

	public void setStationStruct(String stationStruct) {
		this.stationStruct = stationStruct;
	}

	public String getStationTel() {
		return stationTel;
	}

	public void setStationTel(String stationTel) {
		this.stationTel = stationTel;
	}

	public String getStationArea() {
		return stationArea;
	}

	public void setStationArea(String stationArea) {
		this.stationArea = stationArea;
	}

	public String getBikeStorageYn() {
		return bikeStorageYn;
	}

	public void setBikeStorageYn(String bikeStorageYn) {
		this.bikeStorageYn = bikeStorageYn;
	}

	public String getElevatorYn() {
		return elevatorYn;
	}

	public void setElevatorYn(String elevatorYn) {
		this.elevatorYn = elevatorYn;
	}

	public String getLactationRoomYn() {
		return lactationRoomYn;
	}

	public void setLactationRoomYn(String lactationRoomYn) {
		this.lactationRoomYn = lactationRoomYn;
	}

	public String getLostPropertyCenterYn() {
		return lostPropertyCenterYn;
	}

	public void setLostPropertyCenterYn(String lostPropertyCenterYn) {
		this.lostPropertyCenterYn = lostPropertyCenterYn;
	}

	public String getWheelchairChargingYn() {
		return wheelchairChargingYn;
	}

	public void setWheelchairChargingYn(String wheelchairChargingYn) {
		this.wheelchairChargingYn = wheelchairChargingYn;
	}

	public String getSupplyRoomYn() {
		return supplyRoomYn;
	}

	public void setSupplyRoomYn(String supplyRoomYn) {
		this.supplyRoomYn = supplyRoomYn;
	}

	@Override
	public String toString() {
		return "SubwayDto [stationCode=" + stationCode + ", stationName=" + stationName + ", elevatorFac=" + elevatorFac
				+ ", stationAddr=" + stationAddr + ", stationExit=" + stationExit + ", stationStruct=" + stationStruct
				+ ", stationTel=" + stationTel + ", stationArea=" + stationArea + ", bikeStorageYn=" + bikeStorageYn
				+ ", elevatorYn=" + elevatorYn + ", lactationRoomYn=" + lactationRoomYn + ", lostPropertyCenterYn="
				+ lostPropertyCenterYn + ", wheelchairChargingYn=" + wheelchairChargingYn + ", supplyRoomYn="
				+ supplyRoomYn + "]";
	}

	
	
}