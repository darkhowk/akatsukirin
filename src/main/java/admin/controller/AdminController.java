package admin.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.util.JSONPObject;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

import com.fasterxml.jackson.core.JsonProcessingException;

import admin.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Resource(name="adminSerivce")
	private AdminService adminService;
	
	@RequestMapping("/main")
	public String main(Model model, HttpSession session, @RequestParam HashMap<String, Object> param, HttpServletRequest request) {
		logger.info("Welcome Memorandum Admin Main !");
		
		param.put("category", "admin");
		List<LinkedHashMap<String, Object>> menu = adminService.getMenu(param);
		//model.addAttribute("id", param.get("id"));
		model.addAttribute("menu", adminMenu());
		model.addAttribute("path", path(request));
		
		return "admin/main";
	}
	
	@RequestMapping("/menu")
	public String menu(Model model, HttpSession session, @RequestParam HashMap<String, Object> param, HttpServletRequest request) {
		
		HashMap<String, Object> data = adminService.getMenuList(param);
		model.addAttribute("data", data);
		model.addAttribute("menu", adminMenu());
		model.addAttribute("path", path(request));
		
		return "admin/menu";
	}
	
	@RequestMapping("/category")
	public String category(Model model, HttpSession session, @RequestParam HashMap<String, Object> param, HttpServletRequest request) throws JsonProcessingException {
		HashMap<String, Object> data = adminService.getCategoryList(param);
		model.addAttribute("data", data);
		model.addAttribute("menu", adminMenu());
		model.addAttribute("path", path(request));
		
		return "admin/category";
	}
	
	@RequestMapping(value ="/category/ajax", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> adminCategory(HttpSession session, @RequestParam HashMap<String, Object> param, HttpServletRequest request) {
		HashMap<String, Object> result = adminService.setCategoryData(param);
		return result; 
	}
	
	@RequestMapping(value ="/menu/ajax", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> adminMenu(HttpSession session, @RequestParam HashMap<String, Object> param, HttpServletRequest request) {
		HashMap<String, Object> result = adminService.setMenuData(param);
		return result; 
	}
	
	private List<LinkedHashMap<String, Object>> adminMenu(){
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("category", "admin");
		List<LinkedHashMap<String, Object>> result = adminService.getMenu(param);
		
		return result;
		
	}
	private HashMap<String, Object> path(HttpServletRequest request) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		String requestMapping = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String[] pathList = requestMapping.split("/");
		String path = "";
		
		for (int i = 1; i < pathList.length ; i ++) {
			if (i == pathList.length-1) {
				String MenuName = adminService.getPath(pathList[i]);
				path += MenuName;
				result.put("MenuName",MenuName);
			}
			else {
				path += adminService.getPath(pathList[i])+">";
			}
		}
		result.put("path", path);
		return result;
	}
}
