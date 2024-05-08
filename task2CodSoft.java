import java.util.*;
public class task2CodSoft {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //Number of subjects
        System.out.println("Enter number of subjects:");
        int n=sc.nextInt();
        float totalMarks=0;
        for(int i=1; i<=n; i++){
            System.out.println("Enter marks for subject "+i);
            totalMarks+=sc.nextFloat();
        }
        float avg=totalMarks/n;
        System.out.println("Total Marks = "+String.format("%.2f", totalMarks)+"\nAverage Percentage = "+String.format("%.2f", avg));
        if(avg>90){ System.out.println("O Grade!"); }
        else if(avg>80 && avg<90){ System.out.println("E Grade!"); }
        else if(avg>70 && avg<80){ System.out.println("A Grade!"); }
        else if(avg>60 && avg<70){ System.out.println("B Grade!"); }
        else if(avg>50 && avg<60){ System.out.println("C Grade!"); }
        else if(avg>40 && avg<50){ System.out.println("D Grade!"); }
        else{ System.out.println("F Grade!"); }
        sc.close();
    }
}