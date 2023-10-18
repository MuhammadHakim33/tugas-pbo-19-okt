package matriks;

public class Matriks {
    private int matriks1[][] = new int[2][2];
    private int matriks2[][] = new int[2][2];

    public Matriks(int[][] matriks1, int[][] matriks2) {
        this.matriks1 = matriks1;
        this.matriks2 = matriks2;
    }

    public double[][] tambah() {
        double hasil[][] = new double[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                hasil[i][j] = matriks1[i][j] + matriks2[i][j];
            }
        }
        
        return hasil;
    }

    public double[][] kurang() {
        double hasil[][] = new double[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                hasil[i][j] = matriks1[i][j] - matriks2[i][j];
            }
        }
        
        return hasil;
    }

    public double[][] kali() {
        double hasil[][] = new double[2][2];
        int jumlah = 0;
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    jumlah = jumlah + matriks1[i][k] * matriks2[k][j];
                }
                hasil[i][j] = jumlah;
                jumlah = 0;
            }
        }
        
        return hasil;
    }

    public double[][] transpose(double[][] matriks) {
        double hasil[][] = new double[2][2];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                hasil[j][i] = matriks[i][j];
            }
        }
        
        return hasil;
    }

    public double[][] invers(double[][] matriks) {
        double hasil[][] = new double[2][2];
        
        double determinan = matriks[0][0] * matriks[1][1] - matriks[0][1] * matriks[1][0];

        hasil[0][0] = matriks[1][1] / determinan;
        hasil[0][1] = -matriks[0][1] / determinan;
        hasil[1][0] = -matriks[1][0] / determinan;
        hasil[1][1] = matriks[0][0] / determinan;

        return hasil;
    }

    public void display(String tipe, double[][] hasil) {
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
