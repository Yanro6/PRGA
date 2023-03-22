package peron.yang.tp3;

import morpions.kit.test.SpecifModeleMorpions;

public class ModeleMorpions implements SpecifModeleMorpions {

	public int[][] matrice;
	public Etat etat;
	public int nbCoupsJoue;

	public ModeleMorpions() {
		super();

		// def grille
		matrice = new int[TAILLE][TAILLE];

		// init nb coups joue
		nbCoupsJoue = 0;

		// init etat
		etat = Etat.J1_JOUE;

	}

	@Override
	public Etat getEtatJeu() {
		return etat;
	}

	@Override
	public int getJoueur() {
		if (etat == Etat.J1_JOUE) {
			return 1;
		} else if (etat == Etat.J2_JOUE) {
			return 2;
		} else {
			return 0;
		}
	}

	@Override
	public int getVainqueur() {
		if (etat == Etat.J1_VAINQUEUR) {
			return 1;
		} else if (etat == Etat.J2_VAINQUEUR) {
			return 2;
		} else {
			return 0;
		}
	}

	@Override
	public int getNombreCoups() {
		return nbCoupsJoue;
	}

	@Override
	public boolean estFinie() {
		int valeur;

		// verifie lignes
		for (int lig = 0; lig < TAILLE; lig++) {
			valeur = 1;
			for (int col = 0; col < TAILLE; col++) {
				valeur = valeur * matrice[lig][col];
			}
			if (partieFinie(valeur)) {
				return true;
			}
		}

		// verifie colonnes
		for (int col = 0; col < TAILLE; col++) {
			valeur = 1;
			for (int lig = 0; lig < TAILLE; lig++) {
				valeur = valeur * matrice[lig][col];
			}
			if (partieFinie(valeur)) {
				return true;
			}
		}

		// verifie diagonales
		valeur = 1;
		for (int dia = 0; dia < TAILLE; dia++) {
			valeur = valeur * matrice[dia][dia];
		}
		if (partieFinie(valeur)) {
			return true;
		}

		valeur = 1;
		for (int dia = TAILLE - 1; dia >= 0; dia--) {
			valeur = valeur * matrice[dia][dia];
		}
		if (partieFinie(valeur)) {
			return true;
		}

		if (nbCoupsJoue == 9) {
			etat = Etat.MATCH_NUL;
			return true;
		}

		return false;
	}

	public boolean partieFinie(int v) {
		if (v == 8) {
			etat = Etat.J2_VAINQUEUR;
			return true;
		} else if (v == 1) {
			etat = Etat.J1_VAINQUEUR;
			return true;
		}
		return false;
	}

	@Override
	public boolean estCoupAutorise(int ligne, int colonne) {
		if (estFinie()) {
			return false;
		} else if ((ligne > TAILLE) || (colonne > TAILLE) || (ligne < 1) || (colonne < 1)) {
			return false;
		} else if (matrice[ligne - 1][colonne - 1] == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void jouerCoup(int ligne, int colonne) {
		if (estCoupAutorise(ligne, colonne)) {
			int lig = ligne - 1;
			int col = colonne - 1;
			if (getEtatJeu() == Etat.J1_JOUE) {
				matrice[lig][col] = 1;
				etat = Etat.J2_JOUE;
			} else if (getEtatJeu() == Etat.J2_JOUE) {
				matrice[lig][col] = 2;
				etat = Etat.J1_JOUE;
			}
			nbCoupsJoue++;
		}

		estFinie();
		affiche();
	}

	public void affiche() {
		String ligne = "";
		for (int lig = 0; lig < TAILLE; lig++) {
			for (int col = 0; col < TAILLE; col++) {
				ligne = ligne + Integer.toString(matrice[lig][col]);
			}
			ligne = ligne + "\n";
		}

		System.out.println(ligne);
	}
}
