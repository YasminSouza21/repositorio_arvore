public class Arvore {
    private No noRaiz;
    private Arvore arvoreDireita;
    private Arvore arvoreEsquerda;

    public Arvore() {
        this.noRaiz = null;
        this.arvoreDireita = null;
        this.arvoreEsquerda = null;
    }

    public Arvore(Integer valorNoRaiz) {
        this.noRaiz = new No(valorNoRaiz);
        this.arvoreDireita = null;
        this.arvoreEsquerda = null;
    }

    public void inserir(Integer valor) {
        if (this.noRaiz == null) {
            this.noRaiz = new No(valor);
            System.out.println("add nó " + valor + " raiz");
        } else if(valor < this.noRaiz.getValor()){
            if (this.arvoreEsquerda == null) {
                this.arvoreEsquerda = new Arvore(valor);
                System.out.println("add no " + valor + " a esquerda do no " + this.noRaiz.getValor());
            } else {
                this.arvoreEsquerda.inserir(valor);
            }
        } else {
            if(this.arvoreDireita == null){
                this.arvoreDireita = new Arvore(valor);
                System.out.println("add no " + valor + " a direita do no " + this.noRaiz.getValor());
            } else {
                this.arvoreDireita.inserir(valor);
            }
        }

    }

    public Integer count(){
        if(this.noRaiz == null){
            return  0;
        }

        int count = 1;
        if(this.arvoreEsquerda != null){
            count += this.arvoreEsquerda.count();
        }

        if(this.arvoreDireita != null){
            count += this.arvoreDireita.count();
        }

        return count;
    }
}
