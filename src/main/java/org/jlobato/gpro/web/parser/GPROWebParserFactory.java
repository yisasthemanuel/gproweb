package org.jlobato.gpro.web.parser;

import org.jlobato.gpro.web.parser.impl.IDLoggedManagerParserManagerProfileLink;
import org.jlobato.gpro.web.parser.impl.ManagerHistoryParserS70;
import org.jlobato.gpro.web.parser.impl.NewStyleParserFromAccountSettings;
import org.jlobato.gpro.web.parser.impl.TrackRecordParserImpl;

/**
 * A factory for creating GPROWebParser objects.
 *
 * @author jmplobato
 */
public class GPROWebParserFactory {
	
	/**
	 * Instantiates a new GPRO web parser factory.
	 */
	private GPROWebParserFactory() {
	}
	
	/**
	 * Gets the new style parser.
	 *
	 * @return the new style parser
	 */
	public static NewStyleParser getNewStyleParser() {
		return new NewStyleParserFromAccountSettings();
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
	
	/**
	 * Gets the track record parser.
	 *
	 * @return the track record parser
	 */
	public static TrackRecordParser getTrackRecordParser() {
		return new TrackRecordParserImpl();
	}

}
