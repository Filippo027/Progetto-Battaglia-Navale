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
        caricaUtenti(); // Carica utenti e password all'inizio
        caricaVittorie(); // Carica le vittorie
    }

    // Metodo per registrare un giocatore (interattivamente)
    public void registraGiocatoreInterattivo() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Inserisci il nome del giocatore: ");
            String nome = scanner.nextLine();
            
            // Controlla se il giocatore esiste già
            if (utenti.containsKey(nome)) {
                System.out.println("Giocatore già registrato!");
                return;
            }
            
            System.out.print("Inserisci la password: ");
            String password = scanner.nextLine();
            
            // Salva nome utente e password
            utenti.put(nome, password);
            vittorie.put(nome, 0); // Inizializza le vittorie a 0
            
            salvaUtenti(); // Aggiorna il file con i nuovi dati
            System.out.println("Giocatore " + nome + " registrato con successo!");
        }
    }

    // Metodo per verificare l'accesso di un utente
    public boolean accediGiocatore(String nome, String password) {
        if (utenti.containsKey(nome) && utenti.get(nome).equals(password)) {
            System.out.println("Accesso riuscito per il giocatore: " + nome);
            return true;
        } else {
            System.out.println("Accesso negato. Nome utente o password errati.");
            return false;
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
            for (Map.Entry<String, Integer> entry : vittorie.entrySet()) {
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
    }
}
