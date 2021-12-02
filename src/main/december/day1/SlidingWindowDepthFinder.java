package main.december.day1;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowDepthFinder {
    public Integer slidingWindowSeaFloorChange(List<Integer> depths, int window) {
        int changes = 0;
        List<Integer> bracketSums = getBracketSums(depths, window);
        for (int i = 1; i < bracketSums.size(); i++) {
            if (bracketSums.get(i) > bracketSums.get(i - 1)) {
                changes++;
            }
        }

        return changes;
    }

    public List<Integer> getBracketSums(List<Integer> depths, int window){
        int brackets = depths.size() - window + 1;
        List<Integer> sums = new ArrayList<>(brackets);

        for(int i = 0; i < brackets; i++){
            int windowSum = 0;
            for(int j = i; j < i + window; j++){
                windowSum += depths.get(j);
            }
            sums.add(i, windowSum);
        }
        return sums;
    }
}
