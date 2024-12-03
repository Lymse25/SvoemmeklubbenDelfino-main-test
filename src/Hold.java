import java.util.ArrayList;

public class Hold {
    public String holdNavn;
    public String niveau;
    public int maxAntalDeltagere;
    public ArrayList<String> traeningsTider;
    public ArrayList<Medlem> holdliste;

    // Constructor
    public Hold(String holdNavn, String niveau, int maxAntalDeltagere, ArrayList<String> traeningsTider) {
        this.holdNavn = holdNavn;
        this.niveau = niveau;
        this.maxAntalDeltagere = maxAntalDeltagere;
        this.traeningsTider = traeningsTider;
        this.holdliste = new ArrayList<>();
    }

    public void addDeltager(Medlem medlem) {
        if (holdliste.size() < maxAntalDeltagere) {
            holdliste.add(medlem);
            System.out.println(medlem.navn + " er tilmeldt til " + holdNavn);
        } else {
            System.out.println("Der er ikke plads på " + holdNavn);
        }
    }

    public void removeDeltager(Medlem medlem) {
        if (holdliste.contains(medlem)) {
            holdliste.remove(medlem);
            System.out.println(medlem.navn + " er blevet fjernet fra " + holdNavn);
        } else {
            System.out.println("Medlem ikke fundet på holdet.");
        }
    }

    public ArrayList<Medlem> getHoldliste() {
        return holdliste;
    }

    public String getHoldNavn() {
        return holdNavn;
    }

    @Override
    public String toString() {
        return holdNavn + " (" + niveau + "): " + holdliste.size() + "/" + maxAntalDeltagere + " deltagere.";
    }

    public static void main(String[] args) {
        ArrayList<String> traeningsTider = new ArrayList<>();
        traeningsTider.add("Tirsdag kl.16:00 - 18:00");
        traeningsTider.add("Torsdag kl.17:00 - 19:00");

        Hold junior = new Hold("Juniorholdet", "Højt", 10, traeningsTider);
        Hold senior = new Hold("Seniorholdet", "Elite", 7, traeningsTider);

        Medlem medlem1 = new Medlem("Camilla", "CamillaKanin@gmail.com", "35422144", "Borups Allé 22, 5. th.", 123, 22, true);
        Medlem medlem2 = new Medlem("Tinke", "UlvepigenTinke@gmail.com", "23456789", "Fernandosgade 5B", 233, 15, true);
        Medlem medlem3 = new Medlem("Majbrit", "Majbritprivatmail@gmail.com", "24949389", "Sjællandsgade 233K", 303, 12, false);

        junior.addDeltager(medlem1);
        junior.addDeltager(medlem2);
        junior.addDeltager(medlem3);

        System.out.println("Junior holdliste: " + junior.getHoldliste());

        senior.addDeltager(medlem1);

        System.out.println("Senior holdliste: " + senior.getHoldliste());
        System.out.println("Junior holdliste efter fjernelse: ");
        junior.removeDeltager(medlem2);
        System.out.println(junior.getHoldliste());
    }
}