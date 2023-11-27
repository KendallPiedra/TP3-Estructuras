
package skynet;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Mapa mapa=new Mapa();
        mapa.generarCiudades("Ciudades6.json");
        
        for(Ciudad ciudad:mapa.ciudades){
            System.out.println(ciudad.nombre);
            System.out.println("---------------------CAMINOS-------------------");
            for(Camino camino:ciudad.caminos){
                System.out.println(camino.ciudad2);
            }
            System.out.println("-----------------------------------------------");
        }
        mapa.generarGrafo();

        
        System.out.println("=================================================");
        System.out.println(mapa.grafo.toString());
        System.out.println("=================================================");        
        mapa.convertirAGrafoDirigido();
        System.out.println(mapa.grafo.esEuleriano());
        List<Ciudad> camino=mapa.grafo.obtenerCaminoEuleriano();
        for(Ciudad ciudad:camino){
            System.out.print(ciudad.nombre+"->");
        }
        /*
        mapa.generarGrafoExpansionMinima();
        System.out.println("=================================================");
        System.out.println(mapa.grafoExpansionMinima.toString());
        System.out.println(mapa.grafo.esConexo());
        
        Skynet SKINEY=new Skynet(mapa);
        System.out.println(SKINEY.mapaReal.grafo.toString());
        //System.out.println("=================================================");
        //SKINEY.dividirAlMundo();
        //SKINEY.bloquearArbolExpansionMinBienes();
        //System.out.println(SKINEY.mapaReal.grafo.toString());
        //System.out.println("=================================================");
        //System.out.println(SKINEY.mapaReal.grafoExpansionMinima.toString());



        
        
        System.out.println("PRUEBAAAAAASSSSSSSSS");
        Mapa mapa2=new Mapa();
        mapa2.generarCiudades("Ciudades6.json");
        mapa2.generarGrafo();
        
        mapa2.convertirAGrafoDirigido(); //Hablar con Ken de esto a ver si hacemos algo al respecto
        */
    }

}
