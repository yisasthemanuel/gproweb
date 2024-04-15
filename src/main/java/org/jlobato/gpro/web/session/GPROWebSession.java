package org.jlobato.gpro.web.session;

import java.util.List;

import org.jlobato.gpro.web.xbean.ManagerHistoryXBean;
import org.jlobato.gpro.web.xbean.TrackRecordSetXBean;

/**
 * The Interface GPROWebSession.
 */
public interface GPROWebSession {

	/** The Constant MANAGER_PAGE_PATTERN. */
	String MANAGER_PAGE_PATTERN = "https://gpro.net/gb/ManagerProfile.asp?IDM={0}";
	/** The Constant MANAGER_HISTORY_LINK_NAME. */
	String MANAGER_HISTORY_LINK_NAME = "lnkmanhistory";
	/** The Constant TEAM_Q_RECORDS_PAGE_PATTERN. */
	String TEAM_Q_RECORDS_PAGE_PATTERN = "https://gpro.net/gb/Stats.asp?type=trackbestqlaps&stype=team&trackId={0}#scroll";
	/** The Constant TEAM_Q_RECORDS_PAGE_PATTERN. */
	String TEAM_R_RECORDS_PAGE_PATTERN = "https://gpro.net/gb/Stats.asp?type=trackbestrlaps&stype=team&trackId={0}#scroll";
	/** The Constant TEAM_Q_RECORDS_PAGE_PATTERN. */
	String TEAM_Q_WET_RECORDS_PAGE_PATTERN = "https://gpro.net/gb/Stats.asp?type=trackbestqlapswet&stype=team&trackId={0}#scroll";
	/** The Constant TEAM_Q_RECORDS_PAGE_PATTERN. */
	String TEAM_R_WET_RECORDS_PAGE_PATTERN = "https://gpro.net/gb/Stats.asp?type=trackbestrlapswet&stype=team&trackId={0}#scroll";
	/** The Constant SUBMIT_BUTTON_LABEL. */
	String SUBMIT_BUTTON_LABEL = "LogonFake";
	/** The Constant LOGIN_FIELD_NAME. */
	String LOGIN_FIELD_NAME = "textLogin";
	/** The Constant PASSWORD_FIELD_NAME. */
	String PASSWORD_FIELD_NAME = "textPassword";

	/**
	 * Login.
	 */
	public void login();

	/**
	 * Checks if is new style.
	 *
	 * @return true, if is new style
	 */
	public boolean isNewStyle();

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername();

	/**
	 * Si ya está la sesión creada o no.
	 *
	 * @return true, if is logged
	 */
	public boolean isLogged();

	/**
	 * Gets the id manager.
	 *
	 * @return the id manager
	 */
	public String getIdManager();

	/**
	 * Gets the manager history.
	 *
	 * @param theOtherManager the id manager
	 * @return the manager history
	 */
	public List<ManagerHistoryXBean> getManagerHistory(String theOtherManager);

	/**
	 * Gets the track records info.
	 *
	 * @param idTrack the id track
	 * @return the track records info
	 */
	public TrackRecordSetXBean getTrackRecordsInfo(String idTrack);

	/**
	 * Logout.
	 */
	public void logout();
	
	/**
	 * Quit.
	 */
	public void quit();

}