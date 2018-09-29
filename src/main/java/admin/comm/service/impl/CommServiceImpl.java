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
	
}
