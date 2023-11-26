
package skynet;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Usuario
 */
public class Mapa {
    List<Camino> caminos= new ArrayList<>();
    List<Ciudad> ciudades= new ArrayList<>();
    Grafo grafo;
    
    public Mapa() {
    }

    public List<Camino> getCaminos() {
        return caminos;
    }

    public void setCaminos(List<Camino> caminos) {
        this.caminos = caminos;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
    
    
    public static Ciudad[] leerJSON(String nombre) {
        Gson gson = new Gson();
        String fichero = "";

        try (BufferedReader br = new BufferedReader(new FileReader(nombre))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                fichero += linea;
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error al abrir el archivo: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error de lectura del archivo: " + ex.getMessage());
        }

        return gson.fromJson(fichero, Ciudad[].class);
    }

    public void generarCiudades(String nombre) {
        Ciudad[] ciudadesArray = leerJSON(nombre);

        // Limpiar la lista de ciudades antes de agregar las nuevas
        ciudades.clear();

        // Agregar las ciudades al mapa
        for (Ciudad ciudad : ciudadesArray) {
            ciudades.add(ciudad);
        }
    }

    public Ciudad buscarCiudad(String sCiudad){
        for (Ciudad ciudad: ciudades){
            if(ciudad.nombre.equals(sCiudad)){
                return ciudad;
            }
        }
        return null;
    }

    public void generarAdyacenciasGrafo(){
        for(Ciudad ciudad: ciudades){
            for (Camino camino:ciudad.caminos){
                if (buscarCiudad(camino.ciudad2)!=null){
                    grafo.annadirNuevaArista(ciudad, 
                        buscarCiudad(camino.ciudad2), camino.ejercito, camino.bienes, camino.distancia);
                }
            }
        }
    }
    public void generarGrafo(){
        grafo= new Grafo();
        for(Ciudad ciudad: ciudades){
            grafo.crearNuevoNodo(ciudad);
        }
        generarAdyacenciasGrafo();
        
    }
    /*
    public void generarCiudades(String nombre){
        Gson gson=leerJSON(nombre);
        

    }
*/
}

