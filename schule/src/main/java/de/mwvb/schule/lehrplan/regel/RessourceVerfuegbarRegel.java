package de.mwvb.schule.lehrplan.regel;

import de.mwvb.schule.lehrplan.entity.Regel;
import de.mwvb.schule.lehrplan.entity.Regelkontext;
import de.mwvb.schule.lehrplan.entity.RessourcenVerfuegbarkeit;
import de.mwvb.schule.ressourcen.entity.Ressource;

/**
 * Sind alle Ressourcen (Lehrer, Raum, ...) verfügbar?
 */
public class RessourceVerfuegbarRegel implements Regel {

	@Override
	public boolean erfuellt(Regelkontext ktx) {
		RessourcenVerfuegbarkeit resVerf = ktx.getRessourcenVerfuegbarkeit();
		int tag = ktx.getTag();
		int stunde = ktx.getStunde();
		for (Ressource ressource : ktx.getFach().getErforderlicheRessourcen()) {
			if (!resVerf.verfuegbar(ressource, tag, stunde)) {
				return false;
			}
		}
		return true;
	}
}
