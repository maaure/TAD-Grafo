import java.util.ArrayList;

public class Grafo<T> {
    
    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;

    public Grafo() {
        this.vertices = new ArrayList<Vertice<T>>();
        this.arestas = new ArrayList<Aresta<T>>();
    }

    public void adicionarVertice(T data) {
         Vertice<T> novoVertice = new Vertice<T>(data);
         this.vertices.add(novoVertice);
    }

    public void adicionarAresta(Double peso, T inicio, T fim) {

    }

}
