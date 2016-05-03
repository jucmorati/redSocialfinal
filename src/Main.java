


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import Lectura.Lectura;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Camilo
 */
public class Main {

    
    //public static void main(String[] args){
        
    //}
    
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream(new File("salida.txt"));
        ArrayList<Usuarios> redSocial = new ArrayList<>();
        ArrayList<Fotografia> redSocialFotos = new ArrayList<>();
        ArrayList<Comentarios> comentar =new ArrayList<>();        
        int x,y;
        String nombrearchivo,s="",publico,palabralistar="";
        String descripcionopcional;
        String nombre;
        String comentario;
        String fechacreacion;
        String nick;
        int edad = 0,op=0,numUsuarios=0;
        String clave;
        String correo;        
        Scanner sc = new Scanner( System.in );
        Lectura lectura= new Lectura();
        
        while(op != 10) {
            System.out.println("marque 1 para registrar un usuario");
            System.out.println("marque 2 para hacer un comentario");
            System.out.println("marque 3 para subir fotos y etiquetar personas en ellas");
            System.out.println("marque 4 para buscar un usuario por su nick");
            System.out.println("marque 5 para listar los comentariosde un usuario por su nick");
            System.out.println("marque 6 para listar fotografias en las que aparece un usuario ");
            System.out.println("marque 7 para listar comentarios en los que aparece una palabra ");
            op = Integer.parseInt(sc.nextLine());
            switch(op){
                
                case 1:
                      //registro del usuario
                    
                    System.out.println("ingrese su nombre");
                    nombre=sc.nextLine();
                    do {
                        try {
                            if(nombre.length() >= 100) {
                                throw new IllegalArgumentException("");
                            }
                        } catch(IllegalArgumentException ex) {
                            System.out.println("\"Nombre muy extenso, por favor cambielo\"");
                            nombre = sc.nextLine();
                        }
                    } while(nombre.length() >= 100);
                    
                    System.out.println("ingrese un nick");
                    nick=sc.nextLine();
                    System.out.println("ingrese su edad");
                    boolean ok;
                    do{
                        ok = true;
                        try {
                            edad=Integer.parseInt(sc.nextLine());
                        }
                        catch(NumberFormatException ex) {
                            System.out.println("Ingrese un numero por favor");
                            ok = false;
                        }
                        while (edad<18){
                            System.out.println("Debe ser mayor de edad ");
                            edad=Integer.parseInt(sc.nextLine());
                        }
                       
                    } while(ok == false);
                    System.out.println("ingrese su clave");
                    clave=sc.nextLine();
                    System.out.println("ingrese su correo");
                    correo=sc.nextLine();

                    try{
                         Usuarios usuario=new Usuarios(nombre,nick,edad,clave,correo);

                        ps.append("\n"+"USUARIO"+";"+usuario.getNombre()+";"+usuario.getNick()+";"+usuario.getEdad()+";"+usuario.getClave()+";"+usuario.getCorreo());
                                            redSocial.add(usuario);
                                            

                    }
                    catch(IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                        //System.out.println("ingrese su nombre");
                        //nombre=sc.nextLine();
                    }
        
                    
                break;
                case 2://hacer comentario( solo para usuarios)
                    
                    System.out.println("escriba un comentario");
                    comentario=sc.nextLine();                 
                    
                    System.out.println("escriba la fecha de creacion");
                    fechacreacion=sc.nextLine();
                    System.out.println("ingrese el nick del usuario que realizo el comentario");
                    nick=sc.nextLine();
                    Comentarios coment =new Comentarios(comentario,fechacreacion,nick);

                    for(int i =0; i<redSocial.size();i++){
                        if (nick.equals(redSocial.get(i).getNick())){
                            redSocial.get(i).addComentario(coment);
                            try {
                            
                        ps.append("\n "+"COMENTARIO"+";"+coment.getComentario()+";"+coment.getFechacreacion()+";"+coment.getNick1());
                        
                    } catch (Exception e) {
                    }
                    
                            comentar.add(coment);
                        }
                    }                 
                    break;
                case 3://subir fotos,marcar nombres de usuario
                    System.out.println("para validar la foto ingrese su nick");
                    publico=sc.nextLine();
                    System.out.println("ingrese el nombre del archivo");
                    nombrearchivo=sc.nextLine();
                    System.out.println("¿desea añadir un comentario(si/no)? ");
                     s=sc.nextLine();
                    Fotografia fotografia;
                    if (s.equals("si")){
                        System.out.println("ingrese su comentario");
                        descripcionopcional=sc.nextLine();
                        fotografia=new Fotografia (nombrearchivo,descripcionopcional,publico);
                        
                        
                        do {
                        try {
                            if(descripcionopcional.length() >= 200) {
                                throw new IllegalArgumentException("");
                            }
                        } catch(IllegalArgumentException ex) {
                            System.out.println("\"Descripcion muy extensa, por favor cambiela\"");
                            descripcionopcional = sc.nextLine();
                        }
                    } while(descripcionopcional.length() >= 200);
                        
                    }
                    else {
                        descripcionopcional="no hay comentario";
                        fotografia=new Fotografia (nombrearchivo,descripcionopcional,publico);
                    }
                    System.out.println("Cuantas personas desea etiquetar");
                     numUsuarios= Integer.parseInt(sc.nextLine());
                    int red = 0, nored = 0;
                    for(int j = 0; j < numUsuarios; j++) {
                        System.out.println("ingrese el nick que desea etiquetar"+
                                " o el nombre del no-usuario");
                        nick=sc.nextLine();
                        System.out.println("ingrese la coordenada x (x>0) del etiquetado");
                        x= Integer.parseInt(sc.nextLine());
                        System.out.println("ingrese la coordenada y (y>0) del etiquetado");
                        y= Integer.parseInt(sc.nextLine());                        
                        fotografia.addUsuario(nick);
                        Coordenadas coor=new Coordenadas(x,y);
                        fotografia.addCoordenadas(coor);                        
                        boolean encontro = false;
                        for(int i =0; i<redSocial.size();i++){
                            if (nick.equals(redSocial.get(i).getNick())){
                               encontro = true;
                               redSocial.get(i).addFotografia(fotografia);
                            }
                        }
                        if(encontro == true) {red++;}
                        else nored++;
                    }
                    if( !(red >1 && red <6 && nored > 0) ) {
                        throw new IllegalArgumentException("Error en numero de usuarios"+
                        " tener en cuenta solo se pueden etiquetar de 2 a 5 usuarios y"+
                                " y minimo 1 n-usuario");
                    }                    
                    redSocialFotos.add(fotografia);
                     try {
                            
                        ps.append("\n "+"FOTOGRAFIA"+";"+fotografia.getNombrearchivo()+";"+fotografia.getDescripcionopcional()+";"+fotografia.getPublico()+";"+fotografia.etiquetados+";"+fotografia.coordenadas);
                        ps.close();
                                        
                     } catch (Exception e) {
                    }
                    System.out.println("FOTO SUBIDA CORRECTAMENTE");
                    break;                    
                case 4:
                    System.out.println("ingrese el nombre del usuario que busca");
                    nick=sc.nextLine();
                    for(int i =0; i<redSocial.size();i++){
                            if (nick.equals(redSocial.get(i).getNick())){
                               // System.out.println(redSocial.get(i).toString());
                               lectura.leerArchivo(nick);      
                            }
                    }
                    break;
                case 5:
                    System.out.println("ingrese el nick del usuario que busca");
                    nick=sc.nextLine();
                    for(int i =0; i<comentar.size();i++){
                       
                            //System.out.println(comentar.get(i).getComentario());
                            lectura.leerComentario(nick); //mil cosas aca,se repite el resultado
                       
                    }
                   break; 
                case 6:
                    System.out.println("ingrese el nombre del usuario que busca");
                    nick=sc.nextLine();
                    for(Usuarios usu: redSocial) {                       
                        if (nick.equals(usu.getNick())){
                            
                            for(Fotografia foto: usu.fotografias) {
                                System.out.print(foto.getNombrearchivo()+" "+
                                    " fue publicada por " + foto.getPublico()+
                                   "en la foto aparecen: ");
                                
                                for(String name: foto.etiquetados) {
                                    System.out.print(name+" ");
                                }
                            }                                   
                        }
                    }
                    break;
                case 7:
                    System.out.println("ingrese la palabra para listar los comentarios en los cuales aparece");
                    palabralistar=sc.nextLine();
                    for (int i=0;i<comentar.size();i++){
                    String[] palabras = comentar.get(i).getComentario().split(" ");
                       for(int j=0;j<palabras.length;j++){
                            if(palabras[j].equals(palabralistar)) {
                            //System.out.println(comentar.get(i).toString());
                         lectura.leerComentarioCompleto();// aca igualmente se repiten los resultados pero sirve
                            }
                            
                        }
                    }
                    break;
            }    
            
    }
 }               
}  

