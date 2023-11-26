/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skynet;

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
