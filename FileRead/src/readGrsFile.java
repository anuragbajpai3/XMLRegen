
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


 class FileRead 
 {
  public static void main(String args[])
   {
   try{
   // Open the file that is the first 
   // command line parameter
   FileInputStream fstream = new FileInputStream("C:\\Users\\abajpai\\git\\ParsingFiles\\FileRead\\result.grs");
   // Get the object of DataInputStream
   DataInputStream in = new DataInputStream(fstream);
   BufferedReader br  = new BufferedReader(new InputStreamReader(in));
   String strLine;
  /* String[] NodeClass       = new String[1000]; 
   String[] NodeName        = new String[1000];
   String[] SourceNode      = new String[1000]; 
   String[] DestNode        = new String[1000];
   String[] SourceNodeClass = new String[1000]; 
   String[] DestNodeClass   = new String[1000];*/
  
   List<String>NodeName           = new ArrayList<String>();
   List <String> NodeClass        = new ArrayList <String> ();
   List <String> SourceNodeName   = new ArrayList <String> ();
   List <String> DestNodeName     = new ArrayList <String> ();
   List <String> SourceNodeClass  = new ArrayList <String> ();
   List <String> DestNodeClass    = new ArrayList <String> ();


   int p = 1;
   int b = 1;
   //Read File Line By Line
   while ((strLine = br.readLine()) != null)   {
   // Print the content on the console
   //System.out.println (strLine);
   String str_nodesep = str_piece(strLine, '#', 1);
   if (strLine.equals(str_nodesep)){
	  // System.out.println("The given string is not a hash line");// No hash present
	   String str_nodesep1 = str_piece(str_nodesep, ':', 1);
	   //System.out.println (str_nodesep1);
	   if (str_nodesep.equals(str_nodesep1)){
		  // System.out.println("The given string is not a node line");
	   }
	   else{
		  // System.out.println("The given string is a node/edge line");
		   String str_nodesep2 = str_piece(str_nodesep1, '@', 1);
		  if ((str_nodesep1.equals(str_nodesep2)))
		   {	
			 
			  
			  
			   //System.out.println("The given string is a node line");
			  System.out.println(strLine);
			    String str_resultn1 = str_piece(strLine, ':', 2);
			    System.out.println(str_resultn1);
			    NodeName.add(str_piece(str_resultn1, '(', 1));
		        NodeClass.add(str_piece(str_resultn1, '"', 2));
		       
		        Iterator it=NodeClass.iterator();

		        while(it.hasNext())
		        {
		          String value=(String)it.next();

		          System.out.println("Value :"+value);
		        }

		       /* System.out.println("***** Node Names and Class******");
		        System.out.println(NodeClass[p]);
		        System.out.println(NodeName[p]);
		        System.out.println("********************************");*/
		        p              = p+1;
		       // System.out.println(p);
			  
		   }
		  else
		  {
			  
		        String str_result1 = str_piece(strLine, ':', 1);
		        String str_result2 = str_piece(strLine, ':', 2);
		        String str_result3 = str_piece(str_result2, '-', 2);
		        String str_destNode = str_piece(str_result3, '"', 2);
		        String str_srcNode = str_piece(str_result1, '"', 2);
		        SourceNodeName.add(str_piece(str_result1, '"', 2));
		        DestNodeName.add(str_piece(str_result3, '"', 2));
		        /*System.out.println(SourceNode[b]);
		        System.out.println(DestNode[b]);*/
		        b = b + 1;
		       
		   }
		  
		    
	   }
	   }
	   else{
	   //System.out.println("The given string is a hash line");
	   }
	 
   
   }
   
   //Close the input stream
   in.close();
     }catch (Exception e){//Catch exception if any
   System.err.println("Error: " + e.getMessage());
   }
   }
  private static String str_piece(String str, char separator, int index) {
      String str_result = "";
      int count = 0;
      for(int i = 0; i < str.length(); i++) {
          if(str.charAt(i) == separator) {
              count++;
              if(count == index) {
                  break;
              }
          }
          else {
              if(count == index-1) {
                  str_result += str.charAt(i);
              }
          }
      }
      return str_result;
  }
 }
 	