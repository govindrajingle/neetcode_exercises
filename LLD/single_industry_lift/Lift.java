public class Lift {
    int currentFloor;
    int destinationFloor;
    int sourceFloor;

    public int moveUp() {
        if (destinationFloor > 9 || destinationFloor < 0)
            return currentFloor;
        if (destinationFloor > sourceFloor || destinationFloor > currentFloor)
            return 1;
        return currentFloor;
    }

    public int moveDown() {
        if (destinationFloor > 9 || destinationFloor < 0)
            return currentFloor;
        if (destinationFloor < sourceFloor || destinationFloor < currentFloor)
            return 1;
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public Lift() {
        setCurrentFloor(0);
    }
}
