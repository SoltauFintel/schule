package de.mwvb.schule.zuordnungen.entity;

import de.mwvb.schule.schule.entity.Schule;

public class StundenplanBerechnungInput {
	private final Schule schule;
	private final Zuordnungen zuordnungen;

	public StundenplanBerechnungInput(Schule schule, Zuordnungen zuordnungen) {
		super();
		this.schule = schule;
		this.zuordnungen = zuordnungen;
	}

	public Schule getSchule() {
		return schule;
	}

	public Zuordnungen getZuordnungen() {
		return zuordnungen;
	}
}
