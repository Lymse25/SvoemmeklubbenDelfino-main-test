import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Medlem> medlemmer = opretTestMedlemmer(); // Testmedlemmer

        boolean kører = true;
        while (kører) {
            System.out.println("\nVælg en funktion:");
            System.out.println("1. Økonomi");
            System.out.println("   5a. Kontingentbetaling");
            System.out.println("   5b. Registrer betaling");
            System.out.println("   5c. Vis restancer");
            System.out.println("   5d. Kontingentsatser");
            System.out.println("   5e. Økonomioversigt");
            System.out.println("6a. Afslut program");

            System.out.print("Dit valg: ");
            String valg = scanner.nextLine();

            switch (valg.toLowerCase()) {
                case "5a":
                    visKontingentbetaling(medlemmer);
                    break;
                case "5b":
                    registrerBetaling(medlemmer, scanner);
                    break;
                case "5c":
                    visRestancer(medlemmer);
                    break;
                case "5d":
                    visKontingentsatser();
                    break;
                case "5e":
                    visØkonomioversigt(medlemmer);
                    break;
                case "6a":
                    System.out.println("Afslutter programmet. Farvel!");
                    kører = false;
                    break;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }

        scanner.close();
    }

    // Opret testmedlemmer
    private static ArrayList<Medlem> opretTestMedlemmer() {
        ArrayList<Medlem> medlemmer = new ArrayList<>();
        medlemmer.add(new Medlem("Lars", "lars@example.com", "12345678", "Vej 1", 1, 25, true));
        medlemmer.add(new Medlem("Mette", "mette@example.com", "87654321", "Vej 2", 2, 65, true));
        medlemmer.add(new Medlem("Hans", "hans@example.com", "11223344", "Vej 3", 3, 15, false));
        return medlemmer;
    }

    // 5a: Vis kontingentbetaling
    private static void visKontingentbetaling(ArrayList<Medlem> medlemmer) {
        System.out.println("Kontingentbetaling:");
        for (Medlem medlem : medlemmer) {
            System.out.println(medlem.navn + " skal betale: " + medlem.beregnKontingent() + " kr.");
        }
    }

    // 5b: Registrer betaling
    private static void registrerBetaling(ArrayList<Medlem> medlemmer, Scanner scanner) {
        System.out.println("Indtast medlemsnummer for betaling:");
        int medlemsNummer = Integer.parseInt(scanner.nextLine());
        for (Medlem medlem : medlemmer) {
            if (medlem.medlemsNummer == medlemsNummer) {
                medlem.registrerBetaling();
                System.out.println("Betaling registreret for " + medlem.navn);
                return;
            }
        }
        System.out.println("Medlem ikke fundet.");
    }

    // 5c: Vis restancer
    private static void visRestancer(ArrayList<Medlem> medlemmer) {
        System.out.println("Medlemmer i restance:");
        for (Medlem medlem : medlemmer) {
            if (medlem.erIRestance) {
                System.out.println("Navn: " + medlem.navn + ", Medlemsnummer: " + medlem.medlemsNummer);
            }
        }
    }

    // 5d: Vis kontingentsatser
    private static void visKontingentsatser() {
        System.out.println("Kontingentsatser:");
        System.out.println("Ungdomsmedlemmer (under 18 år): 1000 kr.");
        System.out.println("Voksenmedlemmer (18-59 år): 1600 kr.");
        System.out.println("Seniormedlemmer (60 år og ældre): 1200 kr.");
        System.out.println("Passivt medlemskab: 500 kr.");
    }

    // 5e: Vis økonomioversigt
    private static void visØkonomioversigt(ArrayList<Medlem> medlemmer) {
        double samletKontingent = 0.0;
        for (Medlem medlem : medlemmer) {
            samletKontingent += medlem.beregnKontingent();
        }
        System.out.println("Samlet kontingentindtægt: " + samletKontingent + " kr.");
    }
}