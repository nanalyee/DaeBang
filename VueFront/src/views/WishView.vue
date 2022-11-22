<template>
  <div>
    <!-- Header Start -->
    <div class="container-fluid bg-light my-6 mt-0" id="home">
      <div class="container">
        <div class="row g-5 align-items-center">
          <div class="col-lg-6 pt-5 pb-5 text-end">
            <img
              class="img-fluid"
              src="@/assets/img/gif/wish3-unscreen.gif"
              style="width: 500px"
              alt=""
            />
          </div>
          <div class="col-lg-6 py-6 pb-0 pt-lg-0">
            <img src="@/assets/img/rank/rank.png" alt="" id="podium_icon" />
            <br />
            <br />
            <h1 class="display-5 mb-3">유저 맞춤 추천 시스템</h1>
            <h2 class="typed-text-output d-inline"></h2>
            <vue-typer
              class="fs-4"
              :text="[
                '어디가 좋은지 모르겠다면',
                '여러분의 상권 선호도를 바탕으로',
                '최고의 지역을 추천해 드릴게요.',
                '분명 도움이 될 거예요!',
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
              <!-- <button @click="modalShow = !modalShow">Open Modal</b-button> -->
              <b-button type="button" class="btn-play">
                <span></span>
              </b-button>
              <h5 class="ms-4 mb-0 d-none d-sm-block">소개 영상</h5>
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
        <!-- <wish-weather></wish-weather> -->
      </div>
    </div>
    <div class="container-xxl py-6 pt-5" id="weather">
      <div class="container">
        <wish-tour></wish-tour>
      </div>
    </div>
  </div>
</template>

<script>
import WishRank from "../components/wish/WishRank.vue";
import WishTour from "../components/wish/WishTour.vue";
// import WishWeather from "../components/wish/WishWeather.vue";

export default {
  name: "appWish",
  components: { WishRank, WishTour },
};
</script>

<style>
#podium_icon {
  width: 10%;
}
</style>
