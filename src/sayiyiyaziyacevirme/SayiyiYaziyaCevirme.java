/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sayiyiyaziyacevirme;

import java.util.Scanner;

/**
 *
 * @author burak
 */
public class SayiyiYaziyaCevirme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] basamakTuru = {"yüz ", " bin ", " milyon ", " milyar ", " trilyon "};
        String[] sayılar = {"", " bir ", " iki ", " üç ", " dört ", " beş ", " altı ", " yedi ", " sekiz ", " dokuz "};
        String[] onlular = {"", " on ", " yirmi ", " otuz ", " kırk ", " elli ", " altmış ", " yetmiş ", " seksen ", " doksan "};

        Scanner girilenSayi = new Scanner(System.in); // Ekrandan girilen sayıyı alır
        int sayı = girilenSayi.nextInt();
        
        String yazi = ""; // sayının tamamen yazı halinde yazılması için kullanılır
        String uclukYazi = ""; // 3 lü basamakların nasıl yazılacağı için kullanılır
        
        int ucluSayi = sayı % 1000;
        int i = 0;
        int birler;
        int onlar;
        int yuzler;

        if(sayı == 0){ // 0 değeri girilmiş ise döngüye girmeden yazdırılır
            yazi = "sıfır";
        }
        
        while (sayı > 0) { // girilen sayı 0 tan büyük olduğu sürece yazılacak yazı oluşturulur

            birler = ucluSayi % 10; // 3 lü basamakların birler basamağını bulmak için mod 10 değerine bakılır
            onlar = (ucluSayi % 100) / 10; // 3 lü sayının onlar basamağındaki değer bulmak için  mod 100 değeri 10 a bölünür
            yuzler = ucluSayi / 100;

            if (yuzler == 0) { // yüzler basamağının 0 kontrolü >> 001 bir yazması
                uclukYazi = onlular[onlar] + sayılar[birler];
            } else if (yuzler == 1) { // yüzler basamağının 1 kontrolü >> 120 yüz yirmi yazması
                uclukYazi = " yüz " + onlular[onlar] + sayılar[birler];
            } else { // yüzler basamağı 0 ve 1 den farklı ise >> 200 iki yüz yazması
                uclukYazi = sayılar[yuzler] + " yüz " + onlular[onlar] + sayılar[birler];
            }

            if (i > 0) { // sayının değeri 1000 den büyükse bin milyon gibi ifadelerin eklenmesi
                if ((birler == 1) && (onlar == 0 && yuzler == 0) && i == 1) { // bir bin yazılmasının engellenmesi
                    uclukYazi = basamakTuru[i];
                } else if (birler == 0 && onlar == 0 && yuzler == 0) { // 000 ın kontrolü
                    uclukYazi = uclukYazi;
                } else {
                    uclukYazi = uclukYazi + basamakTuru[i];
                }

            }
            
            sayı -= (yuzler * 100 + onlar * 10 + birler);
            if (sayı >= (10 ^ (3))) { // sayının 1000 den büyük olup olmamasının kontrolü
                sayı /= 1000;
                ucluSayi = sayı % 1000;
                i++;
            }

            yazi = uclukYazi + yazi;
        }

        System.out.println(" sayı : " + yazi);
    }

}
