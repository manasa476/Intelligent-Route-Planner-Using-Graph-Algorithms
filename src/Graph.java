import java.util.*;

public class Graph {

    private Map<String, List<Edge>> graph = new HashMap<>();

    public void addRoad(String source,
                        String destination,
                        int distance) {

        graph.putIfAbsent(source, new ArrayList<>());
        graph.putIfAbsent(destination, new ArrayList<>());

        graph.get(source).add(new Edge(destination, distance));
        graph.get(destination).add(new Edge(source, distance));
    }

    public Map<String, List<Edge>> getGraph() {
        return graph;
    }

    // THIS METHOD IS MISSING
    public void displayGraph() {

        for (String location : graph.keySet()) {

            System.out.print(location + " -> ");

            for (Edge edge : graph.get(location)) {

                System.out.print("("
                        + edge.destination
                        + ","
                        + edge.weight
                        + ") ");
            }

            System.out.println();
        }
    }
}