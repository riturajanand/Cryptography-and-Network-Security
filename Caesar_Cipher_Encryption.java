
import java.util.Scanner;

public class Caesar_Cipher_Encryption 
{

	public static String caesar_cipher_encryption(String message)
	{
		/*
		 * Here the ley will be randomly generated by the system 
		 * Key will lie in [1 255]
		 */
		int key= 1+ (int) (Math.random()*255);
		String cipher_text="";
		
		int n=message.length();
		for(int i=0;i<n;i++)
		    cipher_text+=(char) ((message.charAt(i)+key)%256);
		
		/*
		 * Now when we transmit the message we need to provide the key also.
		 * In order to pass the key we will insert the key at end of the message by 
		 * appending the particular kth character in from the ASCII set. 
		 */
		cipher_text+= (char) key;
		return cipher_text;
		
	}
	
	public static String caesar_cipher_decryption(String message)
	{
		//extract the key first 
		int n=message.length();
		int key=message.charAt(n-1);
		n--;
		//Decrypt the message 
		String original_message="";
		for(int i=0;i<n;i++)
		{
			/*
			 * If the ascii value comes less than 0 then add 256 to it 
			 */
			int val=message.charAt(i)-key;
			if(val<0)
				val=256+val;
			original_message+=(char) (val%256);
		}
		return original_message;
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the message to be transmitted:");
		String s=input.nextLine();
		String encrypted_message=caesar_cipher_encryption(s);
		System.out.println("Cipher text is:"+encrypted_message);
		String decrypted_message=caesar_cipher_decryption(encrypted_message);
		System.out.println("Decrypted message is:"+decrypted_message);
		int len=encrypted_message.length();
		Caesar_Cipher_Brute_Froce_Attack.caesar_cipher_brute_force_attack(encrypted_message);
	}

}
