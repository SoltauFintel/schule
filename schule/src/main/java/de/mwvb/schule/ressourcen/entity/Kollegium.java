package de.mwvb.schule.ressourcen.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Lehrer Menge
 */
public class Kollegium extends HashSet<Lehrer> {

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
	
	public List<Lehrer> sorted() {
		List<Lehrer> ret = new ArrayList<>(size());
		ret.addAll(this);
		Collections.sort(ret, new Comparator<Lehrer>() {
			@Override
			public int compare(Lehrer a, Lehrer b) {
				return a.getName().compareTo(b.getName());
			}
		});
		return ret;
	}
}
