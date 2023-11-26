
package skynet;

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
        System.out.println("=================================================");
        mapa.generarGrafo();
        System.out.println(mapa.grafo.toString());
        System.out.println(mapa.grafo.esConexo());
    }
    
    
    
}
