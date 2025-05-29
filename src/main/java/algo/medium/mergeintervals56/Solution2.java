package r.ian.algo.medium.mergeintervals56;

import java.util.Arrays;

/**
 * 9% 98.5
 *
 * @author Melton Smith
 * @since 29.05.2025
 */
public class Solution2 {

    public int[][] merge(int[][] intervals) {
        int[][] sort = sort(intervals, 0, intervals.length - 1);
        int k = 0;
        for (int i = 0; i < sort.length; i++) {
            if (sort[i] == null)
                break;
            k++;
        }
        return Arrays.copyOfRange(sort, 0, k);
    }

    public int[][] sort(int[][] input, int left, int right) {
        if (left == right) {
            int[] ints = input[left];
            int[][] res = new int[1][2];
            res[0] = ints;
            return res;

        }

        int mid = left + (right - left) / 2;

        int[][] sort = sort(input, left, mid);
        int[][] sort1 = sort(input, mid + 1, right);

        return merge(sort, sort1);
    }


    private int[][] merge(int[][] left, int[][] right) {
        int[][] resArr = new int[left.length + right.length][2];

        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = null;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            int[] leftAr = left[i];
            int[] rightAr = right[j];
            if (leftAr == null && rightAr == null) {
                return resArr;
            }
            else if (leftAr == null) {
                addOrMergeRest(right, j, resArr, k);
                return resArr;
            }
            else if (rightAr == null) {
                addOrMergeRest(left, i, resArr, k);
                return resArr;
            }
            else {
                if (rightAr[0] < leftAr[0]) {
                    if (resArr[k] != null) { //prev merged interval
                        if (rightAr[0] <= resArr[k][1]) { //merge cond
                            resArr[k][1] = Math.max(rightAr[1], resArr[k][1]);
                            if (leftAr[0] <= resArr[k][1]) { //now checking left
                                resArr[k][1] = Math.max(leftAr[1], resArr[k][1]);
                                i++;
                                j++;
                            } else {
                                j++;
                            }
                        } else { //no overlapping
                            k++;
                            resArr[k] = rightAr;
                            j++;
                        }
                    } else {
                        resArr[k] = rightAr;
                        j++;
                    }
                } else {
                    if (resArr[k] != null) {
                        if (leftAr[0] <= resArr[k][1]) { //merge cond
                            resArr[k][1] = Math.max(leftAr[1], resArr[k][1]);
                            if (rightAr[0] <= resArr[k][1]) { //now checking right
                                resArr[k][1] = Math.max(rightAr[1], resArr[k][1]);
                                i++;
                                j++;
                            } else {
                                i++;
                            }
                        } else { //no overlapping
                            k++;
                            resArr[k] = leftAr;
                            i++;
                        }
                    } else {
                        resArr[k] = leftAr;
                        i++;
                    }

                }
            }



        }

        //adding something is left
        addOrMergeRest(left, i, resArr, k);
        addOrMergeRest(right, j, resArr, k);



        return resArr;
    }

    private static int addOrMergeRest(int[][] arr2d, int i, int[][] resArr, int k) {
        while (i < arr2d.length) {
            int[] pair = arr2d[i];
            if (pair == null)
                return k;

            if (pair[0] <= resArr[k][1]) {
                resArr[k][1] = Math.max(pair[1], resArr[k][1]);
                i++;
            } else {
                k++;
                resArr[k] = pair;
                i++;
            }
        }
        return k;
    }
}
