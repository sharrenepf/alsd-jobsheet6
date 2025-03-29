public class DataDosen24 {
    Dosen24[] dataDosen = new Dosen24[10];
    int idx = 0;

    public void tambah(Dosen24 dsn) {
        if (idx < dataDosen.length) {
            dataDosen[idx] = dsn;
            idx++;
        } else {
            System.out.println("Data dosen sudah penuh!");
        }
    }

    public void tampil() {
        if (idx == 0) {
            System.out.println("Belum ada Data Dosen.");
        } else {
            System.out.printf("\n%-10s %-15s %-15s %-5s\n", "Kode", "Nama", "Jenis Kelamin", "Usia");
            System.out.println("-----------------------------------------------------");
            for (int i = 0; i < idx; i++) {
                String jenisKelamin = dataDosen[i].jenisKelamin ? "Laki-laki" : "Perempuan";
                System.out.printf("%-10s %-15s %-15s %-5d\n",
                    dataDosen[i].kode, 
                    dataDosen[i].nama, 
                    jenisKelamin, 
                    dataDosen[i].usia
                );
            }
        }
    }

    public void sortingASC() { // Bubble Sort (Usia termuda ke tertua)
        if (idx == 0) { 
            System.out.println("Belum ada Data Dosen.");
            return;
        }

        for (int i = 0; i < idx - 1; i++) {
            for (int j = 0; j < idx - i - 1; j++) {
                if (dataDosen[j].usia > dataDosen[j + 1].usia) {
                    Dosen24 temp = dataDosen[j];
                    dataDosen[j] = dataDosen[j + 1];
                    dataDosen[j + 1] = temp;
                }
            }
        }
    }

    public void sortingDSC() { // Selection Sort (Usia tertua ke termuda)
        if (idx == 0) { 
            System.out.println("Belum ada Data Dosen.");
            return;
        }

        for (int i = 0; i < idx - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < idx; j++) {
                if (dataDosen[j].usia > dataDosen[maxIdx].usia) {
                    maxIdx = j;
                }
            }
            Dosen24 temp = dataDosen[maxIdx];
            dataDosen[maxIdx] = dataDosen[i];
            dataDosen[i] = temp;
        }
    }

    public void PencarianDataSequential18(String namaCari) {
        boolean found = false;
        int count = 0;

        System.out.println("\nHasil Pencarian Nama: " + namaCari);
        System.out.printf("\n%-10s %-15s %-15s %-5s\n", "Kode", "Nama", "Jenis Kelamin", "Usia");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < idx; i++) {
            if (dataDosen[i].nama.equalsIgnoreCase(namaCari)) {
                String jenisKelamin = dataDosen[i].jenisKelamin ? "Laki-laki" : "Perempuan";
                System.out.printf("%-10s %-15s %-15s %-5d\n",
                    dataDosen[i].kode, 
                    dataDosen[i].nama, 
                    jenisKelamin, 
                    dataDosen[i].usia
                );
                found = true;
                count++;
            }
        }

        if (!found) {
            System.out.println("Dosen dengan nama " + namaCari + " tidak ditemukan.");
        } else if (count > 1) {
            System.out.println("Peringatan: Ditemukan lebih dari satu hasil untuk nama \"" + namaCari + "\"!");
        }
    }

    public void PencarianDataBinary18(int usiaCari) {
        sortingASC();

        int left = 0, right = idx - 1, mid;
        boolean found = false;
        int count = 0;

        System.out.println("\nHasil Pencarian Usia: " + usiaCari);
        System.out.printf("\n%-10s %-15s %-15s %-5s\n", "Kode", "Nama", "Jenis Kelamin", "Usia");
        System.out.println("-----------------------------------------------------");

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (dataDosen[mid].usia == usiaCari) {
                found = true;

                int i = mid;
                while (i >= left && dataDosen[i].usia == usiaCari) {
                    String jenisKelamin = dataDosen[i].jenisKelamin ? "Laki-laki" : "Perempuan";
                    System.out.printf("%-10s %-15s %-15s %-5d\n",
                        dataDosen[i].kode, 
                        dataDosen[i].nama, 
                        jenisKelamin, 
                        dataDosen[i].usia
                    );
                    count++;
                    i--;
                }

                i = mid + 1;
                while (i <= right && dataDosen[i].usia == usiaCari) {
                    String jenisKelamin = dataDosen[i].jenisKelamin ? "Laki-laki" : "Perempuan";
                    System.out.printf("%-10s %-15s %-15s %-5d\n",
                        dataDosen[i].kode, 
                        dataDosen[i].nama, 
                        jenisKelamin, 
                        dataDosen[i].usia
                    );
                    count++;
                    i++;
                }

                break;
            } else if (dataDosen[mid].usia < usiaCari) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Dosen dengan usia " + usiaCari + " tidak ditemukan.");
        } else if (count > 1) {
            System.out.println("Peringatan: Ditemukan lebih dari satu hasil untuk usia " + usiaCari + "!");
        }
    }
}