package tri;

public class TriRapide {
	/** 
	 * partager les éléments d’un sous−tableau en 2 parties.
	 * @param T : tableau à partager
	 * @param binf, bsup : indices du premier et du dernier élément du sous-tableau à partager
	 * @pre 0 ≤ binf, bsup < T.length
	 * @post partage les éléments de T compris entre les indices binf et bsup selon le principe
	 * décrit au paragraphe 2.2 et met le pivot à sa place.
	 * @return indice auquel a été placé le pivot
	 */
	static int partager(int[] T, int binf, int bsup) {
		assert 0 <= binf && bsup < T.length : "Echec : 0 <= binf && bsup < T.length";
		while(binf < bsup) {
			while(binf < bsup) {
				if(T[bsup] <= T[0]) 
					break;
				bsup--;
			}
			while(binf < bsup) {
				if(T[binf] > T[0])
					break;
				binf++;
			}
			if(binf < bsup) {
				int tmp = T[binf];
				T[binf] = T[bsup];
				T[bsup] = tmp;
			}
			else {
				int tmp = T[binf];
				T[binf] = T[0];
				T[0] = tmp;
			}
		}
		return binf;
	}
	
	/** 
	 * triRapide : trier récursivement un sous−tableau (algorithme du tri rapide)
	 * @paramT : tableau à trier
	 * @param binf, bsup : indices du premier et du dernier élément du sous-tableau à trier
	 * @pre 0 ≤ binf, bsup < T.length
	 */
	static void triRapide(int[] T, int binf, int bsup) {
		int pivot = partager(T, binf, bsup);
		if(binf < pivot - 1)
			triRapide(T, binf, pivot - 1);
		if(bsup > pivot + 1)
			triRapide(T, pivot + 1, bsup);
	}
	
	/** 
	 * trier : trier un tableau par ordre croissant avec l’algorithme du tri rapide
	 * @param T : tableau à trier
	 * @param nb : nombre d’éléments à trier dans le tableau
	 * @pre 1 < nb ≤ T.length
	 */
	public static void trier(int[] T, int nb) {
		
	}
}
