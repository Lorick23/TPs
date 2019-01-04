public class TPTab2Dim {
	public static void main(String args[]) {
		int[][] tab = {new int[60], new int[26]};
		int i = 0;
		int j = 0;
		boolean iPlus = true;
		boolean jPlus = true;

		/*if(j < tab[1].length){
			for(i = 0; i < tab[0].length; i++){
				for(j = 0; j < tab[1].length; j++){
					if(i==j){
						System.out.println("tab["+i+"]["+j+"]");
					}
				}
			}
		}*/

		for(i = 0; i < tab[0].length; i++){
			if(jPlus){
				for(j = 0; j < tab[1].length; j++){
				if(i==j){
					System.out.println("tab["+i+"]["+j+"]");
				}
				}
			}
			
			if(!jPlus){
				for(j = tab[1].length; j >= 0; j--){
				if(i==j){
					System.out.println("tab["+i+"]["+j+"]");
				}
				}
			}
			
			//System.out.println("j "+j);
			//System.out.println(tab[1].length -1);

			if(i == tab[0].length){
				iPlus = false;
			}
			if(j == tab[1].length){
				jPlus = false;
				System.out.println("ca passe");
			}

		}
	}
}