package de.mwvb.schule.schueler.entity;

import de.mwvb.schule.lehrplan.entity.Lehrplan;

/**
 * Die Klassen einer Jahrgangsstufe haben die gleichen Rahmenbedingungen (Lehrplan usw.)
 */
public class Jahrgang {
	private final int jahrgang;
	private final Lehrplan lehrplan = new Lehrplan();
	private int maxTag = 5;
	private int maxStunde = 7;

	public Jahrgang(int jahrgang) {
		if (jahrgang < 1) {
			throw new IllegalArgumentException("jahrgang muss größer 0 sein!");
		}
		this.jahrgang = jahrgang;
	}

	public int getJahrgang() {
		return jahrgang;
	}

	public int getMaxTag() {
		return maxTag;
	}

	public void setMaxTag(int maxTag) {
		if (maxTag < 1 || maxTag > 7) {
			throw new IllegalArgumentException("maxTag muss eine Zahl zwischen 1 und 7 sein! Üblich: 5 oder 6");
		}
		this.maxTag = maxTag;
	}

	public int getMaxStunde() {
		if (maxStunde < 1) {
			throw new IllegalArgumentException("maxStunde muss eine Zahl ab 1 sein!");
		}
		return maxStunde;
	}

	public void setMaxStunde(int maxStunde) {
		this.maxStunde = maxStunde;
	}

	public Lehrplan getLehrplan() {
		return lehrplan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + jahrgang;
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
		Jahrgang other = (Jahrgang) obj;
		if (jahrgang != other.jahrgang)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Jahrgang " + jahrgang;
	}
}
