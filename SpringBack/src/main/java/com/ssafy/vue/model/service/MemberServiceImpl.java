package com.ssafy.vue.model.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.model.BoardDto;
import com.ssafy.vue.model.MemberDto;
import com.ssafy.vue.model.mapper.BoardMapper;
import com.ssafy.vue.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		if (memberDto.getUserid() == null || memberDto.getUserpwd() == null)
			return null;
		return sqlSession.getMapper(MemberMapper.class).login(memberDto);
	}

	@Override
	public MemberDto userInfo(String userid) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).userInfo(userid);
	}

	@Override
	public void saveRefreshToken(String userid, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", refreshToken);
		sqlSession.getMapper(MemberMapper.class).saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userid) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).getRefreshToken(userid);
	}

	@Override
	public void deleRefreshToken(String userid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", null);
		sqlSession.getMapper(MemberMapper.class).deleteRefreshToken(map);
	}
	
	@Override
	public boolean regist(MemberDto memberDto) throws Exception {
		if(memberDto.getUserid() == null || memberDto.getUsername() == null || memberDto.getUserpwd()==null || memberDto.getEmail()==null) {
			throw new Exception();
		}
		return sqlSession.getMapper(MemberMapper.class).regist(memberDto) == 1;
	}

	@Override
	@Transactional
	public boolean modify(MemberDto memberDto) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).modify(memberDto) == 1;
	}
	
	@Override
	@Transactional
	public boolean delete(String userid) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).delete(userid) == 1;
	}
}
