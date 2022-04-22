package objectOrientedProgramming.assignment1;

import java.util.Scanner;

public class ComplexNumberUse {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int real1 = s.nextInt();
		int imaginary1 = s.nextInt();
		int real2 = s.nextInt();
		int imaginary2 = s.nextInt();
		ComplexNumber c1 = new ComplexNumber(real1, imaginary1);
		ComplexNumber c2 = new ComplexNumber(real2, imaginary2);
		c1.print();
		c2.print();
//		c1.add(c2);
//		c1.print();
		c1.multiply(c2);
		c1.print();
	}

}
