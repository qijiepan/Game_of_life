Prey prey;

void setup() {
  size(600,400);
  frameRate(1);
  prey = new Prey();
  }


void draw() {
  //if(mousePressed){
  background(255);
    prey.generate();
    prey.display();
  //}
}

void mousePressed(){
  prey.init();

}


