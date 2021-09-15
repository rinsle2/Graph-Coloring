public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();

        g.addVertex("a");
        g.addEdge("a", "b");
        g.graphColoring(2);
    }
}
