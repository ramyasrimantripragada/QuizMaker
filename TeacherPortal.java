import java.util.*;
import java.io.*;	
class TeacherPortal
{
            Scanner s=new Scanner(System.in);
	private String subject;
	private String question,op1,op2,op3,op4,key;
	TeacherPortal(String subject)
	{
		this.subject=subject;
		try{
			FileWriter w=new FileWriter("Subjects.txt",true);
			w.write(subject+"\n");
			w.close();
		}catch(Exception ie){System.out.println(ie);}
	}
	public void createQuiz()
	{
		System.out.println("Enter Quiz questions,options and answers: ");
		try
		{
			DataOutputStream out=new DataOutputStream(new FileOutputStream(subject+".txt")); 
			for(int i=1;i<=10;i++)
			{
				System.out.print("Question-"+i+": ");
				question=s.nextLine();
				System.out.print("Option 1: ");
				op1=s.nextLine();
				System.out.print("Option 2: ");
				op2=s.nextLine();
				System.out.print("Option 3: ");
				op3=s.nextLine();
				System.out.print("Option 4: ");
				op4=s.nextLine();
				System.out.print("Answer: ");
				key=s.nextLine();
				out.writeChars(question+"\n"+op1+"\n"+op2+"\n"+op3+"\n"+op4+"\n"+key+"\n");
			}
			System.out.println("Successfully created quiz!!\n\n");
            out.close();
		}catch(Exception ie){System.out.println(ie);}
	}
	public static void main(String args[])
	{
		System.out.println("\n\t\t\t\t\t************\n\t\t\t\t\t*QUIZ MAKER*\n\t\t\t\t\t************\n\n\n\n");
		System.out.println("\t\t\tMADE BY: RAMYA SRI MANTRIPRAGADA");
		System.out.println("\n\n\n\n\n\t\t\t\tPRESS ANY KEY TO CONTINUE!!");
		Scanner s=new Scanner(System.in);
		String e=s.nextLine();
		System.out.print("\033[H\033[2J");
		System.out.println("\n\n\t\t*Welcome to Teacher Portal*\n\n");
		System.out.println("\n\n\n\n\n\t\t\t\tPRESS ANY KEY TO CONTINUE!!");
		e=s.nextLine();
		System.out.print("\033[H\033[2J");
		System.out.println("Do you want to create Quiz[y/n]: ");
		String choice=s.nextLine();
		System.out.print("\033[H\033[2J");
		while((choice.equals("y"))||(choice.equals("Y")))
		{
			System.out.print("Enter subject name: ");
			String sub=s.nextLine();
			sub=sub.toUpperCase();
			System.out.print("Enter unit number: ");
			String unit=s.nextLine();
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
			if(file.contains(sub+"-"+unit))
			    System.out.println("Sorry the quiz for unit-"+unit+" in "+sub+" is already created");
			else
			{
				TeacherPortal t=new TeacherPortal(sub+"-"+unit);
				t.createQuiz();
			}
			System.out.println("\n\nDo you want to continue: ");
			choice=s.nextLine();
			System.out.print("\033[H\033[2J");
		}
		System.out.println("\n\n\t\t\t*SUCCESSFULLY TERMINATED!!* \n\n\n\t\t\t\t *THANKYOU!!*");
	}
}
