/**
 *
 * @author Berk Tunç(berk.tunc@ogr.sakarya.edu.tr)  B171200016
 *         Muhammed Emin Bal (muhammed.bal1@ogr.sakarya.edu.tr)  B171200018
 * @since 13.4.2020
 * <p>
 *  Kendimizin ürettiği Rastgele(RANDOM) sayı kütüphanesi.
 * </p>
 */
package Rastgelesayıüret;


public class rastgelesayıüret {    //Random sayı üretmenin mantığı bilgisayar üstündekisaatin gerekli işlemler  sonucunda elde edilen sayılardan oluşmaktadır.
    
public int max;
public int last;

public rastgelesayıüret(int max){   //RASTGELESAYI üretme metodumuz.
    this.max = max;
    last = (int) (System.currentTimeMillis() % max);
}

    public rastgelesayıüret () {
        throw new UnsupportedOperationException("HATA!"); 
    }


public int nextInt(){   //Aralık için belirlediğimiz fonksiyonumuz.
    last = (last * 32719 + 3) % 32749;       //Şuan bulunduğumuz her anda milisaniyeler çok hızla geçtiğinden neredeyse her zaman random sayı ürettiğimizde farklı sayılar karşımıza çıkmaktadır. 
    return last % max;
    
    
    
}

    public void nextInt(int i) {
        throw new UnsupportedOperationException("HATA!");
    }



    
}
