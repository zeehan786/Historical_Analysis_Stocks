public class Trade {
	
private String EntryDate, ExitDate;
private double EntryPrice, ExitPrice, StopLoss, TargetP;
private boolean dir;//true for long trade, false for short
private int holdingPeriod;

public Trade()
{
holdingPeriod = 0;
}
public void setHolding(int h){
    holdingPeriod = h;
}
public int getHolding(){
   return holdingPeriod;
}
public Trade(Trade T) {
		//symbol = T.symbol;
		EntryDate = T.EntryDate;
		EntryPrice = T.EntryPrice;
		StopLoss = T.StopLoss;
		TargetP = T.TargetP;
		//dir = T.dir;
		//on = T.on;
		ExitPrice = T.ExitPrice;
		ExitDate = T.ExitDate;
                this.dir = T.dir;
		//HoldingPeriod = T.HoldingPeriod;
	}

public void open(String Entday, double EntP, double StL, double TP, boolean d)
{
EntryDate = Entday;
EntryPrice = EntP;
StopLoss = StL;
TargetP = TP;
dir = d;
//Why we need StopLoss and TargetP in open function
}
public void close(String date, double EP)
{
	ExitDate = date;
	ExitPrice = EP;
}
public double ProfitPerc()
{
    if (dir == true){
        return (ExitPrice-EntryPrice)/EntryPrice*100.0;
    }else{
        return (EntryPrice - ExitPrice)/EntryPrice*100.0;
    }
}
public String getEntryDate() {
	return EntryDate;
}
public void setEntryDate(String entryDate) {
	EntryDate = entryDate;
}
public String getExitDate() {
	return ExitDate;
}
public void setExitDate(String exitDate) {
	ExitDate = exitDate;
}
public double getEntryPrice() {
	return EntryPrice;
}
public void setEntryPrice(double entryPrice) {
	EntryPrice = entryPrice;
}
public double getExitPrice() {
	return ExitPrice;
}
public void setExitPrice(double exitPrice) {
	ExitPrice = exitPrice;
}
public double getStopLoss() {
	return StopLoss;
}
public void setStopLoss(double stopLoss) {
	StopLoss = stopLoss;
}
public double getTarget() {
	return TargetP;
}
public void setTarget(double target) {
	TargetP = target;
}
public void setDir(boolean d){
    dir = d;
}
public boolean getDir(){
    return dir;
}

public String toString()
{
return "\n"+this.EntryDate+" ,"+this.EntryPrice+" ,"+this.getTarget()+" ,"+this.getStopLoss()+" ,"+this.getExitDate()+" ,"+this.getExitPrice()+
        " ,"+this.getHolding();
}
}
