package oni.comm.controller;

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
@RequestMapping("/oni")
public class CommController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommController.class);
	
	@Resource(name="commSerivce")
	private CommService commService;

	
	@RequestMapping("/main")
	public String main(Model model, HttpSession session) {
		
		
		return "oni/main";
	}
}
