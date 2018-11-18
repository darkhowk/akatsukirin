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
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.util.JSONPObject;
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
			JSONObject option = new JSONObject();
			
			column.put("title", strKey);
			column.put("name", strKey);
			
			if (strKey.toUpperCase().equals("SEQ")) {
			}
			else if (strKey.toUpperCase().contains("CREATE") || strKey.toUpperCase().contains("UPDATE")) {
			}
			else if (strKey.toUpperCase().equals("USEYN")) {
				option.put("type", "select");
				ArrayList<JSONObject> list = new ArrayList<JSONObject>();
				JSONObject listItem1 = new JSONObject();
				JSONObject listItem2 = new JSONObject();
				listItem1.put("text", "사용");
				listItem1.put("value", "Y");
				list.add(listItem1);
				listItem2.put("text", "미사용");
				listItem2.put("value", "N");
				list.add(listItem2);
				option.put("listItems", list);
			}
			else {
				option.put("type", "text");
			}
			
			
			column.put("editOptions", option);
			columnList.add(column);
		}
		
		 Gson json = new Gson();
		 List<String> list = new ArrayList<String>();
		 for (LinkedHashMap<String, Object> mapData : data) {
			 list.add(json.toJson(mapData, LinkedHashMap.class));
		 }
		result.put("column", columnList);
		result.put("list", list);
		
		return result;
	}

	@Override
	public HashMap<String, Object> setMenuData(HashMap<String, Object> param) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		int count = 0;
		
		List<HashMap<String,Object>> data = (List<HashMap<String, Object>>) setParamToMap(param);
		if (data.size() > 0) {
			for (HashMap<String, Object> rowData : data) {
				 count += adminDao.mergeIntoMenu(rowData);
			}
		}
		
		result.put("result", count);
		return result;
	}
	
	@Override
	public HashMap<String, Object> setCategoryData(HashMap<String, Object> param) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		int count = 0;
		
		List<HashMap<String,Object>> data = (List<HashMap<String, Object>>) setParamToMap(param);
		if (data.size() > 0) {
			for (HashMap<String, Object> rowData : data) {
				 count += adminDao.mergeIntoCategory(rowData);
			}
		}
		
		
		result.put("result", count);
		return result;
	}
	
	private List<HashMap<String,Object>> setParamToMap(HashMap<String, Object> param){
		List<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>>();
		
		List<HashMap<String,Object>> Listdata = new ArrayList<HashMap<String,Object>>();
		List<HashMap<String,Object>> tmpData = new ArrayList<HashMap<String,Object>>();
		
		HashMap<String, Object> map = param;
		Set key = map.keySet();
		Iterator iterator = key.iterator();
		HashMap<String, Object> data = new HashMap<String, Object>();

		while(iterator.hasNext()) {
			String strKey = (String) iterator.next();
			data.put("USER_ID", "darkhowk");
				int num = Integer.parseInt(strKey.substring(strKey.indexOf("[")+1, strKey.indexOf("]")));
				String dataKey = strKey.substring(strKey.lastIndexOf("[")+1, strKey.lastIndexOf("]"));
				Object dataValue = param.get(strKey);
			
				data.put(dataKey, dataValue);
				tmpData.add(num , data);
		}

		for (int i = 0; i < tmpData.size(); i++) {
             if (!Listdata.contains(tmpData.get(i))) {
            	 Listdata.add(tmpData.get(i));
             }
         }

		result.addAll(Listdata);
		return result;
	}
}
