package org.jlobato.gpro.web.session;

import java.text.MessageFormat;
import java.util.List;

import org.jlobato.gpro.web.parser.GPROWebParserFactory;
import org.jlobato.gpro.web.xbean.ManagerHistoryXBean;

import net.sourceforge.jwebunit.junit.WebTester;

/**
 * The Class GPROWebSession.
 *
 * @author 
 */
public class GPROWebSession {
	
	/** The Constant SUBMIT_BUTTON_LABEL. */
	private static final String SUBMIT_BUTTON_LABEL = "LogonFake";

	/** The Constant LOGIN_FIELD_NAME. */
	private static final String LOGIN_FIELD_NAME = "textLogin";

	/** The Constant PASSWORD_FIELD_NAME. */
	private static final String PASSWORD_FIELD_NAME = "textPassword";

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

	/** The Constant MANAGER_PAGE_PATTERN. */
	public static final String MANAGER_PAGE_PATTERN = "https://www.gpro.net/gb/ManagerProfile.asp?IDM={0}";

	/** The Constant MANAGER_HISTORY_LINK_NAME. */
	public static final String MANAGER_HISTORY_LINK_NAME = "lnkmanhistory";
	
	/**
	 * Instantiates a new GPRO web session.
	 *
	 * @param url the url
	 * @param username the username
	 * @param password the password
	 */
	public GPROWebSession(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
		this.tester = new WebTester();
	}
	
	
	/**
	 * Login.
	 */
	public void login() {
		//TODO Si falla al hacer login, devolvemos una sesión inválida
		if (isLogged()) {
			throw new IllegalStateException("You are already logged in");
		}
		tester.setScriptingEnabled(false);
		tester.beginAt(this.url);
		tester.assertSubmitButtonPresent(SUBMIT_BUTTON_LABEL);
		
		tester.setTextField(LOGIN_FIELD_NAME, this.username);
		tester.setTextField(PASSWORD_FIELD_NAME, this.password);
		
		tester.submit();
		
		//TODO meter el lenguaje
		//this.language = getLanguage(tester);
		
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
	public boolean isNewStyle() {
		return newStyle;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Si ya está la sesión creada o no.
	 *
	 * @return true, if is logged
	 */
	public boolean isLogged() {
		return logged;
	}
	
	/**
	 * Gets the id manager.
	 *
	 * @return the id manager
	 */
	public String getIdManager() {
		return idManager;
	}
	
	/**
	 * Gets the manager history.
	 *
	 * @param idManager the id manager
	 * @return the manager history
	 */
	public List<ManagerHistoryXBean> getManagerHistory(String idManager) {
		//TODO - Manejo de excepciones
		if (!isLogged()) {
			throw new IllegalStateException("You are not logged in while trying to get manager history for ID " + idManager);
		}
		
		//TODO - Delegar en un objeto PageSourceHandler
		String managerHistoryPage = MessageFormat.format(GPROWebSession.MANAGER_PAGE_PATTERN, idManager);
		this.tester.gotoPage(managerHistoryPage);
		
		//Aseguramos que está el link
		this.tester.assertLinkPresent(GPROWebSession.MANAGER_HISTORY_LINK_NAME);
		
		return GPROWebParserFactory.getManagerHistoryParser().getManagerHistoryInfo(this.tester.getPageSource());
		
	}
	
	/**
	 * Logout.
	 */
	public void logout() {
		if (!isLogged()) {
			throw new IllegalStateException("You are not logged in while trying to log out");
		}
		
		this.tester.assertLinkPresentWithText("Logout");
		this.tester.clickLinkWithText("Logout");
	}

}
