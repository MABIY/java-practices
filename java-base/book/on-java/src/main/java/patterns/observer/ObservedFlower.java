package patterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author lh
 */
class Flower {
    private boolean isOpen = false;
    private boolean alreadyOpen = false;
    private boolean alreadyClosed = false;

    Observable opening = new Observable() {
        @Override
        public void notifyObservers() {
            if (isOpen && !alreadyOpen) {
                setChanged();
                super.notifyObservers();
                alreadyOpen = true;
            }
        }
    };

    Observable closing = new Observable() {
        @Override
        public void notifyObservers() {
            if (!isOpen && !alreadyClosed) {
                setChanged();
                super.notifyObservers();
                alreadyClosed = true;
            }
        }
    };

    public void open() {
        isOpen = true;
        opening.notifyObservers();
        alreadyClosed = false;
    }

    public void close() {
        isOpen = false;
        closing.notifyObservers();
        alreadyOpen = false;
    }
}

class Bee {
    private String id;
    public final Observer whenOpened = (ob, a) -> {
        System.out.println("Bee " + id + "'s breakfast time!");
    };
    public final Observer whenClosed = (ob, a) -> {
        System.out.println("Bee " + id + "'s bed time!");
    };

    public Bee(String name) {
        this.id = name;
    }
}

class Hummingbird {
    private String id;
    public final Observer whenOpened = (ob, a) -> {
        System.out.println("Hummingbird " + id + "'s breakfast time!");
    };
    public final Observer whenClosed = (ob, a) -> {
        System.out.println("Hummingbird " + id + "'s bed time!");
    };
    public Hummingbird(String name) {
        this.id = name;
    }
}

public class ObservedFlower {
    public static void main(String[] args) {
        Flower f = new Flower();
        Bee ba = new Bee("A"), bb = new Bee("B");
        Hummingbird ha = new Hummingbird("A"),
                hb = new Hummingbird("B");
        f.opening.addObserver(ha.whenOpened);
        f.opening.addObserver(hb.whenOpened);
        f.opening.addObserver(ba.whenOpened);
        f.opening.addObserver(bb.whenOpened);

        f.closing.addObserver(ha.whenClosed);
        f.closing.addObserver(hb.whenClosed);
        f.closing.addObserver(ba.whenClosed);
        f.closing.addObserver(bb.whenClosed);

        f.opening.deleteObserver(hb.whenOpened);

        f.open();
        f.open(); // 没有效果，花瓣已经打开
        System.out.println("--------------------");
        f.closing.deleteObserver(ba.whenClosed);
        f.close();
        System.out.println("++++++++++++++++++++");
        f.close();//没有效果：花边已经关闭
        System.out.println("====================");
        f.opening.deleteObservers();
        f.open();// 没有观察者会更新
        System.out.println("####################");
        f.close();
    }
}
