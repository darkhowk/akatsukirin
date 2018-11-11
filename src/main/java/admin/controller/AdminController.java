package admin.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import admin.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Resource(name="adminSerivce")
	private AdminService adminService;
	
	@RequestMapping("/main")
	public String main(Model model, HttpSession session, @RequestParam HashMap<String, Object> param) {
		logger.info("Welcome Memorandum Admin Main !");
		
		param.put("category", "admin");
		List<HashMap<String, Object>> menu = adminService.getMenu(param);
		//model.addAttribute("id", param.get("id"));
		model.addAttribute("menu", adminMenu());
		
		return "admin/main";
	}
	
	@RequestMapping("/menu")
	public String menu(Model model, HttpSession session, @RequestParam HashMap<String, Object> param) {
		
		HashMap<String, Object> data = adminService.getMenuList(param);
		model.addAttribute("data", data);
		model.addAttribute("menu", adminMenu());
		
		return "admin/menu";
	}
	
	@RequestMapping("/category")
	public String category(Model model, HttpSession session, @RequestParam HashMap<String, Object> param) {
		
		HashMap<String, Object> data = adminService.getCategoryList(param);
		model.addAttribute("data", data);
		model.addAttribute("menu", adminMenu());
		
		return "admin/category";
	}
	
	@RequestMapping(value ="/ajax/adminmenu", method=RequestMethod.POST)
	@ResponseBody
	public JSONPObject adminMenu(HttpSession session, @RequestParam HashMap<String, Object> param) {
		JSONPObject result = null;
		System.out.println("-------------------------------");
		System.out.println(param.toString());
		
		return result; 
	}
	
	private List<HashMap<String, Object>> adminMenu(){
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("category", "admin");
		List<HashMap<String, Object>> result = adminService.getMenu(param);
		
		return result;
		
	}
}
