import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;



import java.io.IOException;

public class Game {
    private int x = 10;
    private int y = 10;
    private Screen screen;
    private Hero hero;
    private Position position;


    public Game() {
                try {
                    TerminalSize terminalSize = new TerminalSize(40, 20);
                    DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
                    Terminal terminal = terminalFactory.createTerminal();
                    Screen screen = new TerminalScreen(terminal);
                    screen.setCursorPosition(null);
                    screen.startScreen();
                    screen.doResizeIfNecessary();
                    screen.clear();
                    screen.setCharacter(x,y,TextCharacter.fromCharacter('X')[0]);
                    screen.refresh();
                    hero = new Hero(10, 10);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    public void run(){
        while(true) {
            try {
                draw();
                KeyStroke key = screen.readInput();
                processKey(key);
                if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                    screen.close();
                if (key.getKeyType() == KeyType.EOF)
                    break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp    -> moveHero(hero.moveUp());
            case ArrowDown  -> moveHero(hero.moveDown());
            case ArrowLeft  -> moveHero(hero.moveLeft());
            case ArrowRight -> moveHero(hero.moveRight());
        }
        System.out.println(key);
    }
    }

