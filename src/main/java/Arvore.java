public class Arvore {
    private No noRaiz;
    private Arvore arvoreDireita;
    private Arvore arvoreEsquerda;

    public Arvore() {
        this.noRaiz = null;
        this.arvoreDireita = null;
        this.arvoreEsquerda = null;
    }

    public Arvore(Integer valorNoRaiz){
        this.noRaiz = new No(valorNoRaiz);
        this.arvoreDireita = null;
        this.arvoreEsquerda = null;
    }



}
