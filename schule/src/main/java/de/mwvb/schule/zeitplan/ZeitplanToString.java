package de.mwvb.schule.zeitplan;

import de.mwvb.schule.zeitplan.entity.Zeitplan;

public class ZeitplanToString {
	private final Zeitplan zeitplan;
	private final int anzahlStunden;
	
	public ZeitplanToString(Zeitplan zeitplan) {
		this(zeitplan, 0);
	}

	public ZeitplanToString(Zeitplan zeitplan, int anzahlStunden) {
		this.zeitplan = zeitplan;
		this.anzahlStunden = anzahlStunden;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int tag = 1; tag <= zeitplan.getAnzahlTage(); tag++) {
			sb.append("   ");
			sb.append(new WochentagToString(zeitplan.getWochentag(tag), anzahlStunden).toString());
		}
		return sb.toString();
	}
}
