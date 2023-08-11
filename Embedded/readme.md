# Embeded

HM-10

BeconSetting

//설정 초기화

AT+RENEW

//가게 번호

AT+IBE0AAAAAAAA
AT+IBE1AAAAAAAA

//가게 번호
AT+IBE200000001

//동물 번호
AT+IBE300000001

//가게에서 사용하는 번호

AT+MARJ0xCAFE
AT+MINO0xCAFE

//비콘 신호 추기

AT+ADVI0

//비콘 이름
AT+NAMECafet1

//비콘 모드
AT+IBEA1

//비콘 전용 모드
AT+DELO2

//AutoSleep off
AT+PWRM1

//재부팅

AT+RESET

ScannerSetting

// 연결 수동화

// 이 명령어를 생략하고 아래 명령어 입력시

// AT+RENEW를 빠르게 입력하여 자동 연결을 캔슬함.

AT+IMME1

// 마스터 모드

AT+ROLE1

//iBEACONE scan

AT+DISI?

ESP-01

//모듈 초기화

AT+RESTORE

//아이피 셋팅

AT+CIPSTA="IP","GATEWAY","SUBNETMASK”

//아이피 셋팅 필요 없이 사용시

AT+CWDHCP=1,1

//AP 연결

AT+CWJAP="MyWiFi","MyPassword”

// 서버 커넥션 확보

AT+CIPSTART="TCP","43.201.102.130",8080

//데이터 사이즈

AT+CIPSEND=7

> 이후 원하는 데이터 입력

//서버 커넥션 종료

AT+CIFSR

//참고

[https://bcho.tistory.com/1284](https://bcho.tistory.com/1284)
