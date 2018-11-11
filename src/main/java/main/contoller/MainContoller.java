package main.contoller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import admin.controller.AdminController;

@Controller

public class MainContoller {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping("/")
	public String main(Model model, HttpSession session) {
		logger.info("Welcome akatsukirin Admin Main !");
		

		// 1. 컨텐츠 목록 가져오기
		
		// 2. 컨테츠별 추가 이동 경로들.. ( 하단에 넣을 것 ) 가져오기
		
		// 3. 컨텐츠들 이미지 리스트 가져오기 ( 5초마다 이미지 변경 )
		
		
		return "/home";
	}
	
}
