/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lectura;

import java.io.FileInputStream;
import java.io.*;
import java.util.Scanner;

public class Lectura {
    public void leerArchivo (String nick) throws FileNotFoundException {  
            Scanner lectura = new Scanner(new File("salida.txt"));

        while(lectura.hasNext()){
        String rol = lectura.nextLine();
            String[] palabraspartir = rol.split(";");   
            if (palabraspartir[0].equals("USUARIO")){
                if(palabraspartir[2].equals(nick)){
                System.out.println(palabraspartir[1]+" "+palabraspartir[2]+" "+palabraspartir[3]+" "+palabraspartir[4]);   
                 }
            
            }
        }
    }
    public void leerComentario(String line) throws FileNotFoundException {
                    Scanner lectura = new Scanner(new File("salida.txt"));

        while(lectura.hasNext()){
            String rol = lectura.nextLine();
            String[] palabraspartir = rol.split(";");
            if (palabraspartir[0].equals(" COMENTARIO")){
                if (palabraspartir[3].equals(line)){
                    System.out.println(palabraspartir[1]);
                }
                
            }
            
        }
        
    }
}