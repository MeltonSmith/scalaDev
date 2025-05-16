package r.ian.algo.medium.partitionlabels763;

import org.junit.Test;

import java.util.List;

/**
 * @author Melton Smith
 * @since 17.05.2025
 */
public class SolutionTest {

    @Test
    public void firstTest() {
        Solution solution = new Solution();
        List<Integer> ababcbacadefegdehijhklij = solution.partitionLabels("ababcbacadefegdehijhklij");
//        List<Integer> ababcbacadefegdehijhklij = solution.partitionLabels("eccbbbbdec");
//        List<Integer> ababcbacadefegdehijhklij = solution.partitionLabels("caedbdedda");
        System.out.println(ababcbacadefegdehijhklij);
    }
}
