import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Segment extends Figure {
	private Point pointA;
	private Point pointB;

	public Segment(Point point, int longueur, boolean horizontal)  {
		this.pointA = point;
		if (horizontal) {
			pointB = new Point(point.getX() + longueur, point.getY());
		} else {
			pointB = new Point(point.getX(), point.getY() + longueur);
		}
		super.col = Couleur.getCouleurDefaut();
	}
	
	public Segment(Point point, int longueur, boolean horizontal, Couleur col)  {
		this(point, longueur, horizontal);
		super.col = col;
	}



	@Override
	public String toString() {
		return "Segment [pointA=" + pointA + ", pointB=" + pointB + ", col=" + col + "]";
	}

	@Override
	protected String getType() {
		// TODO Auto-generated method stub
		return "SEGMENT";
	}

	@Override
	public Collection<Point> getPoints() {
		List<Point> points = new ArrayList<Point>();
		points.add(pointA);
		points.add(pointB);
		return points;
	}

	@Override
	protected boolean couvre(Point point) {
		return (point.getX() >= pointA.getX() && point.getX() <= pointB.getX())
				&& (point.getY() >= pointA.getY() && point.getY() <= pointB.getY());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pointA == null) ? 0 : pointA.hashCode());
		result = prime * result + ((pointB == null) ? 0 : pointB.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Segment other = (Segment) obj;
		if (pointA == null) {
			if (other.pointA != null)
				return false;
		} else if (!pointA.equals(other.pointA))
			return false;
		if (pointB == null) {
			if (other.pointB != null)
				return false;
		} else if (!pointB.equals(other.pointB))
			return false;
		if(super.col != other.col)
			return false;
		return true;
	}

	@Override
	protected double surface() {
		// TODO Auto-generated method stub
		return 0;
	}


//	public boolean equals(Figure fig) {
//		if (!this.getType().equals(fig.getType())) {
//			return false;
//		}
//		Segment seg = (Segment) fig;
//		if (this.pointA == seg.pointA && this.pointB == seg.pointB) {
//			return true;
//		}
//		return false;
//	}
	
	

}
