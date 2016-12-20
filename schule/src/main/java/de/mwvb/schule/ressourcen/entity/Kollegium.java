package de.mwvb.schule.ressourcen.entity;

import java.util.ArrayList;

/**
 * Lehrer Liste
 */
public class Kollegium extends ArrayList<Lehrer> {

	public Kollegium() {
		super();
	}
	
	public Lehrer byName(String name) {
		for (Lehrer l : this) {
			if (l.getName().equals(name)) {
				return l;
			}
		}
		throw new RuntimeException("Lehrer nicht vorhanden: " + name);
	}
}
