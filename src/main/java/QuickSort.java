public class QuickSort {

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(array, start, end);

            quickSort(array, start, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];

        int smallerIndex = start - 1;

        for (int pointer = start; pointer < end; pointer++) {
            if (array[pointer] < pivot) {
                // If current element is smaller than pivot,
                // move smaller index to the next position and swap smaller one with current element
                // Then move pointer to the next position
                // TODO array[smallerIndex] must keep smaller than array[smallerIndex+1] as well as pivot
                // Each time when smallerIndex moves to next position, it also means that pointer's value is smaller than pivot
                // array[0-smallerIndex] contains elements definitely smaller than pivot
                // arrayp[smallerIndex+1] means it trys to expand its collection, and if pointer's value is smaller than pivot. it finishes expansion
                smallerIndex++;

                int tempValue = array[pointer];
                array[pointer] = array[smallerIndex];
                array[smallerIndex] = tempValue;
            }

            // If current element is larger than pivot,
            // smaller index stays put
            // and only move the pointer
        }

        // Finally we found the gap between the end of smaller elements and the start of bigger elements
        // Then we insert the pivot to it
        int tempValue = array[smallerIndex + 1];
        array[smallerIndex + 1] = array[end];
        array[end] = tempValue;

        return smallerIndex + 1;
    }

}
