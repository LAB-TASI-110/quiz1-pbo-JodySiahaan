import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        // Menggunakan try-with-resources agar Scanner otomatis tertutup
        try (Scanner input = new Scanner(System.in)) {
            
            String[] menu = {
                    "Nasi Padang",
                    "Rendang",
                    "Ayam Goreng"
            };

            int[] harga = {25000, 30000, 22000};
            int[] porsi = new int[3];

            // Input porsi
            for (int i = 0; i < menu.length; i++) {
                System.out.print("Masukkan porsi " + menu[i] + ": ");
                porsi[i] = input.nextInt();
            }

            System.out.println();
            // Header
            System.out.printf("%-20s %-10s %-10s %-10s\n", "Menu", "Porsi", "Harga", "Total");
            System.out.println("============================================================");

            int totalPembayaran = 0;

            for (int i = 0; i < menu.length; i++) {
                int total = porsi[i] * harga[i];
                totalPembayaran += total;

                System.out.printf("%-20s %-10d %-10d %-10d\n", 
                        menu[i], porsi[i], harga[i], total);
            }

            System.out.println("============================================================");
            System.out.printf("%-42s %d\n", "Total Pembayaran", totalPembayaran);
        } // Scanner otomatis ditutup di sini secara aman
    }
}
