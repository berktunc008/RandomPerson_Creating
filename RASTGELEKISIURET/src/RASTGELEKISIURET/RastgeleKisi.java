/**
 *
 * @author Berk Tunç(berk.tunc@ogr.sakarya.edu.tr)  B171200016
 *         Muhammed Emin Bal (muhammed.bal1@ogr.sakarya.edu.tr)  B171200018
 * @since 13.4.2020
 * <p>
 *  RASTGELEKİŞİ ÜRET SINIFI
 * </p>
 */
package RASTGELEKISIURET;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Rastgelesayıüret.rastgelesayıüret;


public class RastgeleKisi {
	// Üretilen Kişiler Metin belgesine Kayıt Edilip Üretilen Kişilerdeki TC Imei Numaraları Geçerlimi Diye Kontrol Edilip Ekrana Yazdırılmaktadır.
    private int SatirSayisi;
    private final rastgelesayıüret mynumber = new rastgelesayıüret(SatirSayisi);
    
    private File file;
    private BufferedReader reader = null;              //DOSYA OKUMA İŞLEMLERİ.

        public String RastgeleKisi(){
         file = new File("..\\RASTGELEKISIURET\\random_isimler.txt");     //Random isimlerin olduğu txt yolu belirrtik.
         
                
        SatirSayisi = 0;
        try {
            reader = new BufferedReader(new FileReader(file));   //DOSYA İŞLEMLERİ
            String satir = reader.readLine();
            while (satir != null) {                         //Önceki ödevde de yapmış olduğumuz şekilde txt belgesini sırayla okutma işlemleri yapılır.
                if (satir.length() > 0) {
                    SatirSayisi++;
                }
                satir = reader.readLine();                //TRY CATCH !
            }
        } catch (final IOException e) {
        }
        
         int sayac = 0;
        String Metin[] = new String[SatirSayisi + 1];
        try {
            reader= new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            Metin[0] = reader.readLine();
            while (Metin[sayac] != null) {
                if (Metin[sayac].length() > 0) {      //DSOYA İŞLEMLERİ.
                    sayac++;
                }
                Metin[sayac] = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return Metin[mynumber.nextInt()];
    
    }
   
    }

