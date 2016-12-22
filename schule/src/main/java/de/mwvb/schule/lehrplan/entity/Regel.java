package de.mwvb.schule.lehrplan.entity;

/**
 * Eine Einplanungsregel legt fest, welche Kriterien zwingend erf�llt sein m�ssen, damit eine Unterrichtsstunde
 * in den Stundenplan einer Klasse eingetragen werden darf. Beispiel: Lehrer muss verf�gbar sein.
 */
public interface Regel {

	/**
	 * @param kontext alle Daten, die f�r die Pr�fung der Regel ben�tigt werden
	 * @return true wenn die Regel erf�llt wird
	 */
	boolean erfuellt(Regelkontext kontext);
}
