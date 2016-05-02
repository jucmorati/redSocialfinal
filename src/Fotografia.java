
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
public class Fotografia {
    private String nombrearchivo;
    private String publico;//persona que publico la foto
    private String descripcionopcional;
    ArrayList <String> etiquetados;  
    ArrayList <Coordenadas> coordenadas;

    public Fotografia(String nombrearchivo, String descripcionopcional,String publico) {
        this.nombrearchivo = nombrearchivo;
        this.descripcionopcional = descripcionopcional;
        this.publico=publico;
        this.etiquetados=new ArrayList <String>();
        this.coordenadas=new ArrayList <Coordenadas>();

    }

    public String getPublico() {
        return publico;
    }

    public void setPublico(String publico) {
        this.publico = publico;
    }
    

    public String getNombrearchivo() {
        return nombrearchivo;
    }

    public void setNombrearchivo(String nombrearchivo) {
        this.nombrearchivo = nombrearchivo;
    }

    public String getDescripcionopcional() {
        return descripcionopcional;
    }

    public void setDescripcionopcional(String descripcionopcional) {
        this.descripcionopcional = descripcionopcional;
    }
public void addUsuario (String nick){
    etiquetados.add(nick);
}
public void addCoordenadas(Coordenadas coor){
    coordenadas.add (coor);
}
 
    
}
