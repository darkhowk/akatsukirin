package admin.comm.controller;

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

import admin.comm.service.CommService;

@Controller
@RequestMapping("/admin")
public class CommController {

	private static final Logger logger = LoggerFactory.getLogger(CommController.class);
	
	@Resource(name="commSerivce")
	private CommService commService;
	
	@RequestMapping("/main")
	public String main(Model model, HttpSession session) {
		logger.info("Welcome akatsukirin Admin Main !");
		
		String id = "darkhowk";
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("menuLevel", "0");
		
		List<HashMap<String, Object>> mainMenu = commService.getMenu(param);
		param.remove("menuLevel");
		
		List<HashMap<String, Object>> subMenu = commService.getMenu(param);
		
		session.setAttribute("mainMenu", mainMenu);
		session.setAttribute("subMenu", subMenu);
		
		model.addAttribute("id", id);
		model.addAttribute("mainMenu", mainMenu);
		model.addAttribute("subMenu", subMenu);
		
		return "admin/main";
	}
	
	@RequestMapping("/adminMenuMng")
	public String adminMenuMng(Model model, HttpSession session, @RequestParam HashMap<String, Object> param) {
		
		model = getCommData(model, session, param);
		HashMap<String, Object> data = commService.getAdminMenuList(param);
		model.addAttribute("data", data);
		
		return "admin/adminMenuMng";
	}
	
	@RequestMapping("/userMenuMng")
	public String userMenuMng(Model model, HttpSession session, @RequestParam HashMap<String, Object> param) {
		
		model = getCommData(model, session, param);
		
		return "admin/userMenuMng";
	}

	@RequestMapping(value ="/ajax/adminmenu", method=RequestMethod.POST)
	@ResponseBody
	public JSONPObject adminMenu(HttpSession session, @RequestParam HashMap<String, Object> param) {
		JSONPObject result = null;
		System.out.println("-------------------------------");
		System.out.println(param.toString());
		
		return result; 
	}
	
	private Model getCommData(Model model, HttpSession session, @RequestParam HashMap<String, Object> param) {
		
		String check = (String) session.getAttribute("admin");
		if ("".equals(check) || null == check) {
			model.addAttribute("auth", "N");
		}
		else {
			model.addAttribute("auth", "Y");
		}
		
		String menu = "main";
		if (null == param || "".equals(param)) {
			
		}
		else {
			String selMenu = (String) param.get("selMenu");
			
			List<HashMap<String,Object>> subMenu = (List) session.getAttribute("subMenu");
			for (HashMap<String,Object> subs : subMenu) {
				
				if (selMenu.equals(subs.get("SEQ"))) {
					model.addAttribute("selMenuCategory", subs.get("MENUCATEGORY"));
					model.addAttribute("selMenu", subs.get("MENUNAME"));
				}
			}
		}
		
		model.addAttribute("mainMenu", session.getAttribute("mainMenu"));
		model.addAttribute("subMenu", session.getAttribute("subMenu"));
		
		return model;
	}
}
