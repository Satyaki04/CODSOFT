import java.sql.*;
import java.util.*;

public class task5CodSoft {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/HiJDBC";
        String username = "Satyaki";
        String password = "Sa30";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("----Welcome----");
            Statement st = con.createStatement();
        
            //Driver code!!
            Scanner sc=new Scanner(System.in);
            System.out.println("Do you want to\n  1. Enroll for a course\n  2. Drop out from any course\n  3. Abort");
            System.out.println("Enter your choice:");
            int choice=sc.nextInt();
            if(choice==1){
                System.out.println("--------------------------------------------------------------------------------");
                //Displaying details of the courses available
                System.out.println("COODE \t\t TITLE \t\t\t   DESCRIPTION\t\tSCHEDULE  SLOTS");
                ResultSet rset = st.executeQuery(" SELECT CODE, TITLE, DESCRIPTION, SCHEDULE, CAPACITY - STUDENTS_REGISTERED AS SLOTS FROM COURSE WHERE STUDENTS_REGISTERED<CAPACITY;");
                while(rset.next()){
                    System.out.println(rset.getString("CODE")+" \t "+rset.getString("TITLE")+" \t "+rset.getString("DESCRIPTION")+" \t   "+rset.getString("SCHEDULE")+" \t   "+rset.getString("SLOTS"));
                }
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("Enter your name"); 
                String name=sc.next();
                System.out.println("Enter course code:"); 
                String code=sc.next();
                //Getting ID
                rset=st.executeQuery("SELECT * FROM STUDENT;");
                int id=0;
                while(rset.next()){
                    id=rset.getInt("ID");  //ID for new student
                }
                PreparedStatement pstmt = con.prepareStatement("INSERT INTO STUDENT VALUES (?, ?, ?)");
                pstmt.setInt(1, id+1);
                pstmt.setString(2, name);
                pstmt.setString(3, code);
                pstmt.executeUpdate();
                
                // Update the number of registered students in the course table
                pstmt = con.prepareStatement("UPDATE COURSE SET STUDENTS_REGISTERED = STUDENTS_REGISTERED + 1 WHERE CODE = ?");
                pstmt.setString(1, code);
                pstmt.executeUpdate();

                //Process successfull message
                System.out.println("\nCongratulations! You are successfully enrolled for the course, "+code+"!");
            }
            else if(choice==2){
                System.out.println("Enter your first name:");
                String name=sc.next();
                //Accessing course of the student in which he was enrolled
                String code=null;
                ResultSet rset=st.executeQuery("SELECT NAME, COURSE FROM STUDENT;");
                while(rset.next()){ 
                    if(rset.getString("NAME").equals(name)){
                        code=rset.getString("COURSE"); break;
                    }
                } 
                if(code==null){ 
                    System.out.println("You are not enrolled to any course! Enroll to any course first.");
                    System.exit(0);
                }
                // Deleting the student from the student table
                PreparedStatement pstmt = con.prepareStatement("DELETE FROM STUDENT WHERE NAME = ?");
                pstmt.setString(1, name);
                pstmt.executeUpdate();
                
                // Updating the number of registered students in the course table
                pstmt = con.prepareStatement("UPDATE COURSE SET STUDENTS_REGISTERED = STUDENTS_REGISTERED - 1 WHERE CODE = ?");
                pstmt.setString(1, code);
                pstmt.executeUpdate();

                //Process successfull message
                System.out.println("Process successfull! Wishing you luck!!");
            }

            else if(choice==3){ System.out.println("---THANK YOU---"); }

            else{ System.out.println("Invalid Input!"); }

            //Closing objects 
            con.close(); sc.close();
        } catch (Exception e) {   
            System.out.println(e);
        }
    }
}