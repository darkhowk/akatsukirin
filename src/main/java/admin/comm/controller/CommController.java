package admin.comm.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import admin.comm.service.CommService;

@Controller
public class CommController {

	private static final Logger logger = LoggerFactory.getLogger(CommController.class);
	
	@Resource(name="commSerivce")
	private CommService commService;
	
	@RequestMapping("/admin/main")
	public String main(Model model, HttpSession session) {
		logger.info("Welcome AkatukiRin Admin Main !");
		
		
		// 1. 권한 체크후, 해당 권한의 메뉴를 가져옴 ( 현재 권한체크로직은 제외 2018.09.29) 해당 권한 체크는 Query 에서 id로 체크
		String id = "darkhowk";
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("menuLevel", "0");
		List<HashMap<String, Object>> mainMenu = commService.getMenu(param);
		param.remove("menuLevel");
		List<HashMap<String, Object>> subMenu = commService.getMenu(param);
		
		model.addAttribute("id", id);
		model.addAttribute("mainMenu", mainMenu);
		model.addAttribute("subMenu", subMenu);
		
		return "admin/main";
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		logger.info("Welcome AkatukiRin Admin Home !");
		
		return "/home";
	}
}
