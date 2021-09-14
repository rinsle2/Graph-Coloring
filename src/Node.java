import java.util.*;

public class Node<T> {
    private Map<T, List<T>> map = new HashMap<>();
    private int nodeCount = 0;
    private ArrayList<Boolean> checks;

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

    private void checkMatricies(List l, int colors, int nC) {
        int len = l.size();
        if(len == nC - 1 && nC > colors) {
            for (int i=0;i<checks.size();i++) {
                if (!checks.get(i)) {
                    checks.set(i, true);
                }
            }
        }
    }
    private void populate(int numC) {
        for (int i=0;i<=numC;i++) {
            checks.add(false);
        }
    }
    private boolean allTrue(int nC) {
        int fullCount = 0;
        for (Boolean b: checks) {
            if(b) fullCount++;
            if(fullCount >= nC) return true;
        }
        return false;
    }
    public void graphColoring(int numColors) {
        map.forEach((k, v) -> checkMatricies(v, numColors, nodeCount));
        checks = new ArrayList<>();
        populate(numColors);
        System.out.print("Graph is ");
        if(allTrue(numColors)) {
            System.out.print("not");
        }
        System.out.println("colorable with " + numColors + " colors.");
    }




}
