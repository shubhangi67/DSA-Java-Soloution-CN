package objectOrientedProgramming.assignment1;

public class ComplexNumber {
	int real;
	int imaginary;

	public ComplexNumber(int real, int imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	public int getReal() {
		return real;
	}

	public void setReal(int real) {
		this.real = real;
	}

	public int getImaginary() {
		return imaginary;
	}

	public void setImaginary(int imaginary) {
		this.imaginary = imaginary;
	}

	public void print() {
		System.out.println(real + " + " + imaginary + "i");
	}

	public void add(ComplexNumber c2) {
		this.real = this.real + c2.real;
		this.imaginary = this.imaginary + c2.imaginary;
	}

	public void multiply(ComplexNumber c2) {
		int newreal = this.real*c2.real - this.imaginary*c2.imaginary;
		int newimaginary =this.imaginary= this.real*c2.imaginary + this.imaginary*c2.real;
		this.real =newreal;
		this.imaginary=newimaginary ;
		
	}
}
