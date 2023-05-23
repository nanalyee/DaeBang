## 4팀 이현구, 서현경 최종 보고서

# 🚩프로젝트 소개

### ✔️ **프로젝트 명**

### 대 방

### ✔️ **프로젝트 설명**

 Backend는 SpringBoot , Frontend는 Vue로 구현하고 DB를 구축하여 데이터를 관리하는 프로젝트이다.

MVC + MVVM 기반의 웹 프로젝트를 설계하고 구현하며, Kakao Map API와 공공 데이터 포털을 통해 대전지역의 전,월세 데이터를 가공하여 기능을 제공한다.

사용자는 원하는 지역을 검색하고 관심 지역에 등록하여 추천 시스템을 이용할 수 있다.

사용자가 선택한 지역의 전,월세 자료를 테이블 형태로 보여주며, 해당하는 집의 이름 클릭 시 상세정보와 반경 1KM 지역 이내의 상권 위치를 확인할 수 있다.

편의 기능으로 교통, 날씨, 관광지 정보를 제공한다.

### ✔️ **프로젝트 일정**

### **2022-11-14 ~ 2022-11-24**

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/37fc59c8-4cce-47c0-bcbb-a9849d9c3a4d/Untitled.png)

### ✔️ **팀원**

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c5c40988-bb5e-427e-b215-226af8c06f18/Untitled.png)

- **[이현구](https://github.com/Leeh9)**
- **[서현경](https://github.com/nanalyee)**

## 📌 목표

- Web Architecture를 이해하고 활용하여 Web Project를 설계하고 구현할 수 있다.
- Spring & MyBatis Framework, Spring Boot, Vue.js를 이해하고 활용할 수 있다.
- OAuth 로그인, REST API등의 기술을 활용하여 MSA를 도입해 본다.
- 추가적으로 기능을 구현한다.

## ⭐ 프로젝트 기능

### 필수 구현 기능

1. 주택 실거래가 정보 수집 (아파트, 다가구주택, 오피스텔)
2. 주택 실거래가 검색 (아파트, 다가구주택, 오피스텔)
3. 회원 관리 ( 회원가입, 회원탈퇴, 내 정보 수정)
4. 로그인 관리 ( 로그인 / 로그아웃 )

### 추가 구현 기능

1. 관심 지역 추가 / 삭제 (회원 전용)
2. 주변 상권 정보 수집
3. 주변 상권 업종 정보 검색 (8가지 대 분류)
4. 주변 날씨 정보 수집 / 출력
5. 주변 관광지 정보 수집 / 출력
6. 사용자에게 상권 선호 지수를 입력 받아 관심 지역 추천 시스템 구현(회원 전용)
7. 점수 기반 관심 지역 랭킹 / 차트 출력
8. 주요 지역 실시간 교통 상황
9. 실시간 교통 상황 공유 게시판 (글 쓰기, 수정, 읽기, 회원 전용)
10. 버스 정류소 실시간 버스 도착 정보 (검색)
11. 지하철 역 상세 정보 확인
12. 주택, 관광지 썸네일 이미지 검색 기능

## 💥 기술 스택

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/19ff7947-ab25-43ff-b6b7-41baa6b52eb4/Untitled.png)

## 📡 사용한 API

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/cf94b6cc-5a44-415b-9ae7-66ed25b28b07/Untitled.png)

![데이터1.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/baf3f045-84ea-442d-bcc4-eb4c2bf600bd/%EB%8D%B0%EC%9D%B4%ED%84%B01.png)

![데이터2.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a41b7d6d-9102-4d55-a5da-a9b89026bd74/%EB%8D%B0%EC%9D%B4%ED%84%B02.png)

![데이터3.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ee08c95c-8cbd-4dc9-bd80-cf3886d49fa6/%EB%8D%B0%EC%9D%B4%ED%84%B03.png)

## 💾 사용한 데이터베이스

- **[ daebang_member]** - 유저 테이블

|  | 유저ID | 유저이름 | 유저비밀번호 | 이메일 | 가입일 | 토큰 |
| --- | --- | --- | --- | --- | --- | --- |
| Column Name | userid | username | userpwd | email | joindate | token |
| Data Type | varchar(16) | varchar(20) | varchar(16) | varchar(20) | TIMESTAMP | varchar(1000) |
| Constraint | primary key | NOT NULL | NOT NULL | default null | NOT NULL  DEFAULT CURRENT_TIMESTAMP | default null |

```sql
CREATE TABLE IF NOT EXISTS `daebang`.`daebang_member` (
  `userid` VARCHAR(16) NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `userpwd` VARCHAR(16) NOT NULL,
  `email` VARCHAR(20) NULL DEFAULT NULL,
  `joindate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `token` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`userid`))
```

- **[ board ]** - 게시판 테이블

|  | 게시글번호 | 게시글유형 | 게시글작성자 | 게시글제목 | 게시글내용 | 조회수 | 게시글작성일시 |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Column Name | articleno | articletype | userid | subject | content | hit | regtime |
| Data Type | INT(AUTO_INCREMENT) | VARCHAR(16) | VARCHAR(16) | VARCHAR(100) | VARCHAR(2000) | INT | DATE |
| Constraint | primary key | DEFAULT NULL | DEFAULT NULL | DEFAULT NULL | DEFAULT NULL | DEFAULT 0 | NOT NULL |
|  |  |  |  |  |  |  |  |

```sql
CREATE TABLE IF NOT EXISTS `daebang`.`board` (
  `articleno` INT NOT NULL AUTO_INCREMENT,
  `articletype` VARCHAR(16) NULL DEFAULT NULL,
  `userid` VARCHAR(16) NULL DEFAULT NULL,
  `subject` VARCHAR(100) NULL DEFAULT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT 0,
  `regtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`articleno`),
  FOREIGN KEY (`userid`) REFERENCES `daebang_member` (`userid`))
```

- **[ busstop_info]** - 버스 정류소 테이블

|  | 정류소 ID | 정류소 이름 |
| --- | --- | --- |
| Column Name | stop_id | stop_name |
| Data Type | VARCHAR(30) | VARCHAR(30) |
| Constraint | NOT NULL | NOT NULL |
|  |  |  |

```sql
CREATE TABLE IF NOT EXISTS `daebang`.`busstop_info` (
  `stop_id` VARCHAR(30) NOT NULL,
  `stop_name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`stop_id`))
```

- **[ subway_info]** - 지하철 역사 테이블

|  | 역 ID | 역 이름 | 승강 시설 | 역 주소 | 역 출구 정보 | 역 구조 | 역 번호 | 역 면적 | 자전거 거치대 여부 | 엘리베이터 여부 | 수유실 여부 | 분실물 관리 여부 | 휠체어 충전소 여부 | 물품 보관함 여부 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Column Name | stationCode | stationName | elevatorFac | stationAddr | stationExit | stationStruct | stationTel | stationArea | bikeStorageYn | elevatorYn | lactationRoomYn | lostPropertyCenterYn | wheelchairChargingYn | supplyRoomYn |
| Data Type | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) |
| Constraint | NOT NULL | NOT NULL | NOT NULL | NOT NULL | NOT NULL | NOT NULL | NOT NULL | NOT NULL | NOT NULL | NOT NULL | NOT NULL | NOT NULL | NOT NULL | NOT NULL |
|  | PRIMARY KEY |  |  |  |  |  |  |  |  |  |  |  |  |  |

```sql
CREATE TABLE IF NOT EXISTS `daebang`.`subway_info` (
  `stationCode` VARCHAR(30) NOT NULL,
  `stationName` VARCHAR(30) NOT NULL,
  `elevatorFac` VARCHAR(30) NOT NULL,
  `stationAddr` VARCHAR(30) NOT NULL,
  `stationExit` VARCHAR(30) NOT NULL,
  `stationStruct` VARCHAR(30) NOT NULL,
  `stationTel` VARCHAR(30) NOT NULL,
   `stationArea` VARCHAR(30) NOT NULL,
  `bikeStorageYn` VARCHAR(30) NOT NULL,
  `elevatorYn` VARCHAR(30) NOT NULL,
  `lactationRoomYn` VARCHAR(30) NOT NULL,
  `lostPropertyCenterYn` VARCHAR(30) NOT NULL,
  `wheelchairChargingYn` VARCHAR(30) NOT NULL,
  `supplyRoomYn` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`stationCode`))
```

- **[ wishlist]** - 관심 지역 테이블

|  | 관심지역번호 | 관심지역이름 | 주택타입 | 구이름 | 동이름 | 경도 | 위도 | 유저ID | 등록일 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Column Name | wishno | wishname | wishtype | gugunname | dongname | lat | lng | userid | joindate |
| Data Type | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) | VARCHAR(30) |
| Constraint | NOT NULL | NOT NULL | NOT NULL | NOT NULL | NOT NULL | NOT NULL | NOT NULL | NOT NULL | NOT NULL |
|  | PRIMARY KEY |  |  |  |  |  |  |  |  |

```sql
CREATE TABLE IF NOT EXISTS `daebang`.`wishlist` (
  `wishno`  INT NOT NULL AUTO_INCREMENT, #번호
  `wishname` VARCHAR(20) NOT NULL, #이름
  `wishtype` VARCHAR(20) NOT NULL, #타입
  `gugunname` VARCHAR(20) NOT NULL, #구군
  `dongname` VARCHAR(20) NOT NULL, #법정동
  `lat` VARCHAR(20) NOT NULL, #위도
  `lng` VARCHAR(20) NOT NULL, #경도
  `userid` VARCHAR(16) NOT NULL, #등록한 유저 id
  `joindate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, #등록시간
  PRIMARY KEY (`wishno`),
  FOREIGN KEY (`userid`) REFERENCES `daebang_member` (`userid`))
```

### 전체 시스템 구조도

---

![시스템구조도.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c858f1c1-594f-4303-9d37-459729c3c6a5/%EC%8B%9C%EC%8A%A4%ED%85%9C%EA%B5%AC%EC%A1%B0%EB%8F%84.png)

### ERD(Entity Relationship Diagram)

---

![daebang_erd.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a35aefc9-e80e-47c4-b3fe-47d4023eec38/daebang_erd.png)

## Flow Chart

---

![flowchart.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8faa6881-de89-48c3-8a2a-67527deef2f1/flowchart.png)

## UseCase Diagram

---

![daebang_usecase.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/27e93722-b9f4-4e48-9021-e49c6742b84a/daebang_usecase.png)

## Class Diagram

- **<Member>**

![member.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6ff0192e-58f8-469e-9634-ad27ba91cce7/member.png)

- **<Board>**

![board.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/38a4edc9-85b5-4890-8515-8072dfd68d12/board.png)

- **<Traffic>**

![traffic.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9bc9f36e-6f8a-480e-873a-fec97f96f6fd/traffic.png)

- **<Wish>**

![wish.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/36ef2a59-d9a7-403c-91eb-58355c78de36/wish.png)

- **<Config>**

![config_cd.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d3198383-9755-48ff-abc6-57636f75440b/config_cd.png)

- **<Interceptor>**

![interceptor_cd.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3ef45871-f4ff-44a8-8f9e-fffecf546995/interceptor_cd.png)

- **<Exception>**

![exception_cd.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/71f1018c-f2e5-42ad-a3c9-0d5c6eed0ea2/exception_cd.png)

## 🗂 프로젝트 구성

### **<Backend>**

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/26d73f9f-c970-443f-92e4-8f45adea610b/Untitled.png)

### **<Frontend>**

- components

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6514f2b4-efb0-4452-958e-6ab185e54a10/Untitled.png)

- views

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a7c80c93-6d33-4878-9cd6-ecbf30d55454/Untitled.png)

# 📢기능 설명

## [ 0. 메인 ]

- **화면**

![main-full.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8522d08c-f9ba-4145-a233-fb09e70d4fa5/main-full.png)

- **기능 설명**
    
    페이지 첫 실행시 보여지는 화면으로 인사말, 서비스소개, 공공데이터, 팀원 소개로 이루어져있다.
    

## [ 1. 전,월세 실거래 조회]

- **화면**

![apt-search-keyword.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7e5f5b14-7d6e-46b7-b54b-2dd7a4a5f799/apt-search-keyword.png)

![apt-search-1.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8607471a-667f-4f12-8918-4c0365dc1012/apt-search-1.png)

![apt-search-2.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e22a9801-c795-4e8f-835f-301c06d05a64/apt-search-2.png)

- **기능 설명**
    
    로그인 하면 대전 지역 전,월세 실거래 조회 화면으로 넘어간다.
    
    타입, 구 , 연 , 월을 선택하면 해당하는 지역의 다음 selectbox가 표시된다.
    
    검색을 누르면 해당하는 지역의  전,월세 실거래 데이터가 조회된다.
    

## [ 2. 해당 주거형태의 이미지 불러오기 기능 ]

- **화면**
    
    ![apt-search-3.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a41f955e-1a34-494d-95ab-8647214d8f42/apt-search-3.png)
    

- **기능 설명**
    
    전월세 데이터를 조회한 후 해당 데이터를 클릭 시 상세정보가 출력되며 카카오 이미지 검색 api를 이용하여
    
    정확도 순으로 첫 번째에 있는 이미지를 가져온다.
    

## [ 3. 카카오맵에서 매물 위치 및 상세 정보 조회 ]

- **화면**
    
    ![detail-full.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/30813cec-95e9-4a91-ad2b-9b05739904f6/detail-full.png)
    

![detail-near-list-2.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9653ec28-254d-4b75-94a5-d25bf55770c0/detail-near-list-2.png)

![detail-near-button.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9afc5698-e3af-4c86-851e-f2872f9f1c4b/detail-near-button.png)

![detail-near-list-1.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6caa6274-e20b-4257-b68b-caca6b5437b0/detail-near-list-1.png)

- **기능 설명**
    
    원하는 매물의 상세정보 페이지로 이동하여 카카오지도 위에서 매물 위치를 시각적으로 확인할 수 있다.
    
    상권 버튼을 눌러 사용자가 원하는 키워드 버튼을 클릭하면 해당 키워드에 맞는 상권 정보를 조회 가능하다. 각 상권 버튼을 누르면 상세정보가 보이며, 지도에서 인포윈도우로 정확한 위치를 파악할 수 있다. 상권 목록은 [접기]나 [상권모양버튼]으로 언제든 닫거나 열 수 있다.
    

## [ 4. 실시간 날씨 예보 조회 ]

- **화면**

![detail-near-weather.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c690d1df-1d39-4cfc-a786-c12cbcb0a5ab/detail-near-weather.png)

- **기능 설명**
    
    중앙 상단의 날씨 버튼을 누르면 현재 페이지의 매물 위치 정보를 토대로 약 하루동안 날씨 예보를 시각적 아이콘으로 파악할 수 있다.
    

## [ 5. 주변 관광 정보 조회 ]

- **화면**
    
    ![detail-near-tour-1.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ca2112ac-2d30-4703-9502-754107863a13/detail-near-tour-1.png)
    
    ![detail-near-tour-2.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c52e3675-f906-4cd8-9d4a-3aefd97dac96/detail-near-tour-2.png)
    

- **기능 설명**
    
    중앙 상단의 관광지 버튼을 누르면 현재 페이지의 매물 위치 정보를 토대로 동일한 구군 지역의 관광지를 리스트 형태로 보여준다. 각 항목을 클릭하면 우측 화면에서 관련 상세 정보를 조회할 수 있다.
    

## [ 6. 교통 상황 조회]

- **화면**

![traffic-road.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/aac6435d-19ab-4405-b961-4337ec6b4140/traffic-road.png)

- **기능 설명**
    
    교통상황 버튼을 클릭하면 해당 페이지로 넘어간다.
    
    랜드마크 버튼을 클릭하면 해당 지역의 실시간 교통 상황을 보여준다.
    

## [ 7. 교통 상황 공유 게시판 ]

- **화면**
    
    ![traffic-road-board.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/49ba69ec-c11a-492f-9dac-7f05ead59fc9/traffic-road-board.png)
    
    ![traffic-road-board-success.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d0f93b4a-9c4a-4596-b65a-6b3a9e0c83fd/traffic-road-board-success.png)
    
    ![traffic-road-board-write.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fe77a741-f19a-4319-a44d-9967f2a98a49/traffic-road-board-write.png)
    
    ![traffic-road-board-write-after-modifyable.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0676e465-6418-435e-ad05-d6173b2c7222/traffic-road-board-write-after-modifyable.png)
    

- **기능 설명**
    
    랜드마크의 게시글 버튼을 클릭하면 오른쪽에 사이드바와 함께 해당하는 지역의 게시글 목록을 출력한다.
    
    각 게시판 별로 유저는 CRUD 기능을 이용할 수 있고 게시글을 클릭하면 내용이 출력된다.
    
    작성일시가 함께 출력되므로 실시간으로 교통 정보를 공유할 수 있다.
    

## [ 8. 실시간 버스정류소 조회 ]

- **화면**
    
    ![traffic-road-bus.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/96e10cbf-a4fb-494c-a69e-06348c34bdea/traffic-road-bus.png)
    
    ![traffic-road-bus-search.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8035a625-81fc-4e0f-9668-4be61355f52d/traffic-road-bus-search.png)
    
    ![traffic-road-bus-detail.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/506361bc-a526-4793-90bb-c63f4ff41611/traffic-road-bus-detail.png)
    
- **기능설명**
    
    대전광역시 3072개의 정류소 정보를 슬라이드쇼 형태로 조회할 수 있다.
    
    우측 상단의 검색창을 통해 원하는 키워드의 정류소만 모아서 볼 수 있다.
    
    원하는 정류소를 클릭하면 상세 정보를 모달창으로 확인할 수 있다.
    

## [ 9. 지하철 역사 정보 조회 ]

- **화면**
    
    ![traffic-subway.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/74110d35-a573-457c-8029-9abe680daf3b/traffic-subway.png)
    

![traffic-subway-detail.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e6137f81-0552-4c1f-9489-20032a008507/traffic-subway-detail.png)

- **기능설명**
    
    대전시의 모든 도시철도 역사정보를 슬라이드쇼 형태로 확인할 수 있다. 
    
    원하는 역을 클릭하면 모달창으로 상세정보를 조회 가능하다.
    

## [ 10. 관심지역 설정 ]

- 화면
    
    ![wish-add-1.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e3f19c2d-c2f1-484a-a389-522a633419e5/wish-add-1.png)
    
    ![wish-add-2.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/929eca2b-b487-4fc3-8d23-67ceabf71728/wish-add-2.png)
    
    ![wish-add-3.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bdc1bb11-099e-4a00-a10e-aa597958b0b9/wish-add-3.png)
    
- 기능설명
    
    로그인을 하면 3번의 페이지에서 하트 버튼이 보인다. 빈 하트를 누르면 관심지역에 추가되고, 하트가 채워진다. 반대로 채워진 하트를 누르면 관심지역에서 삭제되고 하트가 비게 된다.
    
    해당 내역은 11번 관심지역 랭킹에서 상세하게 확인할 수 있다.
    

## [ 11. 관심지역 랭킹과 주변 상권 리스트 ]

- **화면**
    
    ![wishrank-1.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6e48ac2f-7fb6-4a9e-8145-611a43c7b5a8/wishrank-1.png)
    
    ![wishrank-2.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/87bfcb05-e94e-4359-8b62-62a4e9a24c7c/wishrank-2.png)
    

- **기능설명**
    
    사용자가 설정한 상권 선호도 점수를 바탕으로 점수화하여 시상대와 차트 형태로 표현했다.
    
     ( = 선호상권 유/무 + 반경500m 해당 상권 개수)
    
    1~3위 매물은 해당 정보를 클릭하면 주변 상권 목록을 키워드 별로 모아서 볼 수 있다.
    

## [ 12. 로그인/로그아웃/회원가입/회원탈퇴/마이페이지/정보수정 ]

- **화면**
    
    ![login-before.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/850949e4-49f3-4e20-83a9-ed250d83c60c/login-before.png)
    
    ![login-after.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f11d9850-a7d7-4a34-899e-79861b4b6ced/login-after.png)
    
    ![modify-1.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/85351e67-a370-4c69-99cc-7046f219687a/modify-1.png)
    
    ![modify-alert-fail.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/47e2793f-b4d5-49f9-9b89-1dd196b879da/modify-alert-fail.png)
    
    ![modify-alert-success.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d0a28474-557c-4097-8ead-150b101e23c9/modify-alert-success.png)
    
    ![regist-alert-fail.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e217e2ae-8b29-4e6b-8364-4853b4a326b7/regist-alert-fail.png)
    
    ![regist-alert-success.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/93e8c6e9-2ab4-43f3-87c3-250e83b59350/regist-alert-success.png)
    
- **기능설명**
    
    jwt 토큰 방식으로 로그인하여 안정성을 비교적 높였다.
    
    ![login-refreshToken.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4a173501-4ea0-4dea-9203-cad55a32ac2d/login-refreshToken.png)
    
    회원가입은 전용 페이지에서, 정보 수정과 회원 탈퇴는 마이페이지에서 가능하다.
    
    ![wishscore-modify.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/84f81bbd-85ab-46d5-9810-9fda0bb6dc3e/wishscore-modify.png)
    
    ![wishscore-modify-after.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c8931b57-3649-4317-9393-1798e8bcf198/wishscore-modify-after.png)
    
    ![wishscore-modify-success.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8eb0ce42-9882-4d6a-a1b9-09fc22f93064/wishscore-modify-success.png)
    
    마이페이지 내에 있는 상권 선호도 정보를 통해 사용자가 점수를 커스터마이징 할 수 있다.
    
    ---
    
    ## 👏 소감
    
    ### 이현구
    
    ```
    예상보다 프로젝트의 완성도가 높게 나와 같아 만족한다.
    약 열흘간 쉬지 않고 달렸는데 갑작스러운 제안이나 기능 수정 요구에도
    불평 없이 열심히 해준 페어에게 감사를 전하고 싶다.
    ```
    
    ### 서현경
    
    ```
      기획했던 서비스에 비해 대전을 보다 깊게 분석할 수 있는 데이터가 부족해서 아쉬웠지만,
      대부분 기획과 비슷하게나마 구현해 내서 뿌듯했다. 
      끝까지 열심히 해내준 페어에게 너무 고맙고 덕분에 많이 배우고 성장할 수 있는 좋은 경험이었다.
    ```
