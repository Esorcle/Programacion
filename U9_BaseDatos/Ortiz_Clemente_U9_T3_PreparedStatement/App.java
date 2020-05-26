import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ADClassicModels adClassicModels = new ADClassicModels();
        int opcion = 1;
        boolean inserted = false;
        boolean update = false;
        int salesID;
        int customerID;
        String productCode;
        int orderNumber;
        int quantifyOrdered;

        while (opcion != 5) {
            System.out.println("--------------------------------------------------");
            System.out.println("¡Bienvenid@!\n");
            System.out.println("Indique, mediante el número correspondiente, la opción que desea realizar:");
            System.out.println("1.\tInsertar cliente");
            System.out.println("2.\tAsignar empleado a cliente");
            System.out.println("3.\tAñadir producto a pedido");
            System.out.println("4.\tMostrar con detalle un pedido");
            System.out.println("5.\tSalir de la aplicación");
            System.out.println("--------------------------------------------------");
            opcion = sc.nextInt();
            sc.nextLine();


            switch (opcion) {
                case 1:
                    inserted = false;
                    //Llamo al método para instroducir datos
                    Customer customer = takeData();

                    try {
                        //Recibo el estado del método llamado
                        inserted = adClassicModels.insertCustomer(customer);

                        //Lanzo mensaje al usuario según estado recibido
                        if (inserted) {
                            System.out.println("Se ha introducido el cliente correctamente\n");
                        } else {
                            System.out.println("Error al introducir el cliente.\nCompruebe los campos y vuelva a intentarlos\n");
                        }

                    } catch (ClassicModelsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    //Reinicio valor
                    update = false;

                    //Pido datos
                    System.out.println("Indique el número de cliente");
                    customerID = sc.nextInt();
                    System.out.println("Indique el número de vendedor");
                    salesID = sc.nextInt();

                    try {
                        //Recibo estado del método llamado
                        update = adClassicModels.assingnSales(salesID, customerID);

                        //Lanzo mensaje al usuario según estado recibido
                        if (update) {
                            System.out.println("Se ha actualizado el vendedor del cliente\n");
                        } else {
                            System.out.println("Error en la actualización\nCompruebe los campos y vuelva a intentarlos\n");
                        }
                    } catch (ClassicModelsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    //Reinicio valor
                    inserted = false;

                    //Pido datos
                    System.out.println("Indique el número del pedido");
                    orderNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Indique el código del producto");
                    productCode = sc.nextLine();
                    System.out.println("Indique la cantidad de producto");
                    quantifyOrdered = sc.nextInt();
                    sc.nextLine();

                    try {
                        //Recibo estado del método llamado
                        inserted = adClassicModels.insertProductoOrder(productCode, orderNumber, quantifyOrdered);

                        //Lanzo mensaje al usuario según estado recibido
                        if (inserted) {
                            System.out.println("Se ha introducido el producto en el pedido\n");
                        } else {
                            System.out.println("Fallo al introducir el producto\nCompruebe los campos y vuelva a intentarlos\n");
                        }
                    } catch (ClassicModelsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    //Pido datos
                    System.out.println("Indique el número del pedido");
                    orderNumber = sc.nextInt();

                    try {
                        adClassicModels.orderToString(orderNumber);
                    } catch (ClassicModelsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Te echaremos de menos");
                    //Cierro Scanner
                    sc.close();
                    //Cierro conexión
                    ConexionBD.close();
                    break;

                default:
                    System.out.println("Introduzca un número correcto (entre 1 y 5)\n");
                    break;
            }
        }
    }

    public static Customer takeData() {

        //Creo varaibles
        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer();

        //Pido datos
        System.out.println("Dame customerNumber: ");
        customer.setCustomerNumber(sc.nextInt());
        //Limpiar buffer de entrada (Scanner)
        sc.nextLine();
        System.out.println("Dame customerName: ");
        customer.setCustomerName(sc.nextLine());
        System.out.println("Dame contactLastName: ");
        customer.setContactLastName(sc.nextLine());
        System.out.println("Dame contactFirstName: ");
        customer.setContactFirstName(sc.nextLine());
        System.out.println("Dame phone: ");
        customer.setPhone(sc.nextLine());
        System.out.println("Dame addressLine1: ");
        customer.setAddressLine1(sc.nextLine());
        System.out.println("Dame addressLine2: ");
        customer.setAddressLine2(sc.nextLine());
        System.out.println("Dame city: ");
        customer.setCity(sc.nextLine());
        System.out.println("Dame state: ");
        customer.setState(sc.nextLine());
        System.out.println("Dame postalCode: ");
        customer.setPostalCode(sc.nextLine());
        System.out.println("Dame country: ");
        customer.setCountry(sc.nextLine());
        System.out.println("Dame creditLimit: ");
        String aux = sc.nextLine();
        if ("".equals(aux)) {
            customer.setCreditLimit(null);
        } else {
            Float aux2 = Float.parseFloat(aux);
            customer.setCreditLimit(aux2);
        }
        System.out.println("Dame sales Employee Number: ");
        aux = sc.nextLine();
        if ("".equals(aux)) {
            customer.setSalesRepEmployeeNumber(null);
        } else {
            int aux2 = Integer.parseInt(aux);
            customer.setSalesRepEmployeeNumber(aux2);
        }


        return customer;
    }
}
