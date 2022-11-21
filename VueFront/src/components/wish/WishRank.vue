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
      <div class="col-lg-7 pr-0">
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
              <div class="col align-self-end px-0">
                <div type="button" class="btn btn-outline-primary col" style="height: 250px; overflow: auto">
                  2등 관련 정보 {{ example[1].wishname }}
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
              <div class="col align-self-end px-0">
                <div type="button" class="btn btn-outline-primary col" style="height: 360px; overflow: auto">
                  1등 관련 정보 {{ example[0].wishname }}
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
              <div class="col align-self-end px-0">
                <div type="button" class="btn btn-outline-primary col" style="height: 180px; overflow: auto">
                  3등 관련 정보 {{ example[2].wishname }}
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-5 pl-0">
        <div class="container mb-3 p-5 bg-white border rounded-3">
          <div
            v-for="(item, i) in example"
            :key="i"
            type="button"
            :id="'storeinfo' + i"
            class=""
            data-toggle="collapse"
            :href="'#toggle' + i"
            role="button"
            aria-expanded="false"
            :aria-controls="'toggle' + i"
          >
            <div class="p-2 my-3 border rounded row" v-if="i > 2">
              <div class="col align-self-center">
                <div class="">
                  <span class="fs-4 pe-3">{{ item.wishname }}</span>
                  <span class="" style="color: gray">아파트</span>
                </div>

                <div class="collapse" :id="'toggle' + i" data-parent="#accordion">
                  <div class="row">
                    <div class="col">
                      <span class="pe-3" style="color: gray">전용면적</span>
                      <span></span>
                    </div>
                    <div class="col">
                      <span class="pe-3" style="color: gray">층수</span>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col">
                      <span class="pe-3" style="color: gray">보증금액</span>
                    </div>
                    <div class="col">
                      <span class="pe-3" style="color: gray">월세</span>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col">
                      <span class="pe-3" style="color: gray">법정동</span>
                    </div>
                    <div class="col">
                      <span class="pe-3" style="color: gray">건축년도</span>
                    </div>
                    <!-- <div class="col">
              <a id="copy" style="color: #8797c7" href="#" onclick="callFunction();">복사</a>
            </div> -->
                  </div>
                </div>
              </div>
              <div class="col-3 collapse" :id="'toggle' + i" data-parent="#accordion">
                <img class="img-fluid img-thumbnail rounded" :src="$store.state.houseimg" alt="" />
              </div>
              <div class="col-1 text-right align-self-center collapse" :id="'toggle' + i" data-parent="#accordion">
                <a href="#" class="golink">
                  <i class="bi bi-chevron-compact-right fs-1"></i>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapGetters } from "vuex";
const memberStore = "memberStore";
export default {
  name: "wishRank",
  data() {
    return {
      example: [
        { wishname: "아파트1" },
        { wishname: "아파트2" },
        { wishname: "아파트3" },
        { wishname: "아파트4" },
        { wishname: "아파트5" },
        { wishname: "아파트6" },
      ],
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
};
</script>

<style></style>
