package de.mwvb.schule.schule.entity;

import java.util.ArrayList;
import java.util.List;

import de.mwvb.schule.ressourcen.entity.Kollegium;
import de.mwvb.schule.schueler.entity.Jahrgang;
import de.mwvb.schule.schueler.entity.Klasse;

/**
 * Eine Schule besteht hauptsächlich aus Lehrern (Kollegium) und Schülern (Klassen).
 */
public class Schule {
	private final String name;
	private final Kollegium kollegium = new Kollegium();
	private final List<Klasse> klassen = new ArrayList<Klasse>();

	public Schule(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public Kollegium getKollegium() {
		return kollegium;
	}

	public List<Klasse> getKlassen() {
		return klassen;
	}
	
	public Klasse findeKlasse(String name) {
		for (Klasse k : klassen) {
			if (k.getName().equals(name)) {
				return k;
			}
		}
		throw new RuntimeException("Klasse nicht vorhanden: " + name);
	}
	
	public Jahrgang findeJahrgang(int jahrgang) {
		for (Klasse k : klassen) {
			Jahrgang jg = k.getJahrgang();
			if (jg.getJahrgang() == jahrgang) {
				return jg;
			}
		}
		throw new RuntimeException("Jahrgang nicht vorhanden: " + jahrgang);
	}
}
