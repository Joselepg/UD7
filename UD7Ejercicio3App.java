/**
 * @author Jose Luis Padilla Gonzalez
 * @version 14-07-2021
 */
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class UD7Ejercicio3App {
	//El metodo Relleno rellenara las arrayList con datos.
	public static void Relleno(ArrayList<String> producto, ArrayList<Double> precio, ArrayList<Integer> stock) {
		producto.add("Champu");
		producto.add("Detergente");
		producto.add("Cepillo de dientes");
		producto.add("Mechero");
		producto.add("Tabaco");
		producto.add("Boligrafo");
		producto.add("Lapiz");
		producto.add("Goma de borrar");
		producto.add("Bombilla");
		producto.add("Taza");

		precio.add(4.4);
		precio.add(2.3);
		precio.add(1.0);
		precio.add(0.95);
		precio.add(4.95);
		precio.add(0.3);
		precio.add(0.2);
		precio.add(2.3);
		precio.add(15.59);

		stock.add(5);
		stock.add(4);
		stock.add(8);
		stock.add(2);
		stock.add(5);
		stock.add(4);
		stock.add(8);
		stock.add(2);
		stock.add(10);
	}
	//El metodo Mostrar preguntara si quieres mostrar las arrayList, si la respuesta es si recorrera las arrayList y las imprimira por pantalla en orden de posicion.
	public static void Mostrar(ArrayList<String> producto, ArrayList<Double> precio, ArrayList<Integer> stock) {
		String textoMostrar = JOptionPane.showInputDialog("¿Quieres ver la lista de productos?");
			if(textoMostrar.equalsIgnoreCase("Si")) {
				for (int i = 0; i < producto.size(); i++) {
					JOptionPane.showMessageDialog(null,"Producto:"+producto.get(i)+'\n'+"Precio:"+precio.get(i)+'\n'+"Numero de Stock:"+stock.get(i));
				}
			}
	}
	//El metodo Añadir preguntara por el nombre del producto que quieres añadir, su stock y su precio y lo añadira a su correspondiente arrayList.
	public static void Añadir(ArrayList<String> producto, ArrayList<Double> precio, ArrayList<Integer> stock, boolean nuevoProducto) {
		String nuevo = JOptionPane.showInputDialog("¿Que producto quieres añadir?");
		producto.add(nuevo);
		String numProducto = JOptionPane.showInputDialog("¿Cuanta Stock de "+nuevo+"quieres añadir?");
		int stockProducto = Integer.parseInt(numProducto);
		stock.add(stockProducto);
		String precioProducto = JOptionPane.showInputDialog("¿Cual es el precio de "+nuevo+"?");
		double precioP = Double.parseDouble(precioProducto);
		precio.add(precioP);
	}
	//El metodo pregunta preguntara si quieres añadir un nuevo producto si la respuesta es si devolvera el boolean nuevoProducto como true, en caso contrario lo devolvera como false.
	public static boolean Pregunta(boolean nuevoProducto) {
		String textoNuevo = JOptionPane.showInputDialog("¿Quieres añadir un nuevo producto?");
		if(textoNuevo.equals("Si")) {
			return nuevoProducto=true;
		}else return nuevoProducto=false;
	}
	/*El metodo main declarara una variable boolean nuevoProducto y las arrayList de preocuto, precio y stock.
	 * Despues ejecutara el metodo Relleno y Pregunta, si al ejecutar Pregunta la respuesta devuelve nuevoProducto como true se ejecutara el metodo Añadir.
	 * Para finalizar ejecutara el metodo Mostrar.
	 */
	public static void main(String[] args) {
		boolean nuevoProducto=false;
		ArrayList<String> producto = new ArrayList<>();
		ArrayList<Double> precio = new ArrayList<>();
		ArrayList<Integer> stock = new ArrayList<>();
		Relleno(producto,precio,stock);
		Pregunta(nuevoProducto);
		if(nuevoProducto=true) {
			Añadir(producto,precio,stock,nuevoProducto);
		}
		Mostrar(producto,precio,stock);

	}

}
