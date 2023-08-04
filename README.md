# Homo SSAFY-ens : PET-MAN

## 🔷 프로젝트 소개

### ✔ 작성 정보

- 작성자 : 서울 1반 A105
- 날짜 : 2023.07.03 ~ 2023.08.18 (총 7주)

### 👥 팀원 소개

| 멤버 | 역할 | 담당 |
| --- | --- | --- |
| 👑 송진현😭 | Back IoT PM Infra Web  |  CI/CD 구현, SSL인증서 적용, 외부 API 연동, IOT 회로 설계, IOT 펌웨어 개발, 팀원 관리, 개발 총괄, 팀원 소통 및 스크럼 진행 |
| 🦘 이제원 | Back Web  | web 커뮤니티 기능 개발 - 유저, 게시글 사진, 유저 사진, 가게, 방문기록, 가게 평점, 가게 동물 정보 |
| 🐻 박동건 | Back Web | web 커뮤니티 기능 개발 - 게시글, 댓글, 좋아요, 태그 기능 |
| 🚀 김재석 | Front Web | web 게시글, 카페 개별 페이지, 마이페이지, 지도에서 찾기 기능  |
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
| 2023-08-01(화) | 이메일 인증, 게시판 탭 구현, 페이지네이션 적용, 관리자 페이지 테이블 구별 | 게시글, 댓글 리팩토링, 게시글 파일 업로드 기능 추가, 메일부분 api 수정 및 추가, swagger 의존성 추가, 유저와 보드 사진 및 파일 추가 수정 |  |
| 2023-08-02(수) | 게시판 기능 추가, 회원정보 수정 기능. 관리자 회원정보 관련 기능 구현 및 master merge | 게시글 리팩토링(for loop), 좋아요 api 제작 |  |
| 2023-08-03(목) | 리팩토링 | 게시글 좋아요 기능 개발, dto 리팩토링, 위치정보 api 추가 |  |

### ✔ 회의록

- 레퍼런스, 메모 등 추가

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
    | !BREAKING CHANGE | 커다란 API 변경의 경우 |
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
- 인스턴스 삭제 시  soft-delete 방식을 채택한다.
    - `DELETE`요청을 통해 상태 변수를 삭제/생성 상태를 전환한다.
- Service, Repository 영역에서 단일 객체를 반환하는 메소드의 경우 `Optional`을 사용해 null 반환에 대응한다.

## 📂 프로젝트 폴더 구조

### Back-End(변동 있으면 수정)

```markdown
📂 backend
	ㄴ ...
	ㄴ 📂 main
			ㄴ 📂 java
					ㄴ 📂 com.petman
							ㄴ 📄 PetmanBackEndApplication.java
					ㄴ 📂 com.petman.config
							ㄴ 📄 DBConfig.java
							ㄴ 📄 WebConfig.java
					ㄴ 📂 com.petman.board
							ㄴ 📂 controller
									ㄴ 📄 BoardController.java
							ㄴ 📂 service
									ㄴ 📄 BoardService.java
									ㄴ 📄 LikeBoardService.java
							ㄴ 📂 repository
									ㄴ 📄 BoardRepository.java
									ㄴ 📄 LikeBoardRepository.java
									ㄴ 📄 CategoryRepository.java
							ㄴ 📂 dto
									ㄴ 📂 requestDto
											ㄴ 📄 AddBoardRequestDto.java
											ㄴ 📄 UpdateLikeBoardRequestDto.java
											ㄴ 📄 UpdateBoardRequestDto.java
									ㄴ 📂 responseDto
											ㄴ 📄 BoardResponseDto.java
											ㄴ 📄 LikeBoardListResponseDto.java
							ㄴ 📂 entity
									ㄴ 📄 Board.java
									ㄴ 📄 LikeBoard.java
									ㄴ 📄 Category.java
					ㄴ 📂 com.petman.comment
							ㄴ 📂 controller
									ㄴ 📄 CommentController.java
							ㄴ 📂 service
									ㄴ 📄 CommentService.java
							ㄴ 📂 repository
									ㄴ 📄 CommentRepository.java
							ㄴ 📂 dto
									ㄴ 📂 requestDto
											ㄴ 📄 AddCommentRequestDto.java
											ㄴ 📄 UpdateCommentRequestDto.java
									ㄴ 📂 responseDto
											ㄴ 📄 CommentResponseDto.java
							ㄴ 📂 entity
									ㄴ 📄 Comment.java
					ㄴ 📂 com.petman.shop
							ㄴ 📂 controller
									ㄴ 📄 ShopController.java
							ㄴ 📂 service
									ㄴ 📄 ShopService.java
							ㄴ 📂 repository
									ㄴ 📄 ShopRepository.java
							ㄴ 📂 dto
									ㄴ 📂 requestDto
											ㄴ 📄 UserRequestDto.java
									ㄴ 📂 responseDto
											ㄴ 📄 UserResponseDto.java
							ㄴ 📂 entity
									ㄴ 📄 Shop.java
					ㄴ 📂 com.petman.user
							ㄴ 📂 controller
									ㄴ 📄 UserController.java
							ㄴ 📂 service
									ㄴ 📄 JwtService.java
									ㄴ 📄 JwtServiceImpl.java
									ㄴ 📄 UserService.java
									ㄴ 📄 UserServiceImpl.java
									ㄴ 📄 JwtUtil.java
							ㄴ 📂 repository
									ㄴ 📄 UserRepository.java
							ㄴ 📂 dto
									ㄴ 📂 requestDto
											ㄴ 📄 LoginDto.java
											ㄴ 📄 ModifyDto.java
											ㄴ 📄 RegistDto.java
									ㄴ 📂 responseDto
											ㄴ 📄 TokenDto.java
											ㄴ 📄 UserInformationDto.java
											ㄴ 📄 UserListDto.java
							ㄴ 📂 entity
									ㄴ 📄 User.java
									ㄴ 📄 Token.java
			ㄴ 📂 resources
					ㄴ 📂 static
							ㄴ 📂 img
					ㄴ 📄 application.yml
```

### Front-End

```markdown
📂 frontend
	ㄴ ...
	ㄴ 📂 public
		ㄴ 📄 favicon.ico
		ㄴ 📄 index.html
		ㄴ 📄 manifest.json
		ㄴ 📄 robots.txt
		ㄴ 📂 images
			ㄴ 📂 logo
				ㄴ 📄 logo192.png
				ㄴ 📄 logo512.png
			ㄴ 📂 main
				ㄴ 📄 babyrabbit.png
				ㄴ 📄 bamboodog.png
				ㄴ 📄 blackcat.png
				ㄴ 📄 cat.png
				ㄴ 📄 chinchilla.png
				ㄴ 📄 dog.png
				ㄴ 📄 ducklings.png
				ㄴ 📄 hamster.png
				ㄴ 📄 noimage.png
				ㄴ 📄 puppy.png
				ㄴ 📄 rabbit.png
				ㄴ 📄 walldog.png
				ㄴ 📄 wooddog.png
	ㄴ 📂 src
		ㄴ 📄 App.css
		ㄴ 📄 App.js
		ㄴ 📄 index.css
		ㄴ 📄 index.js
		ㄴ 📂 components
			ㄴ 📂 Button
				ㄴ 📄 Button.css
				ㄴ 📄 Button.js
			ㄴ 📂 CommentList
				ㄴ 📄 CommentList.css
				ㄴ 📄 CommentList.js
			ㄴ 📂 Editor
				ㄴ 📄 Editor.css
				ㄴ 📄 Editor.js
			ㄴ 📂 Footer
				ㄴ 📄 Footer.css
				ㄴ 📄 Footer.js
			ㄴ 📂 Header
				ㄴ 📄 Header.css
				ㄴ 📄 Header.js
			ㄴ 📂 InquiryForm
				ㄴ 📄 InquiryForm.css
				ㄴ 📄 InquiryForm.js
			ㄴ 📂 LoginForm
				ㄴ 📄 LoginForm.css
				ㄴ 📄 LoginForm.js
			ㄴ 📂 MainList
				ㄴ 📄 MainList.css
				ㄴ 📄 MainList.js
				ㄴ 📄 MainListMockupData.js
			ㄴ 📂 Menu
				ㄴ 📄 Menu.css
				ㄴ 📄 Menu.js
			ㄴ 📂 NearPost
				ㄴ 📄 NearPost.css
				ㄴ 📄 NearPost.js
			ㄴ 📂 Post
				ㄴ 📄 Post.css
				ㄴ 📄 Post.js
			ㄴ 📂 SideBar
				ㄴ 📄 SideBar.css
				ㄴ 📄 SideBar.js
		ㄴ 📂 pages
			ㄴ 📂 BoardDetail
				ㄴ 📄 BoardDetail.css
				ㄴ 📄 BoardDetail.js
			ㄴ 📂 BoardPage
				ㄴ 📄 BoardPage.css
				ㄴ 📄 BoardPage.js
			ㄴ 📂 InquiryPage
				ㄴ 📄 InquiryPage.css
				ㄴ 📄 InquiryPage.js
			ㄴ 📂 LoginPage
				ㄴ 📄 LoginPage.css
				ㄴ 📄 LoginPage.js
			ㄴ 📂 MainPage
				ㄴ 📄 MainPage.css
				ㄴ 📄 MainPage.js
			ㄴ 📂 ManagePage
				ㄴ 📄 ManagePage.css
				ㄴ 📄 ManagePage.js
			ㄴ 📂 MyPage
				ㄴ 📄 MyPage.css
				ㄴ 📄 MyPage.js
			ㄴ 📂 StorePage
				ㄴ 📄 StorePage.css
				ㄴ 📄 StorePage.js
			ㄴ 📂 TestPage
				ㄴ 📄 TestPage.css
				ㄴ 📄 TestPage.js
		ㄴ 📂 utils
			ㄴ 📂 handleLogin
				ㄴ 📄 handleLogin.js
		ㄴ 📂 hooks
			ㄴ 📂 useBoardDetail
				ㄴ 📄 useBoardDetail.js
			ㄴ 📂 useBoardList
				ㄴ 📄 useBoardList.js
			ㄴ 📂 useBoardPageMenu
				ㄴ 📄 useBoardPageMenu.js
	ㄴ 📄 package-lock.json
	ㄴ 📄 package.json
	ㄴ 📄 README.md
```

## 설계, 기획

### Prototype

[](https://www.figma.com/file/LmfUu7zbmXG2aIhZujdssU/A105?type=design&node-id=0:1&mode=design&t=69QzFvYKxsXRfdl9-1)

### Entity Relationship Diagram

![homo_ssafyens_ERD.png](assets/homo_ssafyens_ERD.png)