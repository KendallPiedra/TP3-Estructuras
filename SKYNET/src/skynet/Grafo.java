
package skynet;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
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
    
    public int contarConexionesEnGrafoDirigido(NodoGrafo nodo){
        int cantCaminos=0;
        List<Camino> caminos=extraerTodosLosCaminos();
            for(Camino camino:caminos){
                if(camino.origen.nombre.equals(nodo.dato.nombre) || camino.destino.nombre.equals(nodo.dato.nombre) ){
                    cantCaminos++;
                }
            }
        return cantCaminos;
    }
    
    public boolean tieneParejasDeCaminos(NodoGrafo nodo){
        int cantCaminosEntrada=0;
        int cantCaminosSalida=0;
        List<Camino> caminos=extraerTodosLosCaminos();
            for(Camino camino:caminos){
                if(camino.origen.nombre.equals(nodo.dato.nombre) ){
                    cantCaminosSalida++;
                }
                if(camino.destino.nombre.equals(nodo.dato.nombre)){
                    cantCaminosEntrada++;
                }
            }
        return cantCaminosEntrada==cantCaminosSalida;
    }
    
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
    public String encontrarCiudadConMenosCaminos(){
        NodoGrafo temp =primero;
        int minCaminos=10000;
        String camino="NO HAY CAMINO";
        while (temp!=null){
            if (temp.totalCaminos()<minCaminos){
                minCaminos=temp.totalCaminos();
                camino= temp.dato.nombre;
            }
            temp=temp.siguiente;
        }
        return camino;
    }
    
    
    public Ciudad retornarCiudadConMasCaminos(){
        NodoGrafo temp =primero;
        int maxCaminos=0;
        Ciudad camino=temp.dato;
        while (temp!=null){
            if (temp.totalCaminos()>maxCaminos){
                maxCaminos=temp.totalCaminos();
                camino= temp.dato;
            }
            temp=temp.siguiente;
        }
        return camino;
    }
    public Ciudad retornarCiudadConMenosCaminos(){
        NodoGrafo temp =primero;
        int minCaminos=10000;
        Ciudad camino=temp.dato;
        while (temp!=null){
            if (temp.totalCaminos()<minCaminos){
                minCaminos=temp.totalCaminos();
                camino= temp.dato;
            }
            temp=temp.siguiente;
        }
        return camino;
    }
    
    public int sacarCantidadDeCaminosDirigidosAUnaCiudad(NodoGrafo nodo){
        return sacarListaDeCiudadesDirigidas(nodo).size();
    }
    public Ciudad retornarCiudadConMenosCaminosConExcepcion(Ciudad excepcion){
        NodoGrafo temp =primero;
        int minCaminos=10000;
        Ciudad camino=temp.dato;
        while (temp!=null){
            if (temp.totalCaminos()<minCaminos&&!temp.dato.nombre.equals(excepcion.nombre)){
                minCaminos=temp.totalCaminos();
                camino= temp.dato;
            }
            temp=temp.siguiente;
        }
        return camino;
    }
    public Ciudad retornarCiudadConMenosCaminosDirigidosAConExcepcion(Ciudad excepcion){
        NodoGrafo temp =primero;
        int minCaminos=10000;
        Ciudad camino=temp.dato;
        while (temp!=null){
            if (sacarCantidadDeCaminosDirigidosAUnaCiudad(temp)<minCaminos&&!temp.dato.nombre.equals(excepcion.nombre)){
                minCaminos=sacarCantidadDeCaminosDirigidosAUnaCiudad(temp);
                camino= temp.dato;
            }
            temp=temp.siguiente;
        }
        return camino;
    }
    
    public void eliminarCamino(Camino camino){
        NodoGrafo temp=primero;
        while(temp.dato!=camino.origen){
            temp=temp.siguiente;
        }
        temp.lista.eliminarAdyacencia(camino.destino);
    }

    public boolean esEuleriano() {
        NodoGrafo tmp = primero;
        int impar = 0;

        while (tmp != null) {
            int conexiones = contarConexionesEnGrafoDirigido(tmp);
            if (conexiones % 2 != 0) {
                impar++;
                if (impar > 2 || !tieneParejasDeCaminos(tmp)) {
                    return false;
                }
            }
            tmp = tmp.siguiente;
        }

        return true;
    }

   //============================================================================    
    public void limpiarRegistroVisita(){
        NodoGrafo temp=primero;
        while (temp!=null){
            temp.devisitar();
            temp=temp.siguiente;
        }
    }
    
    /**
     *  Saca las ciudades que se dirigen a la ciudad puesta como parametro
     * @param nodo
     * @return 
     */
    public List<Ciudad> sacarListaDeCiudadesDirigidas(NodoGrafo nodo){
        List<Ciudad>listaCiudades=new ArrayList<>();
        NodoGrafo temp= primero;
        while(temp!=null){
            Camino tempCamino=temp.lista.primero;
            while(tempCamino!=null){
                if(tempCamino.destino.nombre.equals(nodo.dato.nombre)){
                    listaCiudades.add(temp.dato);
                    break;
                }
                tempCamino=tempCamino.siguiente;
            }
            temp=temp.siguiente;
        }
        return listaCiudades;
    }
    
    public boolean esDirigidoA(NodoGrafo nodo1, NodoGrafo nodo2){
        List<Ciudad> listaCiudades=sacarListaDeCiudadesDirigidas(nodo2);
        for(Ciudad ciudad:listaCiudades){
            if(nodo1.dato.nombre.equals(ciudad.nombre)){
                return true;
            }
        }
        return false;
    }
    
    public void conectarGrafoDirigido(){
        
        NodoGrafo temp=primero; 
        while(temp!=null){
            if(temp.lista.listaVacia()){
                NodoGrafo temporalIncertar=retornarCiudadConMasCaminos().nodo;
                while(esDirigidoA(temporalIncertar,temp)){
                    temporalIncertar=temporalIncertar.siguiente;
                    
                    if(temporalIncertar==null){
                        temporalIncertar=primero;
                    }  
                }
                temp.lista.nuevaAdyacencia(temp.dato, temporalIncertar.dato);
            }
            temp=temp.siguiente;
        }
        System.out.println(toString());
    }
    public void conectarGrafoDirigidoFuncional(){
        System.out.println(toString());
        System.out.println("===================================================");

        NodoGrafo temp=primero; 
        while(temp!=null){
            if(temp.lista.listaVacia()){
                System.out.println(temp.dato.nombre);
                temp.lista.nuevaAdyacencia(temp.dato, retornarCiudadConMenosCaminosDirigidosAConExcepcion(temp.dato).nodo.dato);
            }
            temp=temp.siguiente;
        }
        System.out.println("TERMINO DE AÑADIR");
        System.out.println(toString());
    }
    
    
    public void generarCaminosVuelta(){
        NodoGrafo temp= primero;
        while(temp!=null){
            temp.agregarCaminosVuelta();
            temp=temp.siguiente;
        }
    }
    
    public Camino encontrarCaminoNoVisitado(NodoGrafo nodo){
        Camino camino=nodo.lista.primero;
        while(camino!=null){
            if(!camino.isVisitado()){
                return camino;
            }
            camino=camino.siguiente;
        }
        return null;
    }
    
    public List<Ciudad> obtenerCaminoEuleriano() {
        List<Ciudad> caminos = new ArrayList<>();
        if (!esEuleriano()) {
            return caminos;
        }
        Stack<Ciudad> pila = new Stack<>();
        Ciudad inicio = primero.dato; 
        pila.push(inicio);
        while(!pila.isEmpty()){
            Ciudad actual = pila.peek();

            if (encontrarCaminoNoVisitado(actual.nodo)!=null) {
                Camino camino = encontrarCaminoNoVisitado(actual.nodo);
                camino.setVisitado(true);
                Ciudad siguiente=camino.destino;
                pila.push(siguiente);
            } else {
                pila.pop();
                caminos.add(actual);
            }
        }
        Collections.reverse(caminos);
        return caminos;
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
