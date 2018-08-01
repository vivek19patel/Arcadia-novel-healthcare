package com.coding.test;

public class Snippet {
	public static int subsequence(String s) {
		char bit; // current element in the sequence
		int cont = 0; // current length of the sequence of zeros
		int maxlen = 0; // temporary value of the maximum length
		for (int i = 0; i < s.length(); i++) {
			bit = s.charAt(i);
			if (bit == '0') { // we have read a new ’0’
				cont++; // update the length of the current sequence
				if (cont > maxlen) // if necessary, ...
					// ... update the temporary maximum
					maxlen = cont;
			} else // we have read a 1
				cont = 0; // reset the length of the current sequence
		}
		return maxlen;
	}

	public static void main(String[] args) {

		subsequence("mkdsjvi");

	}

}
