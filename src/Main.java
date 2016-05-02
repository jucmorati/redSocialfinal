
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

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

    
    public static void main(String[] args) {
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
        int edad,op=0,numUsuarios=0;
        String clave;
        String correo;
        
        Scanner sc = new Scanner( System.in );
        while(op != 9) {
            System.out.println("marque 1 para registrar un usuario");
            System.out.println("marque 2 para hacer un comentario");
            System.out.println("marque 3 para subir fotos y etiquetar personas en ellas");
            System.out.println("marque 4 para buscar un usuario por su nick");
            System.out.println("marque 5 para listar los comentariosde un usuario por su nick");
           System.out.println("marque 6 para listar fotografias en las que aparece un usuario ");
           System.out.println("marque 7 para listar comentarios en los que aparece una palabra ");
            op = sc.nextInt();
            switch(op){
                case 1:
                      //registro del usuario
                    System.out.println("ingrese su nombre");
                    nombre=sc.next();
                    System.out.println("ingrese un nick");
                    nick=sc.next();
                    System.out.println("ingrese su edad");
                    edad=sc.nextInt();
                    System.out.println("ingrese su clave");
                    clave=sc.next();
                    System.out.println("ingrese su correo");
                    correo=sc.next();
                    Usuarios usuario=new Usuarios(nombre,nick,edad,clave,correo);
                    redSocial.add(usuario);
                break;
                case 2://hacer comentario( solo para usuarios)
                    
                    System.out.println("escriba un comentario");
                    comentario=sc.next();
                    System.out.println("escriba la fecha de creacion");
                    fechacreacion=sc.next();
                    Comentarios coment =new Comentarios(comentario,fechacreacion);
                    System.out.println("ingrese el nick del usuario que realizo el comentario");
                    nick=sc.next();
                    for(int i =0; i<redSocial.size();i++){
                        if (nick.equals(redSocial.get(i).getNick())){
                            redSocial.get(i).addComentario(coment);
                            comentar.add(coment);
                        }
                    }                 
                    break;
                case 3://subir fotos,marcar nombres de usuario
                    System.out.println("para validar la foto ingrese su nick");
                    publico=sc.next();
                    System.out.println("ingrese el nombre del archivo");
                    nombrearchivo=sc.next();
                    System.out.println("¿desea añadir un comentario(si/no)? ");
                     s=sc.next();
                    Fotografia fotografia;
                    if (s.equals("si")){
                        System.out.println("ingrese su comentario");
                        descripcionopcional=sc.next();
                        fotografia=new Fotografia (nombrearchivo,descripcionopcional,publico);
                    }
                    else {
                        descripcionopcional="no hay comentario";
                        fotografia=new Fotografia (nombrearchivo,descripcionopcional,publico);
                    }
                    System.out.println("Cuantas personas desea etiquetar");
                     numUsuarios=sc.nextInt();
                    int red = 0, nored = 0;
                    for(int j = 0; j < numUsuarios; j++) {
                        System.out.println("ingrese el nick que desea etiquetar"+
                                " o el nombre del no-usuario");
                        nick=sc.next();
                        System.out.println("ingrese la coordenada x (x>0) del etiquetado");
                        x=sc.nextInt();
                        System.out.println("ingrese la coordenada y (y>0) del etiquetado");
                        y=sc.nextInt();                        
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
                    System.out.println("FOTO SUBIDA CORRECTAMENTE");
                    break;                    
                case 4:
                    System.out.println("ingrese el nombre del usuario que busca");
                    nick=sc.next();
                    for(int i =0; i<redSocial.size();i++){
                            if (nick.equals(redSocial.get(i).getNick())){
                                System.out.println(redSocial.get(i).toString());
                            }
                    }
                    break;
                case 5:
                    System.out.println("ingrese el nombre del usuario que busca");
                    nick=sc.next();
                    for(int i =0; i<comentar.size();i++){
                        if (nick.equals(redSocial.get(i).getNick())){
                            System.out.println(comentar.get(i).getComentario());
                        }
                    }
                   break; 
                case 6:
                    System.out.println("ingrese el nombre del usuario que busca");
                    nick=sc.next();
                    //for(int i =0; i<redSocial.size();i++){
                    //    Usuarios usu = redSocial.get(i);
                    for(Usuarios usu: redSocial) {
                        //System.out.println(nick + " " + usu.getNick() + " " + usu.fotografias.size());
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
                    System.out.println("ingrese la palaba para listar los comentarios en los cuales aparece");
                    palabralistar=sc.next();
                    for (int i=0;i<comentar.size();i++){
                    String[] palabras = comentar.get(i).getComentario().split(" ");
                        for(int j=0;j<comentar.get(i).getComentario().length();j++){
                            if(palabras[j].equals(palabralistar)) {
                            System.out.println(comentar.get(i));
                            }
                        }
                    }
            }     
        }
    }  
}