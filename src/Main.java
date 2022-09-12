import java.util.Random;

public class Main {

    private static Integer[] integerTestList = new Integer[10];
    private static int minValueIndex = 0;

    private static void testListInitialization() {
        Random value = new Random();
        for (int i = 0; i < integerTestList.length; i++) {
            integerTestList[i] = value.nextInt(0, 100);
        }
    }
    private static void swap(Integer[] array, int from, int to){
        int temp = array[to];
        array[to] = array[from];
        array[from] = temp;
    }
    private static void sortingByInsert(Integer[] array){
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }
    private static void bubbleSorting(Integer[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length-1; j > i; j--) {
                if (array[j] < array[i]){
                    swap(array,j,i);
                }
            }
        }
    }
    private static void sortingBySelection(Integer[] array){
        int size = size();
        for (int i = 0; i < size; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[minValueIndex]) {
                    minValueIndex = j;
                }
            }
            swap(array, i, minValueIndex);
        }
    }
    private static void sortArray(int leftIndex, int runner) {
        if (integerTestList[runner] < integerTestList[minValueIndex]) {
           minValueIndex = runner;
        }
        if (runner == size()-1){
            swap(integerTestList, minValueIndex, leftIndex);
        leftIndex++;
        runner = leftIndex;
        minValueIndex = leftIndex;
            if (leftIndex == size()-1) {
                return;
            }
        }
        sortArray(leftIndex,runner+1);
    }
    public static int size() {
        int n = 0;
        for (Integer e : integerTestList) {
            if (e != null) {
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        testListInitialization();
        for (int i = 0; i < integerTestList.length; i++) {
            System.out.print(integerTestList[i] + ", ");
        }
        System.out.println();
        sortArray(0,0);
        for (int i = 0; i < integerTestList.length; i++) {
            System.out.print(integerTestList[i] + ", ");
        }
       /* long start = System.currentTimeMillis();
        bubbleSorting(integerTestList);
        System.out.println("Bubble sorting time " + (System.currentTimeMillis() - start)/1000 + "sec");
        testListInitialization();
        start = System.currentTimeMillis();
        sortingBySelection(integerTestList);
        System.out.println("Selection sorting time " + (System.currentTimeMillis() - start)/1000 + "sec");
        testListInitialization();
        start = System.currentTimeMillis();
        sortingByInsert(integerTestList);
        System.out.println("Insert sorting time " + (System.currentTimeMillis() - start)/1000 + "sec");*/
    }
}


