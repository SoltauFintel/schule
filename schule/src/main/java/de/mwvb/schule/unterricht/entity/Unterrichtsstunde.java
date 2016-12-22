package de.mwvb.schule.unterricht.entity;

import java.util.ArrayList;
import java.util.List;

import de.mwvb.schule.ressourcen.entity.Lehrer;
import de.mwvb.schule.ressourcen.entity.Raum;
import de.mwvb.schule.ressourcen.entity.Ressource;

public class Unterrichtsstunde extends Fach {
	/** erforderliche Ressourcen (Lehrer, Raum, Beamer, ...) */
	private final List<Ressource> erforderlicheRessourcen = new ArrayList<>();

	public Unterrichtsstunde(String bez) {
		super(bez);
	}

	public Unterrichtsstunde(String bez, String lehrerName) {
		super(bez);
		erforderlicheRessourcen.add(new Lehrer(lehrerName));
	}

	public List<Ressource> getErforderlicheRessourcen() {
		return erforderlicheRessourcen;
	}
	
	public Lehrer getLehrer() {
		return (Lehrer) erforderlicheRessourcen.stream().filter(r -> r instanceof Lehrer).findFirst().orElse(null);
	}
	
	public Raum getRaum() {
		return (Raum) erforderlicheRessourcen.stream().filter(r -> r instanceof Raum).findFirst().orElse(null);
	}
	
	@Override
	public String toString() {
		Lehrer l = getLehrer();
		return pad(getBezeichnung()) + "." + pad(l == null ? "" : l.getName());
	}
}
