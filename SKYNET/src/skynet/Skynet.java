
package skynet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Skynet {
    Mapa mapaReal;
    Mapa mapaSimulacion;
    
    public Skynet(Mapa _mapaReal){
        mapaSimulacion=mapaReal=_mapaReal;
    }
    
    public List<String> dividirAlMundo(){
        List<String> nodosEliminados=new ArrayList<>();
        while(mapaSimulacion.getGrafo().esConexo()){
            mapaReal.borrarCiudadDelMapa(mapaReal.grafo.encontrarCiudadConMasCaminos());
            mapaReal.generarGrafo();
        }
        return nodosEliminados;
    }
    
    public void bloquearArbolExpansionMinBienes(){
        mapaReal.generarGrafoExpansionMinimaBienes();
        List<Camino> listaCaminos= mapaReal.grafoExpansionMinima.extraerTodosLosCaminos();
        for(Camino camino: listaCaminos){
            //System.out.println(camino.toString()+"---------------------");
            mapaReal.grafo.eliminarCamino(camino);
        }
    }
    
    
    
    
    
    
    
    
}
