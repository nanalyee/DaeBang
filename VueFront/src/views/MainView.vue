<template>
  <div class="main">
    <!-- Header Start -->
    <div class="container-fluid bg-light my-6 mt-0" id="home">
      <div class="container">
        <div class="row g-5 pt-5 align-items-center">
          <div class="col-lg-6 text-end">
            <img class="img-fluid" src="@/assets/img/main_top.png" alt="" />
          </div>
          <div class="col-lg-6 py-6 pb-0 pt-lg-0">
            <h4 class="text-primary mb-3">대전 입문 안내 도우미</h4>
            <h1 class="display-3 mb-3">대방</h1>
            <h2 class="typed-text-output d-inline"></h2>
            <vue-typer
              class="fs-4"
              :text="[
                '아파트부터 오피스텔까지 다양한 매매 정보',
                '대전시 주요 교통 시설 정보와 실시간 정체 정도',
                '주택 위치 기반 나만의 관심 지역',
                '대전에 처음 적응하기 위한 필수 안내 도우미, 대방입니다.',
              ]"
              :repeat="Infinity"
              initial-action="typing"
              :pre-type-delay="100"
              :type-delay="100"
              :pre-erase-delay="1500"
              :erase-delay="250"
              erase-style="clear"
              :erase-on-complete="false"
              caret-animation="blink"
            >
            </vue-typer>
            <div class="d-flex align-items-center pt-5">
              <a href="" class="btn btn-primary py-3 px-4 me-5">Sign In</a>
              <!-- <button @click="modalShow = !modalShow">Open Modal</b-button> -->
              <b-button @click="show" type="button" class="btn-play">
                <span></span>
              </b-button>
              <h5 class="ms-4 mb-0 d-none d-sm-block">Play Video</h5>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Header End -->

    <!-- Video Modal Start -->
    <b-modal v-model="modalShow" hide-footer title="Using Component Methods">
      <div class="d-block text-center">
        <h3>Hello From My Modal!</h3>
      </div>
      <iframe
        width="300"
        height="200"
        src="https://www.youtube.com/embed/PYNvQIJ2cuM?controls=2&amp;showinfo=0&amp;modestbranding=1"
        title="[KPOP Playlist] 요즘 듣는 케이팝 노동요"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
        allowfullscreen
      ></iframe>
    </b-modal>
    <!-- Video Modal End -->

    <!-- 소개 시작 -->

    <div class="container-xxl py-6 pt-5" id="project">
      <div class="container">
        <div class="row g-5 mb-5 wow fadeInUp" data-wow-delay="0.1s">
          <div class="col-lg-6">
            <h1 class="display-7 mb-0">대방은 다양한 데이터를 바탕으로</h1>
            <h1 class="display-7 mb-0">최적의 결과를 보여드려요.</h1>
          </div>
          <div class="col-lg-6 text-lg-end">
            <!-- <a class="btn btn-primary py-3 px-5" href="">Hire Me</a> -->
          </div>
        </div>
        <div class="row g-4 mt-5">
          <div class="col-lg-5 wow fadeInUp" data-wow-delay="0.1s">
            <img class="rounded" src="@/assets/img/gif/td1.gif" alt="" style="width: 500px; height: 300px" />
          </div>
          <div class="col-lg-5 wow fadeInUp" data-wow-delay="0.1s">
            <h1 class="fs-2 mb-0" id="mainintroduce">대전이 처음이라 어려우신가요?</h1>
          </div>
        </div>
        <div class="row g-4 mt-5" style="margin-top: 30px">
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <h1 class="fs-2 mb-0" id="mainintroduce">걱정하지 마세요.</h1>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <img class="rounded" src="@/assets/img/gif/td2.gif" alt="" style="width: 500px; height: 300px" />
          </div>
        </div>
        <div class="row g-4 mt-5" style="margin-top: 30px">
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <img class="rounded" src="@/assets/img/gif/td3.gif" alt="" style="width: 500px; height: 300px" />
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <h1 class="fs-2 mb-0" id="mainintroduce">제가 당신의 이정표가 되어드릴게요.</h1>
          </div>
        </div>
      </div>
    </div>
    <!-- 소개 끝 -->

    <!-- 서비스 소개 시작 -->
    <div class="container-fluid bg-light my-5 py-6" id="service">
      <div class="container">
        <div class="row g-5 mb-5 wow fadeInUp" data-wow-delay="0.1s">
          <div class="col-lg-6">
            <h1 class="display-5 mb-0">서비스 소개</h1>
          </div>
          <div class="col-lg-6 text-lg-end">
            <!-- <a class="btn btn-primary py-3 px-5" href="">Hire Me</a> -->
          </div>
        </div>
        <div class="row g-4">
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
              <div class="bg-icon flex-shrink-0 mb-3">
                <img class="img-fluid rounded" src="@/assets/img/main/apartment.png" alt="" />
              </div>
              <div class="ms-sm-4">
                <h4 class="mb-3">전/월세 거래 기록검색</h4>
                <!-- <h6 class="mb-3">Start from <span class="text-primary">$199</span></h6> -->
                <span>
                  아파트, 오피스텔, 원룸, 빌라의 전, 월세 거래 정보를 알려드립니다. 여러분이 지정한 필터에 맞춰 거래된
                  상세 정보 및 위치를 조회할 수 있습니다.
                </span>
              </div>
            </div>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s">
            <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
              <div class="bg-icon flex-shrink-0 mb-3">
                <img class="img-fluid rounded" src="@/assets/img/main/comment.png" alt="" />
              </div>
              <div class="ms-sm-4">
                <h4 class="mb-3">관심 지역 추천 서비스</h4>
                <span
                  >사용자가 선택한 상권 선호도에 맞춰 관심 지역 순위를 정해드립니다. 고르기 어렵다면 도움을
                  받아보세요.</span
                >
              </div>
            </div>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
              <div class="bg-icon flex-shrink-0 mb-3">
                <img class="img-fluid rounded" src="@/assets/img/main/live.png" alt="" />
              </div>
              <div class="ms-sm-4">
                <h4 class="mb-3">실시간 교통 정보</h4>
                <span> 주요 지역의 도로 상황, 실시간 버스 도착 정보, 지하철 역사 정보를 제공합니다.</span>
                <span> 게시판을 이용해 다른 사용자와 교통 상황을 공유해 보세요!</span>
              </div>
            </div>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s">
            <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
              <div class="bg-icon flex-shrink-0 mb-3">
                <img class="img-fluid rounded" src="@/assets/img/main/travel-guide.png" alt="" />
              </div>
              <div class="ms-sm-4">
                <h4 class="mb-3">상권, 날씨, 관광지</h4>
                <span
                  >여러분이 원하는 매물을 선택하면 해당 지역의 상권 정보, 날씨를 알려드립니다. <br />주변의 관광지도
                  둘러보세요!</span
                >
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 서비스 소개 끝 -->

    <!-- About Start -->
    <div class="container-xxl py-6" id="about">
      <div class="container">
        <div class="row g-5 wow fadeInUp" data-wow-delay="0.1s">
          <div class="col-lg-6">
            <h1 class="display-5 mb-0">공공데이터</h1>
          </div>
          <!-- <div class="col-lg-6 text-lg-end">
            <a class="btn btn-primary py-3 px-5" href="https://www.data.go.kr/">공공데이터 포털</a>
          </div> -->
        </div>
        <div class="row g-5 m-0">
          <div class="col-auto mb-5 mr-4 p-0">
            <div class="fs-4 text-center mb-4">사용 API</div>
            <div class="years flex-shrink-0 text-center">
              <div class="display-1 mb-0 text-primary">12</div>
            </div>
          </div>
          <div class="col ml-4">
            <!-- API 캐러셀 시작   -->
            <div id="carouselAPI" class="carousel carousel-dark slide" data-ride="carousel">
              <ol class="carousel-indicators">
                <li id="indicator" data-target="#carouselAPI" data-slide-to="0" class="active"></li>
                <li id="indicator" data-target="#carouselAPI" data-slide-to="1"></li>
                <li id="indicator" data-target="#carouselAPI" data-slide-to="2"></li>
              </ol>

              <div class="carousel-inner">
                <div id="carousel_api_speed" class="carousel-item active rounded">
                  <div class="row g-4">
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                      <div class="d-flex align-items-center mb-3">
                        <h3 class="border-end pe-3 me-3 mb-0">아파트 전,월세 거래자료</h3>
                        <h2 class="text-primary fw-bold mb-0 fs-4" data-toggle="counter-up">2018-2022</h2>
                      </div>
                      <p class="mb-4">부동산 거래신고에 관한 법률에 따라 신고된 주택의 실거래 자료를 제공</p>
                      <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>국토교통부</p>
                    </div>
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                      <div class="d-flex align-items-center mb-3">
                        <h3 class="border-end pe-3 me-3 mb-0">다세대주택 전,월세 거래자료</h3>
                        <h2 class="text-primary fw-bold mb-0 fs-4" data-toggle="counter-up">2018-2022</h2>
                      </div>
                      <p class="mb-4">부동산 거래신고에 관한 법률에 따라 신고된 주택의 실거래 자료를 제공</p>
                      <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>국토교통부</p>
                    </div>
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                      <div class="d-flex align-items-center mb-3">
                        <h3 class="border-end pe-3 me-3 mb-0">오피스텔 전,월세 거래자료</h3>
                        <h2 class="text-primary fw-bold mb-0 fs-4" data-toggle="counter-up">2018-2022</h2>
                      </div>
                      <p class="mb-4">부동산 거래신고에 관한 법률에 따라 신고된 주택의 실거래 자료를 제공</p>
                      <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>국토교통부</p>
                    </div>
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                      <div class="d-flex align-items-center mb-3">
                        <h3 class="border-end pe-3 me-3 mb-0">다가구주택 전,월세 거래자료</h3>
                        <h2 class="text-primary fw-bold mb-0 fs-4" data-toggle="counter-up">2018-2022</h2>
                      </div>
                      <p class="mb-4">부동산 거래신고에 관한 법률에 따라 신고된 주택의 실거래 자료를 제공</p>
                      <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>국토교통부</p>
                    </div>
                  </div>
                </div>
                <div id="carousel_api_speed" class="carousel-item">
                  <div class="row g-4">
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
                      <div class="d-flex align-items-center mb-3">
                        <h3 class="border-end pe-3 me-3 mb-0">상가(상권)정보</h3>
                        <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">100</h2>
                      </div>
                      <p class="mb-4">소상공인 상권정보 조회 당 최대 100건 상권내 상가업소 조회 <br /></p>
                      <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>소상공인시장진흥공단</p>
                    </div>
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                      <div class="d-flex align-items-center mb-3">
                        <h3 class="border-end pe-3 me-3 mb-0">자동차 길찾기</h3>
                        <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">LIVE</h2>
                      </div>
                      <p class="mb-4">하나의 출발지에서 하나의 목적지까지로의 경로에 대한 상세 정보</p>
                      <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>KAKAO MOBILITY</p>
                    </div>
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                      <div class="d-flex align-items-center mb-3">
                        <h3 class="border-end pe-3 me-3 mb-0">카테고리로 장소 검색하기</h3>
                        <h2 class="text-primary fw-bold mb-0 fs-4" data-toggle="counter-up">8개 카테고리</h2>
                      </div>
                      <p class="mb-4">카테고리 코드에 해당하는 장소 검색 결과를 지정된 정렬 기준에 따라 제공</p>
                      <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>KAKAO</p>
                    </div>
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                      <div class="d-flex align-items-center mb-3">
                        <h3 class="border-end pe-3 me-3 mb-0 fs-4">정류소별 도착정보 조회 서비스</h3>
                        <h2 class="text-primary fw-bold mb-0 fs-4" data-toggle="counter-up">3072개 정류소</h2>
                      </div>
                      <p class="mb-4 fs-8">버스정보시스템 - 도착예정정보,정류소정보, 노선정보, 운수사정보, 차량정보</p>
                      <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>공공교통정책과</p>
                    </div>
                  </div>
                </div>

                <div id="carousel_api_speed" class="carousel-item">
                  <div class="row g-4">
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                      <div class="d-flex align-items-center mb-3">
                        <h3 class="border-end pe-3 me-3 mb-0">역사정보</h3>
                        <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">22개 역사</h2>
                      </div>
                      <p class="mb-4">대전 도시철도의 역사정보</p>
                      <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>대전교통공사</p>
                    </div>
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                      <div class="d-flex align-items-center mb-3">
                        <h3 class="border-end pe-3 me-3 mb-0">문화관광(관광지)</h3>
                        <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">127개 관광지</h2>
                      </div>
                      <p class="mb-4">문화관광 (관광지) 정보</p>
                      <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>스마트도시과</p>
                    </div>
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                      <div class="d-flex align-items-center mb-3">
                        <h3 class="border-end pe-3 me-3 mb-0">단기예보 조회서비스</h3>
                        <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">LIVE</h2>
                      </div>
                      <p class="mb-4">초단기실황, 초단기예보, 단기예보, 예보버전 정보를 조회하는 서비스</p>
                      <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>기상청</p>
                    </div>
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                      <div class="d-flex align-items-center mb-3">
                        <h3 class="border-end pe-3 me-3 mb-0">이미지 검색</h3>
                        <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">LIVE</h2>
                      </div>
                      <p class="mb-4">다음 검색 서비스에서 질의어로 이미지를 검색합니다.</p>
                      <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>KAKAO</p>
                    </div>
                  </div>
                </div>
              </div>

              <button
                id="carousel-control-prev"
                class="carousel-control-prev"
                type="button"
                data-target="#carouselAPI"
                data-slide="prev"
              >
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
              </button>
              <button
                id="carousel-control-next"
                class="carousel-control-next"
                type="button"
                data-target="#carouselAPI"
                data-slide="next"
              >
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
              </button>
            </div>

            <!-- API 캐러셀 끝   -->
          </div>

          <!-- <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="d-flex align-items-center mb-3">
              <h3 class="border-end pe-3 me-3 mb-0">아파트 전,월세 거래자료</h3>
              <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">2018-2022</h2>
            </div>
            <p class="mb-4">부동산 거래신고에 관한 법률에 따라 신고된 주택의 실거래 자료를 제공</p>
            <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>국토교통부</p>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="d-flex align-items-center mb-3">
              <h3 class="border-end pe-3 me-3 mb-0">다세대주택 전,월세 거래자료</h3>
              <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">2018-2022</h2>
            </div>
            <p class="mb-4">부동산 거래신고에 관한 법률에 따라 신고된 주택의 실거래 자료를 제공</p>
            <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>국토교통부</p>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="d-flex align-items-center mb-3">
              <h3 class="border-end pe-3 me-3 mb-0">오피스텔 전,월세 거래자료</h3>
              <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">2018-2022</h2>
            </div>
            <p class="mb-4">부동산 거래신고에 관한 법률에 따라 신고된 주택의 실거래 자료를 제공</p>
            <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>국토교통부</p>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="d-flex align-items-center mb-3">
              <h3 class="border-end pe-3 me-3 mb-0">다가구주택 전,월세 거래자료</h3>
              <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">2018-2022</h2>
            </div>
            <p class="mb-4">부동산 거래신고에 관한 법률에 따라 신고된 주택의 실거래 자료를 제공</p>
            <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>국토교통부</p>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
            <div class="d-flex align-items-center mb-3">
              <h3 class="border-end pe-3 me-3 mb-0">상가(상권)정보</h3>
              <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">100</h2>
            </div>
            <p class="mb-4">
              소상공인 상권정보 상가업소 공공 데이터 기반<br />
              조회 당 최대 100건 상권내 상가업소 조회 가능
            </p>
            <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>소상공인시장진흥공단</p>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="d-flex align-items-center mb-3">
              <h3 class="border-end pe-3 me-3 mb-0">자동차 길찾기</h3>
              <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">LIVE</h2>
            </div>
            <p class="mb-4">하나의 출발지에서 하나의 목적지까지로의 경로에 대한 상세 정보</p>
            <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>KAKAO MOBILITY</p>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="d-flex align-items-center mb-3">
              <h3 class="border-end pe-3 me-3 mb-0">카테고리로 장소 검색하기</h3>
              <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">8개 카테고리</h2>
            </div>
            <p class="mb-4">정의된 카테고리 코드에 해당하는 장소 검색 결과를 지정된 정렬 기준에 따라 제공</p>
            <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>KAKAO</p>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="d-flex align-items-center mb-3">
              <h3 class="border-end pe-3 me-3 mb-0">정류소별 도착정보 조회 서비스</h3>
              <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">3072개 정류소</h2>
            </div>
            <p class="mb-4">버스정보시스템 정보(도착예정정보,정류소정보, 노선정보, 운수사정보, 차량정보)</p>
            <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>공공교통정책과</p>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="d-flex align-items-center mb-3">
              <h3 class="border-end pe-3 me-3 mb-0">역사정보</h3>
              <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">22개 역사</h2>
            </div>
            <p class="mb-4">대전 도시철도의 역사정보</p>
            <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>대전교통공사</p>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="d-flex align-items-center mb-3">
              <h3 class="border-end pe-3 me-3 mb-0">문화관광(관광지)</h3>
              <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">127개 관광지</h2>
            </div>
            <p class="mb-4">문화관광 (관광지) 정보</p>
            <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>스마트도시과</p>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="d-flex align-items-center mb-3">
              <h3 class="border-end pe-3 me-3 mb-0">단기예보 조회서비스</h3>
              <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">LIVE</h2>
            </div>
            <p class="mb-4">초단기실황, 초단기예보, 단기예보, 예보버전 정보를 조회하는 서비스</p>
            <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>기상청</p>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="d-flex align-items-center mb-3">
              <h3 class="border-end pe-3 me-3 mb-0">이미지 검색</h3>
              <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">LIVE</h2>
            </div>
            <p class="mb-4">다음 검색 서비스에서 질의어로 이미지를 검색합니다.</p>
            <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>KAKAO</p>
          </div> -->
        </div>
      </div>
    </div>
    <!-- About End -->

    <!-- Team Start -->
    <div class="container-fluid bg-light mt-5 py-6" id="team">
      <div class="container">
        <div class="row g-5 mb-5 wow fadeInUp" data-wow-delay="0.1s">
          <div class="col-lg-6">
            <h1 class="display-5 mx-2 mb-0">팀원</h1>
          </div>
          <div class="col-lg-6 text-lg-end">
            <a class="btn btn-primary py-3 px-5" href="">Git Hub</a>
          </div>
        </div>
        <div class="row g-4 justify-content-center">
          <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="team-item position-relative">
              <img class="img-fluid rounded" src="@/assets/img/hyungu.jpg" alt="" />
              <div class="team-text bg-white rounded-end p-4">
                <div>
                  <h5>이현구</h5>
                  <span>Developer</span>
                </div>
                <i class="fa fa-arrow-right fa-2x text-primary" onclick="window.open('https://github.com/Leeh9')"></i>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
            <div class="team-item position-relative">
              <img class="img-fluid rounded" src="@/assets/img/hyunkyung.jpg" alt="" />
              <div class="team-text bg-white rounded-end p-4">
                <div>
                  <h5>서현경</h5>
                  <span>Developer</span>
                </div>
                <i
                  class="fa fa-arrow-right fa-2x text-primary"
                  onclick="window.open('https://github.com/nanalyee')"
                ></i>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Team End -->
  </div>
</template>

<script>
export default {
  name: "AppMain",
  components: {},
  data() {
    return {
      modalShow: false,
      photoModalShow: false,
      photolink: "preview6.png",
    };
  },
  methods: {
    show() {
      console.log("show");
      this.modalShow = !this.modalShow;
    },
    photoshow(link) {
      console.log("photoshow");
      this.photolink = link;
      this.photoModalShow = !this.photoModalShow;
    },
  },
};
</script>

<style>
#carousel_api_speed {
  transition: 0s !important;
}

#mainintroduce {
  margin-top: 140px;
  /* line-height: middle; */
  text-align: center;
}

#carouselAPI .carousel-indicators {
  margin-bottom: -4em !important;
}

/* #carouselAPI ol li {
  background-color: #d4a817 !important;
  width: 22px;
  height: 22px;
  margin: 12px;
  letter-spacing: 0.5px !important;
} */
</style>
