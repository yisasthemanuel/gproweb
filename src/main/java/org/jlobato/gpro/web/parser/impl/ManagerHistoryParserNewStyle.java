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
 * The Class ManagerHistoryParserNewStyle.
 */
public class ManagerHistoryParserNewStyle implements ManagerHistoryParser {

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
		Element divManHistory = doc.getElementById(ManagerHistoryParser.MANAGER_HISTORY_DIV_NAME);
		Elements managerHistoryTables = divManHistory.getElementsByTag(ParserConstants.TABLE_HTML_TAG);
		Element managerHistoryTable = managerHistoryTables.first();
		Elements rows = managerHistoryTable.getElementsByTag(ParserConstants.HTML_TABLE_ROW_TAG);
		//La fila de los nombres de las columnas no nos interesa
		rows.remove(0);
		
		List<ManagerHistoryXBean> result = new ArrayList<ManagerHistoryXBean>();
		for (Element row : rows) {
			Elements datos = row.getElementsByTag(ParserConstants.HTML_TABLE_COLUMN_TAG);
			System.out.println("datos: " + datos.html());
			//Season
			String season = datos.get(0).text();
			//Group
			String group = datos.get(1).getElementsByTag("a").first().text();
			//Tyres
			String tyres = datos.get(11).getElementsByTag("img").first().attr("src");
			//Position
			String position = datos.get(2).text();
			//Wins
			String wins = datos.get(3).text();			
			//Podiums
			String podiums = datos.get(4).text();			
			//Poles
			String poles = datos.get(5).text();
			//Fastest laps
			String fastestLaps = datos.get(6).text();
			//Points
			String points = datos.get(7).text();
			//Races
			String races = datos.get(8).text();
			//Cup
			String cup = datos.get(10).text();
			//Money
			String money = datos.get(12).text();
			
			result.add(ManagerHistoryXBeanBuilder.newManagerHistoryXBean()
					.withSeason(season)
					.withGroup(group)
					.withTyres(tyres)
					.withPosition(position)
					.withWins(wins)
					.withPodiums(podiums)
					.withPoles(poles)
					.withFastestLaps(fastestLaps)
					.withPoints(points)
					.withRaces(races)
					.withCup(cup)
					.withMoney(money).build());
		}
		
		return result;
	}

}
