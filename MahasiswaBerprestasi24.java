public class MahasiswaBerprestasi24 {
    Mahasiswa24[] listMhs;

    MahasiswaBerprestasi24(int jumlah) {
        listMhs = new Mahasiswa24[jumlah];
    }

    void tambah(int index, Mahasiswa24 m) {
        if (index < listMhs.length) {
            listMhs[index] = m;
        }
    }

    void tampil() {
        for (Mahasiswa24 m : listMhs) {
            if (m != null) {
                m.tampilInformasi();
            }
        }
    }

    void bubbleSort() {
        for (int i = 0; i < listMhs.length - 1; i++) {
            for (int j = 0; j < listMhs.length - 1 - i; j++) {
                if (listMhs[j] != null && listMhs[j + 1] != null && listMhs[j].ipk < listMhs[j + 1].ipk) {
                    Mahasiswa24 tmp = listMhs[j];
                    listMhs[j] = listMhs[j + 1];
                    listMhs[j + 1] = tmp;
                }
            }
        }
    }

    int sequentialSearching(double cari) {
        int posisi = -1;
        for (int j = 0; j < listMhs.length; j++) {
            if (listMhs[j].ipk == cari) {
                posisi = j;
                break;
            }
        }
        return posisi;
    }

    int findBinarySearch(double cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (cari == listMhs[mid].ipk) {
                return mid;
            } else if (listMhs[mid].ipk > cari) {
                return findBinarySearch(cari, left, mid - 1);
            } else {
                return findBinarySearch(cari, mid + 1, right);
            }
        }
        return -1;
    }

    void tampilPosisi(double x, int pos) {
        if (pos != -1) {
            System.out.println("Data mahasiswa dengan IPK: " + x + " ditemukan pada indeks " + pos);
        } else {
            System.out.println("Data mahasiswa dengan IPK " + x + " tidak ditemukan");
        }
    }

    void tampilDataSearch(double x, int pos) {
        if (pos != -1) {
            System.out.println("NIM\t: " + listMhs[pos].nim);
            System.out.println("Nama\t: " + listMhs[pos].nama);
            System.out.println("Kelas\t: " + listMhs[pos].kelas);
            System.out.println("IPK\t: " + x);
        } else {
            System.out.println("Data mahasiswa dengan IPK " + x + " tidak ditemukan");
        }
    }
}