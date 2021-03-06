package sortingandsearching;

import java.util.ArrayList;

public class MergeSortList {
    private ArrayList<Integer> inputArray;

    public ArrayList<Integer> getInputArray() {
        return inputArray;
    }

    public MergeSortList(ArrayList<Integer> inputArray) {
        this.inputArray = inputArray;
    }

    public void sortGivenArray() {
        divide(0, this.inputArray.size() - 1);
    }

    public void divide(int startIndex, int endIndex) {
        //Divide till you breakdown your list to single element
        if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
            int middle = (endIndex + startIndex) / 2;
            divide(startIndex, middle);
            divide(middle + 1, endIndex);

            //merging Sorted array produce above into one sorted array
            merger(startIndex, middle, endIndex);
        }
    }

    public void merger(int startIndex, int midIndex, int endIndex) {
        //Below is the mergedarray that will be sorted array Array[i-midIndex] , Array[(midIndex+1)-endIndex]
        ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();
        int leftIndex = startIndex;
        int rightIndex = midIndex + 1;

        while (leftIndex <= midIndex && rightIndex <= endIndex) {
            if (inputArray.get(leftIndex) < inputArray.get(rightIndex)) {
                mergedSortedArray.add(inputArray.get(leftIndex));
                leftIndex++;
            }else {
                mergedSortedArray.add(inputArray.get(rightIndex));
                rightIndex++;
            }
        }

        //Either of below while loop will execute
        while(leftIndex <= midIndex){
            mergedSortedArray.add(inputArray.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex <= endIndex){
            mergedSortedArray.add(inputArray.get(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = startIndex;
        //Setting sorted array to original one
        while (i < mergedSortedArray.size()){
            inputArray.set(j,mergedSortedArray.get(i++));
            j++;
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> unsortedArray = new ArrayList<Integer>();
        unsortedArray.add(8);
        unsortedArray.add(2);
        unsortedArray.add(7);
        unsortedArray.add(1);

        MergeSortList mergeSortList = new MergeSortList(unsortedArray);

        System.out.println("---------Initial Unsorted Array---------");

        for (int i: mergeSortList.getInputArray()){
            System.out.println(i + " ");
        }

        mergeSortList.sortGivenArray();

        System.out.println("\n------------Sorted Array------------");
        for (int i: mergeSortList.getInputArray()){
            System.out.println(i + " ");
        }
    }
}
