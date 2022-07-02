package nl.hhs.rentathing;

public abstract class Product implements IDatabase{


    public double prijsPerDag;
    public String voornaam;
    public String achternaam;
    public double verzekeringskosten;
    public String id;
    public boolean verhuurd;
    public boolean verzekering;
    public int aantalDagen;


    public Product() {
    }

    public Product(double prijsPerDag, String voornaam, String achternaam) {
        this.prijsPerDag = prijsPerDag;
        this.voornaam = voornaam;
        this.achternaam = achternaam;

    }
    public Product(double prijsPerDag, String voornaam, String achternaam,double verzekeringskosten, boolean verhuurd){
        this(prijsPerDag,voornaam,achternaam);
        this.verzekeringskosten = verzekeringskosten;
        this.verhuurd = verhuurd;

    }
    public Product(double prijsPerDag, String voornaam, String achternaam,double verzekeringskosten, boolean verhuurd,int aantalDagen,boolean verzekering){
        this(prijsPerDag,voornaam,achternaam,verzekeringskosten,verhuurd);
        this.aantalDagen = aantalDagen;
        this.verzekering=verzekering;
    }


    public void berekenprijs(Double prijsPerDag, double verzekeringskosten, int aantalDagen){

    }

    @Override
    public String toString() {
        return "Product{" +
                "PrijsPerDag=" + prijsPerDag +
                ", verzekeringskosten=" + verzekeringskosten +
                ", id='" + id + '\'' +
                ", verhuurd=" + verhuurd +
                ", aantalDagen=" + aantalDagen +
                '}';
    }

    @Override
    public String getId() {
        return id;}
    @Override
    public void setId(String id) {
        this.id = id;
    }
}
