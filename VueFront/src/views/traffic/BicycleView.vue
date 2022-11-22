<template>
  <!-- 자전거 서비스 시작-->
  <div class="container-fluid bg-light mt-5 py-6" id="team">
    <div class="container">
      <div class="row g-5 mb-5 wow fadeInUp" data-wow-delay="0.1s">
        <div class="col-lg-6">
          <h1 class="display-5 mb-0">자전거 <img src="@/assets/img/bicyclegif.gif" alt="" id="bicyclegif" /></h1>
          <br />
          <h5 class="text-primary fw-bold mb-4">
            대전 공영 자전거
            <span class="text-success">타슈</span>의 대여소 정보를 확인하세요!
          </h5>
        </div>
        <div class="col-lg-6 text-lg-end">
          <a class="btn" href="https://bike.tashu.or.kr/main.do" target="blank" id="tashu_logo"
            ><img src="@/assets/img/tashu.png" alt="타슈"
          /></a>
        </div>
      </div>
      <div>{{ this.time }}</div>
      <div class="col-lg-12 text-center">
        <h1 class="display-7 my-4 mb-10"></h1>
        <tashu-map></tashu-map>
      </div>
    </div>
  </div>
  <!-- 자전거 서비스 끝-->
</template>

<script>
import TashuMap from "@/components/bicycle/TashuMap";
export default {
  name: "BicycleView",

  components: {
    TashuMap,
  },
  data() {
    return {
      time: new Date(),
    };
  },
  created() {},

  methods: {},
};
</script>

<style>
#bicyclegif {
  width: 10%;
}
</style>
