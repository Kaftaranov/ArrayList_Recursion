import java.util.Arrays;

public class IntegerList_Impl implements IntegerListInterface {

    Integer[] integerList = new Integer[16];

    Integer[] extension(Integer[] arrayToExtend) {
        Integer[] tempArray;
        tempArray = Arrays.copyOf(integerList, arrayToExtend.length + arrayToExtend.length / 2);
        return integerList = tempArray;
    }

    Integer[] shiftLeft(int index) {
        for (int i = index; i < integerList.length; i++) {
            integerList[i] = integerList[i + 1];
            if (i == integerList.length - 2) {
                integerList[i + 1] = null;
                break;
            }
        }
        return integerList;
    }

    Integer[] shiftRight(int index) {
        if (integerList[integerList.length - 1] != null) {
            throw new RuntimeException("Index is out of bounds");
        }
        for (int i = size(); i >= index; i--) {
            integerList[i + 1] = integerList[i];
        }
        return integerList;
    }

    @Override
    public Integer add(int item) {
        if (size() == 0) {
            return integerList[0] = item;
        }
        if (integerList[integerList.length-1] != null) {
            extension(integerList);
        }
        return integerList[(size())] = item;
    }

    @Override
    public Integer add(int index, int item) {
        if (index > size() || index > integerList.length) {
            throw new RuntimeException("Index is out of bounds");
        }
        shiftRight(index);
        return integerList[index] = item;
    }

    @Override
    public Integer set(Integer index, Integer item) {
        if (index > size() || index > integerList.length) {
            throw new RuntimeException("Index is out of bounds");
        }
        return integerList[index] = item;
    }

    @Override
    public Integer removeByValue(int item) {
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i].equals(item)) {
                shiftLeft(i);
                return item;
            }
        }
        throw new RuntimeException("Item not found");
    }

    @Override
    public Integer removeByIndex(int index) {
        Integer removedItem;
        if (integerList[index] != null) {
            removedItem = integerList[index];
            shiftLeft(index);
        } else {
            throw new RuntimeException("Index not found");
        }
        return removedItem;
    }

    @Override
    public boolean contains(Integer item) {
        sortingBySelection(integerList);
        return findItem(integerList, item);

    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = integerList.length - 1; i >= 0; i--) {
            if (integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(Integer index) {
        if (index > size()) {
            throw new RuntimeException("Index is out of bounds");
        }
        return integerList[index];
    }

    @Override
    public boolean equals(IntegerListInterface otherList) {
        if (otherList.size() != size()) {
            return false;
        }
        for (int i = 0; i < integerList.length; i++) {
            if (!integerList[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        int n = 0;
        for (Integer e : integerList) {
            if (e != null) {
                n++;
            }
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        for (Integer e : integerList) {
            if (e != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(integerList, null);
    }

    @Override
    public Integer[] toArray() {
        Integer[] newArray = new Integer[size()];
        for (int i = 0; i < size(); i++) {
            newArray[i] = integerList[i];
        }
        return newArray;
    }

    private void sortingBySelection(Integer[] array) {
        for (int i = 0; i < size(); i++) {
            int minValueIndex = i;
            for (int j = size() - 1; j > i; j--) {
                if (array[j] < array[minValueIndex]) {
                    minValueIndex = j;
                }
            }
            swap(array, i, minValueIndex);
        }
    }

    private void swap(Integer[] array, int from, int to) {
        int temp = array[to];
        array[to] = array[from];
        array[from] = temp;
    }

    private boolean findItem(Integer[] array, int item) {
        int min = 0;
        int max = size() - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (item == array[mid]) {
                return true;
            }
            if (item < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}

