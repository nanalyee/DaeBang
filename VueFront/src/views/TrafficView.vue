<template>
  <div class="main">
    <!-- Header Start -->
    <div class="container-fluid bg-light my-6 mt-0" id="home">
      <div class="container">
        <div class="row g-5 pt-5 align-items-center">
          <div class="col-lg-6">
            <img
              class="img-fluid text-center"
              src="@/assets/img/automobile.png"
              alt=""
              id="automobile"
            />
          </div>
          <div class="col-lg-6 py-6 pb-0 pt-lg-0">
            <img src="@/assets/img/live.gif" alt="" id="live" />
            <!-- <h4 class="text-primary mb-3">LIVE</h4> -->
            <br />
            <br />
            <h1 class="display-5 mb-3">실시간 교통 상황</h1>
            <h2 class="typed-text-output d-inline"></h2>
            <div class="typed-text">
              <br />
            </div>
            <div class="d-flex align-items-center pt-5">
              <!-- <button @click="modalShow = !modalShow">Open Modal</b-button> -->
              <b-button @click="show" type="button" class="btn-play">
                <span></span>
              </b-button>
              <h5 class="ms-4 mb-0 d-none d-sm-block">소개영상</h5>
            </div>
          </div>
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
    <div class="container-xxl py-3 pt-5" id="project">
      <div class="container">
        <div class="row g-5 mb-5 align-items-center wow fadeInUp" data-wow-delay="0.1s">
          <div class="col-lg-12">
            <h1 class="display-5 mb-0">
              실시간 교통 상황<img src="@/assets/img/live_state.gif" alt="" id="img_live_state" />
            </h1>
          </div>
        </div>
        <div class="col-lg-12 text-lg-end">
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
    </div>
    <div class="container">
      <router-link :to="{ name: 'daejeonStation' }" class="btn btn-primary">대전역</router-link> |
      <router-link :to="{ name: 'yuseongStation' }" class="btn btn-primary">유성온천역</router-link>
      | <router-link :to="{ name: 'noeunStation' }" class="btn btn-primary">노은역</router-link> |
      <router-link :to="{ name: 'hanbatUniv' }" class="btn btn-primary">한밭대</router-link>
    </div>

    <live-view></live-view>
    <bus-view></bus-view>
    <train-view></train-view>
    <bicycle-view></bicycle-view>
    <tourist-destination></tourist-destination>
    <fav-weather></fav-weather>
  </div>
</template>

<script>
import LiveView from "@/views/traffic/LiveView";
import BusView from "@/views/traffic/BusView";
import TrainView from "@/views/traffic/TrainView";
import BicycleView from "@/views/traffic/BicycleView";
import TouristDestination from "@/components/fav/TouristDestination";
import FavWeather from "@/components/fav/FavWeather";
export default {
  name: "AppMain",
  components: {
    LiveView,
    BusView,
    TrainView,
    BicycleView,
    TouristDestination,
    FavWeather,
  },
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
</style>
