import java.util.ArrayList;

public class SortingAlgorithm {
    private static ArrayList<Integer> myArr = new ArrayList<Integer>();
    private static ArrayList<Integer> myArr2 = new ArrayList<Integer>();

    public static void main(String[] args) {
        // ArrayList 1
        myArr.add(45);
        myArr.add(21);
        myArr.add(52);
        myArr.add(61);
        myArr.add(9);
        myArr.add(15);
        myArr.add(45);
        myArr.add(21);
        myArr.add(52);
        myArr.add(61);
        myArr.add(9);
        myArr.add(15);

        // ArrayList2
        myArr2.add(45);
        myArr2.add(21);
        myArr2.add(52);
        myArr2.add(61);
        myArr2.add(9);
        myArr2.add(15);
        


        /**
         * Bubble sorting algorithm below
         */
        System.out.println(myArr.toString());

        boolean isSorted = true;
        int holder;

        do {
            isSorted = true;

            for (int i = 0; i < myArr.size() - 1; i++) {
                if (myArr.get(i) > myArr.get(i + 1)) {
                    holder = myArr.get(i);
                    myArr.set(i, myArr.get(i + 1));
                    myArr.set(i + 1, holder);
                    isSorted = false;
                }
            }
        } while(!isSorted);

        System.out.println(myArr.toString());


        /**
         * Selection sorting algorithm below
         */
        System.out.println(myArr2.toString());

        int swapIndex = 0;

        for(int i = 0; i < myArr2.size(); i++) {
            int minValue = myArr2.get(i);

            for(int j = i; j < myArr2.size(); j++) {
                if(myArr2.get(j) < minValue) {
                    minValue = myArr2.get(j);
                    swapIndex = j;
                }
            }

            myArr2.set(swapIndex, myArr2.get(i));
            myArr2.set(i, minValue);
        }

        System.out.println(myArr2.toString());

    }
}
