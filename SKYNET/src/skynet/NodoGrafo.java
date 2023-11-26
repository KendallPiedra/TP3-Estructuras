/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skynet;

/**
 *
 * @author Usuario
 */
public class NodoGrafo {
    Ciudad dato;
    ListaAdyacencia lista; 
    NodoGrafo siguiente;
    
    public NodoGrafo(Ciudad ciudad){
        dato=ciudad;
        lista=new ListaAdyacencia();
        siguiente=null;
        ciudad.setNodo(this);
    }
    
    public int totalCaminos(){
        return lista.totalAdyacencias();
    }

    public Ciudad getDato() {
        return dato;
    }

    public void setDato(Ciudad dato) {
        this.dato = dato;
    }

    public ListaAdyacencia getLista() {
        return lista;
    }

    public void setLista(ListaAdyacencia lista) {
        this.lista = lista;
    }

    public NodoGrafo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoGrafo siguiente) {
        this.siguiente = siguiente;
    }
    
    
    public void devisitar(){
        dato.setVisitado(false);
    }
    
    public void agregarCaminosVuelta(){
        lista.agragarCaminosVuelta(dato);
    }

    
    
}
