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
    boolean visitado;
    
    public NodoGrafo(Ciudad ciudad){
        dato=ciudad;
        lista=new ListaAdyacencia();
        siguiente=null;
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

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
    
    
}
