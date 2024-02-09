package lab4p2_andreflores_gerardohasbum;

public abstract class Agua extends Agentes{

    public Agua(double precio, int vida, double DMG, String nombre, int edad) {
        super(precio, vida, DMG, nombre, edad);
    }public double Danio(Agentes agente) {
        double trudmg = 0;
        
        if (agente instanceof Fuego) {
            trudmg = getDMG() * 1.3;
        } else if (agente instanceof Tierra) {
            trudmg = getDMG();
        } else if (agente instanceof Viento) {
            trudmg = getDMG() * 0.5;
        }
        
        return trudmg;
    }
    
}
