public class MainClass1 {

    public static void main(String[] args) {
        
        String str = "new :balls($ = \"third\")";
        
        /*System.out.println("1:" + str_piece(str, '|', 1));
        System.out.println("2:" + str_piece(str, '|', 2));
        System.out.println("3:" + str_piece(str, '|', 3));
        System.out.println("4:" + str_piece(str, '|', 4));
        System.out.println("5:" + str_piece(str, '|', 5));
        System.out.println("6:" + str_piece(str, '|', 6));*/
        String str_result1 = str_piece(str, ':', 2);
        System.out.println(str_result1);
        String str_result2 = str_piece(str_result1, '(', 1);
        System.out.println(str_result2);
        String str_result3 = str_piece(str_result1, '"', 2);
        System.out.println(str_result3);
    }
    
    private static String str_piece(String str, char separator, int index) {
        String str_result = "";
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == separator) {
                count++;
                if(count == index) {
                    break;
                }
            }
            else {
                if(count == index-1) {
                    str_result += str.charAt(i);
                }
            }
        }
        return str_result;
    }
}