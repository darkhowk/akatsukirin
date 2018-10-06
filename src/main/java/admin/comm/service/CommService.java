package admin.comm.service;

import java.util.HashMap;
import java.util.List;

public interface CommService {

	List<HashMap<String, Object>> getMenu(HashMap<String, Object> param);

	HashMap<String, Object> getAdminMenuList(HashMap<String, Object> param);

}
