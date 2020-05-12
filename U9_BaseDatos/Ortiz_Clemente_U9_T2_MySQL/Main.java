public class Main {
    public static void main(String[] args) {

        ADClassicModels classicModels = new ADClassicModels();

        System.out.println(classicModels.getEmpleados());

        System.out.println(classicModels.getOffices());

        ConexionBD.close();
    }
}
