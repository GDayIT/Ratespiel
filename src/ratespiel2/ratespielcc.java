package ratespiel2;

import java.io.Console;
import java.util.Random;
import java.util.Scanner;

/**
 * @Autor Georgiou
 * 

 *        Ein Spiel, in dem zwei Spieler eine Zahl sich gegenseitig zu erraten versuchen.
 *        
 */

public class ratespielcc {
	
	
	
	
	
	// Konstanten
	private static final String WILLKOMMEN = "WILLLKOMMEN BEIM GROSSEN RATE SPIEL!\nSIE SIND HERZLICHST EINGELADEN MIT COMPUTER ODER FREUNDEN ZU SPIELEN!\n\n";
	private static final String SPIELER_MODUS = "Hallo Spieler was willst du Spielen?\n\tGib 1 für Einzelspieler (gegen Computer),\n\toder 2 für Mehrspieler (gegen Freunde): ";
	private static final String SPIEL_GESTARTET = "Ich habe eine Zahl zwischen 0 und 10 ausgedacht. Rate sie! \n";
	private static final String SPIEL_GESTARTET1 = "Bitte eine Zahl zwischen 1 und ";
	private static final String SPIEL_GESTARTET2 = " eingeben!";
	private static final String EXCEPTION = "Ungültige Auswahl. Bitte erneut versuchen.\n";
	private static final String SPIELER_MENGE = "Wie viele Spieler gibt es?\n" + "Gib die Anzahl ein: ";
	
	private static final String SPIELER_X = "\nSpieler 1: Denke dir eine Zahl zwischen 0 und ";
	private static final String SPIELER_Y = "Spieler 2: Denke dir eine Zahl zwischen 0 und ";
	private static final String SPIELER_X2 = "Spieler 1 du bist dran!\nDeine versuche: \n";
	private static final String SPIELER_Y2 = "Spieler 2 du bist dran!\nDeine versuche: \n";
	
	
	/**
	 * Erweiterung_____________________________________________________________________
	 */
	private static final String SPIELER_NTE_MODUS = "Spieler ";
	private static final String SPIELER_NOETIG = "Mindestens 2 Spieler sind nötig für den Mehrspielermodus.\n";
	private static final String HAST = "\nDu darfst ";
	private static final String VERSUCH = " mal raten!";
	private static final String SPIELER_NTE_0 = "du bist dran!\n";
	private static final String SPIELER_NTE_1 = "Gewinner ist Spieler!!! ";
	private static final String SPIEL_MMODUS_ENDE = " !!!\n";
	private static final String SPIELER_MODUS_GEWINNT = " GEWINNT!";
	private static final String SPIELER_MODUS_VERLIERT1 = " Die ";
	private static final String SPIELER_MODUS_VERLIERT = " anderen VERLIEREN!\n";
	private static final String SPIELER_MODUS_VERLIERER = "Beim nächsten mal klappt es vielleicht!";
	private static final String SPIELER_MODUS_VERSUCH = " versuch, sonst heißt es gleich next please!\n";
	private static final String KEINER_GE1 = "Gewinner ist 1! Leute versucht es beim nächsten mal besser. Die Zahle war..\n";
	
	/**
	 * ________________________________________________________________________________
	 */
	
	private static final String VERSUCHE = "Bitte eingeben wie oft der Spieler daneben liegen darf!\n";
	private static final String ZAHL_TIPP = "\nDann tipp mal welche zahl es ist..\nGebe die Zahl ein und drücke die Enter-Taste\n";
	private static final String ZAHL_EINGEBEN = "Gebe die Zahl ein und drücke die Enter-Taste\n";
	private static final String RICHTIG = "Richtig, Herzlichen Glückwunsch!";
	private static final String FALSCH = "\nFalsch, Versuch es noch mal!";
	private static final String NOCH_MAL = "Noch mal spielen? Wenn ja, tippe 1 (und Enter), sonst egal was (und Enter).\n";
	private static final String TSCHUESS = "Tschüss!\nBis zum nächsten Mal :-)";
	private static final String JA = "1";
	private static final String KEINE_ZAHL = "Das war keine Zahl. Ihre eingabe:";
	private static final String RUNDEN_FRAGE = "Wie viele Runden möchtest du spielen?";
	private static final String ZU_VIEL = "Ist schon ziemlich viel!";
	private static final String ZU_WENIG = "Ist schon ziemlich wenig!";
	private static final String RUNDEN = "Runde ";
	private static final String VON = " von ";
	private static final String AUS = " aus!\n";
	private static final String N = " \n";
	
	private int spielerModus;
	private int rundenLauf;
	private int spielerMenge;
	private int meineZahl;
	private int grenze = 10;
	private int grenze2 = 100;
	
	private final Scanner scan = new Scanner(System.in);
    private final Random random = new Random();


	

	/**
	 * Standardkonstruktor + Willkommenstext
	 */
	public ratespielcc() {
		super();
		willk();
		starteEinSpiel();
		
	}
	private void willk() {
		ausgabe(WILLKOMMEN);
	}

	/**
	 * In dieser Methode wird das eigentliche Spiel gestartet.
	 */
	private void starteEinSpiel() {
		ausgabe(SPIELER_MODUS);
        spielerModus = zahlEinlesen();

        if (spielerModus == 1) {
            einzelspielerModus();
        } else if (spielerModus == 2) {
            mehrspielerModus();
        } else {
            ausgabe(EXCEPTION);
            starteEinSpiel();
        }
//		spielerMenge();
//		ausgabe(RUNDEN_FRAGE);
//		rundenLauf = zahlEinlesen();
//		meineZahl = ausdenken(grenze);
////		System.out.println(meineZahl);
//		ausgabe(SPIEL_GESTARTET);
		
		spieleEineRunde();
	}
	
	
	private void einzelspielerModus() {
        ausgabe(RUNDEN_FRAGE);
        rundenLauf = zahlEinlesen();

        for (int runde = 1; runde <= rundenLauf; runde++) {
            ausgabe(RUNDEN + runde + VON + rundenLauf);
            int geheimZahl = random.nextInt(grenze + 1);
            boolean korrekt = false;
            while (!korrekt) {
                ausgabe(ZAHL_TIPP);
                int getippt = zahlEinlesen();
                if (getippt == geheimZahl) {
                    ausgabe(RICHTIG);
                    korrekt = true;
                } else {
                    ausgabe(FALSCH);
                    ausgabe(getippt < geheimZahl ? ZU_WENIG : ZU_VIEL);
                }
            }
        }
        wiederholeDasSpiel();
    }

	
	
	
	
	

	/**
	 * 
	 * In dieser Methode wird ermittelt wieviele runden und spieler am spiel teilnehmen sollen.
	 * Wenn mehr als zwei logik ändern.
	 * 
	 */

	private void mehrspielerModus() {
		try {
		ausgabe(RUNDEN_FRAGE);
		rundenLauf = zahlEinlesen();
		ausgabe(SPIELER_MENGE);
		spielerMenge = zahlEinlesen();
		
		if(spielerMenge < 2) {
			ausgabe(SPIELER_NOETIG);
			return;
		}
		
		ausgabe(VERSUCHE);
		int maxVersuche = zahlEinlesen();
		
		
		Console console = System.console();
		
		
		for (int runde = 1; runde <= rundenLauf; runde++) {
			ausgabe(RUNDEN + runde + VON + rundenLauf);
			
			int geheimZahl;
			int aktuellerSpieler = ((runde - 1) % spielerMenge) + 1;

			do {
			    if (console != null) {
			        char[] input = console.readPassword(SPIELER_NTE_MODUS + aktuellerSpieler + SPIELER_X + grenze2 + AUS + ZAHL_EINGEBEN);
			        geheimZahl = Integer.parseInt(new String(input));
			    } else {
			        ausgabe(SPIELER_X + grenze2 + AUS  + ZAHL_EINGEBEN);
			        geheimZahl = zahlEinlesen();
			    }

			    if (geheimZahl < 1 || geheimZahl > grenze2) {
			        ausgabe(SPIEL_GESTARTET1 + grenze2 + SPIEL_GESTARTET2);
			    }

			} while (geheimZahl < 1 || geheimZahl > grenze2);
            
            boolean korrekt = false;
            int versuche = 1;
            
			
            if (spielerMenge == 2) {
                // 2-Spieler-Modus: Spieler 2 rät
            	int ratenderSpieler = (aktuellerSpieler == 1) ? 2 : 1;
            	
                for (int versuch = 1; versuch <= maxVersuche; versuch++) {
	        ausgabe(SPIELER_NTE_MODUS + ratenderSpieler + HAST + versuch + VERSUCH + N + ZAHL_EINGEBEN);
            int tipp = zahlEinlesen();
            
            if (tipp == geheimZahl) {
            	ausgabe(RICHTIG);
            	korrekt = true;
            	break;
            } else {
                ausgabe(FALSCH);
                ausgabe(tipp < geheimZahl ? ZU_WENIG : ZU_VIEL);
            }
			}
            //hier soll nur ein versuch möglich sein und mit jeder runde einem neuen spieler die möglichkeit geboten werden
		} else {
			
		
			for (int spieler = 1; spieler <= spielerMenge; spieler++) {
                if (spieler == aktuellerSpieler) continue;

                for (int versuch = 1; versuch <= maxVersuche; versuch++) { 
            	ausgabe(SPIELER_NTE_0 + aktuellerSpieler + ZAHL_TIPP + versuche + SPIELER_MODUS_VERSUCH + RUNDEN + rundenLauf);
            	int tippen = zahlEinlesen();
            	
            	if (tippen == geheimZahl) {
            		ausgabe(SPIELER_NTE_1 + aktuellerSpieler + SPIEL_MMODUS_ENDE + SPIELER_NTE_MODUS + aktuellerSpieler + SPIELER_MODUS_GEWINNT + SPIELER_MODUS_VERLIERT1 +  (spielerMenge - 1) + SPIELER_MODUS_VERLIERT + SPIELER_MODUS_VERLIERER);
            		korrekt = true;
            		break;
            	
            	} else {
            		ausgabe(SPIELER_NTE_0 + SPIELER_NTE_MODUS + aktuellerSpieler + FALSCH);
            		ausgabe(tippen < geheimZahl ? ZU_WENIG : ZU_VIEL);
            			}
            		}
            	if (korrekt) break;
				}
            	}
			
            if (!korrekt) {
            	ausgabe(KEINER_GE1 + geheimZahl);
            
            }
            
		}
	   
		 wiederholeDasSpiel();
		 
	} catch (NumberFormatException e) {
        ausgabe("FEHLER: Ungültige Zahl eingegeben.");
	} catch (Exception e) {
        ausgabe("Ein unerwarteter Fehler ist aufgetreten: " + e.getMessage());
	}
}
	

	/**
	 * Hier wird eine komplette Spielrunde absolviert.
	 */
	private void spieleEineRunde() {

		ausgabe(ZAHL_EINGEBEN);
		int zahl = zahlEinlesen();

		if (zahl == meineZahl) {
			ausgabe(RICHTIG);
			wiederholeDasSpiel();
		} else {
			ausgabe(FALSCH);

		} if (zahl < meineZahl) {
            ausgabe(ZU_WENIG);
        		} else if (zahl > meineZahl) {
        			ausgabe(ZU_VIEL);
        		} else {
    		
        			ausgabe(RICHTIG);
        		}
		spieleEineRunde();
	}

	
	

	
	
	
	
	/**
	 * Hier wird evaluiert, ob der Spieler noch mal spielen möchte. Davon häng die
	 * weitere Vorgehensweise ab.
	 */
	private void wiederholeDasSpiel() {

		ausgabe(NOCH_MAL);
		String antwort = textEinlesen();

		if (antwort.equals(JA))
			starteEinSpiel();
		else
			verabschiede();
	}

	/**
	 * Hier wird das Spiel beendet. Wir denken vorausschauend: Hier können
	 * eventuelle weitere Aufgaben erledigt werden, z.B. speichern
	 */
	private void verabschiede() {
		ausgabe(TSCHUESS);
		System.exit(0);
	}

	/**
	 * Generiert eine Zufalszahl aus oder wenn mehrere spieler spielen wird hier die zahl gespeichert und als rundenlauf mit geben eine zahl an je einen spieler zum raten geheim ohne das der anderer spieler die zahl sieht übergeben!
	 * @param grenze2 
	 * 
	 * @return
	 */
	private int ausdenken(int grenze2) {
		
		return random.nextInt(0, grenze) + 1;
		
	}


	/**
	 * Liest die Benutzereingabe als Text ein
	 * 
	 * @return Text
	 */
	private String textEinlesen() {
		return scan.next();
	}

	/**
	 * Liest die Benutzereingabe als eine Zahl ein
	 * 
	 * @return eine Zahl, wenn die Eingabe eine Zahl war, char-Wert entsprechend dem
	 *         ersten Zeichen der Eingabe
	 */
	private int zahlEinlesen() {
		String eingabe = textEinlesen();
		int zahl;
		try {
			zahl = Integer.valueOf(eingabe);
		} catch (NumberFormatException e) {
			zahl = eingabe.charAt(0);
			ausgabe(KEINE_ZAHL +" (" + eingabe + ")");
		}
		return zahl;
	}

	/**
	 * Gibt einen Text auf die Konsole aus
	 * 
	 * @param text auszugebene Text
	 */
	private void ausgabe(String text) {
		System.out.println(text);
	}

	/**
	 * Hier startet das Programm.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		new ratespielcc();
		
	}

}




















