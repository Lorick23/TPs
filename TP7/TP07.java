public class TP07 {
	public static void main(String args[]) {
		//Dans ce cas, si input = 100, il teste les nombres jusqu'a 100
		/*int input = Integer.parseInt(args[0]);
		int countModulo = 0;

		for (int i = 2; i < input+1; i++) {
			for (int j = 1; j < i+1; j++) {
				if(i%j == 0){
					countModulo++;
				}
			}
			if(countModulo == 2){
				System.out.println(i);
			}
			countModulo = 0;
		}*/

		//Dans ce cas, si input = 100, il sort les 100 premiers nombres premiers
		int input = Integer.parseInt(args[0]);
		int countModulo = 0;
		int nbPremiersTrouves = 0;
		int i = 2;

		while(nbPremiersTrouves < input){
			for (int j = 1; j < i+1; j++) {
				if(i%j == 0){
					countModulo++;
				}
			}
			if(countModulo == 2){
				System.out.println(i);
				nbPremiersTrouves++;
			}
			countModulo = 0;
			i++;
		}
	}
}