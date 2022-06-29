package de.mwvb.schule.testdaten;

import de.mwvb.schule.schueler.entity.Klasse;
import de.mwvb.schule.schule.entity.Schule;
import de.mwvb.schule.zuordnungen.entity.Zuordnungen;

public class Schule1ZuordnungenFactory {
	private Schule schule;
	private Zuordnungen zuordnungen;
	
	public Zuordnungen build(Schule schule) {
		this.schule = schule;
		zuordnungen = new Zuordnungen(schule);
		
		kfl("5a", "M=CR,D=AU,E=PA,SP=ST,KU=RI,PH=WE,BI=WE,EK=WI,TX=NI,MU=RI,PK=PA");
		kfl("5b", "M=CR,D=AU,E=NI,SP=ST,KU=RI,PH=WE,BI=WE,EK=WI,TX=NI,MU=RI,PK=AU");
		kfl("5c", "M=FO,D=BU,E=NI,SP=ST,KU=RI,PH=WE,BI=BU,EK=WI,TX=NI,MU=RI,PK=AU");
		kfl("5d", "M=FO,D=BU,E=PA,SP=ST,KU=RI,PH=FU,BI=BU,EK=WI,TX=NI,MU=RI,PK=PA");
		
		kfl("6a", "M=FO,D=AU,E=PA,SP=ST,KU=RI,PH=WE,BI=ST,EK=WI,TX=NI,F=WI,PK=PA");
		
		return zuordnungen;
	}
	
	private void kfl(String klasseName, String definition) {
		Klasse klasse = schule.findeKlasse(klasseName);
		for (String fachUndLehrer : definition.split(",")) {
			String[] w = fachUndLehrer.split("=");
			zuordnungen.add(klasse, w[0].trim(), w[1].trim());
		}
	}
}
