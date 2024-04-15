package org.jlobato.gpro.web.session;

import java.util.List;

import org.jlobato.gpro.web.xbean.ManagerHistoryXBean;
import org.jlobato.gpro.web.xbean.TrackRecordSetXBean;

import lombok.extern.log4j.Log4j2;

/**
 * A factory for creating GPROWebSession objects.
 *
 * @author 
 */
@Log4j2
public class GPROWebSessionFactory {
	
	/**
	 * Gets the GPRO web session.
	 *
	 * @return the GPRO web session
	 */
	public static GPROWebSession getGPROWebSession() {
		//TODO ver cómo manejar las propiedades de conexión
		return new GPROWebSessionSeleniumHQ("https://gpro.net/gb/gpro.asp", "yisasthemanuel", "oxford");
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		GPROWebSession session = GPROWebSessionFactory.getGPROWebSession();
		
		session.login();
		
		log.debug("Logged in: {}",  session.isLogged());
		log.debug("New Style: {}", session.isNewStyle());
		log.debug("Manager ID: {}", session.getIdManager());
		List<ManagerHistoryXBean> managerHistory = session.getManagerHistory("52243");
		log.debug("Manager history: {}", managerHistory);
		
		managerHistory = session.getManagerHistory(session.getIdManager());
		log.debug("Logged Manager history: {}", managerHistory);
		
		TrackRecordSetXBean trackRecordInfo = session.getTrackRecordsInfo("41");
		log.debug("Track Record Info: {}", trackRecordInfo);
		
		trackRecordInfo = session.getTrackRecordsInfo("13");
		log.debug("Track Record Info: {}", trackRecordInfo);
		
		session.logout();
		log.debug("Logged out. Now exiting...");
		
		session.quit();
	}

}
