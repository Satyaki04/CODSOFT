import java.util.*;
class Questions{
    String[] Qs;
    String[] options; 
    int[] ans;
    public static int score; public static int flag;
    void checkAns(int a, Scanner sc){
        Timer timer=new Timer(); 
        System.out.println("Enter the option:"); 
        timer.schedule(new TimerTask() {
            public void run(){System.out.println("Time's up!"); flag++; timer.cancel(); }
        },10000); 
        if(sc.nextInt()==a){ score++; }
        timer.cancel();
    }
    void add(String[] Qs, String[] options, int[] ans){
        this.Qs=Qs; this.options=options; this.ans=ans;
    }    
    void startQuiz(){
        Scanner sc=new Scanner(System.in);
        for(int i=0; i<Qs.length; i++){
            System.out.println("--------------------------------");
            System.out.println((i+1)+". "+Qs[i]);
            System.out.println(options[i]);
            checkAns(ans[i], sc); 
        }
        sc.close();
        System.out.println("Your score is "+score+"\n---Thank You!---");
        return;
    }
}
public class task4CodSoft {
    public static void main(String[] args) {
        String[] Qs={"What is the capital of India?","What is the value of Pi?","What is the product of 2 and 2?"};
        String[] options={"1. Kolkata\n2. Mumbai\n3. Uttar Pradesh\n4. Delhi","1. 3.14\n2. 2.14\n3. 1.14\n4. 0.14","1. 2\n2. 3\n3. 4\n4. 5"};
        int[] ans={1,1,3};
        Questions quiz=new Questions();
        quiz.add(Qs, options, ans);
        quiz.startQuiz();
    }
}
