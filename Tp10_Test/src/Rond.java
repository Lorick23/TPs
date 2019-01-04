import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rond extends Figure implements Surfacable {
	private Point center;
	private int radius;

	public Rond(Point point, int radius) {
		this.center = point;
		this.radius = radius;
		super.col = Couleur.getCouleurDefaut();
	}

	public Rond(Point point, int radius, Couleur col) {
		this(point, radius);
		super.col = col;
	}

	protected String getType() {
		return "ROND";
	}

	public Collection<Point> getPoints() {
		List<Point> points = new ArrayList<Point>();
		points.add(center);
		return points;
	}

	@Override
	public String toString() {
		return "Rond [center=" + center + ", radius=" + radius + ", col=" + col + "]";
	}

	public Point getPoint() {
		return center;
	}

	public void setPoint(Point point) {
		this.center = point;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public double surface() {
		return Math.sqrt(radius) * Math.PI;
	}

	@Override
	protected boolean couvre(Point point) {
		return Math.sqrt(
				Math.pow((point.getX() - center.getX()), 2) + (Math.pow(center.getY() - point.getY(), 2))) < radius;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		result = prime * result + radius;
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
		Rond other = (Rond) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		if (radius != other.radius)
			return false;
		if (super.col != other.col)
			return false;
		return true;
	}

//	@Override
//	public double distanceOrigine() {
//		return center.distance(new Point(Point.getInitX(), Point.getInitY()));
//	}

//	public boolean equals(Figure fig) {
//		if(!this.getType().equals(fig.getType())) {
//			return false;
//		}
//		Rond rond = (Rond) fig;
//		if(this.center == rond.center && this.radius == rond.radius) {
//			return true;
//		}
//		return false;
//	}

}
