package r.ian.algo.medium.partitionlabels763;


import java.util.*;

/**
 * @author Melton Smith
 * @since 17.05.2025
 */
public class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] charsAscii = new int[127];
        //todo
        Arrays.fill(charsAscii, -1);
        int[] partitions = new int[s.length() + 1];
        int lastActivePartitionIndex = -1;
        int newPartitionStartIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (charsAscii[c] == -1) {
                newPartitionStartIndex = i;
                lastActivePartitionIndex++;
                partitions[lastActivePartitionIndex] = newPartitionStartIndex;
            }
            else { //seen
                while (charsAscii[c] < newPartitionStartIndex) { //seen in previous partition, moving back and "merge" partitions
                    partitions[lastActivePartitionIndex] = 0;
                    lastActivePartitionIndex--;
                    newPartitionStartIndex = partitions[lastActivePartitionIndex];
                }
            }
            charsAscii[c] = i;
        }

        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < partitions.length; i++) {
            if (partitions[i] != 0 && (i == partitions.length - 1 || partitions[i+1] == 0)) {
                res.add(s.length() - partitions[i]);
                break;
            }
            else if (partitions[i] == 0 && partitions[i+1] == 0) {
                res.add(s.length() - partitions[i]);
                break;
            }
            else
                res.add(partitions[i+1] - partitions[i]);

        }

        return res;
    }
}
