package admin.comm.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value="commDao")
public class CommDao {

	@Autowired
	private SqlSession session;

	public List<HashMap<String, Object>> getMenu(HashMap<String, Object> param) {
		return session.selectList("COMM.getMenu", param);
	}

	public List<HashMap<String, Object>> getAdminMenuList(HashMap<String, Object> param) {
		return session.selectList("COMM.getAdminMenuList", param);
	}
	
}
