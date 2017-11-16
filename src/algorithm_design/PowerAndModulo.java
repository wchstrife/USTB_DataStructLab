package algorithm_design;

import java.util.Scanner;

/*
 * 分治法求幂指数取模
 */
public class PowerAndModulo {

	public static void main(String[] args) {
		
		PowerAndModulo power = new PowerAndModulo();
	
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		
		while(!string.equals("exit")){
			String[] params = string.split(" ");
			int a = Integer.parseInt(params[0]);
			int b = Integer.parseInt(params[1]);
			int c = Integer.parseInt(params[2]);
			System.out.println(power.powMod(a, b, c));
			
			string = scanner.nextLine();
		}		
	}

	public int powMod(int a, int b, int c){
		int ans = 1;
		a =a % c;
		while(b > 0){
			if(b % 2 == 1)
				ans = (ans * a) %c;
			b = b/2;
			a = (a*a) % c;
		}
		
		return ans;
	}
}
