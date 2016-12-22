package de.mwvb.schule.lehrplan.entity;

/**
 * Eine Einplanungsregel legt fest, welche Kriterien zwingend erfüllt sein müssen, damit eine Unterrichtsstunde
 * in den Stundenplan einer Klasse eingetragen werden darf. Beispiel: Lehrer muss verfügbar sein.
 */
public interface Regel {

	/**
	 * @param kontext alle Daten, die für die Prüfung der Regel benötigt werden
	 * @return true wenn die Regel erfüllt wird
	 */
	boolean erfuellt(Regelkontext kontext);
}
