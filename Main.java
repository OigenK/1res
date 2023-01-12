import java.util.Scanner;

class Main {



    public static void main(String[] args)throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два числа от 1 до 10");
        String input = scanner.nextLine();
        System.out.println(calc(input));

    }
     public static String calc(String input) throws  Exception {
           int a,b;
           String c;
           String result;
           String [] inputString = input.split("[+\\-*/]");
           a=Integer.parseInt(inputString[0]);
           b=Integer.parseInt(inputString[1]);
           c = sortLine(input);
           if ( a>10||b>10) {
               throw new Exception(" числа должны быть не больше 10");
           }
               int arabian = getResult(a,b,c);
               result = String.valueOf(arabian);
               return result;
           }


     static String sortLine(String i) {
         if (i.contains("+")) return "+";
         if (i.contains("-")) return "-";
         if (i.contains("*")) return "*";
         if (i.contains("/")) return "/";
         else return null;
     }
     static int getResult(int a, int b, String i) {
         if (i.contains("+")) return a + b;
         else if (i.contains("-")) return a - b;
         else if (i.contains("*")) return a * b;
         else return a / b;
     }



     }
