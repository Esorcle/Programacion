package pizzeria;

/**
 *
 */
public class Pizza {
    /**
     *
     */
    public enum Size {MEDIANA, FAMILIAR}
    private Size tamanio;
    private int numIngre = 0;
    private Ingrediente[] pizza;

    /**
     * @param tamanio
     */
    public Pizza(Size tamanio) {
        this.tamanio = tamanio;
        this.pizza = new Ingrediente[3];
    }

    /**
     *
     */
    public Pizza(){
        this.tamanio = Size.FAMILIAR;
        this.pizza = new Ingrediente[3];
    }
    /**
     * @return
     */
    public int getNumIngre() {
        return numIngre;
    }

    /**
     * @param ingre
     * @return
     */
    public boolean addIngred(Ingrediente ingre) {
        if (this.numIngre == 3) {
            return false;
        }
        this.pizza[numIngre] = ingre;
        numIngre++;
        return true;
    }

    public void mostarInfo() {
        System.out.print("Pizza " + this.tamanio + " con ");
        for (int i = 0; i < this.numIngre; i++) {
            System.out.print(this.pizza[i].getNombre());
            if ((i == 1 && this.numIngre==3) || (i==0 && this.numIngre==2)) {
                System.out.print(" y ");
            } else
                if(i==0){
                System.out.print(", ");
            }
        }

    }
}


