package de.mwvb.schule.zuordnungen.entity;

import java.util.ArrayList;
import java.util.List;

import de.mwvb.schule.lehrplan.entity.LehrplanFach;
import de.mwvb.schule.ressourcen.entity.Lehrer;
import de.mwvb.schule.ressourcen.entity.Ressource;
import de.mwvb.schule.schueler.entity.Klasse;
import de.mwvb.schule.schule.entity.Schule;
import de.mwvb.schule.unterricht.entity.Fach;

public class Zuordnungen {
	private final Schule schule;
	private final List<KlasseFachRessourcen> zuordnungen = new ArrayList<>();
	
	public Zuordnungen(Schule schule) {
		this.schule = schule;
	}
	
	public void add(Klasse klasse, String fach, String lehrerName) {
		if (klasse == null || fach == null || fach.trim().isEmpty() || lehrerName == null || lehrerName.trim().isEmpty()) {
			throw new IllegalArgumentException("Parameter klasse, fach oder lehrerName nicht korrekt angegeben!");
		}
		LehrplanFach i = klasse.getJahrgang().getLehrplan().byBez(fach);
		if (i == null) {
			throw new RuntimeException("Klasse " + klasse.getName() + ": Das Fach " + fach + " ist nicht im Lehrplan enthalten!");
		}
		Lehrer l = schule.getKollegium().byName(lehrerName);
		if (l == null) {
			throw new RuntimeException("Klasse " + klasse.getName() + ": Lehrer nicht vorhanden: " + lehrerName);
		}
		Fach dasFach = new Fach(fach);
		if (!l.getFaecher().contains(dasFach)) {
			throw new RuntimeException("Klasse " + klasse.getName() + ": Der Lehrer " + l.getName()
				+ " unterrichtet nicht das Fach " + fach + " !");
		}
		List<Ressource> list = getRessourcen(klasse, fach);
		if (list == null) {
			zuordnungen.add(new KlasseFachRessourcen(klasse, dasFach, l));
		} else {
			list.add(l);
		}
	}

	public List<Ressource> getRessourcen(Klasse klasse, String fach) {
		for (KlasseFachRessourcen kfr : zuordnungen) {
			if (kfr.getKlasse().equals(klasse) && kfr.getFach().getBezeichnung().equals(fach)) {
				return kfr.getRessourcen();
			}
		}
		return null;
	}
}
