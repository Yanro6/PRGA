package peron.yang.tp2;

public class MotsCroisesBis {

	private Grille<CaseMC> grille;

	private int hauteur;
	private int largeur;

	// Constructeur créant une instance de MotsCroises
	// dotée de 4 instances de Grille, suivant les
	// spécifications données ci-dessous :
	public MotsCroisesBis(int hauteur, int largeur) {
		if (hauteur < 0)
			throw new IllegalArgumentException("Hauteur incorrecte : " + hauteur);
		if (largeur < 0)
			throw new IllegalArgumentException("Largeur incorrecte : " + largeur);
		this.hauteur = hauteur;
		this.largeur = largeur;
		grille = new Grille<>(this.hauteur, this.largeur);
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
		if (!grille.coordCorrectes(lig, col))
			throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
		return grille.getCellule(lig, col).getStatut();
	}

	public void setCaseNoire(int lig, int col, boolean noire) {
		if (!grille.coordCorrectes(lig, col))
			throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
		CaseMC cm = new CaseMC();
		cm.setStatut(noire);
		grille.setCellule(lig, col, cm);
	}

	// Accesseurs à la grille de solution
	// Préconditions :
	// coordCorrectes(lig, col)
	// !estCaseNoire(lig, col)

	public char getSolution(int lig, int col) {
		if (!grille.coordCorrectes(lig, col))
			throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		return grille.getCellule(lig, col).getSolution();
	}

	public void setSolution(int lig, int col, char sol) {
		if (!grille.coordCorrectes(lig, col))
			throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		CaseMC cm = grille.getCellule(lig, col);
		cm.setSolution(sol);
		grille.setCellule(lig, col, cm);
	}

	// Accesseurs à la grille du joueur
	// Préconditions : idem
	public char getProposition(int lig, int col) {
		if (!grille.coordCorrectes(lig, col))
			throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		return grille.getCellule(lig, col).getProposition();
	}

	public void setProposition(int lig, int col, char prop) {
		if (!grille.coordCorrectes(lig, col))
			throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		CaseMC cm = grille.getCellule(lig, col);
		cm.setProposition(prop);
		grille.setCellule(lig, col, cm);
	}

	// Accesseurs aux définitions.
	// Le paramètre "horiz" est "true" pour les définitions horizontales,
	// "false" pour les définitions verticales.
	// Préconditions : idem
	public String getDefinition(int lig, int col, boolean horiz) {
		if (!grille.coordCorrectes(lig, col))
			throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		if (horiz) {
			return grille.getCellule(lig, col).getHorizontal();
		} else {
			return grille.getCellule(lig, col).getVertical();
		}
	}

	public void setDefinition(int lig, int col, boolean horiz, String def) {
		if (!grille.coordCorrectes(lig, col))
			throw new IllegalArgumentException("CoordonnÃ©e incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		CaseMC cm = grille.getCellule(lig, col);
		if (horiz) {
			cm.setHorizontal(def);
			grille.setCellule(lig, col, cm);
		} else {
			cm.setVertical(def);
			grille.setCellule(lig, col, cm);
		}
	}

}
