import java.io.Serializable;

/**
 * Created by haoha on 10/13/2017.
 */
public class Dog extends Animal implements Serializable {
    String color = "black";
    int age = 3;

    void printColor() {
        System.out.println(color);
        System.out.println(super.color);
    }
}
