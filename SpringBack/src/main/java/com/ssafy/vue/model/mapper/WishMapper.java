package com.ssafy.vue.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.BoardDto;
import com.ssafy.vue.model.BoardParameterDto;
import com.ssafy.vue.model.WishDto;

@Mapper
public interface WishMapper {
	
	public int addWishList(WishDto wishDto) throws SQLException;
	public List<WishDto> listWish() throws SQLException;
	public List<WishDto> listWishId(String userid) throws SQLException;
	public List<WishDto> chkExistWish(String wishname, String userid) throws SQLException;
	public int deleteWishList(String wishname, String userid) throws SQLException;
	
}