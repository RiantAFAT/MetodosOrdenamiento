import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;

import Metodos.*;

/*Realizado por: Andres Felipe Aristizabal Torres - Edison Hoover Largo
    Menu principal que permite elegir el metodo a utilizar y posteriormente imprimir los resultados de los tiempos de ejecucion en un grafico de barras.
    Los metodos tomados de otros repositorios tiene pequeñas variaciones con respecto a los originales
    dado que estaban diseñados para funcionar autonomamente.
 */

public class GraficoOrdenamiento extends JFrame{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        long[] data= new long[7];
        int arreglo[]= new int[1000000];

        int opc= 3444;
        while(opc != 0) {
            llenarArreglo(arreglo);
            System.out.println("Ingrese el numero correspondiente al metodo por el cual desea ordenar el arreglo: \n"+
                                "1.) TimSort.\n"+
                                "2.) CombSort\n"+
                                "3.) TreeSort\n"+
                                "4.) PigeonHoleSort\n"+
                                "5.) HeapSort\n"+
                                "6.) BitonicSort\n"+
                                "7.) GnomeSort\n"+
                                "0.) Salir.\n"+
                                "9.) Grafico de barras(Una vez se ejecuten todos los metodos)\n");
            opc = scanner.nextInt();

            /*String z="";
            for (int elemento : arreglo) {
                z= z + elemento + "\t" ;

            }
            System.out.println("Arreglo sin ordenar:\n");
            System.out.println(z + "\n");*/
            long startTime = 0, endTime = 0, executionTime= 0;
            switch (opc) {
                case 1:
                    TimSort timsort;
                    timsort = new TimSort();
                    startTime = System.currentTimeMillis();
                    timsort.timSort(arreglo, arreglo.length);
                    endTime = System.currentTimeMillis();
                    executionTime = endTime - startTime;
                    System.out.println("El tiempo de ejecución de TimSort fue de: " + executionTime + " milisegundos");
                    data[0] = executionTime;
                    break;
                case 2:
                    CombSort combsort;
                    combsort = new CombSort();
                    startTime = System.currentTimeMillis();
                    combsort.combSort(arreglo);
                    endTime = System.currentTimeMillis();
                    executionTime = endTime - startTime;
                    System.out.println("El tiempo de ejecución de CombSort fue de: " + executionTime + " milisegundos");
                    data[1] = executionTime;
                    break;
                case 3:
                    TreeSort treesort;
                    treesort = new TreeSort();
                    startTime = System.currentTimeMillis();
                    treesort.treeins(arreglo);
                    System.out.println("Arreglo ordenado:\n");
                    treesort.inorderRec(treesort.root);
                    System.out.println("\n");
                    endTime = System.currentTimeMillis();
                    executionTime = endTime - startTime;
                    System.out.println("El tiempo de ejecución de TreeSort fue de: " + executionTime + " milisegundos\n");
                    data[2] = executionTime;
                    break;

                case 4:
                    PigeonholeSort pigeonholeSort;
                    pigeonholeSort = new PigeonholeSort();
                    startTime = System.currentTimeMillis();
                    pigeonholeSort.pigeonhole_sort(arreglo,arreglo.length);
                    endTime = System.currentTimeMillis();
                    executionTime = endTime - startTime;
                    System.out.println("El tiempo de ejecución de PigeonHoleSort fue de: " + executionTime + " milisegundos");
                    data[3] = executionTime;
                    break;
                case 5:
                    HeapSort heapSort;
                    heapSort = new HeapSort();
                    startTime = System.currentTimeMillis();
                    heapSort.sort(arreglo);
                    endTime = System.currentTimeMillis();
                    executionTime = endTime - startTime;
                    System.out.println("El tiempo de ejecución de HeapSort fue de: " + executionTime + " milisegundos");
                    data[4] = executionTime;
                    break;
                case 6:
                    int up = 1;
                    BitonicSort bitonicSort;
                    bitonicSort = new BitonicSort();
                    startTime = System.currentTimeMillis();
                    bitonicSort.sort(arreglo, arreglo.length, up);
                    endTime = System.currentTimeMillis();
                    executionTime = endTime - startTime;
                    System.out.println("El tiempo de ejecución de BitonicSort fue de: " + executionTime + " milisegundos");
                    data[5] = executionTime;
                    break;
                case 7:
                    GnomeSort gnomeSort;
                    gnomeSort = new GnomeSort();
                    startTime = System.currentTimeMillis();
                    gnomeSort.gnomeSort(arreglo);
                    endTime = System.currentTimeMillis();
                    executionTime = endTime - startTime;
                    System.out.println("El tiempo de ejecución de GnomeSort fue de: " + executionTime + " milisegundos");
                    data[6] = executionTime;
                    break;

                case 9: //Grafico de barras
                    SwingUtilities.invokeLater(() -> new GraficoOrdenamiento("Grafico de Barras con Datos Long", data));

            }
            /*if(opc != 0 && opc != 3 && opc != 9){
                //imprimir arreglo de prueba ordenado
                String t="";
                for (int elemento : arreglo) {
                    t= t + elemento + "\t" ;

                }
                System.out.println("Arreglo ordenado:\n");
                System.out.println(t);
            }*/
        }
        scanner.close();

    }
    public static void llenarArreglo(int arreglo[]){
        // Crear un objeto Random
        Random random = new Random();

        // Definir el rango (por ejemplo, de 1 a 100)
        int min = 10000000;
        int max = 99999999;

        // Generar un número aleatorio dentro del rango
        int randomNumber = random.nextInt(max - min + 1) + min;
        for(int i = 0; i < arreglo.length; i++){
            arreglo[i]= random.nextInt(max - min + 1) + min;
        }
    }

    public GraficoOrdenamiento(String title, long[] data) {
        super(title);

        // Configurar el panel del gráfico
        BarChartPanel panel = new BarChartPanel(data);
        panel.setPreferredSize(new Dimension(800, 600));
        add(panel);

        // Configuración básica de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }



    
    
}
