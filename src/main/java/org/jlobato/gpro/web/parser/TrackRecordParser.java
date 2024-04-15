package org.jlobato.gpro.web.parser;

import org.jlobato.gpro.web.xbean.TrackRecordXBean;

/**
 * The Interface TrackRecordParser.
 */
public interface TrackRecordParser {
	
	/** The records table id. */
	public static final String RECORDS_TABLE_ID = "Table16";

	/**
	 * Gets the track record info.
	 *
	 * @param htmlSource the html source
	 * @return the track record info
	 */
	public TrackRecordXBean getTrackRecordInfo(String htmlSource);
}
