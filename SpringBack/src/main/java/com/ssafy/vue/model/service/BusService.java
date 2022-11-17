package com.ssafy.vue.model.service;

import java.util.List;

import com.ssafy.vue.model.BusDto;

public interface BusService {
	public List<BusDto> listBusStop() throws Exception;

}
