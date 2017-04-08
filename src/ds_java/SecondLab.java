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
			Reverse(input);
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
				
				
				
			}
		}
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
				if(dotIndex != -1)
					throw new IllegalArgumentException("���ʽ���󣬱��ʽ��ֻ������һ��С����");
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
