/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia3edd;

import java.util.ArrayList;

/**
 *
 * @author abehd
 */
public class GraphNode {

    private String name = new String();//Identificador del nodo

    private ArrayList<Edge> edges = new ArrayList<Edge>();//Listado de vértices
/*
    Constructor
    */
    public GraphNode() {

    }
/*
    Getters y Setters
    */
    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public ArrayList<Edge> getEdges() {

        return edges;

    }

    public void setEdges(ArrayList<Edge> edges) {

        this.edges = edges;

    }
/*
    Metodo to string para impresiones.
    */
    @Override
    public String toString() {
        return name;
    }

}
