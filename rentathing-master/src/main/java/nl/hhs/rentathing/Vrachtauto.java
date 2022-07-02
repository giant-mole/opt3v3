package nl.hhs.rentathing;

public class Vrachtauto extends Product{
    public Double laadvermogen;
    public Double gewicht;


    public Vrachtauto() {
    }


    public double berekenprijs(double prijsPerDag, double verzekeringskosten, int aantalDagen) {
        double totaalPrijs ;
        if (!verzekering) {
            totaalPrijs = prijsPerDag * aantalDagen;

        } else {
            totaalPrijs = (prijsPerDag * aantalDagen) + (verzekeringskosten * aantalDagen);


        }
        return totaalPrijs;
    }

    public Vrachtauto(double prijsPerDag, String voornaam, String achternaam, double verzekeringskosten, boolean verhuurd, int aantalDagen, boolean verzekering, Double laadvermogen, Double gewicht) {
        super(prijsPerDag, voornaam, achternaam, verzekeringskosten, verhuurd, aantalDagen, verzekering);
        this.laadvermogen = laadvermogen;
        this.gewicht = gewicht;
    }


    @Override
    public String toString() {
        return "Vrachtauto{" +
                "laadvermogen=" + laadvermogen +
                ", gewicht=" + gewicht +
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

    public  Double getLaadvermogen() {
        return laadvermogen;
    }

    public void setLaadvermogen(Double laadvermogen) {
        this.laadvermogen = laadvermogen;
    }

    public Double getGewicht() {
        return gewicht;
    }

    public void setGewicht(Double gewicht) {
        this.gewicht = gewicht;
    }

}
