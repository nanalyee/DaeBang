package com.ssafy.vue.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.BusDto;

@Mapper
public interface BusMapper {
	
	public List<BusDto> listBusStop() throws SQLException;
	
}