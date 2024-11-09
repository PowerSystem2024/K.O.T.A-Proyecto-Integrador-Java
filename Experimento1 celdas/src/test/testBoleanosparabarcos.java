/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author Mkjdf983
 */
public class testBoleanosparabarcos {
        public static void main(String[] args) {
        Barco destructor = new Barco("Destructor", 3);

        // Destruir la posición 2
        destructor.destruir(1);

        // Mostrar el estado del barco
        destructor.mostrarEstado();
    }
}

class Barco {
    private String nombre;
    private int tamaño;
    private boolean[] destruido;

    public Barco(String nombre, int tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.destruido = new boolean[tamaño];
    }

    public void destruir(int posicion) {
        if (posicion >= 0 && posicion < tamaño) {
            destruido[posicion] = true;
        }
    }

    public void mostrarEstado() {
        for (int i = 0; i < tamaño; i++) {
            if (destruido[i]) {
                System.out.print("X "); // Representa que está destruido
            } else {
                System.out.print("O "); // Representa que no está destruido
            }
        }
        System.out.println();
    }

    // Getters y setters según sea necesario
}