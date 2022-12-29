import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Grafo<T> {

    private static int index = 0;
    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;
    private ArrayList<ArrayList<Vector<Aresta<T>>>> matrizAdjacencia;

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
        this.matrizAdjacencia = new ArrayList<ArrayList<Vector<Aresta<T>>>>();
    }

    private static int getIdNextVertex() {
        return ++index;
    }

    /**
     * @param data
     * @return int
     *         Retorna o ID do vertice do dado recém inserido
     */
    public int adicionarVertice(T data) {
        Vertice<T> v = new Vertice<T>(data);
        v.setId(getIdNextVertex());
        vertices.add(v);
        adicionarVerticeMatrizAdjacencia(v);
        return v.getId();
    }

    public Vertice<T> adicionarVertice(Vertice<T> v) {
        v.setId(getIdNextVertex());
        vertices.add(v);
        adicionarVerticeMatrizAdjacencia(v);
        return v;
    }

    public Aresta<T> adicionarAresta(Double peso, Vertice<T> inicio, Vertice<T> fim) {
        Aresta<T> a = new Aresta<T>(peso, inicio, fim);
        int indexInicio = conseguirEnderecoMatrizAdjacencia(inicio);
        int indexFim = conseguirEnderecoMatrizAdjacencia(fim);
        matrizAdjacencia.get(indexInicio).get(indexFim).add(a);
        return a;
    }


    public int conseguirEnderecoMatrizAdjacencia(Vertice<T> v) {
        int id = v.getId();
        for(int i = 0; i < vertices.size(); i++) {
            if(vertices.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void adicionarVerticeMatrizAdjacencia(Vertice<T> v) {
        matrizAdjacencia.add(new ArrayList<Vector<Aresta<T>>>());
        for(ArrayList<Vector<Aresta<T>>> i : matrizAdjacencia) {
            while(i.size() < vertices.size()) {
                i.add(new Vector<Aresta<T>>());
            }
        }

    }

    public void printVertices() {
        for (Vertice<T> v : vertices) {
            System.out.print("[" + v.getId() + ": " + v.getData() + "] ");
        }
        System.out.println();
    }

    public void printMatrizAdjacencia() {
        for(int i = 0; i < vertices.size(); i++) {
            for(int j = 0; j < vertices.size(); j++) {
                System.out.print(matrizAdjacencia.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
