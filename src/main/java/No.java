public class No {
    private Integer valor;
    private No esquerda;
    private No direita;
    private int altura;

    public No(Integer valor) {
        this.valor = valor;
        this.altura = 1;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }

    public void atualizarAltura(){
        this.altura++;
    }
}
