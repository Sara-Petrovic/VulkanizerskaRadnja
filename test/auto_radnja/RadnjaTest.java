package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected Radnja radnja;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDodajGumu() {
		AutoGuma guma = new AutoGuma();
		guma.setMarkaModel("Pirelli 12");
		
		radnja.dodajGumu(guma);
		
		assertEquals(1, radnja.getGume().size());
		assertEquals(guma, radnja.getGume().get(0));
	}

	@Test
	void testDodajGumuVise() {
		AutoGuma guma = new AutoGuma();
		guma.setMarkaModel("Pirelli 12");
		guma.setPrecnik(15);
		guma.setSirina(200);
		guma.setVisina(50);
		
		radnja.dodajGumu(guma);
		
		AutoGuma guma2 = new AutoGuma();
		guma2.setMarkaModel("Longbottom 12");
		guma2.setPrecnik(18);
		guma2.setSirina(213);
		guma2.setVisina(54);
		
		radnja.dodajGumu(guma2);
		
		assertEquals(2, radnja.getGume().size());
		assertEquals(guma2, radnja.getGume().get(0));
	}
	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class,
				()->radnja.dodajGumu(null));
	}
	
	@Test
	void testDodajGumuDuplikat() {
		AutoGuma guma = new AutoGuma();
		guma.setMarkaModel("Pirelli 12");
		guma.setPrecnik(15);
		guma.setSirina(200);
		guma.setVisina(50);
		
		radnja.dodajGumu(guma);
		
		AutoGuma guma2 = new AutoGuma();
		guma2.setMarkaModel("Pirelli 12");
		guma2.setPrecnik(15);
		guma2.setSirina(200);
		guma2.setVisina(50);
		
		RuntimeException e = assertThrows(java.lang.RuntimeException.class,
				()->radnja.dodajGumu(guma2));
	}
	@Test
	void testPronadjiGumu() {
		AutoGuma guma = new AutoGuma();
		guma.setMarkaModel("Pirelli 12");
		guma.setPrecnik(15);
		guma.setSirina(200);
		guma.setVisina(50);
		
		radnja.dodajGumu(guma);
		
		AutoGuma guma2 = new AutoGuma();
		guma2.setMarkaModel("Longbottom 1");
		guma2.setPrecnik(16);
		guma2.setSirina(205);
		guma2.setVisina(56);
		
		radnja.dodajGumu(guma2);

		LinkedList<AutoGuma> lista= new LinkedList<>();
		lista = radnja.pronadjiGumu("nesto");

		assertEquals(0, lista.size());
	}

	@Test
	void testPronadjiGumuNull() {
		assertEquals(null, radnja.pronadjiGumu(null));
	}
	
	@Test
	public void testPronadjiGumuVise() {
		AutoGuma guma = new AutoGuma();
		guma.setMarkaModel("Pirelli 12");
		guma.setPrecnik(15);
		guma.setSirina(200);
		guma.setVisina(50);
		
		radnja.dodajGumu(guma);
		
		AutoGuma guma2 = new AutoGuma();
		guma2.setMarkaModel("Longbottom 1");
		guma2.setPrecnik(16);
		guma2.setSirina(205);
		guma2.setVisina(56);
		
		radnja.dodajGumu(guma2);
		
		AutoGuma guma3 = new AutoGuma();
		guma3.setMarkaModel("Longbottom 1");
		guma3.setPrecnik(15);
		guma3.setSirina(230);
		guma3.setVisina(56);
		
		radnja.dodajGumu(guma3);

		//Od 3 gume u listi 2 odgovaraju kriterijumu
		LinkedList<AutoGuma> nova = new LinkedList<>();
		nova = radnja.pronadjiGumu("Longbottom 1");

		assertEquals(2, nova.size());
		assertTrue(nova.contains(guma2));
		assertTrue(nova.contains(guma3));

	}
}
