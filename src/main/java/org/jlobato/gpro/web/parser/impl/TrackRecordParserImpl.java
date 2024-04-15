package org.jlobato.gpro.web.parser.impl;

import org.jlobato.gpro.utils.GPROUtils;
import org.jlobato.gpro.web.parser.ParserConstants;
import org.jlobato.gpro.web.parser.TrackRecordParser;
import org.jlobato.gpro.web.xbean.TrackRecordXBean;
import org.jlobato.gpro.web.xbean.TrackRecordXBeanBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * The Class TrackRecordParserImpl.
 */
public class TrackRecordParserImpl implements TrackRecordParser {

	/**
	 * Gets the track record info.
	 *
	 * @param htmlSource the html source
	 * @return the track record info
	 */
	@Override
	public TrackRecordXBean getTrackRecordInfo(String htmlSource) {
		//Si está el link entonces le damos al parseo de la tabla
		Document doc = Jsoup.parse(htmlSource);
		Element teamRecordsTable = doc.getElementById(TrackRecordParser.RECORDS_TABLE_ID);
		Elements rows = teamRecordsTable.getElementsByTag(ParserConstants.HTML_TABLE_ROW_TAG);
		//La fila del record del equipo es la segunda
		Element rowBestTime = rows.get(1);
		Elements cols = rowBestTime.getElementsByTag(ParserConstants.HTML_TABLE_COLUMN_TAG);
		
		// Col 2 -> El nombre del que tiene el record. Hay que quitar el nombre del grupo en el que está el manager
		String manager = cols.get(2).text();
		manager = manager.substring(0, manager.lastIndexOf(" "));
		// Col 2 -> Tiene el link al manager, con lo cual se obtiene el id. El link del manager es el primero de todos, hay que parserarlo
		Elements links = cols.get(2).getElementsByTag(ParserConstants.HTML_LINK_TAG);
		String idManager = GPROUtils.getIDManagerFromLink(links.get(0).attr(ParserConstants.HREF_ATTR_TAG));
		// Col 3 -> El tiempo empleado, hay que quitar la s del final
		String time = cols.get(3).text();
		time = time.substring(0, time.length() - 1);
		// Col 4 -> La diferencia con respecto al record absoluto, hay que quitar la s del final
		String gap = cols.get(4).text();
		gap = gap.substring(0, gap.length() - 1);
		// Col 5 -> Temporada en la que se consiguió el record, hay que parsear la cadena para extraer la temporada
		String season = GPROUtils.getIDSeason(cols.get(5).text());
		// Col 5 -> Temporada en la que se consiguió el record, hay que parsear la cadena para extraer la carrera
		String race = GPROUtils.getIDRace(cols.get(5).text());
		// Col 6 -> Grupo del manager cuando consiguió el record
		String group = cols.get(6).text();
		// Col 7 -> Fecha en la que consiguió el record, hay que parsearla para que tenga el formato que queremos 
		String date = GPROUtils.convertDate(cols.get(7).text());
		
		
		//Qualy dry record
		TrackRecordXBeanBuilder trackRecordBuilder = TrackRecordXBeanBuilder.newTrackRecordXBeanBuilder();
		return trackRecordBuilder
			.withManagerName(manager)
			.withIdManagerGpro(idManager)
			.withLapTime(time)
			.withGap(gap)
			.withSeason(season)
			.withRace(race)
			.withGroup(group)
			.withDate(date)
			.build();
	}

}
