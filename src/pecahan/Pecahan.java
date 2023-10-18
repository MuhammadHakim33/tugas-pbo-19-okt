package pecahan;

public class Pecahan {
    private int pembilang;
    private int penyebut;

    public Pecahan (int pembilang, int penyebut) {
        try {
            if (penyebut == 0) {
                throw new Exception("Penyebut Tidak Boleh 0");
            }

            this.pembilang = pembilang;
            this.penyebut = penyebut;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Pecahan convertToInt(String data) {
        String[] pecahan = data.split("/");
        int pembilang = Integer.parseInt(pecahan[0]);
        int penyebut = Integer.parseInt(pecahan[1]);
        return new Pecahan(pembilang, penyebut);
    }

    public Pecahan tambah(Pecahan next) {
        int penyebut;
        int pembilang;

        if(this.penyebut != next.penyebut) {
            penyebut = this.pembilang * next.pembilang;
            pembilang = (this.pembilang * next.penyebut) + (next.pembilang * this.penyebut);
            return new Pecahan(pembilang, penyebut);
        }
        
        pembilang = this.pembilang + next.pembilang;
        penyebut = this.penyebut;
        return new Pecahan(pembilang, penyebut);
    }

    public Pecahan kurang(Pecahan next) {
        int penyebut;
        int pembilang;

        if(this.penyebut != next.penyebut) {
            penyebut = this.pembilang * next.pembilang;
            pembilang = (this.pembilang * next.penyebut) - (next.pembilang * this.penyebut);
            return new Pecahan(pembilang, penyebut);
        }
        
        pembilang = this.pembilang - next.pembilang;
        penyebut = this.penyebut;
        return new Pecahan(pembilang, penyebut);
    }

    public Pecahan kali(Pecahan next) {
        int pembilang = this.pembilang * next.pembilang;
        int penyebut = this.penyebut * next.penyebut;
        return new Pecahan(pembilang, penyebut);
    }

    public Pecahan bagi(Pecahan next) {
        int pembilang = this.pembilang * next.penyebut;
        int penyebut = this.penyebut * next.pembilang;
        return new Pecahan(pembilang, penyebut);
    }

    public String convertToString() {
        return pembilang + "/" + penyebut;
    }
}
