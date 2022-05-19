package lekce_310;

public abstract class FactoryShape {

    public static FactoryShape createCircle() {
        return new Circle();
    }

    public static FactoryShape createSquare() {
        return new Square();
    }

    public static FactoryShape createRandomShape() {
        return Math.random() > 0.5 ? createSquare() : createCircle();
    }

    private static class Circle extends FactoryShape {
        @Override
        protected void paint0() {
            System.out.println("○");
        }
    }

    private static class Square extends FactoryShape {
        @Override
        protected void paint0() {
            System.out.println("□");
        }
    }

    protected abstract void paint0() ;

    public void paintShape() {

    }
}
