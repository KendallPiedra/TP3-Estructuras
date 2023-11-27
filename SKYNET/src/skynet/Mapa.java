
package skynet;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author Usuario
 */
public class Mapa {
    //List<Camino> caminos= new ArrayList<>();
    List<Ciudad> ciudades= new ArrayList<>();
    Grafo grafo;
    Grafo grafoExpansionMinima;

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }
    
    
    public Mapa() {
    }
/*
    public List<Camino> getCaminos() {
        return caminos;
    }

    public void setCaminos(List<Camino> caminos) {
        this.caminos = caminos;
    }
*/
    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
    
    
    public static Ciudad[] leerJSON(String nombre) {
        Gson gson = new Gson();
        String fichero = "";

        try (BufferedReader br = new BufferedReader(new FileReader(nombre))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                fichero += linea;
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error al abrir el archivo: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error de lectura del archivo: " + ex.getMessage());
        }

        return gson.fromJson(fichero, Ciudad[].class);
    }

    public void generarCiudades(String nombre) {
        Ciudad[] ciudadesArray = leerJSON(nombre);

        // Limpiar la lista de ciudades antes de agregar las nuevas
        ciudades.clear();

        // Agregar las ciudades al mapa
        for (Ciudad ciudad : ciudadesArray) {
            ciudades.add(ciudad);
        }
    }

    public Ciudad buscarCiudad(String sCiudad){
        for (Ciudad ciudad: ciudades){
            if(ciudad.nombre.equals(sCiudad)){
                return ciudad;
            }
        }
        return null;
    }

    public void generarAdyacenciasGrafo(){
        for(Ciudad ciudad: ciudades){
            for (Camino camino:ciudad.caminos){
                if (buscarCiudad(camino.ciudad2)!=null){
                    grafo.annadirNuevaArista(ciudad, 
                        buscarCiudad(camino.ciudad2), camino.ejercito, camino.bienes, camino.distancia);
                }
            }
        }
    }
    
    public void generarAristasGrafoExpansionMinima(){
        for(Ciudad ciudad: ciudades){
            for (Camino camino:ciudad.caminos){
                if (buscarCiudad(camino.ciudad2)!=null && !buscarCiudad(camino.ciudad2).visitado){
                    ciudad.visitado=true;
                    buscarCiudad(camino.ciudad2).visitado=true;
                    grafoExpansionMinima.annadirNuevaArista(ciudad, 
                        buscarCiudad(camino.ciudad2), camino.ejercito, camino.bienes, camino.distancia);
                }
            }
        }
    } 
    public void generarGrafo(){
        grafo= new Grafo();
        for(Ciudad ciudad: ciudades){
            grafo.crearNuevoNodo(ciudad);
        }
        generarAdyacenciasGrafo();
    }
    
    public void generarGrafoExpansionMinima(){
        grafoExpansionMinima= new Grafo();
        for(Ciudad ciudad: ciudades){
            grafoExpansionMinima.crearNuevoNodo(ciudad);
        }
        generarAristasGrafoExpansionMinima();
        //grafoExpansionMinima.generarCaminosVuelta();
    }
    //.cgfdñkjgfsdlkfjd{lhjdkgjsf
    
    public void generarGrafoExpansionMinimaBienes(){  
        grafoExpansionMinima= new Grafo();
        Set<Ciudad> nodosIncluidos = new HashSet<>();
        PriorityQueue<Camino> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(Camino::getBienes));
        NodoGrafo nodoInicial = grafo.primero;
        grafoExpansionMinima.crearNuevoNodo(nodoInicial.dato);
        nodosIncluidos.add(nodoInicial.dato);
        
        Camino tmp= nodoInicial.lista.primero;
        while (tmp!=null) {
            colaPrioridad.add(tmp);
            tmp=tmp.siguiente;
        }

        while (!colaPrioridad.isEmpty()) {
            Camino aristaActual = colaPrioridad.poll();
            NodoGrafo nodoDestino = aristaActual.destino.nodo;

            if (!nodosIncluidos.contains(nodoDestino.dato)) {
                grafoExpansionMinima.crearNuevoNodo(nodoDestino.dato);
                nodosIncluidos.add(nodoDestino.dato);
                grafoExpansionMinima.annadirNuevaArista(aristaActual.origen, nodoDestino.dato,aristaActual.ejercito,aristaActual.bienes,aristaActual.distancia);
                
                // Agregar las aristas del nodo de destino a la cola de prioridad
                tmp= nodoDestino.lista.primero;
                while (tmp!=null) {
                    colaPrioridad.add(tmp);
                    tmp=tmp.siguiente;
                }
            }
        }
        grafoExpansionMinima.generarCaminosVuelta();
    }
    
    public String extraerCiudadMásCaminos(){
        String ciudadMayor="NINGUNA";
        int mayorCantCaminos=-1;
        for(Ciudad ciudad:ciudades){
            if(ciudad.getCaminos().size()>mayorCantCaminos){
                mayorCantCaminos=ciudad.getCaminos().size();
                ciudadMayor=ciudad.getNombre();
            }
        }
        return ciudadMayor;
    }
    
    public void borrarCiudadDelMapa(String nombreCiudad){
        int i=0;
        for(Ciudad ciudad:ciudades){
            if(ciudad.getNombre().equals(nombreCiudad)){
                break;
            }
            i++;
        }
        ciudades.remove(i);
        generarGrafo();
    }
    
    public void borrarCaminos(){
        
    }
    
    
    
   
    /*
    public void generarCiudades(String nombre){
        Gson gson=leerJSON(nombre);
        

    }
*/
}

