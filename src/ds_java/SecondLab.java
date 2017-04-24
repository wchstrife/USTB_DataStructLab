package ds_java;

import java.util.Scanner;
import java.util.Stack;

public class SecondLab {
	public static void main(String[] args){
		System.out.println("输入一个中缀表达式，如果需要退出请输入exit");
		Scanner scanner = new Scanner(System.in);
		String input = "";
		input = scanner.nextLine();
		while(input.length()!= 0 && !"exit".equalsIgnoreCase(input)){
			System.out.println("中缀表达式：");
			System.out.println(input);
			System.out.println("后缀表达式：");
			try{
				Reverse(input);
				}catch (NumberFormatException e){
					System.out.println("\npinput error, not a number");
					
				}catch (IllegalArgumentException e){
					System.out.println("\ninput error:" + e.getMessage());
					
				}catch (Exception e){
					System.out.println("\ninput error, invalid expression");
					
				}
			
			System.out.println("请再输入一个表达式，exit退出");
			input = scanner.nextLine();
		}
		System.out.println("program exit");
	}
	
	/*将中缀表达式改写成后缀表达式*/
	private static void Reverse(String input) throws IllegalArgumentException, NumberFormatException{
		int len = input.length();
		char c,tempchar;
		Stack<Character> s1 = new Stack<Character>();//s1存放操作码
		Stack<Double> s2 = new Stack<Double>();//s2存放操作数
		double number;
		int lastIndex = -1;
		for(int i=0; i<len; ++i){
			c = input.charAt(i);
			if (Character.isDigit(c) || c == '.'){
				lastIndex = readDouble(input, i);
				number = Double.parseDouble(input.substring(i, lastIndex));//把字符串的数字转化为double类型
				s2.push(number);//遇到数字就进栈
				i = lastIndex - 1;
				if ((int) number == number)
					System.out.print((int) number + " ");
				else
					System.out.print(number + " ");
			}else if(isOperator(c)){
				while(!s1.isEmpty() && s1.peek() != '(' && priortyCompare(c, s1.peek()) <= 0){
					System.out.print(s1.peek() + " ");
					double num1 = s2.pop();
					double num2 = s2.pop();
					s2.push(calc(num2, num1, s1.pop()));
				}
				s1.push(c);
			}else if (c == '('){
				s1.push(c);
			}else if (c == ')'){
				while ((tempchar = s1.pop()) != '('){
					System.out.print(tempchar + " ");
					double num1 = s2.pop();
					double num2 = s2.pop();
					s2.push(calc(num2, num1, tempchar));
					if(s1.isEmpty()){
						throw new IllegalArgumentException("输入表达式有误，括号不能匹配");
					}
				}
			}else if (c == ' '){
				//忽略中间的空格
			}else {
				throw new IllegalArgumentException("输入的字符有误:" + c + " ");
			}
		}
		while (!s1.isEmpty()){
			tempchar = s1.pop();
			System.out.print(tempchar + " ");
			double num1 = s2.pop();
			double num2 = s2.pop();
			s2.push(calc(num2, num1, tempchar));			
		}
		double result = s2.pop();
		if(!s2.isEmpty())
			throw new IllegalArgumentException("输入的表达式错误");
		System.out.println();
		if ((int) result == result)
			System.out.println("the result is " + (int) result);
		else
			System.out.println("the result is " + result);
	}
	
	/*计算结果*/
	private static double calc(double num1, double num2, char op){
		switch(op){
		case '+' :
			return num1 + num2;
		case '-' :
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '/':
			if (num2 == 0)
				throw new IllegalArgumentException("被除数不能为0");
			return num1 / num2;
		default:
				return 0;
		}
	}
	
	/*判断两个操作码的优先级
	 * 平级返回0
	 * op1大于op2返回1
	 * op1小于op2返回0
	 * */
	private static int priortyCompare(char op1, char op2){
		switch(op1){
		case '+':
		case '-':
			return (op2 == '*' || op2 == '/' ? -1 : 0);
		case '*':
		case '/':
			return (op2 == '+' || op2 == '-' ? 1 :0);
		}
		return 1;
	}
	
	/*判断是否操作码*/
	private static boolean isOperator(char c){
		return( c == '+' || c == '-' || c == '*' || c == '/');
	}
	
	//读取哪几位是数字，返回的是数字结束的位置
	private static int readDouble(String input, int start) throws IllegalArgumentException{
		int len = input.length();
		int dotIndex = -1;
		char c;
		for (int i = start; i<len; ++i){
			c = input.charAt(i);
			//判断小数点
			if(c == '.'){
				if(dotIndex != -1){
					throw new IllegalArgumentException("表达式错误，表达式中只可以有一个小数点");
				}
				else if ( i == len-1)
					throw new IllegalArgumentException("小数点不能在最后一位");
				else dotIndex = i;
			}else if (!Character.isDigit(c)){
				if(dotIndex == -1 || i - dotIndex > 1)
					return i;
				else throw new IllegalArgumentException("小数点的位置错误");
			}else if (i == len - 1){
				return len;
			}
		}
		throw new IllegalArgumentException("输入的不是一个数字");
	}
}
