package lab4p2_andreflores_gerardohasbum;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Lab4P2_AndreFlores_GerardoHasbum {

    public static void main(String[] args) {

        ArrayList<Usuarios> usuarios = new ArrayList();
        usuarios.add(new Usuarios("andre", "andreflor@gmail.com", "pass123", 3000, "andre", 18));
        usuarios.add(new Usuarios("gerardo", "gerardoH@gmail.com", "clave123", 3000, "gerardo", 18));
        usuarios.add(new Usuarios("jack", "jack@gmail.com", "jack123", 3000, "jack", 18));
        int inicioSesion;

    }

    private static Usuarios iniciarSesion(ArrayList<Usuarios> usuarios, Scanner entrada) {
        System.out.println("Inicio de sesion:");
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = entrada.nextLine();
        nombreUsuario = entrada.nextLine();
        System.out.print("Contrasenia: ");
        String contrasenia = entrada.nextLine();

        for (Usuarios usuario : usuarios) {
            if (usuario.getUsuario().equals(nombreUsuario) && usuario.getPassword().equals(contrasenia)) {
                return usuario;
            }
        }
        return null;
    }

}
