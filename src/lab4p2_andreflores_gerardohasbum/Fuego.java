package lab4p2_andreflores_gerardohasbum;

public class Fuego extends Agentes {

    public Fuego(double precio, int vida, double DMG, String nombre, int edad) {
        super(precio, vida, DMG, nombre, edad);
    }

    @Override
    public String toString() {
        return "Fuego: " + super.toString();
    }

    @Override
    public double danio(Agentes agente) {
        double trudmg = 0;

        if (agente instanceof Fuego) {
            trudmg = getDMG() * 0;
        } else if (agente instanceof Tierra) {
            trudmg = getDMG();
        } else if (agente instanceof Viento) {
            trudmg = getDMG() * 0.5;
        } else if (agente instanceof Agua) {
            trudmg = getDMG() * 0.85;
        }

        return trudmg;
    }

}
