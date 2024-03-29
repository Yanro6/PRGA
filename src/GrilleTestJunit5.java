import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import peron.yang.tp2.Grille;

public class GrilleTestJunit5 {

	private Grille<String> g1, g2;
	private int hauteur, largeur;

	@BeforeEach
	public void setUp() throws Exception {
		hauteur = 333;
		largeur = 555;
		g1 = new Grille<String>(hauteur, largeur);
		g2 = new Grille<String>(hauteur + 1, largeur + 1);
		System.out.println("Test de " + g1.getClass().getName());
	}

	@Test
	public void testHauteurLargeur() {
		assertEquals("La hauteur est égale au 1er paramètre du constructeur", hauteur, g1.getHauteur());
		assertEquals("La largeur est égale au 2e paramètre du constructeur", largeur, g1.getLargeur());
	}

	@Test
	public void testCellule() {
		try {
			for (int l = 1; l <= g1.getHauteur(); l++) {
				String ch1 = Integer.toString(l);
				for (int c = 1; c <= g1.getLargeur(); c++) {
					String ch2 = ch1 + ',' + Integer.toString(c);
					g1.setCellule(l, c, ch2);
					g2.setCellule(l, c, ch2 + "x");
					assertEquals("La valeur restituée doit être la valeur enregistrée", ch2, g1.getCellule(l, c));
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			fail("L'indice de tableau ne doit pas dépasser hauteur-1 (resp. largeur-1");
		}
	}

	@Test
	public void testPreconditions() {
		boolean testOK = false;
		// Précondition de hauteur
		try {
			new Grille<Object>(-4, 5);
			testOK = false;
		} catch (RuntimeException e) {
			testOK = true;
		}

		assertTrue("Une hauteur négative doit déclencher une RuntimeException", testOK);

		// Précondition de largeur
		try {
			new Grille<Object>(4, -5);
			testOK = false;
		} catch (RuntimeException e) {
			testOK = true;
		}
		assertTrue("Une largeur négative doit déclencher une RuntimeException", testOK);

		// Précondition de 1ère coordonnée de cellule
		try {
			g1.setCellule(hauteur + 1, 1, "hgjhgjhg");
			testOK = false;
		} catch (RuntimeException e) {
			testOK = true;
		}
		assertTrue("Tout non-respect des bornes doit causer une RuntimeException", testOK);

		// Précondition de 2ème coordonnée de cellule
		try {
			g1.setCellule(1, -1, "hgjhgjhg");
			testOK = false;
		} catch (RuntimeException e) {
			testOK = true;
		}
		assertTrue("Tout non-respect des bornes doit causer une RuntimeException", testOK);
	}
}
