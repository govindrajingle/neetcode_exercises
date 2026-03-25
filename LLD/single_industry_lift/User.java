public class User {
    UserState isUserInOrOut;
    int destinationFloor;

    public boolean entersLift() {
        if (isUserInOrOut == UserState.OUT) {
            return true;
        }
        return false;
    }

    public boolean exitsLift() {
        if (isUserInOrOut == UserState.IN) {
            return true;
        }
        return false;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public User(int destinationFloor) {
        this.destinationFloor = destinationFloor;
        this.isUserInOrOut = UserState.OUT;
    }
}
