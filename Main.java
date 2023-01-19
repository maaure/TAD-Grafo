import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grafo<String> gr = new Grafo<String>();
        
        Vertice<String> a = new Vertice<String>("A");
        Vertice<String> b = new Vertice<String>("B");
        Vertice<String> c = new Vertice<String>("C");
        Vertice<String> d = new Vertice<String>("D");
        Vertice<String> e = new Vertice<String>("E");
        Vertice<String> f = new Vertice<String>("F");
        Vertice<String> g = new Vertice<String>("G");
        Vertice<String> h = new Vertice<String>("H");
        Vertice<String> i = new Vertice<String>("I");
        Vertice<String> j = new Vertice<String>("J");
        Vertice<String> k = new Vertice<String>("K");
        Vertice<String> l = new Vertice<String>("L");
        Vertice<String> m = new Vertice<String>("M");
        Vertice<String> n = new Vertice<String>("N");
        Vertice<String> o = new Vertice<String>("O");
        Vertice<String> p = new Vertice<String>("P");

        Double peso = 1D;

        gr.adicionarVertice(a);
        gr.adicionarVertice(b);
        gr.adicionarVertice(c);
        gr.adicionarVertice(d);
        gr.adicionarVertice(e);
        gr.adicionarVertice(f);
        gr.adicionarVertice(g);
        gr.adicionarVertice(h);
        gr.adicionarVertice(i);
        gr.adicionarVertice(j);
        gr.adicionarVertice(k);
        gr.adicionarVertice(l);
        gr.adicionarVertice(m);
        gr.adicionarVertice(n);
        gr.adicionarVertice(o);
        gr.adicionarVertice(p);

        gr.adicionarArestaNaoDirigida(peso, a, b);
        gr.adicionarArestaNaoDirigida(peso, a, b);

        gr.adicionarArestaNaoDirigida(peso, a, f);
        gr.adicionarArestaNaoDirigida(peso, a, e);
        gr.adicionarArestaNaoDirigida(peso, b, f);
        gr.adicionarArestaNaoDirigida(peso, b, c);
        gr.adicionarArestaNaoDirigida(peso, c, g);
        gr.adicionarArestaNaoDirigida(peso, c, d);
        gr.adicionarArestaNaoDirigida(peso, d, g);
        gr.adicionarArestaNaoDirigida(peso, d, h);
        gr.adicionarArestaNaoDirigida(peso, h, l);
        gr.adicionarArestaNaoDirigida(peso, l, g);
        gr.adicionarArestaNaoDirigida(peso, l, p);
        gr.adicionarArestaNaoDirigida(peso, p, o);
        gr.adicionarArestaNaoDirigida(peso, o, k);
        gr.adicionarArestaNaoDirigida(peso, j, g);
        gr.adicionarArestaNaoDirigida(peso, j, k);
        gr.adicionarArestaNaoDirigida(peso, j, i);
        gr.adicionarArestaNaoDirigida(peso, n, i);
        gr.adicionarArestaNaoDirigida(peso, n, k);
        gr.adicionarArestaNaoDirigida(peso, n, m);
        gr.adicionarArestaNaoDirigida(peso, m, i);
        gr.adicionarArestaNaoDirigida(peso, i, e);
        gr.adicionarArestaNaoDirigida(peso, f, i);
        gr.adicionarArestaNaoDirigida(peso, k, g);

        gr.printMatrizAdjacenciaValor();

    }


    public static void printList(List<Vertice<Integer>> l) {
        for(Vertice<Integer> i : l) {
            System.out.print(i.getData() + " ");
        }
        System.out.println();
    }
}