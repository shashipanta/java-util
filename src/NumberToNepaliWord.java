import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class NumberToNepaliWord {

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

        numberMap.put(new BigInteger("100000000000"), "खर्ब");
        numberMap.put(new BigInteger("1000000000"), "अरब");
        numberMap.put(new BigInteger("10000000"), "करोड");
        numberMap.put(new BigInteger("100000"), "लाख");
        numberMap.put(new BigInteger("1000"), "हजार");
        numberMap.put(new BigInteger("100"), "सय");
        numberMap.put(new BigInteger("10"), " ");

        StringBuilder numberWordFormat = new StringBuilder();

        BigInteger n = new BigInteger("21782901712001");

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

    }

    static String genWords(int n, String ch) {
        StringBuilder wordFormat = new StringBuilder();

        String one[] = {" ", " एक", " दुई", " तीन", " चार", " पाँच", " छ", " सात", " आठ", " नौ", " दस"};

        String ten[] = {" एघार", " ", " तेह्र", " चौध", " पन्ध्र", " सोह्र", " सत्र", " अठार",
                " उन्नाइस", " बिस", " एक्काइस", " बाइस", " तेइस", " चौबिस", " पच्चिस", " छब्बिस", " सत्ताइस", " अट्ठाइस", " उनन्तिस", " तिस",
                " एकतिस", " बत्तिस", " तेत्तिस", " चौतिस", " पैँतिस", " छत्तिस", " सैँतिस", " अठतिस", " उनन्चालिस", " चालिस", " एकचालिस", " बयालिस",
                " त्रिचालिस", " चवालिस", " पैँतालिस", " छयालिस", " सतचालिस", " अठचालिस", " उनन्चास", " पचास", " एकाउन्न", " बाउन्न", " त्रिपन्न", " चवन्न",
                " पचपन्न", " छपन्न", " सन्ताउन्न", " अन्ठाउन्न", " उनसट्ठी", " साठी", " एकसट्ठी", " बयसट्ठी", " त्रिसट्ठी", " चौसट्ठी", " पैँसट्ठी", " छयसट्ठी",
                " सतसट्ठी", " अठसट्ठी", " उनन्सत्तरी", " सत्तरी", " एकहत्तर", " बहत्तर", " त्रिहत्तर", " चौहत्तर", " पचहत्तर", " छयहत्तर", " सतहत्तर", " अठहत्तर",
                " उनासी", " असी", " एकासी", " बयासी", " त्रियासी", " चौरासी", " पचासी", " छयासी", " सतासी", " अठासी", " उनान्नब्बे", " नब्बे",
                " एकान्नब्बे", " बयान्नब्बे", " त्रियान्नब्बे", " चौरान्नब्बे", " पन्चान्नब्बे", " छयान्नब्बे", " सन्तान्नब्बे", " अन्ठान्नब्बे", " उनान्सय"

        };


        String temp;

        if (n > 10) {
            temp = ten[n -11];
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


