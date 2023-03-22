package peron.yang.tp2;

public class MotsCroisesBis {

	private Grille<CaseMC> grille;

	private int hauteur;
	private int largeur;

	// Constructeur cr�ant une instance de MotsCroises
	// dot�e de 4 instances de Grille, suivant les
	// sp�cifications donn�es ci-dessous :
	public MotsCroisesBis(int hauteur, int largeur) {
		if (hauteur < 0)
			throw new IllegalArgumentException("Hauteur incorrecte : " + hauteur);
		if (largeur < 0)
			throw new IllegalArgumentException("Largeur incorrecte : " + largeur);
		this.hauteur = hauteur;
		this.largeur = largeur;
		grille = new Grille<>(this.hauteur, this.largeur);
	}

	// Nombre de rang�es
	public int getHauteur() {
		return this.hauteur;
	}

	// Nombre de colonnes
	public int getLargeur() {
		return this.largeur;
	}

	// Accesseurs aux cases noires
	// Pr�condition : coordCorrectes(lig, col)
	public boolean estCaseNoire(int lig, int col) {
		if (!grille.coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
		return grille.getCellule(lig, col).getStatut();
	}

	public void setCaseNoire(int lig, int col, boolean noire) {
		if (!grille.coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
		CaseMC cm = new CaseMC();
		cm.setStatut(noire);
		grille.setCellule(lig, col, cm);
	}

	// Accesseurs � la grille de solution
	// Pr�conditions :
	// coordCorrectes(lig, col)
	// !estCaseNoire(lig, col)

	public char getSolution(int lig, int col) {
		if (!grille.coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		return grille.getCellule(lig, col).getSolution();
	}

	public void setSolution(int lig, int col, char sol) {
		if (!grille.coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		CaseMC cm = grille.getCellule(lig, col);
		cm.setSolution(sol);
		grille.setCellule(lig, col, cm);
	}

	// Accesseurs � la grille du joueur
	// Pr�conditions : idem
	public char getProposition(int lig, int col) {
		if (!grille.coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		return grille.getCellule(lig, col).getProposition();
	}

	public void setProposition(int lig, int col, char prop) {
		if (!grille.coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
		if (estCaseNoire(lig, col))
			throw new IllegalArgumentException("Case noire : " + lig + " " + col);
		CaseMC cm = grille.getCellule(lig, col);
		cm.setProposition(prop);
		grille.setCellule(lig, col, cm);
	}

	// Accesseurs aux d�finitions.
	// Le param�tre "horiz" est "true" pour les d�finitions horizontales,
	// "false" pour les d�finitions verticales.
	// Pr�conditions : idem
	public String getDefinition(int lig, int col, boolean horiz) {
		if (!grille.coordCorrectes(lig, col))
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
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
			throw new IllegalArgumentException("Coordonnée incorrecte : " + lig + " " + col);
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
