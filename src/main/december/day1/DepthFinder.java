package main.december.day1;

import java.util.List;

public class DepthFinder {
    public Integer seaFloorChange(List<Integer> depths) {

        int changes = 0;
        for (int i = 1; i < depths.size(); i++) {
            if (depths.get(i) > depths.get(i - 1)) {
                changes++;
            }
        }

        return changes;
    }
}