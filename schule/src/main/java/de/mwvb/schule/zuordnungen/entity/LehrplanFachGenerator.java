package de.mwvb.schule.zuordnungen.entity;

import java.util.ArrayList;
import java.util.List;

import de.mwvb.schule.lehrplan.entity.Lehrplan;
import de.mwvb.schule.lehrplan.entity.LehrplanFach;
import de.mwvb.schule.ressourcen.entity.Ressource;
import de.mwvb.schule.schueler.entity.Klasse;

public class LehrplanFachGenerator {
	private final Zuordnungen zuordnungen;
	
	public LehrplanFachGenerator(Zuordnungen zuordnungen) {
		this.zuordnungen = zuordnungen;

	}

	public List<LehrplanFach> generate(Klasse klasse, Lehrplan lehrplan) {
		List<LehrplanFach> ret = new ArrayList<>();
		ret.addAll(generate(klasse, lehrplan, true, true));
		ret.addAll(generate(klasse, lehrplan, true, false));
		ret.addAll(generate(klasse, lehrplan, false, true));
		ret.addAll(generate(klasse, lehrplan, false, false));
		return ret;
	}

	private List<LehrplanFach> generate(Klasse klasse, Lehrplan lehrplan, boolean hauptfach, boolean doppelstunde) {
		List<LehrplanFach> ret = new ArrayList<>();
		for (LehrplanFach fach : lehrplan) {
			if (fach.isHauptfach() == hauptfach && fach.isMussDoppelstunde() == doppelstunde) {
				List<Ressource> ressourcen = zuordnungen.getRessourcen(klasse, fach.getBezeichnung());
				for (int i = 1; i <= fach.getAnzahl(); i++) {
					LehrplanFach neu = new LehrplanFach(fach);
					neu.setAnzahl(1);
					if (ressourcen != null) {
						neu.getErforderlicheRessourcen().addAll(ressourcen);
					}
					ret.add(neu);
				}
			}
		}
		return ret;
	}
}
