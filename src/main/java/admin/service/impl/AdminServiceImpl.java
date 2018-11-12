package admin.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

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
		HashMap<String, Object> result = getData(adminDao.getMenuList(param));
		
		result.put("param", param);
		return result;
	}
	

	@Override
	public HashMap<String, Object> getCategoryList(HashMap<String, Object> param) throws JsonProcessingException {
		HashMap<String, Object> result = getData(adminDao.getCategoryList(param));
		
		result.put("param", param);
		return result;
	}

	@Override
	public String getPath(String a)
	{
		return adminDao.getPath(a);
	}
	
	private HashMap<String, Object> getData(List<LinkedHashMap<String, Object>> data){
		HashMap<String, Object> result = new HashMap<String, Object>();
		List<JSONObject> columnList = new ArrayList<JSONObject>();
		
		HashMap<String, Object> map = data.get(0);
		Set key = map.keySet();
		Iterator iterator = key.iterator();
		while(iterator.hasNext()) {
			String strKey = (String) iterator.next();
			JSONObject column = new JSONObject();
			column.put("title", strKey);
			column.put("name", strKey);
			JSONObject option = new JSONObject();
			option.put("type", "text");
			column.put("editOptions", option);
			columnList.add(column);
		}
		
		 Gson json = new Gson();
		 List<String> list = new ArrayList<String>();
        // Convert the ordered map into an ordered string.
		 for (LinkedHashMap<String, Object> mapData : data) {
			 list.add(json.toJson(mapData, LinkedHashMap.class));
		 }
		 System.out.println("list :: "+ list.toString());
		result.put("column", columnList);
		result.put("list", list);
		
		return result;
	}
}
