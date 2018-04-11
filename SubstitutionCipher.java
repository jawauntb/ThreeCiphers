import java.util.*;

public class SubstitutionCipher extends Cipher {
    
    
    /**
     * The specialized constructor.
     *
     * @param key The key to used to shift each character for
     * encryption/decryption.
     **/
    public SubstitutionCipher (long key) {
        
        super(key);
        
    } // SubCipher ()
    // =========================================================================
    /**
     * Replace each character in the given cleartext by shifting forward, by the
     * number of positions specified by the key, each character.
     *
     * @param cleartext The unencrypted source data.
     * @returns The ciphertext -- the encrypted result.
     **/
    public List<Character> encrypt (List<Character> cleartext) {
        
        List<Character> ciphertext = new LinkedList<Character>();
        Random gen = new Random(this.getKey());
        
        // Shift each character of the cleartext, appending the result to the
        // ciphertext.  Assume an English encoding with 256 possible character
        // values, wrapping around any shifts beyond a value of 255.
        for (char clearchar : cleartext) {
            int shift = gen.nextInt();
            
            char cipherchar = (char)((clearchar + shift) % 256);
            ciphertext.add(cipherchar);
            
        }
        
        return ciphertext;
        
    } // encrypt ()
    // =========================================================================
    
    
    
    // =========================================================================
    /**
     * Replace each character in the given ciphertext by shifting backward, by
     * the number of positions specified by the key, each character.
     *
     * @param ciphertext The encrypted source data.
     * @returns The cleartext -- the decrypted result.
     **/
    public List<Character> decrypt (List<Character> ciphertext) {
        List<Character> cleartext = new LinkedList<Character>();
        Random gen = new Random(this.getKey());
        // Shift each character of the cleartext, appending the result to the
        // ciphertext.  Assume an English encoding with 256 possible character
        // values, wrapping around any shifts beyond a value of 255.
        for (char cipherchar : ciphertext) {
            int shifty = gen.nextInt();
            char clearchar = (char)((cipherchar - shifty) % 256);
            cleartext.add(clearchar);
        }
        return cleartext;
    } // decrypt ()
}
