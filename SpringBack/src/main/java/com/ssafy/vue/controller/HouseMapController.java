package com.ssafy.vue.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.model.HouseInfoDto;
import com.ssafy.vue.model.SidoGugunCodeDto;
import com.ssafy.vue.model.service.HouseMapService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/map")
@Api("Map 컨트롤러  API V1")
public class HouseMapController {

	private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);

	@Autowired
	private HouseMapService haHouseMapService;

	@ApiOperation(value = "시도 정보", notes = "전국의 시도를 반환한다.", response = List.class)
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception {
		logger.info("sido - 호출");
		return new ResponseEntity<List<SidoGugunCodeDto>>(haHouseMapService.getSido(), HttpStatus.OK);
	}

	@ApiOperation(value = "구군 정보", notes = "전국의 구군을 반환한다.", response = List.class)
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> gugun(
			@RequestParam("sido") @ApiParam(value = "시도코드.", required = true) String sido) throws Exception {
		logger.info("gugun - 호출");
		return new ResponseEntity<List<SidoGugunCodeDto>>(haHouseMapService.getGugunInSido(sido), HttpStatus.OK);
	}

	@ApiOperation(value = "아파트 목록", notes = "지역코드와 매매계약월을 기준으로 아파트 목록을 반환한다.", response = List.class)
	@GetMapping(value = "/searchApt/{lawd_cd}/{deal_ymd}", produces = "application/json;charset=utf-8")
	public ResponseEntity<String> searchApt(@PathVariable("lawd_cd") String lawdCd,
			@PathVariable("deal_ymd") String dealYmd) throws IOException {
		logger.info("sido - 호출");
		String serviceKey = "U3x%2FhookUVc%2BS%2FYDXR0orCt70jponbqHM%2BfioZ%2BHxGIqJV3t4Na4cnAKAEZp6%2Fa%2FE01V9A5lx35maqZDKxcccw%3D%3D";
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptRent");
		urlBuilder.append(
				"?" + URLEncoder.encode("LAWD_CD", "UTF-8") + "=" + URLEncoder.encode(lawdCd, "UTF-8")); /* 지역코드 */
		urlBuilder.append(
				"&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "=" + URLEncoder.encode(dealYmd, "UTF-8")); /* 계약월 */
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
		//System.out.println(sb.toString());

		JSONObject json = XML.toJSONObject(sb.toString());
		String jsonStr = json.toString();

		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}

	// 오피스텔 ///////////////////////////////////////////////
	// http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcOffiRent?LAWD_CD=11110&DEAL_YMD=201512&serviceKey=서비스키
	@ApiOperation(value = "오피스텔 목록", notes = "지역코드와 매매계약월을 기준으로 오피스텔 목록을 반환한다.", response = List.class)
	@GetMapping(value = "/searchOffice/{lawd_cd}/{deal_ymd}", produces = "application/json;charset=utf-8")
	public ResponseEntity<String> searchOffice(@PathVariable("lawd_cd") String lawdCd,
			@PathVariable("deal_ymd") String dealYmd) throws IOException {
		logger.info("sido - 호출");
		String serviceKey = "U3x%2FhookUVc%2BS%2FYDXR0orCt70jponbqHM%2BfioZ%2BHxGIqJV3t4Na4cnAKAEZp6%2Fa%2FE01V9A5lx35maqZDKxcccw%3D%3D";
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcOffiRent"); /*
																															 */
		urlBuilder.append(
				"?" + URLEncoder.encode("LAWD_CD", "UTF-8") + "=" + URLEncoder.encode(lawdCd, "UTF-8")); /* 지역코드 */
		urlBuilder.append(
				"&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "=" + URLEncoder.encode(dealYmd, "UTF-8")); /* 계약월 */
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
		//System.out.println(sb.toString());

		JSONObject json = XML.toJSONObject(sb.toString());
		String jsonStr = json.toString();

		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}

	// 원룸 ///////////////////////////////////////////////
	// http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcOffiRent?LAWD_CD=11110&DEAL_YMD=201512&serviceKey=서비스키
	@ApiOperation(value = "원룸 목록", notes = "지역코드와 매매계약월을 기준으로 원룸 목록을 반환한다.", response = List.class)
	@GetMapping(value = "/searchRoom/{lawd_cd}/{deal_ymd}", produces = "application/json;charset=utf-8")
	public ResponseEntity<String> searchRoom(@PathVariable("lawd_cd") String lawdCd,
			@PathVariable("deal_ymd") String dealYmd) throws IOException {
		logger.info("sido - 호출");
		String serviceKey = "U3x%2FhookUVc%2BS%2FYDXR0orCt70jponbqHM%2BfioZ%2BHxGIqJV3t4Na4cnAKAEZp6%2Fa%2FE01V9A5lx35maqZDKxcccw%3D%3D";
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcSHRent"); /*
																															 */
		urlBuilder.append(
				"?" + URLEncoder.encode("LAWD_CD", "UTF-8") + "=" + URLEncoder.encode(lawdCd, "UTF-8")); /* 지역코드 */
		urlBuilder.append(
				"&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "=" + URLEncoder.encode(dealYmd, "UTF-8")); /* 계약월 */
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
		//System.out.println(sb.toString());

		JSONObject json = XML.toJSONObject(sb.toString());
		String jsonStr = json.toString();

		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}

	// 다세대주택 ///////////////////////////////////////////////
	// http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcOffiRent?LAWD_CD=11110&DEAL_YMD=201512&serviceKey=서비스키
	@ApiOperation(value = "맨션 목록", notes = "지역코드와 매매계약월을 기준으로 맨션 목록을 반환한다.", response = List.class)
	@GetMapping(value = "/searchMansion/{lawd_cd}/{deal_ymd}", produces = "application/json;charset=utf-8")
	public ResponseEntity<String> searchMansion(@PathVariable("lawd_cd") String lawdCd,
			@PathVariable("deal_ymd") String dealYmd) throws IOException {
		logger.info("sido - 호출");
		String serviceKey = "U3x%2FhookUVc%2BS%2FYDXR0orCt70jponbqHM%2BfioZ%2BHxGIqJV3t4Na4cnAKAEZp6%2Fa%2FE01V9A5lx35maqZDKxcccw%3D%3D";
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcRHRent"); /*
																															 */
		urlBuilder.append(
				"?" + URLEncoder.encode("LAWD_CD", "UTF-8") + "=" + URLEncoder.encode(lawdCd, "UTF-8")); /* 지역코드 */
		urlBuilder.append(
				"&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "=" + URLEncoder.encode(dealYmd, "UTF-8")); /* 계약월 */
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
		//System.out.println(sb.toString());

		JSONObject json = XML.toJSONObject(sb.toString());
		String jsonStr = json.toString();

		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}
	
	// 카카오 이미지 api  ///////////////////////////////////////////////
	// http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcOffiRent?LAWD_CD=11110&DEAL_YMD=201512&serviceKey=서비스키
	@ApiOperation(value = "카카오 이미지 검색", notes = "제목을 기준으로 카카오 이미지 검색을 한다.", response = List.class)
	@GetMapping(value = "/searchimg/{title}", produces = "application/json;charset=utf-8")
	public ResponseEntity<String> searchimg(@PathVariable("title") String title) throws IOException {
		System.out.println(title);
		String serviceKey = "7843aee4e80223a8f32fe3c8242e1036";
		StringBuilder urlBuilder = new StringBuilder(
				"https://dapi.kakao.com/v2/search/image"); 
		urlBuilder.append(
				"?" + URLEncoder.encode("query", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8")); /* 검색어 */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("Authorization", "KakaoAK "+ serviceKey);
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

		//JSONObject json = XML.toJSONObject(sb.toString());
		//String jsonStr = json.toString();

		return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
	}
	
	
	// 상권 정보 api  ///////////////////////////////////////////////
	@ApiOperation(value = "상권 목록", notes = "위도,경도,대분류코드를 이용하여 상권 목록을 반환한다.", response = List.class)
    @GetMapping(value = "/store/{cx}/{cy}/{indsLclsCd}", produces = "application/json;charset=utf-8")
    public ResponseEntity<String> store(@PathVariable("cx") String cx,
            @PathVariable("cy") String cy, @PathVariable("indsLclsCd") String indsLclsCd) throws IOException {
        String serviceKey = "U3x%2FhookUVc%2BS%2FYDXR0orCt70jponbqHM%2BfioZ%2BHxGIqJV3t4Na4cnAKAEZp6%2Fa%2FE01V9A5lx35maqZDKxcccw%3D%3D";
        StringBuilder urlBuilder = new StringBuilder(
                "http://apis.data.go.kr/B553077/api/open/sdsc2/storeListInRadius");
         urlBuilder.append("?" + URLEncoder.encode("radius","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8"));
            //경도
            urlBuilder.append("&" + URLEncoder.encode("cx","UTF-8") + "=" + URLEncoder.encode(cx, "UTF-8")); 
            //위도
            urlBuilder.append("&" + URLEncoder.encode("cy","UTF-8") + "=" + URLEncoder.encode(cy, "UTF-8")); 
            //상권업종대분류코드
            urlBuilder.append("&" + URLEncoder.encode("indsLclsCd","UTF-8") + "=" + URLEncoder.encode(indsLclsCd, "UTF-8"));
            //페이지당건수
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8"));
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
        //System.out.println(sb.toString());

        JSONObject json = XML.toJSONObject(sb.toString());
        String jsonStr = json.toString();

        return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
    }

}
