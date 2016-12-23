package de.mwvb.schule.lehrplan.regel;

import de.mwvb.schule.lehrplan.entity.Regel;
import de.mwvb.schule.lehrplan.entity.Regelkontext;
import de.mwvb.schule.unterricht.entity.Fach;

/**
 * 1. Regel:
 * Ist der Eintrag im Klassen-Stundenplan frei?
 */
public class KlasseVerfuegbarRegel implements Regel {

	@Override
	public boolean erfuellt(Regelkontext ktx) {
		if (ktx.getStunde() > ktx.getMaxStunde()) {
			return false;
		}
		
		// TODO Verteilung
		
		Fach fach = ktx.getKlasseStundenplan().getWochentag(ktx.getTag()).get(ktx.getStunde());
		return fach == null;
	}
}
