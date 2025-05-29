package r.ian.algo.medium.mergeintervals56;

import scala.Array;

import java.util.Arrays;

/**
 * @author Melton Smith
 * @since 28.05.2025
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        return sort(intervals, 0, intervals.length-1);
    }

    public int[][] sort(int[][] input, int left, int right) {
        if (left == right) {
            int[] ints = input[left];
            int[][] res = new int[1][2];
            res[0] = ints;
            return input;

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
                }
                else {
                    resArr[k] = leftAr;
                    i++;
                }

            }
        }
        //adding something is left
        while (i < left.length) {
            int[] leftArr = left[i];
            if (leftArr[0] <= resArr[k][1]) {
                resArr[k][1] = Math.max(leftArr[1], resArr[k][1]);
                i++;
            } else {
                resArr[k] = leftArr;
                i++;
                k++;
            }
        }

        while (j < right.length) {
            int[] rightArr = right[j];
            if (rightArr[0] <= resArr[k][1]) {
                resArr[k][1] = Math.max(rightArr[1], resArr[k][1]);
                j++;
            } else {
                resArr[k] = rightArr;
                j++;
                k++;
            }
        }

        return Arrays.copyOfRange(resArr, 0, k+1);
    }
}
