package lab4p2_andreflores_gerardohasbum;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Lab4P2_AndreFlores_GerardoHasbum {

    static Scanner entrada = new Scanner(System.in);
    static Random ran = new Random();

    public static void main(String[] args) {
        int inicioSesion = 1;
        ArrayList<Usuarios> usuarios = new ArrayList();
        usuarios.add(new Usuarios("Andre", "andreflor@gmail.com", "pass123", 3000, "Andre", 18));
        //agentes andre
        usuarios.get(0).agentes.add(new Fuego(150.5, 100, 30, "Pyro", 21));
        usuarios.get(0).agentes.add(new Agua(150.5, 125, 20, "Squirt", 32));
        usuarios.get(0).agentes.add(new Viento(150.5, 75, 40, "Ankh", 10));
        //fin agentes andre
        usuarios.add(new Usuarios("Gerardo", "gerardoH@gmail.com", "clave123", 3000, "Gerardo", 18));
        //agentes gerardo
        usuarios.get(1).agentes.add(new Fuego(150.5, 100, 30, "Pyro", 21));
        usuarios.get(1).agentes.add(new Agua(150.5, 125, 20, "Squirt", 32));
        usuarios.get(1).agentes.add(new Viento(150.5, 75, 40, "Ankh", 10));
        //fin agentes gerardo
        usuarios.add(new Usuarios("Jack", "jack@gmail.com", "jack123", 3000, "Jack", 18));
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
            entrada.nextLine();
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

                        int random = ran.nextInt(usuarios.size());
                        while (random == pos) {
                            random = ran.nextInt(usuarios.size());
                        }

                        Usuarios temp1 = usuarios.get(pos);
                        Usuarios temp2 = usuarios.get(random);

                        System.out.println(temp1.getUsuario() + " VS. " + temp2.getUsuario());
                        boolean pierde = false;
                        while (pierde == false) {

                            //comienza el combate
                            PrintA(temp1.agentes);//eleccion de atacante aliado
                            System.out.println("Eliga el agente con el que quiere atacar: ");
                            int opcion1 = entrada.nextInt();
                            while (opcion1 < 0 || opcion1 > temp1.agentes.size()) {
                                System.out.println("Esa posicion no contiene un agente porfavor elegir una opcion valida");
                                PrintA(temp1.agentes);
                                opcion1 = entrada.nextInt();
                            }
                            int opcion2 = ran.nextInt(temp2.agentes.size());//eleccion de atacante enemigo
                            Agentes tempA1 = temp1.agentes.get(opcion1);
                            //ataque aliado
                            PrintA(temp2.agentes);
                            System.out.println("Eliga el enemigo que le gustaria atacar: ");
                            int ataque1 = entrada.nextInt();
                            while (ataque1 < 0 || ataque1 > temp2.agentes.size()) {
                                System.out.println("Esa posicion no contiene un agente porfavor elegir una opcion valida");
                                PrintA(temp2.agentes);
                                ataque1 = entrada.nextInt();
                            }
                            Agentes victima1 = temp2.agentes.get(ataque1);
                            double dmg = tempA1.danio(victima1);
                            victima1.setVida(victima1.getVida() - dmg);
                            if (victima1.getVida() < 0) {
                                victima1.setVida(0);
                            }
                            temp2.agentes.remove(ataque1);
                            temp2.agentes.add(ataque1, victima1);
                            int cont = 0;
                            for (int i = 0; i < temp2.agentes.size(); i++) {//validacion si ha ganado el aliado
                                
                                if (temp2.agentes.get(i).getVida()>0) {
                                    cont++;
                                }
                                
                            }
                            if (cont == 0) {
                                
                            }
                            //fin ataque aliado
                            Agentes tempA2 = temp2.agentes.get(opcion2);
                            //ataque enemigo

                        }

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
