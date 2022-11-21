<template>
  <div class="main">
    <!-- Header Start -->
    <div class="container-fluid bg-light my-6 mt-0" id="home">
      <div class="container">
        <div class="row g-5 pt-5 align-items-center">
          <div class="col-lg-6">
            <img class="img-fluid text-center" src="@/assets/img/main_top.png" alt="" />
          </div>
          <div class="col-lg-6 py-6 pb-0 pt-lg-0">
            <h4 class="text-primary mb-3">대전 입문 안내 도우미</h4>
            <h1 class="display-3 mb-3">대방</h1>
            <h2 class="typed-text-output d-inline"></h2>
            <div class="typed-text">
              아파트부터 오피스텔까지 다양한 매매 정보<br />
              대전시 주요 교통 시설 정보와 실시간 정체 정도<br />
              주택 위치 기반 나만의 관심 지역 <br />
              대전에 처음 적응하기 위한 필수 안내 도우미, 대방입니다. <br />
            </div>
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

    <!-- 미리보기 시작 -->
    <div class="container-xxl py-6 pt-5" id="project">
      <div class="container">
        <div class="row g-5 mb-5 align-items-center wow fadeInUp" data-wow-delay="0.1s">
          <div class="col-lg-6">
            <h1 class="display-5 mb-0">대방 미리보기</h1>
          </div>
          <div class="col-lg-6 text-lg-end">
            <ul class="list-inline mx-n3 mb-0" id="portfolio-flters">
              <li class="mx-3 active" data-filter="*">All Projects</li>
              <li class="mx-3" data-filter=".first">Home Search</li>
              <li class="mx-3" data-filter=".second">Board List</li>
            </ul>
          </div>
        </div>
        <div class="row g-4 portfolio-container wow fadeInUp" data-wow-delay="0.1s">
          <div class="col-lg-4 portfolio-item first">
            <div class="border portfolio-img rounded overflow-hidden">
              <img class="img-fluid" src="@/assets/img/preview1.png" alt="" />
              <div class="portfolio-btn">
                <a
                  @click="photoshow('preview1.png')"
                  type="button"
                  class="btn btn-lg-square btn-outline-secondary border-2 mx-1"
                >
                  <i class="bi bi-eye-fill"></i>
                </a>
                <!-- <a
                  class="btn btn-lg-square btn-outline-secondary border-2 mx-1"
                  href="@/assets/img/preview2.png"
                  data-lightbox="portfolio"
                >
                  <i class="bi bi-eye-fill"></i>
                </a> -->
                <a class="btn btn-lg-square btn-outline-secondary border-2 mx-1" href=""><i class="bi bi-link"></i></a>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 portfolio-item second">
            <div class="border portfolio-img rounded overflow-hidden">
              <img class="img-fluid" src="@/assets/img/preview2.png" alt="" />
              <div class="portfolio-btn">
                <a
                  @click="photoshow('preview2.png')"
                  type="button"
                  class="btn btn-lg-square btn-outline-secondary border-2 mx-1"
                >
                  <i class="bi bi-eye-fill"></i>
                </a>
                <!-- <a
                  class="btn btn-lg-square btn-outline-secondary border-2 mx-1"
                  href="@/assets/img/preview2.png"
                  data-lightbox="portfolio"
                  ><i class="bi bi-eye-fill"></i
                ></a> -->
                <a class="btn btn-lg-square btn-outline-secondary border-2 mx-1" href=""><i class="bi bi-link"></i></a>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 portfolio-item first">
            <div class="border portfolio-img rounded overflow-hidden">
              <img class="img-fluid" src="@/assets/img/preview3.png" alt="" />
              <div class="portfolio-btn">
                <a
                  @click="photoshow('preview3.png')"
                  type="button"
                  class="btn btn-lg-square btn-outline-secondary border-2 mx-1"
                >
                  <i class="bi bi-eye-fill"></i>
                </a>
                <!-- <a
                  class="btn btn-lg-square btn-outline-secondary border-2 mx-1"
                  href="@/assets/img/preview3.png"
                  data-lightbox="portfolio"
                  ><i class="bi bi-eye-fill"></i
                ></a> -->
                <a class="btn btn-lg-square btn-outline-secondary border-2 mx-1" href=""><i class="bi bi-link"></i></a>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 portfolio-item second">
            <div class="border portfolio-img rounded overflow-hidden">
              <img class="img-fluid" src="@/assets/img/preview4.png" alt="" />
              <div class="portfolio-btn">
                <a
                  @click="photoshow('preview4.png')"
                  type="button"
                  class="btn btn-lg-square btn-outline-secondary border-2 mx-1"
                >
                  <i class="bi bi-eye-fill"></i>
                </a>
                <!-- <a
                  class="btn btn-lg-square btn-outline-secondary border-2 mx-1"
                  href="@/assets/img/preview4.png"
                  data-lightbox="portfolio"
                  ><i class="bi bi-eye-fill"></i
                ></a> -->
                <a class="btn btn-lg-square btn-outline-secondary border-2 mx-1" href=""><i class="bi bi-link"></i></a>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 portfolio-item first">
            <div class="border portfolio-img rounded overflow-hidden">
              <img class="img-fluid" src="@/assets/img/preview5.png" alt="" />
              <div class="portfolio-btn">
                <a
                  @click="photoshow('preview5.png')"
                  type="button"
                  class="btn btn-lg-square btn-outline-secondary border-2 mx-1"
                >
                  <i class="bi bi-eye-fill"></i>
                </a>
                <!-- <a
                  class="btn btn-lg-square btn-outline-secondary border-2 mx-1"
                  href="@/assets/img/preview5.png"
                  data-lightbox="portfolio"
                  ><i class="bi bi-eye-fill"></i
                ></a> -->
                <a class="btn btn-lg-square btn-outline-secondary border-2 mx-1" href=""><i class="bi bi-link"></i></a>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 portfolio-item second">
            <div class="border portfolio-img rounded overflow-hidden">
              <img class="img-fluid" src="@/assets/img/preview6.png" alt="" />
              <div class="portfolio-btn">
                <a
                  @click="photoshow('preview6.png')"
                  type="button"
                  class="btn btn-lg-square btn-outline-secondary border-2 mx-1"
                >
                  <i class="bi bi-eye-fill"></i>
                </a>
                <!-- <a
                  class="btn btn-lg-square btn-outline-secondary border-2 mx-1"
                  href="@/assets/img/preview6.png"
                  data-lightbox="portfolio"
                  ><i class="bi bi-eye-fill"></i
                ></a> -->
                <a class="btn btn-lg-square btn-outline-secondary border-2 mx-1" href=""><i class="bi bi-link"></i></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 미리보기 끝 -->

    <!-- photo Modal Start -->
    <b-modal v-model="photoModalShow" hide-footer hide-header centered>
      <div class="d-block text-center">
        <h3>Hello From My Modal!222</h3>
      </div>
      <div>
        <b-img :src="require(`@/assets/img/${photolink}`)" fluid alt="Fluid image"></b-img>
      </div>
    </b-modal>
    <!-- photo Modal End -->

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
                <img class="img-fluid rounded" src="@/assets/img/apartment.png" alt="" />
              </div>
              <div class="ms-sm-4">
                <h4 class="mb-3">전국 아파트 매매 검색</h4>
                <!-- <h6 class="mb-3">Start from <span class="text-primary">$199</span></h6> -->
                <span>
                  아파트 매매 공공 데이터를 활용해 사용자가 지정한 시도, 구, 동, 기간에 거래된 상세 정보 및 위치를
                  조회할 수 있습니다.
                </span>
              </div>
            </div>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s">
            <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
              <div class="bg-icon flex-shrink-0 mb-3">
                <img class="img-fluid rounded" src="@/assets/img/community.png" alt="" />
              </div>
              <div class="ms-sm-4">
                <h4 class="mb-3">커뮤니티</h4>
                <span> 회원가입 후 로그인을 통해 자유롭게 글을 올리고 읽는 커뮤니티 기능을 제공합니다. </span>
              </div>
            </div>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
              <div class="bg-icon flex-shrink-0 mb-3">
                <img class="img-fluid rounded" src="@/assets/img/commercial.png" alt="" />
              </div>
              <div class="ms-sm-4">
                <h4 class="mb-3">지정 지역 내 상권 조회</h4>
                <span
                  >사용자가 선택한 유형 상권으로 필터링 된 정보를 가져옵니다. 지정한 지역을 기준으로 반경 1km 내의
                  상권을 조회할 수 있습니다.</span
                >
              </div>
            </div>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s">
            <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
              <div class="bg-icon flex-shrink-0 mb-3">
                <img class="img-fluid rounded" src="@/assets/img/favorite.png" alt="" />
              </div>
              <div class="ms-sm-4">
                <h4 class="mb-3">즐겨찾기</h4>
                <span
                  >사용자는 원하는 매물을 즐겨찾기에 등록할 수 있습니다. 언제든지 등록한 매물을 편리하게 확인할 수
                  있습니다.</span
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
        <div class="row g-5 mb-5 wow fadeInUp" data-wow-delay="0.1s">
          <div class="col-lg-6">
            <h1 class="display-5 mb-0">공공데이터</h1>
          </div>
          <div class="col-lg-6 text-lg-end">
            <a class="btn btn-primary py-3 px-5" href="https://www.data.go.kr/">공공데이터 포털</a>
          </div>
        </div>
        <div class="row g-5">
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <!-- <div class="d-flex align-items-center mb-5">
                        <div class="years flex-shrink-0 text-center me-4">
                            <h1 class="display-1 mb-0">5</h1>
                            <h5 class="mb-0">Years</h5>
                        </div>
                        <h3 class="lh-base mb-0">2015~2020년간<br> 전국 아파트 실거래 <br> 공공데이터 사용</h3>
                    </div>
                    <p class="mb-4">부동산 거래신고에 관한 법률에 따라 신고된 주택의 실거래 자료</p>
                    <p class="mb-3"><i class="far fa-check-circle text-primary me-3"></i>국토교통부</p>
                    <p class="mb-3"><i class="far fa-check-circle text-primary me-3"></i>High Quality Product</p>
                    <p class="mb-3"><i class="far fa-check-circle text-primary me-3"></i>On Time Project Delivery</p>
                    <a class="btn btn-primary py-3 px-5 mt-3" href="">Read More</a> -->
            <div class="d-flex align-items-center mb-3">
              <h3 class="border-end pe-3 me-3 mb-0">아파트매매 실거래자료</h3>
              <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">68827</h2>
            </div>
            <p class="mb-4">
              부동산 거래신고에 관한 법률에 따라 신고된 주택의 68827건의 실거래 자료<br />시,도,행정동 구역별 정해진
              기간 조회 가능
            </p>
            <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>국토교통부</p>
          </div>
          <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
            <!-- <div class="row g-3 mb-4">
                        <div class="col-sm-6">
                            <img class="img-fluid rounded" src="${root}/img/about-1.jpg" alt="">
                        </div>
                        <div class="col-sm-6">
                            <img class="img-fluid rounded" src="${root}/img/about-2.jpg" alt="">
                        </div>
                    </div> -->
            <div class="d-flex align-items-center mb-3">
              <h3 class="border-end pe-3 me-3 mb-0">소상공인시장 상가(상권)정보</h3>
              <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">1000</h2>
            </div>
            <p class="mb-4">
              소상공인 상권정보 상가업소 공공 데이터 기반<br />
              조회 당 최대 1000건 상권내 상가업소 조회 가능
            </p>
            <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>소상공인시장진흥공단</p>
          </div>
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
