package org.jlobato.gpro.web.xbean;

/**
 * The Class ManagerHistoryXBeanBuilder.
 */
public class ManagerHistoryXBeanBuilder {
	
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
	 * Instantiates a new manager history X bean builder.
	 */
	private ManagerHistoryXBeanBuilder() {
	}

	/**
	 * New manager history X bean.
	 *
	 * @return the manager history X bean builder
	 */
	public static ManagerHistoryXBeanBuilder newManagerHistoryXBean() {
		return new ManagerHistoryXBeanBuilder();
	}
	
	/**
	 * Builds the.
	 *
	 * @return the manager history X bean
	 */
	public ManagerHistoryXBean build() {
		ManagerHistoryXBean result = new ManagerHistoryXBean();
		result.setSeason(this.season);
		result.setGroup(this.group);
		result.setTyres(this.tyres);
		result.setPosition(this.position);
		result.setWins(this.wins);
		result.setPodiums(this.podiums);
		result.setPoles(this.poles);
		result.setFastestLaps(this.fastestLaps);
		result.setPoints(this.points);
		result.setRaces(this.races);
		result.setCup(this.cup);
		result.setMoney(this.money);
		result.setObr(this.obr);
		
		return result;
	}

	/**
	 * With season.
	 *
	 * @param season the season
	 * @return the manager history X bean builder
	 */
	public ManagerHistoryXBeanBuilder withSeason(String season) {
		this.season = season;
		return this;
	}

	/**
	 * With group.
	 *
	 * @param group the group
	 * @return the manager history X bean builder
	 */
	public ManagerHistoryXBeanBuilder withGroup(String group) {
		this.group = group;
		return this;
	}

	/**
	 * With tyres.
	 *
	 * @param tyres the tyres
	 * @return the manager history X bean builder
	 */
	public ManagerHistoryXBeanBuilder withTyres(String tyres) {
		this.tyres = tyres;
		return this;
	}

	/**
	 * With position.
	 *
	 * @param position the position
	 * @return the manager history X bean builder
	 */
	public ManagerHistoryXBeanBuilder withPosition(String position) {
		this.position = position;
		return this;
	}

	/**
	 * With wins.
	 *
	 * @param wins the wins
	 * @return the manager history X bean builder
	 */
	public ManagerHistoryXBeanBuilder withWins(String wins) {
		this.wins = wins;
		return this;
	}

	/**
	 * With podiums.
	 *
	 * @param podiums the podiums
	 * @return the manager history X bean builder
	 */
	public ManagerHistoryXBeanBuilder withPodiums(String podiums) {
		this.podiums = podiums;
		return this;
	}

	/**
	 * With poles.
	 *
	 * @param poles the poles
	 * @return the manager history X bean builder
	 */
	public ManagerHistoryXBeanBuilder withPoles(String poles) {
		this.poles = poles;
		return this;
	}

	/**
	 * With fastest laps.
	 *
	 * @param fastestLaps the fastest laps
	 * @return the manager history X bean builder
	 */
	public ManagerHistoryXBeanBuilder withFastestLaps(String fastestLaps) {
		this.fastestLaps = fastestLaps;
		return this;
	}

	/**
	 * With points.
	 *
	 * @param points the points
	 * @return the manager history X bean builder
	 */
	public ManagerHistoryXBeanBuilder withPoints(String points) {
		this.points = points;
		return this;
	}

	/**
	 * With races.
	 *
	 * @param races the races
	 * @return the manager history X bean builder
	 */
	public ManagerHistoryXBeanBuilder withRaces(String races) {
		this.races = races;
		return this;
	}

	/**
	 * With cup.
	 *
	 * @param cup the cup
	 * @return the manager history X bean builder
	 */
	public ManagerHistoryXBeanBuilder withCup(String cup) {
		this.cup = cup;
		return this;
	}

	/**
	 * With money.
	 *
	 * @param money the money
	 * @return the manager history X bean builder
	 */
	public ManagerHistoryXBeanBuilder withMoney(String money) {
		this.money = money;
		return this;
	}
	
	/**
	 * With obr.
	 *
	 * @param obr the obr
	 * @return the manager history X bean builder
	 */
	public ManagerHistoryXBeanBuilder withObr(String obr) {
		this.obr = obr;
		return this;
	}
}
