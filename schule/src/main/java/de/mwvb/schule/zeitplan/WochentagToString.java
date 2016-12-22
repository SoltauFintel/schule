package de.mwvb.schule.zeitplan;

import de.mwvb.schule.unterricht.entity.Fach;
import de.mwvb.schule.zeitplan.entity.Wochentag;

public class WochentagToString {
	public static String freistunde = "     ";
	private final Wochentag<Fach> wt;
	private final int anzahlStunden;

	public WochentagToString(Wochentag<Fach> wt) {
		this(wt, 0);
	}
	
	public WochentagToString(Wochentag<Fach> wt, int anzahlStunden) {
		this.wt = wt;
		this.anzahlStunden = anzahlStunden;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int bis = anzahlStunden >= 1 ? anzahlStunden : wt.getLetzteStunde();
		for (int s = 1; s <= bis; s++) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			Fach fach = wt.get(s);
			sb.append(fach == null ? freistunde : fach.toString());
		}
		return wt.getName() + ": " + sb.toString();
	}
}
