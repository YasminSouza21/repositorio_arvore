public class ArvoreRubroNegra {
    private NoArvoreRubroNegra noPrincipal;

    public ArvoreRubroNegra(){}

    public void inserir(int valor) {
        noPrincipal = inserir(noPrincipal, valor);
        noPrincipal.setCor(Cores.PRETO);
    }

    private NoArvoreRubroNegra inserir(NoArvoreRubroNegra no, int valor) {
        if (no == null) {
            return new NoArvoreRubroNegra(valor, Cores.VERMELHO);
        }
        if (valor < no.getValor()) {
            no.setEsquerda(inserir(no.getEsquerda(), valor));
        } else if (valor > no.getValor()) {
            no.setDireita(inserir(no.getDireita(), valor));
        }
        return no;
    }
}
