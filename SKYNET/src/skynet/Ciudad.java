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
    int soldados,misiles,TEChLevel;
    List<Camino> caminos;
    boolean visitado;

    
    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
    


    

    public Ciudad(String nombre, int soldados, int misiles, int TEChLevel, List<Camino> caminitos) {
        this.nombre = nombre;
        this.soldados = soldados;
        this.misiles = misiles;
        this.TEChLevel = TEChLevel;
        this.caminos = caminitos;
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

    public int getTEChLevel() {
        return TEChLevel;
    }

    public void setTEChlevel(int TEChlevel) {
        this.TEChLevel = TEChlevel;
    }

    public List<Camino> getCaminos() {
        return caminos;
    }

    public void setCaminos(List<Camino> caminos) {
        this.caminos = caminos;
    }
    
    public boolean comparar(Ciudad otra){
        return nombre.equals(otra.getNombre());
    }
    
    
    
            
}
