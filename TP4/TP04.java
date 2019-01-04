public class TP04 {
	public static void main(String args[]) {

		float achat = Float.parseFloat(args[0]);
		float remise;
		float achatAvcRemise;

		if(achat < 1000){
			remise = 0;
		}
		else if(achat < 2000){
			remise = 1;
		}
		else if(achat < 5000){
			remise = 3;
		}
		else{
			remise = 5;
		}

		achatAvcRemise = achat - (achat * (remise/100));
		System.out.println("L'achat avec la remise vaut "+achatAvcRemise);

	}
}