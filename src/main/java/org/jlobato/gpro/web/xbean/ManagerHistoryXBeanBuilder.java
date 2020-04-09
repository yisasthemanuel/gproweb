package org.jlobato.gpro.web.xbean;

public class ManagerHistoryXBeanBuilder {
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

	private ManagerHistoryXBeanBuilder() {
	}

	/**
	 * 
	 * @return
	 */
	public static ManagerHistoryXBeanBuilder newManagerHistoryXBean() {
		return new ManagerHistoryXBeanBuilder();
	}
	
	/**
	 * 
	 * @return
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

	public ManagerHistoryXBeanBuilder withSeason(String season) {
		this.season = season;
		return this;
	}

	public ManagerHistoryXBeanBuilder withGroup(String group) {
		this.group = group;
		return this;
	}

	public ManagerHistoryXBeanBuilder withTyres(String tyres) {
		this.tyres = tyres;
		return this;
	}

	public ManagerHistoryXBeanBuilder withPosition(String position) {
		this.position = position;
		return this;
	}

	public ManagerHistoryXBeanBuilder withWins(String wins) {
		this.wins = wins;
		return this;
	}

	public ManagerHistoryXBeanBuilder withPodiums(String podiums) {
		this.podiums = podiums;
		return this;
	}

	public ManagerHistoryXBeanBuilder withPoles(String poles) {
		this.poles = poles;
		return this;
	}

	public ManagerHistoryXBeanBuilder withFastestLaps(String fastestLaps) {
		this.fastestLaps = fastestLaps;
		return this;
	}

	public ManagerHistoryXBeanBuilder withPoints(String points) {
		this.points = points;
		return this;
	}

	public ManagerHistoryXBeanBuilder withRaces(String races) {
		this.races = races;
		return this;
	}

	public ManagerHistoryXBeanBuilder withCup(String cup) {
		this.cup = cup;
		return this;
	}

	public ManagerHistoryXBeanBuilder withMoney(String money) {
		this.money = money;
		return this;
	}
	
	public ManagerHistoryXBeanBuilder withObr(String obr) {
		this.obr = obr;
		return this;
	}
}
