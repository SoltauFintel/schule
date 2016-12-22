package de.mwvb.schule.lehrplan.entity;

import de.mwvb.schule.ressourcen.entity.Ressource;

/**
 * Gibt Auskunft darüber, ob eine Ressource zu einem Zeitpunkt verfügbar ist.
 * Es erfolgt keine automatische Buchung.
 */
public interface RessourcenVerfuegbarkeit {

	boolean verfuegbar(Ressource ressource, int tag, int stunde);
}
