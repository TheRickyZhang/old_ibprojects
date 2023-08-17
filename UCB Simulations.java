import java.util.*;
class Main {
  public static double UCB(Distribution d, double C, int i){
      return d.calculateMean() + C * (Math.sqrt(Math.log(i)/(d.getSuccesses()+d.getFailures())));
  }


  public static void main(String[] args) {

  double[] averageRegret = new double[10000];
    
for(double e = 0.2; e<.5; e+=.5){
  for(int a = 0; a<1000; a++){
    Distribution A = new Distribution(Math.random());
    Distribution B = new Distribution(Math.random());
    Distribution C = new Distribution(Math.random());
    Distribution D = new Distribution(Math.random());
    Distribution E = new Distribution(Math.random());
    Distribution F = new Distribution(Math.random());
    Distribution G = new Distribution(Math.random());
    Distribution H = new Distribution(Math.random());
    Distribution I = new Distribution(Math.random());
    Distribution J = new Distribution(Math.random());

    Distribution[] list = new Distribution[10];
    list[0] = A;
    list[1] = B;
    list[2] = C;
    list[3] = D;
    list[4] = E;
    list[5] = F;
    list[6] = G;
    list[7] = H;
    list[8] = I;
    list[9] = J;

    //for(int j = 0; j<list.length; j++){
      //System.out.println(list[j].getProbability());
    //}
    //System.out.println("");

    double maxProbability = list[0].getProbability();
    Distribution highestProbability = list[0];
    for(int j = 0; j<list.length; j++){
      if(list[j].getProbability() > maxProbability){
        maxProbability = list[j].getProbability();
        highestProbability = list[j];
      }
    }

    double reward = 0;
    double expectedReward = 0;
    
    //UCB
    
    for(int i = 1; i<10001; i++){
      double tempmax = -99;
      Distribution d = list[(int) (10*Math.random())];
      
      if(i<11){
        d = list[i-1];
      }
      else{
        ArrayList<Distribution> tempList = new ArrayList<Distribution>();
        for(int j = 0; j<list.length; j++){
          if(UCB(list[j], e, i) > tempmax){
            tempmax = UCB(list[j], e, i);
          }
        }
        for(int j = 0; j<list.length; j++){
          if(UCB(list[j], e, i) == tempmax){
            tempList.add(list[j]);
          }
        }
        d = tempList.get((int) (tempList.size() * Math.random()));
      }
      
      if(Math.random()<d.getProbability()){
        d.win();
        reward++;
        //System.out.println("win");
      }
      else{
        d.lose();
        //System.out.println("lose");
      }
      expectedReward += d.getProbability();
      averageRegret[i-1] = averageRegret[i-1] + highestProbability.getProbability() - (expectedReward/i);
    }
    
    for(Distribution d: list){
      d.reset();
    }
    expectedReward = 0;
    }

    for(int i = 0; i<10000; i++){
      averageRegret[i] /= 10000;
      System.out.println(averageRegret[i]);
    }
    //System.out.println(averageRegret[9999]);

    for(int i = 0; i<10000; i++){
      averageRegret[i] = 0;
    }
  System.out.println("");
}
  }
}
