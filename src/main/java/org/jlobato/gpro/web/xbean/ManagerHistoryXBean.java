package org.jlobato.gpro.web.xbean;

/**
 * 
 * @author 
 *
 */
public class ManagerHistoryXBean {
	String season;
	String group;
	String tyres;
	String position;
	String wins;			
	String podiums;			
	String poles;
	String fastestLaps;
	String points;
	String races;
	String cup;			
	String money;
	String obr;
	
	/**
	 * 
	 */
	public ManagerHistoryXBean() {
		super();
	}
	
	/**
	 * 
	 * @param season
	 * @param group
	 * @param tyres
	 * @param position
	 * @param wins
	 * @param podiums
	 * @param poles
	 * @param fastestLaps
	 * @param points
	 * @param races
	 * @param cup
	 * @param money
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

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getTyres() {
		return tyres;
	}

	public void setTyres(String tyres) {
		this.tyres = tyres;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getWins() {
		return wins;
	}

	public void setWins(String wins) {
		this.wins = wins;
	}

	public String getPodiums() {
		return podiums;
	}

	public void setPodiums(String podiums) {
		this.podiums = podiums;
	}

	public String getPoles() {
		return poles;
	}

	public void setPoles(String poles) {
		this.poles = poles;
	}

	public String getFastestLaps() {
		return fastestLaps;
	}

	public void setFastestLaps(String fastestLaps) {
		this.fastestLaps = fastestLaps;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getRaces() {
		return races;
	}

	public void setRaces(String races) {
		this.races = races;
	}

	public String getCup() {
		return cup;
	}

	public void setCup(String cup) {
		this.cup = cup;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getObr() {
		return obr;
	}

	public void setObr(String obr) {
		this.obr = obr;
	}

	@Override
	public String toString() {
		return "ManagerHistoryXBean [season=" + season + ", group=" + group + ", tyres=" + tyres + ", position="
				+ position + ", wins=" + wins + ", podiums=" + podiums + ", poles=" + poles + ", fastestLaps="
				+ fastestLaps + ", points=" + points + ", races=" + races + ", cup=" + cup + ", money=" + money
				+ ", obr=" + obr + "]";
	}
	
}
