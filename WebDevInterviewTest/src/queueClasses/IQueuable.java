package queueClasses;

/**
 * An interface for a collection of queue methods
 */
public interface IQueuable {
    /**
     * Adds value to the queue
     * @param value the value to add
     * @return new queue
     */
    String[] enqueue(String value);

    /**
     * Removes item from queue
     * @return item removed
     */
    String dequeue();

    /**
     * Returns a list of all the items in the queue
     * @return list of all items in queue
     */
    String[] getQueue();

    /**
     * Returns the number of items in the queue
     * @return number of items in queue
     */
    int size();

}
