
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Camilo
 */
public class Comentarios {
    private String comentario;
    private String fechacreacion;

    public Comentarios(String comentario, String fechacreacion) {
        if(comentario.length() >= 200) {
            throw new IllegalArgumentException("El tamaño del comentario es muy grande");
        }
        this.comentario = comentario;
        this.fechacreacion = fechacreacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Override
    public String toString() {
        return "Comentarios{" + "comentario=" + comentario + ", fechacreacion=" + fechacreacion + '}';
    }

   
    
}
