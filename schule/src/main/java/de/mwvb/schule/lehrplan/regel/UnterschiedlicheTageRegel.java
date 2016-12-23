package de.mwvb.schule.lehrplan.regel;

import de.mwvb.schule.lehrplan.entity.Regel;
import de.mwvb.schule.lehrplan.entity.Regelkontext;
import de.mwvb.schule.unterricht.entity.Fach;
import de.mwvb.schule.zeitplan.entity.Wochentag;

/**
 * Wenn ein Fach in mehreren Einzelstunden unterrichtet werden soll, so sollen diese Stunden an unterschiedlichen Tagen gegeben werden.
 */
public class UnterschiedlicheTageRegel implements Regel {

	@Override
	public boolean erfuellt(Regelkontext ktx) {
		return existsFach(ktx, ktx.getTag());
	}

	boolean existsFach(Regelkontext ktx, int tag) {
		String x = ktx.getFach().getBezeichnung();
		Wochentag<Fach> wt = ktx.getKlasseStundenplan().getWochentag(tag);
		for (int stunde = 1; stunde <= ktx.getMaxStunde(); stunde++) {
			Fach fach = wt.get(stunde);
			if (fach != null && fach.getBezeichnung().equals(x)) {
				return false;
			}
		}
		return true;
	}
}
