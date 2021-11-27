
/**
 * Beschreiben Sie hier die Klasse Lager.
 * 
 * @author Felician 
 * @version 27.11.2021
 */

import Liste.*;
import java.util.Iterator;

public class Lager
{
    /**
     * Maximale Anzahl von Lagerflaechen im Lagerplatz.
     */
    private static final int MAX_LAGERFLAECHE = 20; // */
    
    /**
     * Eine Liste mit Lagerflächen.
     * 
     * Jedes Element der Liste nimmt einen Artikel auf, der dort gelagert wird.
     * Für eine bestimmte Artikelsorte (etwa Klohpapier) kann es nur ein Listenelement
     * geben, auf dem diese Artikelsorte gelagert wird.
     * 
     * Die Implementierung dieses Lagers garantiert, dass das Lager nie mehr als
     * {@link #MAX_LAGERFLAECHE} Lagerflaechen enthalten kann.
     */
    private List<Lagerflaeche> Lagerplatz;
    
    /**
     * Konstruktor für Objekte der Klasse Lager
     */
    public Lager(String pN)
    {
        Lagerplatz = new List<>();
    }

    /**
     * Fuegt dem Lager einen neuen Lagerplatz hinzu.
     * 
     * Falls alle Lagerflaechen im Lagerplatz bereits belegt sind (maximale Anzahl
     * Lagerflaechen im Lagerplatz ist bereits erreicht), dann Fehlermeldung.
     * Falls das Lager bereits einen Lagerplatz für den Artikel enthält, dann Fehlermeldung.
     * Falls das Lager noch keinen Lagerplatz für den Artikel enthält, dann wird ein leerer Lagerplatz angelegt.
     * 
     * @param artikel Typ des Artikel, der auf dem neuen Lagerplatz gelagert wird
     * @param name    beliebiger Name, mit dem der Lagerplatz ansprechbar ist
     */
    public void LagerplatzHinzufuegen(Artikel artikel, String name)
    {
        // --- Prüfe, ob die maximale Anzahl von Lagerflaechen schon erreicht ist.
        final int anzahlBelegterLagerflaechen = Lagerplatz.size();
        if (anzahlBelegterLagerflaechen < MAX_LAGERFLAECHE) {
            // ... es ist noch Platz im Lagerplatz
            //     => neue Lagerflaeche hinzufügen
        
            // --- Suche, ob es für diesen Artikel im Lager schon einen Platz gibt.
            //     Falls ja, dann Fehlermeldung.
            final String artikelName = artikel.getName();
            final int bestand = bestand(artikelName);
        
             if (bestand >= 0) {
                // ... so einen Artikel gibt es schon im Lager
                //     => Fehlermeldung und Abbruch
                System.out.println("Den Artikel mit Namen " + artikelName + " gibt es schon");
                
                return;
            } // end if
            // ... so einen Artikel gibt es im Lager noch nicht
            //     => passende, neue Lagerflaeche anlegen
        
            // --- neues Listenelement anlegen
            final Lagerflaeche neueFlaeche = new Lagerflaeche(artikel, name);
            Lagerplatz.add(neueFlaeche); // neue Lagerflaeche im Lager belegen
        } else {
            // ... es ist kein Platz mehr im Lagerplatz
            //     => Fehlermeldung
            System.out.println("Alle Lagerflaechen im Lager sind bereits belegt.");
        } // end else
    } // end method */
    
    /**
     * Entfernt eine Lagerflaeche.
     * 
     * Die Methode sucht nach einer beliebigen Lagerflaeche, die aktuell leer ist.
     * Falls so eine Lagerflaeche gefunden wird, dann wird diese entfernt.
     * Falls so eine Lagerflaeche nicht gefunden wird, dann Fehlermeldung.
     * Es wird maximal eine Lagerflaeche entfernt.
     */
    public void lagerflaecheEntfernen() {
        final int size = Lagerplatz.size();
        
        // --- Implementierung 1: entfernt die erste leere Lagerflaeche
        for (int index = 0; index < size; index++) {
            final Lagerflaeche lagerflaeche = Lagerplatz.get(index);
                final Stack stack = lagerflaeche.getStack();
                final int bestand = stack.size();
                
                if (0 == bestand) {
                    // ... aktuelle Lagerflaeche ist leer
                    //     => entferne diese Lagerflaeche und beende diese Methode
                    Lagerplatz.remove(index); // Lagerflaeche in den Mülleimer (garbage)
                    
                    return;
                }
        } // end for (index ...)
        // ende Implementierung 1 */
        
        /*/ --- Implementierung 2: entfernt die letzte leere Lagerflaeche
        for (int index = size; index-- > 0;) {
            final Lagerflaeche lagerflaeche = Lagerplatz.get(index);
                final Stack stack = lagerflaeche.getStack();
                final int bestand = stack.size();
                
                if (0 == bestand) {
                    // ... aktuelle Lagerflaeche ist leer
                    //     => entferne diese Lagerflaeche und beende diese Methode
                    Lagerplatz.remove(index);
                    
                    return;
                }
        } // end for (index ...)
        // ende Implementierung 2 */
    } // end method */
    
    /**
     * Sucht eine Lagerflaeche anhand des Artikelnamens.
     * 
     * Falls so eine Lagerflaeche existiert, dann wird diese zurückgegeben.
     * Falls so eine Lagerflaeche nicht existiert, dann Fehlermeldung.
     * 
     * @param name des Artikels, für den die Lagerflaeche gesucht wird.
     * 
     * @return Lagerflaeche mit passendem Artikel,
     *         oder null, wenn so eine Lagerflaeche nicht existiert
     */
    public Lagerflaeche sucheLagerflaeche(String name)  {
        Lagerplatz.forEach(lagerflaeche -> {
            final Artikel artikel = lagerflaeche.getArtikel();
            final String artikelName = artikel.getName();
            
            if (name.equals(artikelName)) {
                // ... die aktuelle betrachtete Lagerfläche hat einen Artikel mit demselben Namen wie
                //     der Parameter "name" im Funktionsaufruf
                //     => Lagerflaeche zurückgeben
                return lagerflaeche;
            } // end if
        });
        // ... es wurde kein Artikel mit passenden Namen gefunden
        
        System.out.println("Lagerfläche für Artikel mit Namen " + name + " nicht vorhanden");
        
        return null;
    } // end method */
    
    /**
     * Sucht eine Lagerflaeche anhand der Artikelnummer (EAN).
     * 
     * Falls so eine Lagerflaeche existiert, dann wird diese zurückgegeben.
     * Falls so eine Lagerflaeche nicht existiert, dann Fehlermeldung.
     * 
     * @param ean des Artikels, für den die Lagerflaeche gesucht wird.
     * 
     * @return Lagerflaeche mit passendem Artikel,
     *         oder null, wenn so eine Lagerflaeche nicht existiert
     */
    public Lagerflaeche sucheLagerflaeche(int ean)  {
        Lagerplatz.forEach(lagerflaeche -> {
            final Artikel artikel = lagerflaeche.getArtikel();
            final String artikelEan = artikel.getEan();
            
            if (ean == artikelEan) {
                // ... die aktuelle betrachtete Lagerfläche hat einen Artikel mit derselben EAN wie
                //     der Parameter "EAN" im Funktionsaufruf
                //     => Lagerflaeche zurückgeben
                return lagerflaeche;
            } // end if
        });
        // ... es wurde kein Artikel mit passender EAN gefunden
        
        System.out.println("Lagerfläche für Artikel mit EAN " + ean + " nicht vorhanden");
        
        return null;
    } // end method */
    
    
    /**
     * Sucht anhand eines Artikelnames nach einer Lagerflaeche, wo dieser gelagert wird.
     * 
     * Falls eine Lagerflaeche mit passendem Namen gefunden wird, dann wird der aktuell dort
     * gelagerte Bestand zurückgemeldet.
     * 
     * Falls keine Lagerflaeche mit passendem Namen gefunden wird, dann Fehlermeldung.
     * 
     * @param name Name des Artikels, für den der Bestand zurückgemeldet wird.
     * 
     * @return entweder eine Zahl >= 0, wenn eine Lagerflaeche mit passendem Artikel gefunden wird,
     *         oder -1, wenn so eine Lagerflaeche nicht gefunden wird
     *
    public int bestand(String name) {
        Lagerplatz.forEach(lagerflaeche -> {
            final Artikel artikel = lagerflaeche.getArtikel();
            final String artikelName = artikel.getName();
            
            if (name.equals(artikelName)) {
                // ... die aktuelle betrachtete Lagerfläche hat einen Artikel mit demselben Namen wie
                //     der Parameter "name" im Funktionsaufruf
                //     => Bestand zurückgeben
                final Stack stack = lagerflaeche.getStack();
                final int bestand = stack.size();
                
                return bestand;
            } // end if
        });
        // ... es wurde kein Artikel mit passenden Namen gefunden
        
        System.out.println("Artikel mit Namen " + name + " nicht vorhanden");
        
        return -1;
    } // end method */
    
    /**
     * Sucht anhand einer Artikelnummer (EAN) nach einer Lagerflaeche, wo dieser gelagert wird.
     * 
     * Falls eine Lagerflaeche mit passender EAN gefunden wird, dann wird der aktuell dort
     * gelagerte Bestand zurückgemeldet.
     * 
     * Falls keine Lagerflaeche mit passender EAN gefunden wird, dann Fehlermeldung.
     * 
     * @param ean des Artikels, für den der Bestand zurückgemeldet wird.
     * 
     * @return entweder eine Zahl >= 0, wenn eine Lagerflaeche mit passendem Artikel gefunden wird,
     *         oder -1, wenn so eine Lagerflaeche nicht gefunden wird
     *
    public int bestand(int ean) {
        Lagerplatz.forEach(lagerflaeche -> {
            final Artikel artikel = lagerflaeche.getArtikel();
            final int artikelEAN = artikel.getEAN();
            
            if (ean == artikelEAN) {
                // ... die aktuelle betrachtete Lagerfläche hat einen Artikel mit demselben EAN wie
                //     der Parameter "ean" im Funktionsaufruf
                //     => Bestand zurückgeben
                final Stack stack = lagerflaeche.getStack();
                final int bestand = stack.size();
                
                return bestand;
            } // end if
        });
        // ... es wurde kein Artikel mit passender EAN gefunden
        
        System.out.println("Artikel mit EAN " + ean + " nicht vorhanden");
        
        return -1;
    } // end method */
}

