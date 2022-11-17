package com.ssafy.vue.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/traffic")
@Api("Traffic 컨트롤러  API V1")
public class TrafficController {

	private final Logger logger = LoggerFactory.getLogger(TrafficController.class);

	//@Autowired
	// private HouseMapService haHouseMapService;

	////////////////////////////// 카카오 모빌리티 길찾기 api
	@ApiOperation(value = "카카오 모빌리티 길찾기 api", notes = "출발지와 목적지를 기준으로 현재 교통상황을 알려준다.", response = List.class)
	@GetMapping(value = "/searchroad/{origin}/{destination}", produces = "application/json;charset=utf-8")
	public ResponseEntity<String> searchimg(@PathVariable("origin") String origin,@PathVariable("destination") String destination) throws IOException {
		String serviceKey = "7843aee4e80223a8f32fe3c8242e1036";
		StringBuilder urlBuilder = new StringBuilder("https://apis-navi.kakaomobility.com/v1/directions");
		urlBuilder
				.append("?" + URLEncoder.encode("origin", "UTF-8") + "=" + URLEncoder.encode(origin, "UTF-8")); /* 검색어 */
		urlBuilder.append(
				"&" + URLEncoder.encode("destination", "UTF-8") + "=" + URLEncoder.encode(destination, "UTF-8")); /* 계약월 */

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("Authorization", "KakaoAK " + serviceKey);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		//System.out.println(sb.toString());

		// JSONObject json = XML.toJSONObject(sb.toString());
		// String jsonStr = json.toString();

		return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
	}

}