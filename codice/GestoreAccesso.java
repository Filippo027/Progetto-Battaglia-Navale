import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class GestoreAccesso {
    private String fileGiocatori;

    // Costruttore
    public GestoreAccesso(String fileGiocatori) {
        this.fileGiocatori = "giocatori.txt";
    }

    // Metodo per registrare un nuovo giocatore
    public void registraGiocatore(String nome) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileGiocatori, true))) {
            writer.write(nome);
            writer.newLine();
            System.out.println("Giocatore " + nome + " registrato con successo.");
        } catch (IOException e) {
            System.out.println("Errore durante la registrazione del giocatore: " + e.getMessage());
        }
    }

    // Metodo per accedere a un giocatore registrato
    public boolean accediGiocatore(String nome) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileGiocatori))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.equalsIgnoreCase(nome)) {
                    System.out.println("Accesso consentito per il giocatore " + nome);
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Errore durante l'accesso al file: " + e.getMessage());
        }
        System.out.println("Giocatore " + nome + " non trovato.");
        return false;
    }

    // Metodo per salvare una vittoria del giocatore
    public void salvaVittoria(String nome) {
        String fileVittorie = "vittorie_" + fileGiocatori;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileVittorie, true))) {
            writer.write(nome);
            writer.newLine();
            System.out.println("Vittoria salvata per il giocatore " + nome);
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio della vittoria: " + e.getMessage());
        }
    }
}
