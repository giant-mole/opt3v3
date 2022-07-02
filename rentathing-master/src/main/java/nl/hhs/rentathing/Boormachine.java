package nl.hhs.rentathing;

public class Boormachine extends Product{
    public String merk;
    public String type;

    public Boormachine() {
    }

    public Boormachine(double prijsPerDag, String voornaam, String achternaam, double verzekeringskosten, boolean verhuurd, int aantalDagen, boolean verzekering, String merk, String type) {
        super(prijsPerDag, voornaam, achternaam, verzekeringskosten, verhuurd, aantalDagen, verzekering);
        this.merk = merk;
        this.type = type;
    }


    public double berekenprijs(double prijsPerDag, double verzekeringskosten, int aantalDagen) {
        double totaalPrijs=0;
        if (verzekering){
            totaalPrijs=prijsPerDag*aantalDagen;

        }else{
            totaalPrijs=(prijsPerDag*aantalDagen)+(verzekeringskosten*aantalDagen);


        }


        return totaalPrijs;


    }

    @Override
    public String toString() {
        return "Boormachine{" +
                "merk='" + merk + '\'' +
                ", type='" + type + '\'' +
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
