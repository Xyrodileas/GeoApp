/**
 * Classe pour les diff�rents tris
 * @author i7
 *
 */
public abstract class Triage {

    public void bubbleSort(ListePerso lt) throws ListeVideException, Exception{
        boolean trie = false;
        Formes pivot;

        do{
            lt.premier();
            pivot = (Formes)lt.getElement();
            for(int i=0;i<10;i++){
                trie=true;
                lt.suivant();
                if(pivot.getIDLogger() <= ((Formes) lt.getElement()).getIDLogger()){
                    Formes tmp = (Formes)lt.getElement();
                    lt.supprime();
                    lt.ajoute(tmp,0);
                    trie=false;
                }
            }

        }while(!trie);

    }


//    procédure tri_bulle(tableau T, entier n)
//    faire
//            échange_effectué = faux
//    pour j de 1 à n - 1
//    si T[j] > T[j + 1], alors
//    échanger T[j] et T[j + 1]
//    échange_effectué = vrai
//    fin si
//    fin pour
//    tant que échange_effectué = vrai
//    fin procédure
}
