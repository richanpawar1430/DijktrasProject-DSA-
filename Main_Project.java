package dijktras;
/*Project : TO GET BEST ROUTE FOR TRAVEL
 * Data Structure : GRAPH(Dijkstra's algorithm)
 * Group Members:
 *       2423  Aaditi Patil
 *       2427  Samruddhi Patil
 *       2430  Richa Pawar
 *       2431  Gargi Pol
 * 
 * Batch : B2 (SY COMP DIV B)
 */

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main_Project {
	public static void main(String[] args) {
		int ch=0;
		int choice=0;
		int choice1=0;
		int counter=0;
		int flag1=0;
		int flag2=0;
		int source=0;
		int destination=0;
		int source1 = 0;
		int destination1=0;
		Dijkstras obj1=new Dijkstras();//object of Dijkstras class
		Dijkstras obj2=new Dijkstras();
		String pass;
		int number_of_vertices=0;
		Scanner sc = new Scanner(System.in);

		String comp = "admin123" ;//default password

		do//menu for home page
		{
			System.out.println("----------------------- ");
			System.out.println("\tWELCOME");
			System.out.println("----------------------- ");
			System.out.println("LOGIN IN AS:\n1.ADMIN\n2.CUSTOMER");
			int bus = 0;
			int train = 0;
			ch=sc.nextInt();
			switch(ch)
			{
			case 1://case for Admin login
				int cnt=0;
				if(counter==1)
				{
					System.out.println("YOU HAVE ALREADY FILLED IN THE DETAILS!!");
				}
				else//to enter route details
				{
					do
					{

						System.out.println("ENTER YOUR PASSWORD");
						pass=sc.next();
						if(pass.compareTo(comp)==0 )
						{
							System.out.println("----------------------- ");
							System.out.println("      HOLA,ADMIN!!");
							System.out.println("----------------------- ");
							System.out.println("FILL IN THE INFORMATION BELOW:");
							System.out.println("\nENTER NUMBER OF CITIES FOR WHICH ARE FILLING THE INFORMATION:");
							number_of_vertices = sc.nextInt();
							System.out.println("----------------------- ");
							System.out.println("ENTER DETAILS FOR BUS:");
							System.out.println("----------------------- ");
							obj1.accept(number_of_vertices);
							System.out.println("----------------------- ");
							System.out.println("ENTER DETAILS FOR TRAIN:");
							System.out.println("----------------------- ");
							obj2.accept(number_of_vertices);
							flag1=1;
							counter=1;
							break;
						}
						else//if wrong password entered
						{
							System.out.println("YOU ENTERED WRONG PASSWORD!!");
							cnt++;
							System.out.println("YOU HAVE ONLY "+(3-cnt)+" ATTEMPTS LEFT");
						}
					}while(cnt<3 && cnt>0);
				}
				break;

			case 2://case for customer services
				if(flag1==1)//travel routes are ready
				{
					do
					{

						//Menu for customer services
						obj1.display(number_of_vertices);
						System.out.println("\nHOW DO YOU WANT TO TRAVEL?");
						System.out.println("----------------------");
						System.out.println("1.BY BUS\n2.BY TRAIN\n3.COMPARE COST EFFICIENCY\n4.EXIT");
						System.out.println("----------------------- ");
						System.out.println("PLEASE ENTER YOUR CHOICE:");
						choice=sc.nextInt();
						switch(choice)
						{
						case 1://case for customer to travel by bus
							System.out.println("ENTER THE STARTING CITY NO.:");
							source = sc.nextInt();

							System.out.println("ENTER THE DESTINATION CITY NO.");
							destination = sc.nextInt();
							bus=obj1.user_accept(source,destination,number_of_vertices);

							break;

						case 2://case for customer to travel by train
							System.out.println("ENTER THE STARTING CITY NO.:");
							source1 = sc.nextInt();

							System.out.println("ENTER THE DESTINATION CITY NO.");
							destination1 = sc.nextInt();
							train=obj2.user_accept(source1,destination1,number_of_vertices);

							break;

						case 3://case for customer to to compare travel by bus and train
							if(source==source1 && destination==destination1)
							{
								flag2=1;//travel routes for bus and train must be same
							}
							if(flag2==1)
							{
								if(bus>train)//if traveling distance by train is less
								{
									System.out.println("BUS REQUIRES MORE DISTANCE TO BE TRAVELLED THAN TRAIN");
									System.out.println("HENCE,TRAIN IS MORE EFFICIENT FOR THIS ROUTE!!");
								}
								else if(train>bus)//if traveling distance by bus is less
								{
									System.out.println("TRAIN REQUIRES MORE DISTANCE TO BE TRAVELLED THAN BUS");
									System.out.println("HENCE,BUS IS MORE EFFIECIENT FOR THIS ROUTE!!");
								}
								else//if traveling distance by bus and train are equal
								{
									System.out.println("TRAIN AND BUS BOTH ARE EQUALLY EFFICEIENT FOR THIS ROUTE!! ");
								}
							}
							else
							{
								System.out.println("YOU HAVE CHOSEN TWO DIFFERENT ROUTES!!");
								System.out.println("PLEASE SELECT SAME ROUTES TO CALCULATE EFFICIENCY!");
							}

						}
						System.out.println("\nENTER '1' TO CONTINUE '0' TO EXIT");
						choice1=sc.nextInt();
					}while(choice1!=0);
				}
				else//travel routes are yet to be filled by admin
				{
					System.out.println("\t\t\t*****************************************************************");

					System.out.println("\t\t\t\tTHE WEBSITE IS STILL UNDER CONSTRUCTION!!");
					System.out.println("\t\t\t\tWE APOLOGIZE FOR THE INCONVENIENCE");
					System.out.println("\t\t\t\tVISIT AGAIN!!");
					System.out.println("\t\t\t*****************************************************************");

				}

				break;
			}
		}while(ch!=0);
	}

}
/*
-----------------------
WELCOME
-----------------------
LOGIN IN AS:
1.ADMIN
2.CUSTOMER
2

*****************************************************************
THE WEBSITE IS STILL UNDER CONSTRUCTION!!
WE APOLOGIZE FOR THE INCONVENIENCE
VISIT AGAIN!!
*****************************************************************

-----------------------
WELCOME
-----------------------
LOGIN IN AS:
1.ADMIN
2.CUSTOMER
1
ENTER YOUR PASSWORD
asas
YOU ENTERED WRONG PASSWORD!!
YOU HAVE ONLY 2ATTEMPTS LEFT
ENTER YOUR PASSWORD
fdfd
YOU ENTERED WRONG PASSWORD!!
YOU HAVE ONLY 1ATTEMPTS LEFT
ENTER YOUR PASSWORD
admin123
-----------------------
HOLA,ADMIN!!
-----------------------
FILL IN THE INFORMATION BELOW:
ENTER NUMBER OF CITIES FOR WHICH ARE FILLING THE INFORMATION:
5
-----------------------
ENTER DETAILS FOR BUS:
-----------------------
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Mumbai And Mumbai
0
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Mumbai And Pune
220
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Mumbai And Nashik
360
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Mumbai And Satara
240
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Mumbai And Wai
210
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Pune And Mumbai
220
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Pune And Pune
0
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Pune And Nashik
335

ENTER DISTANCE IN KMS FOR PATH BETWEEN: Pune And Satara
120
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Pune And Wai
110
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Nashik And Mumbai
360
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Nashik And Pune
335
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Nashik And Nashik
0
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Nashik And Satara
385
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Nashik And Wai
350
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Satara And Mumbai
240
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Satara And Pune
120
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Satara And Nashik
385
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Satara And Satara
0
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Satara And Wai
40
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Wai And Mumbai
210
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Wai And Pune
110
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Wai And Nashik
350
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Wai And Satara
40
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Wai And Wai
0
-----------------------
ENTER DETAILS FOR TRAIN:
-----------------------
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Mumbai And Mumbai
0
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Mumbai And Pune
150
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Mumbai And Nashik
320
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Mumbai And Satara
270
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Mumbai And Wai
240
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Pune And Mumbai
150
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Pune And Pune
0
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Pune And Nashik
310
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Pune And Satara
140

ENTER DISTANCE IN KMS FOR PATH BETWEEN: Pune And Wai
112
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Nashik And Mumbai
320
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Nashik And Pune
310
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Nashik And Nashik
0
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Nashik And Satara
370
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Nashik And Wai
350
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Satara And Mumbai
270
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Satara And Pune
140
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Satara And Nashik
370
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Satara And Satara
0
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Satara And Wai
60
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Wai And Mumbai
240
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Wai And Pune
112
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Wai And Nashik
350
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Wai And Satara
60
ENTER DISTANCE IN KMS FOR PATH BETWEEN: Wai And Wai
0
-----------------------
WELCOME
-----------------------
LOGIN IN AS:
1.ADMIN
2.CUSTOMER
2
-------------------------
WELCOME
-------------------------
THE FOLLOWING CITIES ARE CONSIDERED:
-----------------------
CITY CITY NO:
-----------------------
MUMBAI 1
PUNE 2
NASHIK 3
SATARA 4
WAI 5
HOW DO YOU WANT TO TRAVEL?
----------------------

1.BY BUS
2.BY TRAIN
3.COMPARE COST EFFICIENCY
4.EXIT
-----------------------
PLEASE ENTER YOUR CHOICE:
1
ENTER THE STARTING CITY NO.:
1
ENTER THE DESTINATION CITY NO.
5
THE SHORTEST DISTANCE IS:
210 KMS
ENTER &#39;1&#39; TO CONTINUE &#39;0&#39; TO EXIT
1
-------------------------
WELCOME
-------------------------
THE FOLLOWING CITIES ARE CONSIDERED:
-----------------------
CITY CITY NO:
-----------------------
MUMBAI 1
PUNE 2
NASHIK 3
SATARA 4
WAI 5
HOW DO YOU WANT TO TRAVEL?
----------------------
1.BY BUS
2.BY TRAIN
3.COMPARE COST EFFICIENCY
4.EXIT
-----------------------
PLEASE ENTER YOUR CHOICE:
2
ENTER THE STARTING CITY NO.:
2
ENTER THE DESTINATION CITY NO.
3
THE SHORTEST DISTANCE IS:
310 KMS
ENTER &#39;1&#39; TO CONTINUE &#39;0&#39; TO EXIT
1
-------------------------
WELCOME
-------------------------
THE FOLLOWING CITIES ARE CONSIDERED:
-----------------------
CITY CITY NO:
-----------------------
MUMBAI 1

PUNE 2
NASHIK 3
SATARA 4
WAI 5
HOW DO YOU WANT TO TRAVEL?
----------------------
1.BY BUS
2.BY TRAIN
3.COMPARE COST EFFICIENCY
4.EXIT
-----------------------
PLEASE ENTER YOUR CHOICE:
3
YOU HAVE CHOSEN TWO DIFFERENT ROUTES!!
PLEASE SELECT SAME ROUTES TO CALCULATE EFFICIENCY!
ENTER &#39;1&#39; TO CONTINUE &#39;0&#39; TO EXIT
1
-------------------------
WELCOME
-------------------------
THE FOLLOWING CITIES ARE CONSIDERED:
-----------------------
CITY CITY NO:
-----------------------
MUMBAI 1
PUNE 2
NASHIK 3
SATARA 4
WAI 5
HOW DO YOU WANT TO TRAVEL?
----------------------
1.BY BUS
2.BY TRAIN
3.COMPARE COST EFFICIENCY
4.EXIT
-----------------------
PLEASE ENTER YOUR CHOICE:
1
ENTER THE STARTING CITY NO.:
2
ENTER THE DESTINATION CITY NO.
3
THE SHORTEST DISTANCE IS:
335 KMS
ENTER &#39;1&#39; TO CONTINUE &#39;0&#39; TO EXIT
1
-------------------------
WELCOME
-------------------------
THE FOLLOWING CITIES ARE CONSIDERED:

-----------------------
CITY CITY NO:
-----------------------
MUMBAI 1
PUNE 2
NASHIK 3
SATARA 4
WAI 5
HOW DO YOU WANT TO TRAVEL?
----------------------
1.BY BUS
2.BY TRAIN
3.COMPARE COST EFFICIENCY
4.EXIT
-----------------------
PLEASE ENTER YOUR CHOICE:
3
BUS REQUIRES MORE DISTANCE TO BE TRAVELLED THAN TRAIN
HENCE,TRAIN IS MORE EFFICIENT FOR THIS ROUTE!!
ENTER &#39;1&#39; TO CONTINUE &#39;0&#39; TO EXIT
0
-----------------------
WELCOME
-----------------------
LOGIN IN AS:
1.ADMIN
2.CUSTOMER
*/
