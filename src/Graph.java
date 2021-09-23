import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;


public class Graph<T> {
    //Fields
    private final Map<T, ArrayList<T>> map = new HashMap<>();
    private int nodeCount = 0;
    private final ArrayList<Boolean> checks = new ArrayList<>();
    //Populate Boolean Array
    Graph() {
    }
    // O(1)
    public void addVertex(T n) {
        map.put(n, new ArrayList<>());
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
    //Populate the checks for the condition
    private void populate() {
        for (int i=0;i<nodeCount;i++) {
            checks.add(true);
        }
    }
    /*
    * O(n)
    * Checks the graph for proper coloring rules (checking for false cases later)
    * This is the only function that will need to be fixed
    *
    */
    private void checkMatrix(ArrayList<T> l, int colors) {
        if(l.isEmpty()) return;
        int len = l.size();
        //False negatives are given, how do you fix it?
        if((len == nodeCount - 1 || nodeCount > colors) && len >= colors) { //change >= to > and check both graphs to find the issue
            for (int i=0;i<checks.size();i++) {
                if (checks.get(i)) {
                    checks.set(i, false);
                    break;
                }
            }
        }
    }
    /*
    * O(n)
    * Checks the number of full rows in the matrix
    * May also need changing in the future if matrix is unusable
    * Based on the assumption of rules in the matrix and earlier condition
    */
    private boolean subsetTrue(int numC) {
        int fullCount = 0;
        for (Boolean b: checks) {
            if(!b) fullCount++;
            if(fullCount >= numC) return true;
        }
        return false;
    }
    
    private void rowCounts(ArrayList<T> val) {
        if(val.isEmpty()) nodeCount--;
    }

    public void graphColoring(int numColors) {
        populate();//O(n)
        // O((n*(n-1) ))
        map.forEach((k, v) -> rowCounts(v));
        map.forEach((k, v) -> checkMatrix((v), numColors));
        System.out.print("Graph is ");
        //O(n)
        if(subsetTrue(numColors)) {
            System.out.print("not ");
        }
        System.out.println("fully colored with " + numColors + " colors.");
    }
}
