package org.jlobato.gpro.web.session;

import java.util.List;

import org.jlobato.gpro.web.xbean.ManagerHistoryXBean;

/**
 * 
 * @author 
 *
 */
public class GPROWebSessionFactory {
	
	/**
	 * 
	 * @return
	 */
	public static GPROWebSession getGPROWebSession() {
		//TODO ver cómo manejar las propiedades de conexión
		GPROWebSession result = new GPROWebSession("https://www.gpro.net", "yisasthemanuel", "oxford");
		result.login();
		return result;
	}
	
	public static void main(String[] args) {
		GPROWebSession session = GPROWebSessionFactory.getGPROWebSession();
		
		System.out.println("Logged in: " + session.isLogged());
		System.out.println("New Style: " + session.isNewStyle());
		System.out.println("Manager ID: " + session.getIdManager());
		List<ManagerHistoryXBean> managerHistory = session.getManagerHistory("52243");
		System.out.println("Manager history: " + managerHistory);
		
		managerHistory = session.getManagerHistory(session.getIdManager());
		System.out.println("Logged Manager history: " + managerHistory);
		
		session.logout();
		System.out.println("Logged out. Now exiting...");
	}

}
