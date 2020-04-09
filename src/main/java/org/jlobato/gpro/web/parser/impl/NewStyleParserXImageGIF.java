package org.jlobato.gpro.web.parser.impl;

import org.jlobato.gpro.web.parser.NewStyleParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class NewStyleParserXImageGIF implements NewStyleParser {

	@Override
	public boolean isNewStyle(String htmlSource) {
		boolean result = true;
		
		Document doc = Jsoup.parse(htmlSource);
		
		//Que exista la imagen con el src esperado
		result = !doc.select("img[src=" + NewStyleParser.NEW_STYLE_IMAGE_PRESENT + "]").isEmpty();
		
		return result;
	}

}
