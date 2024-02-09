/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4p2_andreflores_gerardohasbum;

/**
 *
 * @author ghasb
 */
public abstract class Agentes extends Personas {

    private double precio;
    private double vida;
    private double DMG;

    public Agentes() {
    }

    public Agentes(double precio, double vida, double DMG, String nombre, int edad) {
        super(nombre, edad);
        this.precio = precio;
        this.vida = vida;
        this.DMG = DMG;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public double getDMG() {
        return DMG;
    }

    public void setDMG(double DMG) {
        this.DMG = DMG;
    }


    @Override
    public String toString() {
        return super.toString() + "precio=" + precio + ", vida=" + vida + ", DMG=" + DMG + '}';
    }
    
    public abstract double danio(Agentes agente);


}
