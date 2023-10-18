import matriks.Matriks;
import matriks.MatriksPecahan;
import pecahan.Pecahan;

public class Main {
    public static void main(String[] args) throws Exception {
        String input1 = "1/2";
        String input2 = "3/4";

        Pecahan pecahan1 = Pecahan.convertToInt(input1);
        Pecahan pecahan2 = Pecahan.convertToInt(input2);

        Pecahan penjumlahan = pecahan1.tambah(pecahan2);
        System.out.println("Penjumlahan : " + penjumlahan.convertToString());

        Pecahan pengurangan = pecahan1.kurang(pecahan2);
        System.out.println("Pengurangan : " + pengurangan.convertToString());

        Pecahan perkalian = pecahan1.kali(pecahan2);
        System.out.println("Perkalian : " + perkalian.convertToString());

        Pecahan pembagian = pecahan1.bagi(pecahan2);
        System.out.println("Pembagian : " + pembagian.convertToString());

        int[][] a = {
            {2,3},
            {4,5}};

        int[][] b = {
            {1,5},
            {2,3}};

        Matriks matriks = new Matriks(a, b);

        double[][] tambah = matriks.tambah();
        matriks.display("Tambah", tambah);

        double[][] kurang = matriks.kurang();
        matriks.display("Kurang", kurang);

        double[][] kali = matriks.kali();
        matriks.display("Kali", kali);
        
        double[][] transpose = matriks.transpose(kali);
        matriks.display("Transpose Hasil Kali", transpose);
        
        double[][] invers = matriks.invers(kali);
        matriks.display("Invers Hasil Kali", invers);

        String[][] c = {
            {"1/2", "2/3"},
            {"3/4", "4/5"}};
            
        String[][] d = {
            {"5/6", "6/7"},
            {"7/8", "8/9"}};

        MatriksPecahan matriksPecahan = new MatriksPecahan(c, d);

        String[][] tambahPecahan = matriksPecahan.tambah();
        matriksPecahan.display("Tambah", tambahPecahan);
        
        String[][] kurangPecahan = matriksPecahan.kurang();
        matriksPecahan.display("Kurang", kurangPecahan);

        String[][] kaliPecahan = matriksPecahan.kali();
        matriksPecahan.display("Kali", kaliPecahan);

        String[][] transposePecahan = matriksPecahan.transpose(kaliPecahan);
        matriksPecahan.display("Transpose Hasil Kali", transposePecahan);

        String[][] inversPecahan = matriksPecahan.invers(kaliPecahan);
        matriksPecahan.display("Invers Hasil Kali", inversPecahan);
    }
}
