package de.mwvb.schule.zeitplan.entity;

import java.util.HashMap;
import java.util.Map;

import de.mwvb.schule.ressourcen.entity.Ressource;
import de.mwvb.schule.schueler.entity.Klasse;

/**
 * Alle Zeitpläne einer Schule
 */
public class Stundenplaene {
	private final Map<Klasse, Zeitplan> stundenplaene = new HashMap<>();
	private final Map<Ressource, Zeitplan> ressourcenbelegungen = new HashMap<>();

	public Stundenplaene() { //
	}
	
	/** Kopierkonstruktor */
	public Stundenplaene(Stundenplaene o) {
		o.stundenplaene.forEach((k,v) -> stundenplaene.put(k, new Zeitplan(v)));
		o.ressourcenbelegungen.forEach((k,v) -> ressourcenbelegungen.put(k, new Zeitplan(v)));
	}
	
	public void clear() {
		stundenplaene.clear();
		ressourcenbelegungen.clear();
	}
	
	public Zeitplan getStundenplan(Klasse klasse) {
		if (klasse == null) {
			throw new IllegalArgumentException("klasse darf nicht null sein!");
		}
		Zeitplan stundenplan = stundenplaene.get(klasse);
		if (stundenplan == null) {
			stundenplan = new Zeitplan(klasse.getJahrgang().getMaxTag());
			stundenplaene.put(klasse, stundenplan);
		}
		return stundenplan;
	}
	
	public Zeitplan getZeitplan(Ressource ressource) {
		if (ressource == null) {
			throw new IllegalArgumentException("ressource darf nicht null sein!");
		}
		Zeitplan stundenplan = ressourcenbelegungen.get(ressource);
		if (stundenplan == null) {
			stundenplan = new Zeitplan(6);
			ressourcenbelegungen.put(ressource, stundenplan);
		}
		return stundenplan;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ressourcenbelegungen == null) ? 0 : ressourcenbelegungen.hashCode());
		result = prime * result + ((stundenplaene == null) ? 0 : stundenplaene.hashCode());
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
		Stundenplaene other = (Stundenplaene) obj;
		if (ressourcenbelegungen == null) {
			if (other.ressourcenbelegungen != null)
				return false;
		} else if (!ressourcenbelegungen.equals(other.ressourcenbelegungen))
			return false;
		if (stundenplaene == null) {
			if (other.stundenplaene != null)
				return false;
		} else if (!stundenplaene.equals(other.stundenplaene))
			return false;
		return true;
	}
}
