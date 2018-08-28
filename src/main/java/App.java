import java.util.Base64;
/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    public static String getDecodedValue(String value) {

        try {
            byte[] decoded = Base64.getMimeDecoder().decode(value);


            return new String(decoded);
        } catch (Exception e) {
            return null;
        }
    }

    public static String base64EncodeValue(String value) {

        try {
            byte[] decoded = Base64.getMimeDecoder().decode(value);


            return new String(decoded);
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        /**
         *  QzNWwc== : 16 51 13 22 48 28
         *  Decode (binary): 010000 110011 001101 010110 110000 011100
         *  Decode (binary group in 8): 01000011 00110011 01010110 11000001 1100
         *  Binary to ASCII: C 3 V
         *
         *  QzNWwQ== : 16 51 13 22 48 16
         *  Decode (binary): 010000 110011 001101 010110 110000 010000
         *  Decode (binary group in 8): 01000011 00110011 01010110 11000001 0000
         *  Binary to ASCII: C 3 V
         *
         *  Last 4 bit is ignored as it truncates the padded bits and decode the
         *  first 32 bits
         *
         *  Lessons learnt
         *
         *  1. QzNWwc== will never be generated as the padding bits should always be 0 hence if encoding is done properly,
         *  it will ensure uniqueness
         *
         *  2. Base64 is based of 6 bit and this would inadvertently increase the encoded length as shown above C3V became
         *  QzNWwQ==
         *
         *  3. It seems that there is no encoding that is able to reduce text length base on
         *  https://softwareengineering.stackexchange.com/questions/119181/what-type-of-encoding-can-i-use-to-make-a-string-shorter
         *  However, I am not sure of the mathematical impossibility mentioned by the author
         */
        String decoded1 = App.getDecodedValue("QzNWwc==");
        String decoded2 = App.getDecodedValue("QzNWwQ==");

        System.out.println(decoded1);
        System.out.println(decoded2);

        System.out.println(decoded1.equals(decoded2));
    }
}
