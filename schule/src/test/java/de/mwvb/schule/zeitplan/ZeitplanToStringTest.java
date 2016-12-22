package de.mwvb.schule.zeitplan;

import org.junit.Assert;
import org.junit.Test;

import de.mwvb.schule.unterricht.entity.Unterrichtsstunde;
import de.mwvb.schule.zeitplan.entity.Zeitplan;

public class ZeitplanToStringTest {

	@Test
	public void leer() {
		Zeitplan zeitplan = new Zeitplan(false);
		String e = new ZeitplanToString(zeitplan).toString();
		Assert.assertEquals("   Mo:    Di:    Mi:    Do:    Fr: ", e);
	}

	@Test
	public void leer_festeBreite() {
		Zeitplan zeitplan = new Zeitplan(2);
		String e = new ZeitplanToString(zeitplan, 4).toString();
		Assert.assertEquals("   Mo:      ,      ,      ,         Di:      ,      ,      ,      ", e);
	}
	
	@Test
	public void gefuellt() {
		Zeitplan zeitplan = new Zeitplan(2);
		zeitplan.getWochentag(1).set(1, new Unterrichtsstunde("BI", "BU"));
		zeitplan.getWochentag(1).set(2, new Unterrichtsstunde("PH", "WE"));
		zeitplan.getWochentag(1).set(6, new Unterrichtsstunde("SP", "ST"));
		zeitplan.getWochentag(2).set(3, new Unterrichtsstunde("D", "AU"));

		String e = new ZeitplanToString(zeitplan, 6).toString();
		Assert.assertEquals("   Mo: BI.BU, PH.WE,      ,      ,      , SP.ST   Di:      ,      , D .AU,      ,      ,      ", e);
	}
	
	@Test
	public void dynamisch() {
		Zeitplan zeitplan = new Zeitplan(4);
		zeitplan.getWochentag(1).set(1, new Unterrichtsstunde("BI", "BU"));
		zeitplan.getWochentag(1).set(2, new Unterrichtsstunde("PH", "WE"));
		zeitplan.getWochentag(1).set(6, new Unterrichtsstunde("SP", "ST"));
		zeitplan.getWochentag(2).set(3, new Unterrichtsstunde("D", "AU"));
		zeitplan.getWochentag(4).set(1, new Unterrichtsstunde("M", "FO"));

		String e = new ZeitplanToString(zeitplan).toString();
		Assert.assertEquals("   Mo: BI.BU, PH.WE,      ,      ,      , SP.ST   Di:      ,      , D .AU   Mi:    Do: M .FO", e);
	}
}
