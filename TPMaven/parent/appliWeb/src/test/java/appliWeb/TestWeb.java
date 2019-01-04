package appliWeb;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.dta.utils.MyStringUtils;

public class TestWeb {
	@Test
	public void testUnit() {
		assertTrue(MyStringUtils.IsNullOrEmpty(" "));
	}
}
