<template>
  <div class="main">
    <!-- Header Start -->
    <div class="container-fluid bg-light my-3 py-3 mt-0" id="home">
      <div class="container">
        <div id="bannerIndicators" class="carousel slide" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#bannerIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#bannerIndicators" data-slide-to="1"></li>
            <li data-target="#bannerIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner">
            <div class="carousel-item active">
              <div class="row g-5 align-items-center" style="height: 500px">
                <div class="col-lg-6 pt-5 pb-5 text-end">
                  <img
                    class="img-fluid"
                    src="@/assets/img/gif/car.gif"
                    style="width: 500px"
                    alt=""
                  />
                </div>
                <div class="col-lg-6 py-6 pb-0 pt-lg-0">
                  <img src="@/assets/img/live.gif" alt="" id="live" />
                  <!-- <h4 class="text-primary mb-3">LIVE</h4> -->
                  <br />
                  <br />
                  <h1 class="display-5 mb-3">실시간 주요 교통 상황</h1>
                  <h2 class="typed-text-output d-inline"></h2>
                  <div class="typed-text">
                    대전시 주요 경유 지역의 도로 정체 정도가 궁금하신가요?<br />
                    실시간 교통 상황을 확인하고 다른 사용자와 공유해보세요.<br />
                  </div>
                  <div class="d-flex align-items-center pt-5">
                    <!-- <button @click="modalShow = !modalShow">Open Modal</b-button> -->
                    <!-- <b-button @click="show" type="button" class="btn-play"> -->
                    <b-button type="button" class="btn-play">
                      <span></span>
                    </b-button>
                    <h5 class="ms-4 mb-0 d-none d-sm-block">소개영상</h5>
                  </div>
                </div>
              </div>
            </div>
            <div class="carousel-item">
              <div class="row g-5 pt-5 pb-5 align-items-center" style="height: 500px">
                <div class="col-lg-6 pt-5 pb-5 pr-5 text-end">
                  <img
                    class="img-fluid"
                    src="@/assets/img/gif/busrun.gif"
                    style="width: 400px"
                    alt=""
                  />
                </div>
                <div class="col-lg-6 py-6 pb-0 pt-lg-0">
                  <img src="@/assets/img/live.gif" alt="" id="live" />
                  <!-- <h4 class="text-primary mb-3">LIVE</h4> -->
                  <br />
                  <br />
                  <h1 class="display-5 mb-3">실시간 버스 정류소 조회</h1>
                  <h2 class="typed-text-output d-inline"></h2>
                  <div class="typed-text">
                    정류장에 어떤 버스가 얼마나 자주오는지 궁금하신가요?<br />
                    3072개의 정류소의 실시간 노선 정보를 검색해보세요.<br />
                  </div>
                  <div class="d-flex align-items-center pt-5">
                    <!-- <button @click="modalShow = !modalShow">Open Modal</b-button> -->
                    <!-- <b-button @click="show" type="button" class="btn-play"> -->
                    <b-button type="button" class="btn-play">
                      <span></span>
                    </b-button>
                    <h5 class="ms-4 mb-0 d-none d-sm-block">소개영상</h5>
                  </div>
                </div>
              </div>
            </div>
            <div class="carousel-item">
              <div class="row g-5 align-items-center" style="height: 500px">
                <div class="col-lg-6 pt-2 pb-5 pr-5 text-end">
                  <img
                    class="img-fluid"
                    src="@/assets/img/subway.png"
                    style="width: 400px"
                    alt=""
                  />
                </div>
                <div class="col-lg-6 py-6 pb-0 pt-lg-0">
                  <h4 class="text-primary mb-3">대전교통공사 공공데이터 기반</h4>
                  <h1 class="display-5 mb-3">도시철도 역사 정보</h1>
                  <h2 class="typed-text-output d-inline"></h2>
                  <div class="typed-text">
                    대전 도시철도의 역사 정보 궁금하신가요?<br />
                    대전교통공사에서 제공하는 상세 정보를 확인해보세요.<br />
                  </div>
                  <div class="d-flex align-items-center pt-5">
                    <!-- <button @click="modalShow = !modalShow">Open Modal</b-button> -->
                    <!-- <b-button @click="show" type="button" class="btn-play"> -->
                    <b-button type="button" class="btn-play">
                      <span></span>
                    </b-button>
                    <h5 class="ms-4 mb-0 d-none d-sm-block">소개영상</h5>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <a class="carousel-control-prev" href="#bannerIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#bannerIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
      </div>
    </div>
    <!-- Header End -->

    <!-- Video Modal Start -->
    <b-modal v-model="modalShow" hide-footer title="교통 상황 시연 영상">
      <!-- <div class="d-block text-center">
        <h3>교통 상황 시연 영상</h3>
      </div> -->
      <p align="middle">
        <iframe
          width="300"
          height="200"
          src="https://www.youtube.com/embed/PYNvQIJ2cuM?controls=2&amp;showinfo=0&amp;modestbranding=1"
          title="[KPOP Playlist] 요즘 듣는 케이팝 노동요"
          frameborder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          allowfullscreen
        ></iframe>
      </p>
    </b-modal>
    <!-- Video Modal End -->

    <!-- 교통상황 시작 -->
    <div class="container-xxl mt-3 pt-5" id="project">
      <div class="container mt-3 py-5">
        <div class="row g-5 mb-5 align-items-center wow fadeInUp" data-wow-delay="0.1s">
          <div class="col-lg-12">
            <h3 class="display-5 mb-0">
              실시간 주요 교통 상황<img
                src="@/assets/img/live_state.gif"
                alt=""
                id="img_live_state"
              />
            </h3>
          </div>
          <div class="row pt-4 justify-content-between">
            <div class="col-lg-6 row pl-4">
              <div class="col-auto pr-0">
                <router-link :to="{ name: 'daejeonStation' }" class="btn btn-primary"
                  >대전역</router-link
                >
              </div>
              <div class="col-auto pr-0">
                <router-link :to="{ name: 'yuseongStation' }" class="btn btn-primary"
                  >유성온천역</router-link
                >
              </div>
              <div class="col-auto pr-0">
                <router-link :to="{ name: 'noeunStation' }" class="btn btn-primary"
                  >노은역</router-link
                >
              </div>
              <div class="col-auto pr-0">
                <router-link :to="{ name: 'hanbatUniv' }" class="btn btn-primary"
                  >한밭대</router-link
                >
              </div>
            </div>
            <div class="col-lg-6 text-lg-end align-self-end">
              <ul class="list-inline mx-n3 mb-0" id="portfolio-flters">
                <img
                  class="img-fluid text-center"
                  src="@/assets/img/traffic_state0.png"
                  alt=""
                  id="img_traffic_state"
                />
                <li class="mx-3" data-filter="*">정보 없음</li>
                <img
                  class="img-fluid text-center"
                  src="@/assets/img/traffic_state1.png"
                  alt=""
                  id="img_traffic_state"
                />
                <li class="mx-3" data-filter=".first">정체</li>
                <img
                  class="img-fluid text-center"
                  src="@/assets/img/traffic_state2.png"
                  alt=""
                  id="img_traffic_state"
                />
                <li class="mx-3" data-filter=".second">지체</li>
                <img
                  class="img-fluid text-center"
                  src="@/assets/img/traffic_state3.png"
                  alt=""
                  id="img_traffic_state"
                />
                <li class="mx-3" data-filter=".second">서행</li>
                <img
                  class="img-fluid text-center"
                  src="@/assets/img/traffic_state4.png"
                  alt=""
                  id="img_traffic_state"
                />
                <li class="mx-3" data-filter=".second">원활</li>
                <img
                  class="img-fluid text-center"
                  src="@/assets/img/traffic_state6.png"
                  alt=""
                  id="img_traffic_state"
                />
                <li class="mx-3" data-filter=".second">통행 불가</li>
              </ul>
            </div>
          </div>
          <live-view></live-view>
        </div>
      </div>
    </div>

    <bus-view></bus-view>
    <train-view></train-view>
    <bicycle-view></bicycle-view>
  </div>
</template>

<script>
import LiveView from "@/views/traffic/LiveView";
import BusView from "@/views/traffic/BusView";
import TrainView from "@/views/traffic/TrainView";
import BicycleView from "@/views/traffic/BicycleView";

export default {
  name: "AppMain",
  components: {
    LiveView,
    BusView,
    TrainView,
    BicycleView,
  },
  data() {
    return {
      modalShow: false,
      photoModalShow: false,
      photolink: "preview6.png",
      slide: 0,
      sliding: null,
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
#automobile {
  width: 350px;
  margin-left: 50px;
  padding: 30px;
}

iframe {
  text-align: center;
}
#live {
  width: 25%;
}

#img_live_state {
  width: 5%;
  margin-bottom: 10px;
  margin-left: 5px;
}
#img_traffic_state {
  width: 3%;
}

#traffic_img {
  margin-left: 150px;
  width: 70%;
}

.carousel-item {
  transition: 0.1s !important;
}

.carousel-indicators li {
  background-color: #6b799e !important;
}
</style>
