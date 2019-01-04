import java.util.concurrent.ThreadLocalRandom;

public enum TypeFigure {
	ROND,
	RECTANGLE,
	CARRE,
	SEGMENT;
	
	public static TypeFigure getRandomType() {
		int randomCol = ThreadLocalRandom.current().nextInt(values().length);
		return values()[randomCol];
	}
}
