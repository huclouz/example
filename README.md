## Project : example
## author : hyuchang, shin
## descript : search book

## 개발 환경
### frontend
- vue 2.2 CLI
- 소스 관리를 위하여 따로 생성 (github URL https://github.com/huclouz/example-front) 

### backend
- Language : JAVA 8
- Framework : Springboot 2.2
- Database : Mysql 5.5.49

## Use Libraries
### frontend
- vuetify : Material UI Theme
- axios : http통신

### backend
- Lombok : set/get 자동설정
- Resttemplate : API 통신
- jackson-databind : 통신 후 사용객체로 컨버팅하기위하여
- mysql-connector :  mysql db접속용
- jwt : restAPI 인증용
- swagger : API문서 확인 및 api testtool로 사용

## Build Flow
```
1. frontend build
2. 빌드 산출물 backend의 static 경로로 복사
3. backend build (현재 백엔드는 프론트엔드의 산출물을 복사해서 push한 상태라 위 내용 생략가능합니다.)
```

## 설치 방법
```
$ git clone https://github.com/huclouz/example.git
$ cd example
$ gradlew clean test 명령을 통하여 테스트케이스를 구동합니다. (선택)
$ gradlew clean build ( 윈도우 OS의 경우 gradlew.bat clean build 이용)
$ java -jar build/libs/huttchang-0.0.1-SNAPSHOT.war 명령을 통하여 실행
  구동을 해야하기때문에 DB는 공개해둔 상태입니다.
```

## RestAPI 한눈에 보기
```
http://localhost:8080/swagger-ui.html로 접속하시면 RestAPI가 한눈에 보입니다.
```

## 사용법
- 로그인 없이는 책 검색, 상세보기, 구매링크로 이동하는 기능이 가능합니다.
- 로그인 후에는 검색 창 옆의 검색어 히스토리, 북마크의 기능이 사용 가능합니다.

