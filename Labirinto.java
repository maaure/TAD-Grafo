import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Labirinto {

    private Grafo<Integer> grafo;
    private Vertice<Integer>[][] vertices;
    private List<Vertice<Integer>> entradas;
    private Vertice<Integer> saida;
    private final double INFINITO = Double.MAX_VALUE;
    private List<List<Vertice<Integer>>> caminhos;

    @SuppressWarnings("unchecked")
    public Labirinto(Integer[][] m) {
        this.entradas = new ArrayList<>();
        this.vertices = new Vertice[m.length][m[0].length];
        this.caminhos = new ArrayList<List<Vertice<Integer>>>();
        grafo = new Grafo<Integer>();

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] != 1) {
                    vertices[i][j] = new Vertice<Integer>(m[i][j]);
                    vertices[i][j].setCoordenadas(i, j);
                    grafo.adicionarVertice(vertices[i][j]);
                }
            }
        }

        conectarVertices();
        encontrarSaidaseEntradas();

        // grafo.printMatrizAdjacencia();

    }

    public void a_star() {
        List<Vertice<Integer>> aberta = new ArrayList<Vertice<Integer>>();
        List<Vertice<Integer>> fechada = new ArrayList<Vertice<Integer>>();
        Vertice<Integer> entrada = entradas.get(0);
        aberta.add(entrada);

        while (true) {
            Vertice<Integer> k = aberta.stream().min((a, b) -> Double.compare(a.getF(), b.getF())).get();
            aberta.remove(k);
            fechada.add(k);
            k.setVisitada(true);

            for (Vertice<Integer> v : k.getArestasSaida().stream().map(a -> a.getFim()).collect(Collectors.toList())) {
                if (fechada.contains(v))
                    continue;
                if (!aberta.contains(v)) {
                    aberta.add(v);
                    v.setAnterior(k);
                    v.calcularG(grafo.getAresta(k, v).getPeso());
                    v.setH(calcularH(v, saida));
                    v.setF(v.getH() + v.getG());
                } else {
                    if (v.getG() < k.getG()) {
                        v.setAnterior(k);
                        v.calcularG(grafo.getAresta(v, k).getPeso());
                        v.setF(v.getH() + v.getG());
                    }
                }

            }
            if (k.getData() == 3) {
                break;
            }
        }
    }

    public double calcularH(Vertice<Integer> v, Vertice<Integer> saida) {
        return calcularDistanciaManhattan(v.getX(), v.getY(), saida.getX(), saida.getY());
    }

    public double calcularDistanciaEuclidiana(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - y1, 2) + Math.pow(x2 - y2, 2));
    }

    public double calcularDistanciaManhattan(double x1, double y1, double x2, double y2) {
        return Math.abs(x1 - y1) + Math.abs(x2 - y2);
    }

    public void dijkstra() {
        Vertice<Integer> in = entradas.get(0);
        List<Vertice<Integer>> Q = new ArrayList<Vertice<Integer>>();
        List<Vertice<Integer>> nuvem = new ArrayList<Vertice<Integer>>();
        for (Vertice<Integer> v : grafo.getListaVertices()) {
            v.setDistancia(INFINITO);
            v.setAnterior(null);
            Q.add(v);
        }
        in.setDistancia(0);

        while (!Q.isEmpty()) {
            Vertice<Integer> u = Q.stream().min((a, b) -> Double.compare(a.getDistancia(), b.getDistancia())).get();
            Q.remove(u);
            u.setVisitada(true);
            nuvem.add(u);

            for (Vertice<Integer> v : u.getArestasSaida().stream().map(a -> a.getFim()).collect(Collectors.toList())) {
                double alt = u.getDistancia() + grafo.getAresta(u, v).getPeso();
                if (alt < v.getDistancia()) {
                    v.setDistancia(alt);
                    v.setAnterior(u);
                }
            }
        }
    }

    public void printListaVerticesComDistancia() {
        for (Vertice<Integer> v : grafo.getListaVertices()) {
            System.out.println("[" + v.getX() + ", " + v.getY() + "]: " + v.getDistancia());
        }
    }

    private void encontrarSaidaseEntradas() {
        List<Vertice<Integer>> vertices = grafo.getListaVertices();
        for (Vertice<Integer> v : vertices) {
            if (v.getData() == 3) {
                saida = v;
            } else if (v.getData() == 2) {
                entradas.add(v);
            }
        }
    }

    private void conectarVertices() {
        for (int i = 1; i < vertices.length - 1; i++) {
            for (int j = 1; j < vertices[0].length - 1; j++) {
                if (Objects.nonNull(vertices[i][j])
                        && (vertices[i][j].getData() == 0 || vertices[i][j].getData() == 2)) {

                    if (Objects.nonNull(vertices[i - 1][j])
                            && (vertices[i - 1][j].getData() == 0 || vertices[i - 1][j].getData() == 3)) {
                        grafo.adicionarAresta(10, vertices[i][j], vertices[i - 1][j]);
                    }

                    if (Objects.nonNull(vertices[i + 1][j])
                            && (vertices[i + 1][j].getData() == 0 || vertices[i + 1][j].getData() == 3)) {
                        grafo.adicionarAresta(10, vertices[i][j], vertices[i + 1][j]);
                    }

                    if (Objects.nonNull(vertices[i][j + 1])
                            && (vertices[i][j + 1].getData() == 0 || vertices[i][j + 1].getData() == 3)) {
                        grafo.adicionarAresta(10, vertices[i][j], vertices[i][j + 1]);
                    }

                    if (Objects.nonNull(vertices[i][j - 1])
                            && (vertices[i][j - 1].getData() == 0 || vertices[i][j - 1].getData() == 3)) {
                        grafo.adicionarAresta(10, vertices[i][j], vertices[i][j - 1]);
                    }

                    // diagonais

                    if (Objects.nonNull(vertices[i - 1][j - 1])
                            && (vertices[i - 1][j - 1].getData() == 0 || vertices[i - 1][j - 1].getData() == 3)) {
                        grafo.adicionarAresta(14, vertices[i][j], vertices[i - 1][j - 1]);
                    }

                    if (Objects.nonNull(vertices[i + 1][j + 1])
                            && (vertices[i + 1][j + 1].getData() == 0 || vertices[i + 1][j + 1].getData() == 3)) {
                        grafo.adicionarAresta(14, vertices[i][j], vertices[i + 1][j + 1]);
                    }

                    if (Objects.nonNull(vertices[i - 1][j + 1])
                            && (vertices[i - 1][j + 1].getData() == 0 || vertices[i - 1][j + 1].getData() == 3)) {
                        grafo.adicionarAresta(14, vertices[i][j], vertices[i - 1][j + 1]);
                    }

                    if (Objects.nonNull(vertices[i - 1][j - 1])
                            && (vertices[i - 1][j - 1].getData() == 0 || vertices[i - 1][j - 1].getData() == 3)) {
                        grafo.adicionarAresta(14, vertices[i][j], vertices[i - 1][j - 1]);
                    }

                }
            }
        }
    }

    public void listarCaminhosSaida() {
        Vertice<Integer> prev = saida;
        List<Vertice<Integer>> caminho = new ArrayList<>();
        while (prev != null) {
            this.vertices[prev.getX()][prev.getY()].setCaminho();
            caminho.add(prev);
            prev = prev.getAnterior();
        }
        Collections.reverse(caminho);
        caminhos.add(caminho);
    }

    public Vertice<Integer> acharNaMatriz(Vertice<Integer> v) {
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices[0].length; j++) {
                if (Objects.nonNull(this.vertices[i][j]) && this.vertices[i][j].equals(v))
                    return this.vertices[i][j];
            }
        }
        return null;
    }

    public void mostrarCaminhosSaida() {
        for (List<Vertice<Integer>> l : caminhos) {
            for (int i = 0; i < l.size(); i++) {
                if (i == 0) {
                    System.out.print("[" + l.get(i).getX() + ", " + l.get(i).getY() + "] -> ");
                }
                System.out.print("(" + l.get(i).getX() + ", " + l.get(i).getY() + ")");
                if (i != l.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    public Vertice<Integer>[][] vertices() {
        return this.vertices;
    }

    public void printLabirinto() {
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices[0].length; j++) {
                if (Objects.isNull(vertices[i][j])) {
                    System.out.print("\u001B[44m1");
                    continue;
                }

                if (vertices[i][j].isVisitada())
                    System.out.print("\033[0m\u001B[41m");

                if (vertices[i][j].isCaminho())
                    System.out.print("\033[0m\u001B[42m");


                System.out.print(vertices[i][j].getData() + "\033[0m");
            }
            System.out.println("\033[0m");
        }
    }

}
