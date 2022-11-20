<template>
  <!-- 자전거 서비스 시작-->
  <div class="container-fluid bg-light mt-5 py-6" id="team">
    <div class="container">
      <div class="row g-5 mb-5 wow fadeInUp" data-wow-delay="0.1s">
        <div class="col-lg-6">
          <h1 class="display-5 mb-0">
            자전거 <img src="@/assets/img/bicyclegif.gif" alt="" id="bicyclegif" />
          </h1>
          <br />
          <h5 class="text-primary fw-bold mb-4">
            대전 공영 자전거
            <span class="text-success">타슈</span>의 대여소 정보를 확인하세요!
          </h5>
        </div>
        <div class="col-lg-6 text-lg-end">
          <a class="btn" href="https://bike.tashu.or.kr/main.do" target="_black" id="tashu_logo"
            ><img src="@/assets/img/tashu.png" alt="타슈"
          /></a>
        </div>
      </div>
      <div class="row g-4">
        <div class="border portfolio-img rounded overflow-hidden">
          <div class="col-lg-12 text-center">
            <h1 class="display-7 my-4 mb-10">지도입니다</h1>
          </div>
          <br />
          <div class="row g-5">
            <div class="col-lg-7">
              <tashu-map></tashu-map>
              <!-- <div class="d-flex align-items-center mb-3">
                ㅇㅇ
                <img class="img-fluid" src="@/assets/img/project-5.jpg" alt="" id="traffic_img" />
              </div> -->
            </div>
            <div class="col-lg-5">
              <div class="d-flex align-items-center mb-3">
                <h3 class="border-end pe-3 me-3 mb-0">대여소 명</h3>
                <h2 class="text-warning fw-bold mb-0" data-toggle="counter-up">대여 가능 대수</h2>
              </div>
              <table class="table table-bordered">
                <tbody>
                  <tr>
                    <th>주소</th>
                    <td>대충 자전거 정보</td>
                  </tr>
                  <tr>
                    <th>대여소ID</th>
                    <td>대충 자전거 정보</td>
                  </tr>
                  <tr>
                    <th>뭘 가져와야</th>
                    <td>대충 자전거 정보</td>
                  </tr>
                  <tr>
                    <th>좋을까?</th>
                    <td>대충 자전거 정보</td>
                  </tr>
                </tbody>
              </table>
              <p class="mb-4">@@@@@@@@@@@</p>
            </div>
          </div>
        </div>
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
    return {};
  },
};
</script>

<style>
#bicyclegif {
  width: 10%;
}
</style>
