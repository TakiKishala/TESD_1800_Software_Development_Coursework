public class Exercise13_11 {
    public static void main(String [] args) {
        Octagon oct1 = new Octagon(5);
        System.out.println(" Octagon:");
        System.out.println(" Area:" + oct1.getArea());
        System.out.println(" Perimeter:" + oct1.getPerimeter());

        Octagon oct2 = (Octagon) oct1.clone() ;
        System.out.println("\nCloned Octagon:");
        System.out.println(" Area:" + oct2.getArea());
        System.out.println(" Perimeter:" + oct2.getPerimeter());

        System.out.println("\ncomparison result :" + oct2.compareTo(oct2));

    }
}
abstract class  GeometricObject {
    private String color;
    private boolean filled;
    public GeometricObject(){}

    public GeometricObject( String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }

    public String getColor(){
        return color;
    }
    public boolean isFilled(){
        return filled;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}
class Octagon extends GeometricObject implements Comparable<Octagon>,Cloneable {

    private double sides;

    public Octagon(){

    }
    public Octagon(double sides){
        this.sides = sides;
    }
    public double getSides(){
        return sides;
    }
    @Override
    public double getArea(){
        return (2+ 4/Math.sqrt(2))*sides*sides;
    }
    @Override
    public double getPerimeter(){
        return 8*sides;
    }
    @Override
    public int compareTo(Octagon o){
        if(this.getArea()> o.getArea())
        return 1;
        else if (this.getArea()<o.getArea())
            return -1;
        else
            return 0;
    }
    @Override
    public Object clone(){
        try {
            return (Octagon) super.clone();
        }catch (CloneNotSupportedException e){
            return null;
        }
    }

}
