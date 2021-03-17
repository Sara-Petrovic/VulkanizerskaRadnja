package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma a;

	@BeforeEach
	void setUp() throws Exception {
		a = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}

	@Test
	void testAutoGuma() {
		a = new AutoGuma();

		assertNotNull(a);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		a = new AutoGuma("Tigar 12", 15, 200, 56);

		assertNotNull(a);
		assertEquals("Tigar 12", a.getMarkaModel());
		assertEquals(15, a.getPrecnik());
		assertEquals(200, a.getSirina());
		assertEquals(56, a.getVisina());
	}

	@Test
	void testSetMarkaModel() {

		a.setMarkaModel("Michelin 3");

		assertEquals("Michelin 3", a.getMarkaModel());
	}

	@Test
	void testSetMarkaModelNull() {

		assertThrows(java.lang.NullPointerException.class, () -> a.setMarkaModel(null));
	}

	@Test
	void testSetMarkaModelKratakString() {

		assertThrows(java.lang.RuntimeException.class, () -> a.setMarkaModel("Mi"));
	}

	@ParameterizedTest
	@CsvSource({ "15", "16" })
	void testSetPrecnik(int precnik) {
			a.setPrecnik(precnik);
			assertEquals(precnik, a.getPrecnik());
	}
	@Test
	void testSetPrecnikIspodOpsega() {
		assertThrows(java.lang.RuntimeException.class, () -> a.setPrecnik(10));
		
	}
	@Test
	void testSetPrecnikIznadOpsega() {
		assertThrows(java.lang.RuntimeException.class, () -> a.setPrecnik(23));	
	}
	
	@ParameterizedTest
	@CsvSource({  "200", "250" })
	void testSetSirina(int sirina) {
			a.setSirina(sirina);
			assertEquals(sirina, a.getSirina());
	}

	@Test
	void testSetSirinaIspodOpsega() {
		assertThrows(java.lang.RuntimeException.class, () -> a.setSirina(100));
		
	}
	@Test
	void testSetSirinaIznadOpsega() {
		assertThrows(java.lang.RuntimeException.class, () -> a.setSirina(500));
	}
	
	@ParameterizedTest
	@CsvSource({ "25", "50"})
	void testSetVisina(int visina) {
			a.setVisina(visina);
			assertEquals(visina, a.getVisina());
	}

	@Test
	void testSetVisinaIspodOpsega() {
		assertThrows(java.lang.RuntimeException.class, () -> a.setVisina(5));
		
	}
	@Test
	void testSetVisinaIznadOpsega() {
		assertThrows(java.lang.RuntimeException.class, () -> a.setVisina(96));
	}
	
	@Test
	void testToString() {
		a.setMarkaModel("Michelin 6");
		a.setPrecnik(15);
		a.setSirina(200);
		a.setVisina(50);

		String s = a.toString();

		assertTrue(s.contains("Michelin 6"));
		assertTrue(s.contains("15"));
		assertTrue(s.contains("200"));
		assertTrue(s.contains("50"));

	}

	@ParameterizedTest
	@CsvSource({ "Michelin 6, 15, 200, 50,Michelin 6, 15, 200, 50, true", 
		"Tigar 6, 15, 200, 50,Michelin 6, 15, 200, 50, false",
		"Michelin 6, 13, 200, 50,Michelin 6, 15, 200, 50, false",
		"Michelin 6, 15, 199, 50,Michelin 6, 15, 200, 50, false",
		"Michelin 6, 15, 200, 48,Michelin 6, 15, 200, 50, false",
		"Miche 6, 16, 200, 50,Michelin 6, 15, 200, 50, false",
		"Miche 6, 15, 199, 50,Michelin 6, 15, 200, 50, false", 
		"Miche 6, 15, 200, 49,Michelin 6, 15, 200, 50, false", 
		"Michelin 6, 16, 201, 50,Michelin 6, 15, 200, 50, false", 
		"Michelin 6, 16, 200, 51,Michelin 6, 15, 200, 50, false", 
		"Michelin 6, 15, 201, 51,Michelin 6, 15, 200, 50, false", 
		"Miche 6, 16, 201, 50,Michelin 6, 15, 200, 50, false", 
		"Miche 6, 15, 201, 51,Michelin 6, 15, 200, 50, false", 
		"Miche 6, 16, 201, 51,Michelin 6, 15, 200, 50, false", 
		

	})
	void testEqualsObject(String marka1, int precnik1, int sirina1, int visina1, String marka2, int precnik2,
			int sirina2, int visina2, boolean eq) {
		a.setMarkaModel(marka1);
		a.setPrecnik(precnik1);
		a.setSirina(sirina1);
		a.setVisina(visina1);

		AutoGuma b = new AutoGuma();
		b.setMarkaModel(marka2);
		b.setPrecnik(precnik2);
		b.setSirina(sirina2);
		b.setVisina(visina2);
		
		assertEquals(eq, a.equals(b));
	}

}
