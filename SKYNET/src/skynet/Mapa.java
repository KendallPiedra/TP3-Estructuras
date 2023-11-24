/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skynet;

import java.util.ArrayList;
import java.util.List;

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
    
    
    
}
