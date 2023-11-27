
package skynet;

import java.util.ArrayList;
import java.util.List;

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
     * @param origen
     * @param destino
     * @param ejercito
     * @param bienes
     * @param distancia
     */
    public void nuevaAdyacencia(Ciudad origen,Ciudad destino,int ejercito, int bienes, int distancia){
        if (!esAdyacente(destino)){
            Camino nodo = new Camino(origen,destino ,ejercito, bienes, distancia);
            insertar(nodo,destino);
        }
    } 
    
    public void nuevaAdyacencia(Ciudad Origen,Ciudad destino){
        if (!esAdyacente(destino)){
            Camino nodo = new Camino(destino);
            insertar(nodo,destino);
        }
    } 
    
    public void insertar(Camino nodo, Ciudad destino){
        if(listaVacia()){
            primero=ultimo=nodo;
        }else{
            if(nodo.bienes<=primero.bienes){ //metodo de ordenamiento(PODEMOS REMPLAZAR)
                nodo.siguiente=primero;
                primero=nodo;
            }else{
                if(nodo.bienes>=ultimo.bienes){
                    ultimo.siguiente= nodo;
                    ultimo=nodo;
                } else{
                    Camino posicion= primero;
                    while(nodo.bienes<=posicion.bienes){
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
    public void eliminarAdyacencia(Ciudad destino) {
        if (listaVacia()) {
            return;
        }

        if (primero.destino.comparar(destino)) {
            primero = primero.siguiente;
            if (primero == null) {
                ultimo = null;
            }
            return;
        }

        Camino actual = primero;
        while (actual.siguiente != null && !actual.siguiente.destino.comparar(destino)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            if (actual.siguiente == null) {
                ultimo = actual;
            }
        }
    }
    
    public List<Ciudad> obtenerVecinos(){
        List<Ciudad> listaVecinos= new ArrayList<>();
        Camino temp=primero;
        while(temp!=null){
            listaVecinos.add(temp.destino);
            temp=temp.siguiente;
        }
        return listaVecinos;
    }
    
    public int totalAdyacencias(){
        Camino temp= primero;
        int total=0;
        while(temp!=null){
            total++;
            temp=temp.siguiente;
        }
        return total;
    }
    
    
    @Override
    public String toString(){
        String cadena="";
        Camino temporal= primero;
        while (temporal !=null){
            cadena=cadena+temporal.destino.getNombre()+" ; ";
            temporal = temporal.siguiente;
        }
        return cadena;
    }
    
    
    
    public void agragarCaminosVuelta(Ciudad ciudad){
        Camino temp=primero;
        while(temp!=null){
            temp.destino.nodo.lista.nuevaAdyacencia(temp.destino,ciudad, temp.ejercito, temp.bienes, temp.distancia);
            temp=temp.siguiente;
        }
    }
    
    
    
}
