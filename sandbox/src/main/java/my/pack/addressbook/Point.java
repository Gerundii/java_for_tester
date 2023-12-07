package my.pack.addressbook;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double distance (Point b) {
        /*double distance = Math.sqrt(Math.pow((b.x - this.x), 2) + Math.pow((b.y - this.y), 2));
        double scale = Math.pow(10, 5);
        double result = Math.ceil(distance * scale) / scale;*/
        return Math.sqrt(Math.pow((b.x - this.x), 2) + Math.pow((b.y - this.y), 2));
    }


}
