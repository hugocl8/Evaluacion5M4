import java.util.Scanner;
import java.util.ArrayList;

class Producto{
    private String nombre;
    private int valor;
    private String descripcion;

    public Producto(String nombre, int valor, String descripcion){
        this.nombre = nombre;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    @Override
    public String toString(){
        return "Producto:" + nombre + " - Valor: " + valor + " - Descripcion: " + descripcion;
    }
}

public class TiendaProductos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Producto("chocolate", 500, "chocolate amargo, 500gr"));
        productos.add(new Producto("leche", 800, "leche entera, 1 litro"));
        productos.add(new Producto("arroz", 900, "arroz grado 2, 1 kilo"));

        boolean continuar = true;

        while (continuar) {
            System.out.println("Elija una opción: ");
            System.out.println("1. Ver productos");
            System.out.println("2. Agregar producto");
            System.out.println("3. Modificar producto");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n ---Lista de productos---");
                    for (Producto producto : productos) {
                        System.out.println(producto);
                    }
                    break;
                case 2:
                    if (productos.size() < 7) {
                        System.out.println("Ingrese el nombre del producto");
                        String nombre = scanner.nextLine();
                        System.out.println("Ingrese el valor del producto");
                        int valor = scanner.nextInt();
                        System.out.println("Ingrese el descripcion del producto");
                        String descripcion = scanner.nextLine();
                        productos.add(new Producto(nombre, valor, descripcion));
                        System.out.println("Producto agregado con éxito.");
                    } else {
                        System.out.println("No se pueden agregar más productos, el límite se alcanzo");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del producto que desea modificar:");
                    String nombreModificar = scanner.nextLine();
                    boolean encontrado = false;
                    for (Producto producto : productos) {
                        if (producto.getNombre().equalsIgnoreCase(nombreModificar)) {
                            System.out.println("Ingrese el nuevo valor del producto: ");
                            int nuevoValor = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Ingrese la nueva descripcion del producto: ");
                            String nuevaDescripcion = scanner.nextLine();
                            producto.setValor(nuevoValor);
                            producto.setDescripcion(nuevaDescripcion);
                            System.out.println("Producto modificado con exito.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No existe el producto con ese nombre");
                    }
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        scanner.close();
    }
}
