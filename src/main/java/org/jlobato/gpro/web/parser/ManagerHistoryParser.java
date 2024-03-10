package org.jlobato.gpro.web.parser;

import java.util.List;

import org.jlobato.gpro.web.xbean.ManagerHistoryXBean;

/**
 * The Interface ManagerHistoryParser.
 */
public interface ManagerHistoryParser {
	
	/** The manager history div name. */
	String MANAGER_HISTORY_DIV_NAME = "dvManHistory";

	/**
	 * Gets the manager history info.
	 *
	 * @param htmlSource the html source
	 * @return the manager history info
	 */
	public List<ManagerHistoryXBean> getManagerHistoryInfo(String htmlSource);

}
