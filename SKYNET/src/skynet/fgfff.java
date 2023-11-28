/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package skynet;

/**
 *
 * @author cesar
 */
public class fgfff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mapa mapa=new Mapa();
        mapa.generarCiudades("Ciudades10.json");
        //mapa.generarCiudades("eule10.json");
        
        mapa.generarGrafo();
        
        Skynet SKINEY=new Skynet(mapa);
        System.out.println(SKINEY.mapaReal.grafo.toString());
        System.out.println("===============LINEA DIVISORA===============");
        System.out.println(SKINEY.mapaSimulacion.grafo.toString());
        System.out.println("====================================LINEA DIVISORA GRAAAAANDE===================================");
        SKINEY.dividirAlMundo();
        System.out.println(SKINEY.mapaReal.grafo.toString());
        System.out.println("===============LINEA DIVISORA===============");
        System.out.println(SKINEY.mapaSimulacion.grafo.toString());
    }
    
}
