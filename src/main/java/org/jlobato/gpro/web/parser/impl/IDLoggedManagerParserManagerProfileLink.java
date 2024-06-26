package org.jlobato.gpro.web.parser.impl;

import org.jlobato.gpro.utils.GPROUtils;
import org.jlobato.gpro.web.parser.IDLoggedManagerParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * The Class IDLoggedManagerParserManagerProfileLink.
 */
public class IDLoggedManagerParserManagerProfileLink implements IDLoggedManagerParser {

	/**
	 * Gets the ID logger manager.
	 *
	 * @param htmlSource the html source
	 * @return the ID logger manager
	 */
	@Override
	public String getIDLoggerManager(String htmlSource) {
		String result = null;

		Document doc = Jsoup.parse(htmlSource);
		Elements links = doc.select("a[href]");
		boolean countryStats = false;
		for (Element link : links) {
			if (countryStats && (link.attr("href").contains("ManagerProfile"))) {
				result = GPROUtils.getIDManagerFromLink(link.attr("href"));
				break;

			}
			if (link.attr("href").contains("Stats") && link.attr("href").contains("type"))
				countryStats = true;
		}

		return result;
	}

}
