package org.jlobato.gpro.web.xbean;

/**
 * The Class ManagerHistoryXBean.
 *
 * @author 
 */
public class ManagerHistoryXBean {
	
	/** The season. */
	String season;
	
	/** The group. */
	String group;
	
	/** The tyres. */
	String tyres;
	
	/** The position. */
	String position;
	
	/** The wins. */
	String wins;			
	
	/** The podiums. */
	String podiums;			
	
	/** The poles. */
	String poles;
	
	/** The fastest laps. */
	String fastestLaps;
	
	/** The points. */
	String points;
	
	/** The races. */
	String races;
	
	/** The cup. */
	String cup;			
	
	/** The money. */
	String money;
	
	/** The obr. */
	String obr;
	
	/**
	 * Instantiates a new manager history X bean.
	 */
	public ManagerHistoryXBean() {
		super();
	}
	
	/**
	 * Instantiates a new manager history X bean.
	 *
	 * @param season the season
	 * @param group the group
	 * @param tyres the tyres
	 * @param position the position
	 * @param wins the wins
	 * @param podiums the podiums
	 * @param poles the poles
	 * @param fastestLaps the fastest laps
	 * @param points the points
	 * @param races the races
	 * @param cup the cup
	 * @param money the money
	 * @param obr the obr
	 */
	public ManagerHistoryXBean(String season, String group, String tyres, String position, String wins, String podiums,
			String poles, String fastestLaps, String points, String races, String cup, String money, String obr) {
		this();
		this.season = season;
		this.group = group;
		this.tyres = tyres;
		this.position = position;
		this.wins = wins;
		this.podiums = podiums;
		this.poles = poles;
		this.fastestLaps = fastestLaps;
		this.points = points;
		this.races = races;
		this.cup = cup;
		this.money = money;
		this.obr = obr;
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
	 * Gets the tyres.
	 *
	 * @return the tyres
	 */
	public String getTyres() {
		return tyres;
	}

	/**
	 * Sets the tyres.
	 *
	 * @param tyres the new tyres
	 */
	public void setTyres(String tyres) {
		this.tyres = tyres;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * Gets the wins.
	 *
	 * @return the wins
	 */
	public String getWins() {
		return wins;
	}

	/**
	 * Sets the wins.
	 *
	 * @param wins the new wins
	 */
	public void setWins(String wins) {
		this.wins = wins;
	}

	/**
	 * Gets the podiums.
	 *
	 * @return the podiums
	 */
	public String getPodiums() {
		return podiums;
	}

	/**
	 * Sets the podiums.
	 *
	 * @param podiums the new podiums
	 */
	public void setPodiums(String podiums) {
		this.podiums = podiums;
	}

	/**
	 * Gets the poles.
	 *
	 * @return the poles
	 */
	public String getPoles() {
		return poles;
	}

	/**
	 * Sets the poles.
	 *
	 * @param poles the new poles
	 */
	public void setPoles(String poles) {
		this.poles = poles;
	}

	/**
	 * Gets the fastest laps.
	 *
	 * @return the fastest laps
	 */
	public String getFastestLaps() {
		return fastestLaps;
	}

	/**
	 * Sets the fastest laps.
	 *
	 * @param fastestLaps the new fastest laps
	 */
	public void setFastestLaps(String fastestLaps) {
		this.fastestLaps = fastestLaps;
	}

	/**
	 * Gets the points.
	 *
	 * @return the points
	 */
	public String getPoints() {
		return points;
	}

	/**
	 * Sets the points.
	 *
	 * @param points the new points
	 */
	public void setPoints(String points) {
		this.points = points;
	}

	/**
	 * Gets the races.
	 *
	 * @return the races
	 */
	public String getRaces() {
		return races;
	}

	/**
	 * Sets the races.
	 *
	 * @param races the new races
	 */
	public void setRaces(String races) {
		this.races = races;
	}

	/**
	 * Gets the cup.
	 *
	 * @return the cup
	 */
	public String getCup() {
		return cup;
	}

	/**
	 * Sets the cup.
	 *
	 * @param cup the new cup
	 */
	public void setCup(String cup) {
		this.cup = cup;
	}

	/**
	 * Gets the money.
	 *
	 * @return the money
	 */
	public String getMoney() {
		return money;
	}

	/**
	 * Sets the money.
	 *
	 * @param money the new money
	 */
	public void setMoney(String money) {
		this.money = money;
	}

	/**
	 * Gets the obr.
	 *
	 * @return the obr
	 */
	public String getObr() {
		return obr;
	}

	/**
	 * Sets the obr.
	 *
	 * @param obr the new obr
	 */
	public void setObr(String obr) {
		this.obr = obr;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ManagerHistoryXBean [season=" + season + ", group=" + group + ", tyres=" + tyres + ", position="
				+ position + ", wins=" + wins + ", podiums=" + podiums + ", poles=" + poles + ", fastestLaps="
				+ fastestLaps + ", points=" + points + ", races=" + races + ", cup=" + cup + ", money=" + money
				+ ", obr=" + obr + "]";
	}
	
}
