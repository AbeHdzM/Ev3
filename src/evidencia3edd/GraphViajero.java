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
public class GraphViajero {

    public GraphViajero() {
    }

    public void show() {

        String[] nombres = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"};

        ArrayList<GraphNode> nodos = new ArrayList<>();
        /*
        Ciclo para darles nombre a los nodos.
         */
        for (int i = 0; i < nombres.length; i++) {
            GraphNode nodoaux = new GraphNode();

            nodoaux.setName(nombres[i]);

            nodos.add(nodoaux);

        }

        for (int i = 0; i < nodos.size(); i++) {

            ArrayList<Edge> edges = new ArrayList<Edge>();
            for (int j = 0; j < nodos.size(); j++) {
                Edge edges2 = new Edge();
                if (i == j) {
                    edges2.setCost(-1);
                    edges2.setTarget(nodos.get(j));
                    edges.add(edges2);
                    nodos.get(i).setEdges(edges);
                } else {
                    edges2.setCost((int) (Math.random() * 20) + 1);
                    edges2.setTarget(nodos.get(j));
                    edges.add(edges2);
                    nodos.get(i).setEdges(edges);
                }

            }
        }

        System.out.println("-------------------------------------------------");
        System.out.println("El camino del viajero, la leyenda jamas contada.");
        System.out.println("-------------------------------------------------");
        ArrayList<GraphNode> result = new ArrayList<>();
        GraphNode source = nodos.get(0);
        result.add(source);

        viajero(nodos, result, source);
    }

    public void viajero(ArrayList<GraphNode> pending, ArrayList<GraphNode> result, GraphNode source) {
        System.out.println(result.toString());
        GraphNode visitado = new GraphNode();

        if (pending.size() == 0) {

            System.out.println("-------------------------------------------------");
            System.out.println("La senda del viajero ha terminado");
            System.out.println("-------------------------------------------------");

        } else {
            ArrayList<Integer> costos = new ArrayList<>();
            Bubble b = new Bubble();
            for (int i = 0; i < 15; i++) {
                int num = source.getEdges().get(i).getCost();
                costos.add(num);
            }
            costos = b.sort(costos);
            int num2 = costos.get(1);
            for (int i = 0; i < 15; i++) {

                if (num2 == source.getEdges().get(i).getCost()) {
                    visitado = source.getEdges().get(i).getTarget();
                    if (result.contains(visitado) == false) {

                        result.add(visitado);
                        pending.remove(source);
                        pending.remove(visitado);
                        viajero(pending, result, visitado);
                    } else {
                    num2 = costos.get(2);
                    }

                }

            }

        }
    }
}
