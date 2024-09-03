import java.util.AbstractList;
import java.util.function.*;
import java.util.ArrayList;

/**
Project1 - class that take a collection (AbstractList) as 
argument and provides various operations on the content of that
collection.

@author  Jared Chandler
@version 9/1/2024
@param <E>
*/
public class Project1<E extends Comparable<E>> 
    implements CollectionUtilities<E>
{
    private AbstractList<E> collection;

    /**
     * Constructor.
     * 
     * @param collection our list
     */
    public Project1(AbstractList<E> collection) {
        this.collection = collection;
    }
    
    /**
     * findSmallest() function finds the smallest element in any generic collection.
     * 
     * @return smallest element
     */
    public E findSmallest() {
        E smallest = collection.get(0);
        
        for (E element : collection) {
            if (element.compareTo(smallest) < 0) {
                smallest = element;
            }
        }

        return smallest;
    }

    /**
     * findLargest() function finds the largest element in any generic collection.
     * 
     * @return largest element
     */
    public E findLargest() {
        E largest = collection.get(0);

        for (E element : collection) {
            if (element.compareTo(largest) > 0) {
                largest = element;
            }
        }

        return largest;
    }

    /**
     * hasDuplicates() function checks to see if there are any duplicate elements in a 
     * generic collection.
     * 
     * @return boolean elements
     */
    public boolean hasDuplicates() {
        for (int i = 0; i < collection.size(); i++) {
            for (int j = i + 1; j < collection.size(); j++) {
                if (collection.get(i).compareTo(collection.get(j)) == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * findOneThat() function finds an element in the collection that passes the predicate.
     * 
     * @param p p is the predicate that tests findOneThat()
     * @return passing element
     */
    public E findOneThat(Predicate<E> p) {
        for (E element : collection) {
            if (p.test(element)) {
                return element;
            }
        }

        return null;
    }

    /**
     * filterList() function finds an element in the collection that passes the predicate.
     * 
     * @param p p is the predicate that tests filterList()
     * @return passing element
     */
    public AbstractList<E> filterList(Predicate<E> p) {
        AbstractList<E> filteredList = new ArrayList<>();

        for (E element : collection) {
            if (p.test(element)) {
                filteredList.add(element);
            }
        }
        
        return filteredList;
    }
}
