public class Main {
    public static void main(String[] args) {
        ArvoreAvl arvoreAvl = new ArvoreAvl(new No(5));

        System.out.println(arvoreAvl.verificarFator(arvoreAvl.getNoPrincipal()));
    }
}
