
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
        mapaSimulacion=new Mapa();
        mapaReal=new Mapa();
        mapaSimulacion.CopiarMapa(_mapaReal);
        mapaReal.CopiarMapa(_mapaReal);
    }
    
    public void dividirAlMundo(){
        while(mapaSimulacion.getGrafo().esConexo()){
            mapaSimulacion.borrarCiudadDelMapa(mapaSimulacion.grafo.encontrarCiudadConMasCaminos());
            mapaSimulacion.generarGrafo();
        }
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
