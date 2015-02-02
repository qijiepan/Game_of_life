Prey prey;

void setup() {
  size(400,400);
  frameRate(10);
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


