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
		
		// 1. ������ ��� ��������
		
		// 2. �������� �߰� �̵� ��ε�.. ( �ϴܿ� ���� �� ) ��������
		
		// 3. �������� �̹��� ����Ʈ �������� ( 5�ʸ��� �̹��� ���� )
		
		return "/home";
	}
	
}
