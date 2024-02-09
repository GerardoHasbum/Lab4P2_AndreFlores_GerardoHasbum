package lab4p2_andreflores_gerardohasbum;

public abstract class Fuego extends Agentes {

    public Fuego(double precio, int vida, double DMG, String nombre, int edad) {
        super(precio, vida, DMG, nombre, edad);
    }

    public double Danio(Agentes agente) {
        double trudmg = 0;
        
        if (agente instanceof Tierra) {
            trudmg = getDMG() * 1.1;
        } else if (agente instanceof Agua) {
            trudmg = getDMG() * 0.85;
        } else if (agente instanceof Viento) {
            trudmg = getDMG() * 0.5;
        }
        
        return trudmg;
    }
    
    

}
