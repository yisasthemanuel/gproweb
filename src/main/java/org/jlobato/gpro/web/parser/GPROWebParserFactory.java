package org.jlobato.gpro.web.parser;

import org.jlobato.gpro.web.parser.impl.IDLoggedManagerParserManagerProfileLink;
import org.jlobato.gpro.web.parser.impl.ManagerHistoryParserS70;
import org.jlobato.gpro.web.parser.impl.NewStyleParserDivBoxy;

/**
 * 
 * @author jmplobato
 *
 */
public class GPROWebParserFactory {
	
	/**
	 * 
	 * @return
	 */
	public static NewStyleParser getNewStyleParser() {
		return new NewStyleParserDivBoxy();
	}
	
	/**
	 * 
	 * @return
	 */
	public static ManagerHistoryParser getManagerHistoryParser() {
		return new ManagerHistoryParserS70();
	}
	
	/**
	 * 
	 * @return
	 */
	public static IDLoggedManagerParser getIDLoggedManagerParser() {
		return new IDLoggedManagerParserManagerProfileLink();
	}

}
