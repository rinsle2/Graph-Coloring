import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;


public class Graph<T> {
    //Fields
    private final Map<T, List<T>> map = new HashMap<>();
    private int nodeCount = 0;
    private ArrayList<Boolean> checks;
    //Populate Boolean Array
    private void populate() {
        for (int i=0;i<=nodeCount;i++) {
            checks.add(false);
        }
    }
    Graph() {
    }
    public void addVertex(T n) {
        map.put(n, new LinkedList<>());
        nodeCount++;
    }

    public void addEdge(T s, T d) {
        if(!map.containsKey(s)) {
            addVertex(s);
        }
        if(!map.containsKey(d)) {
            addVertex(d);
        }
        map.get(s).add(d);
        map.get(d).add(s);
    }
    /*
    *
    * Checks the graph for proper coloring rules (checking for false cases later)
    * This is the only function that will need to be fixed
    *
    */
    private void checkMatrix(LinkedList<T> l, int colors) {
        int len = l.size();
        //Conditionals can be hell, ESPECIALLY WHEN NO ONE'S TESTED ANYTHING
        if(len == nodeCount - 1 && nodeCount > colors && len >= colors) {
            for (int i=0;i<checks.size();i++) {
                if (!checks.get(i)) {
                    checks.set(i, true);
                }
            }
        }
    }
    /*
    *
    * Checks the number of full rows in the matrix
    *
    *
    */
    private boolean subsetTrue(int numC) {
        int fullCount = 0;
        for (Boolean b: checks) {
            if(b) fullCount++;
            if(fullCount >= numC) return true;
        }
        return false;
    }
    public void graphColoring(int numColors) {
        map.forEach((k, v) -> checkMatrix(((LinkedList<T>) v), numColors));
        checks = new ArrayList<>();
        populate();
        System.out.print("Graph is ");
        if(subsetTrue(numColors)) {
            System.out.print("not");
        }
        System.out.println("fully colored with " + numColors + " colors.");
    }
}
