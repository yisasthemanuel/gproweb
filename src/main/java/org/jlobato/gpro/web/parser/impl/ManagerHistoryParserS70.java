package org.jlobato.gpro.web.parser.impl;

import java.util.ArrayList;
import java.util.List;

import org.jlobato.gpro.web.parser.ManagerHistoryParser;
import org.jlobato.gpro.web.parser.ParserConstants;
import org.jlobato.gpro.web.xbean.ManagerHistoryXBean;
import org.jlobato.gpro.web.xbean.ManagerHistoryXBeanBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * The Class ManagerHistoryParserS70.
 */
public class ManagerHistoryParserS70 implements ManagerHistoryParser {

	/**
	 * Gets the manager history info.
	 *
	 * @param htmlSource the html source
	 * @return the manager history info
	 */
	@Override
	public List<ManagerHistoryXBean> getManagerHistoryInfo(String htmlSource) {
		//Si está el link entonces le damos al parseo de la tabla
		Document doc = Jsoup.parse(htmlSource);
		Element divManHistory = doc.getElementById(MANAGER_HISTORY_DIV_NAME);
		Elements managerHistoryTables = divManHistory.getElementsByTag(ParserConstants.TABLE_HTML_TAG);
		Element managerHistoryTable = managerHistoryTables.first();
		Elements rows = managerHistoryTable.getElementsByTag(ParserConstants.HTML_TABLE_ROW_TAG);
		//La fila de los nombres de las columnas no nos interesa
		rows.remove(0);
		
		List<ManagerHistoryXBean> result = new ArrayList<ManagerHistoryXBean>();
		for (Element row : rows) {
			Elements datos = row.getElementsByTag(ParserConstants.HTML_TABLE_COLUMN_TAG);
			int i = 0;
			ManagerHistoryXBeanBuilder managerHistoryBuilder = ManagerHistoryXBeanBuilder.newManagerHistoryXBean();
			for (Element dato: datos) {
				//Season
				switch (i) {
				case 0:
					//Season
					managerHistoryBuilder.withSeason(dato.text());
					break;
				case 1:
					//Categoria grupo
					managerHistoryBuilder.withGroup(dato.getElementsByTag("a").first().text());
					break;
				case 2:
					//Position
					managerHistoryBuilder.withPosition(dato.text());
					break;
				case 3:
					//wins
					managerHistoryBuilder.withWins(dato.text());
					break;
				case 4:
					//Podiums
					managerHistoryBuilder.withPodiums(dato.text());
					break;
				case 5:
					//Poles
					managerHistoryBuilder.withPoles(dato.text());
					break;
				case 6:
					//Fastest laps
					managerHistoryBuilder.withFastestLaps(dato.text());
					break;
				case 7:
					//Points
					managerHistoryBuilder.withPoints(dato.text());
					break;
				case 8:
					//Races
					managerHistoryBuilder.withRaces(dato.text());
					break;
				case 10:
					//Cup
					managerHistoryBuilder.withCup(dato.text());
					break;
				case 11:
					//OBR
					managerHistoryBuilder.withObr(dato.text());
					break;
				case 12:
					//Tyres
					managerHistoryBuilder.withTyres(dato.getElementsByTag("img").first().attr("src"));
					break;
				case 13:
					//Money
					managerHistoryBuilder.withMoney(dato.text());
					break;
				default:
					break;
				}
				
				i++;
			}
			result.add(managerHistoryBuilder.build());
		}
		return result;
	}

}
