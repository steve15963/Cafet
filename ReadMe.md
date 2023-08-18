# Homo SSAFY-ens : PET-MAN

---

---

## 🔷 프로젝트 소개

### ✔ 작성 정보

- 작성자 : 서울 1반 A105
- 날짜 : 2023.07.03 ~ 2023.08.18 (총 7주)

### 👥 팀원 소개

| 멤버 | 역할 | 담당 |
| --- | --- | --- |
| 👑 송진현😭 | Back IoT PM Infra Web  |  CI/CD 구현, SSL인증서 적용, 외부 API 연동, IOT 회로 설계, IOT 펌웨어 개발, 팀원 관리, 개발 총괄, 팀원 소통 및 스크럼 진행 |
| 🦘 이제원 | Back Web  | web 커뮤니티 기능 개발 - 유저, 게시글 사진, 유저 사진, 가게, 방문기록, 가게 평점, 가게 동물 정보, 키오스크(주문정보) |
| 🐻 박동건 | Back Web | web 커뮤니티 기능 개발 - 게시글, 댓글, 좋아요, 태그 기능 / 예외처리, 코드 리팩토링 |
| 🚀 김재석 | Front Web | web 게시글, 카페 개별 페이지, 마이페이지, 지도API 호출 및 지도에서 찾기 기능  |
| ⚛ 박동휘 | Front IoT Web | IOT 회로 설계, 프론트 팀장, web 로그인, 회원가입, 게시글 상세, 개인정보 관리 UI 및 기능 구현  |
| 🗡 신재혁🎲 | Front Back | web 메인,관리자 페이지, 비콘 정보를 기반 위치 정보 계산 및 CRUD, UCC제작 |

### 프로젝트 구분

| Application | Domain | Language | Framework |
| --- | --- | --- | --- |
| ✅ Desktop Web | ⬜ AI | ✅ JavaScript | ⬜ Vue.js |
| ⬜ Mobile Web | ⬜ Big Data | ⬜ TypeScript | ✅ React |
| ✅ Responsive Web | ⬜ Blockchain | ⬜ C/C++ | ⬜ Angular |
| ⬜ Android App | ✅ Responsive Web | ⬜ C# | ✅ Node.js |
| ⬜ iOS App | ⬜ AR/VR/Metaverse | ⬜ Python | ⬜ Flask/Django |
| ⬜ Desktop App | ⬜ Game | ✅ Java | ✅ Spring/Springboot |
|  |  | ⬜ Kotlin |  |
|  |  |  |  |

### ✔ 목표

> 전국 애견카페 커뮤니티
> 

## 프로젝트 관리

### 📅 프로젝트 진행 일정

| 일자 | Front | Back | IOT |
| --- | --- | --- | --- |
| 2023-07-10(월) | Jira 생성, 기능명세서 작성 | Jira 생성, 기능명세서 작성 | - |
| 2023-07-11(화) | 메뉴 구조도 작성 | 스프린트1 ERD 완성, api 명세서 작업 시작 | - |
| 2023-07-12(수) | 로그인 회원 마이페이지 관리자페이지 UI 프로토타입 작성 | api 명세서 작성 완료, 파일구조 정리, | - |
| 2023-07-13(목) | 메인페이지 게시판 UI 프로토타입 작성,  | API명세서 추가 작성, ERD 보충, 백 코딩 시작, | - |
| 2023-07-14(금) | UI기능 정리 및 리액트 설정 세팅 | User, Board, BusinessNumber DTO Service Repository 작성 | - |
| 2023-07-17(월) | 메뉴구조도 수정 및 가게 개별 게시판 UI, 문의하기 UI 작성 | 스프린트 설정, Board CRUD API 개발, User CRUD API 개발 | IOT 모듈 정상 작동 여부 점검 |
| 2023-07-18(화) | 2차 메뉴구조도 작성 및 2차 UI구조 수정 및 페이지 설명 첨삭, 리액트 테스트 코드 작성 | Comment CRUD API 개발, Board - Comment 테이블 매핑, Shop CRUD API 개발 | 음성 녹음 모듈 정상 작동 여부 점검 |
| 2023-07-19(수) | Header, Footer 컴포넌트 구현 및 컴포넌트 구조 분리(pages 구현) | JPA Annotation 학습, Grade테이블 별점 시스템 설계 | - |
| 2023-07-20(목) | Header, Footer, button css 작성 및 컴포넌트 구조 변경 | Board - Comment Dto 설계 개선 평점, 방문기록 시스템 설계 | - |
| 2023-07-21(금) | 스프린트 회고, Sidebar 컴포넌트 구현 | 스프린트 회고, 코드 리뷰 후 merge |  |
| 2023-07-24(월) | mainpage, 게시글 페이지, 게시글 상세 페이지 구조 구현 | Board - 검색 기능 추가, Shop, User, Visited, Grade → 시간 추가 |  |
| 2023-07-25(화) | mainpage, 게시글 전체 페이지, 게시글 상세 페이지 css 적용 | Board - 태그 기능, 조회수 카운트 기능 추가, Shop Refactor |  |
| 2023-07-26(수) | Mainpage, 게시판 기능 일부 구현 | Board/Comment와 - User 연결, board 카테고리 추가
User- 마이페이지 사진 업로드 |  |
| 2023-07-27(목) | Mainpage, 게시판, 게시글 상세 기능 구현 | Board - User / Shop과 연결, 프론트 측과 함께 API 테스트 완료 |  |
| 2023-07-28(금) | 페이지 별 path 수정 및 문의하기, css 일부 통합 | 중간 발표 준비 |  |
| 2023-07-31(월) | 마이페이지 기능 구현, 로그인 및 회원관리 UI 만들기 | web 코드 리팩토링, api docs 최신화, 유저 파일 업로드 수정, 회원가입시 메일 인증 서비스 추가 |  |
| 2023-08-01(화) | 이메일 인증, 게시판 탭 구현, 페이지네이션 적용, 관리자 페이지 테이블 구별 | 게시글, 댓글 리팩토링, 게시글 파일 업로드 기능 추가, 메일부분 api 수정 및 추가, swagger 의존성 추가, 유저와 게시글 사진 및 파일 추가 수정 |  |
| 2023-08-02(수) | 게시판 기능 추가, 회원정보 수정 기능. 관리자 회원정보 관련 기능 구현 및 master merge | 게시글 리팩토링(for loop), 좋아요 api 제작 |  |
| 2023-08-03(목) | 리팩토링 | 게시글 좋아요 기능 개발, dto 리팩토링, 위치정보 api 추가,  |  |
| 2023-08-04(금) | 프로필 이미지 업로드 구현, 관리자 페이지 목록 리스트구현,  | ERD 수정(위치정보 저장), 게시글, 가게, 유저 API 추가, IOT장비 JSON전송체크, Arduino 메모리 최적화 |  |
| 2023-08-07(월) | 지도 검색 기능 구현, 관리자페이지 구현, 댓글 구현 | 가게 태그로 검색 기능 생성,  센서 ERD추가, 센서 Entity 및 Repositoy추가 |  |
| 2023-08-08(화) | 지도 검색 API 가져오기, 검색 결과 목록 출력 | 키오스크 초기 작업, 키오스크 ERD 작업, 사용자 비밀번호 변경 API 생성, 태그 부착 버그 픽스  |  |
| 2023-08-09(수) | accesstoken과 refreshtoken을 통한 권한 별 헤더 구현, 사이드 바 수정, 마이페이지 상 게시글, 댓글 불러오기 기능 구현 | 예외처리 구조 생성, API 버그 FIX, 손님 기준 음료 등 주문(키오스크), 주문을 주인이 받는 요청(키오스크), Arduino Esp-01을 이용한 Socket오픈 및 RFC7230 규약 준수 및 POST요청 성공, Arduino Post요청 Controller 수신 성공 확인 |  |
| 2023-08-10(목) | 토큰관련 일부 기능 수정, 마이페이지 api 연결, 지도 검색 기능 구현, 에디터 구현 | 예외처리 package 생성, 게시판 예외처리, 게시글 댓글 목록 API 수정 |  |
| 2023-08-11(금) | 키오스크 프론트 레이아웃, API 받아오기 | 게시판 썸네일 저장기능 추가, 백엔드 WEB API 예외처리 완료 |  |
| 2023-08-14(월) | 키오스크 기능 구현(로그인, 샵, 주문) | 게시글 내용 정규표현식 적용 포매팅 기능 추가, 키오스크 관련 기능 구현(로그인, 샵, 주문) |  |
| 2023-08-16(수) | IoT 데이터 받아와서 히트맵으로 띄우기 | 문의기능 생성, Kiosk WebSocket 가게마다 구별하기 |  |
| 2023-08-17(목) | 프론트 CSS 수정, 발표자료 준비 | 발표자료 준비, Mock Data 입력, Kiosk Websocket 메뉴 주문 저장 |  |

## 개발 규칙(필요시 추가)

### GIT

- git을 이용한 협업시 각자의 작업물은 각자의 개인 branch에 push하고, 기능이 완성되면 master branch에 합친다(팀장 포함).
- 각자 기능 개발 후 git에 `add-commit-push`하기 전, 각자의 작업영역을 사전에 공유한다.
- 커밋 메시지 양식은 다음과 같이 통일한다.
    
    
    | Tag Name | Description |
    | --- | --- |
    | Feat | 새로운 기능을 추가 |
    | Fix | 버그 수정 |
    | Design | css 등 사용자 UI 디자인 변경 |
    | !HOTFIX | 급하게 치명적인 버그를 고쳐야하는 경우 |
    | Style | 코드 포멧 변경, 세미 콜론 누락, 코드 수정이 없는 경우 |
    | Comment | 필요한 주석 추가 및 변경 |
    | Docs | 문서 수정 |
    | Rename | 파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우 |
    | Remove | 파일을 삭제하는 작업만 수행한 경우 |
    | Update | 파일 수정 |
    | Refactor | 프로덕션 코드 리팩토링 |

```java
ex) 
Feat : 유저 파트
유저 회원가입 추가
```

### Coding Convensions

- 다중의 객체를 반환하는 메소드는 `-List`로 끝낸다.
- REST API 설계시 제목은 `(method type) + (domain name) + (action)` 으로 한다.
- 줄임말은 되도록 피한다.
- Java에서 모든 변수는 camelCase로, SQL에서는 snake_case로 쓴다.
- `HttpStatus`를 사용하는 경우 다음과 같은 규칙을 따른다.
    
    
    | Status Code | Name | Use case |
    | --- | --- | --- |
    | 200 | OK | 성공한 GET, PUT 요청 |
    | 201 | Created | 성공한 POST 요청 |
    | 204 | No Content | 성공한 DELETE 요청 |
    | 400 | Bad Request | 유효하지 않은 컨텐츠: 요청 실패 |
- 생성자 주입 방식으로 작성한다.
- 인스턴스 삭제 시 서비스 상 복구가 필요한 경우에 따라 soft-delete 방식을 채택한다.
    - `DELETE`요청을 통해 상태 변수를 삭제/생성 상태를 전환한다.
- Service, Repository 영역에서 단일 객체를 반환하는 메소드의 경우 `Optional`을 사용해 null 반환에 대응한다.

## 📂 프로젝트 폴더 구조

### Back-End

```markdown
📦backend
 ┣ 📂src
 ┃ ┣ 📂main
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┗ 📂xxx
 ┃ ┃ ┃ ┃ ┗ 📂petmanbe
 ┃ ┃ ┃ ┃ ┃ ┣ 📂address
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AddressController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Address.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AddressRepository.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂board
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BoardController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AddBoardRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AddCategoryRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LikeRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UpdateBoardRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardListResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BoardResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Board.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Category.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LikeBoard.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CategoryRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LikeBoardRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BoardServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂boardfile
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BoardFileController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂responseDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BoardFileDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardFile.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BoardOnlyFile.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardFileRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BoardOnlyFileRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardFileService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BoardFileServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂BusinessNumber
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BusinessNumberController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂DTO
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Detail
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RequestBusinessNumberBodyDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RequestBusinessNumberDetailDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Nomal
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RequestBusinessNumberDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜detailRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜simpleRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂Response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂detail
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ResponseBusinessNumberStatusDetailDataDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ResponseBusinessNumberStatusDetailDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂nomal
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ResponseBusinessNumberStatusDataDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ResponseBusinessNumberStatusDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BusinessNumberRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BusinessNumberRepositoryImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂Service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BusinessNumberService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BusinessNumberServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CheckBusinessNumberService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CheckBusinessNumberServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂comment
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CommentController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AddCommentRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UpdateCommentRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CommentResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Comment.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CommentRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CommentServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂common
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SwaggerConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BaseTimeEntity.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂errorcode
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommonErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FileErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GradeErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InquiryErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KioskErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PetErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ShopErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TagErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜VisitErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ErrorResponse.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GlobalExceptionHandler.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RestApiException.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂inquiry
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜InquiryController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AddInquiryRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InquiryListResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜InquiryResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Inquiry.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜InquiryCategory.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InquiryCategoryRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜InquiryRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InquiryService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜InquiryServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂Kiosk
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂desk
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DeskController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂responseDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PostDeskDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PostFirstDeskDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PutTableDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂resquestDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GetDeskDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Desk.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DeskRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DeskService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DeskServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂menu
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MenuController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂other
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GetMenuPriceSizeDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostMenuPriceSizeDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂requestDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostMenuDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂responseDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GetMenuDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Menu.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MenuPriceSize.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MenuPriceSizeRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MenuRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MenuService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MenuServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂menufile
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MenuFile.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MenuFileRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MenuFileService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MenuFileServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂webSocket
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MessageController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RoomController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂requestDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜OrderRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂responseDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GetMessagesDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜OrderResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MessageDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ChatRoom.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ChatRoomMessage.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Order.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ChatRoomMessageRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ChatRoomRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebSocketRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜WebSocketService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebSocketServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂WebSocketConfig
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebSocketConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Configurationtest.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂KioskLogin
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜KioskLoginController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂responseDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜KioskLoginReturnDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KioskService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜KioskServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂Location
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LocationController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂requestDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AddPetLocationRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜HitMapRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂responseDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜HitMapResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PetLocationResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂VO
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Point.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BeaconLocation.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PetLocation.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UseBeaconForPetLocation.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BeaconLocationRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PetLocationRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜useBeaconForPetLocationRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜HitMapService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜HitMapServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LocationService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LocationServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂mail
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MailController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂DTO
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂requestDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KeyCheckRegistDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MailCheckRegistDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MailDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RegistMail.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MailRegistRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MailService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂shop
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShopController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂others
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JsonResponse.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Position.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂requestDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DeleteShopGradeDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GetShopGradeDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LikeShopRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PostNewShopDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PostShopGradeDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PutShopDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PutShopGradeDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂responseDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GetShopDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GetShopListDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GetShopUserGradeDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Grade.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LikeShop.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Shop.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GradeRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LikeShopRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShopRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GradeService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GradeServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ShopService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShopServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂shopFile
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShopFileController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PostShopFileDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShopFileDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShopFile.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShopFileRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ShopFileService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShopFileServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂shopPet
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShopPetController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PostShopPetDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PutShopPetDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GetShopPetDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShopPet.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShopPetRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ShopPetService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShopPetServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂shopPetFile
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShopPetFileDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShopPetFile.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShopPetFileRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ShopPetFileService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShopPetFileServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂tag
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TagController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TagListResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttachBoard.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttachShop.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Tag.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttachBoardRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttachShopRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TagRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TagService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TagServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂user
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtAuthenticationFilter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SercurityConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂other
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LoginReturnDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂requestDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LevelModifyDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ModifyDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RefreshTokenDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RegistDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UpdateUserPasswordDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserModifyDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂responseDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RefreshJwtDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserFilesListDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserInformationDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserListDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Level.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Role.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Token.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜User.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LevelRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TokenRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CustomUserDetailService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtUtil.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂userfile
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜S3Config.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserFile.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserFileRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FileService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FileServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜S3Uploader.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MultipartJackson2HttpMessageConverter.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂visited
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜VisitedController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂reponseDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DeleteVisitedDateDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostVisitedDateDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂responseDto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DeleteVisitedDateDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GetVisitedDateDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostVisitedDateDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Visited.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜VisitedRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜VisitedService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜VisitedServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜PetManBeApplication.java
 ┃ ┃ ┗ 📂resources
 ┃ ┃ ┃ ┗ 📜application.yaml
 ┣ 📜.gitignore
 ┣ 📜build.gradle
 ┣ 📜Dockerfile
 ┣ 📜gradlew
 ┣ 📜gradlew.bat
 ┗ 📜settings.gradle
```

### Front-End

```markdown
📦src
 ┣ 📂components
 ┃ ┣ 📂AccountData
 ┃ ┃ ┗ 📜AccountData.js
 ┃ ┣ 📂AccountModify
 ┃ ┃ ┣ 📜AccountModify.js
 ┃ ┃ ┗ 📜AccountModify.scoped.css
 ┃ ┣ 📂Button
 ┃ ┃ ┣ 📜Button.js
 ┃ ┃ ┗ 📜Button.scoped.css
 ┃ ┣ 📂Comment
 ┃ ┃ ┣ 📜Comment.js
 ┃ ┃ ┗ 📜Comment.scoped.css
 ┃ ┣ 📂CommentList
 ┃ ┃ ┣ 📜CommentList.js
 ┃ ┃ ┗ 📜CommentList.scoped.css
 ┃ ┣ 📂ContentCard
 ┃ ┃ ┣ 📜ContentCard.js
 ┃ ┃ ┗ 📜ContentCard.scoped.css
 ┃ ┣ 📂Editor
 ┃ ┃ ┣ 📜Editor.js
 ┃ ┃ ┗ 📜Editor.scoped.css
 ┃ ┣ 📂EmailCheckForm
 ┃ ┃ ┣ 📜EmailCheckForm.js
 ┃ ┃ ┗ 📜EmailCheckForm.scoped.css
 ┃ ┣ 📂Footer
 ┃ ┃ ┣ 📜Footer.js
 ┃ ┃ ┗ 📜Footer.scoped.css
 ┃ ┣ 📂Header
 ┃ ┃ ┣ 📜Header.js
 ┃ ┃ ┣ 📜Header.scoped.css
 ┃ ┃ ┣ 📜HeaderDefaultMenu.js
 ┃ ┃ ┣ 📜HeaderManagerMenu.js
 ┃ ┃ ┣ 📜HeaderShopMenu.js
 ┃ ┃ ┗ 📜HeaderUserMenu.js
 ┃ ┣ 📂InquiryForm
 ┃ ┃ ┣ 📜InquiryForm.js
 ┃ ┃ ┗ 📜InquiryForm.scoped.css
 ┃ ┣ 📂KakaoMap
 ┃ ┃ ┗ 📜KakaoMap.js
 ┃ ┣ 📂KioskAnimalListItem
 ┃ ┃ ┣ 📜KioskAnimalListItem.js
 ┃ ┃ ┗ 📜KioskAnimalListItem.scoped.css
 ┃ ┣ 📂KioskButton
 ┃ ┃ ┣ 📜KioskButton.js
 ┃ ┃ ┗ 📜KioskButton.scoped.css
 ┃ ┣ 📂KioskHeatmap
 ┃ ┃ ┣ 📜image (5).png
 ┃ ┃ ┣ 📜KioskHeatmap.js
 ┃ ┃ ┗ 📜KioskHeatmap.scoped.css
 ┃ ┣ 📂KioskLogin
 ┃ ┃ ┣ 📜KioskLogin.js
 ┃ ┃ ┗ 📜KioskLogin.scoped.css
 ┃ ┣ 📂KioskMenu
 ┃ ┃ ┗ 📜KioskMenu.js
 ┃ ┣ 📂KioskNameList
 ┃ ┃ ┣ 📜KioskNameList.js
 ┃ ┃ ┗ 📜KioskNameList.scoped.css
 ┃ ┣ 📂KioskRegist
 ┃ ┃ ┗ 📜KioskRegist.js
 ┃ ┣ 📂LoginForm
 ┃ ┃ ┣ 📜LoginForm.js
 ┃ ┃ ┗ 📜LoginForm.scoped.css
 ┃ ┣ 📂MainList
 ┃ ┃ ┣ 📜MainList.js
 ┃ ┃ ┗ 📜MainList.scoped.css
 ┃ ┣ 📂Manage
 ┃ ┃ ┣ 📜ManageInquiry.js
 ┃ ┃ ┣ 📜ManageInquiryDetail.js
 ┃ ┃ ┣ 📜ManageInquiryDetail.scoped.css
 ┃ ┃ ┣ 📜ManageInquiryList.js
 ┃ ┃ ┣ 📜ManageShops.js
 ┃ ┃ ┣ 📜ManageShopTable.js
 ┃ ┃ ┣ 📜ManageUsers.js
 ┃ ┃ ┗ 📜ManageUserTable.js
 ┃ ┣ 📂Menu
 ┃ ┃ ┣ 📜Menu.js
 ┃ ┃ ┗ 📜Menu.scoped.css
 ┃ ┣ 📂NearPost
 ┃ ┃ ┣ 📜NearPost.js
 ┃ ┃ ┗ 📜NearPost.scoped.css
 ┃ ┣ 📂Post
 ┃ ┃ ┣ 📜Post.js
 ┃ ┃ ┗ 📜Post.scoped.css
 ┃ ┣ 📂PrivacyPolicy
 ┃ ┃ ┣ 📜PrivacyPolicy.js
 ┃ ┃ ┗ 📜PrivacyPolicy.scoped.css
 ┃ ┣ 📂Rule
 ┃ ┃ ┣ 📜Rule.js
 ┃ ┃ ┗ 📜Rule.scoped.css
 ┃ ┣ 📂SearchAddress
 ┃ ┃ ┗ 📜SearchAddress.js
 ┃ ┣ 📂SearchCard
 ┃ ┃ ┣ 📜SearchCard.js
 ┃ ┃ ┗ 📜SearchCard.scoped.css
 ┃ ┣ 📂SearchMap
 ┃ ┃ ┗ 📜SearchMap.js
 ┃ ┣ 📂SearchShopMap
 ┃ ┃ ┗ 📜SearchShopMap.js
 ┃ ┣ 📂ShopAnimalDetailPage
 ┃ ┃ ┣ 📜ShopAnimalDetailPage.js
 ┃ ┃ ┗ 📜ShopAnimalDetailPage.scoped.css
 ┃ ┣ 📂ShopAnimalList
 ┃ ┃ ┗ 📜ShopAnimalList.js
 ┃ ┣ 📂ShopAnimalListItem
 ┃ ┃ ┣ 📜ShopAnimalListItem.js
 ┃ ┃ ┗ 📜ShopAnimalListItem.scoped.css
 ┃ ┣ 📂ShopFollow
 ┃ ┃ ┗ 📜ShopFollow.js
 ┃ ┣ 📂ShopUp
 ┃ ┃ ┣ 📜ShopUp.js
 ┃ ┃ ┗ 📜ShopUp.scoped.css
 ┃ ┣ 📂SideBar
 ┃ ┃ ┣ 📜SideBar.js
 ┃ ┃ ┗ 📜SideBar.scoped.css
 ┃ ┣ 📂SignUpForm
 ┃ ┃ ┣ 📜SignUpForm.js
 ┃ ┃ ┗ 📜SignUpForm.scoped.css
 ┃ ┣ 📂UserBoards
 ┃ ┃ ┣ 📜UserBoards.js
 ┃ ┃ ┗ 📜UserBoards.scoped.css
 ┃ ┣ 📂UserComments
 ┃ ┃ ┗ 📜UserComments.js
 ┃ ┣ 📂UserGrade
 ┃ ┃ ┗ 📜UserGrade.js
 ┃ ┗ 📂UserLike
 ┃ ┃ ┗ 📜UserLike.js
 ┣ 📂hooks
 ┃ ┣ 📜useBoardDetail.js
 ┃ ┣ 📜useBoardList.js
 ┃ ┣ 📜useBoardMainList.js
 ┃ ┣ 📜useBoardPageMenu.js
 ┃ ┣ 📜useCheckFollow.js
 ┃ ┣ 📜useCheckLike.js
 ┃ ┣ 📜useInquiry.js
 ┃ ┣ 📜useInquiryList.js
 ┃ ┣ 📜useKioskList.js
 ┃ ┣ 📜useShopList.js
 ┃ ┗ 📜useUserList.js
 ┣ 📂KioskManagePage
 ┃ ┗ 📜KioskManage.js
 ┣ 📂LiveMap
 ┃ ┗ 📜LiveMap.js
 ┣ 📂MenuPostPage
 ┃ ┣ 📜MenuAdminPage.js
 ┃ ┣ 📜MenuPostOnePage.js
 ┃ ┗ 📜MenuPostPage.js
 ┣ 📂OrderCheckPage
 ┃ ┣ 📜OrderCheckBody.js
 ┃ ┣ 📜OrderCheckBody.scoped.css
 ┃ ┗ 📜OrderCheckPage.js
 ┣ 📂OrderPage
 ┃ ┣ 📜Cart.css
 ┃ ┣ 📜Cart.js
 ┃ ┣ 📜Item.css
 ┃ ┣ 📜Item.js
 ┃ ┣ 📜ModalBasic.css
 ┃ ┣ 📜ModalBasic.js
 ┃ ┣ 📜OnePage.css
 ┃ ┣ 📜OnePage.js
 ┃ ┣ 📜OrderPage.css
 ┃ ┣ 📜OrderPage.js
 ┃ ┣ 📜OrderTestPage.css
 ┃ ┗ 📜OrderTestPage.js
 ┣ 📂pages
 ┃ ┣ 📂BoardDetail
 ┃ ┃ ┣ 📜BoardDetail.js
 ┃ ┃ ┗ 📜BoardDetail.scoped.css
 ┃ ┣ 📂BoardPage
 ┃ ┃ ┣ 📜BoardPage.js
 ┃ ┃ ┗ 📜BoardPage.scoped.css
 ┃ ┣ 📂CreatePage
 ┃ ┃ ┣ 📜CreatePage.js
 ┃ ┃ ┗ 📜CreatePage.scoped.css
 ┃ ┣ 📂KioskAnimalDetailPage
 ┃ ┃ ┣ 📜KioskAnimalDetailPage.js
 ┃ ┃ ┗ 📜KioskAnimalDetailPage.scoped.css
 ┃ ┣ 📂KioskAnimalListPage
 ┃ ┃ ┗ 📜KioskAnimalListPage.js
 ┃ ┣ 📂KioskGalleryDetailPage
 ┃ ┃ ┗ 📜KioskGalleryDetailPage.js
 ┃ ┣ 📂KioskGalleryPage
 ┃ ┃ ┗ 📜KioskGalleryPage.js
 ┃ ┣ 📂KioskMain
 ┃ ┃ ┣ 📜KioskMain.js
 ┃ ┃ ┗ 📜KioskMain.scoped.css
 ┃ ┣ 📂LoginPage
 ┃ ┃ ┣ 📜LoginPage.js
 ┃ ┃ ┗ 📜LoginPage.scoped.css
 ┃ ┣ 📂MainPage
 ┃ ┃ ┣ 📜MainPage.js
 ┃ ┃ ┗ 📜MainPage.scoped.css
 ┃ ┣ 📂ManagePage
 ┃ ┃ ┣ 📜ManagePage.js
 ┃ ┃ ┗ 📜ManagePage.scoped.css
 ┃ ┣ 📂MyPage
 ┃ ┃ ┣ 📜MyPage.js
 ┃ ┃ ┗ 📜MyPage.scoped.css
 ┃ ┣ 📂SearchShopPage
 ┃ ┃ ┣ 📜SearchShopPage.js
 ┃ ┃ ┗ 📜SearchShopPage.scoped.css
 ┃ ┣ 📂ShopGalleryPage
 ┃ ┃ ┗ 📜ShopGalleryPage.js
 ┃ ┣ 📂ShopInfoPage
 ┃ ┃ ┣ 📜ShopInfoPage.js
 ┃ ┃ ┗ 📜ShopInfoPage.scoped.css
 ┃ ┣ 📂ShopPage
 ┃ ┃ ┣ 📜ShopPage.js
 ┃ ┃ ┗ 📜ShopPage.scoped.css
 ┃ ┗ 📂TestPage
 ┃ ┃ ┣ 📜TestPage.js
 ┃ ┃ ┗ 📜TestPage.scoped.css
 ┣ 📂utils
 ┃ ┣ 📜formatTime.js
 ┃ ┣ 📜handleCheckEmail.js
 ┃ ┣ 📜handleComment.js
 ┃ ┣ 📜handleCreateMenu.js
 ┃ ┣ 📜handleCreatePost.js
 ┃ ┣ 📜handleCreateTable.js
 ┃ ┣ 📜handleDeleteTable.js
 ┃ ┣ 📜handleEmailSend.js
 ┃ ┣ 📜handleKioskFirst.js
 ┃ ┣ 📜handleKioskLogin.js
 ┃ ┣ 📜handleLike.js
 ┃ ┣ 📜handleLogin.js
 ┃ ┣ 📜handleLogout.js
 ┃ ┣ 📜handleModifyTable.js
 ┃ ┣ 📜handlePasswordUpadate.js
 ┃ ┣ 📜handleRefreshToken.js
 ┃ ┣ 📜handleShop.js
 ┃ ┣ 📜handleSignUp.js
 ┃ ┣ 📜handleSubmit.js
 ┃ ┣ 📜handletest.js
 ┃ ┣ 📜handleUnlike.js
 ┃ ┗ 📜handleUserUpdate.js
 ┣ 📜App.css
 ┣ 📜App.js
 ┣ 📜axiosCreate.js
 ┣ 📜index.css
 ┗ 📜index.js
```

## 설계, 기획

### Prototype

[](https://www.figma.com/file/LmfUu7zbmXG2aIhZujdssU/A105?type=design&node-id=0:1&mode=design&t=69QzFvYKxsXRfdl9-1)

### API

[](http://i9a105.p.ssafy.io:8080/swagger-ui/index.html)

### Entity Relationship Diagram

![Untitled](Homo%20SSAFY-ens%20PET-MAN%20896c867556b248f6b6d74f73f9829427/Untitled.png)

- Jira (누적 흐름 도표)

![Untitled](Homo%20SSAFY-ens%20PET-MAN%20896c867556b248f6b6d74f73f9829427/Untitled%201.png)

IOT 칼만필터

![Untitled](Homo%20SSAFY-ens%20PET-MAN%20896c867556b248f6b6d74f73f9829427/Untitled%202.png)

![Untitled](Homo%20SSAFY-ens%20PET-MAN%20896c867556b248f6b6d74f73f9829427/Untitled%203.png)

![Untitled](Homo%20SSAFY-ens%20PET-MAN%20896c867556b248f6b6d74f73f9829427/Untitled%204.png)

![Untitled](Homo%20SSAFY-ens%20PET-MAN%20896c867556b248f6b6d74f73f9829427/Untitled%205.png)

히트맵

![Untitled](Homo%20SSAFY-ens%20PET-MAN%20896c867556b248f6b6d74f73f9829427/Untitled%206.png)

![Untitled](Homo%20SSAFY-ens%20PET-MAN%20896c867556b248f6b6d74f73f9829427/Untitled%207.png)

![Untitled](Homo%20SSAFY-ens%20PET-MAN%20896c867556b248f6b6d74f73f9829427/Untitled%208.png)

![Copy of Pet.png](Homo%20SSAFY-ens%20PET-MAN%20896c867556b248f6b6d74f73f9829427/Copy_of_Pet.png)
