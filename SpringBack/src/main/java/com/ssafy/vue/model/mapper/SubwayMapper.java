package com.ssafy.vue.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.SubwayDto;

@Mapper
public interface SubwayMapper {
	
	public List<SubwayDto> listSubwayInfo() throws SQLException;
	
}