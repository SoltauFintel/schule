package de.mwvb.schule.zeitplan.entity;

import java.util.ArrayList;
import java.util.List;

import de.mwvb.schule.unterricht.entity.Fach;

/**
 * Ein Zeitplan besteht bspw. aus 5 Wochentagen.
 * Ein Wochentag hat wiederum n Stunden vom Typ Fach.
 */
public class Zeitplan {
	private final List<Wochentag<Fach>> wochentage = new ArrayList<>();
	/** Kann von der Stundenplan-Berechnung auf true gesetzt werden, wenn der Zeitplan als fertig berechnet gilt. */
	private boolean fertig = false;
	
	/**
	 * Zeitplan mit 5 Tagen (Mo-Fr)
	 */
	public Zeitplan() {
		this(false);
	}
	
	/**
	 * Zeitplan mit 5 oder 6 Tagen
	 * 
	 * @param mitSamstag true: Mo-Sa, false: Mo-Fr
	 */
	public Zeitplan(boolean mitSamstag) {
		this(mitSamstag ? 6 : 5);
	}
	
	public Zeitplan(int anzahlTage) {
		if (anzahlTage < 1) { // ohne Obergrenze
			throw new IllegalArgumentException("anzahlTage muss mindestens 1 sein! Übliche Werte sind 5 oder 6.");
		}
		for (int i = 1; i <= anzahlTage; i++) {
			wochentage.add(new Wochentag<Fach>(i));
		}
	}
	
	/** Kopierkonstruktor */
	public Zeitplan(Zeitplan o) {
		o.wochentage.stream().forEach(wt -> wochentage.add(wt.copy()));
		fertig = o.fertig;
	}
	
	/**
	 * @param tag ab 1
	 * @return Wochentag
	 */
	public Wochentag<Fach> getWochentag(int tag) {
		if (tag < 1 || tag > wochentage.size()) {
			throw new IllegalArgumentException("tag muss eine Zahl von 1 bis " + wochentage.size() + " sein!");
			// TODO Testcase inkl. Prüfung des Meldungstextes
		}
		return wochentage.get(tag - 1);
	}
	
	public int getAnzahlTage() {
		return wochentage.size();
	}

	/**
	 * @return true wenn Zeitplan fertig berechnet
	 */
	public boolean isFertig() {
		return fertig;
	}

	public void setFertig(boolean fertig) {
		this.fertig = fertig;
	}
	
	/**
	 * Liefert Anzahl aller Stunden im Zeitplan.
	 */
	public int getAnzahlStunden() {
		return wochentage.stream().mapToInt(wt -> wt.getAnzahlStunden()).sum();
	}
	
	/**
	 * Liefert Anzahl der Stunden von Tag 1 bis Tag maxTag.
	 */
	public int getAnzahlStunden(int maxTag) {
		if (maxTag < 1 || maxTag > wochentage.size() - 1) {
			throw new IllegalArgumentException("maxTag muss eine Zahl zwischen 1 und " + (wochentage.size() - 1) + " sein!");
		}
		// TODO Java 8
		int ret = 0;
		for (int i = 1; i <= maxTag; i++) {
			ret += wochentage.get(i).getAnzahlStunden();
		}
		return ret;
	}
}
