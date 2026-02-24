import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {

        // Menggunakan try-with-resources (Scanner diletakkan di dalam kurung try)
        try (Scanner input = new Scanner(System.in)) {

            // 1. Input jumlah data
            if (input.hasNextInt()) {
                int N = input.nextInt();
                int[] nilai = new int[N];

                // 2. Input deret nilai
                for (int i = 0; i < N; i++) {
                    nilai[i] = input.nextInt();
                }

                // 3. Input kode kelompok
                String kelompok = input.next();

                int total = 0;

                // 4. Hitung total sesuai kelompok
                if (kelompok.equalsIgnoreCase("A")) {
                    // indeks ganjil (posisi 1, 3, 5...) -> indeks 0, 2, 4...
                    for (int i = 0; i < N; i += 2) {
                        total += nilai[i];
                    }
                } else if (kelompok.equalsIgnoreCase("B")) {
                    // indeks genap (posisi 2, 4, 6...) -> indeks 1, 3, 5...
                    for (int i = 1; i < N; i += 2) {
                        total += nilai[i];
                    }
                }

                System.out.println(total);
            }
        } // Scanner otomatis ditutup di sini secara aman oleh sistem
    }
}
