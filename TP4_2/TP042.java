public class TP042 {
	public static void main(String args[]) {
		int poids = Integer.parseInt(args[0]);
		String tailleSac;

		switch(poids){
			case 1 :
				tailleSac = "petit";
				break;
			case 2 :
				tailleSac = "moyen";
				break;
			default:
				if(poids > 2){
					tailleSac = "grand";
				}else{
					tailleSac = "ERROR";
				}
				break;
		}

		System.out.println(" Le sac est "+ tailleSac);
	}
}