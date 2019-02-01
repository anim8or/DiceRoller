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

public class dice_roller extends PApplet {

//Left click to random face.
//Right click to roll the dice, then left to stop.

int diceSize = 117;
int start;
public void setup() {

  size(diceSize* 2, diceSize*5);
  start = millis();

  
}

public void draw() {
  background(0xff43936B);
  Dice (width/2 , diceSize *1 , 0xffFFF3D6 , 50 );
  Dice (width/2 , diceSize *1 + 125 * 1 , 0xffff99cc ,  50 );
  Dice (width/2 , diceSize *2 + 135 * 1 , 0xff99ccff ,  50 );
  Dice (width/2 , diceSize *3 + 145 * 1 , 0xff99ff99 ,  50 );
  //FFF3D6 //pink red 
  //FFF3D6 // green
  //FFF3D6
  frameRate(0.1f);
  
}


public void Dice (int x ,  int y, int diceCol , int spotcol)
{
  //dice
  noStroke();
  fill(diceCol);
  rectMode(CENTER);
  rect(x, y, diceSize, diceSize, diceSize/5);

  //dots
  fill(spotcol);
  int side = PApplet.parseInt(random(1, 7));
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

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "dice_roller" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
