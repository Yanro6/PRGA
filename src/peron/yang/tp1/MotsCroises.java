package peron.yang.tp1;

public class MotsCroises {

	private Grille solution;
	private Grille proposition;
	private Grille horizontal;
	private Grille vertical;

	private int hauteur;
	private int largeur;

	// Constructeur cr�ant une instance de MotsCroises
	// dot�e de 4 instances de Grille, suivant les
	// sp�cifications donn�es ci-dessous :
	public MotsCroises(int hauteur, int largeur) {
		if (hauteur < 0)
			throw new IllegalArgumentException("Hauteur incorrecte : " + hauteur);
		if (largeur < 0)
			throw new IllegalArgumentException("Largeur incorrecte : " + largeur);
		this.hauteur = hauteur;
		this.largeur = largeur;
		solution = new Grille(this.hauteur, this.largeur);
		proposition = new Grille(this.hauteur, this.largeur);
		horizontal = new Grille(this.hauteur, this.largeur);
		vertical = new Grille(this.hauteur, this.largeur);
	}

	// Nombre de rang�es
	public int getHauteur() {
		return this.hauteur;
	}

	// Nombre de colonnes
	public int getLargeur() {
		return this.largeur;
	}

	// Validit� des coordonn�es
	// Resultat : vrai si et seulement si (lig, col)
	// d�signent une cellule existante de la grille
	public boolean coordCorrectes(int lig, int col) {
		return (((lig >= 1) && (lig <= getHauteur())) && ((col >= 1) && (col <= getLargeur())));
	}

	// Accesseurs aux cases noires
	// Pr�condition : coordCorrectes(lig, col)
	public boolean estCaseNoire(int lig, int col) {
		if (!coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
		return solution.getCellule(lig, col) == null;
	}

	public void setCaseNoire(int lig, int col, boolean noire) {
		if (!coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
		if (noire) {
			solution.setCellule(lig, col, null);
		}else {
			solution.setCellule(lig, col, "");
		}
	}

	// Accesseurs � la grille de solution
	// Pr�conditions :
	// coordCorrectes(lig, col)
	// !estCaseNoire(lig, col)

	public char getSolution(int lig, int col) {
		if (!coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		return solution.getCellule(lig, col).charAt(0);
	}

	public void setSolution(int lig, int col, char sol) {
		if (!coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		solution.setCellule(lig, col, Character.toString(sol));
	}

	// Accesseurs � la grille du joueur
	// Pr�conditions : idem
	public char getProposition(int lig, int col) {
		if (!coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		return proposition.getCellule(lig, col).charAt(0);
	}

	public void setProposition(int lig, int col, char prop) {
		if (!coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		proposition.setCellule(lig, col, Character.toString(prop));
	}

	// Accesseurs aux d�finitions.
	// Le param�tre "horiz" est "true" pour les d�finitions horizontales,
	// "false" pour les d�finitions verticales.
	// Pr�conditions : idem
	public String getDefinition(int lig, int col, boolean horiz) {
		if (!coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		if (horiz) {
			return horizontal.getCellule(lig, col);
		} else {
			return vertical.getCellule(lig, col);
		}
	}

	public void setDefinition(int lig, int col, boolean horiz, String def) {
		if (!coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		if (horiz) {
			horizontal.setCellule(lig, col, def);
		} else {
			vertical.setCellule(lig, col, def);
		}
	}

}
