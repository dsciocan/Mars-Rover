public enum Cardinal {
    N(0,1), E(1,0), S(0,-1), W(-1,0);

    private final int moveX;

    private final int moveY;

    Cardinal(int moveX, int moveY) {
        this.moveX = moveX;
        this.moveY = moveY;

    }

    public int getMoveX() {
        return moveX;
    }

    public int getMoveY() {
        return moveY;
    }

}
