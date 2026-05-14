import java.util.LinkedList;

public class HashTable {

    int size = 10;

    Integer[] linear = new Integer[size];
    Integer[] quadratic = new Integer[size];
    Integer[] doubleHash = new Integer[size];

    LinkedList<Integer>[] chain = new LinkedList[size];

    public HashTable() {

        for (int i = 0; i < size; i++) {
            chain[i] = new LinkedList<Integer>();
        }
    }

    int hash(int x) {
        return x % size;
    }

    int hash2(int x) {
        return 7 - (x % size);
    }

    // Linear Probing
    public void insertLinear(int x) {

        int i = hash(x);

        while (linear[i] != null) {
            i = (i + 1) % size;
        }

        linear[i] = x;
    }

    // Quadratic
    public void insertQuadratic(int x) {

        int i = hash(x);
        int j = 1;

        while (quadratic[i] != null) {
            i = (hash(x) + j * j) % size;
            j++;
        }

        quadratic[i] = x;
    }

    // Double Hashing
    public void insertDouble(int x) {

        int i = hash(x);
        int step = hash2(x);

        while (doubleHash[i] != null) {
            i = (i + step) % size;
        }

        doubleHash[i] = x;
    }

    // Separate Chaining
    public void insertChain(int x) {
        chain[hash(x)].add(x);
    }

    public void display() {

        System.out.println("\nLinear Probing:");
        for (int i = 0; i < size; i++)
            System.out.println(i + " => " + linear[i]);

        System.out.println("\nQuadratic Probing:");
        for (int i = 0; i < size; i++)
            System.out.println(i + " => " + quadratic[i]);

        System.out.println("\nDouble Hashing:");
        for (int i = 0; i < size; i++)
            System.out.println(i + " => " + doubleHash[i]);

        System.out.println("\nSeparate Chaining:");
        for (int i = 0; i < size; i++)
            System.out.println(i + " => " + chain[i]);
    }
}