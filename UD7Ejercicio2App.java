/**
 * @author Jose Luis Padilla Gonzalez
 * @version 14-07-2021
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UD7Ejercicio2App {
	//El metodo Relleno rellenara las arrayList con datos.
	public static void Relleno(ArrayList<String> producto, ArrayList<Double> precio, ArrayList<Double> iva, ArrayList<Double> total) {
		producto.add("Pan");
		producto.add("Agua");
		producto.add("Coca Cola");
		producto.add("Macarrones");

		precio.add(0.4);
		precio.add(0.3);
		precio.add(2.0);
		precio.add(2.3);

		iva.add(0.04);
		iva.add(0.04);
		iva.add(0.21);
		iva.add(0.21);

		total.add(0.41);
		total.add(0.41);
		total.add(2.42);
		total.add(2.48);

	}
	//El metodo Mostrar recorrera las arrayList y las imprimira por pantalla en orden de posicion.
	public static void Mostrar(ArrayList<String> producto, ArrayList<Double> precio, ArrayList<Double> iva, ArrayList<Double> total){
		for (int i = 0; i < producto.size(); i++) {
			JOptionPane.showMessageDialog(null,"Producto:"+producto.get(i)+'\n'+"IVA aplicado:"+(iva.get(i)*100)+"%");
		}
	}
	/*El metodo Pregunta tendra dos variables double precioCesta y brutoCesta para contar el precio con y sin IVA de la cesta.
	 * Preguntara por cuantos productos has comprado y entrara en un bucle hasta que el contador llegue al numero de objetos comprados.
	 * Dentro de ese bucle te preguntara por que producto has comprado y cuantas unidades de ese producto has comprado.
	 * Para finalizar haremos un for que recorrera el arrayList de productos comparando la respuesta de que producto compraste con lo ya existentes y si hay un
	 * resultado igual a la respuesta de la pregunta, multiplicara el numero de veces que se ha comprado por el precio del producto con y sin IVA y lo añadira a precioCesta y brutoCesta
	 * para ira sumando el contador para que una vez los productos añadidos sean iguales al total acabe el bucle.
	 * Despues imprimira por pantalla el precio con y sin IVA y preguntara por la cantidad que desea pagar.
	 * Hara un calculo restandole al pago el precio de la cesta e imprimira finalmente el cambio a devolver.
	 */
	public static void Pregunta(ArrayList<String> producto, ArrayList<Double> precio, ArrayList<Double> iva, ArrayList<Double> total) {
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

	public static void main(String[] args) {
		ArrayList<String> producto = new ArrayList<>();
		ArrayList<Double> precio = new ArrayList<>();
		ArrayList<Double> iva = new ArrayList<>();
		ArrayList<Double> total = new ArrayList<>();
		Relleno(producto, precio, iva, total);
		Mostrar(producto, precio, iva, total);
		Pregunta(producto, precio, iva, total);
		
	}

}
