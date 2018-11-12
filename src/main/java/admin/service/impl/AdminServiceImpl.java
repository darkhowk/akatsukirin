package admin.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	public HashMap<String, Object> getCategoryList(HashMap<String, Object> param) throws JsonProcessingException {
		HashMap<String, Object> result = new HashMap<String, Object>();
		List<LinkedHashMap<String, Object>> data = adminDao.getCategoryList(param);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
		HashMap<String, Object> map = data.get(0);
		Set key = map.keySet();
		System.out.println(key.toString());
		Iterator iterator = key.iterator();
		List<JSONObject> columnList = new ArrayList<JSONObject>();
		while(iterator.hasNext()) {
			String strKey = (String) iterator.next();
			JSONObject column = new JSONObject();
			column.put("title", strKey);
			column.put("name", strKey);
			columnList.add(column);
		}
		result.put("column", columnList);
		result.put("param", param);
		result.put("list", mapper.writeValueAsString(data));
		return result;
	}

	@Override
	public String getPath(String a)
	{
		return adminDao.getPath(a);
	}
	
}
