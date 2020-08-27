//Bar
public class Bar {

private String Date;
private double OpeningP;
private double HighestP;
private double LowestP;
private double ClosingP;
private double adjclose;
private int Volume;

public Bar(String D, float OP, float HP, float LP, float CP, int V) 
{
	Date = D;
	OpeningP = OP;
	HighestP = HP;
	LowestP = HP;
	ClosingP = CP;
	Volume = V;
}
public Bar(String str)
{
  //////     date, open,high,low,close,adj,volume//
	//str = {"2018-02-18,23.04,45,34.3,41.2,42.1,123"};

		String[] splitedSt = str.split(",");
		if (splitedSt.length != 7)
		{
			System.out.println("There is A problem");
			System.exit(1);
		}
		this.Date = splitedSt[0];
		this.OpeningP = Double.parseDouble(splitedSt[1]);
		this.HighestP = Double.parseDouble(splitedSt[2]);
		this.LowestP = Double.parseDouble(splitedSt[3]);
		this.ClosingP = Double.parseDouble(splitedSt[4]);
		this.adjclose = Double.parseDouble(splitedSt[5]);
		this.Volume = Integer.parseInt(splitedSt[6]);
}

public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}
public double getOpeningP() {
	return OpeningP;
}
public void setOpeningP(float openingP) {
	OpeningP = openingP;
}
public double getHighestP() {
	return HighestP;
}
public void setHighestP(float highestP) {
	HighestP = highestP;
}
public double getLowestP() {
	return LowestP;
}
public void setLowestP(float lowestP) {
	LowestP = lowestP;
}
public double getClosingP() {
	return ClosingP;
}
public void setClosingP(float closingP) {
	ClosingP = closingP;
}
public int getVolume() {
	return Volume;
}
public void setVolume(int volume) {
	Volume = volume;
}
public void setAdjClose(double adjClose) {
	this.adjclose = adjclose;
}
public double getAdjClose() {
	return adjclose;
}
}
