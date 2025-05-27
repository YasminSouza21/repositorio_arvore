public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        arvore.inserir(10);
        arvore.inserir(8);
        arvore.inserir(12);
        arvore.inserir(11);
        arvore.inserir(7);
        arvore.inserir(9);
        arvore.inserir(13);

        arvore.countPosOrder();
    }
}
