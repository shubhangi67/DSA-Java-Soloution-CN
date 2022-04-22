package objectOrientedProgramming;

public class FractionUse {

	public static void main(String[] args) {
		Fraction f1 = new Fraction(4,6);
		f1.print();
		//f1.increment();
	
		Fraction f2 = new Fraction(4,8);
//		f1.add(f2);
//		f1.print();
//		f1.sub(f2);
//		f1.print();
		f1.mul(f2);
		f1.print();
//		Fraction f3 = Fraction.add(f1, f2);
//		f3.print();
	}

}
