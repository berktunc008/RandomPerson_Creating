/**
 *
 * @author Berk Tunç(berk.tunc@ogr.sakarya.edu.tr)  B171200016
 *         Muhammed Emin Bal (muhammed.bal1@ogr.sakarya.edu.tr)  B171200018
 * @since 13.4.2020
 * <p>
 *  Bu sınıfta Imei Algoritması kurallarına uygun olarak TC numarası üretiliyor ve döndürülüyor. Tcno kontrol kısmında ise gelen parametreye göre geçerlilik kontrolü yapılıyor.
 * </p>
 */
package RASTGELEKISIURET;


import Rastgelesayıüret.rastgelesayıüret;


public class KimlikNu {

    private final rastgelesayıüret mynumber = new rastgelesayıüret(9);
    private String KimlikNumarasi = "";

    public String KimlikNu() {
        KimlikNumarasi = "";
        int TcSeries[] = new int[11], yedek = 0;   //TC KİMLİK numaramız 11 rakamdan oluşmaktadır.
        for (int sayac = 0; sayac < 11; sayac++) {   //sayaç 11 olanada kadar döndürme işlemini gerçekleştiriyoruz.
            if (sayac == 0) {
                TcSeries[0] = mynumber.nextInt() + 1;       //Diziyi artırma işlemi.
            } else if (sayac < 10) {
                TcSeries[sayac] = mynumber.nextInt();
            }
        }
        TcSeries[9] = (((TcSeries[0] + TcSeries[2] + TcSeries[4] + TcSeries[6] + TcSeries[8]) * 7) - (TcSeries[1] + TcSeries[3] + TcSeries[5] + TcSeries[7])) % 10;
        for (int i = 0; i <= 9; i++) {
            yedek += TcSeries[i];
        }
        TcSeries[10] = yedek % 10;    //Tc kimlik numarasındaki ilk 10 rakamın toplamının birler basamağındaki rakam bizim 11. rakamımız kabul edlir.Bunuda mod alma işlemi ile gerçekleştiriyoruz.
        for (int a = 0; a < 11; a++) {
            KimlikNumarasi += TcSeries[a];   //Yukardaki yazdığımız eşitlik sağlanırsa Kimlik numaramız sağlanmış oluyoruz.
        }
        return KimlikNumarasi;
    }

    public String KimlikNuKontrol(String Tc) {
        if (Tc.length() != 11) {                   //Üretilen TCNO muz 11 rakama eşit değilse GEÇERSİZ SAYILIR.
            return "GeçersizTc";
        }
        int TcSeries[] = new int[Tc.length()];
        for (int i = 0; i < Tc.length(); i++) {
            TcSeries[i] = Integer.parseInt(Tc.substring(i, i + 1));
        }
        int Rakam10, Rakam11, yedek2 = 0;
        Rakam10 = ((TcSeries[0] + TcSeries[2] + TcSeries[4] + TcSeries[6] + TcSeries[8]) * 7 - (TcSeries[1] + TcSeries[3] + TcSeries[5] + TcSeries[7])) % 10;
        for (int i = 0; i <= 9; i++) {           //TC NO yu sağlayan algoritmalardan biridir.
            yedek2 += TcSeries[i];
        }
        Rakam11 = yedek2 % 10;
        if (TcSeries[9] == Rakam10 && TcSeries[10] == Rakam11) {  //Dizinin 9. elemanı 10. rakama veya dizi. 10 elemanı 11 rakama eşitse geçerli sayıyıyoruz.
            return "GeçerliTc";
        } else {
            return "GeçersizTc";
        }
    }
}
