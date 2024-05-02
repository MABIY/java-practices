package patterns;

import onjava.MouseClick;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author lh
 */
class Boxes extends JFrame {
    Observable notifier = new Observable() {
        @Override
        public void notifyObservers(Object arg) {
            setChanged();
            super.notifyObservers(arg);
        }
    };

    public Boxes(int grid) {
        setTitle("Demonstrates Observer pattern");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(grid,grid));
        for (int i = 0; i <grid; i++) {
            for (int j = 0; j <grid; j++) {
                cp.add(new Box(i,j,notifier));
            }
        }
        setSize(500,400);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}

class Box extends JPanel implements Observer {
    int x,y;
    Color color = COLORS[
            (int)(Math.random()*COLORS.length)];
    static final Color[] COLORS ={

            Color.black,Color.blue,Color.cyan,
            Color.darkGray,Color.gray,Color.green,
            Color.lightGray,Color.magenta,
            Color.orange,Color.pink,Color.red,
            Color.white,Color.yellow

    };

    public Box(int x, int y,Observable notifier) {
        this.x = x;
        this.y = y;
        notifier.addObserver(this);
        addMouseListener((MouseClick) e-> notifier.notifyObservers(this));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        Dimension s = getSize();
        g.fillRect(0,0,s.width,s.height);
    }

    @Override
    public void update(Observable o, Object arg) {
        Box clicked = (Box)arg;
        if(nextTo(clicked)) {
            color = clicked.color;
            repaint();
        }
    }

    public boolean nextTo(Box b) {
        return Math.abs(x-b.x) <=1 &&
                Math.abs(y -b.y) <=1;
    }
}
public class BoxObserver {
    public static void main(String[] args) {
        int grid = 8;
        if(args.length > 0) {
            grid= Integer.parseInt(args[0]);
        }
        new Boxes(grid);
    }
}
