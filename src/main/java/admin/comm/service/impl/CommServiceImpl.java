package admin.comm.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import admin.comm.dao.CommDao;
import admin.comm.service.CommService;

@Service(value="commSerivce")
public class CommServiceImpl implements CommService{

	@Resource(name="commDao")
	private CommDao commDao;

	@Override
	public List<HashMap<String, Object>> getMenu(HashMap<String, Object> param) {
		return commDao.getMenu(param);
	}

	@Override
	public HashMap<String, Object> getAdminMenuList(HashMap<String, Object> param) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		// 傍烹 其捞隆 
		param = pageing(param);
		
		result.put("param", param);
		result.put("list", commDao.getAdminMenuList(param));
		return result;
	}
	
	
	
	private HashMap<String, Object> pageing(HashMap<String, Object> param) {
		HashMap<String, Object> result = param;
		// 其捞隆 贸府 
		String page = (String) param.get("page");
		String countPage = (String) param.get("countPage");
		
		if ("".equals(page) || null == page) {
			result.remove("page");
			result.put("page", "1");
			page = "1";
		}
		
		if ("".equals(countPage) || null == countPage) {
			result.remove("countPage");
			result.put("countPage", "10");
			countPage = "10";
		}
		
		int startCount = (Integer.parseInt(page) - 1) * Integer.parseInt(countPage) + 1;
		int endCount = (Integer.parseInt(page) * Integer.parseInt(countPage));  
		
		result.put("startCount", startCount);
		result.put("endCount", endCount);
		
		return result;
	}
}
