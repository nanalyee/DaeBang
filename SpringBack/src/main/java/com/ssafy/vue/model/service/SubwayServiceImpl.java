package com.ssafy.vue.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.model.SubwayDto;
import com.ssafy.vue.model.mapper.SubwayMapper;

@Service
public class SubwayServiceImpl implements SubwayService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<SubwayDto> listSubwayInfo() throws Exception {
		return sqlSession.getMapper(SubwayMapper.class).listSubwayInfo();
	}

}