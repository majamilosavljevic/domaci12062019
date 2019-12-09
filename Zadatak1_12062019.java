package domaci_12062019;

public class Zadatak1_12062019 {

	public static double sumColumn(String excelPath, int workSheet, int column) {

		ExcelUtils.setExcell(excelPath);
		ExcelUtils.setWorkSheet(workSheet);
		double sum = 0;
		for (int i = 0; i < ExcelUtils.getRowNumber(); i++) {
			double temp = Double.parseDouble(ExcelUtils.getDataAt(i, column));
			sum += temp;
		}
		return sum;

	}

	public static void main(String[] args) {
		/*
		 * Napisati program koji racuna sumu brojeva koji se nalaze prvom worksheet-u
		 * Excel tabele koji se zove Brojevi. U tabeli se svi brojevi nalaze u prvoj
		 * koloni. Program treba da cita red po red iz tabele i upisane brojeve dodaje
		 * na sumu. Krajnju sumu nakon toga treba da ispise u konzoli. Potrebno je
		 * omoguciti da program radi i ukoliko se u datu tabelu doda jos brojeva
		 * (isprobati!)
		 * 
		 * Hint: Pogledajte ApachePOI biblioteke kako biste našli metodu koja vraća
		 * index poslednjeg reda koji je ubačen. Istraziti kako neki String prevesti u
		 * int.
		 */

		System.out.println(sumColumn("C:\\Users\\Maja\\eclipse-workspace\\domaci_zadaci\\Brojevi.xlsx", 0, 0));

	}

}
