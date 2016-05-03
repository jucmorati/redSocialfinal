


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
    private String nick1;

    public Comentarios(String comentario, String fechacreacion,String nick1) {
        if(comentario.length() >= 200) {
            throw new IllegalArgumentException("El tamaño del comentario es muy grande");
        }
        this.comentario = comentario;
        this.fechacreacion = fechacreacion;
        this.nick1=nick1;
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

    public String getNick1() {
        return nick1;
    }

    public void setNick1(String nick1) {
        this.nick1 = nick1;
    }

    @Override
    public String toString() {
        return "Comentarios{" + "comentario=" + comentario + ", fechacreacion=" + fechacreacion + '}';
    }

   
    
}
