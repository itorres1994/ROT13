package cipher;

public class ROT13 {
	
	private String message;
	private String secretMessage = "";
	private String alphaCipher = "NOPQRSTUVWXYZABCDEFGHIJKLM";  //Cipher -> ROT13
	private String alphabet    = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  //Alphabet to compare to
	
	public ROT13(String message) {
		this.message = message;  //Initialize the message
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String encipher() {
		String secretMessage = "";                          //Define secret message variable for enciphered text
		String messageVar = eliminateSpaces(this.message);  //Get rid of the spaces in the message
		int length = messageVar.length();                   //Get the length of the message without spaces
		String c = "";                                      //Current analyzed character
		int position = 0;                                   //Variable for holding index of a character
		
		//Loop through the message until all is enciphered
		for(int i = 0; i < length; i++) {
			c = ("" + messageVar.charAt(i)).toUpperCase();  //Change the text to upper case no matter what
			position = alphabet.indexOf(c);                 //Find the index of the character with respect to the alphabet
			secretMessage += alphaCipher.charAt(position);  //Use the index of the character with respect to the alphabet to find
                                                            //the position of where it would be in the ciphered alphabet
			//System.out.println(position + " ");           //Debug for finding character positions
		}
		this.secretMessage = secretMessage;
		return secretMessage;
	}
	
	public String decipher() {
		String decipheredMessage = "";                       //Variable for storing the deciphered message
		String c = "";                                       //Current analyzed character
		int position = 0;                                    //Variable for holding index of a character
		int length = this.secretMessage.length();            //Get the length of the message without spaces
		
		//Loop through the message until all is deciphered
		for(int i = 0; i < length; i++) {
			c = ("" + this.secretMessage.charAt(i));        //Change the text to upper case no matter what
			position = alphaCipher.indexOf(c);              //Variable for holding index of a character
			decipheredMessage += alphabet.charAt(position); //Use the index of the character with respect to the alphaCipher to find
                                                            //the position of where it would be in the alphabet 
		}
		return (length == 0) ? "You have not enciphered a message!" : decipheredMessage;
	}
	
	private String eliminateSpaces(String message) {
		String messRef = "";                                    //Use this variable to store the string without spaces
		message += " ";                                         //Prepend a space so it immediately positions the arrow (position of space immediately
		int arrow = 0;                                          //Position of space
		int length = message.length();                          //Length of the original message
		boolean isSpace = false;                                //Determine if there is a space

		//Loop through the entire message to find all spaces
		for (int i = 0; i < length; i++) {
			isSpace = ("" + message.charAt(i)).equals(" ");     //See if there is a space at the current character index
			if (isSpace) {                                      //If there is a space
				messRef += message.substring(arrow, i);         //Get the substring after the first space (See why it's necessary) and between 
				arrow = i + 1;
			}
		}
		return messRef;
	}
	
	public static void main(String[] args) {
		ROT13 message = new ROT13("ian          torres");
		ROT13 failure = new ROT13("");
		System.out.println(failure.decipher());
		System.out.println(message.encipher());
		System.out.println(message.decipher());
	}

}
