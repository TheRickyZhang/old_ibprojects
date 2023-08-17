import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Main {
  public static void main(String[] args) {
    int[][] board = new int[8][8];
    for(int i = 0; i<8; i++){
      for(int j = 0; j<8; j++){
        int num = 8*i+j+1;
        board[i][j] = num;
      }
    }
    for(int i = 0; i<8; i++){
      for(int j = 0; j<8; j++){
        //System.out.print(board[i][j] + " ");
      }
      //System.out.println("");
    }

    int total = 0;
    
    for(int k = 0; k<2000000; k++){
      ArrayList<Integer> squares = new ArrayList<>();
      for(int i = 1; i<=64; i++){
        squares.add(i);
      }
      squares.remove(squares.indexOf(64));

      ArrayList<Integer> cs = new ArrayList<>();
      for(int i = 0; i<16; i++){
        cs.add(squares.remove((int) (squares.size() * Math.random())));
      }
      
      for(int i = 1; i<=8; i++){
        if(i == 8){
          total += 7;
          break;
        }
        if(cs.indexOf(i)>=0){
        total += i;
          break;
        }
      }

      for(int i = 9; i<=15; i++){
        if(i == 15){
          total += 6;
          break;
        }
        if(cs.indexOf(i)>=0){
        total += i-8;
          break;
        }
      }

      for(int i = 17; i<=23; i++){
        if(i == 23){
          total += 6;
          break;
        }
        if(cs.indexOf(i)>=0){
        total += i-16;
          break;
        }
      }

      
      
      
    }
    System.out.println(total/2000000.0);
  }
}
