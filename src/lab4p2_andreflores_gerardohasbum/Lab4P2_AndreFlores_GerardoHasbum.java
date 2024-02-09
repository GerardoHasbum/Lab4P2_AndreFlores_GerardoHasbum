package lab4p2_andreflores_gerardohasbum;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Lab4P2_AndreFlores_GerardoHasbum {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int inicioSesion = 1;
        ArrayList<Usuarios> usuarios = new ArrayList();
        usuarios.add(new Usuarios("andre", "andreflor@gmail.com", "pass123", 3000, "andre", 18));
        //agentes andre
        usuarios.get(0).agentes.add(new Fuego(150.5, 100, 30, "Pyro", 21));
        usuarios.get(0).agentes.add(new Agua(150.5, 125, 20, "Squirt", 32));
        usuarios.get(0).agentes.add(new Viento(150.5, 75, 40, "Ankh", 10));
        //fin agentes andre
        usuarios.add(new Usuarios("gerardo", "gerardoH@gmail.com", "clave123", 3000, "gerardo", 18));
        //agentes gerardo
        usuarios.get(1).agentes.add(new Fuego(150.5, 100, 30, "Pyro", 21));
        usuarios.get(1).agentes.add(new Agua(150.5, 125, 20, "Squirt", 32));
        usuarios.get(1).agentes.add(new Viento(150.5, 75, 40, "Ankh", 10));
        //fin agentes gerardo
        usuarios.add(new Usuarios("jack", "jack@gmail.com", "jack123", 3000, "jack", 18));
        //agentes jack
        usuarios.get(2).agentes.add(new Fuego(150.5, 100, 30, "Pyro", 21));
        usuarios.get(2).agentes.add(new Agua(150.5, 125, 20, "Squirt", 32));
        usuarios.get(2).agentes.add(new Viento(150.5, 75, 40, "Ankh", 10));
        //fin agentes jack
        while (inicioSesion == 1) {//while 1
            System.out.println("Ingrese una opcion: ");
            System.out.println("1. Ingresar sesion");
            System.out.println("2. Salir");
            inicioSesion = entrada.nextInt();
            if (inicioSesion == 1) {
                int menu = 1;
                PrintA(usuarios);
                int pos = 0;
                Usuarios principal = iniciarSesion(usuarios);

                while (principal == null) {//while validacion usuario correcto

                    System.out.println("Ese usuario no existe favor intentar de nuevo");
                    principal = iniciarSesion(usuarios);

                }//fin while validacion usuario correcto
                if (principal.getUsuario().equals("andre")) {
                    pos = 0;
                } else if (principal.getUsuario().equals("gerardo")) {
                    pos = 1;
                } else if (principal.getUsuario().equals("jack")) {
                    pos = 2;
                }
                while (menu > 0 && menu < 3) {//while 2
                    System.out.println("*****MENU*****");
                    System.out.println("1. Jugar");
                    System.out.println("2. Ver Agentes");
                    System.out.println("3. Salir");
                    menu = entrada.nextInt();

                    if (menu == 1) {//comienzo jugar

                    }//fin jugar

                    if (menu == 2) {//comienzo ver agentes

                        System.out.println("*****VER AGENTES*****");
                        System.out.println("1. Ver lista");
                        System.out.println("2. Comprar agentes");
                        System.out.println("3. Salir");

                        menu = entrada.nextInt();

                        if (menu == 1) {//comienza ver lista

                            PrintA(usuarios.get(pos).agentes);

                        }//fin ver lista

                        if (menu == 2) {//comienza comprar agentes

                        }//fin comprar agentes

                    }//fin ver agentes
                }//fin while 2
            }//fin menu
        }//fin while 1
    }//fin main

    private static Usuarios iniciarSesion(ArrayList<Usuarios> usuarios) {
        System.out.println("Inicio de sesion:");
        System.out.print("Nombre de usuario: ");
        entrada.nextLine();
        String nombreUsuario = entrada.nextLine();
        System.out.print("Contrasenia: ");
        String contrasenia = entrada.nextLine();

        for (Usuarios usuario : usuarios) {
            if ((usuario.getUsuario().equals(nombreUsuario) || usuario.getCorreo().equals(nombreUsuario)) && usuario.getPassword().equals(contrasenia)) {
                return usuario;
            }
        }
        return null;
    }

    public static void PrintA(ArrayList x) {

        for (int i = 0; i < x.size(); i++) {

            System.out.println(i + ".- " + x.get(i).toString());

        }

    }

}//fin clase
