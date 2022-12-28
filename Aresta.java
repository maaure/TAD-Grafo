public class Aresta<T> {
    private Double peso;
    private Vertice<T> inicio;
    private Vertice<T> fim;
    private Boolean direcionado;


    public Aresta(Double peso, Vertice<T> inicio, Vertice<T> fim) {
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
        this.direcionado = false;
    }

    public void setDirecionado(Boolean isDirecionado) {
        this.direcionado = isDirecionado;
    }

    public Boolean isDirecionado() {
        return this.direcionado;
    }

    public Double getPeso() {
        return this.peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Vertice<T> getInicio() {
        return this.inicio;
    }

    public void setInicio(Vertice<T> inicio) {
        this.inicio = inicio;
    }

    public Vertice<T> getFim() {
        return this.fim;
    }

    public void setFim(Vertice<T> fim) {
        this.fim = fim;
    }

    
}
