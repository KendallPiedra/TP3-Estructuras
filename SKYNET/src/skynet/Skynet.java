
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
<<<<<<< Updated upstream
            //System.out.println(camino.toString()+"---------------------");
            mapaSimulacion.grafo.eliminarCamino(camino);
=======
            mapaReal.grafo.eliminarCamino(camino);
>>>>>>> Stashed changes
        }
    }
    
    public void hacerSimulacionReal(){
        mapaReal.CopiarMapa(mapaSimulacion);
    }
    public void deshacerSimulacion(){
        mapaSimulacion.CopiarMapa(mapaReal);
    }
    
    
    
    
    
    
    
    
}
