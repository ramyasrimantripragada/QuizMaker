import java.util.*;
import java.io.*;
public class StudentPortal 
{
           Scanner s=new Scanner(System.in);
	private String subject;
	private String question,op1,op2,op3,op4,key;
	private int count,answer;
	StudentPortal(String subject)
	{
		this.subject=subject;
		this.count=0;
	}
	public void attemptQuiz()
	{
		System.out.println("Your quiz is: \n");
		try
		{
			DataInputStream in=new DataInputStream(new FileInputStream(subject+".txt")); 
			for(int i=1;i<=10;i++)
			{
				question=in.readLine();
				op1=in.readLine();
				op2=in.readLine();
				op3=in.readLine();
				op4=in.readLine();
				key=in.readLine();
				System.out.println("\nQuestion-"+i+": "+question);
				System.out.println("Option 1: "+op1);
				System.out.println("Option 2: "+op2);
				System.out.println("Option 3: "+op3);
				System.out.println("Option 4: "+op4);
				System.out.print("Your Answer: ");
				answer=s.nextInt();
				int intkey=Integer.parseInt(key.substring(1,2));
				if(intkey==answer)
				   ++count;	
			}
            in.close();
		}catch(Exception ie){System.out.println(ie);}
		System.out.println("\n\nYour score is: "+count);
		
	}
	public static void main(String args[])
	{
		System.out.println("\n\t\t\t\t\t************\n\t\t\t\t\t*QUIZ MAKER*\n\t\t\t\t\t************\n\n\n\n");
		System.out.println("\t\t\tMADE BY:RAMYA SRI MANTRIPRAGADA");
		System.out.print("\n\n\n\n\n\t\t\t\tPRESS ANY KEY TO CONTINUE!!");
		Scanner s=new Scanner(System.in);
		String e=s.nextLine();
		System.out.print("\033[H\033[2J");
		System.out.println("\n\n\t\t*Welcome to Student Portal*\n\n");
		System.out.print("\n\n\n\n\n\t\t\t\tPRESS ANY KEY TO CONTINUE!!");
		e=s.nextLine();
		System.out.print("\033[H\033[2J");
		System.out.print("Do you want to attempt Quiz[y/n]: ");
		String choice=s.nextLine();
		System.out.print("\033[H\033[2J");
		while((choice.equals("y"))||(choice.equals("Y")))
		{
			System.out.println("The avaiable quizes are:\n\nSubject-Unit:\n");
			String file="";
			try{
				FileReader in=new FileReader("Subjects.txt");
				int ch;
				
				while((ch=in.read())!=-1)
				{
						file=file+(char)ch;
				}
				in.close();
			}catch(Exception ie){System.out.println(ie);}
			System.out.println(file);
			System.out.print("Enter subject name you want to attempt: ");
			String sub=s.nextLine();
			sub=sub.toUpperCase();
			System.out.print("Enter unit number: ");
			String unit=s.nextLine();
			if(file.contains(sub+"-"+unit))
			{
				StudentPortal stu=new StudentPortal(sub+"-"+unit);
				stu.attemptQuiz();
			}
			else
			    System.out.println("Sorry!! The quiz for unit-"+unit+" in "+sub+" is not available!!");
			System.out.print("\n\nDo you want to continue: ");
			choice=s.nextLine();
			System.out.print("\033[H\033[2J");
		}
		System.out.println("\n\n\t\t\t*SUCCESSFULLY TERMINATED!!* \n\n\n\t\t\t\t *THANKYOU!!*");	}
}
