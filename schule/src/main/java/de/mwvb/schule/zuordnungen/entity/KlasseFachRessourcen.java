package de.mwvb.schule.zuordnungen.entity;

import java.util.ArrayList;
import java.util.List;

import de.mwvb.schule.ressourcen.entity.Lehrer;
import de.mwvb.schule.ressourcen.entity.Ressource;
import de.mwvb.schule.schueler.entity.Klasse;
import de.mwvb.schule.unterricht.entity.Fach;

public class KlasseFachRessourcen {
	private final Klasse klasse;
	private final Fach fach;
	private final List<Ressource> ressourcen = new ArrayList<>();
	
	public KlasseFachRessourcen(Klasse klasse, Fach fach, Lehrer lehrer) {
		this.klasse = klasse;
		this.fach = fach;
		ressourcen.add(lehrer);
	}

	public Klasse getKlasse() {
		return klasse;
	}

	public Fach getFach() {
		return fach;
	}

	public List<Ressource> getRessourcen() {
		return ressourcen;
	}
	
	public Lehrer getLehrer() {
		return (Lehrer) ressourcen.stream().filter(r -> r instanceof Lehrer).findFirst().orElse(null);
	}
}
