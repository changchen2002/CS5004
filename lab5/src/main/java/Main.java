import draw.Circle;
import draw.Figure;
import draw.Rectangle;
import draw.Triangle;

public class Main {
    public static void main(String [] args) {
        Figure figure1 = new Circle(-5, 5, 10);
        Figure figure2 = new Rectangle(1, 3, 5, 7);
        Figure figure3 = new Triangle(-2, 4, 6, 8, 10);

        figure1.draw();
        figure1.erase();
        figure1.resize(0.1);
        figure1.move(1, 1);
        System.out.println();

        figure2.draw();
        figure2.erase();
        figure2.resize(10.0);
        figure2.move(-1, -1);
        System.out.println();

        figure3.draw();
        figure3.erase();
        figure3.resize(0.01);
        figure3.move(5, -5);
    }
}
