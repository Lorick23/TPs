public class TP05 {
	public static void main(String args[]) {
		int x = Integer.parseInt(args[0]);
		int count = 0;

		/*while(count < x){
			System.out.println(count+"\n");
			count++;
		}*/

		do{
			System.out.println(count+"\n");
			count++;
		}while(count < x);
	}
}