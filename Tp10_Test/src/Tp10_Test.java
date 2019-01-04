import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Tp10_Test {

	public static void main(String[] args) {

//		DateTimeFormatter formater = DateTimeFormatter.ofPattern("'Il est' HH'h'mm', le' dd MMMM yyyy");
//		System.out.println(formater.format(LocalDateTime.now()));
//		System.out.println(formater.format(LocalDateTime.of(2018, 12, 25, 21, 0)));
//
//		LocalDateTime ldt = LocalDateTime.parse("Il est 12h50, le 02 janvier 2013", formater);
//		System.out.println(ldt.until(LocalDateTime.now(), ChronoUnit.SECONDS));

		Dessin dessin = new Dessin(FigureUtil.genere(3));
		for (Figure fig : dessin.getFigures()) {
			System.out.println(fig);
			System.out.println("surface "+fig.surface());
		}
		System.out.println("-----");
		System.out.println(FigureUtil.triSurface(dessin));

//		try {
//		FigureUtil.genere(100);
//		FigureUtil.save(FigureUtil.imprime());
//		FigureUtil.load(TypeFigure.getRandomType());
//		
//		} catch (ErrConst e) {
//			System.out.print("hors limite : " + e.getMessage());
//			e.printStackTrace();
//		}

	}

}
