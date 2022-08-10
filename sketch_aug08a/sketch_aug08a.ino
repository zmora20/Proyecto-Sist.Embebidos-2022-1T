#include <ESP32Servo.h> 

Servo myservo;  
Servo myservo1;  
int pinizq= 23;
int pindere=22;
int servo1=21;
int servo2=19;

void setup() {
  Serial.begin(9600);   //iniciar puerto serie
  pinMode(pinizq, INPUT);
  pinMode(pindere, INPUT);//definir pin como entrada
  myservo.attach(servo1);
  myservo1.attach(servo2);
}
 
void loop(){
  int lecturaSensorIzq= digitalRead(pinizq);
  int lecturaSensorDer=digitalRead(pindere);
   if (lecturaSensorIzq == 1 && lecturaSensorDer == 0)
  {
   MotorIzquierdo();
 
  }
    if (lecturaSensorIzq == 1 && lecturaSensorDer == 1)
  {
    MotorAvanza(); // El robot avanza
    Serial.println("robot avanza");
  }
  if (lecturaSensorIzq == 0 && lecturaSensorDer == 1)
  {
   Motorderecho();
 
  }
}

void MotorAvanza(){
  int n=0;
  while (n<180){
    myservo.write(n);
    myservo1.write(n);
    n+=10;
    delay(500);
    }
  }
  void Motorderecho(){
  int n=0;
  while (n<180){
    myservo.write(n);
    myservo1.write(0);
    n+=10;
    delay(500);
    }
  }
  void MotorIzquierdo(){
  int n=0;
  while (n<180){
    myservo.write(0);
    myservo1.write(n);
    n+=10;
    delay(500);
    }
  }
  void parar(){
    myservo.write(0);
    myservo1.write(0);
    }
