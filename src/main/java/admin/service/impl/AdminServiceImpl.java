package admin.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import admin.dao.AdminDao;
import admin.service.AdminService;

@Service(value="adminSerivce")
public class AdminServiceImpl implements AdminService{

	@Resource(name="adminDao")
	private AdminDao adminDao;

	@Override
	public List<HashMap<String, Object>> getMenu(HashMap<String, Object> param) {
		return adminDao.getMenu(param);
	}

	@Override
	public HashMap<String, Object> getMenuList(HashMap<String, Object> param) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		result.put("param", param);
		result.put("list", adminDao.getMenuList(param));
		return result;
	}
	

	@Override
	public HashMap<String, Object> getCategoryList(HashMap<String, Object> param) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		result.put("param", param);
		result.put("list", adminDao.getCategoryList(param));
		return result;
	}

	@Override
	public String getPath(String a)
	{
		return adminDao.getPath(a);
	}
}
