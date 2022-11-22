package com.ssafy.vue.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.model.BusDto;
import com.ssafy.vue.model.SubwayDto;
import com.ssafy.vue.model.service.BusService;
import com.ssafy.vue.model.service.SubwayService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/traffic")
@Api("Traffic 컨트롤러  API V1")
public class TrafficController {

	private final Logger logger = LoggerFactory.getLogger(TrafficController.class);

	@Autowired
	private BusService busService;

	@Autowired
	private SubwayService subwayService;

	// 카카오 모빌리티 길찾기 api
	@ApiOperation(value = "카카오 모빌리티 길찾기 api", notes = "출발지와 목적지를 기준으로 현재 교통상황을 알려준다.", response = List.class)
	@GetMapping(value = "/searchroad/{origin}/{destination}", produces = "application/json;charset=utf-8")
	public ResponseEntity<String> searchimg(@PathVariable("origin") String origin,
			@PathVariable("destination") String destination) throws IOException {
		String serviceKey = "7843aee4e80223a8f32fe3c8242e1036";
		StringBuilder urlBuilder = new StringBuilder("https://apis-navi.kakaomobility.com/v1/directions");
		urlBuilder.append(
				"?" + URLEncoder.encode("origin", "UTF-8") + "=" + URLEncoder.encode(origin, "UTF-8")); /* 검색어 */
		urlBuilder.append("&" + URLEncoder.encode("destination", "UTF-8") + "="
				+ URLEncoder.encode(destination, "UTF-8")); /* 계약월 */

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
		// System.out.println(sb.toString());

		// JSONObject json = XML.toJSONObject(sb.toString());
		// String jsonStr = json.toString();

		return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
	}

	@ApiOperation(value = "버스정류소 목록", notes = "모든 버스정류소의 정보를 반환한다.", response = List.class)
	@GetMapping(value = "/getbusstop", produces = "application/json;charset=utf-8")
	public ResponseEntity<List<BusDto>> listBusStop() throws Exception {
		logger.info("listBusStop - 호출");
		List<BusDto> list = new LinkedList<BusDto>();
		list = busService.listBusStop();

		System.out.println(list.size());
		return new ResponseEntity<List<BusDto>>(busService.listBusStop(), HttpStatus.OK);
	}

	// 버스 상세 정보 ///////////////////////////////////////////////
	@ApiOperation(value = "버스 상세 정보", notes = "정류소 ID를 기준으로 버스 상세정보를 반환한다.", response = List.class)
	@GetMapping(value = "/getbusinfo/{stop_id}", produces = "application/json;charset=utf-8")
	public ResponseEntity<String> getbusinfo(@PathVariable("stop_id") String stopid) throws IOException {
		String serviceKey = "U3x%2FhookUVc%2BS%2FYDXR0orCt70jponbqHM%2BfioZ%2BHxGIqJV3t4Na4cnAKAEZp6%2Fa%2FE01V9A5lx35maqZDKxcccw%3D%3D";
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapitraffic.daejeon.go.kr/api/rest/arrive/getArrInfoByStopID"); /*
																															 */
		urlBuilder.append(
				"?" + URLEncoder.encode("busStopID", "UTF-8") + "=" + URLEncoder.encode(stopid, "UTF-8")); /* 지역코드 */
		urlBuilder.append("&" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
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
		// System.out.println(sb.toString());

		JSONObject json = XML.toJSONObject(sb.toString());
		String jsonStr = json.toString();

		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}

	@ApiOperation(value = "지하철정보 목록", notes = "대전광역시 모든 지하철의 정보를 반환한다.", response = List.class)
	@GetMapping(value = "/getsubway", produces = "application/json;charset=utf-8")
	public ResponseEntity<List<SubwayDto>> getsubway() throws Exception {
		logger.info("listSubway - 호출");
		List<SubwayDto> list = new LinkedList<SubwayDto>();
		list = subwayService.listSubwayInfo();

		System.out.println(list.size());
		return new ResponseEntity<List<SubwayDto>>(subwayService.listSubwayInfo(), HttpStatus.OK);
	}

	// 타슈 실시간 대여소 현황 api
	@ApiOperation(value = "타슈 실시간 대여소 현황 api", notes = "대전 공영 자전거 타슈의 정보를 알려준다.", response = List.class)
	@GetMapping(value = "/tashu", produces = "application/json;charset=utf-8")
	public ResponseEntity<String> tashu() throws IOException {
		String serviceKey = "f060sw160bkatnz2";
		StringBuilder urlBuilder = new StringBuilder("https://bikeapp.tashu.or.kr:50041/v1/openapi/station");

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("api-token", serviceKey);
		conn.setRequestProperty("Accept", "*/*");
		conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		conn.setRequestProperty("Connection", "keep-alive");
		conn.setRequestMethod("GET");
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
