import java.util.ArrayList;
import java.util.List;

public class Dessin {
	private List<Figure> figures = new ArrayList<Figure>();

	public Dessin() {

	}

	public Dessin(List<Figure> figures) {
		this.figures = figures;
	}

	public List<Figure> getFigures() {
		return figures;
	}

	public boolean add(Figure fig) {
		figures.add(fig);
		return true;
	}

	@Override
	public String toString() {
		return "Dessin [figures=" + figures + "]";
	}

	
}
