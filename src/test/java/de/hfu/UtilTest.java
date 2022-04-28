package de.hfu;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class UtilTest {
@Test
	public void  monattest() {
	assertTrue(Util.istErstesHalbjahr(1));
	assertTrue(Util.istErstesHalbjahr(6));
	assertTrue(!Util.istErstesHalbjahr(7));
}
@Test(expected=IllegalArgumentException.class, timeout=1000)
public void gueltigeEingabeTest() {
	Util.istErstesHalbjahr(0);
}
}
