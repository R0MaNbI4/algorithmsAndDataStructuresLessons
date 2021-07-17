public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(0, 4);
        graph.addEdge(0, 6);
        graph.addEdge(1, 5);
        graph.addEdge(1, 8);
        graph.addEdge(2, 7);
        graph.addEdge(2, 6);
        graph.addEdge(2, 3);
        graph.addEdge(3, 8);
        graph.addEdge(5, 6);
        graph.addEdge(7, 9);

        BreadthFirstPath bfs = new BreadthFirstPath(graph, 8);
        System.out.println(bfs.pathTo(9));
    }
}
