/**
 * Classe pour les diff�rents tris
 * @author i7
 *
 */
public abstract class Triage {

    public void SelfSort(ListePerso lt) throws ListeVideException, Exception{
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
                    lt.insererDebut(tmp);
                    trie=false;
                }
            }

        }while(!trie);

    }

    public void bubbleSortByIDLogger(ListePerso lt) throws ListeVideException, Exception{
        boolean trie = true;
        do{
            lt.premier();
            for(int i=0;i<9;i++){

                Formes tmp = (Formes) lt.getElement();
                lt.suivant();
                if(tmp.getIDLogger() > ((Formes) lt.getElement()).getIDLogger()){
                    lt.supprime();
                    lt.ajoute(tmp, 0);
                    trie=false;
                }
            }

        }while(!trie);
    }
    public void bubbleSortByIDLoggerInverted(ListePerso lt) throws ListeVideException, Exception{
        boolean trie = true;
        do{
            lt.premier();
            for(int i=0;i<9;i++){

                Formes tmp = (Formes) lt.getElement();
                lt.suivant();
                if(tmp.getIDLogger() < ((Formes) lt.getElement()).getIDLogger()){
                    lt.supprime();
                    lt.ajoute(tmp, 0);
                    trie=false;
                }
            }

        }while(!trie);
    }
    public void bubbleSortByAir(ListePerso lt) throws ListeVideException, Exception{
        boolean trie = true;
        do{
            lt.premier();
            for(int i=0;i<9;i++){

                Formes tmp = (Formes) lt.getElement();
                lt.suivant();
                if(tmp.getAir() > ((Formes) lt.getElement()).getAir()){
                    lt.supprime();
                    lt.ajoute(tmp, 0);
                    trie=false;
                }
            }

        }while(!trie);
    }
    public void bubbleSortByAirInverted(ListePerso lt) throws ListeVideException, Exception{
        boolean trie = true;
        do{
            lt.premier();
            for(int i=0;i<9;i++){

                Formes tmp = (Formes) lt.getElement();
                lt.suivant();
                if(tmp.getAir() < ((Formes) lt.getElement()).getAir()){
                    lt.supprime();
                    lt.ajoute(tmp, 0);
                    trie=false;
                }
            }

        }while(!trie);
    }
    public void reorganize(ListePerso lt) throws Exception{
        lt.premier();
        ((Formes)lt.getElement()).newPosition(1,1);
        for(int i=0;i<10;i++){
            Formes tmp = (Formes) lt.getElement();
            lt.suivant();
            ((Formes)lt.getElement()).newPosition(tmp.lastx(), tmp.lasty());
        }
    }


}
