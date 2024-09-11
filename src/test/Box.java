package test;

public class Box {
    double width;
    double height;
    double depth;

    Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Dimensions: " + width + " x " + height + " x " + depth;
    }
//String b = ""+box will call the toString method of the Box class.
//    String b = box gives error because the box is an object of the Box class and it cannot be converted to a string directly.
    public static void main(String[] args) {
        Box box = new Box(10, 20, 30);
        String b = ""+box;
        System.out.println(b);
        System.out.println(box);



        int a=9;
        System.out.println(a);

        String name = "Akshat";
//        System.out.println(name.getChars(0,3););

        System.out.println(String.valueOf(a).getClass().getName());
    }
}
