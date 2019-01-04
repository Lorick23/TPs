import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rectangle extends Figure implements Surfacable {
	protected Point pointBasGauche;
	protected Point pointBasDroit;
	protected Point pointHautGauche;
	protected Point pointHautDroit;

	public Rectangle(Point point, int longueur, int hauteur) {
		this.pointBasGauche = point;
		this.pointBasDroit = new Point(point.getX() + longueur, point.getY());
		this.pointHautGauche = new Point(point.getX(), point.getY() + hauteur);
		this.pointHautDroit = new Point(point.getX() + longueur, point.getY() + hauteur);
		super.col = Couleur.getCouleurDefaut();
	}

	public Rectangle(Point point, int longueur, int hauteur, Couleur col) {
		this(point, longueur, hauteur);
		super.col = col;
	}

	@Override
	public Collection<Point> getPoints() {
		List<Point> points = new ArrayList<Point>();
		points.add(pointBasGauche);
		points.add(pointBasDroit);
		points.add(pointHautGauche);
		points.add(pointHautDroit);
		return points;
	}

	protected String getType() {
		return "RECT";
	}

	@Override
	public String toString() {
		return "Rectangle [pointBasGauche=" + pointBasGauche + ", pointBasDroit=" + pointBasDroit + ", pointHautGauche="
				+ pointHautGauche + ", pointHautDroit=" + pointHautDroit + ", col=" + col + "]";
	}

	public Point getPointBasGauche() {
		return pointBasGauche;
	}

	public Point getPointBasDroit() {
		return pointBasDroit;
	}

	public Point getPointHautGauche() {
		return pointHautGauche;
	}

	public Point getPointHautDroit() {
		return pointHautDroit;
	}

	@Override
	public double surface() {
		double aire = (pointBasDroit.getX() - pointBasGauche.getX()) * (pointHautGauche.getY() - pointBasGauche.getY());
		return aire;
	}

	@Override
	protected boolean couvre(Point point) {
		return point.getX() >= pointBasGauche.getX() && point.getX() <= pointBasDroit.getX()
				&& point.getY() >= pointBasGauche.getY() && point.getY() <= pointHautGauche.getY();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pointBasDroit == null) ? 0 : pointBasDroit.hashCode());
		result = prime * result + ((pointBasGauche == null) ? 0 : pointBasGauche.hashCode());
		result = prime * result + ((pointHautDroit == null) ? 0 : pointHautDroit.hashCode());
		result = prime * result + ((pointHautGauche == null) ? 0 : pointHautGauche.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			if (((Figure) obj).getType() != "CARRE") {
				return false;
			}
		}
		Rectangle other = (Rectangle) obj;
		if (pointBasDroit == null) {
			if (other.pointBasDroit != null)
				return false;
		} else if (!pointBasDroit.equals(other.pointBasDroit))
			return false;
		if (pointBasGauche == null) {
			if (other.pointBasGauche != null)
				return false;
		} else if (!pointBasGauche.equals(other.pointBasGauche))
			return false;
		if (pointHautDroit == null) {
			if (other.pointHautDroit != null)
				return false;
		} else if (!pointHautDroit.equals(other.pointHautDroit))
			return false;
		if (pointHautGauche == null) {
			if (other.pointHautGauche != null)
				return false;
		} else if (!pointHautGauche.equals(other.pointHautGauche))
			return false;
		if (super.col != other.col)
			return false;
		return true;
	}

//	@Override
//	public double distanceOrigine() {
//		TreeSet<Double> distances = new TreeSet<Double>();
//		Point init = new Point(Point.getInitX(), Point.getInitY());
//		distances.add(pointBasGauche.distance(init));
//		distances.add(pointHautGauche.distance(init));
//		distances.add(pointBasDroit.distance(init));
//		distances.add(pointHautDroit.distance(init));
//		return distances.first();
//	}

//	public boolean equals(Figure fig) {
//		if (!this.getType().equals(fig.getType())) {
//			if(fig.getType() != "CARRE") {
//				return false;
//			}
//		}
//		Rectangle rect = (Rectangle) fig;
//		if (this.pointBasGauche == rect.pointBasGauche && this.pointBasDroit == rect.pointBasDroit
//				&& this.pointHautGauche == rect.pointHautGauche && this.pointHautDroit == rect.pointHautDroit) {
//			return true;
//		}
//		return false;
//	}

}
