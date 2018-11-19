/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia3edd;

/**
 *
 * @author abehd
 */
public class Edge {

    /*
    Creamos un objeto de tipo GraphNode
     */
    GraphNode target = new GraphNode();
    /*
Declaramos una variable de tipo integer que funcionara para ejemplificar el tamaño entre vertice y vertice.
     */
    Integer cost = null;

    /*
      Constructor
     */
    public Edge() {

    }

    /*
    Setters y Getters
     */
    public GraphNode getTarget() {

        return target;

    }

    public void setTarget(GraphNode target) {

        this.target = target;

    }

    public Integer getCost() {

        return cost;

    }

    public void setCost(Integer cost) {

        this.cost = cost;

    }

    /*
    Metodo to string para Impresiones.
     */
    @Override
    public String toString() {
        return "target = " + target + " , cost = " + cost;
    }

}
