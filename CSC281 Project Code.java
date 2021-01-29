import java.util.Scanner;

public class ProjectCRT281 {

	
	
public static void main(String[] args) {
Scanner input = new Scanner(System.in);

	System.out.println("Enter the number of equations ");
			int n = input.nextInt();
			int a[] = new int[n];
			int ay[] = new int[n];
			int b[] = new int[n];
			int m[] = new int[n];
			int mCapital[] = new int[n];
			int mProduct = 1;
			int solution = 0;
			
			System.out.println("Only positive non-zero numbers are allowed");
			for(int i = 0; i<n; i++) {
				a[i] = input.nextInt();
			    b[i] = input.nextInt();
				m[i] = input.nextInt();

			     }
			
	if(hasASolution(n, a, m)) {
		
			for(int i = 0; i<n; i++)
				mProduct *= m[i];
			
			for(int i = 0; i<n; i++)
		     mCapital[i] = mProduct/m[i];
	
			for(int i = 0; i<n; i++)
			ay[i] = modInverse(a[i], m[i]);

			for(int i = 0; i<n; i++) {
				solution += ay[i] * b[i] * mCapital[i] * modInverse(mCapital[i], m[i]);
			}
			
	System.out.println("The solution is: "+solution % mProduct);
	
	}
	
	System.out.println("Members of the group are: \nAbdullah Alminqah 436106859 (Serial Number: 4)\nSaad Al Dosari 436107296 (Serial Number: 3)\nKhalid Alqahtani 439101993 (Serial Number: 20) \nAhmad Alsohail 439100981 (Serial Number: 9)\nAhmed Alfaifi 439101587 (Serial Number: 12) ");
}

static int gcd(int n1, int n2) {
	int gcd = 1;
    for(int i = 1; i <= n1 && i <= n2; ++i)
    {
        
        if(n1 % i==0 && n2 % i==0)
            gcd = i;
        
        
    }
    return gcd;

}

static boolean hasASolution(int n, int []a, int []m) {
	for(int i = 0; i<n; i++) {
		if(gcd(a[i], m[i]) != 1) {
			System.out.println("No solution because m is not 1");
		return false;
	}
	}
	for(int i = 0; i<n; i++)
		for(int j = 1; j<n; j++) 
			if((j != i) && (gcd(m[i], m[j]) != 1)) {
				System.out.println("No solution because modulos are not pairwise relatively prime");
	return false;
}
	return true;
}

static int modInverse(int a, int m) 
{ 
    int mm = m; 
    int y = 0, x = 1; 

    if (m == 1) 
        return 0; 

    while (a > 1) { 
        
        int q = a / m; 

        int t = m; 

        
        m = a % m; 
        a = t; 
        t = y; 

       
        y = x - q * y; 
        x = t; 
    } 

    
    if (x < 0) 
        x += mm; 

    return x; 
} 

}