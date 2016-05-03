/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Camilo
 */
public class Coordenadas {
    private int x;
    private int y;

    public Coordenadas(int x, int y) {
        if (x<0){
            throw new IllegalArgumentException("la coordenada x solo puede ser positiva");
        }
        if (y<0){
            throw new IllegalArgumentException("la coordenada y solo puede ser positiva");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordenadas{" + "x=" + x + ", y=" + y + '}';
    }
    

    
}
