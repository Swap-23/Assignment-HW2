
import java.io.*;
public class Dictionary_Keywords
{
	public static void main(String[] args)throws Exception
	{
		FileReader R1 =  new FileReader("D:\\New Folder\\Documents\\JAVA Lab 6060\\HW2\\csx-351-hw2-Swap-23-master\\HW2-dictionary.txt");//Two input files :
        BufferedReader Dict  =  new BufferedReader(R1);                                                    //1.Dictionary
        FileReader R2 =  new FileReader("D:\\New Folder\\Documents\\JAVA Lab 6060\\HW2\\csx-351-hw2-Swap-23-master\\HW2-keywords.txt");//2.Keywords
        BufferedReader Key =  new BufferedReader(R2);                                     			 //One output file : To store
        FileWriter W1 = new FileWriter("D:\\New Folder\\Documents\\JAVA Lab 6060\\HW2\\Output.txt"); // the output
        BufferedWriter Output = new BufferedWriter(W1); 
        String Line1=null;  
        String Line2=null; 
        String Dictionary[]=new String[16000]; // Array of size 16000 to store the words read from Dictionary file.
        String Keywords[]=new String[84]; // Array of size 84 to store the words read from Keywords file.
        int i=0;
        while((Line1=Dict.readLine()) != null)
        {
        	   Dictionary[i]=Line1; // Reading from the Dictionary file and storing int the array.
        	   i++;
        }
        i=0;
        while((Line2=Key.readLine()) != null)
        {
        			Keywords[i]=Line2; // Reading from the Keywords file and storing the array.
        			++i;
        }
        Sort(Dictionary); // Function calls for 
        Sort(Keywords); // sorting the two arrays.
        int count=0,flag=0;
        for(i=0;i<84;++i)
        {
        	String S=Keywords[i];
        	flag=0;
        	for(int j=0;j<16000;++j)
        	{
        		if(S.equalsIgnoreCase(Dictionary[j])) // Linearly searching every element of Keywords array
        		{	                         // in the Dictionary array.
        			flag=1;
        		    break;
        	    }
        	}
        	if(flag!=1)
        	{
        		Output.write("Keyword not found : "+S); // Writing the keyword which is not found 
        		Output.newLine();                       // in the Output file.
			    ++count;
        	}
        }
        Output.write("The number of keywords not found : "+count);
        Dict.close(); // Closing the objects which have been created
        Key.close();  // for reading
        Output.close();// and writing.
	}

// Function for sorting the array of strings using Bubble sort technique.
	
static void Sort(String[] A) 
	{
		int l=A.length;
		for(int i=0;i<l-1;++i)
		{
			for(int j=0;j<l-i-1;++j)
			{
				if(A[j].compareTo(A[j+1])>0) // Inbuilt compareTo function for compaaring two strings
				{                            
					String temp=A[j]; 
					A[j]=A[j+1];
					A[j+1]=temp;
				}
			}
		}
	}
}

