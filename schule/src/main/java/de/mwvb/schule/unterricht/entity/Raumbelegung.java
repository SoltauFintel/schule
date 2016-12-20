package de.mwvb.schule.unterricht.entity;

import de.mwvb.schule.schueler.entity.Klasse;

/**
 * Ein Raum wird zu einer Stunde von einer Klasse genutzt.
 */
public class Raumbelegung extends Fach {
	private final Klasse klasse;
	
	public Raumbelegung(String bezeichnung, Klasse klasse) {
		super(bezeichnung);
		this.klasse = klasse;
	}

	public Klasse getKlasse() {
		return klasse;
	}
}
