
package skynet;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class Grafo {
    public NodoGrafo primero;
    public NodoGrafo ultimo;
    
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
            posicion.lista.nuevaAdyacencia(origen,destino, ejercito, bienes, distancia);
        }
    }
    
    public void annadirNuevaArista(Ciudad origen, Ciudad destino){//simple y sencillamente no tiene peso
        if(existeVertice(origen)&&existeVertice(destino)){
            NodoGrafo posicion=primero;
            while(!posicion.dato.nombre.equals(origen.nombre)){
                posicion=posicion.siguiente;
            }
            posicion.lista.nuevaAdyacencia(origen,destino);
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

    public NodoGrafo obtenerNodoPorCiudad(Ciudad ciudad) {
        NodoGrafo temporal = primero;
        while (temporal != null) {
            if (temporal.dato.equals(ciudad)) {
                return temporal;
            }
            temporal = temporal.siguiente;
        }
        return null;
    }

    public int obtenerNumeroVertices() {
        int contador = 0;
        NodoGrafo temporal = primero;
        while (temporal != null) {
            contador++;
            temporal = temporal.siguiente;
        }
        return contador;
    }
    
    public String encontrarCiudadConMasCaminos(){
        NodoGrafo temp =primero;
        int maxCaminos=0;
        String camino="NO HAY CAMINO";
        while (temp!=null){
            if (temp.totalCaminos()>maxCaminos){
                maxCaminos=temp.totalCaminos();
                camino= temp.dato.nombre;
            }
            temp=temp.siguiente;
        }
        return camino;
    }
    
    
    
    public List<Camino> extraerTodosLosCaminos(){
        List<Camino> listaCaminos=new ArrayList<>();
        NodoGrafo temp=primero;
        while(temp!=null){
            Camino caminoTemp=temp.lista.primero;
            while(caminoTemp!=null){
                listaCaminos.add(caminoTemp);
                caminoTemp= caminoTemp.siguiente;
            }
            temp=temp.siguiente;
        }
        return listaCaminos;
    }
    
   //============================================================================    
    public void limpiarRegistroVisita(){
        NodoGrafo temp=primero;
        while (temp!=null){
            temp.devisitar();
            temp=temp.siguiente;
        }
    }
    
    
    public void generarCaminosVuelta(){
        NodoGrafo temp= primero;
        while(temp!=null){
            temp.agregarCaminosVuelta();
            temp=temp.siguiente;
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
