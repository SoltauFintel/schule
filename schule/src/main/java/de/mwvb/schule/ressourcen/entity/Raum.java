package de.mwvb.schule.ressourcen.entity;

import java.util.ArrayList;
import java.util.List;

import de.mwvb.schule.unterricht.entity.Fach;

/**
 * Ein Raum in der Schule, der f�r den Unterricht ben�tigt wird.
 * Beispiele: Turnhalle, Kunstraum
 */
public class Raum implements Ressource {
	/** Geb�ude und/oder Trakt */
	private final String gebaeude;
	/** 0 ist �blicherweise Erdgeschoss, -1 = Keller */
	private final int stock;
	private final String raum;
	private final List<Fach> faecher = new ArrayList<>();
	private Long x = null;
	private Long y = null;

	public Raum(String gebaeude, int stock, int raumnummer) {
		this(gebaeude, stock, "" + raumnummer);
	}
	
	public Raum(String gebaeude, int stock, String raum) {
		this.gebaeude = gebaeude;
		this.stock = stock;
		this.raum = raum;
	}

	public String getBezeichnung() {
		return stock + "." + raum + "/" + gebaeude;
	}

	public String getGebaeude() {
		return gebaeude;
	}

	public int getStock() {
		return stock;
	}

	public String getRaum() {
		return raum;
	}

	/**
	 * Falls f�r ein Unterrichtsfach ein bestimmter Raum mit einer speziellen Funktion ben�tigt wird, wird dieser Raum anhand dieser F�cher-Liste
	 * bestimmt. Eine leere F�cherliste bedeutet, dass dieser Raum keine spezielle Funktion hat und f�r F�cher benutzt werden kann,
	 * die keinen Spezialraum ben�tigen.
	 */
	public List<Fach> getFaecher() {
		return faecher;
	}

	/**
	 * Position und Stock sind die Grundlage f�r die Berechnung der Zeit, die Personen ben�tigen, um von einem Raum zu einem anderen Raum zu gehen.
	 */
	public void setPosition(Long x, Long y) {
		if ((x != null && y == null) || (x == null && y != null)) {
			throw new IllegalArgumentException("x und y m�ssen beide gesetzt oder beide null sein!");
		}
		this.x = x;
		this.y = y;
	}
	
	public Long getX() {
		return x;
	}

	public Long getY() {
		return y;
	}

	@Override
	public String toString() {
		return getBezeichnung();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gebaeude == null) ? 0 : gebaeude.hashCode());
		result = prime * result + ((raum == null) ? 0 : raum.hashCode());
		result = prime * result + stock;
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
		Raum other = (Raum) obj;
		if (gebaeude == null) {
			if (other.gebaeude != null)
				return false;
		} else if (!gebaeude.equals(other.gebaeude))
			return false;
		if (raum == null) {
			if (other.raum != null)
				return false;
		} else if (!raum.equals(other.raum))
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}
}
