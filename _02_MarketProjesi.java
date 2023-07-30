package PROJELER;

import java.util.Scanner;

public class _02_MarketProjesi {
    public static void main(String[] args) {
        System.out.println("Team 4 Bakkalına Hoşgeldiniz");

        String[] urunler = {"Elma", "Karpuz", "Portakal", "Muz"};
        Double[] fiyatlar = {1.50, 4.99, 0.75, 12.99};
        int[] stoklar = {50, 20, 100, 10};


        // ürünleri listeledik ve seçim yapmasını istiyoruz:

        System.out.println("Alışveriş listemiz:");
        for (int i = 0; i < urunler.length; i++) {
            System.out.println((i + 1) + ". " + urunler[i] + " - " + fiyatlar[i] + " TL");
        }
        System.out.println("Lütfen almak istediğiniz ürünleri seçin (örn: 1 2 4):");


        // Kullanıcıdan alışveriş yapmak istediği ürünleri ve miktarlarını alalım:

        Scanner scanner = new Scanner(System.in);
        String secim = scanner.nextLine();
        String[] secimler = secim.split(" ");//diziyi parçalara ayırmaya yarar  yani sayı ile gireceğiz
        //onu parçalara ayırarak hangisi ne kadarsa ona yönlendirip fiyat ile istenilen miktarı çarpacağız
        int[] miktarlar = new int[secimler.length];

        for (int i = 0; i < secimler.length; i++) {
            int index = Integer.parseInt(secimler[i]) - 1;
            System.out.println(urunler[index] + " kaç adet almak istersiniz?");
            miktarlar[i] = scanner.nextInt();
            scanner.nextLine();
        }

        //Seçilen ürünlerin toplam fiyatını hesaplayalım:

        double toplamFiyat = 0;
        for (int i = 0; i < secimler.length; i++) {
            int index = Integer.parseInt(secimler[i]) - 1;
            toplamFiyat += fiyatlar[index] * miktarlar[i];
        }
        //Stok yeterliliğini kontrol edelim ve işlemi tamamlayalım:

        boolean stokYeterli = true;
        String eksikUrunler = "";
        for (int i = 0; i < secimler.length; i++) {
            int index = Integer.parseInt(secimler[i]) - 1;
            if (stoklar[index] < miktarlar[i]) {
                stokYeterli = false;
                eksikUrunler += urunler[index] + " (" + (miktarlar[i] - stoklar[index]) + " kilo eksik)\n";
                //bu if döngüsünde girdiğimiz sayı örneğin 300 ama stok sayımız 10 ise
                //290 kilo eksik var yazdıracak ve program durdurulaacak
            }
        }

        if (stokYeterli) {
            System.out.println("Toplam fiyat: " + toplamFiyat + " TL");
            System.out.println("Alışveriş tamamlandı.");
        } else {
            System.out.println("Maalesef stokta yeterli ürün yok:");
            System.out.println(eksikUrunler);
            System.out.println("Alışveriş tamamlandı.");
        }

        // Müşteriye tekrar alışveriş yapmak isteyip istemediğini soralım:

        System.out.println("Tekrar alışveriş yapmak istiyor musunuz? (E/H)");
        String cevap = scanner.nextLine();
        if (cevap.equals("E")) {
            System.out.println("Lütfen almak istediğiniz ürünleri seçin (örn: 1 2 4):");
            //önceki adımlar tekralanacak yapmadım çok uzun diye
        }
         else {
        // Programı sonlandırın ve sipariş özetini yazdırın.
        System.out.printf("alışverişiniz tamamlanmıştır. Team 4 marketi iyi günler diler :)");
        }


    }
}
