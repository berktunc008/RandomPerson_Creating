/**
 *
 * @author Berk Tunç(berk.tunc@ogr.sakarya.edu.tr)  B171200016
 *         Muhammed Emin Bal (muhammed.bal1@ogr.sakarya.edu.tr)  B171200018
 * @since 13.4.2020
 * <p>
 *  Bu sınıfta Kurallara uygun şekilde telefon numarası üretiliyor.
 * </p>
 */
package RASTGELEKISIURET;


import Rastgelesayıüret.rastgelesayıüret;

public class Telefon {

    private final rastgelesayıüret mynumber = new rastgelesayıüret(5);   //ÜRETTİĞİMİZ RASTGELESAYI KÜTÜPHANESİ İLE RANDOM SAYI ÜRETME
    private final rastgelesayıüret mynumber2 = new rastgelesayıüret(9);
    
    private String TelNumarasi = "";

    public String Telefon() {
        TelNumarasi = "";
        int TelDizi[] = new int[11];         //11 RAKAMDAN OLUŞAN TEL numarası.
        TelDizi[0] = 0;                         //ilk rakam 0 ikinci rakam herzaman 5 le başlar.
        TelDizi[1] = 5;
        TelDizi[2] = mynumber.nextInt() + 2;
        while (TelDizi[2] < 3 || TelDizi[2] > 5) {       //TELEFON NUMARASINDA GEREKLİ OLAN TÜM ALGORİTMALAR
                                                         //internetten araştırılarak eklendi.
            TelDizi[2] = mynumber.nextInt() + 2;
        }
        for (int a = 3; a < 11; a++) {
            TelDizi[a] = mynumber2.nextInt();
        }
        for (int a = 0; a < 11; a++) {
            TelNumarasi += TelDizi[a];
        }
        return TelNumarasi;
    }
}
