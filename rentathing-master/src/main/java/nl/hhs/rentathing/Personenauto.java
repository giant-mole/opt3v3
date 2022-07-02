package nl.hhs.rentathing;

public class Personenauto extends Product {
    public String merk;
    public Double Gewicht;

    public Personenauto(double prijsPerDag, String voornaam, String achternaam, double verzekeringskosten, boolean verhuurd, int aantalDagen, boolean verzekering, String merk, Double gewicht) {
        super(prijsPerDag, voornaam, achternaam, verzekeringskosten, verhuurd, aantalDagen, verzekering);
        this.merk = merk;
        Gewicht = gewicht;
    }


    public Personenauto() {
    }

    public double berekenprijs(double prijsPerDag, double verzekeringskosten, int aantalDagen) {
        double totaalPrijs = 0;
        if (!verzekering) {
            totaalPrijs = prijsPerDag * aantalDagen;

        } else {
            totaalPrijs = (prijsPerDag * aantalDagen) + (verzekeringskosten * aantalDagen);


        }
        return  totaalPrijs;
    }

    @Override
    public String toString() {
        return "Personenauto{" +
                "merk='" + merk + '\'' +
                ", Gewicht=" + Gewicht +
                ", prijsPerDag=" + prijsPerDag +
                ", voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", verzekeringskosten=" + verzekeringskosten +
                ", id='" + id + '\'' +
                ", verhuurd=" + verhuurd +
                ", verzekering=" + verzekering +
                ", aantalDagen=" + aantalDagen +
                '}';
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public Double getGewicht() {
        return Gewicht;
    }

    public void setGewicht(Double gewicht) {
        Gewicht = gewicht;
    }
}
