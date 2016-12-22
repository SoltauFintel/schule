package de.mwvb.schule;

import de.mwvb.schule.lehrplan.entity.Lehrplan;
import de.mwvb.schule.lehrplan.entity.LehrplanFach;
import de.mwvb.schule.ressourcen.entity.Lehrer;
import de.mwvb.schule.schueler.entity.Jahrgang;
import de.mwvb.schule.schueler.entity.Klasse;
import de.mwvb.schule.schule.entity.Schule;

public class Schule1Factory {
	private Schule schule;
	
	public Schule build() {
		schule = new Schule("Schule 1");
		kollegium();
		jahrgang5();
		// TODO weitere Jahrgänge
		// TODO weitere Ressourcen (Räume: Kunstsaal, Turnhalle, Tonstudio, Fotolabor, Physikhörsaal, Küche,
		// Werkraum, Sprachlabor, Schwimmbad, Sportplatz, Klassenzimmer)
		return schule;
	}

	private void kollegium() {
		lehrer("FO", "M", "CH");
		lehrer("CR", "M", "GE");
		lehrer("AU", "D", "PK");
		lehrer("NI", "E", "TX");
		lehrer("PA", "E", "PK");
		lehrer("WE", "PH", "BI");
		lehrer("BU", "D", "BI");
		lehrer("ST", "SP", "BI");
		lehrer("RI", "KU", "MU");
		lehrer("WI", "F", "EK");
		// TODO weitere Lehrer
	}
	
	private void lehrer(String name, String ... faecher) {
		schule.getKollegium().add(new Lehrer(name, faecher));
	}

	private void jahrgang5() {
		Jahrgang jg = new Jahrgang(5);
		jg.setMaxTag(5);
		jg.setMaxStunde(5); // TODO 5 oder 6 ?
		
		Lehrplan lehrplan = jg.getLehrplan();
		lehrplan.add(new LehrplanFach(4, "M", true, false));
		lehrplan.add(new LehrplanFach(4, "D", true, false));
		lehrplan.add(new LehrplanFach(4, "E", true, false));
		lehrplan.add(new LehrplanFach(1, "SP", false, true));
		lehrplan.add(new LehrplanFach(1, "KU", false, true));
		lehrplan.add(new LehrplanFach(2, "PH", false, false));
		lehrplan.add(new LehrplanFach(2, "BI", false, false));
		lehrplan.add(new LehrplanFach(2, "EK", false, false));
		lehrplan.add(new LehrplanFach(1, "TX", false, false));
		lehrplan.add(new LehrplanFach(1, "MU", false, false));
		lehrplan.add(new LehrplanFach(1, "PK", false, false));
		
		klasse(jg, 'a', "PA");
		klasse(jg, 'b', "NI");
		klasse(jg, 'c', "FO");
		klasse(jg, 'd', "BU");
	}
	
	private void klasse(Jahrgang jg, char buchstabe, String klassenlehrerName) {
		Klasse k = new Klasse(jg, buchstabe);
		k.setKlassenlehrer(schule.getKollegium().byName("NI"));
		schule.getKlassen().add(k);
	}
}
