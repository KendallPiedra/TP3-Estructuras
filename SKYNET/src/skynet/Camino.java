
package skynet;

/**
 *
 * @author krisc
 */
public class Camino { //(ARCOS)
    
    String ciudad2;
    Ciudad origen;
    Ciudad destino;
    Camino siguiente;
    int ejercito, bienes, distancia;
    boolean visitado;

    public Camino(String ciudad2, int ejercito, int bienes, int distancia) {
        this.ciudad2 = ciudad2;
        this.ejercito = ejercito;
        this.bienes = bienes;
        this.distancia = distancia;
        this.destino=null;
        this.siguiente=null;
        visitado=false;
    }
    public Camino(Ciudad origen,Ciudad destino,int ejercito, int bienes, int distancia) {
        this.destino = destino;
        this.origen = origen;
        this.ejercito = ejercito;
        this.bienes = bienes;
        this.distancia = distancia;
        this.siguiente=null;
        visitado=false;
    }
    
    public Camino(Ciudad origen, Ciudad destino){
        this.origen= origen;
        this.destino= destino;
        ejercito=bienes=distancia=0;
        this.siguiente=null;
        visitado=false;
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
    
    public void setVisitado(boolean visitado){
        this.visitado=visitado;
    }
    
    public boolean isVisitado(){
        return visitado;
    }
    
    public Camino copiarCamino(Camino camino){
        return null;
    }

    @Override
    public String toString() {
        return origen.nombre+"->"+destino.nombre;
    }
    
    

}
