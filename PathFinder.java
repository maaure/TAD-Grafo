import java.util.List;

public class PathFinder<T> {
    public void DFS(Grafo<T> g, Vertice<T> u) {
        List<Vertice<T>> e = u.verticesAdjacentes();
        for(Vertice<T> v : e) {
            if(!v.foiVisitada()) {
                
            }
        }
    }
}
