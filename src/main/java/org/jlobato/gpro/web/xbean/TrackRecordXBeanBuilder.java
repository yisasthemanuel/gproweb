package org.jlobato.gpro.web.xbean;

// TODO: Auto-generated Javadoc
/**
 * The Class TrackRecordXBeanBuilder.
 */
public class TrackRecordXBeanBuilder {
	
	/** The manager name. */
	private String managerName;
	
	/** The id manager gpro. */
	private String idManagerGpro;
	
	/** The lap time. */
	private String lapTime;
	
	/** The gap. */
	private String gap;
	
	/** The season. */
	private String season;
	
	/** The race. */
	private String race;
	
	/** The group. */
	private String group;
	
	/** The date. */
	private String date;

	/**
	 * Instantiates a new track record X bean builder.
	 */
	private TrackRecordXBeanBuilder() {
	}

	/**
	 * New track record X bean.
	 *
	 * @return the track record X bean builder
	 */
	public static TrackRecordXBeanBuilder newTrackRecordXBeanBuilder() {
		return new TrackRecordXBeanBuilder();
	}

	/**
	 * Builds the.
	 *
	 * @return the track record X bean
	 */
	public TrackRecordXBean build() {
		TrackRecordXBean result = new TrackRecordXBean();
		result.setManagerName(this.managerName);
		result.setIdManagerGpro(this.idManagerGpro);
		result.setLapTime(this.lapTime);
		result.setGap(this.gap);
		result.setSeason(this.season);
		result.setRace(this.race);
		result.setGroup(this.group);
		result.setDate(this.date);
		return result;
	}

	/**
	 * With manager name.
	 *
	 * @param managerName the manager name
	 * @return the track record X bean builder
	 */
	public TrackRecordXBeanBuilder withManagerName(String managerName) {
		this.managerName = managerName;
		return this;
	}

	/**
	 * With id manager gpro.
	 *
	 * @param idManagerGpro the id manager gpro
	 * @return the track record X bean builder
	 */
	public TrackRecordXBeanBuilder withIdManagerGpro(String idManagerGpro) {
		this.idManagerGpro = idManagerGpro;
		return this;
	}

	/**
	 * With lap time.
	 *
	 * @param lapTime the lap time
	 * @return the track record X bean builder
	 */
	public TrackRecordXBeanBuilder withLapTime(String lapTime) {
		this.lapTime = lapTime;
		return this;
	}

	/**
	 * With gap.
	 *
	 * @param gap the gap
	 * @return the track record X bean builder
	 */
	public TrackRecordXBeanBuilder withGap(String gap) {
		this.gap = gap;
		return this;
	}

	/**
	 * With season.
	 *
	 * @param season the season
	 * @return the track record X bean builder
	 */
	public TrackRecordXBeanBuilder withSeason(String season) {
		this.season = season;
		return this;
	}

	/**
	 * With race.
	 *
	 * @param race the race
	 * @return the track record X bean builder
	 */
	public TrackRecordXBeanBuilder withRace(String race) {
		this.race = race;
		return this;
	}

	/**
	 * With group.
	 *
	 * @param group the group
	 * @return the track record X bean builder
	 */
	public TrackRecordXBeanBuilder withGroup(String group) {
		this.group = group;
		return this;
	}

	/**
	 * With date.
	 *
	 * @param date the date
	 * @return the track record X bean builder
	 */
	public TrackRecordXBeanBuilder withDate(String date) {
		this.date = date;
		return this;
	}
}
