package de.mwvb.schule.lehrplan.entity;

import java.util.ArrayList;
import java.util.List;

import de.mwvb.schule.ressourcen.entity.Ressource;
import de.mwvb.schule.unterricht.entity.Fach;

/**
 * Definiert alle Eigenschaften eines Lehrplan-Faches.
 */
public class LehrplanFach extends Fach {
	private int anzahl = 1;
	private boolean hauptfach = false;
	private boolean mussDoppelstunde = false;
	private boolean nichtAufeinanderfolgendeTage = false;
	private final List<Ressource> erforderlicheRessourcen = new ArrayList<>();

	public LehrplanFach(String bezeichnung) {
		super(bezeichnung);
	}

	public LehrplanFach(int anzahl, String bezeichnung, boolean hauptfach, boolean mussDoppelstunde) {
		super(bezeichnung);
		this.anzahl = anzahl;
		this.hauptfach = hauptfach;
		this.mussDoppelstunde = mussDoppelstunde;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public boolean isHauptfach() {
		return hauptfach;
	}

	public void setHauptfach(boolean hauptfach) {
		this.hauptfach = hauptfach;
	}

	public boolean isMussDoppelstunde() {
		return mussDoppelstunde;
	}

	public void setMussDoppelstunde(boolean mussDoppelstunde) {
		this.mussDoppelstunde = mussDoppelstunde;
	}

	public boolean isNichtAufeinanderfolgendeTage() {
		return nichtAufeinanderfolgendeTage;
	}

	public void setNichtAufeinanderfolgendeTage(boolean nichtAufeinanderfolgendeTage) {
		this.nichtAufeinanderfolgendeTage = nichtAufeinanderfolgendeTage;
	}

	public List<Ressource> getErforderlicheRessourcen() {
		return erforderlicheRessourcen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + anzahl;
		result = prime * result + ((erforderlicheRessourcen == null) ? 0 : erforderlicheRessourcen.hashCode());
		result = prime * result + (hauptfach ? 1231 : 1237);
		result = prime * result + (mussDoppelstunde ? 1231 : 1237);
		result = prime * result + (nichtAufeinanderfolgendeTage ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LehrplanFach other = (LehrplanFach) obj;
		if (anzahl != other.anzahl)
			return false;
		if (erforderlicheRessourcen == null) {
			if (other.erforderlicheRessourcen != null)
				return false;
		} else if (!erforderlicheRessourcen.equals(other.erforderlicheRessourcen))
			return false;
		if (hauptfach != other.hauptfach)
			return false;
		if (mussDoppelstunde != other.mussDoppelstunde)
			return false;
		if (nichtAufeinanderfolgendeTage != other.nichtAufeinanderfolgendeTage)
			return false;
		return true;
	}
}
