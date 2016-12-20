package de.mwvb.schule.zeitplan.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Ein Wochentag hat n Stunden.
 */
public class Wochentag<F> {
	private final int tag;
	private final Map<Integer, F> stunden = new HashMap<>();
	
	public Wochentag(int tag) {
		this.tag = tag;
	}

	public int getTag() {
		return tag;
	}

	public String getName() {
		switch (tag) {
		case 1: return "Mo";
		case 2: return "Di";
		case 3: return "Mi";
		case 4: return "Do";
		case 5: return "Fr";
		case 6: return "Sa";
		case 7: return "So";
		default: return "";
		}
	}
	
	public void set(int index, F eintrag) {
		if (index < 1) {
			throw new IllegalArgumentException("Bitte index ab 1 angeben!");
		}
		if (eintrag == null) {
			stunden.remove(index);
		} else {
			stunden.put(index, eintrag);
		}
	}
	
	public void remove(int index) {
		if (index < 1) {
			throw new IllegalArgumentException("Bitte index ab 1 angeben!");
		}
		stunden.remove(index);
	}
	
	/**
	 * @param index
	 * @return kann null sein
	 */
	public F get(int index) {
		if (index < 1) {
			throw new IllegalArgumentException("Bitte index ab 1 angeben!");
		}
		return stunden.get(index);
	}
	
	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stunden == null) ? 0 : stunden.hashCode());
		result = prime * result + tag;
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
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Wochentag<F> other = (Wochentag) obj;
		if (stunden == null) {
			if (other.stunden != null)
				return false;
		} else if (!stunden.equals(other.stunden))
			return false;
		if (tag != other.tag)
			return false;
		return true;
	}

	public int getAnzahlStunden() {
		return stunden.size();
	}
	
	// TODO getErsteStunde
	// TODO getLetzteStunde
	// TODO getAnzahlFreistundenAmAnfang
	// TODO getAnzahlFreistundenMittendrin
	// TODO getErsteFreieStundeAb(int ab)
	// TODO copy
}
