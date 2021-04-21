import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AleatorioEmple {

	public static void main(String[] args) throws IOException {
		crear();
		leer();
	}

	public static void leer() throws IOException {
		File fichero = new File("AleatorioEmple.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		char cad[] = new char[10], aux;
		String nom;
		double salario;
		int pos, num, dep;
		if (file.length() > 0) {
			pos = 0;
			System.out.println(" ------------------------------------------");
			System.out.println(" - - - VISUALIZO POR CONSOLA - - - - ");
			for (;;) {
				file.seek(pos);
				num = file.readInt();
				for (int i = 0; i < cad.length; i++) {
					aux = file.readChar();
					cad[i] = aux;
				}
				nom = new String(cad);
				dep = file.readInt();
				salario = file.readDouble();
				System.out.println("Empleado: " + nom + ", numero:" + num + ", dep: " + dep + ", salario: " + salario);
				pos = pos + 36;

				if (file.getFilePointer() == file.length())
					break;

			} 
			file.close(); 
			System.out.println(" ------------------------------------------");
		} else 
			System.out.println(" ---------FICHERO VACÍO --------------------");
	}// fin verporconsola

	public static void crear() throws IOException {
		File fichero = new File("AleatorioEmple.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		String apellido[] = { "FERNANDEZ", "GIL", "LOPEZ", "RAMOS", "SEVILLA", "CASILLA", "REY" };
		int dep[] = { 10, 20, 10, 10, 30, 30, 20 }; 
		Double salario[] = { 1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0 };

		StringBuffer buffer = null;
		int n = apellido.length;

		for (int i = 0; i < n; i++) {
			file.writeInt(i + 1);
			buffer = new StringBuffer(apellido[i]);
			buffer.setLength(10);
			file.writeChars(buffer.toString());
			file.writeInt(dep[i]);
			file.writeDouble(salario[i]);
		}
		file.close();
	}// fin crear

}// fin class
