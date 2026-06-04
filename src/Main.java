import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

        // Add Roads
        graph.addRoad("A", "B", 4);
        graph.addRoad("A", "C", 2);
        graph.addRoad("B", "D", 5);
        graph.addRoad("C", "D", 1);
        graph.addRoad("D", "E", 2);
        graph.addRoad("B", "E", 3);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== ROUTE PLANNER MENU =====");

            System.out.println("1. Display Road Network");
            System.out.println("2. BFS Traversal");
            System.out.println("3. DFS Traversal");
            System.out.println("4. Find Shortest Route");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    graph.displayGraph();
                    break;

                case 2:

                    System.out.print("Enter Start Location: ");
                    String bfsStart = sc.next();

                    BFS.traverse(graph, bfsStart);

                    break;

                case 3:

                    System.out.print("Enter Start Location: ");
                    String dfsStart = sc.next();

                    DFS.traverse(graph, dfsStart);

                    break;

                case 4:

                    System.out.print("Enter Source: ");
                    String source = sc.next();

                    System.out.print("Enter Destination: ");
                    String destination = sc.next();

                    Dijkstra.shortestPath(
                            graph,
                            source,
                            destination);

                    break;

                case 5:

                    System.out.println("Exiting...");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}