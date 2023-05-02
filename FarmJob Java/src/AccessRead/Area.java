package AccessRead;

public class Area {
	public String pName;
    public String moist;
    public String temp;
    public Double key;

    public Area(String pName, String moist, String temp, Double key) { 
        this.pName = pName;
        this.moist = moist;
        this.temp = temp;
        this.key = key;
        }
    public void display()
    {
        System.out.println( pName + " has a soil moisture regime of " + moist + " and a soil temperature regime of " + temp);
        System.out.println();
    }
}
