package matriks;
import pecahan.Pecahan;

public class MatriksPecahan extends Pecahan {
    private String matriks1[][] = new String[2][2];
    private String matriks2[][] = new String[2][2];

    public MatriksPecahan(String[][] matriks1, String[][] matriks2) {
        super(0, 0);
        this.matriks1 = matriks1;
        this.matriks2 = matriks2;
    }

    public String[][] tambah() {
        String hasil[][] = new String[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Pecahan pecahan1 = Pecahan.convertToInt(matriks1[i][j]);
                Pecahan pecahan2 = Pecahan.convertToInt(matriks2[i][j]);
                Pecahan penjumlahan = pecahan1.tambah(pecahan2);
                hasil[i][j] = penjumlahan.convertToString();
            }
        }
        
        return hasil;
    }

    public String[][] kurang() {
        String hasil[][] = new String[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Pecahan pecahan1 = Pecahan.convertToInt(matriks1[i][j]);
                Pecahan pecahan2 = Pecahan.convertToInt(matriks2[i][j]);
                Pecahan pengurangan = pecahan1.kurang(pecahan2);
                hasil[i][j] = pengurangan.convertToString();
            }
        }
        
        return hasil;
    }

    public String[][] kali() {
        String hasil[][] = new String[2][2];
        Pecahan jumlah = null;
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    Pecahan pecahan1 = Pecahan.convertToInt(matriks1[i][k]);
                    Pecahan pecahan2 = Pecahan.convertToInt(matriks2[k][j]);
                    Pecahan perkalian = pecahan1.kali(pecahan2);
                    if(jumlah == null) {
                        jumlah = perkalian;
                    } else {
                        jumlah = perkalian.tambah(jumlah);
                    }
                }
                hasil[i][j] = jumlah.convertToString();
                jumlah = null;
            }
        }
        
        return hasil;
    }

    public String[][] transpose(String[][] matriks) {
        String hasil[][] = new String[2][2];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                hasil[j][i] = matriks[i][j];
            }
        }
        
        return hasil;
    }

    public String[][] invers(String[][] matriks) {
        String hasil[][] = new String[2][2];
        
        Pecahan pecahan1 = Pecahan.convertToInt(matriks[0][0]);
        Pecahan pecahan2 = Pecahan.convertToInt(matriks[0][1]);
        Pecahan pecahan3 = Pecahan.convertToInt(matriks[1][0]);
        Pecahan pecahan4 = Pecahan.convertToInt(matriks[1][1]);

        Pecahan determinant = pecahan1.kali(pecahan4).kurang(pecahan2.kali(pecahan3));

        hasil[0][0] = pecahan4.bagi(determinant).convertToString();
        hasil[0][1] = pecahan2.bagi(determinant).convertToString();
        hasil[1][0] = pecahan3.bagi(determinant).convertToString();
        hasil[1][1] = pecahan1.bagi(determinant).convertToString();

        return hasil;
    }

    public void display(String tipe, String[][] hasil) {
        System.out.println();
        System.out.println(tipe);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
               System.out.print(hasil[i][j] + " ");
            }
            System.out.println();
        }
    }
}
