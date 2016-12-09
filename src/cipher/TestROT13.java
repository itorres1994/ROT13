package cipher;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestROT13 {

	@Test
	public void testEncipher() {
		
		//Use the values from practicalcryptography.com
		ROT13 message = new ROT13("one by land two by sea");
		String secretMessage = message.encipher();
		
		assertTrue(secretMessage.equalsIgnoreCase("BAROLYNAQGJBOLFRN"));
		
		message.setMessage("if a kid from tatooine can save the galaxy you can too");
		secretMessage = message.encipher();
		
		assertTrue(secretMessage.equalsIgnoreCase("vsnxvqsebzgngbbvarpnafnirgurtnynkllbhpnagbb"));
		
	}
	
	@Test
	public void testDecipher() {
		
		//Use the values from practicalcryptography.com
		ROT13 message  = new ROT13("one by land two by sea");
		message.encipher();
		String originalMessage = message.decipher();
		
		assertTrue(originalMessage.equalsIgnoreCase("onebylandtwobysea"));
		
		ROT13 message2 = new ROT13("");
		originalMessage = message2.decipher();
		
		assertTrue(originalMessage.equalsIgnoreCase("You have not enciphered a message!"));
		
	}

}
