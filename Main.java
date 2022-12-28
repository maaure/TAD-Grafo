import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vertice<Integer>> nums = new ArrayList<>();
        for(int i = 0; i < 10; i++) nums.add(new Vertice<Integer>(i));
        Grafo<Integer> g = new Grafo<Integer>(nums, null);
        g.printMatrizAdjacencia();
    }
}