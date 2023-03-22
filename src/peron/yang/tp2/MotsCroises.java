package peron.yang.tp2;

public class MotsCroises {

	private Grille<Character> solution;
	private Grille<Character> proposition;
	private Grille<String> horizontal;
	private Grille<String> vertical;
	private Grille<Boolean> statut;

	private int hauteur;
	private int largeur;

	// Constructeur créant une instance de MotsCroises
	// dotée de 4 instances de Grille, suivant les
	// spécifications données ci-dessous :
	public MotsCroises(int hauteur, int largeur) {
		if (hauteur < 0)
			throw new IllegalArgumentException("Hauteur incorrecte : " + hauteur);
		if (largeur < 0)
			throw new IllegalArgumentException("Largeur incorrecte : " + largeur);
		this.hauteur = hauteur;
		this.largeur = largeur;
		solution = new Grille<Character>(this.hauteur, this.largeur);
		proposition = new Grille<Character>(this.hauteur, this.largeur);
		horizontal = new Grille<String>(this.hauteur, this.largeur);
		vertical = new Grille<String>(this.hauteur, this.largeur);
		statut = new Grille<Boolean>(this.hauteur, this.largeur);
	}

	// Nombre de rangées
	public int getHauteur() {
		return this.hauteur;
	}

	// Nombre de colonnes
	public int getLargeur() {
		return this.largeur;
	}

	// Accesseurs aux cases noires
	// Précondition : coordCorrectes(lig, col)
	public boolean estCaseNoire(int lig, int col) {
		if (!statut.coordCorrectes(lig, col))
			throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
		return statut.getCellule(lig, col);
	}

	public void setCaseNoire(int lig, int col, boolean noire) {
		if (!this.statut.coordCorrectes(lig, col))
			throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
		this.statut.setCellule(lig, col, noire);
	}

	// Accesseurs à la grille de solution
	// Préconditions :
	// coordCorrectes(lig, col)
	// !estCaseNoire(lig, col)

	public char getSolution(int lig, int col) {
		if (!solution.coordCorrectes(lig, col))
			throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		return solution.getCellule(lig, col);
	}

	public void setSolution(int lig, int col, char sol) {
		if (!solution.coordCorrectes(lig, col))
			throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		solution.setCellule(lig, col, sol);
	}

	// Accesseurs à la grille du joueur
	// Préconditions : idem
	public char getProposition(int lig, int col) {
		if (!proposition.coordCorrectes(lig, col))
			throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		return proposition.getCellule(lig, col);
	}

	public void setProposition(int lig, int col, char prop) {
		if (!proposition.coordCorrectes(lig, col))
			throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		proposition.setCellule(lig, col, prop);
	}

	// Accesseurs aux définitions.
	// Le paramètre "horiz" est "true" pour les définitions horizontales,
	// "false" pour les définitions verticales.
	// Préconditions : idem
	public String getDefinition(int lig, int col, boolean horiz) {
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		if (horiz) {
			if (!horizontal.coordCorrectes(lig, col))
				throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
			return horizontal.getCellule(lig, col);
		} else {
			if (!vertical.coordCorrectes(lig, col))
				throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
			return vertical.getCellule(lig, col);
		}
	}

	public void setDefinition(int lig, int col, boolean horiz, String def) {
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		if (horiz) {
			if (!horizontal.coordCorrectes(lig, col))
				throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
			horizontal.setCellule(lig, col, def);
		} else {
			if (!vertical.coordCorrectes(lig, col))
				throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
			vertical.setCellule(lig, col, def);
		}
	}

}
