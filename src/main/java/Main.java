public class Main {
    public static void main(String[] args) {
        ArvoreRubroNegra tree = new ArvoreRubroNegra();

        int[] keys = {10, 20, 30, 15, 5, 25};
        for(int key : keys){
            tree.inserir(key);
        }

        tree.inorder();

        tree.delete(15);
        tree.delete(10);

        tree.inorder();
    }
}
