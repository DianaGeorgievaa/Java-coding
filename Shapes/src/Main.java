public class Main {

    public static void main(String[] args) {
        Shape [] shapes={new Triangle(5.2,3.0),new Rectangle(1.3,7.0)};
        for(Shape shape: shapes){
            System.out.println(shape.calculateArea());
        }
    }
}
