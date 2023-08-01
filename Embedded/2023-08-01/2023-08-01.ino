#include <SoftwareSerial.h>
#include <string.h>



SoftwareSerial BTSerial(2, 3);  // SoftwareSerial(RX, TX)



void setup()

{

  Serial.begin(9600);

  Serial.println("Hello!");



  // set the data rate for the BT port

  BTSerial.begin(9600);
  
}

void loop() {

  

  while (BTSerial.available()) {  // if BT sends something
    String inputStr = BTSerial.readStringUntil('\n');
    // Serial.println(inputStr);
    char* data = inputStr.c_str();
    // Serial.println(data);
    char* response = strspn(data,":");
    char* adasf = strspn(NULL,":");
    char* uuid = strspn(NULL,":");
    char* marjo =strspn(NULL,":");
    char* mac = strspn(NULL,":");
    char* rssi = strspn(NULL,":");

    Serial.println(response);
    // byte data = BTSerial.read();
  
    // Serial.write(data);  // write it to serial(serial monitor)
  }



  while (Serial.available()) {  // if Serial has input(from serial monitor)

    byte data = Serial.read();

    BTSerial.write(data);  // write it to BT
  }
}
