public class Main {

    private static void initialVertices(Graph<Integer> g, Integer verts) {
        int i = 1;
        do {
            g.addVertex(i);
            i++;
        } while(i<verts);
    }
    //Square Graph with a cross in the middle
    private static void initializeSquareGraph(Graph<Integer> g) {
            g.addEdge(1, 2);
            g.addEdge(2, 3);
            g.addEdge(3, 4);
            g.addEdge(4, 1);
            g.addEdge(2, 4);
            g.addEdge(1, 3);
    }
    // Peterson Graph
    private static void  initializePetersonGraph(Graph<Integer> g) {
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(1, 6);
        g.addEdge(2, 7);
        g.addEdge(2, 3);
        g.addEdge(3, 8);
        g.addEdge(3, 4);
        g.addEdge(4, 9);
        g.addEdge(4, 5);
        g.addEdge(5, 10);
        g.addEdge(6, 8);
        g.addEdge(6, 9);
        g.addEdge(8, 10);
        g.addEdge(10, 7);
        g.addEdge(7, 9);
    }

    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        initialVertices(g, 5);
//      initializeSquareGraph();
        initializePetersonGraph(g);
        g.graphColoring(3);
    }
}
