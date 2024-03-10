package org.jlobato.gpro.web.parser;

/**
 * The Interface NewStyleParser.
 */
public interface NewStyleParser {
	
	/** The new style image present. */
	public String NEW_STYLE_IMAGE_PRESENT = "/images/xdriver.gif";

	/**
	 * Checks if is new style.
	 *
	 * @param htmlSource the html source
	 * @return true, if is new style
	 */
	public boolean isNewStyle(String htmlSource);

}
