import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    public Vertice<T> adicionarVertice(T data) {
        Vertice<T> v = new Vertice<T>(data);
        v.setId(getIdNextVertex());
        vertices.add(v);
        adicionarVerticeMatrizAdjacencia(v);
        return v;
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
        inicio.adicionarArestaSaida(a);
        fim.adicionarArestaEntrada(a);
        matrizAdjacencia.get(indexInicio).get(indexFim).add(a);
        arestas.add(a);
        return a;
    }

    public int conseguirEnderecoMatrizAdjacencia(Vertice<T> v) {
        int id = v.getId();
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void removeVertice(Vertice<T> v) {
        int indexVertice = conseguirEnderecoMatrizAdjacencia(v);
        matrizAdjacencia.remove(indexVertice);
        for (int i = 0; i < matrizAdjacencia.size(); i++) {
            matrizAdjacencia.get(i).remove(indexVertice);
        }
        vertices.remove(indexVertice);
    }

    public void removeAresta(Aresta<T> e) {
        int indexInicio = conseguirEnderecoMatrizAdjacencia(e.getInicio());
        int indexFim = conseguirEnderecoMatrizAdjacencia(e.getFim());

        matrizAdjacencia.get(indexInicio).get(indexFim).remove(e);
        arestas.remove(e);
    }

    private void adicionarVerticeMatrizAdjacencia(Vertice<T> v) {
        matrizAdjacencia.add(new ArrayList<Vector<Aresta<T>>>());
        for (ArrayList<Vector<Aresta<T>>> i : matrizAdjacencia) {
            while (i.size() < vertices.size()) {
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
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(matrizAdjacencia.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void printMatrizAdjacenciaQtde() {
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(matrizAdjacencia.get(i).get(j).size() + " ");
            }
            System.out.println();
        }
    }

    public List<Vertice<T>> finalVertices(Aresta<T> e) {
        return e.vertices();
    }

    public Vertice<T> oposto(Vertice<T> v, Aresta<T> e) {
        List<Vertice<T>> vertices = e.vertices();
        if(!vertices.contains(v)) throw new RuntimeException("Vertice não pertence a aresta.");
        return vertices.get(0).equals(v) ? vertices.get(1) : vertices.get(0);
    }

    public boolean isAdjacente(Vertice<T> v, Vertice<T> w) {
        return v.arestasIncidentes().stream().anyMatch(a -> a.getFim().equals(w));
    }

    public void substituir(Vertice<T> v, T x) {
        v.setData(x);
    }

    public void substituir(Aresta<T> e, T x) {
        e.setData(x);
    }

    public List<Aresta<T>> getListaArestas() {
        return Collections.unmodifiableList(this.arestas);
    }


    public List<Vertice<T>> getListaVertices() {
        return Collections.unmodifiableList(this.vertices);
    }

}
