package restoran;

public class Resep {
    private int id;
    private String nama;
    private String bahan;

    public Resep(int id, String nama, String bahan) {
        this.id = id;
        this.nama = nama;
        this.bahan = bahan;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getBahan() {
        return bahan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    @Override
    public String toString() {
        return id + " - " + nama;
    }
}
