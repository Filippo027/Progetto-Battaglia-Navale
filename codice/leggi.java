import java.io.*;

class Leggi {
    private static BufferedReader br = 
        new BufferedReader(new InputStreamReader(System.in));
    private static String s;

   
    public static boolean unBoolean() {
        input();
        if (s == null || (!s.equalsIgnoreCase("true") && !s.equalsIgnoreCase("false"))) {
            System.err.println("Errore: " + s + " non è un boolean");
            return false;
        }
        return s.equalsIgnoreCase("true");
    }

   
    public static byte unByte() {
        try {
            return Byte.parseByte(input());
        } catch (NumberFormatException e) {
            System.err.println("Errore: " + s + " non è un byte");
            return 0;
        }
    }

   
    public static short unoShort() {
        try {
            return Short.parseShort(input());
        } catch (NumberFormatException e) {
            System.err.println("Errore: " + s + " non è uno short");
            return 0;
        }
    }

   
    public static int unInt() {
        try {
            return Integer.parseInt(input());
        } catch (NumberFormatException e) {
            System.err.println("Errore: " + s + " non è un intero");
            return 0;
        }
    }


    public static long unLong() {
        try {
            return Long.parseLong(input());
        } catch (NumberFormatException e) {
            System.err.println("Errore: " + s + " non è un long");
            return 0;
        }
    }


    public static float unFloat() {
        try {
            return Float.parseFloat(input());
        } catch (NumberFormatException e) {
            System.err.println("Errore: " + s + " non è un float");
            return 0;
        }
    }


    public static double unDouble() {
        try {
            return Double.parseDouble(input());
        } catch (NumberFormatException e) {
            System.err.println("Errore: " + s + " non è un double");
            return 0;
        }
    }

    public static char unChar() {
        try {
            return input().charAt(0);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Errore: input vuoto, impossibile leggere un carattere.");
            return ' ';
        }
    }

    public static String unoString() {
        String inputStr = input();
        if (inputStr == null || inputStr.isEmpty()) {
            System.err.println("Errore: non è stata inserita una stringa.");
            return null;
        }
        return inputStr;
    }

    private static String input() {
        try {
            s = br.readLine().trim();
            if (s == null || s.isEmpty()) {
                System.err.println("Errore: inserire almeno un carattere.");
                return "";
            }
        } catch (IOException e) {
            System.err.println("Errore durante la lettura dell'input!");
            return null;
        }
        return s;
    }
}
