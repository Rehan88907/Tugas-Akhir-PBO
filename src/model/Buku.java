package model;

public class Buku {
      private int id;
    private String judul;
    private String pengarang;
    private int tahun;
    private int stok;

    public Buku(int id, String judul, String pengarang, int tahun, int stok) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahun = tahun;
        this.stok = stok;
    }

    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public int getTahun() {
        return tahun;
    }

    public int getStok() {
        return stok;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}


