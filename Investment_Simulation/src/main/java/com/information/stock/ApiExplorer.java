package com.information.stock;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;


public class ApiExplorer {
	StringBuilder urlBuilder;
	
	public ApiExplorer(String endPoint, String key, int pgDataNum, int pageNo) throws IOException {
		urlBuilder = new StringBuilder(endPoint);
		
		Integer pgDTNum = Integer.valueOf(pgDataNum);
		Integer pgNo = Integer.valueOf(pageNo);
		
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
		+"="+URLEncoder.encode(key, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8")
			+"="+URLEncoder.encode(pgDTNum.toString(), "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8")
			+"="+URLEncoder.encode(pgNo.toString(), "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("resultType", "UTF-8")
		+"="+URLEncoder.encode("json", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("endMrktTotAmt", "UTF-8")
		+"="+URLEncoder.encode("100000000", "UTF-8"));
		
		 URL url = new URL(urlBuilder.toString());
	     HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	     // 5. 통신을 위한 메소드 SET.
	     conn.setRequestMethod("GET");
	     // 6. 통신을 위한 Content-type SET. 
	     conn.setRequestProperty("Content-type", "application/json");
	     // 7. 통신 응답 코드 확인.
	     System.out.println("Response code: " + conn.getResponseCode());
	     // 8. 전달받은 데이터를 BufferedReader 객체로 저장.
	     BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        // 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        // 10. 객체 해제.
	        rd.close();
	        conn.disconnect();
	        // 11. 전달받은 데이터 확인.
	        System.out.println(sb.toString());
	}
}
