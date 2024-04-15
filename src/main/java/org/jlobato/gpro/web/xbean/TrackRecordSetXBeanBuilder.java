package org.jlobato.gpro.web.xbean;

// TODO: Auto-generated Javadoc
/**
 * The Class TrackRecordSetXBeanBuilder.
 */
public class TrackRecordSetXBeanBuilder {
	
	/** The qualy record dry. */
	private TrackRecordXBean qualyRecordDry;
	
	/** The race record dry. */
	private TrackRecordXBean raceRecordDry;
	
	/** The qualy record wet. */
	private TrackRecordXBean qualyRecordWet;
	
	/** The race record wet. */
	private TrackRecordXBean raceRecordWet;
	
	/**
	 * Instantiates a new track record set X bean builder.
	 */
	private TrackRecordSetXBeanBuilder() {
	}
	
	/**
	 * New track record set X bean.
	 *
	 * @return the track record set X bean builder
	 */
	public static TrackRecordSetXBeanBuilder newTrackRecordSetXBeanBuilder() {
		return new TrackRecordSetXBeanBuilder();
	}
	
	/**
	 * Builds the.
	 *
	 * @return the track record set X bean
	 */
	public TrackRecordSetXBean build() {
		TrackRecordSetXBean result = new TrackRecordSetXBean();
		result.setQualyRecordDry(this.qualyRecordDry);
		result.setRaceRecordDry(this.raceRecordDry);
		result.setQualyRecordWet(this.qualyRecordWet);
		result.setRaceRecordWet(this.raceRecordWet);
		return result;
	}
	
	/**
	 * With qualy record dry.
	 *
	 * @param qualyRecordDry the qualy record dry
	 * @return the track record set X bean builder
	 */
	public TrackRecordSetXBeanBuilder withQualyRecordDry(TrackRecordXBean qualyRecordDry) {
		this.qualyRecordDry = qualyRecordDry;
		return this;
	}

	/**
	 * With race record dry.
	 *
	 * @param raceRecordDry the race record dry
	 * @return the track record set X bean builder
	 */
	public TrackRecordSetXBeanBuilder withRaceRecordDry(TrackRecordXBean raceRecordDry) {
		this.raceRecordDry = raceRecordDry;
		return this;
	}
	
	/**
	 * With qualy record wet.
	 *
	 * @param qualyRecordWet the qualy record wet
	 * @return the track record set X bean builder
	 */
	public TrackRecordSetXBeanBuilder withQualyRecordWet(TrackRecordXBean qualyRecordWet) {
		this.qualyRecordWet = qualyRecordWet;
		return this;
	}

	/**
	 * With race record wet.
	 *
	 * @param raceRecordWet the race record wet
	 * @return the track record set X bean builder
	 */
	public TrackRecordSetXBeanBuilder withRaceRecordWet(TrackRecordXBean raceRecordWet) {
		this.raceRecordWet = raceRecordWet;
		return this;
	}
}