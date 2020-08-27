import java.io.*;

public class HigherClass 

{
    
private tradeArray AllTrade = new tradeArray(1000);

private String path;
private String symbolfile;

private double TargetP, StopLoss;



public HigherClass(String location, String sym, double target, double loss)
{
path = location;
symbolfile = sym;
TargetP = target;
StopLoss = loss;
}
    


public void SymbolReader() {
		
		File myfile = new File(path+symbolfile);
		 if (!myfile.exists()) {
			 System.out.println(symbolfile+" does not exist ");
			 System.exit(1);
		 }
		try{ 
			FileReader fr = new FileReader(path+symbolfile);
			//open the file FileReader->BufferedReader
			BufferedReader br = new BufferedReader(fr);
			String Symbol;
			
			while((Symbol = br.readLine())!= null) 
                        {
				//System.out.println("x");
                                String filename = Symbol + "_Daily.csv";
				Tester obj = new Tester(path,filename, TargetP, StopLoss);
                                obj.Run();
                                AllTrade.addArray(obj.getTrades());
                                
                               
                               
                                
                        }
                        }
                catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

        }
public double getTargetPrice()
{
return TargetP;
}
public double getStopLoss()
{
return StopLoss;
}

public tradeArray getAllTrade()
{
return AllTrade;
}




}


