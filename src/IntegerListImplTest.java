import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegerListImplTest {
    private final IntegerList_Impl OUT = new IntegerList_Impl();
    private final Integer[] EMPTY_LIST = {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
    private final Integer[] TEST_LIST = {1,2,3,4,5,6,7,8,9,10,null,null,null,null,null,null};
    private final Integer[] TEST_ADD_BY_INDEX = {1,2,3,4,112233,5,6,7,8,9,10,null,null,null,null,null};
    private final Integer[] LIST_SHIFTED_LEFT = {1,2,3,4,6,7,8,9,10,null,null,null,null,null,null,null};
    private final Integer[] LIST_SHIFTED_RIGHT = {1,2,3,4,5,5,6,7,8,9,10,null,null,null,null,null};
    private final Integer[] SET_VALUE_BY_INDEX = {1,2,3,4,112233,6,7,8,9,10,null,null,null,null,null,null};
    private final Integer[] EXTENDED_LIST = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,null,null,null,null,null,null,null,null};
    private final Integer[] FULL_LIST = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
    private final Integer[] EXTENDED_LIST_ADD = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,123,null,null,null,null,null,null,null};
    private final Integer[] UNSORTED_LIST = {5,2,9,4,1,7,6,8,3,15,14,16,13,11,10,12};
    private final int TEST_INDEX = 4;
    private final int OUT_OF_SIZE_INDEX = 12;
    private final int OUT_OF_BOUND_INDEX = 16;

    @BeforeEach
    public  void integerListIni(){
        OUT.integerList = TEST_LIST;
    }

    @Test
    public void shouldReturnlistShiftedLeft(){
        Assertions.assertArrayEquals(LIST_SHIFTED_LEFT,OUT.shiftLeft(TEST_INDEX));
    }
    @Test
    public void shouldReturnListShiftedRight(){
        Assertions.assertArrayEquals(LIST_SHIFTED_RIGHT,OUT.shiftRight(TEST_INDEX));
    }
    @Test
    public void shouldReturnListWithTESTonly(){
        OUT.integerList = EMPTY_LIST;
        OUT.add(112233);
        Assertions.assertEquals(112233, OUT.integerList[0]);
    }
    @Test
    public void addNumberByIndexShouldAddOrThrowException(){
        OUT.add(TEST_INDEX,112233);
        Assertions.assertArrayEquals(TEST_ADD_BY_INDEX, OUT.integerList);
        Assertions.assertThrows(RuntimeException.class,()->OUT.add(OUT_OF_BOUND_INDEX, 112233));
    }
    @Test
    public void setShouldReplaceValuebyIndexOrThrowException(){
        OUT.set(TEST_INDEX, 112233);
        Assertions.assertArrayEquals(SET_VALUE_BY_INDEX, OUT.integerList);
        Assertions.assertThrows(RuntimeException.class,()->OUT.set(OUT_OF_BOUND_INDEX,112233));
        Assertions.assertThrows(RuntimeException.class,()-> OUT.set(OUT_OF_SIZE_INDEX, 112233));
    }
    @Test
    public void removeByIndexShouldRemoveOrThrowException(){
        OUT.removeByIndex(TEST_INDEX);
        Assertions.assertArrayEquals(LIST_SHIFTED_LEFT, OUT.integerList);
        Assertions.assertThrows(RuntimeException.class,()->OUT.removeByIndex(OUT_OF_SIZE_INDEX));
    }
    @Test
    public void removeByValueShouldRemoveOrThrowException(){
        OUT.integerList = SET_VALUE_BY_INDEX;
        OUT.removeByValue(112233);
        Assertions.assertArrayEquals(LIST_SHIFTED_LEFT, OUT.integerList);
        Assertions.assertThrows(RuntimeException.class,()->OUT.removeByValue(112233));
    }
    @Test
    public void equalsShouldCompareArraysOrThrowNPE(){
        Assertions.assertArrayEquals(OUT.integerList, TEST_LIST);
    }
    @Test
    public void shouldReturnTEST_INDEXandFalse(){
        OUT.integerList = SET_VALUE_BY_INDEX;
        Assertions.assertTrue(OUT.contains(TEST_INDEX));
        Assertions.assertFalse(OUT.contains(OUT_OF_BOUND_INDEX));
    }
    @Test
    public void shouldReturnExtendedList(){
        OUT.integerList = FULL_LIST;
        Assertions.assertArrayEquals(OUT.extension(), EXTENDED_LIST);
    }
    @Test
    public void shouldExtendTheListAndAddValueOf123(){
        OUT.integerList = FULL_LIST;
        OUT.add(123);
        Assertions.assertArrayEquals(EXTENDED_LIST_ADD, OUT.integerList);
    }
    @Test
    public void shouldReturnSortedArray(){
        OUT.integerList = UNSORTED_LIST;
        OUT.sortingBySelection(OUT.integerList);
        Assertions.assertArrayEquals(FULL_LIST,OUT.integerList);
    }
}

