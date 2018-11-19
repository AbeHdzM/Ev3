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
public class Graph {

    /*
    Constructor
     */
    public Graph() {
    }

    /*
    Metodo para imprimir en el main
     */
    public void show() {
/*
        Arreglo de strings para darles nombres a los nodos
        */
        String[] nombres = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"};
        /*
        ArrayList de nodos.
        */
        ArrayList<GraphNode> nodos = new ArrayList<>();
/*
        Ciclo para darles nombre a los nodos.
        */
        for (int i = 0; i < nombres.length; i++) {
            GraphNode nodoaux = new GraphNode();

            nodoaux.setName(nombres[i]);

            nodos.add(nodoaux);

        }
        /*
        Ciclo para darle vertices a los nodos, con su peso correspondiente.
        */
        for (int i = 0; i < nodos.size(); i++) {
            /*
            Se crean dos objetos de tipo edge
            */
            Edge edges2 = new Edge();
            Edge edges3 = new Edge();
/*
            En caso de que el nodo sea el penultimo, solo podra tener un vertice, el vertice final entonces solo se le agrega ese.
            */
            if (i == 13) {
                //Se crea un arraylist de vertices.
                ArrayList<Edge> edges = new ArrayList<Edge>();
                //Se establece el costo de la union, mediante un numero random.
                edges2.setCost((int) (Math.random() * 10) + 1);
                //Se hace la union de nodo con vertice.
                edges2.setTarget(nodos.get(i + 1));
                //Se añade el vertice a la lista de vertices del nodo.
                edges.add(edges2);
                //Se añade la lista de vertices al nodo.
                nodos.get(i).setEdges(edges);
            } 
            /*
            En caso de que el nodo sea el ultimo, solo podra ir hacia el mismo y el peso de ese camino sera -1 o 0.
            */
            else if (i == 14) {
                //Se crea un arraylist de vertices.
                ArrayList<Edge> edges = new ArrayList<Edge>();
                //Se establece el costo de la union del ultimo vertice con si mismo, lo cual dara -1 o 0.
                edges2.setCost(-1);
                //Se establece que la unica union posible del nodo sera consigo mismo.
                edges2.setTarget(nodos.get(i));
                //Se añade el vertice a la lista de vertices del nodo.
                edges.add(edges2);
                //Se añade la lista de vertices al nodo.
                nodos.get(i).setEdges(edges);
            } 
            /*
            En cualquier otro caso, cada nodo tendra 2 vertices, por ejemplo, el nodo A tendra como vertices B y C, el nodo
            B tendra como vertices C y D, y asi sucesivamente, tomando en cuenta para los vertices una relacion de la posicion 
            del nodo +1 y +2.
            */
            else {
                //Se crea un arrayList.
                ArrayList<Edge> edges = new ArrayList<Edge>();
                //Se establece el costo de la union del vertice 1, mediante el numero random
                edges2.setCost((int) (Math.random() * 10) + 1);
                //Se hace la union entre nodo y el vertice 1.
                edges2.setTarget(nodos.get(i + 1));
                //Se establece el costo de la union del vertice 2, mediante el numero random
                edges3.setCost((int) (Math.random() * 10) + 1);
                //Se hace la union entre nodo y el vertice 2.
                edges3.setTarget(nodos.get(i + 2));
                //Se añaden ambos vertices a la lista de vertices del nodo.
                edges.add(edges2);
                edges.add(edges3);
                //Se añade la lista de vertices al nodo.
                nodos.get(i).setEdges(edges);

            }
/*
            Impresion de el listado de nodos, para ver los vertices asignados a cada nodo, asi como el peso de la union.
            */
        }
        for (int i = 0; i < nodos.size(); i++) {
            System.out.println(nodos.get(i).getName() + nodos.get(i).getEdges());
        }
/*
        Impresion que denota el inicio del metodo dijkstra.
        */
        System.out.println("Camino cortito HDMLG360NOSCOPE4K1080P");
        //Se pasa como parametro el primer nodo de la lista.
        dijkstra(nodos.get(0));

    }
/*
    Metodo dijkstra para encontrar el camino mas corto
    */
    //El metodo toma como parametro el primer nodo de la lista de nodos.
    public void dijkstra(GraphNode source) {
        //Se hace impresion del nodo actual.
        System.out.println(source.getName());
        //Si el costo del vertice del nodo es -1 eso indica que estamos en el ultimo nodo, no se hace nada,
        //porque ya se imprimio previamente xd.
        if (source.getEdges().get(0).getCost() == -1) {
            
        }
        //Si el tamaño de la lista de vertices es 1, es obvio que estamos en el penultimo nodo,
        //pues este es el unico que cuenta con solo un vertice, por lo que se manda a llamar a su vertice y entra en el metodo de dijkstra
        //en el cual se procedera a imprimir el ultimo nodo.
        else if (source.getEdges().size() == 1) {
            source = source.getEdges().get(0).getTarget();
            dijkstra(source);
        } else {
            //En cualquiera de los otros casos, lo unico que se tiene que hacer es diferenciar por cual camino se ira,
            //lo cual se hara comparando los costos de ambos vertices, dependiendo de cual sea menor, se tomara ese vertice
            //como nodo fuente y se mandara al metodo recursivo donde continuara hasta llegar al final, haciendo impresiones de
            //todos los nodos para marcar el camino a seguir.
            if (source.getEdges().get(0).getCost() < source.getEdges().get(1).getCost()) {
                source = source.getEdges().get(0).getTarget();
                dijkstra(source);
            } else {
                source = source.getEdges().get(1).getTarget();
                dijkstra(source);
            }

        }

    }

}
