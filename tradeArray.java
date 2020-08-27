import java.util.*;
public class tradeArray {
	
	//A vector of trades Vector<Trade> 
	private Vector<Trade> v;
	//default constructor calls default constructor for Vector 
	public tradeArray(){
		v = new Vector<Trade>();
	}
	//Constructor with one integer calls the Vector constructor
	public tradeArray(int s){
		v = new Vector<Trade>(s);
	}
	//constructor with two integers calls also Vector constructor
	public tradeArray(int s, int inc){
		v = new Vector<Trade>(s, inc);
	}
	public int size() {
		return v.size();
	}
	//inset method to call the add method in the Vector 
	public void insert(Trade T) {
		v.add(T);
	}
	//public Trade At(int index) retuning the trade at index index.
	public Trade At(int index) {
		return v.elementAt(index);
	}
	public void addArray(tradeArray input) {
		for (int i =0; i < input.size(); i++) {
			//Trade T = new Trade(input.At(i));
			this.insert(input.At(i));
		}
	}
	public String toString() 
        {
		String st = "";
		int s = size();
		for (int i = 0; i <s; i++) {
			st += this.At(i).toString() + "\n";
		}
		return st;
	}
        
        public Statistics getStats() {
		//create a Stats objects 
		Statistics st = new Statistics();
		//go throu the array (vector) trade per trade and update the info in Stats
                st.numoFTrades = this.size();
		for (int i = 0; i < this.size(); i++){
			
			st.AvenumberDays += this.At(i).getHolding();
                        st.TotalLongWinnings += this.At(i).ProfitPerc();
                        st.TotalShortWinnings += this.At(i).ProfitPerc();
                        
			if(this.At(i).ProfitPerc()>=0) {
                                
				//st.TotalWinnings += this.At(i).ProfitPerc();
				st.numoFWinningTr++;
				if(this.At(i).getDir() == true) {
                                    
					st.numoFLongTr++;
					st.TotallongWinners++;
					
					st.TotalnumberLongDays += this.At(i).getHolding();
					
				}else {
					st.numoFShortTr++;
					st.TotalshortWinners++;
					
					st.TotalnumberShortDays += this.At(i).getHolding();
				}
			} else {//it is a loser
				st.numoFLosingTr++;
				//st.totalLoss += this.At(i).percentPL();
				if(this.At(i).getDir() == true) {
                                    
					st.numoFLongTr++;
					st.TotallongLosers++;					
					st.TotalnumberLongDays += this.At(i).getHolding();
					
				}else {
                                        st.numoFShortTr++;
					st.TotalshortLosers++;					
					st.TotalnumberShortDays += this.At(i).getHolding();
				}
			}
		}
                st.numoFWinningTr = (st.numoFWinningTr/st.numoFTrades)*100;
                
                st.numoFLosingTr = (st.numoFLosingTr/st.numoFTrades)*100;
                
                st.TotallongWinners = st.TotallongWinners/st.numoFLongTr * 100; 
                
                st.TotalshortWinners = st.TotalshortWinners/st.numoFShortTr * 100;
                
                st.TotallongLosers = st.TotallongLosers/st.numoFLongTr * 100;
                
                st.TotalshortLosers = st.TotalshortLosers/st.numoFShortTr * 100;
                
                st.TotalLongWinnings = (st.TotalLongWinnings/st.numoFLongTr);             
                         
                st.TotalShortWinnings = (st.TotalShortWinnings/st.numoFShortTr);
                
                st.TotalWinnings = (st.TotalLongWinnings*st.numoFLongTr + st.TotalShortWinnings*st.numoFShortTr)/(st.numoFTrades);
                
                st.AvenumberDays = ((double)st.AvenumberDays)/st.numoFTrades;
            
		return st;
	}	
        
}