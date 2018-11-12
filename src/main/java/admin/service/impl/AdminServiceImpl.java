package admin.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import admin.dao.AdminDao;
import admin.service.AdminService;

@Service(value="adminSerivce")
public class AdminServiceImpl implements AdminService{

	@Resource(name="adminDao")
	private AdminDao adminDao;

	@Override
	public List<LinkedHashMap<String, Object>> getMenu(HashMap<String, Object> param) {
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
		List<LinkedHashMap<String, Object>> data = adminDao.getCategoryList(param);
		JSONObject column = new JSONObject();
		
		HashMap<String, Object> map = data.get(0);
		Set key = map.keySet();
		Iterator iterator = key.iterator();
		int i = 0;
		while(iterator.hasNext()) {
			String strKey = (String) iterator.next();
			column.put(i+"", strKey);
			i++;
		}
		result.put("column", column);
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
