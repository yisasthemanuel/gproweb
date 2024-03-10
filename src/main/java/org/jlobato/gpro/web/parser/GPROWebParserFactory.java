package org.jlobato.gpro.web.parser;

import org.jlobato.gpro.web.parser.impl.IDLoggedManagerParserManagerProfileLink;
import org.jlobato.gpro.web.parser.impl.ManagerHistoryParserS70;
import org.jlobato.gpro.web.parser.impl.NewStyleParserDivBoxy;

/**
 * A factory for creating GPROWebParser objects.
 *
 * @author jmplobato
 */
public class GPROWebParserFactory {
	
	/**
	 * Gets the new style parser.
	 *
	 * @return the new style parser
	 */
	public static NewStyleParser getNewStyleParser() {
		return new NewStyleParserDivBoxy();
	}
	
	/**
	 * Gets the manager history parser.
	 *
	 * @return the manager history parser
	 */
	public static ManagerHistoryParser getManagerHistoryParser() {
		return new ManagerHistoryParserS70();
	}
	
	/**
	 * Gets the ID logged manager parser.
	 *
	 * @return the ID logged manager parser
	 */
	public static IDLoggedManagerParser getIDLoggedManagerParser() {
		return new IDLoggedManagerParserManagerProfileLink();
	}

}
