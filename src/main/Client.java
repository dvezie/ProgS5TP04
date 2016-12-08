package main;

import java.util.Scanner;
import outilsTris.OutilsTris;
import tri.TriTas;

public class Client {
	
	public static void verifTabTrie(int[] tab){
		for(int i=0;i<tab.length-1;i++){
			if(tab[i]>tab[i+1]){
				System.out.println("!!! Tableau non trié !!!");
			}
		}
	}
	
	public static void main(String[] args){		
		long temps;
		Scanner input = new Scanner(System.in);
		System.out.println("\nSaisir le nom du fichier contenant le tableau à trier : ");
		String fichierNonTrie = input.nextLine();
		input.close();
		int[] tab = OutilsTris.lireTableau(fichierNonTrie);
		temps=OutilsTris.getInstantPresent();
		TriTas.trier(tab, tab.length);
		temps=OutilsTris.getInstantPresent()-temps;
		verifTabTrie(tab);
		String fichierTrie = "trie";
		OutilsTris.enregistrerTableau(tab, tab.length, fichierTrie, "TriTas");
		System.out.println("Opération complété, temps d'éxécution du tris : "+temps+" millisesondes.");		
	}
}
