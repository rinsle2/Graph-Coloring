public class Main {

    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        for(int i=1;i<5;i++)
            g.addVertex(i);
            g.addEdge(1, 2);
            g.addEdge(2, 3);
            g.addEdge(3, 4);
            g.addEdge(4, 1);
            g.addEdge(2, 4);
            g.addEdge(1, 3);
//        g.addEdge(1, 2);
//        g.addEdge(1, 5);
//        g.addEdge(1, 6);
//        g.addEdge(2, 7);
//        g.addEdge(2, 3);
//        g.addEdge(3, 8);
//        g.addEdge(3, 4);
//        g.addEdge(4, 9);
//        g.addEdge(4, 5);
//        g.addEdge(5, 10);
//        g.addEdge(6, 8);
//        g.addEdge(6, 9);
//        g.addEdge(8, 10);
//        g.addEdge(10, 7);
//        g.addEdge(7, 9);
        g.graphColoring(3);
    }
}
