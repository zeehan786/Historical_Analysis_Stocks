public class SuperMain 
{

 
    public static void main(String[] args)
    {
        
        String path = "C:\\Users\\zeeha\\Desktop\\Data\\";
        
        String Sfile = "Stocks.txt";
        
        String Efile = "ETFs.txt";    
        
               double[] target = new double[4];
		target[0] = 0.01;
		target[1] = 0.02;
		target[2] = 0.05;
		target[3] = 0.1;
                
		double[] loss = new double[4];
		loss[0] = 0.01;
		loss[1] = 0.02;
		loss[2] = 0.05;
		loss[3] = 0.1;
        
       
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
      
            HigherClass stck1 = new HigherClass(path,Sfile,target[j],loss[i]);
            HigherClass etf1 = new HigherClass(path,Efile,target[j],loss[i]);
            
            stck1.SymbolReader();   
            etf1.SymbolReader();
            
              tradeArray Trades = (stck1.getAllTrade());
              
             
           
              System.out.println("For Stocks.txt: TargetPrice: "+target[j]+"%, StopLoss = "+ loss[i]+"%\n"+Trades.getStats().toString()+"\n\n\n");
            
            
           
              tradeArray Trades2 = (etf1.getAllTrade());
            
             System.out.println("For ETFs.txt: TargetPrice: "+target[j]+"%, StopLoss = "+ loss[i]+"%\n"+Trades2.getStats().toString()+"\n\n\n");
            
            
              Trades.addArray(Trades2);
          
             System.out.println("Combination of Stocks.txt and ETF.txt: "+target[j]+"%, StopLoss = "+ loss[i]+"%\n"+Trades.getStats().toString()+"\n\n\n");
            
           
            }
        }
        

      }
    
}  
        

      

        
        
    
