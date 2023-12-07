package my.pack.addressbook;

public class MyFirstProgram {
	public static void main(String[] args) {
		hello("world");
		hello("Vasya");
		System.out.println();

		Square s = new Square(5.0);
		System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(8.0, 7.0);
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

		Point a = new Point(10, 4);
		Point b = new Point(-7, 19);
		System.out.println(a.distance(b));

	}
	public static void hello (String somebody) {
		System.out.println("Hello, " + somebody + "!");
	}

}