import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Vertice<T> {
    private Integer id;
    private T data;
    private ArrayList<Aresta<T>> arestasEntrada;
    private ArrayList<Aresta<T>> arestasSaida;
    private boolean visitada;

    public Vertice(T data) {
        this.data = data;
        this.arestasEntrada = new ArrayList<Aresta<T>>();
        this.arestasSaida = new ArrayList<Aresta<T>>();
        this.id = -1;
        this.visitada = false;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void adicionarArestaEntrada(Aresta<T> aresta) {
        this.arestasEntrada.add(aresta);
    }

    public void adicionarArestaSaida(Aresta<T> aresta) {
        this.arestasSaida.add(aresta);
    }

    public List<Aresta<T>> arestasIncidentes() {
        return Collections.unmodifiableList(Stream.concat(arestasEntrada.stream(), arestasSaida.stream()).collect(Collectors.toList()));
    }

    public List<Aresta<T>> arestasSaida() {
        return Collections.unmodifiableList(arestasSaida);
    }

    public List<Vertice<T>> verticesAdjacentes() {
        List<Vertice<T>> vs = new ArrayList<>();
        for(Aresta<T> a : arestasSaida) {
            vs.add(a.getFim());
        }
        return vs;
    }


    public ArrayList<Aresta<T>> getArestasEntrada() {
        return this.arestasEntrada;
    }

    public void setArestasEntrada(ArrayList<Aresta<T>> arestasEntrada) {
        this.arestasEntrada = arestasEntrada;
    }

    public ArrayList<Aresta<T>> getArestasSaida() {
        return this.arestasSaida;
    }

    public void setArestasSaida(ArrayList<Aresta<T>> arestasSaida) {
        this.arestasSaida = arestasSaida;
    }

    public boolean foiVisitada() {
        return this.visitada;
    }

    public void setVisitada(boolean visitada) {
        this.visitada = visitada;
    }

}
