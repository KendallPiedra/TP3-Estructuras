
package skynet;

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
    
    public void dividirAlMundo(){
        while(mapaSimulacion.getGrafo().esConexo()){
            mapaReal.borrarCiudadDelMapa(mapaReal.grafo.encontrarCiudadConMasCaminos());
            mapaReal.generarGrafo();
        }
    }
    
    public void bloquearArbolExpansionMinBienes(){
        mapaReal.generarGrafoExpansionMinimaBienes();
        List<Camino> listaCaminos= mapaReal.grafoExpansionMinima.extraerTodosLosCaminos();
        for(Camino camino: listaCaminos){
            
        }
    }
    
    
    
    
    
    
    
    
}
