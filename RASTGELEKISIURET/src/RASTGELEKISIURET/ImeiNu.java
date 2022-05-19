/**
 *
 * @author Berk Tunç(berk.tunc@ogr.sakarya.edu.tr)  B171200016
 *         Muhammed Emin Bal (muhammed.bal1@ogr.sakarya.edu.tr)  B171200018                     
 * @since 13.4.2020
 * <p>
 *  Bu sınıfta Imei Algoritması kurallarına uygun olarak Imei üretiliyor ve döndürülüyor. Imei Kontrol kısmında ise gelen Imei parametresine göre kontol yapılmaktadır.
 * </p>
 */
package RASTGELEKISIURET;

import Rastgelesayıüret.rastgelesayıüret;


public class ImeiNu {

    private final rastgelesayıüret mynumber = new rastgelesayıüret(9);   //Kendi ürettiğimiz Rastgelesayıüret kütüphanesi kullanıldı.
    private String ImeiNumarasi = "";

    public String IMEINo() {
        
        ImeiNumarasi = "";
        
        int ImeiSeries[] = new int[15], Tsayi = 0, Csayi = 0, yedek = 0;   //imeiDizisi oluşturuyoruz.
        for (int i = 0; i < 15; i++) {
            ImeiSeries[i] = mynumber.nextInt();
        }
        for (int i = 0; i <= 12; i += 2) {
            Tsayi += ImeiSeries[i];
        }
        for (int a = 1; a <= 13; a += 2) {
            yedek = ImeiSeries[a] * 2;
            if (yedek > 9) {
                yedek = yedek - 9;
            }
            Csayi += yedek;
        }
        yedek = Csayi + Tsayi;
        
        double Yyedek = ((Math.ceil(yedek / 10)) * 10) + 10;
        if (((int) Yyedek - yedek) > 9) {
            ImeiSeries[14] = ((int) Yyedek - yedek) % 10;
        } else {
            ImeiSeries[14] = (int) Yyedek - yedek;
        }
        for (int a = 0; a < 15; a++) {
            ImeiNumarasi += ImeiSeries[a];
        }
        return ImeiNumarasi;
    }

    public String ImeiKontrol(String Imei) {
        
        String Imeidöngü = "";
        double KTsayi = 0, KCsayi = 0;
        int ImeiSeries[] = new int[Imei.length()]; //Dizimizi imeinin uzunluğuna eşitliyoruz.

        if (Imei.length() != 15) {    //imei dizisinin uzunluğu 15e eşit değilse Geçersiz kılıyoruz.
            return "GeçersizImei";
        }
        for (int i = 0; i < Imei.length(); i++) {    //İmei dizimizi 1 er 1 er artırıyoruz.
            ImeiSeries[i] = Integer.parseInt(Imei.substring(i, i + 1));  //parse işelmi yapılır.
        }
        for (int i = 0; i <= 12; i += 2) {
            KTsayi += ImeiSeries[i];
        }
        for (int i = 1; i <= 13; i += 2) {          //İmei numarasının geçerli olması için oluşturulan algoritmarı internetten bulup programımıza ekliyoruz.
            if (ImeiSeries[i] * 2 > 9) {
                KCsayi += ImeiSeries[i] * 2 - 9;
            } else {
                KCsayi += ImeiSeries[i] * 2;
            }
        }
        double Kyedek = ((Math.ceil((KTsayi + KCsayi) / 10)) * 10);  //imei numarasının algoritmalarından biri olan bu sorguyu gerçekleştiriyoruz.
        
        for (int i = 0; i < 15; i++) {  
            Imeidöngü += ImeiSeries[i];
        }
        if (Kyedek - (KTsayi + KCsayi) == ImeiSeries[14]) {     //Kyedek ten KT+KC yi çıkardığımızda 14 tutarsa geçerli değilse geçersiz sayıyoruz.
            return "GeçerliImeiNumarası";
        } else {
            return "GeçersizImeiNumarası";
        }
    }
}
