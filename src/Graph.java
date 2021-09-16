import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;


public class Graph<T> {
    //Fields
    private final Map<T, List<T>> map = new HashMap<>();
    private int nodeCount = 0;
    private final ArrayList<Boolean> checks = new ArrayList<>();
    //Populate Boolean Array
    Graph() {
    }
    // O(1)
    public void addVertex(T n) {
        map.put(n, new LinkedList<>());
        nodeCount++;
    }
    // O(1) technically
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
    //O(n)
    private void populate() {
        for (int i=0;i<nodeCount;i++) {
            checks.add(false);
        }
    }
    /*
    * O(n^2)
    * Checks the graph for proper coloring rules (checking for false cases later)
    * This is the only function that will need to be fixed
    *
    */
    private void checkMatrix(LinkedList<T> l, int colors) {
        int len = l.size();
        //False negatives are given, working on a fix (readme is about to get a LOT longer due to iterating over the condition)
        if((len == nodeCount - 1 || nodeCount > colors) && len >= colors) {
            for (int i=0;i<checks.size();i++) {
                if (!checks.get(i)) {
                    checks.set(i, true);
                    break;
                }
            }
        }
    }
    /*
    * O(n)
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
        populate();//O(n)
        // O(n^2)
        map.forEach((k, v) -> checkMatrix(((LinkedList<T>) v), numColors));
        System.out.print("Graph is ");
        //O(n)
        if(subsetTrue(numColors)) {
            System.out.print("not ");
        }
        System.out.println("fully colored with " + numColors + " colors.");
    }
}
