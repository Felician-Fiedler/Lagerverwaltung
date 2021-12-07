/**
 * Artikel = eine Europalette mit dem Namen als Inhalt
 */
public class Artikel
{
    
    private String Name;
    private int Artikelnummer;
    private int Kundennummer;
    
    /**
     * Ein neues Objekt vom Typ Artikel wird erschaffen. 
     * 
     * @param pName der Name vom Typ String 
     * @param pArtikelnummer die Artikelnummer vom Typ int 
     * @param pKundennummer die Kundennummer vom Typ int 
     */
    public Artikel(String pName, int pArtikelnummer, int pKundennummer)
    {
        Name = pName;
        Artikelnummer = pArtikelnummer;
        Kundennummer = pKundennummer;
    }

    /**
     * Der Name des Objekts wird zurückgeliefert.
     */
    public String getName() {
        return Name;
    }
    
    /**
     * Die Artikelnummer des Objekts wird zurückgeliefert.
     */
    public int getArtikelnummer() {
        return Artikelnummer;
    }
    
    /**
     * Die Kundennummer des Objekts wird zurückgeliefert.
     */
    public int getKundennummer() {
        return Kundennummer;
    }
}
