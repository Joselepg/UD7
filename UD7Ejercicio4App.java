/**
 * @author Jose Luis Padilla Gonzalez
 * @version 14-07-2021
 */
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class UD7Ejercicio4App {
	//El metodo Relleno rellenara las arrayList con datos.
	public static void Relleno(ArrayList<String> producto, ArrayList<Double> precio, ArrayList<Double> iva, ArrayList<Double> total, ArrayList<Integer> stock) {
		producto.add("Champu");
		producto.add("Detergente");
		producto.add("Cepillo de dientes");
		producto.add("Mechero");


		precio.add(4.4);
		precio.add(2.3);
		precio.add(1.0);
		precio.add(0.95);

		
		iva.add(0.04);
		iva.add(0.04);
		iva.add(0.21);
		iva.add(0.21);

		total.add(4.57);
		total.add(3.2);
		total.add(1.21);
		total.add(1.19);


		stock.add(5);
		stock.add(4);
		stock.add(8);
		stock.add(2);

	}
	//El metodo Mostrar preguntara si quieres mostrar las arrayList, si la respuesta es si recorrera las arrayList y las imprimira por pantalla en orden de posicion.
	public static void Mostrar(ArrayList<String> producto, ArrayList<Double> precio, ArrayList<Double>  iva, ArrayList<Double> total, ArrayList<Integer> stock){
		String textoMostrar = JOptionPane.showInputDialog("¿Quieres ver la lista de productos?");
		if(textoMostrar.equalsIgnoreCase("Si")) {
			for (int i = 0; i < producto.size(); i++) {
				JOptionPane.showMessageDialog(null,"Producto: "+producto.get(i)+'\n'+"Precio: "+precio.get(i)+'\n'+"IVA aplicado: "+(iva.get(i)*100)+"%"+'\n'+"Precio total: "+total.get(i)+'\n'+"Numero de Stock: "+stock.get(i));
			}
		}
	}
	/*El metodo PreguntaCesta tendra dos variables double precioCesta y brutoCesta para contar el precio con y sin IVA de la cesta.
	 * Preguntara por cuantos productos has comprado y entrara en un bucle hasta que el contador llegue al numero de objetos comprados.
	 * Dentro de ese bucle te preguntara por que producto has comprado y cuantas unidades de ese producto has comprado.
	 * Para finalizar haremos un for que recorrera el arrayList de productos comparando la respuesta de que producto compraste con lo ya existentes y si hay un
	 * resultado igual a la respuesta de la pregunta, multiplicara el numero de veces que se ha comprado por el precio del producto con y sin IVA y lo añadira a precioCesta y brutoCesta
	 * para ira sumando el contador para que una vez los productos añadidos sean iguales al total acabe el bucle.
	 * Despues imprimira por pantalla el precio con y sin IVA y preguntara por la cantidad que desea pagar.
	 * Hara un calculo restandole al pago el precio de la cesta e imprimira finalmente el cambio a devolver.
	 */
	public static void PreguntaCesta(ArrayList<String> producto, ArrayList<Double> precio, ArrayList<Double> iva, ArrayList<Double> total) {
		double precioCesta = 0;
		double brutoCesta = 0;
		int contador = 0;
		String textoTotal = JOptionPane.showInputDialog("¿Cuantos productos has comprado?");
		int totalProducto = Integer.parseInt(textoTotal);
		while (contador < totalProducto) {
			String textoProducto = JOptionPane.showInputDialog("¿Que producto has comprado?");
			String textoNumProducto = JOptionPane
					.showInputDialog("¿Cuantas unidades de " + textoProducto + " has comprado?");
			int numProducto = Integer.parseInt(textoNumProducto);
			for (int i = 0; i < producto.size(); i++) {
				if (textoProducto.equalsIgnoreCase(producto.get(i))) {
					precioCesta += (total.get(i) * numProducto);
					brutoCesta += (precio.get(i) * numProducto);
				}
			}

			contador += numProducto;
		}
		JOptionPane.showMessageDialog(null,"El precio total es de "+precioCesta+" € con IVA y "+brutoCesta+" € sin IVA.");
		String textoPago = JOptionPane.showInputDialog("Ingrese la cantidad que efectuara para el pago.");
		double pago = Integer.parseInt(textoPago);
		double cambio = pago-precioCesta;
		JOptionPane.showMessageDialog(null,"El cambio será de "+cambio+" €");
	}
	//El metodo Añadir preguntara por el nombre del producto que quieres añadir, su stock, su precio y que IVA se aplicara, tambien calculara el precio total con ese IVA y añadira todos los datos a su correspondiente arrayList.
	public static void Añadir(ArrayList<String> producto, ArrayList<Double> precio, ArrayList<Double> total, ArrayList<Double> iva, ArrayList<Integer> stock,  boolean nuevoProducto) {
		String nuevo = JOptionPane.showInputDialog("¿Que producto quieres añadir?");
		producto.add(nuevo);
		String numProducto = JOptionPane.showInputDialog("¿Cuanta Stock de "+nuevo+" quieres añadir?");
		int stockProducto = Integer.parseInt(numProducto);
		stock.add(stockProducto);
		String precioProducto = JOptionPane.showInputDialog("¿Cual es el precio de "+nuevo+"?");
		double precioP = Double.parseDouble(precioProducto);
		precio.add(precioP);
		String ivaProducto = JOptionPane.showInputDialog("¿Cual es el IVA añadido de "+nuevo+"?");
		double ivaP = Double.parseDouble(ivaProducto);
		iva.add(ivaP);
		total.add(precioP*ivaP);
	}
	//El metodo preguntaAñadir preguntara si quieres añadir un nuevo producto si la respuesta es si devolvera el boolean nuevoProducto como true, en caso contrario lo devolvera como false.
	public static boolean PreguntaAñadir(boolean nuevoProducto) {
		String textoNuevo = JOptionPane.showInputDialog("¿Quieres añadir un nuevo producto?");
		if(textoNuevo.equals("Si")) {
			return nuevoProducto=true;
		}else return nuevoProducto=false;
	}
	/*El metodo main declarara una variable boolean nuevoProducto y las arrayList de preocuto, precio, iva, total y stock.
	 * Despues ejecutara el metodo Relleno y PreguntaCesta, si al ejecutar PreguntaAñadir la respuesta devuelve nuevoProducto como true se ejecutara el metodo Añadir.
	 * Para finalizar ejecutara el metodo Mostrar.
	 */
	public static void main(String[] args) {
		boolean nuevoProducto=false;
		ArrayList<String> producto = new ArrayList<>();
		ArrayList<Double> precio = new ArrayList<>();
		ArrayList<Double> iva = new ArrayList<>();
		ArrayList<Double> total = new ArrayList<>();
		ArrayList<Integer> stock = new ArrayList<>();
		Relleno(producto, precio, iva, total, stock);
		PreguntaCesta(producto, precio, iva, total);
		PreguntaAñadir(nuevoProducto);
		if(nuevoProducto=true) {
			Añadir(producto,precio,total,iva,stock,nuevoProducto);
		}
		Mostrar(producto, precio, iva, total, stock);

	}
}

