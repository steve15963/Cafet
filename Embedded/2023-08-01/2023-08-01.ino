#include <SoftwareSerial.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>
#include <ArduinoJson.h>

#include "WiFiEsp.h"

#define MAX_CIRCULAR_SIZE 2
#define BEACON_COUNT 4

SoftwareSerial BTSerial(2, 3);  // SoftwareSerial(RX, TX)
SoftwareSerial WFSerial(4, 5);

int searchFlag[BEACON_COUNT] = {0,};

DynamicJsonDocument doc(100);

char ssid[] = "MULTI_GUEST_2";            // your network SSID (name)
char pass[] = "guest1357";        // your network password
int status = WL_IDLE_STATUS;     // the Wifi radio's status

char server[] = "jsonplaceholder.typicode.com";

unsigned long lastConnectionTime = 0;         // last time you connected to the server, in milliseconds
const unsigned long postingInterval = 10000L;

// Initialize the Ethernet client object
WiFiEspClient client;

typedef struct{
  double x;
  double y;
  double radius;
} Anchor;

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
  // double offset[BEACON_COUNT] = {-53,-49,-49};
  double offset[BEACON_COUNT] = {-49,-49,-49};
  double n = 2.0;
  double constant = offset[index-1];
  double distance = pow(10, (constant - rssi) / (10 * n));
  return distance;
}

void printWifiStatus()
{
  // print the SSID of the network you're attached to
  Serial.print("SSID: ");
  Serial.println(WiFi.SSID());

  // print your WiFi shield's IP address
  IPAddress ip = WiFi.localIP();
  Serial.print("IP Address: ");
  Serial.println(ip);

  // print the received signal strength
  long rssi = WiFi.RSSI();
  Serial.print("Signal strength (RSSI):");
  Serial.print(rssi);
  Serial.println(" dBm");
}


void setup()

{

  Serial.begin(9600);
  BTSerial.begin(9600);
  
  WFSerial.begin(9600);
  WFSerial.listen();

  WiFi.init(&WFSerial);
  if (WiFi.status() == WL_NO_SHIELD) {
    Serial.println("WiFi shield not present");
    // don't continue
    while (true);
  }

  while ( status != WL_CONNECTED) {
    Serial.print("Attempting to connect to WPA SSID: ");
    Serial.println(ssid);
    // Connect to WPA/WPA2 network
    status = WiFi.begin(ssid, pass);
  }
  delay(500);

  

  for(int i = 0 ; i < BEACON_COUNT; i++){
    InitCircularArray(&Beacon[i]);
    setData(&Beacon[i],-50);
  }
  BTSerial.listen();
  BTSerial.println("AT+RESET");
  BTSerial.println("AT+DISI?");

  Serial.println("준비 완료!");
  
}

void loop() {
  int i = 0;
  // Serial.print("시작");
  while (BTSerial.available()) {  // if BT sends something
    String inputStr = BTSerial.readStringUntil('\n');
    // Serial.println(inputStr);
    char* response = inputStr.c_str();
    // Serial.println(data);

    char* token = strtok(response, ":");
 
    char* data[6];
    if(strcmp(token,"OK+DISIS\r") == 0){
      Serial.println("===============비콘 스캔 시작=============");
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
        // Serial.print("주소 : ");
        // Serial.println(data[2]);
        strncpy(storeNum, data[2]+16,8);
        // Serial.print("가게 번호 : ");
        // Serial.println(atoi(storeNum));
        strncpy(beaconNum,data[2]+24,8);
        Serial.print("비콘 번호 : ");
        int beaconIndex = atoi(beaconNum);
        Serial.println(beaconIndex);  
        // Serial.print("신호 세기 : ");

        int power = atoi(data[5]);
        // Serial.println(power);
        

        setData(&Beacon[beaconIndex], power);

        Serial.print("평균 신호 세기 :");
        int avgPower = getAvg(&Beacon[beaconIndex]);
        Serial.println(avgPower);

        // Serial.print("거리 : ");
        // Serial.println(calculateDistance(avgPower,beaconIndex));

        searchFlag[beaconIndex] = 1;
        Serial.println("-------------------------------------");

      }
    }
    else if(strcmp(token,"OK+DISCE\r") == 0){
      // delay(50);
      if(searchFlag[1] == 0 && searchFlag[2] == 0 && searchFlag[3] == 0){
          Serial.println("***********전송**********");
          WFSerial.listen();
          delay(10);
          String json  = "";
          client.stop();
          for(int i = 0; i < BEACON_COUNT; i++ ){
            searchFlag[i] = 0;
            int avgPower = getAvg(&Beacon[i]);
            doc["b" + i ] = calculateDistance(avgPower,i);
          }
          if (client.connect(server, 80)) {
            // printWifiStatus();
            Serial.println("커넥션 확보 성공");
            serializeJson(doc,json);
            Serial.println("Connecting...");
            
            // send the HTTP PUT request
            client.println("POST /api/Animal/Location HTTP/1.1");
            client.println("Host: jsonplaceholder.typicode.com");
            client.println("Accept: */*");
            client.println("Content-Length: " + json.length());
            client.println("Content-Type: application/x-www-form-urlencoded");
            client.println("Connection: close");
            client.println();
            client.println(json);
            Serial.println("***********전송 완료**********");
          }
          else {
            Serial.println("커넥션 확보 실패");
            Serial.println("***********전송 실패**********");
          }
          BTSerial.listen();
          delay(10);
        }
      Serial.println("================비콘 재검색=====================");
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