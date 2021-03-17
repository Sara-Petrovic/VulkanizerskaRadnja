package auto_radnja;

import java.util.LinkedList;
import auto_radnja.gume.AutoGuma;

/**
 * Ova klasa implementira interfejs Radnja i predstavlja implementaciju preko liste.
 * @author Sara Petrovic
 *
 */
public class VulkanizerskaRadnja implements Radnja {
	
	/**
	 * Lista sa svim gumama u radnji.
	 */
	private LinkedList<AutoGuma> gume = new LinkedList<AutoGuma>();

	@Override
	public void dodajGumu(AutoGuma a) {
		if (a == null)
			throw new NullPointerException("Guma ne sme biti null");
		if (gume.contains(a))
			throw new RuntimeException("Guma vec postoji");
		gume.addFirst(a);
	}

	@Override
	public LinkedList<AutoGuma> pronadjiGumu(String markaModel) {
		if (markaModel == null)
			return null;
		LinkedList<AutoGuma> novaLista = new LinkedList<AutoGuma>();
		for (int i = 0; i < gume.size(); i++)
			if (gume.get(i).equals(markaModel))
				novaLista.add(gume.get(i));
		return novaLista;
	}
	
}
