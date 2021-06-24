import java.util.ArrayList;
import java.util.Random;

public class RemoveTest {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        Random random = new Random();
        int n = 100;

        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        //test removeMin
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (!bst.isEmpty()) {
            arrayList.add(bst.removeMin());
        }

        System.out.println(arrayList);
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i-1)>arrayList.get(i)) {
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("removeMin test completed");

    }
}
