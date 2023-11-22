public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        //polymorphism

        //two type
        // 1.compile time polymorphism

        PolymophysumCon mm = new PolymophysumCon();
        mm.dance("ha"); //overloading method using parameters this is call as compile time polymorphism




        // 2.Run time polymorphism

        //A class extends by B class and display method overriding

        //When compile check left side A class have method only but running B code of right side (Dynamic method dispatch)

        A nn = new B();
        nn.display();

    }
}
