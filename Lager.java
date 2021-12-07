
/**
 * Beschreiben Sie hier die Klasse Lager.
 * 
 * @author Felician 
 * @version 27.11.2021, Version 0.0.1
 */

import Liste.*;
import java.util.Iterator;

public class Lager
{
    /**
     * Maximale Anzahl von Lagerflaechen im Lagerplatz.
     *
    private static final int MAX_LAGERFLAECHE = 20; // */
    
    /**
     * Eine Liste mit Lagerflächen.
     * 
     * Jedes Element der Liste nimmt einen Artikel auf, der dort gelagert wird.
     * Für eine bestimmte Artikelsorte (etwa Klopapier) kann es nur ein Listenelement
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
        Lagerplatz = new List<Lagerflaeche>();
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
    public void LagerplatzHinzufuegen( int pL, int pH)
    {
        nummer = Lagerplatz.getLaenge() + 1;
        nL = Lagerflaeche(pH, pL, nummer);
        Lagerplatz.append(nL);
    } // end method */
    
    /**
     * Entfernt eine Lagerflaeche.
     * 
     * Die Methode sucht nach einer beliebigen Lagerflaeche, die aktuell leer ist.
     * Falls so eine Lagerflaeche gefunden wird, dann wird diese entfernt.
     * Falls so eine Lagerflaeche nicht gefunden wird, dann Fehlermeldung.
     * Es wird maximal eine Lagerflaeche entfernt.
     */
    public boolean lagerflaecheEntfernen(int pN) {
        /*final int size = Lagerplatz.getLaenge();
        
        // --- Implementierung 1: entfernt die erste leere Lagerflaeche
        for (int index = 0; index < size; index++) {
            final Lagerflaeche lagerflaeche = Lagerplatz.get(index);
                final Stack stack = lagerflaeche.getContent();
                final int bestand = stack.getHoehe();
                
                if (0 == bestand) {
                    // ... aktuelle Lagerflaeche ist leer
                    //     => entferne diese Lagerflaeche und beende diese Methode
                    Lagerplatz.remove(index); // Lagerflaeche in den Mülleimer (garbage)
                    
                    return;
                }
        } // end for (index ...)
        // ende Implementierung 1 */
        
        /**
         *   --- Implementierung 2: entfernt die letzte leere Lagerflaeche
         *
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
        Lagerplaetze.toFirst();
        while (Lagerplaetze.getContent() != null)
        {
            if (Lagerplaetze.getContent().getNummer() == pN)
            {
                if (Lagerplaetze.getContent().istLeer())
                {
                    Lagerplaetze.remove();
                    return true;
                }
                else
                {
                    return false;
                }
            }
            Lagerplaetze.next();
        }
        return false;
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
    public int sucheLagerflaeche(int pAN, int pKN)  {
        boolean run = false;
        int flaeche =- 1;
        Lagerplatz.toFirst();
        while (! run && Lagerplatz.getContent() != null)
        {
            if (Lagerplatz.getContent().sucheArtikel(pAN, pKN) != 0)
            {
                flaeche = Lagerplatz.getContent().getNummer();
            }
            Lagerplatz.next();
        }
        return flaeche;
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
     */
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
     */
    public int suche(int ean, int pKN) {
        Lagerplatz.forEach(lagerflaeche -> {
            
            final int artikelnummer = artikel.getArtikelnummer();
            
            if (ean == artikelnummer) {
                // ... die aktuelle betrachtete Lagerfläche hat einen Artikel mit demselben EAN wie
                //     der Parameter "ean" im Funktionsaufruf
                //     => Bestand zurückgeben
                final Stack stack = lagerflaeche.getContent();
                final int bestand = stack.getHoehe();
                
                return bestand;
            } // end if
        });
        // ... es wurde kein Artikel mit passender EAN gefunden
                return -1;
    } // end method */
    public int suche(int pAN, pKN)
    {
        Lagerplaetze.toFirst();
        
        while (Lagerplaetze.getContent() != null)
        {
            Lagerplaetze.getContent().toFirst();
        
            while (Lagerplaetze.getContent().getContent() != null)
            {
                Lagerplaetze
                Lagerplatze.getContent().next();
            }
            Lagerplatze.next();
        }
    }

}
