public class Medlem {
    public String navn;
    public String email;
    public String telefon;
    public String adresse;
    public int medlemsNummer;
    public int alder;
    public boolean aktivMedlem;
    public boolean erIRestance;
    public boolean harBetaltKontingent;

    // Konstruktør
    public Medlem(String navn, String email, String telefon, String adresse,
                  int medlemsNummer, int alder, boolean aktivMedlem) {
        this.navn = navn;
        this.email = email;
        this.telefon = telefon;
        this.adresse = adresse;
        this.medlemsNummer = medlemsNummer;
        this.alder = alder;
        this.aktivMedlem = aktivMedlem;
        this.erIRestance = false;
        this.harBetaltKontingent = false;
    }

    // Metode til at sætte restance status
    public void setErIRestance(boolean erIRestance) {
        this.erIRestance = erIRestance;
    }

    // Registrerer betaling
    public void registrerBetaling() {
        this.harBetaltKontingent = true;
        this.erIRestance = false;
    }

    // Beregner kontingent
    public double beregnKontingent() {
        if (!aktivMedlem) {
            return 500; // Passivt medlemskab
        }

        if (alder < 18) {
            return 1000; // Ungdomsmedlem
        } else if (alder >= 18 && alder < 60) {
            return 1600; // Voksenmedlem
        } else {
            return 1200; // Seniormedlem
        }
    }

    // toString metode til udskrivning
    @Override
    public String toString() {
        return "Medlem{" +
                "navn='" + navn + '\'' +
                ", medlemsNummer=" + medlemsNummer +
                ", alder=" + alder +
                ", aktivMedlem=" + aktivMedlem +
                ", erIRestance=" + erIRestance +
                ", harBetaltKontingent=" + harBetaltKontingent +
                '}';
    }
}