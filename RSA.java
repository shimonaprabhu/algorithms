import java.math.BigInteger;
import java.util.*;

class RSA
{
    public static void main(String args[])
    {
        RSA rsa=new RSA();
        Scanner br=new Scanner(System.in);
	Random r = new Random();
        int bitlength=1024;
        System.out.println("Enter the message to be encrypted");
        String message=br.nextLine();
        System.out.println("Message sent to be encrypted: "+message);
        System.out.println("String in Bytes: "+rsa.bytesToString(message.getBytes()));
        BigInteger p = BigInteger.probablePrime(bitlength, r);
        BigInteger q = BigInteger.probablePrime(bitlength, r);
        BigInteger N = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = BigInteger.probablePrime(bitlength / 2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
        {
            e.add(BigInteger.ONE);
        }
        BigInteger d = e.modInverse(phi);
        byte[] encrypted = rsa.encrypt(message.getBytes(),e,N);
        byte[] decrypted = rsa.decrypt(encrypted,d,N);
        System.out.println("Decrypted Bytes: "+rsa.bytesToString(decrypted));
        System.out.println("Decrypted String: "+new String(decrypted));
    }
    
    String bytesToString(byte[] encrypted)
    {
        String test = "";
        for (byte b : encrypted)
        {
            test += Byte.toString(b);
        }
        return test;
    }
    
    byte[] encrypt(byte[] message,BigInteger e,BigInteger N)
    {
        return (new BigInteger(message)).modPow(e, N).toByteArray();
    }
    byte[] decrypt(byte[] message,BigInteger d,BigInteger N)
    {
        return (new BigInteger(message)).modPow(d, N).toByteArray();
    }
    
}





