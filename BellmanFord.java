/*********************************************************************************************************************
     **
     **  Bellman Ford algorithm to find shortest path 
     **  Used data structure:
	 **				1. Linked List
	 **				
     **  Input in the form of array
     **  Output is shortest distance from source vertex
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/

//import package

import java.util.*;
import java.io.*;

public class Main
{
    //class to store edges with weight
    static class Item
    {
        int i1;
        int i2;
        int value;
        Item(int i1,int i2,int value)
        {
            this.i1=i1;
            this.i2=i2;
            this.value=value;
        }
    }
    
    static int[]dis;
    static boolean flag=true;
    public static void bellmanFord(LinkedList<Item>list)
    {
        
        Iterator<Item>itr=list.iterator();
            
        while(itr.hasNext())
        {
            Item x=itr.next();
            int i1=x.i1;
            int i2=x.i2;
            int value=x.value;
            
            if(dis[i2]>(dis[i1]+value))
            {
                flag=false;              
                dis[i2]=dis[i1]+value;
              
            }
        }
    }
    
    public static void main(String[]args) throws IOException
    {
        
        Scanner scan=new Scanner(System.in);
        
            //n =number of vertices
            int n=6; //scan.nextInt();
            //m = number of edges
            int m=9; //scan.nextInt();
            
            //array a to store edge from a[i][0] to a[i][1]
            int [][]a={{1,2},{1,3},{1,4},{2,5},{3,2},{3,5},{4,3},{5,6},{4,6}};
            //array w to store weight on respective edge of arra a
            int[]w={6,4,5,-1,-2,3,-2,3,-1};
            LinkedList<Item>list=new LinkedList<>();
            
            int x,y,r;    
            
            for(int i=0;i<m;i++)
            {
                
                x=a[i][0]; //scan.nextInt();
                y=a[i][1]; //scan.nextInt();
                r=w[i]; //scan.nextInt();
                list.add(new Item(x,y,r));
                
                //list.add(new Item(x,r));
            }
            
            
                
            //source is vertex from which we want shortest distance
            int source=1; //scan.nextInt();
            
            dis=new int[n+1];
            
            Arrays.fill(dis,Integer.MAX_VALUE);
            dis[source]=0;
            
            
            
            for(int i=0;i<n-1;i++)
            {
                bellmanFord(list);
            }
            
            //to check presence of negative cycle
            flag=true;
            for(int i=1;i<=1;i++)
                bellmanFord(list);
            
            if(!flag)    
                System.out.println("Negative cycle present");
                
            //print shortest distance from source vertex if not exist any path then print -1
            for(int i=1;i<=n;i++)
            {
                if(dis[i]==Integer.MAX_VALUE)
                    System.out.println("No Path between 1 and "+i+" ");
                else
                    System.out.println("Shortest Path from 1 to "+i+" : "+dis[i]+" ");    
            }
            
    }
    
}
