package auto_radnja;

import java.util.LinkedList;
import auto_radnja.gume.AutoGuma;

/**
 * Interfejs koji predstavlja radnju.
 * 
 * @author Sara Petrovic
 *
 */
public interface Radnja {
	
	/**
	 * Dodaje novu gumu u radnju.
	 * 
	 * @param a AutoGuma koja se dodaje.
	 * 
	 * @throws java.lang.NullPointerException ako je uneta guma null
	 * @throws java.lang.RuntimeException ako uneta guma vec postoji u radnji (duplikat)
	 */
	void dodajGumu(AutoGuma a);

	/**
	 * Pronalazi gumu iz radnje na osnovu marke gume.
	 * 
	 * @param markaModel MarkaModel gume na osnovu koje se vrsi pretraga.
	 * @return Lista AutoGuma koje zadovoljavaju kriterijum, tj. imaju istu markuModel kao sto je trazeno.
	 *			null ako je markaModel gume null.
	 */
	LinkedList<AutoGuma> pronadjiGumu(String markaModel);
	
	/**
	 * Vraca listu svih guma u radnji.
	 * @return lista svih guma
	 */
	LinkedList<AutoGuma> getGume();

	
}