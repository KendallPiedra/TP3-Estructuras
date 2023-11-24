
package skynet;

/**
 *
 * @author krisc
 */
public class Camino {
    String ciudad1, ciudad2;
    int ejercito, bienes, distancia;
    
    Camino(String ciudad1, String ciudad2, int ejercito, int bienes, int distancia){
        this.ciudad1=ciudad1;
        this.ciudad2=ciudad2;
        this.ejercito=ejercito;
        this.bienes=bienes;
        this.distancia=distancia;
    }
}
