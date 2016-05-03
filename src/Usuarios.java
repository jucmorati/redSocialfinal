
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Camilo
 */
public class Usuarios {
    private String nombre;
    private String nick;
    private int edad;
    private String clave;
    private String correo;
    ArrayList<Comentarios> comentario;
    ArrayList<Fotografia> fotografias;
    
    

    public Usuarios(String nombre, String nick, int edad, String clave, String correo) {
       
        if (edad<18){
            throw new IllegalArgumentException("es necesario ser mayor de edad");
        }
  
        
        if (clave.equals("123456")){
            throw new IllegalArgumentException("contraseña no permitida");
        }
        this.nombre = nombre;
        this.nick = nick;
        this.edad = edad;
        this.clave = clave;
        this.correo = correo;
        this.comentario=new ArrayList<Comentarios>();
        if (comentario.size()>200){
            //throw new IllegalArgumentException("Comentario muy extenso, disminuya la cantidad de caracteres");
        }
        this.fotografias=new ArrayList<Fotografia>();

        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void addComentario (Comentarios com){
        comentario.add(com);
        
    }
    public void addFotografia (Fotografia fot){
        fotografias.add(fot);
    }
    

    @Override
    public String toString() {
        return "Usuarios{" + "nombre=" + nombre + ", nick=" + nick + ", edad=" + edad + ", correo=" + correo + '}';
    }

   
}
