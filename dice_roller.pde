//Left click to random face.
//Right click to roll the dice, then left to stop.

int diceSize = 117;
int start;
void setup() {

  size(diceSize* 2, diceSize*5);
  start = millis();

  
}

void draw() {
  background(#43936B);
  Dice (width/2 , diceSize *1 , #FFF3D6 , 50 );
  Dice (width/2 , diceSize *1 + 125 * 1 , #ff99cc ,  50 );
  Dice (width/2 , diceSize *2 + 135 * 1 , #99ccff ,  50 );
  Dice (width/2 , diceSize *3 + 145 * 1 , #99ff99 ,  50 );
  //FFF3D6 //pink red 
  //FFF3D6 // green
  //FFF3D6
  frameRate(0.1);
  
}


void Dice (int x ,  int y, color diceCol , color spotcol)
{
  //dice
  noStroke();
  fill(diceCol);
  rectMode(CENTER);
  rect(x, y, diceSize, diceSize, diceSize/5);

  //dots
  fill(spotcol);
  int side = int(random(1, 7));
  if (side == 1 || side == 3 || side == 5)
    ellipse(x, y, diceSize/5, diceSize/5); 
  if (side == 2 || side == 3 || side == 4 || side == 5 || side == 6) { 
    ellipse(x - diceSize/4, y - diceSize/4, diceSize/5, diceSize/5);
    ellipse(x + diceSize/4, y + diceSize/4, diceSize/5, diceSize/5);
  }
  if (side == 4 || side == 5 || side == 6) {
    ellipse(x - diceSize/4, y + diceSize/4, diceSize/5, diceSize/5);
    ellipse(x + diceSize/4, y - diceSize/4, diceSize/5, diceSize/5);
  }
  if (side == 6) {
    ellipse(x, y - diceSize/4, diceSize/5, diceSize/5);
    ellipse(x, y + diceSize/4, diceSize/5, diceSize/5);
  }

  //roll
  if (mousePressed && mouseButton == LEFT)
    noLoop();
}

//void mousePressed() {
//  loop();
//}

