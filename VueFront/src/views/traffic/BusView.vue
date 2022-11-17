<template>
  <!-- 버스 서비스 시작 -->

  <div class="container-fluid bg-light my-5 py-6" id="service">
    <div class="container">
      <div class="row g-5 mb-4 wow fadeInUp" data-wow-delay="0.1s">
        <div class="col-lg-6">
          <h1 class="display-5 mb-0">
            버스 <img src="@/assets/img/busgif.gif" alt="" id="busgif" />
          </h1>
        </div>
      </div>
      <div class="row align-items-center wow fadeInUp" data-wow-delay="0.1s">
        <h5 class="text-primary fw-bold mb-3">
          대전광역시 3072개의 정류소 정보를 제공합니다. (* 정렬기준: 가나다순)
        </h5>
        <h5 class="text-success fw-bold mb-3">클릭 시 상세 정보를 가져옵니다.</h5>
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
          <div class="carousel-item active">
            <!-- 캐러셀 아이템 시작 -->
            <div class="row g-4">
              <div class="col-lg-6 wow fadeInUp portfolio-item first">
                <div
                  class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5"
                >
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">1 . {{ this.busstops[0].stop_name }}</h4>
                    <!-- <h6 class="mb-3">Start from <span class="text-primary">$199</span></h6> -->
                    <span class="text-primary fw-bold"> 정류소 ID: {{ busstops[0].stop_id }}</span
                    ><br />
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                </div>
                <div class="portfolio-btn">
                  <b-button v-b-toggle.sidebar-bus><i class="bi bi-info-square"></i></b-button>
                </div>
              </div>
              <div class="col-lg-6 wow fadeInUp portfolio-item first">
                <div
                  class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5"
                >
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop2.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">2 . {{ this.busstops[1].stop_name }}</h4>
                    <span class="text-primary fw-bold"> 정류소 ID: {{ busstops[1].stop_id }}</span
                    ><br />
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                </div>
                <div class="portfolio-btn">
                  <b-button v-b-toggle.sidebar-bus><i class="bi bi-info-square"></i></b-button>
                </div>
              </div>
              <div class="col-lg-6 wow fadeInUp portfolio-item first">
                <div
                  class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5"
                >
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop3.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">3 . {{ this.busstops[2].stop_name }}</h4>
                    <span class="text-primary fw-bold"> 정류소 ID: {{ busstops[2].stop_id }}</span
                    ><br />
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                </div>
                <div class="portfolio-btn">
                  <b-button v-b-toggle.sidebar-bus><i class="bi bi-info-square"></i></b-button>
                </div>
              </div>
              <div class="col-lg-6 wow fadeInUp portfolio-item first">
                <div
                  class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5"
                >
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop4.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">4 . {{ this.busstops[3].stop_name }}</h4>
                    <span class="text-primary fw-bold"> 정류소 ID: {{ busstops[3].stop_id }}</span
                    ><br />
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                </div>
                <div class="portfolio-btn">
                  <b-button v-b-toggle.sidebar-bus><i class="bi bi-info-square"></i></b-button>
                </div>
              </div>
            </div>
            <!-- 캐러셀 아이템 끝 -->
          </div>
          <div class="carousel-item" v-for="(item, i) in printbuslist()" :key="i">
            <!-- 캐러셀 아이템 시작 -->
            <div class="row g-4">
              <div class="col-lg-6 wow fadeInUp portfolio-item first" data-wow-delay="0.1s">
                <div
                  class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5"
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
                </div>
                <div class="portfolio-btn">
                  <b-button v-b-toggle.sidebar-bus><i class="bi bi-info-square"></i></b-button>
                </div>
              </div>
              <div class="col-lg-6 wow fadeInUp portfolio-item first" data-wow-delay="0.3s">
                <div
                  class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5"
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
                </div>
                <div class="portfolio-btn">
                  <b-button v-b-toggle.sidebar-bus><i class="bi bi-info-square"></i></b-button>
                </div>
              </div>
              <div class="col-lg-6 wow fadeInUp portfolio-item first" data-wow-delay="0.1s">
                <div
                  class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5"
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
                </div>
                <div class="portfolio-btn">
                  <b-button v-b-toggle.sidebar-bus><i class="bi bi-info-square"></i></b-button>
                </div>
              </div>
              <div class="col-lg-6 wow fadeInUp portfolio-item first" data-wow-delay="0.3s">
                <div
                  class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5"
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
                </div>
                <div class="portfolio-btn">
                  <b-button v-b-toggle.sidebar-bus><i class="bi bi-info-square"></i></b-button>
                </div>
              </div>
            </div>
            <!-- 캐러셀 아이템 끝 -->
          </div>
        </div>
        <br />
        <br />
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
      title="버스 정류소 상세 정보"
      right
      shadow
      backdrop
      backdrop-variant="dark"
      width="620px"
    >
      <template #default="{ hide }">
        <div class="p-3">
          <h4 id="sidebar-no-header-title">정류소이름@@@@@@@@</h4>
          <p>가나다라마바사@@@@@@@@@@@@@@@@@@@@</p>
          <b-img src="https://picsum.photos/500/500/?image=54" fluid thumbnail></b-img>

          <b-container> 여기다가 데이터 불러오면 되겠다 </b-container>
          <b-button variant="primary" block @click="hide">Close Sidebar</b-button>
        </div>
      </template>
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
      busstop: {
        stopid: 0,
        stopname: null,
      },
    };
  },

  methods: {
    printbuslist() {
      var list = [];
      for (var i = 4; i < this.busstops.length; i += 4) list.push(i);
      return list;
    },
  },
  created() {
    // spring에서 비동기로 버스 불러오기
    http.get(`/traffic/getbusstop`).then(({ data }) => {
      this.busstops = data;
    });
    console.log(this.busstops);
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

#indicator.active {
  background-color: #541cbd;
}

#carousel-control-prev {
  margin-bottom: 50px;
}

#carousel-control-next {
  margin-bottom: 50px;
}

#busgif {
  width: 10%;
}
</style>
