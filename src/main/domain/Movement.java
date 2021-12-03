package main.domain;

public class Movement {
    
    String direction;
    int distance;

    public Movement(String dir, int dis){
        this.direction = dir;
        this.distance = dis;
    }

    public String getDirection() {
        return this.direction;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
