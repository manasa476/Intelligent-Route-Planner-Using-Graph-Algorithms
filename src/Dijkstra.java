import java.util.*;

public class Dijkstra {

    public static void shortestPath(Graph graph,
                                    String source,
                                    String destination) {

        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> previous = new HashMap<>();

        PriorityQueue<Node> pq = new PriorityQueue<>(
                Comparator.comparingInt(n -> n.distance));

        for (String vertex : graph.getGraph().keySet()) {
            distance.put(vertex, Integer.MAX_VALUE);
        }

        distance.put(source, 0);
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {

            Node currentNodeObj = pq.poll();
            String currentNode = currentNodeObj.name;

            for (Edge edge : graph.getGraph().get(currentNode)) {

                int newDistance =
                        distance.get(currentNode)
                                + edge.weight;

                if (newDistance <
                        distance.get(edge.destination)) {

                    distance.put(edge.destination,
                            newDistance);

                    previous.put(edge.destination,
                            currentNode);

                    pq.add(new Node(
                            edge.destination,
                            newDistance));
                }
            }
        }

        // Reconstruct Path
        List<String> path = new ArrayList<>();

        String current = destination;

        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }

        Collections.reverse(path);

        // Route Summary
        System.out.println("\n===== ROUTE SUMMARY =====");
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Shortest Route: " + path);
        System.out.println("Total Distance: "
                + distance.get(destination) + " km");
        System.out.println("Number of Locations Visited: "
                + path.size());
    }
}

class Node {

    String name;
    int distance;

    Node(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }
}