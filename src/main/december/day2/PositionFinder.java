package main.december.day2;

import java.util.List;

import main.domain.Movement;

public class PositionFinder {

    public Integer findEndpointProduct(List<Movement> movements) {
        int xDir = 0;
        int yDir = 0;
        int aim = 0;

        for (Movement movement : movements) {
            switch (movement.getDirection()) {
                case "forward":
                    xDir += movement.getDistance();
                    yDir += aim * movement.getDistance();
                    break;
                case "up":
                    aim -= movement.getDistance();
                    break;
                case "down":
                    aim += movement.getDistance();
                    break;
                default:
                    break;
            }
        }
        return xDir * yDir;
    }

}
