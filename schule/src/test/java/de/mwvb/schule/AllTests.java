package de.mwvb.schule;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import de.mwvb.schule.zeitplan.ZeitplanToStringTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ZeitplanToStringTest.class,
})
public class AllTests {

}
