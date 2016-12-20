package de.mwvb.schule.lehrplan.entity;

import de.mwvb.schule.unterricht.entity.Fach;

/**
 * Hält alle Daten, die für die Regelprüfung erforderlich sind.
 */
public class Regelkontext {
	private int tag;
	private int stunde;
	private Fach fach;
	// TODO weitere Attribute...

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public int getStunde() {
		return stunde;
	}

	public void setStunde(int stunde) {
		this.stunde = stunde;
	}

	public Fach getFach() {
		return fach;
	}

	public void setFach(Fach fach) {
		this.fach = fach;
	}
}
