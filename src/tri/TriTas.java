package tri;

public class TriTas {
	
	/**
	echanger la place de deux éléments dans le tableau
	@param tnb : tableau d'éléments
	@param p1 : indice du premier élément
	@param p2 : indice du deuxième élément
	@pre 0 <= p1 < tnb.length
	@pre 0 <= p2 < tnb.length
	@post les éléments aux indices p1 et p2 ont échanger de place
	*/
	static void echanger(int[] tnb, int p1, int p2){
		assert(0<=p1 && p1<tnb.length);
		assert(0<=p2 && p2<tnb.length);
		int varStock=tnb[p1];
		tnb[p1]=tnb[p2];
		tnb[p2]=varStock;
	}
	
	/**
	ré-organiser le tas de manière à ce que l'élément situé à l'indice p soit remis à sa place
	@param tnb : tableau d'éléments
	@param p : indice de l’élément à remettre à sa place
	@param nbElem : indice de l’élément à partir du quel il ne faut plus modifier le tableau
	@pre 0 <= p < tnb.length
	@post l'élément (anciennement/présentement) situé à l'indice p est à sa place
	*/
	static void reOrganiser(int[] tnb, int p, int nbElem){
		assert(0<=p && p<tnb.length);
		int sommet=p, filsGauche=2*p+1, filsDroit=2*p+2;
		if(filsGauche>=nbElem){					// si feuille -> rien
		}else if(filsDroit==nbElem){			// si uniquement fils gauche
			if(tnb[sommet]<tnb[filsGauche]){				
				echanger(tnb,sommet,filsGauche);			
			}
		}else if(filsDroit<nbElem){				// si fils gauche et fils droit
			int filsMax=filsDroit, filsMin=filsGauche;
			if(tnb[filsMin]>tnb[filsMax]){
				filsMax=filsGauche;
				filsMin=filsDroit;
			}
			if(tnb[sommet]<tnb[filsMax]){		// on essaye de remplacer en priorité par le plus grand fils
				echanger(tnb,sommet,filsMax);
				reOrganiser(tnb,filsMax,nbElem);
			}else if(tnb[sommet]<tnb[filsMin]){
				echanger(tnb,sommet,filsMin);
				reOrganiser(tnb,filsMin,nbElem);
			}
		}			
	}
	
	/**
	ajoutert nb[p] au tas formé par les p premiers éléments du tableau tnb.
	@param tnb : tableau dont les p premiers éléments forment un tas
	@param p : indice de l’élément à ajouter au tas
	@pre 1 <= p < tnb.length
	@post les p+1 premiers éléments du tableau tnb forment un tas
	*/
	static void ajouterTas(int[] tnb, int p){
		assert(1<=p && p<tnb.length);
		int sommet=p, pere=(p-1)/2;
		while(tnb[sommet]>tnb[pere]){
			echanger(tnb,sommet,pere);
			sommet=pere;
			pere=(pere-1)/2;
		}
	}
	/**
	supprimer l’élément maximum du tas et réorganiser le reste du tas.
	@param tnb : tableau d ont les p premiers éléments forment un tas
	@param p : nombre d ’ éléments dans le tas
	@pre 1 < p <= tnb.length
	@post : place l’élément maximum en tnb [p-1]; les p-1 premiers éléments de tnb forment un tas
	*/
	static void supprimerMax(int[] tnb, int p){
		assert(1<p && p<=tnb.length);
		echanger(tnb,p-1,0);
		reOrganiser(tnb,0,p-1);
	}
	/**
	trier un tableau d’entiers en ordre croissant avec l’algorithme du tri par tas
	@param tnb : tableau à trier
	@param nb : nombre d’élémentsdansletableau
	@pre 1 <= nb <= tnb.length
	*/
	public static void trier(int[] tnb, int nb){
		assert(1<=nb && nb<=tnb.length);
		for(int p=1;p<nb;p++){		//p=1 initialement car le premier élément correspond au tas de taille 1
			ajouterTas(tnb, p);
		}
		for(int p=nb;p>1;p--){
			supprimerMax(tnb,p);
		}		
	}
}
