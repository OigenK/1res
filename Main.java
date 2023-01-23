import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите два числа от 1 до 10 либо от I до Х");
        String input = reader.readLine();
        System.out.println(calc(input));

    }

    public static String calc(String input) throws Exception {
        int a, b;
        String c;
        String result;
        String[] inputString = input.split("[+\\-*/]");
        boolean yesNo;
        if (inputString.length != 2)
            throw new Exception("должно быть не больше двух чисел в операции");
        c = sortLine(input);
        if (c == null)
            throw new Exception("неверная операция");
        if (Roman.ifRoman(inputString[0]) && Roman.ifRoman(inputString[1])) {
            a = Roman.convAR(inputString[0]);
            b = Roman.convAR(inputString[1]);
            yesNo = true;
        }
        else if (!Roman.ifRoman(inputString[0]) && !Roman.ifRoman(inputString[1])) {
            a = Integer.parseInt(inputString[0]);
            b = Integer.parseInt(inputString[1]);
            yesNo = false;
        }
        else {
            throw new Exception("Операция должна быть в одном числовом формате");
        }
        if (a > 10 || b > 10)
            throw new Exception(" числа в операции должны быть не больше 10");
            int arabian = getResult(a, b, c);
            if (yesNo) {
                if (arabian <= 0) {
                    throw new Exception("Римское число должно быть больше нуля");
                }
                result = Roman.convRom(arabian);
            } else {
                result = String.valueOf(arabian);
            }
                return result;
            }


            static String sortLine (String i){
                if (i.contains("+")) return "+";
                if (i.contains("-")) return "-";
                if (i.contains("*")) return "*";
                if (i.contains("/")) return "/";
                else return null;
            }

            static int getResult ( int a1, int b1, String i){
                if (i.contains("+")) return a1 + b1;
                else if (i.contains("-")) return a1 - b1;
                else if (i.contains("*")) return a1 * b1;
                else return a1 / b1;
            }
        }



    class Roman {
        static String[] romanNum = new String[]{"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX","XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        public static boolean ifRoman(String s1) {
            for (int i = 0; i < romanNum.length; i++) {
                if (s1.equals(romanNum[i])) {
                    return true;
                }
            }
            return false;
        }

        public static int convAR(String s2) {
            for (int i = 0; i < romanNum.length; i++) {
                if (s2.equals(romanNum[i])) {
                    return i;
                }
            }
            return -1;
        }

        public static String convRom(int arabian) {

            return romanNum[arabian];
        }
    }


