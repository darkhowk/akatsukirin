package admin.service.impl;

import java.util.Map.Entry;

public class CustomizedHashMap
{
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
	    // TODO Auto-generated method stub
	    return -o1.getValue().compareTo(o2.getValue());
	  }
}
