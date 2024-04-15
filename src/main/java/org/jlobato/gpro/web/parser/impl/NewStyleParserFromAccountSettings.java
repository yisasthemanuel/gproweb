package org.jlobato.gpro.web.parser.impl;

import org.jlobato.gpro.web.parser.NewStyleParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * The Class NewStyleParserFromAccountSettings.
 */
public class NewStyleParserFromAccountSettings implements NewStyleParser {

	/**
	 * Checks if is new style.
	 *
	 * @param htmlSource the html source
	 * @return true, if is new style
	 */
	@Override
	public boolean isNewStyle(String htmlSource) {
		Document doc = Jsoup.parse(htmlSource);
		Element newStyleCheckbox = doc.select("input[name=cbNewOffice]").first();
		return (newStyleCheckbox != null) && newStyleCheckbox.hasAttr("checked");
	}

}
