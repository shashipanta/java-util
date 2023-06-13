import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NumberToWord {


    private static final Map<BigInteger, String> numberMap = new LinkedHashMap<>();

//            Map.of(
//                    new BigInteger("100000000000"), "Kharab",
//                    new BigInteger("1000000000"), "Arab",
//                    new BigInteger("10000000"), "Crore",
//                    new BigInteger("100000"), "Lakh",
//                    new BigInteger("1000"), "Thousand",
//                    new BigInteger("100"), "Hundred",
//                    new BigInteger("10"), " "
//            )


    public static void main(String[] args) {

        numberMap.put(new BigInteger("10000000000000"), "Sankha");
        numberMap.put(new BigInteger("100000000000"), "Kharab");
        numberMap.put(new BigInteger("1000000000"), "Arab");
        numberMap.put(new BigInteger("10000000"), "Crore");
        numberMap.put(new BigInteger("100000"), "Lakh");
        numberMap.put(new BigInteger("1000"), "Thousand");
        numberMap.put(new BigInteger("100"), "Hundred");
        numberMap.put(new BigInteger("10"), " ");

        StringBuilder numberWordFormat = new StringBuilder();

        BigInteger n = new BigInteger("217800290171201");

//        numberMap.entrySet().stream().forEach(bigIntegerStringEntry ->
//                System.out.println(bigIntegerStringEntry.getKey() + " : " + bigIntegerStringEntry.getValue())
//        );

        Iterator<Map.Entry<BigInteger, String>> mapItr = numberMap.entrySet().iterator();

        BigInteger divide = null;
        int mod;

        while (mapItr.hasNext()) {
            Map.Entry<BigInteger, String> next = mapItr.next();
            BigInteger key = next.getKey();
            String value = next.getValue();

            System.out.print(next.getKey() + " : " + next.getValue());
            System.out.println();

            if(value.equals(" ")){
                mod = n.mod(new BigInteger("100")).intValue();
                numberWordFormat.append(genWords(mod, value));
                break;
            }

            divide = n.divide(key);
            if (key.compareTo(new BigInteger("100")) == 0) {
                mod = divide.mod(new BigInteger("10")).intValue();
            } else {
                mod = divide.mod(new BigInteger("100")).intValue();
            }



            numberWordFormat.append(genWords(mod, value));
        }

        System.out.print(n);

        System.out.println();
        System.out.println(" Returned string : \n" + numberWordFormat);


//        genWords( (n / 1_000_000_000) % 100, " arab");
//        genWords((int) (n / 10_000_000) % 100, " crore");
//        genWords((int) (n / 100000) % 100, " lakh");
//        genWords((int) (n / 1000) % 100, " thousand");
//        genWords((int) (n / 100) % 10, " hundred");
//        genWords((int) n % 100, " ");
    }

    static String genWords(int n, String ch) {
        StringBuilder wordFormat = new StringBuilder();

        String one[] = {" ", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten",
                " Eleven", " Twelve", " Thirteen", " Fourteen", "Fifteen", " Sixteen", " Seventeen", " Eighteen",
                " Nineteen"};

        String ten[] = {" ", " ", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};

        String temp;

        if (n > 19) {
            temp = ten[n / 10] + one[n % 10];
//            System.out.print(temp);
            wordFormat.append(temp);
        } else {
            temp = one[n];
//            System.out.print(one[n]);
            wordFormat.append(temp);
        }
        if (n > 0) {
//            System.out.print(ch);
            wordFormat.append(" " + ch);
        }

        return wordFormat.toString();
    }
}
