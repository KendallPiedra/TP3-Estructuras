
package skynet;

/**
 *
 * @author krisc
 */
public class Camino { //(ARCOS)
    String ciudad2;
    Ciudad destino;
    Camino siguiente;
    int ejercito, bienes, distancia;

    public Camino(String ciudad2, int ejercito, int bienes, int distancia) {
        this.ciudad2 = ciudad2;
        this.ejercito = ejercito;
        this.bienes = bienes;
        this.distancia = distancia;
        this.destino=null;
        this.siguiente=null;
    }
    public Camino(Ciudad destino, int ejercito, int bienes, int distancia) {
        this.destino = destino;
        this.ejercito = ejercito;
        this.bienes = bienes;
        this.distancia = distancia;
        this.siguiente=null;
    }
    
    public Camino(Ciudad destino){
        this.destino= destino;
        ejercito=bienes=distancia=0;
        this.siguiente=null;
    }

    public String getCiudad2() {
        return ciudad2;
    }

    public void setCiudad2(String ciudad2) {
        this.ciudad2 = ciudad2;
    }

    public int getEjercito() {
        return ejercito;
    }

    public void setEjercito(int ejercito) {
        this.ejercito = ejercito;
    }

    public int getBienes() {
        return bienes;
    }

    public void setBienes(int bienes) {
        this.bienes = bienes;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

}
