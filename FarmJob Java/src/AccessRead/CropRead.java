package AccessRead;
import java.sql.*;
import java.util.*;


public class CropRead {
	
	public static void main(String[] args) {
		Read();		
	}

	public static void Read() {
        try {
//          import java.sql.*;
        	Connection conn=DriverManager.getConnection(
        	        "jdbc:ucanaccess://C:/Users/enoch/Documents/FarmJob/Soil Data/soildb_US_2003.mdb");
        	Statement s = conn.createStatement();
        	Statement t = conn.createStatement();
        	ResultSet cyl = s.executeQuery("select * from cocropyld");
        	ResultSet rst = t.executeQuery("select * from component");	

       
        	CrpYld[] Yield=new CrpYld[101];
        	Area[] cArea=new Area[101];
        	Random rand = new Random();
        	Integer[] Sumn=new Integer[5];
        	for (int h=0;h<3;h++) {
        		Sumn[h]= rand.nextInt(101);
        	}
        	int i=0;
        	int j=0;
        	int o=0;
        	
        	//getting data from table
        	while ((cyl.next() )&&(rst.next())&&(i<101)) {
        		Yield[i] = new CrpYld(cyl.getString("cropname"),rst.getString("compname"),cyl.getDouble("nonirryield_r"),cyl.getDouble("cokey"),cyl.getString("yldunits"));
    			i++;    			
        	}        
        	
        	while ((rst.next())&&(j<101)) {
        		cArea[j] = new Area(rst.getString("compname"),rst.getString("taxmoistscl"),rst.getString("taxtempregime"),rst.getDouble("cokey"));
        		j++;
        	}     	
        	
        	//Extra variables
        	
//        	String sName=Yield[Sumn[0]].loc;
//        	Double sKey=Yield[Sumn[0]].key;        	
//        	while(cArea[o].key==sKey) {
//        		cArea[o].display();
//        		o++;
//        	}
        	
        	//print
        	System.out.print("3 Random Crop Harvest Facts in Bradley County\n");
        	while(o<3) {
        		System.out.print(o+1 + ". ");
        		Yield[Sumn[o]].display();
        		o++;
        	}
        }
        catch(Exception e) {
       	 e.printStackTrace();
        }
	}

	public static void Sort(CrpYld[] yum) {
		Arrays.sort(yum); 
	}
}