
package skynet;

/**
 *
 * @author cesar
 */
public class fgfff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mapa mapa=new Mapa();
        mapa.generarCiudades("Ciudades6.json");
        //mapa.generarCiudades("eule10.json");
        
        mapa.generarGrafo();
        
        Skynet SKINEY=new Skynet(mapa);
        System.out.println(SKINEY.mapaReal.grafo.toString());
        System.out.println("===============LINEA DIVISORA===============");
        System.out.println(SKINEY.mapaSimulacion.grafo.toString());
        System.out.println("====================================LINEA DIVISORA GRAAAAANDE===================================");

        System.out.println(SKINEY.generarRedDeUnSoloRecorrido());

        System.out.println(SKINEY.generarRedDeUnSoloRecorridoSinAniquilacion());
        SKINEY.eliminarNodosMasVisitadosRecorrido();
        System.out.println("===============LINEA DIVISORA===============");
        System.out.println(SKINEY.mapaSimulacion.grafo.toString());

        SKINEY.eliminarNodosMasVisitadosRecorrido();
        System.out.println("===============LINEA DIVISORA===============");
        System.out.println(SKINEY.mapaSimulacion.grafo.toString());
        

    }
    
}
