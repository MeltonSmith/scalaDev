package r.ian.algo.medium.partitionlabels763;


import java.util.*;

/**
 * @author Melton Smith
 * @since 17.05.2025
 */
public class Solution {
    //97% 60%
    public List<Integer> partitionLabels(String s) {
        int[] charsAscii = new int[26];
        Arrays.fill(charsAscii, -1);
        int a = 'a';
        int[] partitions = new int[s.length() + 1];
        int lastActivePartitionIndex = -1;
        int newPartitionStartIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            //not seen, starting a new partition
            if (charsAscii[c-a] == -1) {
                newPartitionStartIndex = i;
                lastActivePartitionIndex++;
                partitions[lastActivePartitionIndex] = newPartitionStartIndex;
            } else { //seen
                while (charsAscii[c-a] < newPartitionStartIndex) { //seen in previous partition, moving back and "merge" partitions
                    partitions[lastActivePartitionIndex] = 0;
                    lastActivePartitionIndex--;
                    newPartitionStartIndex = partitions[lastActivePartitionIndex];
                }
            }
            charsAscii[c-a] = i;
        }

        LinkedList<Integer> res = new LinkedList<>();
        if (lastActivePartitionIndex == -1) {
            res.add(s.length());
            return res;
        }

        for (int i = 0; i < partitions.length; i++) {
            if (i == lastActivePartitionIndex) {
                res.add(s.length() - partitions[i]);
                break;
            } else
                res.add(partitions[i + 1] - partitions[i]);
        }

        return res;
    }

    //97% 42%
    public List<Integer> partitionLabelsWitjLinkedList(String s) {
        int[] charsAscii = new int[26];
        Arrays.fill(charsAscii, -1);
        int a = 'a';
        LinkedList<Integer> partitions = new LinkedList<>();
        int newPartitionStartIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            //not seen, starting a new partition
            if (charsAscii[c-a] == -1) {
                newPartitionStartIndex = i;
                partitions.addLast(newPartitionStartIndex);
            } else { //seen
                while (charsAscii[c-a] < newPartitionStartIndex) { //seen in previous partition, moving back and "merge" partitions
                    partitions.pollLast();
                    newPartitionStartIndex = partitions.peekLast();
                }
            }
            charsAscii[c-a] = i;
        }

        LinkedList<Integer> res = new LinkedList<>();
        if (partitions.isEmpty()) {
            res.add(s.length());
            return res;
        }

        while (partitions.peekFirst() != null) {
            var elem = partitions.pollFirst();
            if (partitions.peekFirst() == null) {
                res.add(s.length() - elem);
                break;
            }

            res.add(partitions.getFirst() - elem);

        }


        return res;
    }
}
