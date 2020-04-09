package org.jlobato.gpro.web.parser;

import java.util.List;

import org.jlobato.gpro.web.xbean.ManagerHistoryXBean;

public interface ManagerHistoryParser {
	
	String MANAGER_HISTORY_DIV_NAME = "dvManHistory";

	public List<ManagerHistoryXBean> getManagerHistoryInfo(String htmlSource);

}
