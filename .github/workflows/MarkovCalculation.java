
class Main {
  public static void main(String[] args) {
    double num = 0.063218498918347;
    for(int i = 1; i<10000000; i++){
      double p = i*num;
      double d = Math.abs(p - (int)(p+0.5));
      if(d<0.000001){
        System.out.println(i);
        System.out.println(p);
      }
    }
  }
}
