package lab4p2_andreflores_gerardohasbum;

public class Agua extends Agentes {

    public Agua(double precio, double vida, double DMG, String nombre, int edad) {
        super(precio, vida, DMG, nombre, edad);
    }

    @Override
    public String toString() {
        return "Agua: " + super.toString();
    }

    
    
    @Override
    public double danio(Agentes agente) {
        double trudmg = 0;

        if (agente instanceof Fuego) {
            trudmg = getDMG() * 1.3;
        } else if (agente instanceof Tierra) {
            trudmg = getDMG();
        } else if (agente instanceof Viento) {
            trudmg = getDMG() * 0.5;
        } else if (agente instanceof Agua) {
            trudmg = 0;
        }

        return trudmg;
    }

}
