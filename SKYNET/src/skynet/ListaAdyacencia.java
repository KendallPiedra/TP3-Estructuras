/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skynet;

/**
 *
 * @author Usuario
 */
public class ListaAdyacencia {//FALTA METODO DE ELIMINAR
    Camino primero;
    Camino ultimo;
    
    public ListaAdyacencia() {
        primero=ultimo=null;
    }
    
    public boolean listaVacia(){
        return primero==null;
    }
    
    /**
     * Annade una nueva adyacencia 
     * @param destino
     * @param ejercito
     * @param bienes
     * @param distancia
     */
    public void nuevaAdyacencia(Ciudad destino,int ejercito, int bienes, int distancia){
        if (!esAdyacente(destino)){
            Camino nodo = new Camino(destino, ejercito, bienes, distancia);
            insertar(nodo,destino);
        }
    } 
    
    public void nuevaAdyacencia(Ciudad destino){
        if (!esAdyacente(destino)){
            Camino nodo = new Camino(destino);
            insertar(nodo,destino);
        }
    } 
    
    public void insertar(Camino nodo, Ciudad destino){//modificar para que inserte por PESO
        if(listaVacia()){
            primero=ultimo=nodo;
        }else{
            if(destino.nombre.compareTo(primero.destino.toString())<=0){ //metodo de ordenamiento(PODEMOS REMPLAZAR)
                nodo.siguiente=primero;
                primero=nodo;
            }else{
                if(destino.nombre.compareTo(ultimo.destino.nombre)>=0){
                    ultimo.siguiente= nodo;
                    ultimo=nodo;
                } else{
                    Camino posicion= primero;
                    while(destino.nombre.compareTo(posicion.destino.nombre)<=0){
                        posicion=posicion.siguiente;
                    }
                    nodo.siguiente=posicion.siguiente;
                    posicion.siguiente=nodo;
                }
            }
        }
    }
    
    public boolean esAdyacente(Ciudad dato){
        Camino actual;
        actual= primero;
        
        while (actual!=null &&!dato.nombre.equals(actual.destino.nombre)){
            actual=actual.siguiente;
        }
        return actual!=null;
        
    }
}
