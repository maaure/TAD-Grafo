public class Maze {
    
    private Grafo<Integer> grafo;
    private Vertice<Integer>[][] vertices;

    @SuppressWarnings("unchecked")
    public Maze(Integer[][] m) {
        this.vertices = new Vertice[m.length][m[0].length];
        grafo = new Grafo<Integer>();


        System.out.println(m.length + " " + m[0].length);
        for(int i = 0; i < m.length; i++) {
            for(int j = 0 ; j < m[0].length; j++) {
                vertices[i][j] = new Vertice<Integer>(m[i][j]);
                grafo.adicionarVertice(vertices[i][j]);
            }
        }

        connectVertices();

        grafo.printMatrizAdjacencia();

    }

    private void connectVertices() {
        for(int i = 1; i < vertices.length - 1; i++) {
            for(int j = 1; j < vertices[0].length - 1; j++) {
                if(vertices[i][j].getData() == 0) {
                    
                    if(vertices[i-1][j].getData() == 0) {
                        grafo.adicionarAresta(null, vertices[i][j], vertices[i-1][j]);
                    }
                    
                    
                    if(vertices[i+1][j].getData() == 0) {
                        grafo.adicionarAresta(null, vertices[i][j], vertices[i+1][j]);
                    }
                    
                    
                    if(vertices[i][j+1].getData() == 0) {
                        grafo.adicionarAresta(null, vertices[i][j], vertices[i][j+1]);
                    }
                

                    if(vertices[i][j-1].getData() == 0) {
                        grafo.adicionarAresta(null, vertices[i][j], vertices[i][j-1]);
                    }
                

                }
            }
        }
    }

}
