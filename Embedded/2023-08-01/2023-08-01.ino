#include <SoftwareSerial.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>



SoftwareSerial BTSerial(2, 3);  // SoftwareSerial(RX, TX)


float calculateDistance(int rssi) {
  float n = 2.0;
  float constant = -62;
  float distance = pow(10, (constant - rssi) / (10 * n));
  return distance;
}

void setup()

{

  Serial.begin(9600);

  Serial.println("Hello!");



  // set the data rate for the BT port

  BTSerial.begin(9600);
  
}

void loop() {
  int i = 0;
  

  while (BTSerial.available()) {  // if BT sends something
    String inputStr = BTSerial.readStringUntil('\n');
    // Serial.println(inputStr);
    char* response = inputStr.c_str();
    // Serial.println(data);

    char* token = strtok(response, ":");
 
    char* data[6];
    if(strcmp(token,"OK+DISIS\r") == 0){
      Serial.println("스캔 시작");
    }
    else if(strcmp(token,"OK+DISC") == 0){
      while (token != NULL) {
          data[i++] = token;
          token = strtok(NULL, ":");
      }
      i = 0;
      char mark[17] = {0,};
      char storeNum[9] = {0,};
      char beaconNum[9] = {0,};
      strncpy(mark,data[2],16);
      if(strcmp(mark,"AAAAAAAAAAAAAAAA") == 0){
        Serial.print("주소 : ");
        Serial.println(data[2]);
        strncpy(storeNum, data[2]+16,8);
        Serial.print("가게 번호 : ");
        Serial.println(atoi(storeNum));
        strncpy(beaconNum,data[2]+24,8);
        Serial.print("비콘 번호 : ");
        Serial.println(atoi(beaconNum));      
        Serial.print("신호 세기 : ");
        Serial.println(atoi(data[5]));
        Serial.print("거리 : ");
        Serial.println(calculateDistance(atoi(data[5])));
      }
    }
    else if(strcmp(token,"OK+DISCE\r") == 0){
      Serial.println("재검색");
      BTSerial.println("AT+DISI?");
    }
    else{
      Serial.print("예외 발생 :");
      Serial.println(response);
      i = 0;
      BTSerial.println("AT+RESET");
      BTSerial.println("AT+DISI?");
    }
  }



  while (Serial.available()) {  // if Serial has input(from serial monitor)

    byte data = Serial.read();

    BTSerial.write(data);  // write it to BT
  }
}

