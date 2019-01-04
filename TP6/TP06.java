public class TP06 {
	public static void main(String args[]) {
		int input = Integer.parseInt(args[0]);
		int factorielle = 1;

		for(int i = 1; i < input+1; i++){
			factorielle *= i;
		}
		System.out.println("La factorielle de "+input+" vaut "+factorielle);
	}
}