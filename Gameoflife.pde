Prey prey;
int[] array_test = new int[4];
int[] p_predator =new int[2];
int[] p_prey =new int[2];
int[] p_ipredator = new int[2];
int[] p_iprey =new int[2];
int i =0;

void setup() {
  size(1000,400);
  frameRate(1);
  prey = new Prey();
  }


void draw() {
  //if(mousePressed){
  //background(255);
    prey.generate();
    array_test=prey.generate();
    line(600, 50, 600, 350);
    line(600,350,950,350);
    textSize(10);
    fill(0, 102, 153);
    text("100", 590, 50);
    text("80", 590, 110);
    text("60", 590, 170);
    text("40", 590, 230);
    text("20", 590, 290);
    text("0", 590, 350);
    p_predator[1]=(int)(array_test[0]*(-3)+350);
    p_predator[0]=610+i;
    p_ipredator[1]=(int)(array_test[1]*(-3)+350);
    p_ipredator[0]=610+i;
    p_prey[1]=(int)(array_test[2]*(-3)+350);
    p_prey[0]=610+i;
    p_iprey[1]=(int)(array_test[3]*(-3)+350);
    p_iprey[0]=610+i;
    i +=10;
    
    fill(0, 0, 255);
    rect(p_predator[0],p_predator[1],4,4);
    strokeWeight(3);
    stroke(255, 0, 255);
    point(p_ipredator[0],p_ipredator[1]);
    strokeWeight(1);
    fill(0, 255, 0);
    ellipse(p_prey[0],p_prey[1],4,4);
    strokeWeight(3);
    stroke(255, 0, 255);
    point(p_iprey[0],p_prey[1]);

    //line(temp1[0], temp1[1], p_predator[0], p_predator[1]);
    //temp1 = p_predator;
    strokeWeight(1);
    prey.display();
  //}
}

void mousePressed(){
  prey.init();
  background(255);
  i=0;

}


