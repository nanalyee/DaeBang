<template>
  <div class="container">
    <div class="row g-5 mb-5 wow fadeInUp" data-wow-delay="0.1s">
      <div class="col-lg-6">
        <h1 class="display-5 mb-0">{{ userInfo.username }} 님의 관심 지역 랭킹</h1>
      </div>
      <!-- <div class="col-lg-6 text-lg-end">
        <a class="btn btn-primary py-3 px-5" href="https://www.data.go.kr/">공공데이터 포털</a>
      </div> -->
    </div>
    <div class="row g-5">
      <div class="col-lg-8">
        <div class="container mb-3 bg-white border rounded-3 row">
          <div class="col border" style="height: 500px; overflow: auto">
            <div class="row" style="height: 230px; overflow: auto">
              <div class="col align-self-end text-center">
                <img
                  src="@/assets/img/marker/second.png"
                  alt=""
                  class="img img-fluid display-block"
                  style="width: 100px"
                />
              </div>
            </div>
            <div class="row-6">
              <div class="col align-self-end">
                <div
                  type="button"
                  class="btn btn-outline-primary col"
                  style="height: 250px; overflow: auto"
                >
                  2등 관련 정보
                </div>
              </div>
            </div>
          </div>
          <div class="col border" style="height: 500px; overflow: auto">
            <div class="row" style="height: 120px; overflow: auto">
              <div class="col align-self-end text-center">
                <img
                  src="@/assets/img/marker/first.png"
                  alt=""
                  class="img img-fluid display-block"
                  style="width: 100px"
                />
              </div>
            </div>
            <div class="row-6">
              <div class="col align-self-end">
                <div
                  type="button"
                  class="btn btn-outline-primary col"
                  style="height: 360px; overflow: auto"
                >
                  1등 관련 정보
                </div>
              </div>
            </div>
          </div>
          <div class="col border" style="height: 500px; overflow: auto">
            <div class="row" style="height: 300px; overflow: auto">
              <div class="col align-self-end text-center">
                <img
                  src="@/assets/img/marker/third.png"
                  alt=""
                  class="img img-fluid display-block"
                  style="width: 100px"
                />
              </div>
            </div>
            <div class="row-6">
              <div class="col align-self-end">
                <div
                  type="button"
                  class="btn btn-outline-primary col"
                  style="height: 180px; overflow: auto"
                >
                  3등 관련 정보
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-4">
        <div class="container mb-3 p-5 bg-white border rounded-3"></div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapGetters } from "vuex";
const memberStore = "memberStore";
export default {
  name: "wishRank",
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
};
</script>

<style></style>
