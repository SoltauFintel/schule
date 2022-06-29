package de.mwvb.schule.lehrplan.entity;

import java.util.TreeSet;

/**
 * LehrplanFach Menge
 * 
 * Nennt man auch Stundentafel.
 */
public class Lehrplan extends TreeSet<LehrplanFach> {

	public LehrplanFach byBez(String bez) {
		return stream().filter(i -> i.getBezeichnung().equals(bez)).findFirst().orElse(null);
	}
}
