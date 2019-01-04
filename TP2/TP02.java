public class TP02 {
	public static void main(String args[]) {

		int val1 = 1234;
		float val2 = val1;
		System.out.println("val1 = "+val1+"\nval2 = "+val2+"\n\n");

		val1 = 123456789;
		val2 = val1;
		System.out.println("val1 = "+val1+"\nval2 = "+val2+"\n\n");

		float x = 15f;
		float z = 0f;
		float y = -123;
		float a = x/z;
		float b = y/z;
		float c = a/b;

		System.out.println("x = "+x+"\nz = "+z+"\ny = "+y+"\na = "+a+"\nb = "+b+"\nc = "+c);
	}
}

/*
Convertir un entier en flottant
Le but de ce TP est de visualiser les problèmes de conversion que l’on peut rencontrer.

L&#39;exercice consiste à effectuer une série d’affectation.

Affecter la valeur 1234 à une variable int, le stocker dans une variable de type float et
afficher les deux valeurs par System.out.println(...).
Refaire la même opération avec la valeur 123456789
Afficher les valeurs spéciales des flottants
Le but de ce TP est de visualiser le résultat d’une division par zéro.

L&#39;exercice consiste à effectuer une série de calcul limite.

Affecter la valeur 15 à une variable x de type float.
Affecter la valeur 0 à une variable z de type float.
Affecter la valeur -123 à une variable y de type float.
Affecter la valeur x / z à une variable a de type float.
Affecter la valeur y / z à une variable b de type float.
Affecter la valeur a / b à une variable c de type float.
Afficher toutes les valeurs par System.out.println(...).
*/