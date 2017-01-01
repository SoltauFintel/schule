package de.mwvb.schule.testdaten;

import org.junit.Test;

import de.mwvb.schule.schueler.entity.Jahrgang;
import de.mwvb.schule.schule.entity.Schule;

public class Schule1Test {

	@Test
	public void stammdaten() {
		Schule schule1 = new Schule1Factory().build();
		new Schule1ZuordnungenFactory().build(schule1);
		
		System.out.println("Die Schule hat " + schule1.getKlassen().size() + " Klassen.");
		
		Jahrgang jg5 = schule1.findeKlasse("5a").getJahrgang();
		System.out.println("\r\nJahrgang 5:");
		System.out.println("  " + jg5.getLehrplan().size() + " Lehrplan-Fächer");
	}
}
