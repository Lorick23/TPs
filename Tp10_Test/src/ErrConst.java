
@SuppressWarnings("serial")
public class ErrConst extends Exception {
	public ErrConst(String string) {
		super(string);
		System.out.println("Dessin Hors Limite !");
	}
}
