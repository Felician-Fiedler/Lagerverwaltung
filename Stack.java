 

/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2018
 * </p>
 * <p>
 * Generische Klasse Stack<ContentType>
 * </p>
 * <p>
 * Objekte der generischen Klasse Stack (Stapel/Keller) verwalten beliebige
 * Objekte vom Typ ContentType nach dem Last-In-First-Out-Prinzip, d.h., das
 * zuletzt abgelegte Objekt wird als erstes wieder entnommen. Alle Methoden haben
 * eine konstante Laufzeit, unabhaengig von der Anzahl der verwalteten Objekte.
 * </p>
 * 
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule
 * @version Generisch_02 2014-02-21
 */
public class Stack<ContentType> {
	
	/* --------- Anfang der privaten inneren Klasse -------------- */
	
	private class StackNode {

		private ContentType content = null;
		private StackNode nextNode = null;

		/**
		 * Ein neues Objekt vom Typ StackNode<ContentType> wird erschaffen. 
		 * Der Inhalt wird per Parameter gesetzt. Der Verweis ist leer.
		 * 
		 * @param pContent das Inhaltselement des Knotens vom Typ ContentType
		 */
		public StackNode(ContentType pContent) {
			content = pContent;
			nextNode = null;
		}

		/**
		 * Der Verweis wird auf das Objekt, das als Parameter uebergeben wird,
		 * gesetzt.
		 * 
		 * @param pNext der Nachfolger des Knotens
		 */
		public void setNext(StackNode pNext) {
			nextNode = pNext;
		}
		
		/**
		 * Liefert das naechste Element des aktuellen Knotens.
		 * 
		 * @return das Objekt vom Typ StackNode, auf das der aktuelle Verweis zeigt
		 */
		public StackNode getNext() {
			return nextNode;
		}

		/**
		 * Liefert das Inhaltsobjekt des Knotens vom Typ ContentType.
		 * 
		 * @return das Inhaltsobjekt des Knotens
		 */
		public ContentType getContent() {
			return content;
		}
		
	}
	
	/* ----------- Ende der privaten inneren Klasse -------------- */
	
	private StackNode head;
	private int hoehe;

	/**
	 * Ein leerer Stack wird erzeugt. 
	 * Objekte, die in diesem Stack verwaltet werden, muessen vom Typ
	 * ContentType sein.
	 */
	public Stack() {
		head = null;
	}

	/**
	 * Die Anfrage liefert den Wert true, wenn der Stack keine Objekte enthaelt, 
	 * sonst liefert sie den Wert false.
	 * 
	 * @return true, falls der Stack leer ist, sonst false
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Das Objekt pContentType wird in den Stack eingefügt. 
	 * Falls pContentType gleich null ist, bleibt der Stack unveraendert.
	 * 
	 * @param pContent
	 *            das anzuhaengende Objekt vom Typ ContentType
	 */
	public void push(ContentType pContent) {
		if (pContent != null) {
			StackNode newNode = new StackNode(pContent);
			if (this.isEmpty()) {
				head = newNode;
			} else {
				newNode.setNext(head);
				head = newNode;
			}
			hoehe ++;
		}
	}

	/**
	 * Das erste Objekt wird aus dem Stack entfernt. 
	 * Falls der Stack leer ist, wird sie nicht veraendert.
	 */
	public void pop() {
		if (!this.isEmpty()) {
			head = head.getNext();
			if (this.isEmpty()) {
				head = null;
			}
			hoehe ++;
		}
	}

	/**
	 * Die Anfrage liefert das erste Objekt des Stack. 
	 * Die Stack bleibt unveraendert. 
	 * Falls der Stack leer ist, wird null zurueckgegeben.
	 *
	 * @return das erste Objekt des Stack vom Typ ContentType oder null,
	 *         falls der Stack leer ist
	 */
	public ContentType first() {
		if (this.isEmpty()) {
			return null;
		} else {
			return head.getContent();
		}
	}
	public int getHoehe()
	{
	   return hoehe;
	}
}
