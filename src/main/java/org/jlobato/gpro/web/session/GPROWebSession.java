package org.jlobato.gpro.web.session;

import java.text.MessageFormat;
import java.util.List;

import org.jlobato.gpro.web.parser.GPROWebParserFactory;
import org.jlobato.gpro.web.xbean.ManagerHistoryXBean;

import net.sourceforge.jwebunit.junit.WebTester;

/**
 * 
 * @author 
 *
 */
public class GPROWebSession {
	
	/**
	 * 
	 */
	private static final String SUBMIT_BUTTON_LABEL = "Submit2";

	/**
	 * 
	 */
	private static final String LOGIN_FIELD_NAME = "textLogin";

	/**
	 * 
	 */
	private static final String PASSWORD_FIELD_NAME = "textPassword";

	/**
	 * 
	 */
	protected WebTester tester;
	
	/**
	 * 
	 */
	private boolean newStyle = false;
	
	/**
	 * 
	 */
	private String url;
	
	/**
	 * 
	 */
	private String username;
	
	/**
	 * 
	 */
	private String password;
	
	/**
	 * 
	 */
	private String idManager;

	/**
	 * 
	 */
	private boolean logged;

	/**
	 * 
	 */
	public static final String MANAGER_PAGE_PATTERN = "https://www.gpro.net/gb/ManagerProfile.asp?IDM={0}";

	/**
	 * 
	 */
	public static final String MANAGER_HISTORY_LINK_NAME = "lnkmanhistory";
	
	/**
	 * 
	 * @param url
	 * @param username
	 * @param password
	 */
	public GPROWebSession(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
		this.tester = new WebTester();
	}
	
	
	/**
	 * 
	 */
	public void login() {
		//TODO Si falla al hacer login, devolvemos una sesión inválida
		if (isLogged()) {
			throw new IllegalStateException("You are already logged in");
		}
		tester.setScriptingEnabled(false);
		tester.beginAt(this.url);
		tester.assertButtonPresent(SUBMIT_BUTTON_LABEL);
		
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
	 * 
	 * @return
	 */
	public boolean isNewStyle() {
		return newStyle;
	}

	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Si ya está la sesión creada o no
	 * 
	 * @return
	 */
	public boolean isLogged() {
		return logged;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getIdManager() {
		return idManager;
	}
	
	/**
	 * 
	 * @param idManager
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
	 * 
	 */
	public void logout() {
		if (!isLogged()) {
			throw new IllegalStateException("You are not logged in while trying to log out");
		}
		
		this.tester.assertLinkPresentWithText("Logout");
		this.tester.clickLinkWithText("Logout");
	}

}
