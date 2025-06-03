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

    public int verificarFator(No no) {
        int alturaEsquerda = (noPrincipal == null) ? 0 : noPrincipal.getAltura();
        int alturaDireta = (noPrincipal == null) ? 0 : noPrincipal.getAltura();
        if (no.getEsquerda() != null) {
            verificarFator(no.getEsquerda());
            alturaEsquerda = (no.getEsquerda() != null) ? no.getAltura() : 0;
        }

        if(no.getDireita() != null){
            verificarFator(no.getDireita());
            alturaDireta = (no.getDireita() != null) ? no.getAltura() : 0;
        }

        return ((alturaEsquerda - alturaDireta) == 1 ) ? 1 : alturaEsquerda - alturaDireta;
    }


}
