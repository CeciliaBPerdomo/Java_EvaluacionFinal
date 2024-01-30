package Evaluacion;

import java.util.Scanner;

public class Empresa {
    public String nombre;
    public int edad;
    public String puesto;
    public int salario;

    public Empleado[] empleados = new Empleado[5];
    public int cantidadEmpleados = 0;
    public Empresas empresas = new Empresas();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empresa empresa = new Empresa();

        int opcion;
        do {
            System.out.println("Menú Principal:");
            System.out.println("1. Agregar un nuevo empleado");
            System.out.println("2. Mostrar información de empleados");
            System.out.println("3. Salir del programa");
            System.out.print("Ingrese su opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                sc.next();
            }

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del empleado: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese la edad del empleado: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Por favor, ingrese una edad válida.");
                        sc.next();
                    }
                    int edad = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Ingrese el puesto del empleado: ");
                    String puesto = sc.nextLine();

                    System.out.print("Ingrese el salario del empleado: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Por favor, ingrese un salario válido.");
                        sc.next();
                    }
                    int salario = sc.nextInt();
                    sc.nextLine();

                    // Validación de entrada
                    if (edad < 0 || salario < 0) {
                        System.out.println("Por favor, ingrese datos válidos.");
                    } else {
                        Empleado nuevoEmpleado = new Empleado(nombre, edad, puesto, salario);
                        empresa.empresas.agregarEmpleado(nuevoEmpleado);
                    }
                    break;

                case 2:
                    empresa.empresas.mostrarInformacionEmpleados();
                    break;

                case 3:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (opcion != 3);

        sc.close();
    }

    // Clase Empleado
    class Empleado extends Persona {
        public String puesto;
        public int salario;

        public Empleado(String empleado_nombre, int empleado_edad, String empleado_puesto, int empleado_salario) {
            super(empleado_nombre, empleado_edad);
            puesto = empleado_puesto;
            salario = empleado_salario;
        }
    }

    // Clase Persona
    class Persona {
        public String nombre;
        public int edad;

        public Persona() {
            nombre = "";
            edad = 0;
        }

        public Persona(String empleado_nombre, int empleado_edad) {
            nombre = empleado_nombre;
            edad = empleado_edad;
        }
    }

    // Clase Empresas
    class Empresas {
        private Empleado[] empleados = new Empleado[5];
        private int cantidadEmpleados = 0;

        public void agregarEmpleado(Empleado nuevoEmpleado) {
            if (cantidadEmpleados < 5) {
                empleados[cantidadEmpleados++] = nuevoEmpleado;
                System.out.println("Empleado agregado correctamente.");
            } else {
                System.out.println("No se pueden agregar más empleados. Límite alcanzado.");
            }
        }

        public void mostrarInformacionEmpleados() {
            if (cantidadEmpleados > 0) {
                System.out.println("Información de empleados:");
                for (int i = 0; i < cantidadEmpleados; i++) {
                    System.out.println("Nombre: " + empleados[i].nombre);
                    System.out.println("Edad: " + empleados[i].edad);
                    System.out.println("Puesto: " + empleados[i].puesto);
                    System.out.println("Salario: " + empleados[i].salario);
                    System.out.println("------------------------");
                }
            } else {
                System.out.println("No hay empleados en la empresa.");
            }
        }
    }
}

/* 
Descripción del Problema:
Crear una aplicación simple de gestión de empleados en Java. 
Cada empleado debe tener la siguiente información:

Nombre
Edad
Puesto
Salario


Luego crear una clase llamada Empleado que hereda de persona y además tiene los atributos públicos puesto y salario

Clase Empresa:
Crear una clase llamada Empresa que contenga un arreglo de empleados con capacidad para 5 empleados.
Implementar un método para agregar un nuevo empleado al arreglo.
Implementar un método para mostrar la información de todos los empleados de la empresa.

Menú Principal:
Crear un programa principal que simule un menú de opciones para el usuario:
Opción 1: Agregar un nuevo empleado.
Opción 2: Mostrar la información de todos los empleados.
Opción 3: Salir del programa.
Validación de Entrada:
Validar la entrada del usuario para asegurar que se ingresen datos válidos (por ejemplo, no permitir edades negativas o salarios negativos).
*/ 