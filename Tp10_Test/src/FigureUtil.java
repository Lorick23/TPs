import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FigureUtil {

	public static Map<String, Figure> figures = new HashMap<>();
	public static int countFigure = 0;

	public static Point getRandomPoint() {
		Point point = new Point(ThreadLocalRandom.current().nextInt(0, 100),
				ThreadLocalRandom.current().nextInt(0, 100));
		return point;
	}

	public static Rond getRandomRond(Couleur col) {
		Rond rond = new Rond(getRandomPoint(), ThreadLocalRandom.current().nextInt(0, 100), col);
		figures.put(String.valueOf(countFigure), rond);
		return rond;
	}

	public static Rectangle getRandomRectangle(Couleur col) {
		Rectangle rect = new Rectangle(getRandomPoint(), ThreadLocalRandom.current().nextInt(0, 100),
				ThreadLocalRandom.current().nextInt(0, 100), col);
		figures.put(String.valueOf(countFigure), rect);
		return rect;
	}

	public static Rectangle getRandomCarre(Couleur col) {
		Carre carre = new Carre(getRandomPoint(), ThreadLocalRandom.current().nextInt(0, 100), col);
		figures.put(String.valueOf(countFigure), carre);
		return carre;
	}

	public static Segment getRandomSegment(Couleur col) {
		int random = new Random().nextInt(2);
		boolean bool;
		switch (random) {
		case 0:
			bool = false;
		default:
			bool = true;
		}
		Segment segment = new Segment(getRandomPoint(), ThreadLocalRandom.current().nextInt(0, 100), bool, col);
		// countFigure++;
		figures.put(String.valueOf(countFigure), segment);
		return segment;
	}

	public static Figure getRandomFigure() {
		Couleur col = Couleur.getRandomCol();
		switch (ThreadLocalRandom.current().nextInt(4)) {
		case 0:
			return getRandomRond(col);
		case 1:
			return getRandomRectangle(col);
		case 2:
			return getRandomCarre(col);
		default:
			return getRandomSegment(col);
		}
	}

	public static Surfacable getRandomSurface() {
		int random = new Random().nextInt(4);
		Couleur col = Couleur.getRandomCol();
		switch (random) {
		case 0:
			return getRandomRond(col);
		case 1:
			return getRandomRectangle(col);
		default:
			return getRandomCarre(col);
		}
	}

	public static Collection<Point> getPoints(Collection<Figure> figures) {
		List<Point> points = new ArrayList<Point>();
		for (Figure fig : figures) {
			points.addAll(fig.getPoints());
		}
		return points;
	}

	public static Collection<Point> getPoints(Figure... figures) {
		List<Point> points = new ArrayList<Point>();
		for (Figure fig : figures) {
			points.addAll(fig.getPoints());
		}
		return points;
	}

	public static List<Figure> genere(int x) {
		List<Figure> figures = new ArrayList<Figure>();
		for (int i = 0; i < x; i++) {
			countFigure++;
			figures.add(getRandomFigure());
		}
		return figures;
	}

	public static Figure getFigureEn(Point point, Dessin dessin) {
		for (Figure fig : dessin.getFigures()) {
			if (fig.couvre(point)) {
				return fig;
			}
		}
		return null;
	}

	public static List<Figure> triProcheOrigine(Dessin dessin) {
		List<Figure> figures = dessin.getFigures();
		// Collections.sort(figures);
		return figures.stream().sorted().collect(Collectors.toList());
	}

	public static Figure get(String id) {
		
		return figures.entrySet().stream().filter(e -> e.getKey().equals(id)).map(Entry::getValue).findFirst().orElse(null);
		
//		for (Entry<String, Figure> entry : figures.entrySet()) {
//			String cle = entry.getKey();
//			Figure valeur = entry.getValue();
//			if (id.equals(cle)) {
//				return valeur;
//			}
//		}
//		return null;
	}

	public static List<Figure> triSurface(Dessin dessin) {

		return dessin.getFigures().stream().filter(f -> f instanceof Surfacable).sorted((Figure f1, Figure f2) -> {
			double s1 = ((Surfacable) f1).surface();
			double s2 = ((Surfacable) f2).surface();
			if (s1 > s2) {
				return 1;
			} else if (s1 < s2) {
				return -1;
			}
			return 0;
		}).collect(Collectors.toList());

//		List<Figure> figures = dessin.getFigures();
//		List<Figure> tmp = new ArrayList<>();
//		for (Figure tm : figures) {
//			if (tm instanceof Surfacable) {
//				tmp.add(tm);
//			}
//		}
//		Collections.sort(tmp, new Comparator<Figure>() {
//			@Override
//			public int compare(Figure o1, Figure o2) {
//				Surfacable s1 = (Surfacable) o1;
//				Surfacable s2 = (Surfacable) o2;
//				if (s1.surface() > s2.surface()) {
//					return 1;
//				} else if (s1.surface() < s2.surface()) {
//					return -1;
//				}
//				return 0;
//			}
//		});
//		return tmp;
	}

	public static String imprime() throws ErrConst {

		// Convertit ma HM en TP pour la trier par index
		Map<Integer, Figure> sortedFigures = new TreeMap<>();
		for (Entry<String, Figure> entry : figures.entrySet()) {
			sortedFigures.put(Integer.parseInt(entry.getKey()), entry.getValue());
		}
		// Creation de la liste des figures rangés par index
		boolean fill = false;
		StringBuffer sb = new StringBuffer();
		for (Entry<Integer, Figure> entry : sortedFigures.entrySet()) {
			sb.append(entry.getKey() + " => " + entry.getValue().toString() + "\n");
			for (int i = 0; i < 200; i++) {
				sb.append("=");
			}
			sb.append("\n");
		}
		// Representation des figures
		for (int y = 100; y > 0; y--) {
			for (int x = 0; x < 100; x++) {
				for (Entry<String, Figure> entry : figures.entrySet()) {
					for (Point point : entry.getValue().getPoints()) {
						if (x == point.getX() && y == point.getY()) {
							if (!fill) {
								sb.append(entry.getValue().getCouleur().getCode() + " ");
								fill = true;
							}
						}
					}
				}
				if (!fill) {
					sb.append(". ");
				}
				fill = false;
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void save(String str) {

		try {
			FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(str.toString());
			o.close();
			f.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}

	public static void load() {
		try {
			FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			System.out.println(oi.readObject().toString());
			oi.close();
			fi.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void load(TypeFigure typeFigure) {
		try {
			FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			String regex = "\\w* =>\\s+\\w*" + typeFigure.toString() + ".+?\\n";
			Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(oi.readObject().toString());
			while (matcher.find()) {
				System.out.println(matcher.group());
			}
			switch (typeFigure) {
			case RECTANGLE:
				break;
			case CARRE:
				break;
			case ROND:
				break;
			case SEGMENT:
				break;
			default:
				break;
			}
			oi.close();
			fi.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
