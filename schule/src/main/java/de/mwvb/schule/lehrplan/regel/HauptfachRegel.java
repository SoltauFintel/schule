package de.mwvb.schule.lehrplan.regel;

import de.mwvb.schule.lehrplan.entity.Regel;
import de.mwvb.schule.lehrplan.entity.Regelkontext;

/**
 * Ein Hauptfach soll in den ersten 4 Stunden unterrichtet werden.
 */
public class HauptfachRegel implements Regel {

	@Override
	public boolean erfuellt(Regelkontext ktx) {
		if (!ktx.getFach().isHauptfach()) { // Regel nicht anwendbar
			return true;
		}
		return (ktx.getStunde() <= 4);
	}
}
