package com.ssafy.vue.model.service;

import java.util.List;

import com.ssafy.util.PageNavigation;
import com.ssafy.vue.model.BoardDto;
import com.ssafy.vue.model.BoardParameterDto;
import com.ssafy.vue.model.WishDto;

public interface WishService {
	public boolean addWishList(WishDto wishDto) throws Exception;
	public List<WishDto> listWish() throws Exception;
	public List<WishDto> listWishId(String userid) throws Exception;
	public List<WishDto> chkExistWish(String wishname, String userid) throws Exception;
	public boolean deleteWishList(String wishname, String userid) throws Exception;
}
