package de.mwvb.schule.lehrplan.entity;

import de.mwvb.schule.schueler.entity.Klasse;
import de.mwvb.schule.zeitplan.entity.Zeitplan;

/**
 * H�lt alle Daten, die f�r die Regelpr�fung erforderlich sind.
 */
public class Regelkontext {
	private final int tag;
	private final int stunde;
	private final LehrplanFach fach;
	private final Klasse klasse;
	private final Zeitplan klasseStundenplan;
	private final RessourcenVerfuegbarkeit ressourcenVerfuegbarkeit;

	public Regelkontext(int tag, int stunde, LehrplanFach fach, Klasse klasse, Zeitplan klasseStundenplan,
			RessourcenVerfuegbarkeit ressourcenVerfuegbarkeit) {
		this.tag = tag;
		this.stunde = stunde;
		this.fach = fach;
		this.klasse = klasse;
		this.klasseStundenplan = klasseStundenplan;
		this.ressourcenVerfuegbarkeit = ressourcenVerfuegbarkeit;
	}

	public int getTag() {
		return tag;
	}

	public int getStunde() {
		return stunde;
	}

	public LehrplanFach getFach() {
		return fach;
	}
	
	public int getMaxStunde() {
		return klasse.getJahrgang().getMaxStunde();
	}

	public Zeitplan getKlasseStundenplan() {
		return klasseStundenplan;
	}

	public RessourcenVerfuegbarkeit getRessourcenVerfuegbarkeit() {
		return ressourcenVerfuegbarkeit;
	}
	
	public Regelkontext fuerAndereStunde(int andereStunde) {
		return new Regelkontext(tag, andereStunde, fach, klasse, klasseStundenplan, ressourcenVerfuegbarkeit);
	}
}
