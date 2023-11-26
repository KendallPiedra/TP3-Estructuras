
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

    
    
}
