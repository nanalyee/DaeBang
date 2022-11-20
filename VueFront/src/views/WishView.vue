<template>
  <div>
    <!-- Header Start -->
    <div class="container-fluid bg-light my-6 mt-0" id="home">
      <div class="container">
        <div class="row g-5 pt-5 align-items-center">
          <div class="col-lg-6">
            <img class="img-fluid text-center" src="@/assets/img/marker/life.png" alt="" />
          </div>
          <div class="col-lg-6 py-6 pb-0 pt-lg-0">
            <h4 class="text-primary mb-3">내가 원하는 방</h4>
            <h1 class="display-3 mb-3">wish list test</h1>
            <h2 class="typed-text-output d-inline"></h2>
            <div class="typed-text">
              아파트부터 오피스텔까지 당신이 원하는 정보를 찾아드립니다<br />
              지금 바로 시작해 보세요!
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

    <div class="container-xxl py-6 pt-5" id="wishrank">
      <div class="container">
        <wish-rank></wish-rank>
      </div>
    </div>
    <div class="container-fluid bg-light my-5 py-6" id="tour">
      <div class="container">
        <wish-tour></wish-tour>
      </div>
    </div>
    <div class="container-xxl py-6 pt-5" id="weather">
      <div class="container">
        <wish-weather></wish-weather>
      </div>
    </div>
  </div>
</template>

<script>
import WishRank from "../components/wish/WishRank.vue";
import WishTour from "../components/wish/WishTour.vue";
import WishWeather from "../components/wish/WishWeather.vue";

export default {
  name: "appWish",
  components: { WishRank, WishTour, WishWeather },
};
</script>

<style></style>
