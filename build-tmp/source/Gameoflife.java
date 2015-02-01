import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Gameoflife extends PApplet {

Prey prey;

public void setup() {
  size(600,400);
  frameRate(1);
  prey = new Prey();
  }


public void draw() {
  //if(mousePressed){
  background(255);
    prey.generate();
    prey.display();
  //}
}

public void mousePressed(){
  prey.init();

}


class Prey{
  int[][] board;
  int w =10;
  int columns,rows;

  Prey(){
    columns = 500/w;
    rows =400/w;
  
    board = new int[columns+1][rows+1];
    init();
  }


  public void init(){

    for (int i =1; i< columns-1;i++){
      for(int j=1;j<rows-1;j++){
        double random =Math.random();
        if(random<=0.05f) board[i][j]=4;
        else if(random<0.2f) board[i][j]=0;
        else if(random<0.35f) board[i][j]=-1;
        else if(random<0.6f) board[i][j]=1;
        else if(random<1) board[i][j]=3;
        //board[i][j] = int(random(7)-2);//,-2,-1,0,1,2,3,4
      }
    }
  }

  public void generate(){

    int[][] next = new int[columns+1][rows+1];

    for(int x =0;x<columns;x++){
      for(int y =0;y<rows;y++){

        int neighbors = 0;
        int neighbors2 =0;
        int anti_neighbors =0;
        int anti_neighbors2 =0;
        int food =0;
        int food2 =0;
        int competitor =0;
        int competitor2 =0;
        int host=0;
        int a_prey =0;
        int a_predator =0;
        int i_prey =0;
        int i_predator=0;
        int sign =0;
        int sign2 =0;
        int sign3 =0;
        int sign4 =0;
        int e_infected =0;

        if((board[x][y]==0)||(board[x][y]==3)){//0 dead prey, 3 alive prey.
          for (int i = -1;i<=1;i++){
            for(int j = -1; j<=1;j++){
              if(board[(x+i+columns)%columns][(y+j+rows)%rows]==3){
                neighbors += 1;
                sign4=1;
              }
              if(board[(x+i+columns)%columns][(y+j+rows)%rows]==-2){
                neighbors ++;
              }
            }
          }
          if(sign4 == 1){
            neighbors--;
          }

          for (int k = -1;k<=1;k++){
            for (int l = -1; l <= 1;l++){
              if((board[(x+k+columns)%columns][(y+l+rows)%rows]==1)||(board[(x+k+columns)%columns][(y+l+rows)%rows]==2)){
                anti_neighbors +=1;
              }
            }
          }

            if(board[x][y]==3){
              for(int m =-1;m<=1;m++){
                for(int n =-1;n<=1;n++){
                  if((board[(x+m+columns)%columns][(y+n+rows)%rows]==4)||(board[(x+m+columns)%columns][(y+n+rows)%rows]==-2)){
                    i_prey=1;
                  }
                }
              }
            }
    }

        else if((board[x][y]==-1)||(board[x][y]==1)){// 1 alive predator -1 dead predator
          if(board[x][y]==1){
            for(int o =-1;o<=1;o++){
              for(int p =-1;p<=1;p++){
                if(board[(x+o+columns)%columns][(y+p+rows)%rows]==3){
                  food ++;
                }
                if(board[(x+o+columns)%columns][(y+p+rows)%rows]==-2){
                  food ++;
                  i_predator=1;
                }
              }
            }
          }
          if (board[x][y]==1){
            for (int q = -1;q<=1;q++){
              for (int r =-1;r<=1;r++){
                if(board[(x+q+columns)%columns][(y+r+rows)%rows]==1){
                  competitor++;
                  sign=1;
                }
                if(board[(x+q+columns)%columns][(y+r+rows)%rows]==2){
                  competitor++;
                  i_predator=1;
                }
                if(board[(x+q+columns)%columns][(y+r+rows)%rows]==4){
                  e_infected=1;
                }

              }
            }
            if(sign==1){
              competitor -=board[x][y];
            }
         }  
        }
        else if(board[x][y]==2){// 2 infected alive predator
          for (int s = -1;s<=1;s++){
            for (int t =-1;t<=1;t++){
              if(board[(x+s+columns)%columns][(y+t+rows)%rows]==1){
                competitor2 +=1;
              }
              if(board[(x+s+columns)%columns][(y+t+rows)%rows]==2){
                competitor2 +=1;
                sign2=1;
              }
            }
          }
          if(sign2==1){
            competitor2--;
          }
        

          for (int u = -1;u<=1;u++){
            for(int v= -1;v<=1;v++){
              if((board[(x+u+columns)%columns][(y+v+rows)%rows]==3)||(board[(x+u+columns)%columns][(y+v+rows)%rows]==-2)){
                food2++;
              }
            }
          }
    }

    else if(board[x][y]==-2){// -2 infected alive prey
      for(int i1=-1;i1<=1;i1++){
        for(int j1=-1;j1<=1;j1++){
          if(board[(x+i1+columns)%columns][(y+j1+rows)%rows]==3){
            neighbors2++;
          }
          if(board[(x+i1+columns)%columns][(y+j1+rows)%rows]==-2){
            neighbors2++;
            sign3=1;
          }
        }
      }
      if(sign3==1){
        neighbors2--;
      }

      for(int k1=-1;k1<=1;k1++){
        for(int l1=-1;l1<=1;l1++){
          if((board[(x+k1+columns)%columns][(y+l1+rows)%rows]==1)||(board[(x+k1+columns)%columns][(y+l1+rows)%rows]==2)){
            anti_neighbors2++;
          }
        }
      }
    }

           
        else if(board[x][y]==4){ // 4 disease
          for(int m1=-1;m1<=1;m1++){
            for(int n1=-1;n1<=1;n1++){
              if((board[(x+m1+columns)%columns][(y+n1+rows)%rows]==1)||(board[(x+m1+columns)%columns][(y+n1+rows)%rows]==-2)||(board[(x+m1+columns)%columns][(y+n1+rows)%rows]==3)){
                host++;
              }
            }
          }
        }
        if ((board[x][y] == 3) && (neighbors<  2)) next[x][y] = 0;           // Loneliness(alive prey bcome dead prey)
            else if ((board[x][y] == 3) && (neighbors >  3)) next[x][y] = 0;        // Overpopulation
            else if ((board[x][y] == 0) && (neighbors == 3)) next[x][y] = 3;           // Reproduction
            else if ((board[x][y] == 3) && (anti_neighbors >= 1)) next[x][y]=0;       // Be eaten
            else if ((board[x][y] == 3) && (i_prey == 1)) next[x][y] = -2;        // prey be infected
            else if ((board[x][y] == 1) && (food > competitor)) next[x][y] =1;       // eat prey
            else if ((board[x][y] == 1) && (food <= competitor)) next[x][y] =-1;       // hungury to death
            else if ((board[x][y] == 1) && (e_infected ==1)) next[x][y] =2;        // eat the infected prey
            else if ((board[x][y] == -1) && (competitor==2)) /*&& (food >2))*/ next[x][y]=1;  // born when parents have enough food
            else if ((board[x][y] == -2) && (neighbors2 >2)) next[x][y] =0;      // Overporpulation;
            else if ((board[x][y] == -2) && (anti_neighbors2>=1)) next[x][y]=0;    // Be eaten;
            else if ((board[x][y] == -2) && (neighbors2 <2)) next[x][y]=0;      //Loneliness
            else if ((board[x][y] == 2) && (food2>2*competitor2)) next[x][y]=2;    // infected predator eat prey
            else if ((board[x][y] == 2) && (food2<= 2*competitor2)) next[x][y]=-1;  // hungury to death
            else if ((board[x][y] == 4) && (host == 0)) next[x][y] =0;        // disease died because of no host
            else                                            next[x][y] = board[x][y];  // Stasis  
        
      }
      
    }board = next;

  }
  public void display(){
    for(int i =0; i<columns;i++){
      for(int j =0; j<rows;j++){
        if((board[i][j] == 1)) fill(0,0,255); //alive predator
        else if(board[i][j] == 4) fill(255,0,0); //disease
        else if(board[i][j] == 3) fill(0,255,0); //alive prey
        else if(board[i][j] == 2) fill(255,0,255); //infected predator
        else if(board[i][j] == -2) fill(255,255,0); //infected prey
        else fill(255);
        stroke(0);
        rect(i*w,j*w,w,w);
      }
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Gameoflife" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
