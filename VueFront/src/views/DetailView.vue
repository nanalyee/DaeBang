<template>
  <div class="box p-0 m-0">
    <div class="container mt-5 mb-3">
      <div class="row justify-content-between">
        <div class="col">
          <h2 style="display: inline-block">상세 보기</h2>
        </div>
        <div class="col text-lg-end text-center">
          <button type="button" class="btn bg-white mx-4" @click="goBack" style="color: #6b799e">
            매매검색으로 돌아가기
          </button>
        </div>
      </div>
      <div class="row">
        <kakao-map-view></kakao-map-view>
        <!-- <div class="col-6"><near-list-view></near-list-view></div> -->
      </div>
    </div>
  </div>
</template>

<script>
import KakaoMapView from "../components/detail/KakaoMapView.vue";
// import NearListView from "../components/detail/NearListView.vue";

export default {
  name: "appDetail",
  components: { KakaoMapView },
  methods: {
    goBack() {
      this.$router.go(-1);
    },
  },
};
</script>

<style scoped>
.box {
  width: 100vw;
  height: 100vh;
}
#map {
  z-index: 1;
}
</style>
