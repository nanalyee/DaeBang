<template>
  <div class="box p-0 m-0">
    <h3>test</h3>

    <div class="container mt-5 mb-3">
      <h2 style="display: inline-block">상세 보기</h2>

      <div class="row">
        <div class="col-6"><kakao-map-view></kakao-map-view></div>
        <div class="col-6"><near-list-view></near-list-view></div>
      </div>
    </div>
  </div>
</template>

<script>
import KakaoMapView from "../components/detail/KakaoMapView.vue";
import NearListView from "../components/detail/NearListView.vue";

export default {
  name: "appDetail",
  components: { KakaoMapView, NearListView },
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
