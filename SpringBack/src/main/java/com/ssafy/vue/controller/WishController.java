package com.ssafy.vue.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.LinkedList;
import java.util.List;

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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.model.WishDto;
import com.ssafy.vue.model.service.WishService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/wish")
@Api("Wish 컨트롤러  API V1")
public class WishController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private WishService wishService;

	@ApiOperation(value = "관심지역 추가", notes = "관심지역을 추가한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> addWishList(
			@RequestBody @ApiParam(value = "관심지역 정보.", required = true) WishDto wishDto) throws Exception {
		logger.info("addWishList - 호출");
		if (wishService.addWishList(wishDto)) {
			System.out.println(wishDto.toString());
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "관심지역 목록", notes = "모든 관심지역 정보를 반환한다.", response = List.class)
	@GetMapping(value = "/listwish", produces = "application/json;charset=utf-8")
	public ResponseEntity<List<WishDto>> listWish() throws Exception {
		logger.info("listBusStop - 호출");
		List<WishDto> list = new LinkedList<WishDto>();
		list = wishService.listWish();

		System.out.println(list.size());
		return new ResponseEntity<List<WishDto>>(wishService.listWish(), HttpStatus.OK);
	}

	@ApiOperation(value = "유저 아이디에 맞는 관심지역 목록", notes = "유저 아이디에 맞는 관심지역 정보를 반환한다.", response = List.class)
	@GetMapping(value = "/listwishid/{userid}", produces = "application/json;charset=utf-8")
	public ResponseEntity<List<WishDto>> listWishId(@PathVariable("userid") String userid) throws Exception {
		logger.info("listWishId - 호출");
		List<WishDto> list = new LinkedList<WishDto>();
		list = wishService.listWishId(userid);

		System.out.println(list.size());
		return new ResponseEntity<List<WishDto>>(wishService.listWishId(userid), HttpStatus.OK);
	}

	@ApiOperation(value = "이미 등록된 지역인지 체크", notes = "이미 등록된 지역인지 체크하는 정보를 반환한다.", response = List.class)
	@GetMapping(value = "/chkexistwish/{wishname}/{userid}", produces = "application/json;charset=utf-8")
	public ResponseEntity<String> chkExistWish(@PathVariable("wishname") String wishname,
			@PathVariable("userid") String userid) throws Exception {
		logger.info("chkExistWish - 호출");
		List<WishDto> list = new LinkedList<WishDto>();
		list = wishService.chkExistWish(wishname, userid);

		System.out.println(list.size());
		if (list.size() >= 1) {
			// 중복값 있으면 SUCCESS 반환
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "관심지역 삭제", notes = "유저 아이디와 지역 제목이 같은 데이터를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{wishname}/{userid}")
	public ResponseEntity<String> deleteWishList(
			@PathVariable("wishname") @ApiParam(value = "삭제할 글의 글번호.", required = true) String wishname,
			@PathVariable("userid") @ApiParam(value = "유저 이름", required = true) String userid) throws Exception {
		logger.info("deleteWishList - 호출");
		System.out.println(wishname);
		System.out.println(userid);
		if (wishService.deleteWishList(wishname, userid)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	// 문화관광 전체 정보 API
	@ApiOperation(value = "관광지 정보", notes = "관광지 정보를 반환한다.", response = List.class)
	@GetMapping(value = "/gettd", produces = "application/json;charset=utf-8")
	public ResponseEntity<String> gettd() throws IOException {
		String serviceKey = "U3x%2FhookUVc%2BS%2FYDXR0orCt70jponbqHM%2BfioZ%2BHxGIqJV3t4Na4cnAKAEZp6%2Fa%2FE01V9A5lx35maqZDKxcccw%3D%3D";
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/6300000/tourDataService/tourDataListJson"); /*
																															 */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey); /* 지역코드 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("127", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
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

//			JSONObject json = XML.toJSONObject(sb.toString());
//			String jsonStr = json.toString();

		return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
	}

	// 문화관광 상세 정보 API
	@ApiOperation(value = "관광지 상세 정보", notes = "관광지 상세 정보를 반환한다.", response = List.class)
	@GetMapping(value = "/gettddetail/{tourSeq}", produces = "application/json;charset=utf-8")
	public ResponseEntity<String> gettddetail(@PathVariable("tourSeq") String tourSeq) throws IOException {
		String serviceKey = "U3x%2FhookUVc%2BS%2FYDXR0orCt70jponbqHM%2BfioZ%2BHxGIqJV3t4Na4cnAKAEZp6%2Fa%2FE01V9A5lx35maqZDKxcccw%3D%3D";
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/6300000/tourDataService/tourDataItemJson"); /*
																															 */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey); /* 지역코드 */
		urlBuilder.append("&" + URLEncoder.encode("tourSeq", "UTF-8") + "=" + URLEncoder.encode(tourSeq, "UTF-8"));
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
		return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
	}

	// 날씨 상세 정보 API
	// https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst?serviceKey=U3x%2FhookUVc%2BS%2FYDXR0orCt70jponbqHM%2BfioZ%2BHxGIqJV3t4Na4cnAKAEZp6%2Fa%2FE01V9A5lx35maqZDKxcccw%3D%3D&pageNo=1&numOfRows=200&dataType=XML&base_date=20221120&base_time=1700&nx=55&ny=127
	@ApiOperation(value = "날씨 상세 정보", notes = "날씨 상세 정보를 반환한다.", response = List.class)
	@GetMapping(value = "/getweather/{basedate}/{basetime}/{nx}/{ny}", produces = "application/json;charset=utf-8")
	public ResponseEntity<String> getweather(@PathVariable("basedate") String basedate,
			@PathVariable("basetime") String basetime, @PathVariable("nx") String nx, @PathVariable("ny") String ny)
			throws IOException, NoSuchAlgorithmException, KeyManagementException {
		// ============= 인증서 허용 코드 =================
		TrustManager[] trustAllCerts = new TrustManager[] { (TrustManager) new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };

		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		// ============= /인증서 허용 코드 =================

		String serviceKey = "U3x%2FhookUVc%2BS%2FYDXR0orCt70jponbqHM%2BfioZ%2BHxGIqJV3t4Na4cnAKAEZp6%2Fa%2FE01V9A5lx35maqZDKxcccw%3D%3D";

		StringBuilder urlBuilder = new StringBuilder(
				"https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"); /*
																													 */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey); /* 지역코드 */
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("200", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "=" + URLEncoder.encode(basedate, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "=" + URLEncoder.encode(basetime, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("nx", "UTF-8") + "=" + URLEncoder.encode(nx, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("ny", "UTF-8") + "=" + URLEncoder.encode(ny, "UTF-8"));
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

	// 카카오 카테고리로 장소 검색하기   api "https://developers.kakao.com/docs/latest/ko/local/dev-guide"
	@ApiOperation(value = "카카오 카테고리로 장소 검색하기 api", notes = "위도,경도,반지름, 카테고리를 기준으로 해당 카테고리가 있는지 검색한다.", response = List.class)
	@GetMapping(value = "/searchcategory/{x}/{y}/{category}/{radius}", produces = "application/json;charset=utf-8")
	public ResponseEntity<String> searchimg(@PathVariable("x") String x,
			@PathVariable("y") String y,@PathVariable("category") String category ,@PathVariable("radius") String radius) throws IOException {
		String serviceKey = "7843aee4e80223a8f32fe3c8242e1036";
		StringBuilder urlBuilder = new StringBuilder("https://dapi.kakao.com/v2/local/search/category.json");
		urlBuilder.append(
				"?" + URLEncoder.encode("x", "UTF-8") + "=" + URLEncoder.encode(x, "UTF-8")); 
		urlBuilder.append("&" + URLEncoder.encode("y", "UTF-8") + "="
				+ URLEncoder.encode(y, "UTF-8")); 
		urlBuilder.append("&" + URLEncoder.encode("category_group_code", "UTF-8") + "="
				+ URLEncoder.encode(category, "UTF-8")); 
		urlBuilder.append("&" + URLEncoder.encode("radius", "UTF-8") + "="
				+ URLEncoder.encode(radius, "UTF-8")); 

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
		System.out.println(sb.toString());
		
		// JSONObject json = XML.toJSONObject(sb.toString());
		// String jsonStr = json.toString();

		return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
	}

}
