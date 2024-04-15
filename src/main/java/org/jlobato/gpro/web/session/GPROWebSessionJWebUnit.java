package org.jlobato.gpro.web.session;

import java.text.MessageFormat;
import java.util.List;

import org.jlobato.gpro.web.parser.GPROWebParserFactory;
import org.jlobato.gpro.web.xbean.ManagerHistoryXBean;
import org.jlobato.gpro.web.xbean.TrackRecordSetXBean;
import org.jlobato.gpro.web.xbean.TrackRecordSetXBeanBuilder;
import org.jlobato.gpro.web.xbean.TrackRecordXBean;

import net.sourceforge.jwebunit.junit.WebTester;

/**
 * The Class GPROWebSession.
 *
 * @author 
 */
public class GPROWebSessionJWebUnit implements GPROWebSession {
	
	/** The tester. */
	protected WebTester tester;
	
	/** The new style. */
	private boolean newStyle = false;
	
	/** The url. */
	private String url;
	
	/** The username. */
	private String username;
	
	/** The password. */
	private String password;
	
	/** The id manager. */
	private String idManager;

	/** The logged. */
	private boolean logged;

	/**
	 * Instantiates a new GPRO web session.
	 *
	 * @param url the url
	 * @param username the username
	 * @param password the password
	 */
	public GPROWebSessionJWebUnit(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
		this.tester = new WebTester();
	}
	
	
	/**
	 * Login.
	 */
	@Override
	public void login() {
		//TODO Si falla al hacer login, devolvemos una sesión inválida
		if (isLogged()) {
			throw new IllegalStateException("You are already logged in");
		}
		tester.setScriptingEnabled(false);
		tester.beginAt(this.url);
		tester.assertSubmitButtonPresent(GPROWebSession.SUBMIT_BUTTON_LABEL);
		
		tester.setTextField(GPROWebSession.LOGIN_FIELD_NAME, this.username);
		tester.setTextField(GPROWebSession.PASSWORD_FIELD_NAME, this.password);
		
		tester.submit();
		
		//Aquí es donde va el tema de si el usuario utiliza o no el nuevo estilo de la web
		this.newStyle = GPROWebParserFactory.getNewStyleParser().isNewStyle(this.tester.getPageSource());
		
		//Obtenemos el id del manager para el que se abre la sesión
		this.idManager = GPROWebParserFactory.getIDLoggedManagerParser().getIDLoggerManager(this.tester.getPageSource());
		
		this.logged = true;
	}

	/**
	 * Checks if is new style.
	 *
	 * @return true, if is new style
	 */
	@Override
	public boolean isNewStyle() {
		return newStyle;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/**
	 * Si ya está la sesión creada o no.
	 *
	 * @return true, if is logged
	 */
	@Override
	public boolean isLogged() {
		return logged;
	}
	
	/**
	 * Gets the id manager.
	 *
	 * @return the id manager
	 */
	@Override
	public String getIdManager() {
		return idManager;
	}
	
	/**
	 * Gets the manager history.
	 *
	 * @param theOtherManager the id manager
	 * @return the manager history
	 */
	@Override
	public List<ManagerHistoryXBean> getManagerHistory(String theOtherManager) {
		whenNotLogged("You are not logged in while trying to get manager history for ID " + theOtherManager);
		
		//TODO - Delegar en un objeto PageSourceHandler
		String managerHistoryPage = MessageFormat.format(GPROWebSession.MANAGER_PAGE_PATTERN, theOtherManager);
		this.tester.gotoPage(managerHistoryPage);
		
		//Aseguramos que está el link
		this.tester.assertLinkPresent(GPROWebSession.MANAGER_HISTORY_LINK_NAME);
		
		return GPROWebParserFactory.getManagerHistoryParser().getManagerHistoryInfo(this.tester.getPageSource());
	}
	
	/**
	 * Gets the track records info.
	 *
	 * @param idTrack the id track
	 * @return the track records info
	 */
	@Override
	public TrackRecordSetXBean getTrackRecordsInfo(String idTrack) {
		whenNotLogged("You are not logged in while trying to get team records track with ID " + idTrack);
		
		//TODO - Delegar en un objeto PageSourceHandler
		String teamQualyRecordsPage = MessageFormat.format(GPROWebSession.TEAM_Q_RECORDS_PAGE_PATTERN, idTrack);
		this.tester.gotoPage(teamQualyRecordsPage);
		
		//Aseguramos que está la tabla de records
		//TODO - Pasar a constante
		this.tester.assertTablePresent("Table16");
		
		this.tester.assertSelectOptionValuePresent("group", "291");
		
		this.tester.assertLinkPresentWithExactText("Team ranking");
		
		TrackRecordSetXBeanBuilder builder = TrackRecordSetXBeanBuilder.newTrackRecordSetXBeanBuilder();
		
		//Parseamos y obtenermos la información		
		TrackRecordXBean bestLap = GPROWebParserFactory.getTrackRecordParser().getTrackRecordInfo(this.tester.getPageSource());
		
		return builder
			.withQualyRecordDry(bestLap)
			.build();
	}
	
	/**
	 * Logout.
	 */
	@Override
	public void logout() {
		whenNotLogged("You are not logged in while trying to log out");
		
		this.tester.assertLinkPresentWithText("Logout");
		this.tester.clickLinkWithText("Logout");
		this.logged = false;
	}
	
	/**
	 * When not logged.
	 *
	 * @param message the message
	 */
	private void whenNotLogged(String message) {
		//TODO - Manejo de excepciones
		if (!isLogged()) {
			throw new IllegalStateException(message);
		}
	}


	/**
	 * Quit.
	 */
	@Override
	public void quit() {
		if (isLogged()) {
			logout();
		}
	}

}
