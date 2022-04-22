package recursion1;

import java.util.Scanner;

public class TowerOfHonoi {
	public static void towerOfHonoi(int disks,char source,char aux,char destination)
	{
		if(disks==0)
		{
			return;
		}
		if(disks==1)
        {
            System.out.println(source+" "+destination); 
        }
        else 
        {
            towerOfHonoi(disks-1,source,destination,aux);
            System.out.println(source+" "+destination);
            towerOfHonoi(disks-1,aux,source,destination);

        }
		
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		towerOfHonoi(n, 'a', 'b', 'c');

	}

}
