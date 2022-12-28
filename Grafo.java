import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Grafo<T> {

    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;
    private ArrayList<ArrayList<Vector<Aresta<T>>>> matrizAdjacencia;

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
        this.matrizAdjacencia = calcularMatrizAdjacencia(vertices.size());
    }

    /**
     * @param data
     * @return int
     *         Retorna o ID do vertice do dado recém inserido
     */
    public int adicionarVertice(T data) {
        Vertice<T> v = new Vertice<T>(data);
        v.setId(vertices.size());
        vertices.add(v);
        adicionarVerticeMatrizAdjacencia(v);
        return v.getId();
    }

    public void adicionarVerticeMatrizAdjacencia(Vertice<T> v) {
        
    }

    private ArrayList<ArrayList<Vector<Aresta<T>>>> calcularMatrizAdjacencia(Integer nVertices) {
        ArrayList<ArrayList<Vector<Aresta<T>>>> matrizAdjacencia = new ArrayList<>();
        for (int i = 0; i < nVertices; i++) {
            ArrayList<Vector<Aresta<T>>> l = new ArrayList<>();
            for (int j = 0; j < nVertices; j++) {
                l.add(new Vector<Aresta<T>>());
            }
            matrizAdjacencia.add(l);
        }
        return matrizAdjacencia;
    }

    public void printVertices() {
        for (Vertice<T> v : vertices) {
            System.out.print(v.getId() + ": " + v.getData() + " ");
        }
        System.out.println();
    }

    public void printMatrizAdjacencia() {
        Iterator<ArrayList<Vector<Aresta<T>>>> it = this.matrizAdjacencia.iterator();
        while (it.hasNext()) {
            ArrayList<Vector<Aresta<T>>> v = it.next();
            for (int i = 0; i < v.size(); i++) {
                System.out.print(v.get(i) + " ");
            }
            System.out.println();
        }
    }

}
