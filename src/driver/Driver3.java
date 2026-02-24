import java.util.ArrayList;
import java.util.Scanner;

// Class Pelanggan
class Pelanggan {
    String id;
    String nama;
    String noHp;
    String alamat;

    Pelanggan(String id, String nama, String noHp, String alamat) {
        this.id = id;
        this.nama = nama;
        this.noHp = noHp;
        this.alamat = alamat;
    }
}

// Class Transaksi
class Transaksi {
    String idTransaksi;
    Pelanggan pelanggan;
    String layanan;
    double berat;
    double hargaPerKg;
    double total;
    String status;

    Transaksi(String idTransaksi, Pelanggan pelanggan, String layanan, double berat, double hargaPerKg) {
        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
        this.layanan = layanan;
        this.berat = berat;
        this.hargaPerKg = hargaPerKg;
        this.total = berat * hargaPerKg;
        this.status = "Diproses";
    }
}

public class Driver3 {

    static ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    static ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\n=== SISTEM LAUNDRY DEL ===");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Lihat Pelanggan");
            System.out.println("3. Tambah Transaksi");
            System.out.println("4. Update Status");
            System.out.println("5. Laporan Harian");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // buang enter

            switch (pilihan) {
                case 1:
                    tambahPelanggan();
                    break;
                case 2:
                    lihatPelanggan();
                    break;
                case 3:
                    tambahTransaksi();
                    break;
                case 4:
                    updateStatus();
                    break;
                case 5:
                    laporanHarian();
                    break;
                case 6:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 6);
    }

    // Tambah Pelanggan
    static void tambahPelanggan() {
        System.out.print("ID Pelanggan: ");
        String id = scanner.nextLine();
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("No HP: ");
        String noHp = scanner.nextLine();
        System.out.print("Alamat: ");
        String alamat = scanner.nextLine();

        daftarPelanggan.add(new Pelanggan(id, nama, noHp, alamat));
        System.out.println("Pelanggan berhasil ditambahkan!");
    }

    // Lihat Pelanggan
    static void lihatPelanggan() {
        if (daftarPelanggan.isEmpty()) {
            System.out.println("Belum ada pelanggan.");
        } else {
            for (Pelanggan p : daftarPelanggan) {
                System.out.println("ID: " + p.id + " | Nama: " + p.nama + " | HP: " + p.noHp + " | Alamat: " + p.alamat);
            }
        }
    }

    // Tambah Transaksi
    static void tambahTransaksi() {
        if (daftarPelanggan.isEmpty()) {
            System.out.println("Belum ada pelanggan!");
            return;
        }

        System.out.print("ID Transaksi: ");
        String idTransaksi = scanner.nextLine();

        System.out.print("Masukkan ID Pelanggan: ");
        String idPelanggan = scanner.nextLine();

        Pelanggan pelangganDipilih = null;
        for (Pelanggan p : daftarPelanggan) {
            if (p.id.equals(idPelanggan)) {
                pelangganDipilih = p;
                break;
            }
        }

        if (pelangganDipilih == null) {
            System.out.println("Pelanggan tidak ditemukan!");
            return;
        }

        System.out.println("Pilih Layanan:");
        System.out.println("1. Cuci Kering (7000/kg)");
        System.out.println("2. Cuci Setrika (10000/kg)");
        System.out.println("3. Express (15000/kg)");
        System.out.print("Pilihan: ");
        int pilihanLayanan = scanner.nextInt();

        double hargaPerKg = 0;
        String layanan = "";

        switch (pilihanLayanan) {
            case 1:
                layanan = "Cuci Kering";
                hargaPerKg = 7000;
                break;
            case 2:
                layanan = "Cuci Setrika";
                hargaPerKg = 10000;
                break;
            case 3:
                layanan = "Express";
                hargaPerKg = 15000;
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        System.out.print("Berat (kg): ");
        double berat = scanner.nextDouble();
        scanner.nextLine();

        Transaksi transaksi = new Transaksi(idTransaksi, pelangganDipilih, layanan, berat, hargaPerKg);
        daftarTransaksi.add(transaksi);

        System.out.println("Transaksi berhasil ditambahkan!");
        System.out.println("Total Bayar: Rp " + transaksi.total);
    }

    // Update Status
    static void updateStatus() {
        System.out.print("Masukkan ID Transaksi: ");
        String id = scanner.nextLine();

        for (Transaksi t : daftarTransaksi) {
            if (t.idTransaksi.equals(id)) {
                System.out.println("Status saat ini: " + t.status);
                System.out.print("Masukkan status baru: ");
                t.status = scanner.nextLine();
                System.out.println("Status berhasil diperbarui!");
                return;
            }
        }

        System.out.println("Transaksi tidak ditemukan!");
    }

    // Laporan Harian
    static void laporanHarian() {
        double totalPendapatan = 0;

        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        System.out.println("\n=== LAPORAN TRANSAKSI ===");
        for (Transaksi t : daftarTransaksi) {
            System.out.println("ID: " + t.idTransaksi +
                    " | Pelanggan: " + t.pelanggan.nama +
                    " | Layanan: " + t.layanan +
                    " | Total: Rp " + t.total +
                    " | Status: " + t.status);

            totalPendapatan += t.total;
        }

        System.out.println("Total Pendapatan: Rp " + totalPendapatan);
    }
}
