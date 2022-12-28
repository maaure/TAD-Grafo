import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Grafo<T> {
    
    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;
    private ArrayList<ArrayList<Vector<Aresta<T>>>> matrizAdjacencia;


    public Grafo(ArrayList<Vertice<T>> vertices, ArrayList<Aresta<T>> arestas) {
        this.vertices = vertices;
        this.arestas = arestas;
        this.matrizAdjacencia = calcularMatrizAdjacencia(vertices.size());
    }


    private ArrayList<ArrayList<Vector<Aresta<T>>>> calcularMatrizAdjacencia(Integer nVertices) {
        ArrayList<ArrayList<Vector<Aresta<T>>>> matrizAdjacencia = new ArrayList<>();
        for(int i = 0; i < nVertices; i++) {
            ArrayList<Vector<Aresta<T>>> l = new ArrayList<>();
            for(int j = 0; j < nVertices; j++) {
                l.add(new Vector<Aresta<T>>());
            }
            matrizAdjacencia.add(l);
        }
        return matrizAdjacencia;
    }

    public void printMatrizAdjacencia() {
        Iterator<ArrayList<Vector<Aresta<T>>>> it = this.matrizAdjacencia.iterator();
        while(it.hasNext()) {
            ArrayList<Vector<Aresta<T>>> v = it.next();
            for(int i = 0; i < v.size(); i++) {
                System.out.print(v.get(i) + " ");
            }
            System.out.println();
        }
    }
    


}
