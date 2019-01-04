public class TP04_2 {
	public static void main(String args[]) {
		int poids = args[0];
		String tailleSac;

		if(poids == 1){
			tailleSac = "petit";
		}
		else if(poids == 2){
			tailleSac = "moyen";
		}
		else if(poids > 2){
			tailleSac = "grand";
		}
		else{
			tailleSac = "ERROR";
		}
	}
}

/*Seconde partie : “switch”
Le but de ce TP est d’utiliser les instructions : switch ... case … default ....
L&#39;exercice consiste à calculer une taille de sac en fonction d’un poids d’entrée.
On définit la taille en fonction d’un poid (entier) :
 “petit” pour un poid de 1kg,
 “moyen” pour un poid de 2kg,
 “grand” pour un poid supérieur à 2kg.
$ java TpJava04 4500 2
4500.0 =&gt; 135.0
moyen*/