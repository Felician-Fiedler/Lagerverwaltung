
import Liste.*;
/**
 * Beschreiben Sie hier die Klasse Lagerflaeche.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Lagerflaeche
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int hoehe;
    private int laenge;
    private List<Stack<Artikel>> Felder;
    private int nummer;

    public Lagerflaeche(int pH, int pL, int pN)
    {
        // Instanzvariable initialisieren
        hoehe = pH;
        laenge = pL;
        Felder = new List<Stack<Artikel>>();
        nummer = pN;
    }
    
    private Stack generateStack()
    {
        Stack<Artikel> neueArtikel = new Stack<Artikel>();
        return neueArtikel;
    }
    
    public boolean istLeer()
    {
        if (Felder.getLaenge() != 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public double addArtikel(Artikel pA, double anzahl)
    {
        // tragen Sie hier den Code ein
        double nHoehe = hoehe;
        Felder.toFirst();
        while (anzahl > 0 && !this.istLeer() && Felder.getContent() != null)
        {
            if (Felder.getContent().first() != null)
            {
                if (pA.getArtikelnummer() == Felder.getContent().first().getArtikelnummer() && pA.getKundennummer() == Felder.getContent().first().getKundennummer())
                {
                    while (Felder.getContent().getHoehe() < nHoehe)
                    {
                        Felder.getContent().push(pA);
                        anzahl --;
                    }
                }
            }
            Felder.next();
        }
        if (Math.ceil(anzahl / nHoehe) <= (laenge - Felder.getLaenge()))
        {
            for (double stackZahl = Math.ceil(anzahl / nHoehe); stackZahl > 0; stackZahl --)
            {
                Felder.append(generateStack());
                Felder.toLast();
                if (anzahl <= nHoehe)
                {
                    for (double i = anzahl; i > 0; i--)
                    {
                        Felder.getContent().push(pA);
                    }
                }
                else
                {
                    for (double i = nHoehe; i > 0; i--)
                    {
                    Felder.getContent().push(pA);
                    }
                    anzahl -= nHoehe;
                }
            }
            return 0;
        }
        
        else
        {
            for (int stackCount = laenge - Felder.getLaenge(); stackCount > 0; stackCount --)
            {
                Felder.append(generateStack());
                Felder.toLast();
                for (double i = nHoehe; i > 0; i--)
                {
                    Felder.getContent().push(pA);
                }
                anzahl -= nHoehe;
            }
            return anzahl;
        }
    }
   /* public int getAnteilArtikel(int pAN, int pKN)
    {
      Felder.toFirst();
      int anteil = 0;
      int wert = 0;
        while (! this.istLeer())
        {
            if (Felder.getContent() != null && Felder.getContent().first() != null)
            {
                if (pAN == Felder.getContent().first().getArtikelnummer() && pKN == Felder.getContent().first().getKundennummer())
                {
                    wert += Felder.getContent().getHoehe();
                }
            }
            else
            {
                if (Felder.getLaenge() != 0)
                {
                    anteil = wert / Felder.getLaenge();
                    return anteil;
                }
                else
                {
                    return 0;
                }
            }
            Felder.next();
        }
    }*/
    public double anteilVonArtikel(int pAN, int pKN)
    {
        if (! this.istLeer())
        {
            double anteil;
            int len = Felder.getLaenge();
            int ges = 0;
            Felder.toFirst();
            while (Felder.getContent() != null && Felder.getContent().first() != null)
            {
                if (pAN == Felder.getContent().first().getArtikelnummer() && pKN == Felder.getContent().first().getKundennummer())
                {
                    ges += Felder.getContent().getHoehe();
                }
                Felder.next();
            }
            anteil = ges / len;
            return anteil;
        }
        else
        {
            return 0;
        }
    }
    public int entferne(int anzahl, int pAN, int pKN)
    {
        Felder.toFirst();
        if (! this.istLeer())
        {
           while (anzahl > 0 && Felder.getContent() != null)
           {
               if (Felder.getContent().first().getArtikelnummer() == pAN && Felder.getContent().first().getKundennummer() == pKN)
               {
                   if (Felder.getContent().getHoehe() <= anzahl)
                   {
                       anzahl -= Felder.getContent().getHoehe();
                       Felder.remove();
                   }
                   else
                   {
                       for (int i = anzahl; i > 0; i--)
                       {
                           Felder.getContent().pop();
                       }
                       anzahl = 0;
                   }
               }
               Felder.next();
           }
           return anzahl;
        }
        else
        {
            return anzahl;
        }
    }
    public List getAsList()
    {
        return Felder;
    }
    public int getNummer()
    {
        return nummer;
    }
    public int getHoehe()
    {
        return hoehe;
    }
    public int getLaenge()
    {
        return laenge;
    }
}
