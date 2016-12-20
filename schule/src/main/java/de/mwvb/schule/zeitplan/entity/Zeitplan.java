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
		for (int i = 1; i <= anzahlTage; i++) {
			wochentage.add(new Wochentag<Fach>(i));
		}
	}
	
	/**
	 * @param tag 1..7
	 * @return Wochentag
	 */
	public Wochentag<Fach> getWochentag(int tag) {
		if (tag < 1 || tag > 7) {
			throw new IllegalArgumentException("tag muss eine Zahl von 1 bis 7 sein!");
		}
		return wochentage.get(tag - 1);
	}
	
	public int getAnzahlTage() {
		return wochentage.size();
	}

	public boolean isFertig() {
		return fertig;
	}

	public void setFertig(boolean fertig) {
		this.fertig = fertig;
	}
	
	// TODO getAnzahlStunden(int maxTag)
	// TODO getAnzahlStunden() // alle Tage
	// TODO copy
}
