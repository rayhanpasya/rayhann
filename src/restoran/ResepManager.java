package restoran;

import java.util.ArrayList;

public class ResepManager {
    private ArrayList<Resep> resepList = new ArrayList<>();
    private int nextId = 1;

    public void tambahResep(String nama, String bahan) {
        Resep resep = new Resep(nextId++, nama, bahan);
        resepList.add(resep);
    }

    public void editResep(int id, String nama, String bahan) {
        for (Resep resep : resepList) {
            if (resep.getId() == id) {
                resep.setNama(nama);
                resep.setBahan(bahan);
                return;
            }
        }
    }

    public void hapusResep(int id) {
        resepList.removeIf(resep -> resep.getId() == id);
    }

    public ArrayList<Resep> getResepList() {
        return resepList;
    }
}
