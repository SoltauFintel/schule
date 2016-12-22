package de.mwvb.schule.lehrplan.entity;

import de.mwvb.schule.ressourcen.entity.Ressource;

/**
 * Gibt Auskunft dar�ber, ob eine Ressource zu einem Zeitpunkt verf�gbar ist.
 * Es erfolgt keine automatische Buchung.
 */
public interface RessourcenVerfuegbarkeit {

	boolean verfuegbar(Ressource ressource, int tag, int stunde);
}
