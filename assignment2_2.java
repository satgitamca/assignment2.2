package assinment2.pkg1;

import java.util.*;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


class Business2
   {
    Scanner sc = new Scanner(System.in);
    String[] dateArray=new String[3];
    String newdate;
    String[] MonthIndex={"01","02","03","04","05","06","07","08","09","10","11","12"};
    String[] MonthName={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
   
    //Given input: “1,2,3,4,5-8,6-10,8-15,16-25,20-30,22-26”;
    //output: 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30;
    String[] UserInputs = {"1","2","3","4","5-8","6-10","8-15","16-25","20-30","22-26"};
    
    int[] LB={1,4,9,12,17,20,25,28,33,36,41,44,49,52,57,60};
    int[] MB={2,5,10,13,18,21,26,29,34,37,42,45,30,53,58,61};
    int[] UB={3,6,11,14,19,22,27,30,35,38,43,46,51,54,59,62};
    int[] SL={7,15,23,39,47,55,63};
    int[] SU={8,16,24,32,48,56,64};
    public void PrintBirthName()
    {
     String BirthName="";   
     System.out.print("Please Enter valid Birth Number(1 to 64): "); 
     int  Inputbirthnumber= sc.nextInt();
     if(findBirthName(Inputbirthnumber,LB)==true)BirthName="Lower";
     else if(findBirthName(Inputbirthnumber,MB)==true)BirthName="Middle";
     else if(findBirthName(Inputbirthnumber,UB)==true)BirthName="Upper";
     else if(findBirthName(Inputbirthnumber,SL)==true)BirthName="Side Lower";
     else if(findBirthName(Inputbirthnumber,SU)==true)BirthName="Side Upper";
     else BirthName="Invalid Birth Number";
        System.out.println("You entered "+Inputbirthnumber +" and your Birth is "+BirthName);
    }
    
    public boolean findBirthName(int BirthNumber,int[] arr)
    {  boolean isFound=false;
       for(int i=0;i<arr.length;i++)
       {
          if(arr[i]==BirthNumber)
          isFound=true; 
       }
      return isFound; 
    }
    
    public void PrintOPfrominputArray()
    {
        System.out.println("User Input is:1,2,3,4,5-8,6-10,8-15,16-25,20-30,22-26");
        System.out.println("aspected Output is:1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30");
        System.out.println("========================Result============================");
        int counter=0,max=0;
        for(int i=0;i<UserInputs.length;i++)
        {
          if(UserInputs[i].contains("-")==false && Integer.parseInt(UserInputs[i])>max )
               max=Integer.parseInt(UserInputs[i]);
           else
               if(Integer.parseInt(UserInputs[i].split("-")[1])>max)
               max=Integer.parseInt(UserInputs[i].split("-")[1]);
        }
        System.out.print("Output is:1");
        for(int j=2;j<=max;j++)
        {
        System.out.print(","+j);
        }
    System.out.println("");
    }
    public String PrintMonthDay(String mName)
    {
     String mvalue="00"; 
     for(int i=0;i<MonthName.length;i++)
     {
       if(MonthName[i].equals(mName))
         mvalue=MonthIndex[i];
       }
      return mvalue;
    }
    
    public void PrintDateFormat()
    {
     DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd/MMM/uuuu" );
     LocalDate ld;
     System.out.print("Please Enter valid Date((MM Mon YYYY/MM,Mon,YYYY): "); 
     String  InputDate= sc.nextLine();
     if(InputDate.contains(",")==true)
    {
      dateArray=InputDate.split(",");
      newdate=dateArray[2]+"-"+PrintMonthDay(dateArray[1])+"-"+dateArray[0];
      System.out.println( "Input date is:"+InputDate+"\tResult date is :"+newdate);
      //ld = LocalDate.parse(InputDate , f );//input date should be in this formate 19/05/2009
      //System.out.println("Formated date is:"+ld);
     }
     else if(InputDate.contains(" ")==true)
     {
      dateArray=InputDate.split(" ");
      newdate=dateArray[2]+"-"+PrintMonthDay(dateArray[1])+"-"+dateArray[0];
      System.out.println( "Input date is:"+InputDate+"\tResult date is :"+newdate);
     }
     else
     {
        PrintDateFormat(); 
     }
     System.out.println("=====================================");
     
    }
 }

public class assignment2_2
{
    public static void main(String[] args)
     {
         Scanner sc = new Scanner(System.in);
         Business2 b2=new Business2();
         System.out.println("========Enter Your Choice:===============");
         System.out.println("Enter 1 for Print Birth:");
         System.out.println("Enter 2 for Date formate:");
         System.out.println("Enter 3 for Array aspected result:");
         int  choice= sc.nextInt();
         if(choice==1) b2.PrintBirthName(); 
         if(choice==2) b2.PrintDateFormat();
         if(choice==3)b2.PrintOPfrominputArray();
     }
}
