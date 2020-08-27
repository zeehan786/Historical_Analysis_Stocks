import java.io.*;
public class Tester 
{
	

private tradeArray SelectedTrade = new tradeArray(1000);
  
private OurArray <Bar> BarSet = new OurArray<Bar>(10000); 

private String path;

private String fileName;

private double Sloss,TPrice;


public Tester(String p,String Fname, double TargetP, double StopL)
{
fileName = Fname;
path =p;
TPrice = TargetP;
Sloss = StopL;
}

public tradeArray getTrades(){
    return SelectedTrade;
}

public void Run()
{

try
{
FileReader fr = new FileReader(path+"\\"+fileName);
BufferedReader br = new BufferedReader(fr);
String line = br.readLine();//ignores the first line
while((line=br.readLine())!=null)
{
Bar b = new Bar(line);
//Why not Bar b(line);
BarSet.AddBack(b);
}
fr.close();
//why not br.close
} 
catch(IOException e)
{
	System.out.println("Exception: "+e.getMessage());
	System.exit(1);
}

//Long Trade--------------------------------------------------------------------
for (int i = 3; i < BarSet.Getsize() - 1; i++) {
	//when do we have a pattern? 
        //System.out.println("Loop: "+i);
	if(BarSet.elementAt(i).getLowestP() < BarSet.elementAt(i-1).getLowestP() //1 if(BarSet.elementAt(i).getHighestP() > BarSet.elementAt(i-1).getHighestP() //1
			&& BarSet.elementAt(i).getHighestP() > BarSet.elementAt(i-1).getHighestP() //2
			&& BarSet.elementAt(i-1).getHighestP() > BarSet.elementAt(i-2).getHighestP() //3
			&& BarSet.elementAt(i-1).getLowestP() > BarSet.elementAt(i-2).getLowestP() //4
			&& BarSet.elementAt(i-2).getHighestP() > BarSet.elementAt(i-3).getHighestP() //5
			&& BarSet.elementAt(i-2).getLowestP() > BarSet.elementAt(i-3).getLowestP() //6
			&& //close of last bar is close to the bottom
			(BarSet.elementAt(i).getClosingP()-BarSet.elementAt(i).getLowestP())/(BarSet.elementAt(i).getHighestP()-BarSet.elementAt(i).getLowestP()) < 0.05)
	{
		Trade t = new Trade(); //create a trade
		String entrydate = BarSet.elementAt(i+1).getDate();
		double entryprice = BarSet.elementAt(i+1).getOpeningP();
		double stoploss = entryprice *(1-Sloss);
		double target = entryprice * (1+TPrice);
		t.open(entrydate,entryprice,stoploss,target, true); //long(buy)
                outcomes(t, i+1);
	}else if(BarSet.elementAt(i).getHighestP() > BarSet.elementAt(i-1).getHighestP() //1
			&& BarSet.elementAt(i).getLowestP() < BarSet.elementAt(i-1).getLowestP() //2
			&& BarSet.elementAt(i-1).getLowestP() < BarSet.elementAt(i-2).getLowestP() //3
			&& BarSet.elementAt(i-1).getHighestP() < BarSet.elementAt(i-2).getHighestP() //4
			&& BarSet.elementAt(i-2).getLowestP() < BarSet.elementAt(i-3).getLowestP() //5
			&& BarSet.elementAt(i-2).getHighestP() < BarSet.elementAt(i-3).getHighestP() //6
			&& //close of last bar is close to the top
			(BarSet.elementAt(i).getHighestP() - BarSet.elementAt(i).getClosingP())/(BarSet.elementAt(i).getHighestP()-BarSet.elementAt(i).getLowestP())<0.05)
	{
		Trade t = new Trade();
		String entrydate = BarSet.elementAt(i+1).getDate();
		double entryprice = BarSet.elementAt(i+1).getOpeningP();
		double stoploss = entryprice *(1+Sloss);
		double target = entryprice * (1-TPrice);
		t.open(entrydate,entryprice,stoploss,target, false);//short (sell this stock)
                outcomes(t, i+1);
              
	}
            
        }
}

void outcomes(Trade t, int ind){
    int j=ind;//i+1
    for(j=ind;j<BarSet.Getsize(); j++)
    {
        if(t.getDir() == true){
	if(BarSet.elementAt(j).getLowestP()<=t.getStopLoss())
	{
            if(BarSet.elementAt(j).getOpeningP()<=t.getStopLoss())
            {
		t.close(BarSet.elementAt(j).getDate(),BarSet.elementAt(j).getOpeningP());
                t.setHolding(j-ind);
                
                //System.out.println("Holding: "+t.getHolding());
                        SelectedTrade.insert(t);
                        break;
            }else{
                 t.close(BarSet.elementAt(j).getDate(),t.getStopLoss());
                  t.setHolding(j-ind);
                        SelectedTrade.insert(t);
                        break;
                        }
        }else if(BarSet.elementAt(j).getHighestP()>=t.getTarget())
                      {
                          if(BarSet.elementAt(j).getOpeningP()>=t.getTarget())
                          {
                           t.close(BarSet.elementAt(j).getDate(), BarSet.elementAt(j).getOpeningP());
                            t.setHolding(j-ind);
                           SelectedTrade.insert(t);   
                           break;
                          }
                           else
                          {
                          t.close(BarSet.elementAt(j).getDate(), t.getTarget());
                           t.setHolding(j-ind);
                          SelectedTrade.insert(t);
                          break;
                          }
                      
                      }
        }
        else{
		if(BarSet.elementAt(j).getHighestP()>=t.getStopLoss())
		{
                        if(BarSet.elementAt(j).getOpeningP()>=t.getStopLoss())
                        {
			t.close(BarSet.elementAt(j).getDate(),BarSet.elementAt(j).getOpeningP() );
                         t.setHolding(j-ind);
                        SelectedTrade.insert(t);
                        break;
                        }
                        else
                        {
                        t.close(BarSet.elementAt(j).getDate(),t.getStopLoss());
                        t.setHolding(j-ind);
                        SelectedTrade.insert(t);
                        break;
                        }
		}
                       else if(BarSet.elementAt(j).getLowestP()<=t.getTarget())
                      {
                          if(BarSet.elementAt(j).getOpeningP()<=t.getTarget())
                          {
                           t.close(BarSet.elementAt(j).getDate(), BarSet.elementAt(j).getOpeningP());
                           t.setHolding(j-ind);
                           SelectedTrade.insert(t);   
                           break;
                          }
                           else
                          {
                          t.close(BarSet.elementAt(j).getDate(), t.getTarget());
                          t.setHolding(j-ind);
                          SelectedTrade.insert(t);
                          break;
                          }
                      }
                   }
    }
         if(j==BarSet.Getsize())
                       {
                       t.close(BarSet.elementAt(j-1).getDate(),BarSet.elementAt(j-1).getAdjClose());
                        t.setHolding(j-ind);
                       if(t.getDir() == true)
                         SelectedTrade.insert(t);
                       else 
                         SelectedTrade.insert(t);  
                       }
    
    
}
    
}
/*

*/