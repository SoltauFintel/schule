package de.mwvb.schule.unterricht.entity;

public class Fach implements Comparable<Fach> {
	private final String bezeichnung;
	
	/**
	 * @param bezeichnung meist Kurzbezeichnung (1-2 Großbuchstaben), z.B. "PH" für Physik, "M" für Mathematik
	 */
	public Fach(String bezeichnung) {
		if (bezeichnung == null || bezeichnung.trim().isEmpty()) {
			throw new IllegalArgumentException("bezeichnung muss belegt sein!");
		}
		this.bezeichnung = bezeichnung;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
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
		Fach other = (Fach) obj;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getBezeichnung();
	}
	
	protected String pad(String s) {
		final int len = 2;
		while (s.length() < len) {
			s += " ";
		}
		return s.substring(0, len);
	}

	@Override
	public int compareTo(Fach b) {
		return bezeichnung.compareTo(b.bezeichnung);
	}
}
