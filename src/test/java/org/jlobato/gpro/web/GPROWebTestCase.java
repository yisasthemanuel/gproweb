package org.jlobato.gpro.web;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jlobato.gpro.web.session.GPROWebSession;
import org.jlobato.gpro.web.xbean.ManagerHistoryXBean;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The Class GPROWebTestCase.
 */
public class GPROWebTestCase {
	static GPROWebSession session;
	
	Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Before all tests.
	 */
	@BeforeClass
	public static void beforeAllTests() {
		session = new GPROWebSession("https://www.gpro.net", "yisasthemanuel", "oxford");
		session.login();
	}
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	private GPROWebSession getSession() {
		return session;
	}

	/**
	 * Test login.
	 */
	@Test
	public void testLogin() {
		GPROWebSession theSession = getSession();
		Assert.assertEquals("testLogin", true, theSession.isLogged());
	}

	/**
	 * Test is new style.
	 */
	@Test
	public void testIsNewStyle() {
		GPROWebSession theSession = getSession();
		Assert.assertEquals("testIsNewStyle", true, theSession.isNewStyle());
	}

	/**
	 * Test get username.
	 */
	@Test
	public void testGetUsername() {
		GPROWebSession theSession = getSession();
		Assert.assertEquals("testGetUsername", "yisasthemanuel", theSession.getUsername());
	}

	/**
	 * Test is logged.
	 */
	@Test
	public void testIsLogged() {
		GPROWebSession theSession = getSession();
		Assert.assertEquals("testIsLogged", true, theSession.isLogged());
	}

	/**
	 * Test get id manager.
	 */
	@Test
	public void testGetIdManager() {
		GPROWebSession theSession = getSession();
		Assert.assertEquals("testGetIdManager", "113612", theSession.getIdManager());
	}
	
	/**
	 * Test manager history.
	 */
	@Test
	public void testManagerHistory() {
		GPROWebSession theSession = getSession();
		List<ManagerHistoryXBean> history = theSession.getManagerHistory("113612");
		Iterator<ManagerHistoryXBean> it = history.iterator();
		while (it.hasNext()) {
			ManagerHistoryXBean seasonBean = it.next();
			if (seasonBean.getSeason().equals("97")) {
				Assert.assertEquals("A-43", seasonBean.getGroup());
				Assert.assertEquals("5", seasonBean.getPosition());
				Assert.assertEquals("43", seasonBean.getPoints());
			}
			if (seasonBean.getSeason().equals("74")) {
				Assert.assertEquals("A-82", seasonBean.getGroup());
				Assert.assertEquals("6", seasonBean.getPosition());
				Assert.assertEquals("2", seasonBean.getFastestLaps());
				Assert.assertEquals("3", seasonBean.getWins());
				Assert.assertEquals("1209", seasonBean.getObr());
			}
			if (seasonBean.getSeason().equals("43")) {
				Assert.assertEquals("M-5", seasonBean.getGroup());
				Assert.assertEquals("R1", seasonBean.getCup());
				Assert.assertEquals("1", seasonBean.getPodiums());
			}
			if (seasonBean.getSeason().equals("17")) {
				Assert.assertEquals("R-79", seasonBean.getGroup());
				Assert.assertEquals("0", seasonBean.getPoles());
				Assert.assertEquals("4", seasonBean.getPodiums());
				Assert.assertEquals("9", seasonBean.getRaces());
				Assert.assertEquals("$9.792.948", seasonBean.getMoney());
			}
			if (seasonBean.getSeason().equals("87") || seasonBean.getSeason().equals("86")) {
				Assert.assertEquals("Elite", seasonBean.getGroup());
			}
		}
	}
	
	/**
	 * Logout.
	 */
	@AfterClass
	public static void logout() {
		session.logout();
	}

}
