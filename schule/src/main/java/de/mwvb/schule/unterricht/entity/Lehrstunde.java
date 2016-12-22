package de.mwvb.schule.unterricht.entity;

import java.util.ArrayList;
import java.util.List;

import de.mwvb.schule.ressourcen.entity.Raum;
import de.mwvb.schule.ressourcen.entity.Ressource;
import de.mwvb.schule.schueler.entity.Klasse;

/**
 * Ein Lehrer gibt einer Klasse eine Lehrstunde.
 */
public class Lehrstunde extends Fach {
	private final Klasse klasse;
	private final List<Ressource> ressourcen = new ArrayList<>();
	
	public Lehrstunde(String bezeichnung, Klasse klasse) {
		super(bezeichnung);
		if (klasse == null) {
			throw new IllegalArgumentException("klasse darf nicht null sein!");
		}
		this.klasse = klasse;
	}

	public Klasse getKlasse() {
		return klasse;
	}

	/**
	 * @return z.B. Raum, Beamer
	 */
	public List<Ressource> getRessourcen() {
		return ressourcen;
	}

	public Raum getRaum() {
		return (Raum) ressourcen.stream().filter(r -> r instanceof Raum).findFirst().orElse(null);
	}

	@Override
	public String toString() {
		return pad(getBezeichnung()) + "." + klasse.getName4();
	}
}
