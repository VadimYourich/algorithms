package lesson4;

public class Lesson4Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(22);
        tree.add(3);
        tree.add(5);
        tree.add(12);
        tree.add(7);
        tree.add(11);
        tree.add(10);
        tree.add(13);
        tree.add(15);
        tree.add(4);
        tree.add(8);
    
        tree.printTree();
    }
    
}
