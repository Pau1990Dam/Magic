package com.example.a14270729b.magicconfragment;

/**
 * Created by 14270729b on 04/10/16.
 */

public class Jugador {

    private int vida;
    private int veneno;
    private Jugador jugadorBuffer;

    public Jugador(){
    }

    public Jugador(int vida, int veneno) {
        this.vida = vida;
        this.veneno = veneno;
    }

    public int getVida() {
        return vida;
    }

    public int getVeneno() {
        return veneno;
    }

    public void venenoMas(){
        veneno++;
    }
    public void venenoMenos(){
        veneno--;
    }
    public void vidaMas(){
        vida++;
    }
    public void vidaMenos(){
        vida--;
    }

    public void robarVida(Jugador jugOtro){
        jugOtro.vidaMenos();
        this.vidaMas();
    }

    public void inicializarValores(){
        vida = 20;
        veneno = 0;
    }

    public void llenarBuffer(){
        jugadorBuffer = new Jugador(this.getVida(), this.getVeneno());
    }

    public int getVidaBuffer(){
        return jugadorBuffer.getVida();
    }

    public int getVenenoBuffer(){
        return jugadorBuffer.getVeneno();
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setVeneno(int veneno) {
        this.veneno = veneno;
    }
}
