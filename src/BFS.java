import java.util.*;

public class BFS {

    public static void traverse(Graph graph,
                                String start) {

        Set<String> visited =
                new HashSet<>();

        Queue<String> queue =
                new LinkedList<>();

        queue.add(start);

        visited.add(start);

        while(!queue.isEmpty()) {

            String current =
                    queue.poll();

            System.out.print(current + " ");

            for(Edge edge :
                    graph.getGraph()
                            .get(current)) {

                if(!visited.contains(edge.destination)) {

                    visited.add(edge.destination);

                    queue.add(edge.destination);
                }
            }
        }
    }
}