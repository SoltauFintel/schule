package de.mwvb.schule.lehrplan.regel;

import de.mwvb.schule.lehrplan.entity.Regel;
import de.mwvb.schule.lehrplan.entity.Regelkontext;

/**
 * Eine Doppelstunde soll nicht von einer großen Pause unterbrochen werden.
 * Die große Pause findet nach der 2. und 4. Stunde statt.
 * Doppelstunden werden als Block eingeplant. Daher muss hier auch direkt geprüft werden, ob Klasse und Ressourcen für die 2. Doppelstunde-Stunde
 * verfügbar sind.
 */
public class DoppelstundeRegel implements Regel {

	@Override
	public boolean erfuellt(Regelkontext ktx) {
		if (!ktx.getFach().isMussDoppelstunde()) { // Regel nicht anwendbar
			return true;
		}
		if (ktx.getStunde() % 2 == 0) { // gerade Stunde
			return false;
		}
		return true;
//		Regelkontext zweiteStunde = ktx.fuerAndereStunde(ktx.getStunde() + 1);
//		return new KlasseVerfuegbarRegel().erfuellt(zweiteStunde)
//				&& new RessourceVerfuegbar().erfuellt(zweiteStunde);
	}
}
