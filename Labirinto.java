import java.util.List;

public class Labirinto {
    
    private Grafo<Integer> grafo;
    private Vertice<Integer>[][] vertices;
    private List<Vertice<Integer>> entradas;
    private List<Vertice<Integer>> saidas;

    @SuppressWarnings("unchecked")
    public Labirinto(Integer[][] m) {
        this.vertices = new Vertice[m.length][m[0].length];
        grafo = new Grafo<Integer>();

        for(int i = 0; i < m.length; i++) {
            for(int j = 0 ; j < m[0].length; j++) {
                vertices[i][j] = new Vertice<Integer>(m[i][j]);
                grafo.adicionarVertice(vertices[i][j]);
            }
        }

        conectarVertices();
        encontrarSaidaseEntradas();

        grafo.printMatrizAdjacencia();

    }

    private void encontrarSaidaseEntradas() {
    List<Vertice<Integer>> vertices = grafo.getListaVertices();
        for(Vertice<Integer> v : vertices) {
            if(v.getData() == 3) {
                saidas.add(v);
            } else if (v.getData() == 2) {
                entradas.add(v);
            }
        }
    }

    private void conectarVertices() {
        for(int i = 1; i < vertices.length - 1; i++) {
            for(int j = 1; j < vertices[0].length - 1; j++) {
                if(vertices[i][j].getData() == 0 || vertices[i][j].getData() == 2) {
                    
                    if(vertices[i-1][j].getData() == 0 || vertices[i-1][j].getData() == 3) {
                        grafo.adicionarAresta(null, vertices[i][j], vertices[i-1][j]);
                    }
                    
                    if(vertices[i+1][j].getData() == 0 || vertices[i+1][j].getData() == 3) {
                        grafo.adicionarAresta(null, vertices[i][j], vertices[i+1][j]);
                    }
                    
                    if(vertices[i][j+1].getData() == 0 || vertices[i][j+1].getData() == 3) {
                        grafo.adicionarAresta(null, vertices[i][j], vertices[i][j+1]);
                    }
                
                    if(vertices[i][j-1].getData() == 0 || vertices[i][j-1].getData() == 3) {
                        grafo.adicionarAresta(null, vertices[i][j], vertices[i][j-1]);
                    }
                

                }
            }
        }
    }

}
