package lab4p2_andreflores_gerardohasbum;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Lab4P2_AndreFlores_GerardoHasbum {

    static Scanner entrada = new Scanner(System.in);
    static Random ran = new Random();

    public static void main(String[] args) {
        int inicioSesion = 1;
        ArrayList<Agentes> agentes = new ArrayList();
        agentes.add(new Fuego(150.5, 100, 30, "Pyro", 21));
        agentes.add(new Fuego(150.5, 100, 30, "Flaminhot", 87));
        agentes.add(new Fuego(150.5, 100, 30, "Cheto", 102));
        agentes.add(new Agua(150.5, 125, 20, "Cascada", 67));
        agentes.add(new Agua(150.5, 125, 20, "Squirt", 32));
        agentes.add(new Agua(150.5, 125, 20, "lluvia", 32));
        agentes.add(new Viento(150.5, 75, 40, "soplon", 123));
        agentes.add(new Viento(150.5, 75, 40, "ventorral", 10));
        agentes.add(new Viento(150.5, 75, 40, "Ankh", 10));
        agentes.add(new Tierra(150.5, 80, 50, "lodo", 45));
        agentes.add(new Tierra(150.5, 80, 50, "selva", 12));
        agentes.add(new Tierra(5, 80, 50, "primo", 6));

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
                if (principal.getUsuario().equals("Andre")) {
                    pos = 0;
                } else if (principal.getUsuario().equals("Gerardo")) {
                    pos = 1;
                } else if (principal.getUsuario().equals("Jack")) {
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
                            System.out.println("*****TURNO DE " + usuarios.get(pos).getUsuario() + "*****");
                            PrintA(temp1.agentes);//eleccion de atacante aliado
                            System.out.println("Eliga el agente con el que quiere atacar: ");
                            int opcion1 = entrada.nextInt();
                            while (opcion1 < 0 || opcion1 > temp1.agentes.size() - 1) {
                                System.out.println("Esa posicion no contiene un agente porfavor elegir una opcion valida");
                                PrintA(temp1.agentes);
                                opcion1 = entrada.nextInt();
                            }
                            while (temp1.agentes.get(opcion1).getVida() == 0) {
                                System.out.println("Ese agente esta KO'd favor elegir otro");
                                PrintA(temp1.agentes);
                                opcion1 = entrada.nextInt();
                            }
                            int opcion2 = ran.nextInt(temp2.agentes.size());//eleccion de atacante enemigo
                            Agentes tempA1 = temp1.agentes.get(opcion1);
                            //ataque aliado
                            PrintA(temp2.agentes);
                            System.out.println("Eliga el enemigo que le gustaria atacar: ");
                            int ataque1 = entrada.nextInt();
                            while (ataque1 < 0 || ataque1 > temp2.agentes.size() - 1) {
                                System.out.println("Esa posicion no contiene un agente porfavor elegir una opcion valida");
                                PrintA(temp2.agentes);
                                ataque1 = entrada.nextInt();
                            }
                            Agentes victima1 = temp2.agentes.get(ataque1);
                            int hitormiss = ran.nextInt(8);
                            if (hitormiss == 7) {
                                System.out.println("Fallaste :c");
                            } else {
                                double dmg = tempA1.danio(victima1);
                                victima1.setVida(victima1.getVida() - dmg);
                                if (victima1.getVida() < 0) {
                                    victima1.setVida(0);
                                }
                                temp2.agentes.remove(ataque1);
                                temp2.agentes.add(ataque1, victima1);
                                int cont = 0;
                                for (int i = 0; i < temp2.agentes.size(); i++) {//validacion si ha ganado el aliado

                                    if (temp2.agentes.get(i).getVida() > 0) {
                                        cont++;
                                    }

                                }
                                if (cont == 0) {//preparacion para la siguiente ronda y validacion de gane
                                    System.out.println(temp1.getUsuario() + " ha ganado!");
                                    break;
                                }
                            }
                            //fin ataque aliado
                            //comienza el combate enemigo

                            System.out.println("*****TURNO DE " + temp2.getUsuario() + "*****");
                            System.out.println("Eliga el agente con quien quiere atacar: ");
                            PrintA(temp2.agentes);
                            int opcionE = ran.nextInt(temp2.agentes.size());
                            while (temp2.agentes.get(opcionE).getVida() == 0) {
                                opcionE = ran.nextInt(temp2.agentes.size());
                            }
                            System.out.println(opcionE);
                            Agentes enemigo = temp2.agentes.get(opcionE);
                            System.out.println("Eliga el agente al que quiere atacar: ");
                            PrintA(temp1.agentes);
                            int opcionA = ran.nextInt(temp1.agentes.size());
                            while (temp1.agentes.get(opcionA).getVida() == 0) {
                                opcionA = ran.nextInt(temp1.agentes.size());
                            }
                            System.out.println(opcionA);
                            hitormiss = ran.nextInt(8);
                            if (hitormiss == 7) {
                                System.out.println("Fallaste :c");
                            } else {
                                Agentes aliado = temp1.agentes.get(opcionA);
                                double dmgE = enemigo.danio(aliado);
                                aliado.setVida(aliado.getVida() - dmgE);
                                temp1.agentes.remove(opcionA);
                                temp1.agentes.add(opcionA, aliado);
                                int contE = 0;
                                for (int i = 0; i < temp1.agentes.size(); i++) {

                                    if (temp1.agentes.get(i).getVida() > 0) {
                                        contE++;
                                    }

                                }
                                if (contE == 0) {
                                    System.out.println(temp2.getUsuario() + " ha ganado!");
                                    break;
                                }
                                //ataque enemigo
                            }
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

                            PrintA(agentes);
                            System.out.println("\nusted tiene: " + principal.getDinero() + "dolares");
                            System.out.println("ingrese el indice del agente que quiere comprar");
                            int indice = entrada.nextInt();

                            if (agentes.get(indice).getPrecio() > principal.getDinero()) {
                                System.out.println("no tiene suficiente dinero.");

                            } else {
                                principal.setDinero(principal.getDinero() - agentes.get(indice).getPrecio());
                                System.out.println(principal.getUsuario() + "tiene: " + principal.getDinero() + "dolares");
                                principal.agentes.add(agentes.get(indice));
                            }

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
