/**
 *
 * @author Berk Tunç(berk.tunc@ogr.sakarya.edu.tr)  B171200016
 *         Muhammed Emin Bal (muhammed.bal1@ogr.sakarya.edu.tr)  B171200018
 * @since 13.4.2020
 * <p>
 *  Bu sınıfta 0 dan 100 e kadar Random bir şekilde sayı üretiliyor ve yaşa atanıyor.
 * </p>
 */
package RASTGELEKISIURET;


import Rastgelesayıüret.rastgelesayıüret;


public class Yas {

    rastgelesayıüret rakamuret = new rastgelesayıüret(100);     //RASTGELesayıKütüphanemiz kullanılarak random 0 dan 100 e random sayı üretilir.

    public int Yas() {
        return rakamuret.nextInt();           
    }
}
