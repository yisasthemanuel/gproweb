package org.jlobato.gpro.web.session;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.List;

import org.jlobato.gpro.web.parser.GPROWebParserFactory;
import org.jlobato.gpro.web.parser.TrackRecordParser;
import org.jlobato.gpro.web.xbean.ManagerHistoryXBean;
import org.jlobato.gpro.web.xbean.TrackRecordSetXBean;
import org.jlobato.gpro.web.xbean.TrackRecordSetXBeanBuilder;
import org.jlobato.gpro.web.xbean.TrackRecordXBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class GPROWebSessionSeleniumHQ.
 */

/** The Constant log. */
@Slf4j
public class GPROWebSessionSeleniumHQ implements GPROWebSession {
	
	
	/** The Constant CSS_AGREE_BUTTON. */
	private static final String CSS_AGREE_BUTTON = ".css-rznlvj";

	/** The Constant DEFAULT_IMPLICIT_WAIT. */
	private static final int DEFAULT_IMPLICIT_WAIT = 2;

	/** The Constant DRIVER_SERVICE. */
	private static final ChromeDriverService DRIVER_SERVICE;
	
	/** The Constant DRIVER_SERVICE. */
	private static final ChromeOptions DRIVER_OPTIONS;
	
	static {
		//Lanzamos el setup antes de nada para asegurar que el driver de chrome está disponible para los tests
		WebDriverManager.chromedriver().setup();
		
		DRIVER_SERVICE = new ChromeDriverService.Builder()
			.withVerbose(false)
			.usingAnyFreePort()
			.build();
		
		try {
			DRIVER_SERVICE.start();
		} catch (IOException e) {
			log.error("Error al iniciar el servicio de Chrome", e);
		}
		
		DRIVER_OPTIONS = new ChromeOptions();		
		DRIVER_OPTIONS.addArguments("--headless"); //Para que no genere interfaz gráfica
		DRIVER_OPTIONS.addArguments("--disable-gpu"); // Especifico para Windows, puede ser útil para otros sistemas operativos
		
		//Aseguramos que cuando se cierre la máquina virtual se pare el servicio de Chrome
		Runtime.getRuntime().addShutdownHook(new Thread(DRIVER_SERVICE::stop));
	}

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
	
	/** The driver. */
	private WebDriver driver;
	

	/**
	 * Instantiates a new GPRO web session selenium HQ.
	 *
	 * @param url the url
	 * @param username the username
	 * @param password the password
	 */
	public GPROWebSessionSeleniumHQ(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
		this.driver = new ChromeDriver(DRIVER_SERVICE, DRIVER_OPTIONS);
		// Espera general para obtener un elemento de las páginas
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_IMPLICIT_WAIT));
	}

	/**
	 * Login.
	 */
	@Override
	public void login() {
		log.info("Logging into GPRO");
		//TODO Si falla al hacer login, devolvemos una sesión inválida
		if (isLogged()) {
			throw new IllegalStateException("You are already logged in");
		}
		try {
			
			// 1 Visitamos la página de login
			this.driver.get(this.url);
			
			// 2 Sale el modal de las cookies. Buscamos el botón con el texto "AGREE" y hacemos click sobre él
			//   para desbloquear los campos de login. Como la URL que pedimos es la que está en inglés, no tenemos
			//   que tener en cuenta el idioma
			driver.findElement(By.cssSelector(CSS_AGREE_BUTTON)).click();
			
			// 3 Aseguramos que está botón de logado antes de hacer el login, esperamos como máximo 3 segundos
			WebElement loginButton = this.driver.findElement(By.name(SUBMIT_BUTTON_LABEL));
			Wait<WebDriver> waitLoginButton = new WebDriverWait(driver, Duration.ofSeconds(3));
			waitLoginButton.until(d -> loginButton.isDisplayed());
			
			// 4 Mandamos el usuario 
			this.driver.findElement(By.name(LOGIN_FIELD_NAME)).sendKeys(this.username);
			
			// 5 Mandamos el password 
			this.driver.findElement(By.name(PASSWORD_FIELD_NAME)).sendKeys(this.password);
			
			// 6 Pulsamos sobre el botón de login
			this.driver.findElement(By.name(SUBMIT_BUTTON_LABEL)).click();
			
			// 7 Si ha ido bien, marcamos que esta sesión es de un usuario logado
			this.logged = true;
			
			// 8 Vamos a la página de Account Settings para ver si está seleccionado el check 'Use new style office design'
			this.driver.findElement(By.linkText("Account Settings")).click();
			// 9 Esperamos 3 segundos a que esté disponible el elemento
			WebElement newStyleOffice = this.driver.findElement(By.id("cbNewOffice"));
			Wait<WebDriver> waitCheckbox = new WebDriverWait(driver, Duration.ofSeconds(3));
			waitCheckbox.until(d -> newStyleOffice.isDisplayed());
			
			// 10 Parseamos el valor del checkbox y lo guardamos
			this.newStyle = GPROWebParserFactory.getNewStyleParser().isNewStyle(this.driver.getPageSource());
			
			// 11 Vamos a averiguar ahora el id del manager que se ha logado. Para ello,
			// sin salir de la página de Account Settings, obtenemos el nombre del manager
			String managerFirstName = this.driver.findElement(By.name("FName")).getAttribute("value");
			String managerSecondName = this.driver.findElement(By.name("LName")).getAttribute("value");
			String managerName = managerFirstName + " " + managerSecondName;
			
			// 12 Volvemos al home
			this.driver.findElement(By.linkText("Home")).click();
			
			// 12+1 Esperamos 4 segundos a que esté disponible el link
			WebElement managerLink = this.driver.findElement(By.linkText(managerName));
			Wait<WebDriver> waitLink = new WebDriverWait(driver, Duration.ofSeconds(4));
			waitLink.until(d -> managerLink.isDisplayed());
			
			// 14 Obtenemos el id del manager para el que se abre la sesión
			this.idManager = GPROWebParserFactory.getIDLoggedManagerParser().getIDLoggerManager(this.driver.getPageSource());
			log.info("Logged into GPRO. New style is: {}. Manager ID is: {} ", this.newStyle, this.idManager);
		} catch (Exception e) {
			this.logged = false;
			log.error("Excepción durante el logado en GPRO", e);
		}

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
	 * Checks if is logged.
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
		return this.idManager;
	}

	/**
	 * Gets the manager history.
	 *
	 * @param theOtherManager the the other manager
	 * @return the manager history
	 */
	@Override
	public List<ManagerHistoryXBean> getManagerHistory(String theOtherManager) {
		log.info("Trying to get Manager History for Manager with id {}", theOtherManager);
		whenNotLogged("You are not logged in while trying to get manager history for ID " + theOtherManager);
		
		//TODO - Delegar en un objeto URIComponentBuilder
		String managerHistoryPage = MessageFormat.format(GPROWebSession.MANAGER_PAGE_PATTERN, theOtherManager);
		this.driver.get(managerHistoryPage);
		
		//Aseguramos que está el link, esperando 3 segundos como máximo
		WebElement managerHistoryLink = this.driver.findElement(By.id(GPROWebSession.MANAGER_HISTORY_LINK_NAME));
		Wait<WebDriver> waitManagerHistoryLink = new WebDriverWait(driver, Duration.ofSeconds(3));
		waitManagerHistoryLink.until(d -> managerHistoryLink.isDisplayed());
				
		return GPROWebParserFactory.getManagerHistoryParser().getManagerHistoryInfo(this.driver.getPageSource());
	}

	/**
	 * Gets the track records info.
	 *
	 * @param idTrack the id track
	 * @return the track records info
	 */
	@Override
	public TrackRecordSetXBean getTrackRecordsInfo(String idTrack) {
		log.info("Trying to get bests laps for track with id {}", idTrack);
		whenNotLogged("You are not logged in while trying to get team records track with ID " + idTrack);
		
		TrackRecordSetXBeanBuilder builder = TrackRecordSetXBeanBuilder.newTrackRecordSetXBeanBuilder();
		
		//TODO - Delegar en un objeto URIComponentBuilder
		String teamQualyRecordsPage = MessageFormat.format(GPROWebSession.TEAM_Q_RECORDS_PAGE_PATTERN, idTrack);
		this.driver.get(teamQualyRecordsPage);
		
		//Esperemos a que esté la información disponible - 3 segundos
		waitForTeamRecordsTable(3);	    
		//Parseamos y obtenermos la información		
		TrackRecordXBean dryQualyRecord = GPROWebParserFactory.getTrackRecordParser().getTrackRecordInfo(this.driver.getPageSource());
		log.info("Bests dry qualy laps for track with id {}: {}", idTrack, dryQualyRecord);
		
		//TODO - Delegar en un objeto URIComponentBuilder
		String teamRaceRecordsPage = MessageFormat.format(GPROWebSession.TEAM_R_RECORDS_PAGE_PATTERN, idTrack);
		this.driver.get(teamRaceRecordsPage);
		
		//Esperemos a que esté la información disponible - 3 segundos
		waitForTeamRecordsTable(3);		
		//Parseamos y obtenermos la información		
		TrackRecordXBean dryRaceRecord = GPROWebParserFactory.getTrackRecordParser().getTrackRecordInfo(this.driver.getPageSource());
		log.info("Bests dry race laps for track with id {}: {}", idTrack, dryRaceRecord);

		//TODO - Delegar en un objeto URIComponentBuilder
		String teamQualyRecordsWetPage = MessageFormat.format(GPROWebSession.TEAM_Q_WET_RECORDS_PAGE_PATTERN, idTrack);
		this.driver.get(teamQualyRecordsWetPage);
		
		//Esperemos a que esté la información disponible - 3 segundos
		waitForTeamRecordsTable(3);
		//Parseamos y obtenermos la información		
		TrackRecordXBean wetQualyRecord = GPROWebParserFactory.getTrackRecordParser().getTrackRecordInfo(this.driver.getPageSource());
		log.info("Bests wet qualy laps for track with id {}: {}", idTrack, wetQualyRecord);
		
		//TODO - Delegar en un objeto URIComponentBuilder
		String teamRaceRecordsWetPage = MessageFormat.format(GPROWebSession.TEAM_R_WET_RECORDS_PAGE_PATTERN, idTrack);
		this.driver.get(teamRaceRecordsWetPage);
		
		//Esperemos a que esté la información disponible - 3 segundos
		waitForTeamRecordsTable(3);
		//Parseamos y obtenermos la información		
		TrackRecordXBean wetRaceRecord = GPROWebParserFactory.getTrackRecordParser().getTrackRecordInfo(this.driver.getPageSource());
		log.info("Bests wet race laps for track with id {}: {}", idTrack, wetRaceRecord);
		
		return builder
			.withQualyRecordDry(dryQualyRecord)
			.withRaceRecordDry(dryRaceRecord)
			.withQualyRecordWet(wetQualyRecord)
			.withRaceRecordWet(wetRaceRecord)
			.build();
	}

	/**
	 * Wait for team records table.
	 *
	 * @param seconds the seconds
	 */
	private void waitForTeamRecordsTable(int seconds) {
		WebElement table = driver.findElement(By.id(TrackRecordParser.RECORDS_TABLE_ID));
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	    wait.until(d -> table.isDisplayed());
	}

	/**
	 * Logout.
	 */
	@Override
	public void logout() {
		whenNotLogged("You are not logged in while trying to log out");
		this.driver.findElement(By.linkText("Logout")).click();
		this.logged = false;
	}
	
	/**
	 * When not logged.
	 *
	 * @param message the message
	 */
	private void whenNotLogged(String message) {
		//TODO - Pasar a una clase común (código repetido)
		if (!isLogged()) {
			log.error("Trying to get information from invalid session");
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
		this.driver.quit();
	}

}
