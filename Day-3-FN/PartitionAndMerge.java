/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ashwi
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PartitionAndMerge {
    public static void main(String[] args) {
        int[] array = {5,6,7,8,9,};
        int partitionSize = 2;
        int[] partitionOrder = {7, 6, 5};

        int[] result = partitionAndMerge(array, partitionSize, partitionOrder);

        System.out.println("Output:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] partitionAndMerge(int[] array, int partitionSize, int[] partitionOrder) {
        // Partition the array into subarrays based on the given partition size
        List<int[]> partitions = new ArrayList<>();
        for (int i = 0; i < array.length; i += partitionSize) {
            int[] partition = Arrays.copyOfRange(array, i, Math.min(i + partitionSize, array.length));
            partitions.add(partition);
        }

        // Sort the partitions based on the specified order
        Collections.sort(partitions, (a, b) -> {
            int orderA = partitionOrder[partitions.indexOf(a)];
            int orderB = partitionOrder[partitions.indexOf(b)];
            return Integer.compare(orderA, orderB);
        });

        // Merge the sorted partitions into a single array
        List<Integer> mergedList = new ArrayList<>();
        for (int[] partition : partitions) {
            for (int num : partition) {
                mergedList.add(num);
            }
        }

        // Convert the merged list to an array
        int[] mergedArray = new int[mergedList.size()];
        for (int i = 0; i < mergedList.size(); i++) {
            mergedArray[i] = mergedList.get(i);
        }

        return mergedArray;
    }
}
