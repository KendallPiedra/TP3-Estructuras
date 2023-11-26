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
    }
}
