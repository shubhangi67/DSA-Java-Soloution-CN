package objectOrientedProgramming;

public class Student {
	String name;
	int rollnumber;

	public Student() {
		super();
	}

	public Student(String name, int rollnumber) {
		super();
		this.name = name;
		this.rollnumber = rollnumber;
	}

	public String getName() {
		return name;
	}

	public int getRollnumber() {
		return rollnumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollnumber=" + rollnumber + ", getName()=" + getName()
				+ ", getRollnumber()=" + getRollnumber() + "]";
	}

}
