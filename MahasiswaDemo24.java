import java.util.Scanner;

public class MahasiswaDemo24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumMhs = sc.nextInt();
        sc.nextLine();
        
        MahasiswaBerprestasi24 list = new MahasiswaBerprestasi24(jumMhs);
        
        for (int i = 0; i < jumMhs; i++) {
            System.out.println("\nMasukkan data mahasiswa ke-" + (i + 1) + ":");

            System.out.print("NIM   : ");
            String nim = sc.nextLine();

            System.out.print("Nama  : ");
            String nama = sc.nextLine();

            System.out.print("Kelas : ");
            String kelas = sc.nextLine();

            System.out.print("IPK   : ");
            double ipk = sc.nextDouble();
            sc.nextLine();

            Mahasiswa24 m = new Mahasiswa24(nim, nama, kelas, ipk);
            list.tambah(i, m);
        }

        System.out.println("\n----------------------------------------------");
        System.out.println("Data Mahasiswa");
        System.out.println("----------------------------------------------");
        list.tampil();
        
        System.out.println("----------------------------------------------");
        System.out.println("Pencarian data dengan Sequential Search");
        System.out.println("----------------------------------------------");
        System.out.print("Masukkan IPK mahasiswa yang dicari: ");
        double cari = sc.nextDouble();

        System.out.println("Menggunakan sequential searching...");
        int posisi = list.sequentialSearching(cari);
        list.tampilPosisi(cari, posisi);
        list.tampilDataSearch(cari, posisi);

        System.out.println("----------------------------------------------");
        System.out.println("Pencarian data dengan Binary Search");
        System.out.println("----------------------------------------------");
        System.out.print("Masukkan IPK mahasiswa yang dicari: ");
        cari = sc.nextDouble();

        System.out.println("Menggunakan binary search...");
        int posisi2 = list.findBinarySearch(cari, 0, jumMhs - 1);
        list.tampilPosisi(cari, posisi2);
        list.tampilDataSearch(cari, posisi2);

        sc.close();
    }
}