package lab4p2_andreflores_gerardohasbum;

public class Viento extends Agentes {

    public Viento(double precio, int vida, double DMG, String nombre, int edad) {
        super(precio, vida, DMG, nombre, edad);
    }

    @Override
    public double danio(Agentes agente) {
        double trudmg = 0;

        if (agente instanceof Tierra) {
            trudmg = getDMG() * 1.1;
        } else if (agente instanceof Agua) {
            trudmg = getDMG() * 0.7;
        } else if (agente instanceof Fuego) {
            trudmg = getDMG() * 1.5;
        } else if (agente instanceof Viento) {
            trudmg = 0;
        }

        return trudmg;
    }

    @Override
    public String toString() {
        return "Viento: " + super.toString();
    }
    
    

}
