
public class Carre extends Rectangle {

	public Carre(Point point, int cote) {
		super(point, cote, cote);
	}
	
	public Carre(Point point, int cote, Couleur col) {
		super(point, cote, cote, col);
	}

	protected String getType() {
		return "CARRE";
	}

	@Override
	public String toString() {
		return "Carre [pointBasGauche=" + pointBasGauche + ", pointBasDroit=" + pointBasDroit + ", pointHautGauche="
				+ pointHautGauche + ", pointHautDroit=" + pointHautDroit + ", col=" + col + "]";
	}


}
