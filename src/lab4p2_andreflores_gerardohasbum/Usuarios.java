package lab4p2_andreflores_gerardohasbum;

import java.util.ArrayList;

public class Usuarios extends Personas{

    private String usuario, correo, password;
    double dinero;
    ArrayList<Agentes> agentes = new ArrayList();

    public Usuarios() {
    }

    public Usuarios(String usuario, String correo, String password, double dinero, String nombre, int edad) {
        super(nombre, edad);
        this.usuario = usuario;
        this.correo = correo;
        this.password = password;
        this.dinero = dinero;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "usuario=" + usuario + ", correo=" + correo + ", password=" + password + ", dinero=" + dinero + ", agentes=" + agentes + '}';
    }
    
    
}
