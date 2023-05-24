# 🚩프로젝트 소개

### ✔️ **프로젝트 명**

![Title](/Images/banner.png)

### ✔️ **프로젝트 개요**

SSAFY 8기 1학기 관통 프로젝트

2인 제작, 2022.11.14 ~ 2023.11.24 (11일)

### ✔️ **프로젝트 목표**

Backend는 SpringBoot , Frontend는 Vue로 구현하고 DB를 구축하여 데이터를 관리하는 프로젝트이다.

MVC + MVVM 기반의 웹 프로젝트를 설계하고 구현하며, Kakao Map API와 공공 데이터 포털을 통해 대전지역의 전,월세 데이터를 가공하여 기능을 제공한다.

사용자는 원하는 지역을 검색하고 관심 지역에 등록하여 추천 시스템을 이용할 수 있다.

사용자가 선택한 지역의 전,월세 자료를 테이블 형태로 보여주며, 해당하는 집의 이름 클릭 시 상세정보와 반경 1KM 지역 이내의 상권 위치를 확인할 수 있다.

편의 기능으로 교통, 날씨, 관광지 정보를 제공한다.

<br/>

# 🏆 프로젝트 성과

- **SSAFY 프로젝트 경진대회 1등**
- 1학기 과정에서 배웠던 Spring & MyBatis Framework, Spring Boot, Vue.js를 이해하고 활용해 볼 수 있었습니다.
- Kakao Map API와 공공 데이터 포털의 총 12가지 API를 사용해 대전 지역의 데이터를 모아서 가공했습니다.
- 사용자는 원하는 지역을 검색하고 관심 지역에 등록하여 추천하는 시스템을 제공하였습니다.

<br/>

# 📺 서비스 화면

**📺 시연 영상** : https://youtu.be/syRObG1gbTQ

<details>
<summary>화면 구성</summary>
<div markdown="1">

## [ 0. 메인 ]

![main-full.png](/Images/main-full.png)

- **기능 설명**
  페이지 첫 실행시 보여지는 화면으로 인사말, 서비스소개, 공공데이터, 팀원 소개로 이루어져있다.

## [ 1. 전,월세 실거래 조회]

![apt-search-keyword.png](/Images/search/apt-search-keyword.png)

![apt-search-1.png](/Images/search/apt-search-1.png)

![apt-search-2.png](/Images/search/apt-search-2.png)

로그인 하면 대전 지역 전,월세 실거래 조회 화면으로 넘어간다.
타입, 구 , 연 , 월을 선택하면 해당하는 지역의 다음 selectbox가 표시된다.
검색을 누르면 해당하는 지역의 전,월세 실거래 데이터가 조회된다.

## [ 2. 해당 주거형태의 이미지 불러오기 기능 ]

![apt-search-3.png](/Images/search/apt-search-3.png)

전월세 데이터를 조회한 후 해당 데이터를 클릭 시 상세정보가 출력되며 카카오 이미지 검색 api를 이용하여
정확도 순으로 첫 번째에 있는 이미지를 가져온다.

## [ 3. 카카오맵에서 매물 위치 및 상세 정보 조회 ]

![detail-full.png](/Images/near/detail-full.png)
![detail-near-button.png](/Images/near/detail-near-button.png)
![detail-near-list-1.png](/Images/near/detail-near-list-1.png)
![detail-near-list-2.png](/Images/near/detail-near-list-2.png)

원하는 매물의 상세정보 페이지로 이동하여 카카오지도 위에서 매물 위치를 시각적으로 확인할 수 있다.
상권 버튼을 눌러 사용자가 원하는 키워드 버튼을 클릭하면 해당 키워드에 맞는 상권 정보를 조회 가능하다. 각 상권 버튼을 누르면 상세정보가 보이며, 지도에서 인포윈도우로 정확한 위치를 파악할 수 있다. 상권 목록은 [접기]나 [상권모양버튼]으로 언제든 닫거나 열 수 있다.

## [ 4. 실시간 날씨 예보 조회 ]

![detail-near-weather.png](/Images/near/detail-near-weather.png)

중앙 상단의 날씨 버튼을 누르면 현재 페이지의 매물 위치 정보를 토대로 약 하루동안 날씨 예보를 시각적 아이콘으로 파악할 수 있다.

## [ 5. 주변 관광 정보 조회 ]

![detail-near-tour-1.png](/Images/near/detail-near-tour-1.png)
![detail-near-tour-2.png](/Images/near/detail-near-tour-2.png)

중앙 상단의 관광지 버튼을 누르면 현재 페이지의 매물 위치 정보를 토대로 동일한 구군 지역의 관광지를 리스트 형태로 보여준다. 각 항목을 클릭하면 우측 화면에서 관련 상세 정보를 조회할 수 있다.

## [ 6. 교통 상황 조회]

![traffic-road.png](/Images/traffic/traffic-road.png)

교통상황 버튼을 클릭하면 해당 페이지로 넘어간다.
랜드마크 버튼을 클릭하면 해당 지역의 실시간 교통 상황을 보여준다.

## [ 7. 교통 상황 공유 게시판 ]

![traffic-road-board.png](/Images/traffic/traffic-road-board.png)
![traffic-road-board-success.png](/Images/traffic/traffic-road-board-success.png)
![traffic-road-board-write.png](/Images/traffic/traffic-road-board-write.png)
![traffic-road-board-write-after-modifyable.png](/Images/traffic/traffic-road-board-write-after-modifyable.png)

랜드마크의 게시글 버튼을 클릭하면 오른쪽에 사이드바와 함께 해당하는 지역의 게시글 목록을 출력한다.
각 게시판 별로 유저는 CRUD 기능을 이용할 수 있고 게시글을 클릭하면 내용이 출력된다.
작성일시가 함께 출력되므로 실시간으로 교통 정보를 공유할 수 있다.

## [ 8. 실시간 버스정류소 조회 ]

![traffic-road-bus.png](/Images/traffic/traffic-road-bus.png)
![traffic-road-bus-search.png](/Images/traffic/traffic-road-bus-search.png)
![traffic-road-bus-detail.png](/Images/traffic/traffic-road-bus-detail.png)
대전광역시 3072개의 정류소 정보를 슬라이드쇼 형태로 조회할 수 있다.
우측 상단의 검색창을 통해 원하는 키워드의 정류소만 모아서 볼 수 있다.
원하는 정류소를 클릭하면 상세 정보를 모달창으로 확인할 수 있다.

## [ 9. 지하철 역사 정보 조회 ]

![traffic-subway.png](/Images/traffic/traffic-subway.png)

![traffic-subway-detail.png](/Images/traffic/traffic-subway-detail.png)

대전시의 모든 도시철도 역사정보를 슬라이드쇼 형태로 확인할 수 있다.
원하는 역을 클릭하면 모달창으로 상세정보를 조회 가능하다.

## [ 10. 관심지역 설정 ]

![wish-add-1.png](/Images/wish/wish-add-1.png)
![wish-add-2.png](/Images/wish/wish-add-2.png)
![wish-add-3.png](/Images/wish/wish-add-3.png)

로그인을 하면 3번의 페이지에서 하트 버튼이 보인다. 빈 하트를 누르면 관심지역에 추가되고, 하트가 채워진다. 반대로 채워진 하트를 누르면 관심지역에서 삭제되고 하트가 비게 된다.
해당 내역은 11번 관심지역 랭킹에서 상세하게 확인할 수 있다.

## [ 11. 관심지역 랭킹과 주변 상권 리스트 ]

![wishrank-1.png](/Images/wish/wishrank-1.png)
![wishrank-2.png](/Images/wish/wishrank-2.png)

사용자가 설정한 상권 선호도 점수를 바탕으로 점수화하여 시상대와 차트 형태로 표현했다.
( = 선호상권 유/무 + 반경500m 해당 상권 개수)
1~3위 매물은 해당 정보를 클릭하면 주변 상권 목록을 키워드 별로 모아서 볼 수 있다.

## [ 12. 로그인/로그아웃/회원가입/회원탈퇴/마이페이지/정보수정 ]

![login-before.png](/Images/member/login-before.png)
![login-after.png](/Images/member/login-after.png)
![modify-1.png](/Images/member/modify-1.png)
![modify-alert-fail.png](/Images/member/modify-alert-fail.png)
![modify-alert-success.png](/Images/member/modify-alert-success.png)
![regist-alert-fail.png](/Images/member/regist-alert-fail.png)
![regist-alert-success.png](/Images/member/regist-alert-success.png)

jwt 토큰 방식으로 로그인하여 안정성을 비교적 높였다.
![login-refreshToken.png](/Images/member/login-refreshToken.png)
회원가입은 전용 페이지에서, 정보 수정과 회원 탈퇴는 마이페이지에서 가능하다.
![wishscore-modify.png](/Images/wish/wishscore-modify.png)
![wishscore-modify-after.png](/Images/wish/wishscore-modify-after.png)
![wishscore-modify-success.png](/Images/wish/wishscore-modify-success.png)
마이페이지 내에 있는 상권 선호도 정보를 통해 사용자가 점수를 커스터마이징 할 수 있다.

</div>
</details>

<br/>
<br/>

# 🔧 구현 기능

- **주택 실거래가**
  - 정보 수집 (아파트, 다가구주택, 오피스텔)
  - 검색 (아파트, 다가구주택, 오피스텔)
- **회원 및 로그인**
  - 회원가입, 회원탈퇴, 정보 수정
  - 로그인, 로그아웃
- **관심 지역**
  - 추가, 삭제
- **주변 상권**
  - 정보 수집
  - 업종 정보 검색 (8가지 대 분류)
- **주변 편의 기능**
  - 주변 날씨 정보 수집/출력
  - 주변 관광지 정보 수집/출력
  - 주요 지역 실시간 교통 상황
  - 실시간 교통 상황 공유 게시판 (글 쓰기, 수정, 읽기, 회원 전용)
  - 버스 정류소 실시간 버스 도착 정보 검색
  - 대전 지하철 역 상세 정보 확인
- **매물 추천**
  - 사용자에게 상권 선호 지수를 입력 받아 관심 지역 추천
  - 점수 기반 관심 지역 랭킹/차트 출력
    <br/>
    <br/>

# 💥 기술 스택

<img src="https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white"> 
<img src="https://img.shields.io/badge/Vue-4FC08D?style=for-the-badge&logo=Vue.js&logoColor=white">
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 
<img src="https://img.shields.io/badge/apachetomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black">

## 📡 사용한 API

![pppt6.PNG](/Images/ppt6.PNG)

## 산출물

---

### flow chart

![flowchart.png](/Images/flowchart.png)

### UseCase Diagram

![usecase.png](/Images/usecase.png)

### Class Diagram

<details>
<summary>Class Diagram</summary>
<div markdown="1">

### Member

![member.PNG](/Images/class_diagram/member.png)

### Board

![board.PNG](/Images/class_diagram/board.png)

### Traffic

![traffic.PNG](/Images/class_diagram/traffic.png)

### Wish

![wish.PNG](/Images/class_diagram/wish.png)

### Config

![config_cd.PNG](/Images/class_diagram/config_cd.png)

### Interceptor

![interceptor_cd.PNG](/Images/class_diagram/interceptor_cd.png)

### Exception

![exception_cd.PNG](/Images/class_diagram/exception_cd.png)

</div>
</details>

<br/>
<br/>

## 👏 팀원

---

![team.png](/Images/team.png)

- **[이현구](https://github.com/Leeh9)**
- **[서현경](https://github.com/nanalyee)**
