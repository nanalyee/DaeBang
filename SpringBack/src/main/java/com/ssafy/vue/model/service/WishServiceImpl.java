package com.ssafy.vue.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.model.WishDto;
import com.ssafy.vue.model.mapper.WishMapper;

@Service
public class WishServiceImpl implements WishService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public boolean addWishList(WishDto wishDto) throws Exception {
		if (wishDto.getUserid() == null || wishDto.getWishname() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(WishMapper.class).addWishList(wishDto) == 1;
	}

	@Override
	public List<WishDto> listWish() throws Exception {
		return sqlSession.getMapper(WishMapper.class).listWish();

	}

	@Override
	public List<WishDto> listWishId(String userid) throws Exception {
		return sqlSession.getMapper(WishMapper.class).listWishId(userid);

	}
	
	@Override
	public List<WishDto> chkExistWish(String wishname, String userid) throws Exception {
		return sqlSession.getMapper(WishMapper.class).chkExistWish(wishname, userid);

	}
	@Override
	public boolean deleteWishList(String wishname, String userid) throws Exception {
		return sqlSession.getMapper(WishMapper.class).deleteWishList(wishname, userid) == 1;
	}

}