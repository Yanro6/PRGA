package peron.yang.tp2;

public class Grille<E> {
// Variables dâ€™instance
// hauteur = nombre de lignes
	private int hauteur;

// largeur = nombre de colonnes
	private int largeur;

// tab = tableau de chaÃ®nes de caractÃ¨res Ã  deux dimensions,
	private E[][] tab;

	// avec taille = hauteur x largeur
	private int taille = hauteur * largeur;

// Constructeur permettant dâ€™obtenir une grille
// dotÃ©e dâ€™un tableau de dimensions conformes aux valeurs
// respectives de hauteur et de largeur, dont tous les
// Ã©lÃ©ments contiennent la valeur null.
// PrÃ©condition : hauteur â‰¥ 0 et largeur â‰¥ 0
	public Grille(int hauteur, int largeur) {
		if (hauteur < 0)
			throw new IllegalArgumentException("Hauteur incorrecte : " + hauteur);
		if (largeur < 0)
			throw new IllegalArgumentException("Largeur incorrecte : " + largeur);
		this.hauteur = hauteur;
		this.largeur = largeur;
		tab = (E[][]) new Object[this.hauteur][this.largeur];

		setTab(tab);

		/*
		 * for (int lig = 0; lig < hauteur; lig++) { for (int col = 0; col < largeur;
		 * col++) { tab[lig][col] = null; } }
		 */

	}

// Accesseurs (getters)
	public int getHauteur() {
		return this.hauteur;
	}

	public int getLargeur() {
		return this.largeur;
	}

// ValiditÃ© des coordonnÃ©es
// Resultat : vrai si et seulement si lig (resp. col)
// est compris entre 1 et getHauteur() (resp. getlargeur())
	public boolean coordCorrectes(int lig, int col) {
		return (((lig >= 1) && (lig <= getHauteur())) && ((col >= 1) && (col <= getLargeur())));
	}

// Valeur de la cellule ayant pour coordonnÃ©es (lig, col)
// PrÃ©condition : coordCorrectes(lig, col)
	public E getCellule(int lig, int col) {
		if (!coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
		return getTab()[lig - 1][col - 1];
	}

// Modification de la cellule de coordonnÃ©es (lig, col)
// PrÃ©condition : coordCorrectes(lig, col)
	public void setCellule(int lig, int col, E ch) {
		if (!coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
		getTab()[lig - 1][col - 1] = ch;
	}

// Texte sur â€œhauteurâ€� lignes, colonnes sÃ©parÃ©es par des |
// (voir exemple plus loin)
	@Override
	public String toString() {
		String res = "";
		for (int lig = 0; lig < this.hauteur; lig++) {
			for (int col = 0; col < this.largeur; col++) {
				res = res + (getTab()[lig][col]);
				if (col != this.largeur - 1) {
					res = res.concat("|");
				}
			}
			res = res.concat("\n");
		}
		return res;
	}

	public E[][] getTab() {
		return (E[][]) tab;
	}

	public void setTab(E[][] tab2) {
		this.tab = tab2;
	}

}
