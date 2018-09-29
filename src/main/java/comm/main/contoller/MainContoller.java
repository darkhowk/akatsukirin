package comm.main.contoller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import admin.comm.controller.CommController;

@Controller
@RequestMapping("/")
public class MainContoller {
	
	private static final Logger logger = LoggerFactory.getLogger(CommController.class);
	
	public String main(Model model, HttpSession session) {
		logger.info("Welcome AkatukiRin Admin Main !");
		
		return "/home";
	}
	
}
