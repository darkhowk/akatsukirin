package admin.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.codehaus.jackson.map.util.JSONPObject;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface AdminService {

	List<LinkedHashMap<String, Object>> getMenu(HashMap<String, Object> param);

	HashMap<String, Object> getMenuList(HashMap<String, Object> param);

	HashMap<String, Object> getCategoryList(HashMap<String, Object> param) throws JsonProcessingException;

	String getPath(String a);

	HashMap<String, Object> setCategoryData(HashMap<String, Object> param);

	HashMap<String, Object> setMenuData(HashMap<String, Object> param);

}
