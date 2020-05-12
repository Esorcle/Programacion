package pizzeria;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza(Pizza.Size.FAMILIAR);
        Ingrediente ingr1 = new Ingrediente("Jamón",100);
        Ingrediente ingr2 = new Ingrediente("Anchoas",60);


        System.out.println(pizza.getNumIngre());

        pizza.addIngred(ingr1);
        pizza.addIngred(ingr2);


        pizza.mostarInfo();

        System.out.println();

        Pedido newPedido = new Pedido();

        newPedido.mostrarPedido();


    }
}
