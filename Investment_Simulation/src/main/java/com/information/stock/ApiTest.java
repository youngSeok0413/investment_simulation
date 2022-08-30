package com.information.stock;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApiTest
 * 
 */
@WebServlet("/ApiTest")
public class ApiTest extends HttpServlet {
	
   @Override
protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	ApiExplorer api = new ApiExplorer("http://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getStockPriceInfo",
"=Oid9hCIUUz8AG7Tma1ERjd%2Bl%2Bp44lkxQvOjjfyAQaGnehYsVpTgnneoZ4zjmm2xoUjUdppTDRlPFbwssWiH53Q%3D%3D",
10, 10);
}

}
