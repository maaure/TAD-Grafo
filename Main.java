import java.util.ArrayList;
import java.util.List;

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

        g.adicionarAresta(null, v6, v7);
        g.adicionarAresta(null, v7, v6);
        g.adicionarAresta(null, v2, v7);
        g.adicionarAresta(null, v5, v4);

        Aresta<Integer> primeiraAresta = g.getListaArestas().get(0);


        printList(g.finalVertices(primeiraAresta));
        g.printMatrizAdjacenciaQtde();

        Vertice<Integer> vx = g.oposto(v6, primeiraAresta);

        System.out.println(vx.getData() + " ");

        System.out.println(g.isAdjacente(v2, v7));
        System.out.println(g.isAdjacente(v7, v2));

        g.printMatrizAdjacenciaQtde();
        g.removeAresta(primeiraAresta);
        System.out.println();
        g.printMatrizAdjacenciaQtde();

    }


    public static void printList(List<Vertice<Integer>> l) {
        for(Vertice<Integer> i : l) {
            System.out.print(i.getData() + " ");
        }
        System.out.println();
    }
}