package org.jlobato.gpro.web.xbean;

/**
 * The Class TrackRecordSetXBean.
 */
public class TrackRecordSetXBean {

	/** The qualy record dry. */
	private TrackRecordXBean qualyRecordDry;
	
	/** The race record dry. */
	private TrackRecordXBean raceRecordDry;
	
	/** The qualy record wet. */
	private TrackRecordXBean qualyRecordWet;
	
	/** The race record wet. */
	private TrackRecordXBean raceRecordWet;

	/**
	 * Instantiates a new track record set X bean.
	 */
	public TrackRecordSetXBean() {
		super();
	}

	/**
	 * Instantiates a new track record set X bean.
	 *
	 * @param qualyRecordDry the qualy record dry
	 * @param raceRecordDry the race record dry
	 * @param qualyRecordWet the qualy record wet
	 * @param raceRecordWet the race record wet
	 */
	public TrackRecordSetXBean(TrackRecordXBean qualyRecordDry, TrackRecordXBean raceRecordDry,
			TrackRecordXBean qualyRecordWet, TrackRecordXBean raceRecordWet) {
		this();
		this.qualyRecordDry = qualyRecordDry;
		this.raceRecordDry = raceRecordDry;
		this.qualyRecordWet = qualyRecordWet;
		this.raceRecordWet = raceRecordWet;
	}

	/**
	 * Gets the qualy record dry.
	 *
	 * @return the qualy record dry
	 */
	public TrackRecordXBean getQualyRecordDry() {
		return qualyRecordDry;
	}

	/**
	 * Sets the qualy record dry.
	 *
	 * @param qualyRecordDry the new qualy record dry
	 */
	public void setQualyRecordDry(TrackRecordXBean qualyRecordDry) {
		this.qualyRecordDry = qualyRecordDry;
	}

	/**
	 * Gets the race record dry.
	 *
	 * @return the race record dry
	 */
	public TrackRecordXBean getRaceRecordDry() {
		return raceRecordDry;
	}

	/**
	 * Sets the race record dry.
	 *
	 * @param raceRecordDry the new race record dry
	 */
	public void setRaceRecordDry(TrackRecordXBean raceRecordDry) {
		this.raceRecordDry = raceRecordDry;
	}

	/**
	 * Gets the qualy record wet.
	 *
	 * @return the qualy record wet
	 */
	public TrackRecordXBean getQualyRecordWet() {
		return qualyRecordWet;
	}

	/**
	 * Sets the qualy record wet.
	 *
	 * @param qualyRecordWet the new qualy record wet
	 */
	public void setQualyRecordWet(TrackRecordXBean qualyRecordWet) {
		this.qualyRecordWet = qualyRecordWet;
	}

	/**
	 * Gets the race record wet.
	 *
	 * @return the race record wet
	 */
	public TrackRecordXBean getRaceRecordWet() {
		return raceRecordWet;
	}

	/**
	 * Sets the race record wet.
	 *
	 * @param raceRecordWet the new race record wet
	 */
	public void setRaceRecordWet(TrackRecordXBean raceRecordWet) {
		this.raceRecordWet = raceRecordWet;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "TrackRecordSetXBean [qualyRecordDry=" + qualyRecordDry + ", raceRecordDry=" + raceRecordDry
				+ ", qualyRecordWet=" + qualyRecordWet + ", raceRecordWet=" + raceRecordWet + "]";
	}

}
