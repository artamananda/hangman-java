import java.io.*;

public class Hangman {
    public static void main(String[] args) {
        char input;
        String ans;
        String[] keyAnswer = {"KAMBING", "JERAPAH", "GAJAH", "ULAR", "KOALA"};
        char[] answer;
        int count;

        input = ' ';
        count = 7;
        ans = keyAnswer[(int) (Math.random() * keyAnswer.length)];
        answer = new char[ans.length()];
        def(answer);

        algorithm(input, ans, answer, count);
    }

    static void algorithm(char input, String ans, char[] answer, int count){
        printAnswer(answer);
        printCount(count);
        while(count > 0){
            System.out.print("Masukkan Jawaban Anda : ");
            input = input();
            System.out.println("\n\n");
            for(int i = 0; i < ans.length(); i++){
                if(input == ans.charAt(i)){
                    answer[i] = ans.charAt(i);
                }
            }
            count--;
            printAnswer(answer);
            if(checkAns(answer) == true){
                printWin();
                return;
            }
            else{
                if(count == 0){
                    printLose();
                    System.out.println("Jawaban yang Benar : " + ans + "\n");
                    return;
                }
                else{
                    printCount(count);
                }
            }
        }
    }

    static char input(){
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        char in = ' ';
        try{
            in = Character.toUpperCase(dataIn.readLine().charAt(0));
        }
        catch(IOException e){
            in = '*';
        }

        return in;
    }

    static char[] def(char[] answer){
        for(int i = 0; i < answer.length; i++){
            answer[i] = '_';
        }
        return answer;
    }

    static boolean checkAns(char[] answer){
        boolean checkAns = true;
        for(char x : answer){
            if(x == '_')
                checkAns =  false;
        }
        return checkAns;
    }

    static void printAnswer(char[] answer){
        for(char x : answer){
            System.out.print(x + " ");
        }
        System.out.println("\n");
    }

    static void printCount(int count){
        System.out.println("Sisa kesempatan : " + count);
        System.out.println("========================================");
    }

    static void printWin(){
        System.out.println("Selamat Anda Menang!!!");
    }

    static void printLose(){
        System.out.println("Maaf, Anda Kalah.");
    }  
}