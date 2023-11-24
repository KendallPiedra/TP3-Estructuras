
package skynet;

/**
 *
 * @author krisc
 */
public class Camino {
    String ciudad1, ciudad2;
    int ejercito, bienes, distancia;

    public Camino(String ciudad1, String ciudad2, int ejercito, int bienes, int distancia) {
        this.ciudad1 = ciudad1;
        this.ciudad2 = ciudad2;
        this.ejercito = ejercito;
        this.bienes = bienes;
        this.distancia = distancia;
    }

    public String getCiudad1() {
        return ciudad1;
    }

    public void setCiudad1(String ciudad1) {
        this.ciudad1 = ciudad1;
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
