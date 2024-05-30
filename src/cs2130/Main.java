package cs2130;

public class Main {

    public static void main(String[] args) {
	    // write your code here

        int m1[][] = new int[][] {
            {0, 1, 1, 1},
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 1, 0}
        };

        MatrixRelation mr1 = new MatrixRelation(m1);

        System.out.println("--------------------------------------------");
        mr1.show();
        System.out.println();
        mr1.reflexiveClosure().show();
        System.out.println();
        mr1.symmetricClosure().show();
        System.out.println();
        System.out.println("This graph could be a rooted tree: " + mr1.isRootedTree());
        System.out.println("--------------------------------------------");

    }
}
