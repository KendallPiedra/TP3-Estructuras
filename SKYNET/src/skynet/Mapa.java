/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    
    public void leerJSON(String nombre){//"loquesea.json"
        	
        Gson gson = new Gson();
        String fichero= "";
        
        try (BufferedReader br = new BufferedReader(new FileReader(nombre))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                fichero += linea;
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        Properties properties = gson.fromJson(fichero, Properties.class);
    }
}
