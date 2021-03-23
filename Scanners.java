
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.StringWriter;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.cos;
import static java.lang.Math.sin;


public class Scanners {
	
	public static final double PI = 3.141592653589793238462643383279502884197169399375105820974944;
	public static final double E = 2.71828182845904523536028747135266249775724709369;
	
	public static double trapezoidalSum(double a, double b, int n){
		double deltaX = (b - a)/n;
		double currX = a;
		double ans = 0;
		int i;
		
		for(i = 0; i <= n; ++i) {
			if(i == 0 || i == n) {
				ans += equation(currX);
			}
			else {
				ans += 2 * equation(currX);
			}
			currX += deltaX;
		}
		
		ans *= (deltaX/2);
		
		return ans;
	}
	
	public static double simpsonSum(double a, double b, int n) {
		double deltaX = (b - a)/n;
		double currX = a;
		double ans = 0;
		int i;
		
		for(i = 0; i <= n; ++i) {
			if(i == 0 || i == n) {
				ans += equation(currX);
			}
			else {
				if(i%2 == 0) {
					ans += 2 * equation(currX);
				}
				else {
					ans += 4 * equation(currX);
				}
			}
			currX += deltaX;
		}
		
		ans *= (deltaX/3);
		
		return ans;
	}
	
	public static double equation(double currX) {
		/**
		 * the equation you are "summing up"
		 */
		double ans;
		ans = (2/sqrt(PI)) * pow(E,-1*pow(currX, 2));//remember to update equation!!!
		return ans;
	}

	public static void main(String[] args) {
		/**
		 * main simply scans for a, b, and n.
		 * If a or b include pi, square roots, or fractions, it would be easier to hardcode them
		 * uncomment whether you are using trapezoidal sum or simpson sum
		 */
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter the value of a:");
		double a = s.nextDouble();
		System.out.println(a);
		System.out.println("Please enter the value of b:");
		double b = s.nextDouble();
		System.out.println("Please enter the value of n:");
		int n = s.nextInt();
		
		//double result = trapezoidalSum(a, b, n);
		double result = simpsonSum(a, b, n);
		System.out.println(result);
	}
	
	
}
