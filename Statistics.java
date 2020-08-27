
public class Statistics 
{
    
    public int numoFTrades, numoFLongTr, numoFShortTr, TotalnumberLongDays, TotalnumberShortDays; 
    
           double TotallongWinners, TotallongLosers, TotalshortWinners, TotalshortLosers,numoFWinningTr, numoFLosingTr;
    
           double TotalWinnings, TotalLongWinnings, TotalShortWinnings,AvenumberDays;
	
  public Statistics()
  {
    numoFTrades = numoFLongTr = numoFShortTr = TotalnumberLongDays = TotalnumberShortDays =0;
    
    TotallongWinners = TotallongLosers = TotalshortWinners = TotalshortLosers  =numoFWinningTr = numoFLosingTr = 0;
    
    TotalWinnings = TotalLongWinnings = TotalShortWinnings = AvenumberDays= 0;
  }
  
  public double getTotalWinnings()
  {
  return TotalWinnings;
  }


  
public String toString()
{
    String st1 = "Number of Trades: " + numoFTrades + ", Number of Long Trades: " + numoFLongTr+", Number of Short Trades: " + numoFShortTr+".";
    
    String st2 = "\nNumber of Long Days: "+TotalnumberLongDays+", Number of Short Days: "+TotalnumberShortDays;
    
    String st3 = ", Average Holding Trades per Trades: "+AvenumberDays+" days.";
    
    String st4 = "\nWinning Trades: " + numoFWinningTr + "%, Losing Trades: "+ numoFLosingTr+"%";
    
    String st5 = "\nLong Winners: " + TotallongWinners + "%, Long Losers: " + TotallongLosers+"%";
    
    String st6 = "\nShort Winners: " + TotalshortWinners + "%, Short Losers:  "+TotalshortLosers+"%";
    
    String st7 = "\nNet Profit: " + TotalWinnings + "%, Net Profit(Long): " + TotalLongWinnings+"%"; 
    
    String st8 = ", Net Profit(Short): " + TotalShortWinnings + "%";
    
   
           
   
    return st1+st2+st3+st4+st5+st6+st7+st8;
    
}

    
}
