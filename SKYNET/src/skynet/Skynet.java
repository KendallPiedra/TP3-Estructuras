
package skynet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Skynet {
    public Mapa mapaReal;
    public Mapa mapaSimulacion;
    
    public Skynet(Mapa _mapaReal){
        mapaSimulacion=new Mapa();
        mapaReal=new Mapa();
        mapaSimulacion.CopiarMapa(_mapaReal);
        mapaReal.CopiarMapa(_mapaReal);
    }
    
    public List<String> dividirAlMundo(){
        List<String> nodosEliminados=new ArrayList<>();
        if (!mapaSimulacion.getGrafo().esConexo()){
            JOptionPane.showMessageDialog(null,"El mapa del mundo ya no es conexo");
        }
        while(mapaSimulacion.getGrafo().esConexo()){
            mapaSimulacion.borrarCiudadDelMapa(mapaSimulacion.grafo.encontrarCiudadConMasCaminos());
            mapaSimulacion.generarGrafo();
        }
        

        return nodosEliminados;
    }
    
    public void bloquearArbolExpansionMinBienes(){
        mapaSimulacion.generarGrafoExpansionMinimaBienes();
        List<Camino> listaCaminos= mapaSimulacion.grafoExpansionMinima.extraerTodosLosCaminos();
        for(Camino camino: listaCaminos){
            //System.out.println(camino.toString()+"---------------------");
            mapaSimulacion.grafo.eliminarCamino(camino);
        }
    }
    public void eliminarElGrafo(){
        mapaSimulacion=new Mapa();
        mapaSimulacion.generarGrafo();
        
    }
    public String generarRedDeUnSoloRecorrido(){
        List<Ciudad> camino=mapaSimulacion.grafo.obtenerCaminoEuleriano();
        String salida="No hay camino";
        boolean primero=true;
        for(Ciudad ciudad:camino){
            if(primero){
                salida=ciudad.nombre;
                primero=false;
            }else{
                salida+="\n->"+ciudad.nombre;
            }     
        }
        
        if(!primero){
            eliminarElGrafo();
        }
        return salida;
    } 
    
    public void dirigirGrafoXD(){
        mapaSimulacion.convertirAGrafoDirigido();
    }
    
    public List<String> sacarListaMasFrecuentementeRecorrido() {
        List<Ciudad> camino = mapaSimulacion.grafo.obtenerCaminoEuleriano();

        // Crear un HashMap para contar la frecuencia de cada nombre de ciudad
        Map<String, Integer> frecuenciaCiudades = new HashMap<>();

        // Contar la frecuencia de cada nombre de ciudad en el camino
        for (Ciudad ciudad : camino) {
            String nombreCiudad = ciudad.nombre;
            frecuenciaCiudades.put(nombreCiudad, frecuenciaCiudades.getOrDefault(nombreCiudad, 0) + 1);
        }

        // Encontrar la frecuencia máxima
        int frecuenciaMaxima = 0;

        for (int frecuencia : frecuenciaCiudades.values()) {
            frecuenciaMaxima = Math.max(frecuenciaMaxima, frecuencia);
        }

        // Encontrar las ciudades más frecuentes
        List<String> ciudadesMasFrecuentes = new LinkedList<>();

        for (Map.Entry<String, Integer> entry : frecuenciaCiudades.entrySet()) {
            String nombreCiudad = entry.getKey();
            int frecuencia = entry.getValue();

            if (frecuencia == frecuenciaMaxima) {
                ciudadesMasFrecuentes.add(nombreCiudad);
            }
        }
        return ciudadesMasFrecuentes;
    }
    
    public void eliminarNodosMasVisitadosRecorrido(){////////////ESTA SE TIENE QUE IMPLEMENTAAAAAR
        List<String> listaAEliminar = sacarListaMasFrecuentementeRecorrido();
        for(String ciudad: listaAEliminar){
            mapaSimulacion.borrarCiudadDelMapa(ciudad);
        }
    }
    
    public void hacerSimulacionReal(){
        mapaReal.CopiarMapa(mapaSimulacion);
    }
    public void deshacerSimulacion(){
        mapaSimulacion.CopiarMapa(mapaReal);
    }
    
    
    
    
    
    
    
    
}
