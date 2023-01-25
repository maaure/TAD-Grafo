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
    private double distancia;
    private Vertice<T> anterior;
    private Integer x;
    private Integer y;
    private List<Vertice<T>> anteriores;
    private double f;
    private double g;
    private double h;

    
    public Vertice(T data) {
        this.data = data;
        this.arestasEntrada = new ArrayList<Aresta<T>>();
        this.arestasSaida = new ArrayList<Aresta<T>>();
        this.id = -1;
        this.visitada = false;
        this.anteriores = new ArrayList<Vertice<T>>();
        this.f = 0;
        this.g = 0;
        this.h = 0;
    }

    public void setX(Integer x) {
        this.x = x;
    }
    public void setY(Integer y) {
        this.y = y;
    }

    public List<Vertice<T>> getAnteriores() {
        return this.anteriores;
    }

    public void setAnteriores(List<Vertice<T>> anteriores) {
        this.anteriores = anteriores;
    }

    public void addAnterior(Vertice<T> v) {
        this.anteriores.add(v);
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


    public boolean isVisitada() {
        return this.visitada;
    }

    public boolean getVisitada() {
        return this.visitada;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Vertice<T> getAnterior() {
        return this.anterior;
    }

    public void setAnterior(Vertice<T> anterior) {
        this.anterior = anterior;
    }

    public void setCoordenadas(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }


    public double getF() {
        return this.f;
    }

    public void setF(double f) {
        this.f = f;
    }

    public double getG() {
        return this.g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getH() {
        return this.h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public void calcularG(double g_calc) {
        Vertice<T> v = this;
        while(v != null) {
            g_calc += v.getG();
            v = v.getAnterior();
        }
        this.g = g_calc;
    }
    
}
