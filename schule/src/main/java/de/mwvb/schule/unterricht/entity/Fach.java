package de.mwvb.schule.unterricht.entity;

public abstract class Fach {
	private final String bezeichnung;
	
	/**
	 * @param bezeichnung meist Kurzbezeichnung (1-2 Großbuchstaben), z.B. "PH" für Physik, "M" für Mathematik
	 */
	public Fach(String bezeichnung) {
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
}
