
package skynet;

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
    
    
    
    
    
    
    
    
    
    
}
