public abstract class Person {
    protected String navn;
    protected String email;
    protected String telefon;
    protected String adresse;

    public Person(String navn, String email, String telefon, String adresse) {
        this.navn = navn;
        this.email = email;
        this.telefon = telefon;
        this.adresse = adresse;
    }

    // Getters and setters omitted for brevity

    @Override
    public String toString() {
        return String.format("Navn: %s, Email: %s, Telefon: %s, Adresse: %s",
                navn, email, telefon, adresse);
    }
}