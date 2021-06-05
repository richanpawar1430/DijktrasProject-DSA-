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
import java.util.*;

public class Dijkstras
{
	public Dijkstras()//constructor
	{

	}
	int adjacency_matrix[][];//matrix for graph 
	int number_of_vertices;

	private int          distances[];
	private Set<Integer> settled;//visited nodes 
	private Set<Integer> unsettled;//non visited nodes
	private int          number_of_nodes;
	private int          adjacencyMatrix[][];

	public Dijkstras(int number_of_nodes)//parametric constructor
	{
		this.number_of_nodes = number_of_nodes;
		distances = new int[number_of_nodes + 1];
		settled = new HashSet<Integer>();
		unsettled = new HashSet<Integer>();
		adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];
	}

	public void dijkstra_algorithm(int adjacency_matrix[][], int source)//Method of dijkstras algorithm
	{
		int evaluationNode;
		for (int i = 1; i <= number_of_nodes; i++)
			for (int j = 1; j <= number_of_nodes; j++)
				adjacencyMatrix[i][j] = adjacency_matrix[i][j];

		for (int i = 1; i <= number_of_nodes; i++)
		{
			distances[i] = Integer.MAX_VALUE;
		}

		unsettled.add(source);
		distances[source] = 0;
		while (!unsettled.isEmpty())
		{
			evaluationNode = getNodeWithMinimumDistanceFromUnsettled();//to find node of minimum distance
			unsettled.remove(evaluationNode);
			settled.add(evaluationNode);
			evaluateNeighbours(evaluationNode);
		}
	}

	private int getNodeWithMinimumDistanceFromUnsettled()//method to find the minimum distance from a node
	{
		int min;
		int node = 0;

		Iterator<Integer> iterator = unsettled.iterator();
		node = iterator.next();
		min = distances[node];
		//iterate to find minimum distance
		for (int i = 1; i <= distances.length; i++)
		{
			if (unsettled.contains(i))
			{
				if (distances[i] <= min)
				{
					min = distances[i];
					node = i;
				}
			}
		}
		return node;
	}

	private void evaluateNeighbours(int evaluationNode)//to modify distance according to dijkstras algorithm
	{
		int edgeDistance = -1;
		int newDistance = -1;

		for (int destinationNode = 1; destinationNode <= number_of_nodes; destinationNode++)
		{
			if (!settled.contains(destinationNode))
			{
				if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE)
				{
					edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
					newDistance = distances[evaluationNode] + edgeDistance;
					//new distance is minimum of edge distance and new distance
					if (newDistance < distances[destinationNode])
					{
						distances[destinationNode] = newDistance;
					}
					unsettled.add(destinationNode);
				}
			}
		}
	}

	public void accept(int number_of_vertices)//accept distances between nodes
	{
		String istring = null;
		String jstring=null;
		Scanner scan = new Scanner(System.in);

		//System.out.println("Enter the number of vertices");
		//number_of_vertices = scan.nextInt();
		adjacency_matrix = new int[number_of_vertices + 1][number_of_vertices + 1];

		
		for (int i = 1; i <= number_of_vertices; i++)
		{
			if(i==1)
			{
				istring="Mumbai";
			}
			else if(i==2)
			{
				istring="Pune";
			}
			else if(i==3)
			{
				istring="Nashik";
			}
			else if(i==4)
			{
				istring="Satara";
			}
			else if(i==5)
			{
				istring="Wai";
			}
			else if(i==6)
			{
				istring="Solapur";
			}
			else if(i==7)
			{
				istring="Nagpur";
			}
			else if(i==8)
			{
				istring="Kolhapur";
			}
			else if(i==9)
			{
				istring="Sangli";
			}
			else if(i==10)
			{
				istring="Sangamner";
			}
			for (int j = 1; j <= number_of_vertices; j++)
			{
				if(j==1)
				{
					jstring="Mumbai";
				}
				else if(j==2)
				{
					jstring="Pune";
				}
				else if(j==3)
				{
					jstring="Nashik";
				}
				else if(j==4)
				{
					jstring="Satara";
				}
				else if(j==5)
				{
					jstring="Wai";
				}
				else if(j==6)
				{
					jstring="Solapur";
				}
				else if(j==7)
				{
					jstring="Nagpur";
				}
				else if(j==8)
				{
					jstring="Kolhapur";
				}
				else if(j==9)
				{
					jstring="Sangli";
				}
				else if(j==10)
				{
					jstring="Sangamner";
				}
				//entering distance between cities
				System.out.println("ENTER DISTANCE  IN KMS FOR PATH BETWEEN: "+istring+" And "+jstring);

				adjacency_matrix[i][j] = scan.nextInt();
				if (i == j)
				{
					adjacency_matrix[i][j] = 0;
					continue;
				}
				if (adjacency_matrix[i][j] == 0)
				{
					adjacency_matrix[i][j] = Integer.MAX_VALUE;
				}
			}

		}
	}
	public int user_accept(int source,int destination,int number_of_vertices)//to find minimum distances between two cities
	{
		int dist = 0;
		Dijkstras obj=new Dijkstras();
		Scanner scan1 = new Scanner(System.in);
		
		

		Dijkstras obj2 = new Dijkstras(number_of_vertices);
		obj2.dijkstra_algorithm(adjacency_matrix, source);

		//to find shortest distance
		System.out.println("THE SHORTEST DISTANCE IS:");
		int i;
		for ( i = 1; i <= obj2.distances.length - 1; i++)
		{
			if (i == destination)
			{
				System.out.print(obj2.distances[i]);
					dist=obj2.distances[i];// shortest path 
					break;
			}
				
			
		}
	return dist;

		
	}
	public void display(int n)//display the cities connected
	{
		System.out.println("\n-------------------------");
		System.out.println("       WELCOME");
		System.out.println("-------------------------");
		System.out.println("THE FOLLOWING CITIES ARE CONSIDERED:");
		System.out.println("----------------------- ");
		System.out.println("CITY\t\tCITY NO:");
		System.out.println("----------------------- ");
		switch(n)
		{
		case 1://if route for 1 city created
			System.out.println("MUMBAI\t\t1");
			break;
			
		case 2:// if route between 2 cities available
			System.out.println("MUMBAI\t\t1");
			System.out.println("PUNE\t\t2");
			break;
			
		case 3:// if route between 3 cities available
			System.out.println("MUMBAI\t\t1");
			System.out.println("PUNE\t\t2");
			System.out.println("NASHIK\t\t3");
			break;
			
		case 4://if route between 4 cities available
			System.out.println("MUMBAI\t\t1");
			System.out.println("PUNE\t\t2");
			System.out.println("NASHIK\t\t3");
			System.out.println("SATARA\t\t4");
			break;
			
		case 5://if route between 5 cities available
			System.out.println("MUMBAI\t\t1");
			System.out.println("PUNE\t\t2");
			System.out.println("NASHIK\t\t3");
			System.out.println("SATARA\t\t4");
			System.out.println("WAI\t\t5");
			break;
			
		case 6://if route between 6 cities available
			System.out.println("MUMBAI\t\t1");
			System.out.println("PUNE\t\t2");
			System.out.println("NASHIK\t\t3");
			System.out.println("SATARA\t\t4");
			System.out.println("WAI\t\t5");
			System.out.println("SOLAPUR\t\t6");
			break;
			
		case 7://if route between 7 cities available
			System.out.println("MUMBAI\t\t1");
			System.out.println("PUNE\t\t2");
			System.out.println("NASHIK\t\t3");
			System.out.println("SATARA\t\t4");
			System.out.println("WAI\t\t5");
			System.out.println("SOLAPUR\t\t6");
			System.out.println("NAGPUR\t\t7");
			break;
			
		case 8://if route between 8 cities available
			System.out.println("MUMBAI\t\t1");
			System.out.println("PUNE\t\t2");
			System.out.println("NASHIK\t\t3");
			System.out.println("SATARA\t\t4");
			System.out.println("WAI\t\t5");
			System.out.println("SOLAPUR\t\t6");
			System.out.println("NAGPUR\t\t7");
			System.out.println("KOLHAPUR\t\t8");
			break;
			
		case 9://if route between 9 cities available
			System.out.println("MUMBAI\t\t1");
			System.out.println("PUNE\t\t2");
			System.out.println("NASHIK\t\t3");
			System.out.println("SATARA\t\t4");
			System.out.println("WAI\t\t5");
			System.out.println("SOLAPUR\t\t6");
			System.out.println("NAGPUR\t\t7");
			System.out.println("KOLHAPUR\t\t8");
			System.out.println("SANGLI\t\t9");
			break;
			
		case 10://if route between 10 cities available
			System.out.println("MUMBAI\t\t1");
			System.out.println("PUNE\t\t2");
			System.out.println("NASHIK\t\t3");
			System.out.println("SATARA\t\t4");
			System.out.println("WAI\t\t5");
			System.out.println("SOLAPUR\t\t6");
			System.out.println("NAGPUR\t\t7");
			System.out.println("KOLHAPUR\t\t8");
			System.out.println("SANGLI\t\t9");
			System.out.println("SANGAMNER\t\t10");
			break;
		}

	}
}





