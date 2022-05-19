/**
 *
 * @author Berk Tunç(berk.tunc@ogr.sakarya.edu.tr)  B171200016
 *         Muhammed Emin Bal (muhammed.bal1@ogr.sakarya.edu.tr)  B171200018
 * @since 13.4.2020
 * <p>
 *  Programı çalıştırıp kontol ettiğimiz Yerdir.
 * </p>
 */
package deneme;
import RASTGELEKISIURET.*;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;     //KÜTÜPHANE EKLEMELERİ.
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Test {

    
    private static final Scanner Giris = new Scanner(System.in);
    private static final Kisi _Kisi = new Kisi();
    private static int secim = 0;
    private static int UretilecekKisiSayisi;
    public static void main(String[] args) throws IOException {
        
    
        Kisi dene = new Kisi();
        System.out.println(dene.KimlikKontrol("15289743684")); //RASTGELE sayılardan oluşan tc no yazdık.Geçersiz olduğuna dair uyarı verecektir.
                                                       //MANUEL olarak Tc girip doğruluğunu kontrol edebiliriz.Ek özellik.
        
        
            while (secim != 3) {
            Secim();
            switch (secim) {

                case 1:
                    RastgeleKisiUret(UretilecekKisiSayisi); //ÜRETİCLECEK kişi sayısı yazılır.
                    break;

                case 2:
                    KontrolEt();        //Üretilmiş dosya kontrol edilir.
                    break;
                default:
                    System.out.println("Çıkış Yapıldı...");   //Programdan çıkış yapılır.
                    break;
            }

        }
    }
    
      public static void Secim() { //HANGİ İŞLEMİ YAPACAĞIMIZ SEÇİLİR.

        System.out.println("1 - Rastgele Kişi Üret\n2 - Üretilmiş Dosya Kontrol Et\n3 - Çıkış");
        System.out.print("Seçiminiz :");   //HANGİ seçenek seçilecek numara yazılır.
        secim = Giris.nextInt();

        while (secim < 1 || secim > 3) {  //1 ve 3 arasındaki değerler yazılmamışsa.
            System.out.println("Lütfen Geçerli Değerler Giriniz!\n1 - Rastgele Kişi Üret\n2 - Üretilmiş Dosyayı Kontrol Et\n3 - Çıkış");
            System.out.print("Seçiminiz :");  //Yeni değer ister.
            secim = Giris.nextInt();
        }
        if (secim == 1) {
            System.out.print("Üretilecek Kişi Sayısını Yazınız :");
            UretilecekKisiSayisi = Giris.nextInt();
        }

    }

    public static void RastgeleKisiUret(int in) throws FileNotFoundException, IOException {

        for (int i = 0; i < in; i++) {  //Girilen kişi sayısı kadar üretim yapılır.

            String Kayıt = _Kisi.KisiOlustur();  

            File file = new File("Kisiler.txt");   //Kişiler dosyası.
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file, true);    //True oluyorsa işlem yapılır.
            BufferedWriter bWriter = new BufferedWriter(fileWriter);

            bWriter.write(Kayıt);
            bWriter.newLine();           //KAYIR txt'e yazdırılır.
            bWriter.close();
        }
        System.out.println("Kayıt Başarıyla eklendi.");  

    }

    public static void KontrolEt() throws FileNotFoundException, IOException {   //Oluşturulan kişilerin algoritma kontrolü yapılır.

        FileReader fileReader = new FileReader("Kisiler.txt"); //DOSYA OKUMA İŞLEMİ
        String line;
        
        try (BufferedReader okuma = new BufferedReader(fileReader)) {
            int GecerliTc = 0, GecersizTc = 0, GecerliImei = 0, GecersizImei = 0;
            while ((line = okuma.readLine()) != null) {     //tüm satılır bitene kadar okuma işlemi döngü sürer.

                String[] Bilgiler = line.split(" ");

                if ("GeçerliTc".equals(_Kisi.KimlikKontrol(Bilgiler[0]))) {
                    GecerliTc++;
                } else if ("GeçersizTc".equals(_Kisi.KimlikKontrol(Bilgiler[0]))) {
                    GecersizTc++;
                }                     //ALGORİTMA GEÇERLİLİK VE GEÇER OLMAYAN DURUMLAR.

                if ("GeçerliImei".equals(_Kisi.ImeiKontrol(Bilgiler[5].substring(1, Bilgiler[5].length() - 1)))) {
                    GecerliImei++;
                } else if ("GeçersizImei".equals(_Kisi.ImeiKontrol(Bilgiler[5].substring(1, Bilgiler[5].length() - 1)))) {
                    GecersizImei++;
                }

            }
            System.out.println("\nT.C Kimlik Kontrol\n" + GecerliTc + " Geçerli\n" + GecersizTc + " Geçersiz");
            System.out.println("\nIMEI Kontrol\n" + GecerliImei + " Geçerli\n" + GecersizImei + " Geçersiz\n");
        }

    }
    
}
