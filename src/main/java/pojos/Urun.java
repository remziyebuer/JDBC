package pojos;

public class Urun {
    private int id;
    private String isim;
    private double fiyat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public Urun(int id, String isim, double fiyat) {
        this.id = id;
        this.isim = isim;
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "Urun{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                ", fiyat=" + fiyat +
                '}';




    }
}
