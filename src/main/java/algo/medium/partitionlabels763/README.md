# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Simply track the last seen position of a certain character
I'm not going to use hashtable here for less space used.
Instead, let's use an array in which index represenst a char code, whereas a value inside the index equals to the last position of this index in a char seq (input string)


# Approach
<!-- Describe your approach to solving the problem. -->
Let's use greedy approach.
Each time we see a new character, which was not seen before, we start tracking a new partition and store its START index in a separate array (partitions)

```java
if (charsAscii[c-a] == -1) {
                newPartitionStartIndex = i;
                lastActivePartitionIndex++;
                partitions[lastActivePartitionIndex] =  newPartitionStartIndex;
}
```
If we run into a char which was seen, then we compare the current index and the start index of the current partition (i.e whether this char was seen in the current partition)

In case the character last seen index was somewhere before (i.e. charsAscii[c-a] < newPartitionStartIndex), we're "merging" the partitions

```java
else {
                while (charsAscii[c-a] < newPartitionStartIndex) { 
                    partitions[lastActivePartitionIndex] = 0;
                    lastActivePartitionIndex--;
                    newPartitionStartIndex = partitions[lastActivePartitionIndex];
                }
            }
```


# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(N) we iterate through the input char sequence only once

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(1) - we only store a limited

# Code
```java []
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] charsAscii = new int[26];
        Arrays.fill(charsAscii, -1);
        int a = 'a';
        int[] partitions = new int[s.length() + 1];
        int lastActivePartitionIndex = -1;
        int newPartitionStartIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
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
}
```