package admin.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value="adminDao")
public class AdminDao {

	@Autowired
	private SqlSession session;

	public List<HashMap<String, Object>> getMenu(HashMap<String, Object> param) {
		return session.selectList("COMM.getMenu", param);
	}


	public Object getMenuList(HashMap<String, Object> param)
	{
		return session.selectList("COMM.getMenuList", param);
	}

	public Object getCategoryList(HashMap<String, Object> param)
	{
		return session.selectList("COMM.getCategoryList", param);
	}
	
}
