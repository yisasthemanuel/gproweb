package org.jlobato.gpro.web.xbean;

import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class TrackRecordXBean.
 */
public class TrackRecordXBean {

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
	 * Instantiates a new track record X bean.
	 */
	public TrackRecordXBean() {
		super();
	}

	/**
	 * Instantiates a new track record X bean.
	 *
	 * @param managerName the manager name
	 * @param idManagerGpro the id manager gpro
	 * @param lapTime the lap time
	 * @param gap the gap
	 * @param season the season
	 * @param race the race
	 * @param group the group
	 * @param date the date
	 */
	public TrackRecordXBean(String managerName, String idManagerGpro, String lapTime, String gap, String season,
			String race, String group, String date) {
		this();
		this.managerName = managerName;
		this.idManagerGpro = idManagerGpro;
		this.lapTime = lapTime;
		this.gap = gap;
		this.season = season;
		this.race = race;
		this.group = group;
		this.date = date;
	}

	/**
	 * Gets the manager name.
	 *
	 * @return the manager name
	 */
	public String getManagerName() {
		return managerName;
	}

	/**
	 * Sets the manager name.
	 *
	 * @param managerName the new manager name
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	/**
	 * Gets the id manager gpro.
	 *
	 * @return the id manager gpro
	 */
	public String getIdManagerGpro() {
		return idManagerGpro;
	}

	/**
	 * Sets the id manager gpro.
	 *
	 * @param idManagerGpro the new id manager gpro
	 */
	public void setIdManagerGpro(String idManagerGpro) {
		this.idManagerGpro = idManagerGpro;
	}

	/**
	 * Gets the lap time.
	 *
	 * @return the lap time
	 */
	public String getLapTime() {
		return lapTime;
	}

	/**
	 * Sets the lap time.
	 *
	 * @param lapTime the new lap time
	 */
	public void setLapTime(String lapTime) {
		this.lapTime = lapTime;
	}

	/**
	 * Gets the gap.
	 *
	 * @return the gap
	 */
	public String getGap() {
		return gap;
	}

	/**
	 * Sets the gap.
	 *
	 * @param gap the new gap
	 */
	public void setGap(String gap) {
		this.gap = gap;
	}

	/**
	 * Gets the season.
	 *
	 * @return the season
	 */
	public String getSeason() {
		return season;
	}

	/**
	 * Sets the season.
	 *
	 * @param season the new season
	 */
	public void setSeason(String season) {
		this.season = season;
	}

	/**
	 * Gets the race.
	 *
	 * @return the race
	 */
	public String getRace() {
		return race;
	}

	/**
	 * Sets the race.
	 *
	 * @param race the new race
	 */
	public void setRace(String race) {
		this.race = race;
	}

	/**
	 * Gets the group.
	 *
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Sets the group.
	 *
	 * @param group the new group
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(date, gap, group, idManagerGpro, lapTime, managerName, race, season);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrackRecordXBean other = (TrackRecordXBean) obj;
		return Objects.equals(date, other.date) && Objects.equals(gap, other.gap) && Objects.equals(group, other.group)
				&& Objects.equals(idManagerGpro, other.idManagerGpro) && Objects.equals(lapTime, other.lapTime)
				&& Objects.equals(managerName, other.managerName) && Objects.equals(race, other.race)
				&& Objects.equals(season, other.season);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "TrackRecordXBean [managerName=" + managerName + ", idManagerGpro=" + idManagerGpro + ", lapTime="
				+ lapTime + ", gap=" + gap + ", season=" + season + ", race=" + race + ", group=" + group + ", date="
				+ date + "]";
	}

}
