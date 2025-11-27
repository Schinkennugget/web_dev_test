///Methode Breitensuche mit start- und endKnoten
void breitensuche(String startKnoten, String endKnoten) {
    ///warteliste und fertig-Liste initialisieren
    ArrayList<String> warteliste = new ArrayList<String>();
    ArrayList<String> fertig = new ArrayList<String>();
    ///String aktuellerKnotenBezeichner initialisieren und ihn auf startknoten setzen. 
    // Dieser zeigt, bei welchem Knoten der Code grade ist.
    String aktuellerKnotenBezeichner = startKnoten;

    //Solange der gesuchte Knoten nicht abgearbeitet wurde
    while (!fertig.get(fertig.size() - 1).bezeichnerGeben().equals(endKnoten)) {
        //Schauen, ob es eine Kante zwischen dem aktuellen Knoten und einem verbundenen gibt,
        //die noch nicht in der Fertig-Liste sind


        //Der aktuelle Knoten mit allen Kanten, wenn keine da ist, -1
        ArrayList<Integer> kantenVonAktuellemKnoten = matrix.get(knotenBezeichnerGeben(aktuellerKnotenBezeichner));
        
        //Checkt alle Kanten
        for (int i = 0; i < kantenVonAktuellemKnoten.size(); i++) {
            //Wenn eine Kante da ist
            if (kantenVonAktuellemKnoten.get(i) > -1) {
                String andererKnotenBezeichner = knotenBezeichnerGeben(i);
                //Wenn der Knoten, zu dem die Kante noch gehört, noch nicht in der Warte-
                //oder fertig-Liste ist
                if (!fertig.contains(andererKnotenBezeichner) && !warteliste.contains(andererKnotenBezeichner)) {
                    //Knoten zur Warteliste hinzufügen
                    warteliste.add(andererKnotenBezeichner);
                }
            }
        }

        fertig.add(aktuellerKnotenBezeichner);
        if (warteliste.size() > 0) {
            aktuellerKnotenBezeichner = warteliste.get(0);
            warteliste.remove(0);
        } else {
            //Die Warteliste ist leer, alles wurde abgearbeitet
            break;
        }
    }
}
