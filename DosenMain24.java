import java.util.Scanner;

public class DosenMain24 {
    public static void main(String[] args) {
        Scanner scanner18 = new Scanner(System.in);
        DataDosen24 dataDosen = new DataDosen24();
        int menu = 0;

        while (menu != 7) {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Tambah Data Dosen");
            System.out.println("2. Tampilkan Data Dosen");
            System.out.println("3. Urutkan Dosen Usia Termuda");
            System.out.println("4. Urutkan Dosen Usia Tertua");
            System.out.println("5. Cari Nama Dosen");
            System.out.println("6. Cari Usia Dosen");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            menu = scanner18.nextInt();
            scanner18.nextLine();

            if (menu == 1) {
                System.out.print("Masukkan kode dosen: ");
                String kode = scanner18.nextLine();
                System.out.print("Masukkan nama dosen: ");
                String nama = scanner18.nextLine();
                System.out.print("Masukkan jenis kelamin (L/P): ");
                char jk = scanner18.next().charAt(0);
                boolean jenisKelamin = (jk == 'L' || jk == 'l');
                System.out.print("Masukkan usia: ");
                int usia = scanner18.nextInt();
                
                Dosen24 dsn = new Dosen24(kode, nama, jenisKelamin, usia);
                dataDosen.tambah(dsn);
            } 
            else if (menu == 2) {
                dataDosen.tampil();
            } 
            else if (menu == 3) {
                dataDosen.sortingASC();
            } 
            else if (menu == 4) {
                dataDosen.sortingDSC();
            }
            else if (menu == 5) {
                System.out.print("Masukkan nama dosen yang ingin dicari: ");
                String namaCari = scanner18.nextLine();
                dataDosen.PencarianDataSequential18(namaCari);
            }
            else if (menu == 6) {
                System.out.print("Masukkan usia dosen yang ingin dicari: ");
                int usiaCari = scanner18.nextInt();
                dataDosen.PencarianDataBinary18(usiaCari);
            }
            else if (menu == 7) {
                System.out.println("Terima kasih!");
            }
            else {
                System.out.println("Menu tidak valid. Silakan coba lagi.");
            }
        }

        scanner18.close();
    }
}