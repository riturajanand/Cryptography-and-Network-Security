import java.util.HashSet;
import java.util.Scanner;
public class Caesar_Cipher_Brute_Froce_Attack 
{

	public static void caesar_cipher_brute_force_attack(String message)
	{
		/*
		 * Here we will try all possible keys in the range [1-255]
		 * and if there are some special symbols other than some commonly used symbols 
		 * in a conversation. 
		 */
		System.out.println("Attcking with brute force");
		HashSet<Character> special_symbols=new HashSet<Character>();
		special_symbols.add('<');  special_symbols.add('>'); special_symbols.add('?');
		special_symbols.add('/');  special_symbols.add(':'); special_symbols.add(';');
		special_symbols.add('[');  special_symbols.add('{'); special_symbols.add(']');
		special_symbols.add('\"');  special_symbols.add('\''); special_symbols.add(';');
		special_symbols.add('}');  special_symbols.add('|'); special_symbols.add('\\');
		special_symbols.add('+');  special_symbols.add('='); special_symbols.add('-');
		special_symbols.add('_');  special_symbols.add(')'); special_symbols.add('(');
		special_symbols.add('!');  special_symbols.add('@'); special_symbols.add('#');
		special_symbols.add('$');  special_symbols.add('%'); special_symbols.add('^');
		special_symbols.add('&');  special_symbols.add('*'); special_symbols.add('~');
		special_symbols.add('`');  special_symbols.add(' ');
		
		for(int key=1;key<=255;key++)
		{
			String out="";
			int n=message.length();
			boolean print=true;
			for(int i=0;i<n;i++)
			{
				int val=message.charAt(i)-key;
				if(val<0)
					val=256+val;
				char ch=(char) (val%256);
		        /*
		         * if we have any other character other than the alphabtes, numbers and 
		         * specified characters than it would not be a normal conversation
		         */
				if((ch>=97 && ch<=122) || (ch>=65 && ch<=90) ||(ch>=48 && ch<=57)|| special_symbols.contains(ch))
				  out+=ch;
				else
				{
					print=false;
					break;
				}

			}
			if(print)
				System.out.println(key+" "+out);
			
		}
		System.out.println("End of brute force");
		
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the cipher text:");
		String cipher_text=input.nextLine();
		caesar_cipher_brute_force_attack(cipher_text);
		

	}

}
