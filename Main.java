import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Grafo<Integer> g = new Grafo<Integer>();
        for(int i = 0; i < 10; i++) g.adicionarVertice(i);
        g.printVertices();
        g.printMatrizAdjacencia();
    }
}