/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.Scanner;

public class NewMain {

    private static void dijkstra(int[][] matrizAdyacente){
    
        int v = matrizAdyacente.length;
        boolean visitado[] = new boolean[v];
        int distancia[] = new int[v];
        distancia[0] = 0;
        
        for (int i = 1; i < v; i++ ){
        
            distancia[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < v-1; i++){
            
            //encontrar el vertice con la distancia minima
            int verticeMin = encontrarVerticeMin( distancia, visitado);
            visitado[verticeMin]=true;
            //explorar los vecinos
            for (int j = 0; j < v; j++){
            
                if(matrizAdyacente[verticeMin][j] != 0 && !visitado[j] && distancia[verticeMin] != Integer.MAX_VALUE){
                
                    int distanciaNueva = distancia[verticeMin]+matrizAdyacente[verticeMin][j];
                    
                    if ( distanciaNueva < distancia[j]){
                    
                        distancia[j] = distanciaNueva;
                    }
                }
            }
        }
        
        //IMPRIMIR
        for ( int i = 0; i < v; i++){
        
            System.out.println(i+"--"+distancia[i]);
        }
    }
    
    
    private static int encontrarVerticeMin(int[] distancia, boolean visitado[]){
    
        int verticeMin = -1;
        
        for (int i =0; i < distancia.length; i++){
        
            if(!visitado[i] && (verticeMin == -1 || distancia[i] < distancia[verticeMin] )){
            
                verticeMin = i;
            }
        }
        return verticeMin;
    }
    
    public static void main(String[] args) {
       
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        int e = s.nextInt();
        int matrizAdyacente[][] = new int[v][v];
        
        for (int i = 0; i < e; i++){
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int distancia = s.nextInt();
            matrizAdyacente[v1][v2] = distancia;
            matrizAdyacente[v2][v1] = distancia;
        }
        dijkstra(matrizAdyacente);
    }
}
