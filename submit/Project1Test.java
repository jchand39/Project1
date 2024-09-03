import org.junit.*;
import static org.junit.Assert.*;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.*;

/**
Project1Test - class that tests Project1 functions.

@author  Jared Chandler
@version 9/1/2024
*/
public class Project1Test {

    // Create the runner
    private CollectionUtilities<Integer> runner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        ArrayList<Integer> ints = new ArrayList<>(
                Arrays.asList(
                        -293, 3, 1, 38478, -328459, 0, -2, 64, 5779, 46, 0));

        runner = new Project1<Integer>(ints);
    }

    /**
     * tests function findSmallest().
     */
    @Test
    public void testFindSmallest() {
        int n = runner.findSmallest();
        assertEquals(-328459, n);
    }

    /**
    * tests function findLargest().
    */
    @Test
    public void testFindLargest() {
        int n = runner.findLargest();
        assertEquals(38478, n);
    }

    /**
    * tests function hasDuplicates().
    */
    @Test
    public void testHasDuplicatesTrue() {
        boolean v = runner.hasDuplicates();
        assertEquals(true, v);
    }

    /**
    * tests function hasDuplicates().
    */
    @Test
    public void testHasDuplicatesFalse() {
        ArrayList<Integer> ints = new ArrayList<>(
                Arrays.asList(
                        -293, 3, 1, 38478, -328459, 0, -2, 64, 5779, 46));

        runner = new Project1<Integer>(ints);

        boolean v = runner.hasDuplicates();
        assertEquals(false, v);
    }

    /**
    * tests function findOneThat().
    */
    @Test
    public void testFindOneThatTrue() {
        Project1<Integer> specialRunner = (Project1<Integer>) runner;

        Predicate<Integer> p = n -> n == 1;
        int n = specialRunner.findOneThat(p);
        assertEquals(1, n);
    }

    /**
     * tests function findOneThat().
     */
    @Test
    public void testFindOneThatFalse() {
        Project1<Integer> specialRunner = (Project1<Integer>) runner;

        Predicate<Integer> p = n -> n == 0.356;
        Integer n = specialRunner.findOneThat(p);
        assertEquals(null, n);
    }

    /**
     * tests function filterList().
     */
    @Test
    public void testFilterList() {
        Project1<Integer> specialRunner = (Project1<Integer>) runner;

        Predicate<Integer> p = n -> n % 2 == 0;
        AbstractList<Integer> n = specialRunner.filterList(p);
        ArrayList<Integer> filteredList = new ArrayList<>(
            Arrays.asList(
                    38478, 0, -2, 64, 46, 0));
        assertEquals(filteredList, n);
    }
}
