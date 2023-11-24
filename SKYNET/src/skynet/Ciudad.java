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
public class Ciudad {
    String nombre;
    int soldados,misiles,TEChlevel;
    List<Camino> caminitos;

    public Ciudad(String nombre, int soldados, int misiles, int TEChlevel, List<Camino> caminitos) {
        this.nombre = nombre;
        this.soldados = soldados;
        this.misiles = misiles;
        this.TEChlevel = TEChlevel;
        this.caminitos = caminitos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSoldados() {
        return soldados;
    }

    public void setSoldados(int soldados) {
        this.soldados = soldados;
    }

    public int getMisiles() {
        return misiles;
    }

    public void setMisiles(int misiles) {
        this.misiles = misiles;
    }

    public int getTEChlevel() {
        return TEChlevel;
    }

    public void setTEChlevel(int TEChlevel) {
        this.TEChlevel = TEChlevel;
    }

    public List<Camino> getCaminitos() {
        return caminitos;
    }

    public void setCaminitos(List<Camino> caminitos) {
        this.caminitos = caminitos;
    }
    
    
    
            
}
