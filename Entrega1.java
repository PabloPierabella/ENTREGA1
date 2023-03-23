/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.entrega1;

/**
 *
 * @author Pablo Pierabella
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Entrega1 {

    public static void main(String[] args) throws FileNotFoundException {
        int i =0,puntaje=0;
        String eq1,eq2,g1,g2,eqA,eqB,gA,gB,EMP;
        String ruta1="C:\\Users\\Franco\\Desktop\\Resultados.txt";
        String ruta2="C:\\Users\\Franco\\Desktop\\PRONOSTICO.txt";
        File archivo_P= new File(ruta2);
        File archivo_R= new File(ruta1);
        int[] puntos = new int[2];
        Scanner scr = new Scanner(archivo_R);
        Scanner scr2 = new Scanner(archivo_P);
        while(scr.hasNextLine()){
            String linea=scr.nextLine();
            String[] parts= linea.split("\t");
            eq1 = parts[0];
            g1 = parts[1];
            g2 = parts[2];
            eq2 = parts[3];
            Partido objPar = new Partido(eq1,g1,g2,eq2);
            //1 si gano eq1, 0 si empataron y -1 si gano g2
            int n1=Integer.parseInt(g1);
            int n2=Integer.parseInt(g2);
            System.out.println(n1);
            System.out.println(n2);
            if(n1>n2){
                puntos[i]=1;
                System.out.println("gano el eq1");
            }else{
                if(n2>n1){
                    puntos[i]=-1;
                    System.out.println("gano el eq2");
                }else{
                    puntos[i]=0;
                    System.out.println("empataron");
                }
            }i++;
        }
        
       /* for(i=0;i<2;i++){
            System.out.println(puntos[i]);
        }*/
        while(scr2.hasNextLine()){
            i=0;
            String linea=scr2.nextLine();
            String[] parts= linea.split("\t");
            eqA= parts[0];
            gA = parts[1];
            EMP = parts[2];
            gB = parts[3];
            eqB = parts[4];
            Pronostico objPro = new Pronostico(eqA,gA,EMP,gB,eqB);
            if("1".equals(gA) && puntos[i]==1){
                System.out.println("+1 punto");
                puntaje++;
            }else{
                if("1".equals(gB) && puntos[i]==-1){
                System.out.println("+1 punto");
                puntaje++;
            }else{
                if("1".equals(EMP) && puntos[i]==0){
                System.out.println("+1 punto");
                puntaje++;
            }
                }
            }i++;
        }
        scr.close();
        System.out.println("el puntaje es:" + puntaje);
    }
}
