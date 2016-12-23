package de.mwvb.schule.lehrplan.regel;

import de.mwvb.schule.lehrplan.entity.Regelkontext;

/**
 * Wenn bspw. ein Fach 2 Einzelstunden pro Woche unterrichtet wird, dann soll mindestens ein Tag zwischen den Stunden frei sein.
 * Über das Fach-Attribut "nichtAufeinanderfolgendeTage" == false kann diese Regel deaktiviert werden.
 */
public class NichtAufeinanderfolgendeTageRegel extends UnterschiedlicheTageRegel {

	@Override
	public boolean erfuellt(Regelkontext ktx) {
		if (!ktx.getFach().isNichtAufeinanderfolgendeTage()) { // Regel soll nicht angewendet werden.
			return true;
		}
		int anzahlTage = ktx.getKlasseStundenplan().getAnzahlTage();
		if (ktx.getTag() < 1 || ktx.getTag() > anzahlTage) {
			throw new IllegalerTagException("RegelKontext.tag hat illegalen Wert: " + ktx.getTag());
		}
		boolean erfuellt = super.existsFach(ktx, ktx.getTag());
		if (!erfuellt) {
			return false;
		}
		int tag = ktx.getTag() - 1;
		if (tag == 0) {
			tag = anzahlTage;
		}
		return existsFach(ktx, tag);
	}
}
