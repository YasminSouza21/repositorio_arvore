import java.awt.*;

public class ArvoreRubroNegra {
    private NoArvoreRubroNegra noPrincipal;
    private  final NoArvoreRubroNegra NIL;

    public ArvoreRubroNegra(){
        NIL = new NoArvoreRubroNegra(-1);
        NIL.setCor(Cores.PRETO);
        noPrincipal = NIL;
    }

    public void leftRotate(NoArvoreRubroNegra x){
        NoArvoreRubroNegra y = x.getDireita();
        x.setDireita(y.getEsquerda());
        if(y.getDireita() != NIL) y.getEsquerda().setParent(x);

        y.setParent(x.getParent());

        if(x.getParent() == null) noPrincipal = y;
        else if(x == x.getParent().getEsquerda()) x.setParent(y);
        else x.getParent().setDireita(y);

        y.setEsquerda(x);
        x.setParent(y);
    }

    public void rightRotate(NoArvoreRubroNegra y){
        NoArvoreRubroNegra x = y.getEsquerda();
        y.setEsquerda(x.getDireita());

        if(x.getDireita() != NIL) x.getDireita().setParent(y);

        x.setParent(y.getParent());

        if(y.getParent() == null) noPrincipal = x;
        else if(y == y.getParent().getDireita()) y.getParent().setDireita(x);
        else y.getParent().setEsquerda(x);

        x.setDireita(y);
        y.setParent(x);
    }

    public void inserir(int valor){
        NoArvoreRubroNegra no = new NoArvoreRubroNegra(valor);

        NoArvoreRubroNegra  y = null;
        NoArvoreRubroNegra x = noPrincipal;

        while(x != NIL){
            y = x;
            if(no.getValor() < x.getValor()) x = x.getEsquerda();
            else x = x.getDireita();
        }

        no.setParent(y);
        if(y == null) noPrincipal = no;
        else if (no.getValor() < y.getValor()) y.setEsquerda(noPrincipal);
        else y.setDireita(no);

        no.setEsquerda(NIL);
        no.setDireita(NIL);
        no.setCor(Cores.VERMELHO);

        insertFix(no);
    }

    private void insertFix(NoArvoreRubroNegra k){
        while(k.getParent() != null && k.getParent().getCor() == Cores.VERMELHO){
            if(k.getParent() == k.getParent().getParent().getEsquerda()){
                NoArvoreRubroNegra u = k.getParent().getParent().getDireita();
                if(u.getCor() == Cores.VERMELHO){
                    k.getParent().setCor(Cores.PRETO);
                    u.setCor(Cores.PRETO);
                    k.getParent().getParent().setCor(Cores.VERMELHO);
                    k = k.getParent().getParent();
                } else {
                    if(k == k.getParent().getDireita()){
                        k = k.getParent();
                        leftRotate(k);
                    }
                    k.getParent().setCor(Cores.PRETO);
                    k.getParent().getParent().setCor(Cores.VERMELHO);
                    rightRotate(k.getParent().getParent());
                }
            }else {
                NoArvoreRubroNegra u = k.getParent().getParent().getEsquerda();
                if(u.getCor() == Cores.VERMELHO){
                    k.getParent().setCor(Cores.PRETO);
                    u.setCor(Cores.VERMELHO);
                    k.getParent().getParent().setCor(Cores.VERMELHO);
                    k = k.getParent().getParent();
                } else {
                    if(k == k.getParent().getEsquerda()){
                        k = k.getParent();
                        rightRotate(k);
                    }
                    k.getParent().setCor(Cores.PRETO);
                    k.getParent().getParent().setCor(Cores.VERMELHO);
                    leftRotate(k.getParent().getParent());
                }
            }
            if(k == noPrincipal) break;
        }
        noPrincipal.setCor(Cores.PRETO);
    }

    private void transplant(NoArvoreRubroNegra u, NoArvoreRubroNegra v){
        if(u.getParent() == null) noPrincipal = v;
        else  if (u == u.getParent().getEsquerda()) u.getParent().setParent(v);
        else u.getParent().setDireita(v);

        v.setParent(u.getParent());
    }

    private NoArvoreRubroNegra minimum(NoArvoreRubroNegra no){
        while(no.getEsquerda() != NIL) noPrincipal = noPrincipal.getEsquerda();
        return no;
    }

    public void delete(int valor){
        NoArvoreRubroNegra z = searchTree(noPrincipal, valor);
        if(z == NIL) return;

        NoArvoreRubroNegra y = z;
        Cores yOriginalColor = y.getCor();
        NoArvoreRubroNegra x;

        if(z.getEsquerda() == null){
            x = z.getDireita();
            transplant(z, z.getDireita());
        } else if(z.getDireita() == NIL){
            x = z.getEsquerda();
            transplant(z, z.getEsquerda());
        } else {
            y = minimum(z.getDireita());
            yOriginalColor = y.getCor();
            x = y.getDireita();
            if(y.getParent() == z) x.setParent(y);
            else {
                transplant(y, y.getDireita());
                y.setDireita(z.getDireita());
                y.getDireita().setParent(y);
            }
            transplant(z, y);
            y.setEsquerda(z.getEsquerda());
            y.getEsquerda().setParent(y);
            y.setCor(z.getCor());
        }

        if(yOriginalColor == Cores.PRETO) deleteFix(x);
    }

    private void deleteFix(NoArvoreRubroNegra x){
        NoArvoreRubroNegra w;
        while(x != noPrincipal && x.getCor() == Cores.PRETO){
            if(x == x.getParent().getEsquerda()){
                w = x.getParent().getDireita();
                if(w.getCor() == Cores.VERMELHO){
                    w.setCor(Cores.PRETO);
                    x.getParent().setCor(Cores.VERMELHO);
                    leftRotate(x.getParent());
                    w = x.getParent().getDireita();
                }
                if(w.getEsquerda().getCor() == Cores.PRETO && w.getDireita().getCor() == Cores.PRETO){
                    w.setCor(Cores.VERMELHO);
                    x = x.getParent();
                } else {
                    if(w.getDireita().getCor() == Cores.PRETO){
                        w.getEsquerda().setCor(Cores.PRETO);
                        w.setCor(Cores.VERMELHO);
                        rightRotate(w);
                        w = x.getParent().getDireita();
                    }
                    w.setCor(x.getParent().getCor());
                    x.getParent().setCor(Cores.PRETO);
                    w.getDireita().setCor(Cores.PRETO);
                    leftRotate(x.getParent());
                    x = noPrincipal;
                }
            } else {
                w = x.getParent().getEsquerda();
                if(w.getCor() == Cores.VERMELHO){
                    w.setCor(Cores.PRETO);
                    x.getParent().setCor(Cores.VERMELHO);
                    rightRotate(x.getParent());
                    w = x.getParent().getEsquerda();
                }
                if(w.getDireita().getCor() == Cores.PRETO && w.getEsquerda().getCor() == Cores.PRETO){
                    w.setCor(Cores.VERMELHO);
                    x = x.getParent();
                } else {
                    if(w.getEsquerda().getCor() == Cores.PRETO){
                        w.getDireita().setCor(Cores.PRETO);
                        w.setCor(Cores.VERMELHO);
                        leftRotate(w);
                        w = x.getParent().getEsquerda();
                    }
                    w.setCor(x.getParent().getCor());
                    x.getParent().setCor(Cores.PRETO);
                    x.getEsquerda().setCor(Cores.PRETO);
                    rightRotate(x.getParent());
                    x = noPrincipal;
                }
            }

        }
        x.setCor(Cores.PRETO);
    }

    private NoArvoreRubroNegra searchTree(NoArvoreRubroNegra no, int valor){
        if(no == NIL || valor == no.getValor()) return no;
        if(valor < no.getValor()) return  searchTree(no.getEsquerda(), valor);
        return  searchTree(no.getDireita(), valor);
    }

    public void inorder(){
        inorderHelper(noPrincipal);
        System.out.println();
    }

    private void inorderHelper(NoArvoreRubroNegra no){
        if(no != NIL){
            inorderHelper(no.getEsquerda());
            String colorSuffix = (no.getCor() == Cores.VERMELHO) ? "R" : "B";
            System.out.println(no.getValor() + colorSuffix + " ");
            inorderHelper(no.getDireita());
        }
    }


}
