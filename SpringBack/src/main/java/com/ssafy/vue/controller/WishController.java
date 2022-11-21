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
@RequestMapping("/wish")
@Api("Wish 컨트롤러  API V1")
public class WishController {

	private final Logger logger = LoggerFactory.getLogger(WishController.class);

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

//		JSONObject json = XML.toJSONObject(sb.toString());
//		String jsonStr = json.toString();

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
	//https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst?serviceKey=U3x%2FhookUVc%2BS%2FYDXR0orCt70jponbqHM%2BfioZ%2BHxGIqJV3t4Na4cnAKAEZp6%2Fa%2FE01V9A5lx35maqZDKxcccw%3D%3D&pageNo=1&numOfRows=200&dataType=XML&base_date=20221120&base_time=1700&nx=55&ny=127
		@ApiOperation(value = "날씨 상세 정보", notes = "날씨 상세 정보를 반환한다.", response = List.class)
		@GetMapping(value = "/getweather/{basedate}/{basetime}/{nx}/{ny}", produces = "application/json;charset=utf-8")
		public ResponseEntity<String> getweather(@PathVariable("basedate") String basedate, @PathVariable("basetime") String basetime, @PathVariable("nx") String nx, @PathVariable("ny") String ny) throws IOException, NoSuchAlgorithmException, KeyManagementException {
			// ============= 인증서 허용 코드 =================
	    	TrustManager[] trustAllCerts = new TrustManager[] { 
	    	    (TrustManager) new X509TrustManager() {
	    	        public X509Certificate[] getAcceptedIssuers() {
	    	            return null;
	    	        }

	    	        public void checkClientTrusted(X509Certificate[] certs, String authType) {}
	    	        public void checkServerTrusted(X509Certificate[] certs, String authType) {}
	    		}
	    	};

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
			 //System.out.println(sb.toString());
			JSONObject json = XML.toJSONObject(sb.toString());
			String jsonStr = json.toString();
			return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
		}
}
