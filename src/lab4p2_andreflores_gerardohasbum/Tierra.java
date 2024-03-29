package lab4p2_andreflores_gerardohasbum;

public class Tierra extends Agentes {

    public Tierra(double precio, double vida, double DMG, String nombre, int edad) {
        super(precio, vida, DMG, nombre, edad);
    }

    @Override
    public double danio(Agentes agente) {
        double trudmg = 0;

        if (agente instanceof Fuego) {
            trudmg = getDMG() * 0.7;
        } else if (agente instanceof Agua) {
            trudmg = getDMG() * 1.3;
        } else if (agente instanceof Viento) {
            trudmg = getDMG() * 0.4;
        } else if (agente instanceof Tierra) {
            trudmg = 0;
        }

        return trudmg;
    }

    @Override
    public String toString() {
        return "Tierra: " + super.toString();
    }
    
    

}
