#include <SoftwareSerial.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

#define MAX_CIRCULAR_SIZE 5
#define BEACON_COUNT 4



SoftwareSerial BTSerial(2, 3);  // SoftwareSerial(RX, TX)


typedef struct {
    int insertIndex;
    int data[MAX_CIRCULAR_SIZE];
} CircularArray;

void InitCircularArray(CircularArray *target){
  target->insertIndex = 0;
}

double getAvg(CircularArray *target){
  int sum = 0;
  for(int i = 0 ; i < MAX_CIRCULAR_SIZE;i++){
    sum += target->data[i];
  }
  return sum / MAX_CIRCULAR_SIZE;
}
void setData(CircularArray *target,int data){
  target->data[target->insertIndex] = data;
  target->insertIndex = (target->insertIndex+1) % MAX_CIRCULAR_SIZE;
}

CircularArray Beacon[BEACON_COUNT];

double calculateDistance(int rssi,int index) {
  double offset[BEACON_COUNT] = {-53,-49,-49};
  double n = 2.0;
  double constant = offset[index-1];
  double distance = pow(10, (constant - rssi) / (10 * n));
  return distance;
}

void setup()

{

  Serial.begin(9600);

  Serial.println("Hello!");



  // set the data rate for the BT port

  BTSerial.begin(9600);

  for(int i = 0 ; i < BEACON_COUNT; i++){
    InitCircularArray(&Beacon[i]);
  }
  
}

void loop() {
  int i = 0;

  
  int searchFlag[BEACON_COUNT] = {0,};

  while (BTSerial.available()) {  // if BT sends something
    String inputStr = BTSerial.readStringUntil('\n');
    //Serial.println(inputStr);
    char* response = inputStr.c_str();
    // Serial.println(data);

    char* token = strtok(response, ":");
 
    char* data[6];
    if(strcmp(token,"OK+DISIS\r") == 0){
      Serial.println("===============스캔 시작=============");
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
        int beaconIndex = atoi(beaconNum);
        Serial.println(beaconIndex);  
        Serial.print("신호 세기 : ");

        int power = atoi(data[5]);
        Serial.println(power);
        

        setData(&Beacon[beaconIndex], power);

        Serial.print("평균 신호 세기 :");
        int avgPower = getAvg(&Beacon[beaconIndex]);
        Serial.println(avgPower);

        Serial.print("거리 : ");
        Serial.println(calculateDistance(avgPower,beaconIndex));

        searchFlag[beaconIndex] = 1;

        if(searchFlag[1] == 1 && searchFlag[2] == 1 && searchFlag[3] == 1){
          searchFlag[1] = searchFlag[2] = searchFlag[3] = 0;
          Serial.println("위치계산 시작");

        }

        Serial.println("-------------------------------------");

      }
    }
    else if(strcmp(token,"OK+DISCE\r") == 0){
      Serial.println("================재검색=====================");
      BTSerial.println("AT+DISI?");
    }
    else{
      Serial.print("예외 발생 :");
      Serial.println(response);
      i = 0;
      BTSerial.println("AT+RESET\r");
      BTSerial.println("AT+DISI?\r");
    }
  }



  while (Serial.available()) {  // if Serial has input(from serial monitor)

    byte data = Serial.read();

    BTSerial.write(data);  // write it to BT
  }
}