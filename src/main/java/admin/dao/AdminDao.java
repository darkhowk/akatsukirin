package admin.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comm.util.CommSession;

@Repository(value="adminDao")
public class AdminDao extends CommSession{

	@Autowired
	private SqlSession session;

	public List<LinkedHashMap<String, Object>> getMenu(HashMap<String, Object> param) {
		List<LinkedHashMap<String, Object>> data = session.selectList("COMM.getMenu", param);
		return data;
	}


	public List<LinkedHashMap<String, Object>> getMenuList(HashMap<String, Object> param)
	{
		return session.selectList("COMM.getMenuList", param);
	}

	public List<LinkedHashMap<String, Object>> getCategoryList(HashMap<String, Object> param)
	{
		return session.selectList("COMM.getCategoryList", param);
	}


	public String getPath(String a)
	{
		return session.selectOne("COMM.getPath", a);
	}
	
}
