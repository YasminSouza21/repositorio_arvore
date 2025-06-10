public class Main {
    public static void main(String[] args) {
        ArvoreAvl arvoreAvl = new ArvoreAvl(new No(5));

        int[] chaves = {10, 20, 30, 40, 60, 25};

        for(int chave : chaves){
            arvoreAvl.inserir(arvoreAvl.getNoPrincipal(), chave);
        }

        System.out.println("Percurso em ordem da árvore AVL");

        arvoreAvl.emOrdem();
    }
}
