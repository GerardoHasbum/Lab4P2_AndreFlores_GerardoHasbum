package lab4p2_andreflores_gerardohasbum;

public abstract class Viento extends Agentes {

    public Viento(double precio, int vida, double DMG, String nombre, int edad) {
        super(precio, vida, DMG, nombre, edad);
    }
    
    public double Danio(Agentes agente) {
        double trudmg = 0;
        
        if (agente instanceof Tierra) {
            trudmg = getDMG() * 1.1;
        } else if (agente instanceof Agua) {
            trudmg = getDMG() * 0.7;
        } else if (agente instanceof Fuego) {
            trudmg = getDMG() * 1.5;
        }
        
        return trudmg;
    }
    
}
