package com.ssafy.vue.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.model.BusDto;
import com.ssafy.vue.model.mapper.BusMapper;

@Service
public class BusServiceImpl implements BusService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BusDto> listBusStop() throws Exception {
		return sqlSession.getMapper(BusMapper.class).listBusStop();
	}

}