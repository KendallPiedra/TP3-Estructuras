
package skynet;

/**
 *
 * @author Usuario
 */
public class SKYNET {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Mapa mapa=new Mapa();
        mapa.generarCiudades("Ciudades6.json");
        
        for(Ciudad ciudad:mapa.ciudades){
            System.out.println(ciudad.misiles);
        }
        System.out.println("holaaaaa");
    }
    
}
