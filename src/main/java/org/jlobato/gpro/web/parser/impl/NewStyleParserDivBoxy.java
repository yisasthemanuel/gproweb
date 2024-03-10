package org.jlobato.gpro.web.parser.impl;

import org.jlobato.gpro.web.parser.NewStyleParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * The Class NewStyleParserDivBoxy.
 */
public class NewStyleParserDivBoxy implements NewStyleParser {

	private static final String DIV_BOXY = "div.boxy";

	/**
	 * Checks if is new style.
	 *
	 * @param htmlSource the html source
	 * @return true, if is new style
	 */
	@Override
	public boolean isNewStyle(String htmlSource) {
		boolean result = true;
		
		Document doc = Jsoup.parse(htmlSource);
		
		Elements divsBoxy = doc.select(DIV_BOXY);
		result = !divsBoxy.isEmpty();

		return result;
	}

}
