
package skynet;

import java.util.ArrayList;
import java.util.List;

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
    
    public void hacerSimulacionReal(){
        mapaReal.CopiarMapa(mapaSimulacion);
    }
    public void deshacerSimulacion(){
        mapaSimulacion.CopiarMapa(mapaReal);
    }
    
    
    
    
    
    
    
    
}
