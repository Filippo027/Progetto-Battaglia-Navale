import java.io.*;
import java.util.*;

public class GestoreAccesso {
    private final String fileGiocatori;
    private final HashMap<String, String> utenti; // Mappa per memorizzare username e password
    private final HashMap<String, Integer> vittorie; // Mappa per memorizzare le vittorie dei giocatori

    // Costruttore
    public GestoreAccesso(String fileGiocatori) {
        this.fileGiocatori = fileGiocatori;
        this.utenti = new HashMap<>();
        this.vittorie = new HashMap<>();
        //struttura dati che mappa chiavi (identificatori univoci utilizzati per accedere 
        //a un valore specifico all'interno della HashMap) e valori(informazioni associate 
        //a una specifica chiave) . In questo caso, la chiave è una stringa che rappresenta
        //il nome utente, e il valore è una stringa che rappresenta la password

        caricaUtenti();
        caricaVittorie();
    }

    // Metodo per verificare l'accesso di un utente
    public boolean accediGiocatore(String nome, String password) {
        if (utenti.containsKey(nome) && utenti.get(nome).equals(password)) {
            //containsKey verifica se la mappa contiene una mappatura per la chiave specificata
            System.out.println("Accesso riuscito per il giocatore: " + nome);
            return true;
        } else {
            System.out.println("\u001B[31mAccesso negato. Nome utente o password errati.\u001B[0m");
            return false;
        }
    }

    // Metodo per registrare un giocatore
    public void registraGiocatoreInterattivo(String nome, String password) {
        try (Scanner scanner = new Scanner(System.in)) {

            // Salva nome utente e password
            utenti.put(nome, password);
            // Inizializza le vittorie a 0
            vittorie.put(nome, 0);
            //put aggiunge ad una HashMap una coppia di chiave-valore
            
            //Aggiorna i file con i nuovi dati
            salvaUtenti();
            System.out.println("Giocatore " + nome + " registrato con successo!");
        }
    }

    

    // Metodo per salvare una vittoria
    public void salvaVittoria(String nome) {
        if (!vittorie.containsKey(nome)) {
            vittorie.put(nome, 0); // Aggiunge il giocatore se non esiste
        }
        vittorie.put(nome, vittorie.get(nome) + 1); // Incrementa le vittorie

        // Salva le vittorie nel file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("vittorie_" + fileGiocatori))) {
            //BufferedWriter viene usato per scrivere all'interno del file .txt
            for (Map.Entry<String, Integer> entry : vittorie.entrySet()) {
                //Entry permette di accedere a una dingola coppia chiave-valore della HashMap
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
            System.out.println("Vittoria salvata per il giocatore " + nome);
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio della vittoria: " + e.getMessage());
        }
    }

    // Metodo per caricare gli utenti dal file
    private void caricaUtenti() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileGiocatori))) {
            //BufferedReader viene utilizzato per leggere le righe dal file che contiene i dati degli utenti
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    utenti.put(parts[0], parts[1]); // Nome utente e password
                }
            }
            System.out.println("Utenti caricati correttamente.");
        } catch (FileNotFoundException e) {
            System.out.println("File degli utenti non trovato. Verrà creato al salvataggio.");
        } catch (IOException e) {
            System.out.println("Errore durante il caricamento degli utenti: " + e.getMessage());
        }
    }

    // Metodo per salvare gli utenti nel file
    private void salvaUtenti() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileGiocatori))) {
            for (Map.Entry<String, String> entry : utenti.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
            System.out.println("Utenti salvati correttamente.");
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio degli utenti: " + e.getMessage());
        }
    }

    // Metodo per caricare le vittorie dal file
    private void caricaVittorie() {
        String fileVittorie = "vittorie_" + fileGiocatori;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileVittorie))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                //Split viene utilizzato per dividere ogni riga letta dal file in due parti: il nome del giocatore e il numero di vittorie
                if (parts.length == 2) {
                    String nome = parts[0];
                    int count = Integer.parseInt(parts[1]);
                    vittorie.put(nome, count);
                }
            }
            System.out.println("Dati delle vittorie caricati correttamente.");
        } catch (FileNotFoundException e) {
            System.out.println("File delle vittorie non trovato, verrà creato al salvataggio.");
        } catch (IOException e) {
            System.out.println("Errore durante il caricamento delle vittorie: " + e.getMessage());
        }
    }

    // Metodo per ottenere il numero di vittorie di un giocatore
    public int getVittorie(String nome) {
        return vittorie.getOrDefault(nome, 0);
        //getOrDefault viene utilizzato per ottenere il numero di vittorie di un giocatore, restituendo 0 se il giocatore non è presente nella mappa
    }
}
