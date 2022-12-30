import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Grafo<Integer> g = new Grafo<Integer>();
        
        Vertice<Integer> v1 = new Vertice<Integer>(5);
        Vertice<Integer> v2 = new Vertice<Integer>(6);
        Vertice<Integer> v3 = new Vertice<Integer>(1);
        Vertice<Integer> v4 = new Vertice<Integer>(8);
        Vertice<Integer> v5 = new Vertice<Integer>(15);
        Vertice<Integer> v6 = new Vertice<Integer>(0);
        Vertice<Integer> v7 = new Vertice<Integer>(-5);

        g.adicionarVertice(v1);
        g.adicionarVertice(v2);
        g.adicionarVertice(v3);
        g.adicionarVertice(v4);
        g.adicionarVertice(v5);
        g.adicionarVertice(v6);
        g.adicionarVertice(v7);

        g.printMatrizAdjacencia();

        System.out.println();

        g.adicionarAresta(null, v1, v2);
        g.adicionarAresta(null, v2, v1);

        g.adicionarAresta(null, v5, v3);
        g.adicionarAresta(null, v3, v5);
        g.adicionarAresta(null, v3, v5);
        g.adicionarAresta(null, v3, v5);
        g.adicionarAresta(null, v2, v2);

        g.printMatrizAdjacenciaQtde();

        g.removeVertice(v1);

        System.out.println();


        g.printMatrizAdjacenciaQtde();


    }
}