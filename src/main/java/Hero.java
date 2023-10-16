import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private Position position;
    private Hero hero;

    public Hero(int x, int y) {
        position = new Position(x, y);
    }
    public void moveUp() {
        position.setY(position.getY() + 1);
    }

    public void moveDown() {
        position.setY(position.getY() - 1);
    }

    public void moveLeft() {
        position.setX(position.getX() - 1);
    }

    public void moveRight() {
        position.setX(position.getX() + 1);
    }

    public void draw(Screen screen) {
    }
    public void moveHero(Position position){
        hero.setPosition(position);
    }
    public void setPosition(Position position) {
        this.position = position;
    }
}
