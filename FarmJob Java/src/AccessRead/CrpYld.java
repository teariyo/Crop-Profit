package AccessRead;

public class CrpYld {
	public String cName;
    public Double iYield;
    public String loc;
    public Double key;
    public String units;

    public CrpYld(String cName, String loc,Double iYield, Double key,String units) { 
        this.cName = cName;
        this.loc = loc;
        this.iYield = iYield;
        this.key = key;
        this.units = units;
        }
    public void display()
    {
        System.out.println( cName + " cultivated on irrigated land in " + loc + " produces about " + iYield + " " + units +" per acre per year.\n" );
    }
}
