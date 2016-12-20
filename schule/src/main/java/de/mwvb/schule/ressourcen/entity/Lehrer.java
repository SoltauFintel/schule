package de.mwvb.schule.ressourcen.entity;

import java.util.ArrayList;
import java.util.List;

import de.mwvb.schule.unterricht.entity.Fach;
import de.mwvb.schule.zeitplan.entity.Zeitplan;

/**
 * Ein Lehrer unterrichtet eine Klasse in gewissen Lehrfächern.
 * Falls ein Lehrer an mehreren Schulen unterrichtet, ist er nicht zu jeder Zeit verfügbar.
 */
public class Lehrer implements Ressource {
	private final String name;
	private final List<Fach> faecher = new ArrayList<>();
	private final Zeitplan anwesenheiten = new Zeitplan();

	public Lehrer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Fach> getFaecher() {
		return faecher;
	}

	public Zeitplan getAnwesenheiten() {
		return anwesenheiten;
	}
}
