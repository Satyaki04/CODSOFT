import java.util.*;
public class task1CodSoft {
    public static int points=0;
    public static void numCheck(int generatedNum){
        Scanner sc=new Scanner(System.in);
        int i=5; //Number of choices
        while(i>0){
            System.out.println("Guess the number:");
            int num=sc.nextInt(); 
            //Conditions for comparison
            if(num==generatedNum){ 
                System.out.println("Congratulations!! Your guess is correct!\n"); 
                points++;
                return;
            } 
            else if( (num<generatedNum && num>generatedNum-10) || (num>generatedNum && num<generatedNum+10) ){
                System.out.println("Ohh!! Close enough");
            }
            else if(num>generatedNum){ 
                System.out.println("Your guess is too high!!");
            }
            else if(num<generatedNum){ 
                System.out.println("Your guess is too low!!");
            }
            System.out.println((i-1)+" attempts left!\n");
            i--;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        
        char play='Y';
        while(play=='Y'){
            int generatedNum=r.nextInt(100);
            numCheck(generatedNum);
            System.out.println("-----------------");
            System.out.println("Total points - "+points+"\n");
            System.out.println("Do you want to play again?(Y/N)");
            play=sc.next().charAt(0);
        } 
    }
}
