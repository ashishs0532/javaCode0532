package src.main.java.com.tax;

import java.util.ArrayList;
import java.util.Scanner;

class Tax {
	int qty = 0;
	String prodName = null;
	float price = 0.0f;
	boolean imported = false;
	boolean exempted = false;
	float tax = 0.0f;

	void calculateSalesTax() {
		float totalTax = 0.0f;
		if (imported)
			totalTax = 0.05f;
		if (!exempted)
			totalTax = .1f;
		if ((imported) && (!exempted))
			totalTax = .15f;
		tax = totalTax * price;
	}

	public String toString() {
		float p = price + tax;
		return qty + " " + prodName + " at " + p;
	}
}

public class SalesTaxCalculator {
	public static void main(String[] args) throws Exception {
		SalesTaxCalculator st = new SalesTaxCalculator();
		Scanner input = new Scanner(System.in);
		ArrayList list = new ArrayList();
		int no = 1;
		while (true) {
			Tax tax = new Tax();
			System.out.println("Add Products: " + no);
			System.out.print("Quantity: ");
			int qty = input.nextInt();
			tax.qty = qty;
			System.out.print("Product Name: ");
			String prod = input.next();
			tax.prodName = prod;
			System.out.print("Price: ");
			float p = input.nextFloat();
			tax.price = p;
			System.out.print("Is it Imported[y/n]: ");
			String imp = input.next();
			if (imp.toLowerCase().equals("y"))
				tax.imported = true;
			System.out.print("Is it Exempted[y/n]: ");
			String exe = input.next();
			if (exe.toLowerCase().equals("y"))
				tax.exempted = true;
			tax.calculateSalesTax();
			list.add(tax);
			no++;
			System.out.print("Add More Products [y/n]: ");
			String add = input.next();
			if (add.toLowerCase().equals("n"))
				break;
		}
		float tp = 0.0f;
		float tt = 0.0f;
		for (int i = 0; i < list.size(); i++) {
			Tax tax = (Tax) list.get(i);
			tp += tax.price;
			tt += tax.tax;
			System.out.println(tax);
		}

		System.out.println("Sales Taxes:" + tt);
		System.out.println("Total: " + (tp + tt));

	}

}