public class ArvoreAvl {

    private No noPrincipal;

    public No getNoPrincipal() {
        return noPrincipal;
    }

    public void setNoPrincipal(No noPrincipal) {
        this.noPrincipal = noPrincipal;
    }

    public ArvoreAvl(No no) {
        this.noPrincipal = no;
    }

    public int altura(No no) {
        if (no == null) return 0;
        return  Math.max(altura(no.getEsquerda()), altura(no.getDireita()));
    }

    public int verificarFator(No no) {
        if (no == null) return 0;

        int alturaEsquerda = altura(no.getEsquerda());
        int alturaDireita = altura(no.getDireita());

        return alturaEsquerda - alturaDireita;
    }

    public No rotacaoDireita(No no){
        No noEsquerda = no.getEsquerda();
        No varTemp = noEsquerda.getDireita();

        noEsquerda.setDireita(no);
        no.setEsquerda(varTemp);

        no.setAltura(Math.max(altura(no.getEsquerda()), altura(no.getDireita()) +1));

        return  noEsquerda;
    }

    public No inserir(No no, int chave){
        if(no == null){
            return new No(chave);
        }

        if(chave < no.getValor()){
            noPrincipal = inserir(no.getEsquerda(), chave);
        } else if(chave > no.getValor()){
            noPrincipal = inserir(no.getDireita(), chave);
        } else{
            return no;
        }

        noPrincipal.setAltura(1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita())));

        int balanceamento = verificarFator(no);

        if(balanceamento > 1 && chave < no.getEsquerda().getValor()){
            return rotacaoDireita(no);
        }

        if(balanceamento > 1 && chave > no.getEsquerda().getValor()){
            return rotacaoDireita(no);
        }

        return no;
    }

    public void emOrdem() {
        emOrdem(this.noPrincipal);
    }

    private void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.getEsquerda());
            System.out.print(no.getValor() + " ");
            emOrdem(no.getDireita());
        }
    }


}
