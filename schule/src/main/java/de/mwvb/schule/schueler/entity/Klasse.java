package de.mwvb.schule.schueler.entity;

import de.mwvb.schule.ressourcen.entity.Lehrer;
import de.mwvb.schule.ressourcen.entity.Raum;

/**
 * Eine Schulklasse.
 */
public class Klasse {
	private final Jahrgang jahrgang;
	private final char buchstabe;
	private int einschulungsjahr;
	private Lehrer klassenlehrer;
	private Raum klassenzimmer;

	public Klasse(Jahrgang jahrgang, char buchstabe) {
		this.jahrgang = jahrgang;
		this.buchstabe = buchstabe;
	}

	public int getEinschulungsjahr() {
		return einschulungsjahr;
	}

	public void setEinschulungsjahr(int einschulungsjahr) {
		this.einschulungsjahr = einschulungsjahr;
	}

	public Lehrer getKlassenlehrer() {
		return klassenlehrer;
	}

	public void setKlassenlehrer(Lehrer klassenlehrer) {
		this.klassenlehrer = klassenlehrer;
	}

	public Raum getKlassenzimmer() {
		return klassenzimmer;
	}

	public void setKlassenzimmer(Raum klassenzimmer) {
		this.klassenzimmer = klassenzimmer;
	}

	public Jahrgang getJahrgang() {
		return jahrgang;
	}

	public char getBuchstabe() {
		return buchstabe;
	}
	
	public String getName() {
		return "" + jahrgang.getJahrgang() + buchstabe;
	}

	/**
	 * @return 4 Zeichen langer Klassenname, z.B. " 5a ", "10fs"
	 */
	public String getName4() {
		String ret;
		if (jahrgang.getJahrgang() < 10) {
			ret = "0" + jahrgang.getJahrgang();
		} else {
			ret = "" + jahrgang.getJahrgang();
		}
		ret += buchstabe + " ";
		if (ret.length() != 4) {
			throw new RuntimeException("Klasse.getName4() ist nicht 4 Zeichen lang: " + ret);
		}
		return ret;
	}

	@Override
	public String toString() {
		return getName();
	}
	
	public String getSort() {
		if (jahrgang.getJahrgang() < 10) {
			return "0" + jahrgang.getJahrgang() + buchstabe;
		}
		return "" + jahrgang.getJahrgang() + buchstabe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + buchstabe;
		result = prime * result + ((jahrgang == null) ? 0 : jahrgang.hashCode());
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
		Klasse other = (Klasse) obj;
		if (buchstabe != other.buchstabe)
			return false;
		if (jahrgang == null) {
			if (other.jahrgang != null)
				return false;
		} else if (!jahrgang.equals(other.jahrgang))
			return false;
		return true;
	}
}
