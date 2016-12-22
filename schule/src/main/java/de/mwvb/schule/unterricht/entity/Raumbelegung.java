package de.mwvb.schule.unterricht.entity;

import de.mwvb.schule.schueler.entity.Klasse;

/**
 * Ein Raum wird zu einer Stunde von einer Klasse genutzt.
 */
public class Raumbelegung extends Fach {
	private final Klasse klasse;
	
	public Raumbelegung(String bezeichnung, Klasse klasse) {
		super(bezeichnung);
		if (klasse == null) {
			throw new IllegalArgumentException("klasse darf nicht null sein!");
		}
		this.klasse = klasse;
	}

	public Klasse getKlasse() {
		return klasse;
	}
	
	@Override
	public String toString() {
		return pad(getBezeichnung()) + "." + klasse.getName4();
	}
}
