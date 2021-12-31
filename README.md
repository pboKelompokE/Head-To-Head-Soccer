# Head-To-Head-Soccer

Deskripsi game:
Aplikasi ini dibuat dengan mendiskripsikan 2 player. Dimana player akan menentukan gawang dan titik menendang terlebih dahulu. Pertandingan berjumlah 5 ronde ketika salah satu pemain sudah menendang bola maka pertandingan akan diulang dan kedua player akan menentukan titik gawang dan titik menendang kembali. Akan ada hadiah pagi pemenang di akhir pertandingan.


1. Objek 
a. Gawang 
b. Player
c. Bola
d. Skor 
e. Lapangan
f. Menentukan skor
g. menendang bola
h. Penentuan pemenang
i. Hadiah
j. Menentukan hadiah

2. Class : Lapangan
- Method :
Menendang, menentukan skor, penentuan pemenang, penentuan hadiah

3. Variabel
a. Player A
b. Player B
c. Bola
d. Skor
e. Hadiah

import java.util.*;
import java.io.*;
import java.util.Scanner;
public class Gamepenalti{
        public static void main(String args[]){
        }
        class play {
            static void loader(int idTim2, int tukar) throws Exception {
                int c=0;
                boolean s=false;
                System.out.println();
                for (int x = 0; x < 30; x++) {
                    if (idTim2 == 0)
                        System.out.print("   ");
                    System.out.print("   [");
                    if (c==0)
                        s=false;
                    else if (c==6)
                        s=true;

                    if (s==false)
                        c++;
                    else
                        c--;

                    for (int i=0; i<7; i++) {
                        if (i==c)
                            System.out.print("*");
                        else
                            System.out.print("-");
                    }

                    System.out.print("] >> ");
                    if (idTim2 == 0)
                        System.out.println("Komputer memilih sebuah tim");
                    else if (tukar == 1)
                        System.out.print("Komputer melakukan tendangan");
                    else if (tukar == 0)
                        System.out.print("komputer melakukan tangkapan");
                    Thread.sleep(85);
                    System.out.print("\r");

                }
            }

            static void clearScreen() {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }

            static void resetTitik() {
                for (int i=1; i <= 9; i++){
                    titik[i] = "  ";
                }
            }

            static int cekInput(int input){

                do {
                    System.out.print("Masukkan pilihan: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Ulangi pilihan");
                        sc.next();
                    }
                    input = sc.nextInt();
                    return input;
                }while (input <= ((input == 1)? 1 : 0) && input >= ((input == 1) ? 19 : 2));
            }

            static void getPemenang(int skor1, int skor2, String tim1, String tim2) {

                if (skor1 > skor2)
                    System.out.println("        "+tim1);
                else
                    System.out.println("        "+tim2);

            }

            static String setBola(int shooter) {
                if (shooter <= 9 && shooter >=1){
                    for (int i = 1; i <= 9; i++){
                        if (shooter == 1);

                    }
                }

                if (shooter >= 1 && shooter <= 9) {
                    return "benar";
                }

                else {
                    return "salah";
                }
            }




        }


    }

