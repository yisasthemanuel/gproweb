package org.jlobato.gpro.web.parser.impl;

import org.jlobato.gpro.web.parser.NewStyleParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NewStyleParserDivBoxy implements NewStyleParser {

	@Override
	public boolean isNewStyle(String htmlSource) {
		boolean result = true;
		
		Document doc = Jsoup.parse(htmlSource);
		
		Elements divsBoxy = doc.select("div.boxy");
		result = !divsBoxy.isEmpty();

		return result;
	}

}
