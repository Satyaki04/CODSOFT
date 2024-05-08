import java.util.*;
public class task1CodSoft {
    public static int points;
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
        System.out.println("The correct number was "+generatedNum);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        System.out.println("The number range for this game is 0 to 100.\nDo you want to change the upper limit?(Y/N)");
        char choice=sc.next().charAt(0);
        int x=100;
        if(choice=='Y'){
            System.out.println("Enter the upper limit:");
            x=sc.nextInt();
        }

        char play='Y';
        while(play=='Y'){
            int generatedNum=r.nextInt(x);
            numCheck(generatedNum);
            System.out.println("-----------------");
            System.out.println("Total points - "+points+"\n");
            System.out.println("Do you want to play again?(Y/N)");
            play=sc.next().charAt(0);
        } 
    }
}
