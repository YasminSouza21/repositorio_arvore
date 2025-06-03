public class No {
    private Integer valor;
    private int altura;

    public No(Integer valor) {
        this.valor = valor;
        this.altura = 0;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }

    public void atualizarAltura(){
        this.altura++;
    }
}
