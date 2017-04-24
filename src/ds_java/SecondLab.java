package ds_java;

import java.util.Scanner;
import java.util.Stack;

public class SecondLab {
	public static void main(String[] args){
		System.out.println("����һ����׺���ʽ�������Ҫ�˳�������exit");
		Scanner scanner = new Scanner(System.in);
		String input = "";
		input = scanner.nextLine();
		while(input.length()!= 0 && !"exit".equalsIgnoreCase(input)){
			System.out.println("��׺���ʽ��");
			System.out.println(input);
			System.out.println("��׺���ʽ��");
			try{
				Reverse(input);
				}catch (NumberFormatException e){
					System.out.println("\npinput error, not a number");
					
				}catch (IllegalArgumentException e){
					System.out.println("\ninput error:" + e.getMessage());
					
				}catch (Exception e){
					System.out.println("\ninput error, invalid expression");
					
				}
			
			System.out.println("��������һ�����ʽ��exit�˳�");
			input = scanner.nextLine();
		}
		System.out.println("program exit");
	}
	
	/*����׺���ʽ��д�ɺ�׺���ʽ*/
	private static void Reverse(String input) throws IllegalArgumentException, NumberFormatException{
		int len = input.length();
		char c,tempchar;
		Stack<Character> s1 = new Stack<Character>();//s1��Ų�����
		Stack<Double> s2 = new Stack<Double>();//s2��Ų�����
		double number;
		int lastIndex = -1;
		for(int i=0; i<len; ++i){
			c = input.charAt(i);
			if (Character.isDigit(c) || c == '.'){
				lastIndex = readDouble(input, i);
				number = Double.parseDouble(input.substring(i, lastIndex));//���ַ���������ת��Ϊdouble����
				s2.push(number);//�������־ͽ�ջ
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
						throw new IllegalArgumentException("������ʽ�������Ų���ƥ��");
					}
				}
			}else if (c == ' '){
				//�����м�Ŀո�
			}else {
				throw new IllegalArgumentException("������ַ�����:" + c + " ");
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
			throw new IllegalArgumentException("����ı��ʽ����");
		System.out.println();
		if ((int) result == result)
			System.out.println("the result is " + (int) result);
		else
			System.out.println("the result is " + result);
	}
	
	/*������*/
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
				throw new IllegalArgumentException("����������Ϊ0");
			return num1 / num2;
		default:
				return 0;
		}
	}
	
	/*�ж���������������ȼ�
	 * ƽ������0
	 * op1����op2����1
	 * op1С��op2����0
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
	
	/*�ж��Ƿ������*/
	private static boolean isOperator(char c){
		return( c == '+' || c == '-' || c == '*' || c == '/');
	}
	
	//��ȡ�ļ�λ�����֣����ص������ֽ�����λ��
	private static int readDouble(String input, int start) throws IllegalArgumentException{
		int len = input.length();
		int dotIndex = -1;
		char c;
		for (int i = start; i<len; ++i){
			c = input.charAt(i);
			//�ж�С����
			if(c == '.'){
				if(dotIndex != -1){
					throw new IllegalArgumentException("���ʽ���󣬱��ʽ��ֻ������һ��С����");
				}
				else if ( i == len-1)
					throw new IllegalArgumentException("С���㲻�������һλ");
				else dotIndex = i;
			}else if (!Character.isDigit(c)){
				if(dotIndex == -1 || i - dotIndex > 1)
					return i;
				else throw new IllegalArgumentException("С�����λ�ô���");
			}else if (i == len - 1){
				return len;
			}
		}
		throw new IllegalArgumentException("����Ĳ���һ������");
	}
}
