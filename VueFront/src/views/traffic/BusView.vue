<template>
  <!-- 버스 서비스 시작 -->

  <div class="container-fluid bg-light my-5 py-6" id="bus">
    <div class="container">
      <div class="row g-5 mb-4">
        <div class="col-lg-6">
          <h1 class="display-5 mb-0">
            버스 <img src="@/assets/img/busgif.gif" alt="" id="busgif" />
          </h1>
        </div>
      </div>
      <div class="row align-items-center">
        <h5 class="text-primary fw-bold mb-3">
          대전광역시 3072개의 정류소 정보를 제공합니다. (* 정렬기준: 가나다순)
        </h5>
        <h5 class="text-success fw-bold mb-3">클릭 시 실시간 노선 정보를 가져옵니다.</h5>
      </div>

      <div id="carouselExampleIndicators" class="carousel carousel-dark slide" data-ride="carousel">
        <!-- <ol class="carousel-indicators">
          <li
            id="indicator"
            data-target="#carouselExampleIndicators"
            data-slide-to="0"
            class="active"
          ></li>
          <li
            v-for="(item, i) in busstops.slice(1)"
            :key="i"
            id="indicator"
            data-target="#carouselExampleIndicators"
            :data-slide-to="i"
          ></li>
        </ol> -->

        <div class="carousel-inner">
          <div class="carousel-item active rounded">
            <!-- 캐러셀 아이템 시작 -->
            <div class="row g-4">
              <div class="col-lg-6 portfolio-item first pl-5">
                <div
                  class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5 portfolio-img"
                >
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">1 . {{ busstops[0].stop_name }}</h4>
                    <!-- <h6 class="mb-3">Start from <span class="text-primary">$199</span></h6> -->
                    <span class="text-primary fw-bold"> 정류소 ID: {{ busstops[0].stop_id }}</span
                    ><br />
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                  <div class="portfolio-btn rounded justify-content-end">
                    <b-button
                      v-b-toggle.sidebar-bus
                      @click="getBusInfo(busstops[0].stop_name, busstops[0].stop_id, 1)"
                      ><i class="bi bi-info-square-fill"></i
                    ></b-button>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 portfolio-item first pr-5">
                <div
                  class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5 portfolio-img"
                >
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop2.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">2 . {{ busstops[1].stop_name }}</h4>
                    <span class="text-primary fw-bold"> 정류소 ID: {{ busstops[1].stop_id }}</span
                    ><br />
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                  <div class="portfolio-btn rounded m-6">
                    <b-button
                      v-b-toggle.sidebar-bus
                      @click="getBusInfo(busstops[1].stop_name, busstops[1].stop_id, 2)"
                      ><i class="bi bi-info-square-fill"></i
                    ></b-button>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 portfolio-item first pl-5">
                <div
                  class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5 portfolio-img"
                >
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop3.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">3 . {{ busstops[2].stop_name }}</h4>
                    <span class="text-primary fw-bold"> 정류소 ID: {{ busstops[2].stop_id }}</span
                    ><br />
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                  <div class="portfolio-btn rounded m-6 justify-content-end">
                    <b-button
                      v-b-toggle.sidebar-bus
                      @click="getBusInfo(busstops[2].stop_name, busstops[2].stop_id, 3)"
                      ><i class="bi bi-info-square-fill"></i
                    ></b-button>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 portfolio-item first pr-5">
                <div
                  class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5 portfolio-img"
                >
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop4.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">4 . {{ busstops[3].stop_name }}</h4>
                    <span class="text-primary fw-bold"> 정류소 ID: {{ busstops[3].stop_id }}</span
                    ><br />
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                  <div class="portfolio-btn rounded m-6">
                    <b-button
                      v-b-toggle.sidebar-bus
                      @click="getBusInfo(busstops[3].stop_name, busstops[3].stop_id, 4)"
                      ><i class="bi bi-info-square-fill"></i
                    ></b-button>
                  </div>
                </div>
              </div>
            </div>
            <!-- 캐러셀 아이템 끝 -->
          </div>
          <div class="carousel-item" v-for="(item, i) in printbuslist()" :key="i">
            <!-- 캐러셀 아이템 시작 -->
            <div class="row g-4">
              <div class="col-lg-6 portfolio-item first pl-5">
                <div
                  class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5 portfolio-img"
                >
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">{{ item + 1 }} . {{ busstops[item].stop_name }}</h4>
                    <!-- <h6 class="mb-3">Start from <span class="text-primary">$199</span></h6> -->
                    <span class="text-primary fw-bold">
                      정류소 ID: {{ busstops[item].stop_id }}</span
                    ><br />
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                  <div class="portfolio-btn rounded m-6 justify-content-end">
                    <b-button
                      v-b-toggle.sidebar-bus
                      @click="
                        getBusInfo(busstops[item].stop_name, busstops[item].stop_id, item + 1)
                      "
                      ><i class="bi bi-info-square-fill"></i
                    ></b-button>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 portfolio-item first pr-5">
                <div
                  class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5 portfolio-img"
                >
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop2.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">{{ item + 2 }} . {{ busstops[item + 1].stop_name }}</h4>
                    <span class="text-primary fw-bold">
                      정류소 ID: {{ busstops[item + 1].stop_id }}</span
                    ><br />
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                  <div class="portfolio-btn rounded m-6">
                    <b-button
                      v-b-toggle.sidebar-bus
                      @click="
                        getBusInfo(
                          busstops[item + 1].stop_name,
                          busstops[item + 1].stop_id,
                          item + 2
                        )
                      "
                      ><i class="bi bi-info-square-fill"></i
                    ></b-button>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 portfolio-item first pl-5">
                <div
                  class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5 portfolio-img"
                >
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop3.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">{{ item + 3 }} . {{ busstops[item + 2].stop_name }}</h4>
                    <span class="text-primary fw-bold">
                      정류소 ID: {{ busstops[item + 2].stop_id }}</span
                    ><br />
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                  <div class="portfolio-btn rounded m-6 justify-content-end">
                    <b-button
                      v-b-toggle.sidebar-bus
                      @click="
                        getBusInfo(
                          busstops[item + 2].stop_name,
                          busstops[item + 2].stop_id,
                          item + 3
                        )
                      "
                      ><i class="bi bi-info-square-fill"></i
                    ></b-button>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 portfolio-item first pr-5">
                <div
                  class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5 portfolio-img"
                >
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop4.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">{{ item + 4 }} . {{ busstops[item + 3].stop_name }}</h4>
                    <span class="text-primary fw-bold">
                      정류소 ID: {{ busstops[item + 3].stop_id }}</span
                    ><br />
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                  <div class="portfolio-btn rounded m-6">
                    <b-button
                      v-b-toggle.sidebar-bus
                      @click="
                        getBusInfo(
                          busstops[item + 3].stop_name,
                          busstops[item + 3].stop_id,
                          item + 4
                        )
                      "
                      ><i class="bi bi-info-square-fill"></i
                    ></b-button>
                  </div>
                </div>
              </div>
            </div>
            <!-- 캐러셀 아이템 끝 -->
          </div>
        </div>

        <button
          id="carousel-control-prev"
          class="carousel-control-prev"
          type="button"
          data-target="#carouselExampleIndicators"
          data-slide="prev"
        >
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </button>
        <button
          id="carousel-control-next"
          class="carousel-control-next"
          type="button"
          data-target="#carouselExampleIndicators"
          data-slide="next"
        >
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </button>
      </div>
    </div>
    <b-sidebar
      id="sidebar-bus"
      title="정류소 노선 정보"
      right
      shadow
      backdrop
      backdrop-variant="dark"
      width="620px"
    >
      <div id="busList" class="px-3 py-2">
        <!-- button start -->
        <div
          class="panel-group"
          id="accordion"
          role="tablist"
          aria-multiselectable="true"
          v-on:scroll.prevent="onScroll"
        >
          <div class="p-3">
            <h4 id="sidebar-no-header-title">
              {{ busstop_info.stopindex }} . {{ busstop_info.stopname }}
            </h4>
          </div>
          <div
            v-for="(item, i) in busstop_info_list"
            :key="i"
            type="button"
            :id="'article' + i"
            class=""
            data-toggle="collapse"
            :href="'#toggle' + i"
            role="button"
            aria-expanded="false"
            :aria-controls="'toggle' + i"
          >
            <div class="row my-3">
              <div class="col-2 p-2 text-right">
                <img id="bus_icon" class="rounded user" src="@/assets/img/busstop.png" alt="" />
              </div>
              <div class="col-auto">
                <div class="row">
                  <div class="col-auto align-self-center rounded p-3 mb-3 mt-1 bubble">
                    <div class="">
                      <span class="fs-6 font-weight-bold">{{ item.ROUTE_NO }} </span>
                      <span v-if="item.ROUTE_TP == '1'" class="pe-3" style="color: gray">급행</span>
                      <span v-if="item.ROUTE_TP == '2'" class="pe-3" style="color: gray">간선</span>
                      <span v-if="item.ROUTE_TP == '3'" class="pe-3" style="color: gray">지선</span>
                      <span v-if="item.ROUTE_TP == '4'" class="pe-3" style="color: gray">외곽</span>
                      <span v-if="item.ROUTE_TP == '5'" class="pe-3" style="color: gray">마을</span>
                      <span v-if="item.ROUTE_TP == '6'" class="pe-3" style="color: gray">첨단</span>
                    </div>

                    <div
                      class="collapse border-top pt-2 mt-2"
                      :id="'toggle' + i"
                      data-parent="#accordion"
                    >
                      <div class="row">
                        <table class="table table-borderless">
                          <tbody>
                            <tr>
                              <th>차량번호</th>
                              <td>{{ item.CAR_REG_NO }}</td>
                            </tr>
                            <tr>
                              <th>종점</th>
                              <td>{{ item.DESTINATION }}</td>
                            </tr>
                            <tr>
                              <th>도착예정시간</th>
                              <td>{{ item.EXTIME_MIN }} 분</td>
                            </tr>
                            <tr>
                              <th>잔여정류장 수</th>
                              <td>{{ item.STATUS_POS }}</td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-auto align-self-center">
                    <div class="small" style="color: #e9b06b">
                      업데이트 시간 : {{ item.INFO_OFFER_TM.slice(0, -2) }}
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- button end -->
      </div>
      <!-- <template #default="{ hide }">
        <div class="p-3">
          <h4 id="sidebar-no-header-title">
            {{ busstop_info.stopid }} . {{ busstop_info.stopname }}
          </h4>
          <p>가나다라마바사@@@@@@@@@@@@@@@@@@@@</p>
          <b-img src="https://picsum.photos/500/500/?image=54" fluid thumbnail></b-img>

          <b-container> {{ busstop_info.stopname }} </b-container>
          <b-button variant="primary" block @click="hide">Close Sidebar</b-button>
          ㄷㄷ
        </div>
      </template> -->
    </b-sidebar>
  </div>
  <!-- 버스 서비스 끝 -->
</template>

<script>
import http from "@/util/http"; // 버스 정류소 불러오기용

export default {
  name: "BusView",
  data() {
    return {
      busstops: [],
      // 버스 불러오기 테스트용
      busstop_info_list: [],
      busstop_info: {
        stopid: "",
        stopname: "",
        stopindex: "",
        car_reg_no: "",
        destination: "",
        extime_min: "",
        INFO_OFFER_TM: "",
        msg_tp: "",
        route_tp: "",
        status_pos: "",
      },
    };
  },

  methods: {
    printbuslist() {
      var list = [];
      for (var i = 4; i < this.busstops.length; i += 4) list.push(i);
      return list;
    },
    getBusInfo(name, id, idx) {
      console.log("호ㅓ호호");
      console.log(name);
      this.busstop_info.stopname = name;
      this.busstop_info.stopid = id;
      this.busstop_info.stopindex = idx;

      http.get(`/traffic/getbusinfo/${id}`).then(({ data }) => {
        console.log(data.ServiceResult.msgBody);
        this.busstop_info_list = data.ServiceResult.msgBody.itemList;
        console.log(this.busstop_info_list);
      });
    },
  },
  created() {
    // spring에서 비동기로 버스 불러오기
    http.get(`/traffic/getbusstop`).then(({ data }) => {
      this.busstops = data;
    });
    //console.log(this.busstops);
  },
};
</script>

<style>
#carousel {
  width: 10%;
}
#indicator {
  width: 50px;
  height: 4px;
  background-color: black;
}

/* #indicator.active {
  background-color: #541cbd;
} */

/* #carousel-control-prev {
  margin-bottom: 50px;
}

#carousel-control-next {
  margin-bottom: 50px;
} */

#busgif {
  width: 10%;
}

.carousel-control-prev {
  margin-left: -100px;
}

.carousel-control-next {
  margin-right: -100px;
}

.carousel-item {
  float: none;
  transition: 0.1s !important;
}
</style>
