/**
 * @author Jose Luis Padilla Gonzalez
 * @version 14-07-2021
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
public class UD7Ejercicio1App {
	//El metodo Mostrar recorrera las arrayList y las mostrara por pantalla en orden.
	public static void  Mostrar(ArrayList<String>list, ArrayList<Double>nota1, ArrayList<Double>nota2, ArrayList<Double>media) {
		for (int i = 0; i < list.size(); i++) {
			JOptionPane.showMessageDialog(null,"Nombre: "+list.get(i)+"\n"+"Nota UF1: "+nota1.get(i)+"\n"+"Nota UF2: "+nota2.get(i)+"\n"+"Media total: "+media.get(i));
		}
	}
	//El metodo Relleno añadira los datos a las arrayList.
	public static void Relleno(ArrayList<String>list, ArrayList<Double>nota1, ArrayList<Double>nota2){
		list.add("Antonio");
		list.add("Maria");
		list.add("Manuel");
		
		nota1.add(6.2);
		nota1.add(4.8);
		nota1.add(7.9);
		
		nota2.add(3.9);
		nota2.add(7.2);
		nota2.add(8.9);
	}
	//El metodo media calculara las medias de los alumnos y las añadira al arrayList media.
	public static void Media(ArrayList<String>list, ArrayList<Double>nota1, ArrayList<Double>nota2, ArrayList<Double>media) {
		for(int i = 0; i < list.size(); i++) {
			media.add((nota1.get(i)+nota2.get(i))/2);
		}
		
	}
	//El metodo main tendra declaradas las arrayList y luego ejecutara los metodos Relleno, Media y Mostrar.
	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<>();
		ArrayList<Double> nota1=new ArrayList<>();
		ArrayList<Double> nota2=new ArrayList<>();
		ArrayList<Double> media=new ArrayList<>();
		Relleno(list, nota1, nota2);
		Media(list, nota1, nota2, media);
		Mostrar(list, nota1, nota2, media);
	}

}
