package main.december.day2;

import java.util.List;

import main.domain.Movement;

public class PositionFinder {

    public Integer findEndpointProduct(List<Movement> movements) {
        int xDir = 0;
        int yDir = 0;

        for (Movement movement : movements) {
            switch (movement.getDirection()) {
                case "forward":
                    xDir += movement.getDistance();
                    break;
                case "up":
                    yDir -= movement.getDistance();
                    break;
                case "down":
                    yDir += movement.getDistance();
                    break;
            }
        }
        return xDir * yDir;
    }

}
