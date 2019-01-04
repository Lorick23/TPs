public class TPBonus {
	public static void main(String args[]) {
		//Suite Fibonacci

		int input = Integer.parseInt(args[0]);
		int nbMoins1 = 1;
		int nbMoins2 = 0;
		int res;

		/*for (int i = 0; i < input+1; i++) {
			nbMoins1 = i--;
			//nbMoins2 = nbMoins1--;
			if(nbMoins1 < 0){
				nbMoins1 = 0;
			}
			if(nbMoins2 < 0){
				nbMoins2 = 0;
			}
			res = nbMoins1 + nbMoins2;
			System.out.println(res+"\n");
		}*/

		for (int i = 0; i < input+1; i+res) {
			System.out.println(i+"\n");
			res  = nbMoins1 + nbMoins2;
		}
	}
}