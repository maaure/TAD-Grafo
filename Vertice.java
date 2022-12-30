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

    public Vertice(T data) {
        this.data = data;
        this.arestasEntrada = new ArrayList<Aresta<T>>();
        this.arestasSaida = new ArrayList<Aresta<T>>();
        this.id = -1;
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
}
