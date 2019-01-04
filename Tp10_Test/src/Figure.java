import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class Figure implements Comparable<Figure>{
	
	protected Couleur col;
	
	//public abstract 
	public abstract String toString();
	protected abstract double surface();
	protected abstract String getType();
	public void affiche() {
		System.out.println(toString());
	}
	protected abstract Collection<Point> getPoints();
	protected abstract boolean couvre(Point point);
	
	public double distanceOrigine() throws ErrConst {
		List<Double> distances = new ArrayList<Double>();
		for(Point point : this.getPoints()) {
			distances.add(point.distance(new Point(Point.getInitX(), Point.getInitY())));
		}
		return Collections.min(distances);
	}
	
	@Override
	public int compareTo(Figure figure) {
		try {
			if(this.distanceOrigine() > figure.distanceOrigine()) {
				return 1;
			}
		} catch (ErrConst e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(this.distanceOrigine() < figure.distanceOrigine()) {
				return -1;
			}
		} catch (ErrConst e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public Couleur getCouleur() {
		return col;
	}
}
