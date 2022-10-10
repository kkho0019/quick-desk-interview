package queueClasses;

import java.util.Arrays;

/**
 * First-in first-out queue
 */
public class FIFOQUEUE implements IQueuable{
    /**
     * Queue
     */
    private final String[] queue;
    /**
     * Queue capacity
     */
    private final int capacity;
    /**
     * Position of next added item to Queue
     */
    private int currentIndex;

    /**
     * Constructor.
     *
     * @param capacity the size of Queue
     */
    public FIFOQUEUE(int capacity) {
        this.capacity = capacity;
        this.queue = new String[this.capacity];
        this.currentIndex = 0;
    }

    /**
     * Is the Queue full?
     * Returns true if the current Queue has reached its capacity.
     * This is to prevent adding new values to the Queue.
     *
     * @return true if and only if number of values in Queue is equal to capacity of Queue
     */
    public boolean isFull() {
        return size() == capacity;
    }

    /**
     * Is the Queue empty?
     * Returns true if the current Queue has no values in it.
     *
     * @return true if and only if there are no values in Queue.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Add an item to the Queue.
     * Throws an error message if Queue is full.
     *
     * @see IQueuable#enqueue(String)
     */
    @Override
    public String[] enqueue(String value) {
        if (isFull()) {
            throw new AssertionError("Queue is full!");
        } else {
            queue[currentIndex] = value;
        }
        currentIndex++;
        return queue;
    }

    /**
     * Removes first item from Queue.
     * Handles empty Queue.
     *
     * @return the item removed, or an error message telling user the Queue is empty.
     * @see IQueuable#dequeue()
     */
    @Override
    public String dequeue() {
        if (isEmpty()) {
            throw new AssertionError("Queue is empty!");
        } else {
            String removedItem = queue[0];
            for (int i = 0; i < queue.length - 1; i++) {
                if (queue[i+1] != null) {
                    queue[i] = queue[i+1];
                    queue[i+1] = null;
                    currentIndex = i+1;
                }
            }
            return removedItem;
        }
    }

    /**
     * Get a copy of the current Queue.
     * Does not return null item.
     *
     * @return list filtering all null items in the Queue
     * @see IQueuable#getQueue()
     */
    @Override
    public String[] getQueue() {
        return Arrays.stream(queue).filter(x -> x != null).toArray(size -> new String[size]);
    }

    /**
     * Get the number of items in the Queue.
     *
     * @see IQueuable#size()
     */
    @Override
    public int size() {
        return getQueue().length;
    }

    /**
     * Prints the whole Queue including null values.
     * For debugging use only.
     */
    public void printQueue() {
        for (String s : queue) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
