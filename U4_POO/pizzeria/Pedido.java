package pizzeria;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Pedido {
    /**
     *
     */
    private Pizza pizza;
    private Calendar momento;

    /**
     * Constructor para clase Pizza
     * @param pizza
     */
    public Pedido(Pizza pizza) {
        this.pizza = pizza;
        this.momento = Calendar.getInstance();
    }

    /**
     * Contructor para pizza etrella
     */
    public Pedido() {
        this.pizza = new Pizza();
        Ingrediente ingr1= new Ingrediente();
        Ingrediente ingr2 = new Ingrediente("Jamón", 120);
        this.pizza.addIngred(ingr1);
        this.pizza.addIngred(ingr2);
        this.momento = Calendar.getInstance();
    }

    public void mostrarPedido(){
        pizza.mostarInfo();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Fecha y hora: " + dateFormat.format(this.momento));
    }

}
