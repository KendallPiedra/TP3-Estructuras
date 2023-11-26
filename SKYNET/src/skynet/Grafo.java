/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skynet;

import java.util.HashSet;
import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class Grafo {
    private NodoGrafo primero;
    private NodoGrafo ultimo;
    
    public Grafo(){
        primero=ultimo=null;
    }
    public boolean estaVacio(){
        return primero==null;
    }
    public boolean existeVertice(Ciudad dato){
        if(!estaVacio()){
            NodoGrafo temporal=primero;
            while(temporal!=null){
                if(temporal.dato.nombre.equals(dato.nombre)){
                    return true;
                }
                temporal=temporal.siguiente;
            }
        }
        return false;
    }
    
    public void annadirNuevaArista(Ciudad origen, Ciudad destino, int ejercito, int bienes, int distancia){
        if(existeVertice(origen)&&existeVertice(destino)){
            NodoGrafo posicion=primero;
            while(!posicion.dato.nombre.equals(origen.nombre)){
                posicion=posicion.siguiente;
            }
            posicion.lista.nuevaAdyacencia(destino, ejercito, bienes, distancia);
        }
    }
    
    public void annadirNuevaArista(Ciudad origen, Ciudad destino){//simple y sencillamente no tiene peso
        if(existeVertice(origen)&&existeVertice(destino)){
            NodoGrafo posicion=primero;
            while(!posicion.dato.nombre.equals(origen.nombre)){
                posicion=posicion.siguiente;
            }
            posicion.lista.nuevaAdyacencia(destino);
        }
    }
    
    public void crearNuevoNodo(Ciudad dato){
        if(!existeVertice(dato)){
            NodoGrafo nodo=new NodoGrafo(dato);
                if (estaVacio()){
                    primero=nodo;
                    ultimo=nodo;
                }else{
                    if(dato.nombre.compareTo(primero.dato.nombre)<=0){
                        nodo.siguiente=primero;
                        primero=nodo;
                    }else{
                        if(dato.nombre.compareTo(ultimo.dato.getNombre())>=0){
                            ultimo.siguiente = nodo;
                            ultimo = nodo;
                        }else{
                            NodoGrafo temporal=primero;
                            while(dato.getNombre().compareTo(temporal.dato.getNombre())<=0){
                                temporal = temporal.siguiente;
                            }
                            nodo.siguiente=temporal.siguiente;
                            temporal.siguiente=nodo;
                        }
                    }
                
            }
        }
    }
   //============================================================================ 

    public boolean esConexo() {
        if (estaVacio()) {
            // Grafo vacío, considerado conexo por definición.
            return true;
        }

        HashSet<Ciudad> visitados = new HashSet<>();
        Stack<NodoGrafo> stack = new Stack<>();

        // Empezamos desde el primer nodo del grafo
        stack.push(primero);

        while (!stack.isEmpty()) {
            NodoGrafo actual = stack.pop();
            if (!visitados.contains(actual.dato)) {
                visitados.add(actual.dato);
                // Agregar todos los vecinos no visitados a la pila
                for (Ciudad vecino : actual.lista.obtenerVecinos()) {
                    NodoGrafo vecinoNodo = obtenerNodoPorCiudad(vecino);
                    if (!visitados.contains(vecino) && vecinoNodo != null) {
                        stack.push(vecinoNodo);
                    }
                }
            }
        }

        // El grafo es conexo si todos los vértices fueron visitados
        return visitados.size() == obtenerNumeroVertices();
    }

    private NodoGrafo obtenerNodoPorCiudad(Ciudad ciudad) {
        NodoGrafo temporal = primero;
        while (temporal != null) {
            if (temporal.dato.equals(ciudad)) {
                return temporal;
            }
            temporal = temporal.siguiente;
        }
        return null;
    }

    private int obtenerNumeroVertices() {
        int contador = 0;
        NodoGrafo temporal = primero;
        while (temporal != null) {
            contador++;
            temporal = temporal.siguiente;
        }
        return contador;
    }
    
    
    
    
    
   //============================================================================    
    @Override
    public String toString(){
        String cadena="";
        NodoGrafo temporal= primero;
        while(temporal!=null){
            cadena = cadena + temporal.dato.getNombre()+" -> "+temporal.lista.toString()+"\n";
            temporal=temporal.siguiente;
        }
        return cadena;
    }
     
}
