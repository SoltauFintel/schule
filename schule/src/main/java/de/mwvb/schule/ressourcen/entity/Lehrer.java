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

	/**
	 * @param name üblicherweise Kurzbezeichnung bestehend aus genau 2 Großbuchstaben
	 */
	public Lehrer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/**
	 * @return alle Fächer, die der Lehrer unterrichtet
	 */
	public List<Fach> getFaecher() {
		return faecher;
	}

	public Zeitplan getAnwesenheiten() {
		return anwesenheiten;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lehrer other = (Lehrer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
