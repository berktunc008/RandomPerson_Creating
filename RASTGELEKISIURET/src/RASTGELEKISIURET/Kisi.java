/**
 *
 * @author Berk Tunç(berk.tunc@ogr.sakarya.edu.tr)  B171200016
 *         Muhammed Emin Bal (muhammed.bal1@ogr.sakarya.edu.tr)  B171200018
 * @since 13.4.2020
 * <p>
 * Kişilerin özelliklerinin hangi sıraya göre dizileceğini belirlediğimiz sınıf.
 * </p>
 */
package RASTGELEKISIURET;


public class Kisi {        //Üretilecek kişinin sırasyıla hangi özelliklere sahip olması gerektiği eklendi.
    private final RastgeleKisi YeniKisi = new RastgeleKisi();
    private final Yas YeniYas = new Yas();
    private final Telefon YeniTelefon = new Telefon();
    private final ImeiNu YeniImei = new ImeiNu();
    private final KimlikNu YeniKimlik = new KimlikNu();
    private String Gonder;

    public String KisiOlustur() {
        Gonder = YeniKimlik.KimlikNu() + " " + YeniKisi.RastgeleKisi() + " " + YeniYas.Yas() + " " + YeniTelefon.Telefon() + " (" + YeniImei.IMEINo() + ")";
        return Gonder;
    }

    public String KimlikKontrol(String Kimlik) {   //TC nu

        KimlikNu Tckontrol = new KimlikNu();
        return Tckontrol.KimlikNuKontrol(Kimlik);
    }

    public String ImeiKontrol(String Imei) {      //İMEI 
        ImeiNu ImeiKontrol = new ImeiNu();
        return ImeiKontrol.ImeiKontrol(Imei);
    }
}
