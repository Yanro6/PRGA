package peron.yang.tp2;

public class CaseMC {

	private Character solution;
	private Character proposition;
	private String horizontal;
	private String vertical;
	private boolean statut;

	public char getSolution() {
		return solution;
	}

	public char getProposition() {
		return proposition;
	}

	public String getHorizontal() {
		return horizontal;
	}

	public String getVertical() {
		return vertical;
	}

	public boolean getStatut() {
		return statut;
	}

	public void setSolution(Character solution) {
		this.solution = solution;
	}

	public void setProposition(Character proposition) {
		this.proposition = proposition;
	}

	public void setHorizontal(String horizontal) {
		this.horizontal = horizontal;
	}

	public void setVertical(String vertical) {
		this.vertical = vertical;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

}
