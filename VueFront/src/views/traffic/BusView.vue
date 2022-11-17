<template>
  <!-- 버스 서비스 시작 -->

  <div class="container-fluid bg-light my-5 py-6" id="service">
    <div class="container">
      <div class="row g-5 mb-4 wow fadeInUp" data-wow-delay="0.1s">
        <div class="col-lg-6">
          <h1 class="display-5 mb-0">버스</h1>
        </div>
      </div>
      <div class="row align-items-center wow fadeInUp" data-wow-delay="0.1s">
        <h5 class="text-primary fw-bold mb-3">대전광역시 3072개의 정류소 정보를 제공합니다.</h5>
      </div>
      <div id="carouselExampleIndicators" class="carousel carousel-dark slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li id="indicator" data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li id="indicator" data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li id="indicator" data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <!-- 캐러셀 아이템 시작 -->
            <div class="row g-4">
              <div class="col-lg-6 wow fadeInUp">
                <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">해밀리</h4>
                    <!-- <h6 class="mb-3">Start from <span class="text-primary">$199</span></h6> -->
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 wow fadeInUp">
                <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">가람아파트</h4>
                    <span class="text-primary fw-bold">관심 정류소 등록 💌 </span>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 wow fadeInUp">
                <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/traffic_img.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">가목정마을</h4>
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 wow fadeInUp">
                <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/traffic_img.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">가수원역</h4>
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                </div>
              </div>
            </div>
            <!-- 캐러셀 아이템 끝 -->
          </div>
          <div class="carousel-item">
            <!-- 캐러셀 아이템 시작 -->
            <div class="row g-4">
              <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">해밀리</h4>
                    <!-- <h6 class="mb-3">Start from <span class="text-primary">$199</span></h6> -->
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s">
                <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">가람아파트</h4>
                    <span class="text-primary fw-bold">관심 정류소 등록 💌 </span>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/traffic_img.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">가목정마을</h4>
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s">
                <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/traffic_img.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">가수원역</h4>
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                </div>
              </div>
            </div>
            <!-- 캐러셀 아이템 끝 -->
          </div>
          <div class="carousel-item">
            <!-- 캐러셀 아이템 시작 -->
            <div class="row g-4">
              <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">해밀리</h4>
                    <!-- <h6 class="mb-3">Start from <span class="text-primary">$199</span></h6> -->
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s">
                <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/busstop.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">가람아파트</h4>
                    <span class="text-primary fw-bold">관심 정류소 등록 💌 </span>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/traffic_img.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">가목정마을</h4>
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s">
                <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
                  <div class="bg-icon flex-shrink-0 mb-3">
                    <img class="img-fluid rounded" src="@/assets/img/traffic_img.png" alt="" />
                  </div>
                  <div class="ms-sm-4">
                    <h4 class="mb-3">가수원역</h4>
                    <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
                  </div>
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
      <!-- 연습용@@@@@@@@@@@@@@@@@ -->
      <!-- <div class="row g-4">
        <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
          <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
            <div class="bg-icon flex-shrink-0 mb-3">
              <img class="img-fluid rounded" src="@/assets/img/busstop.png" alt="" />
            </div>
            <div class="ms-sm-4">
              <h4 class="mb-3">해밀리</h4>
              <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
            </div>
          </div>
        </div>
        <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s">
          <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
            <div class="bg-icon flex-shrink-0 mb-3">
              <img class="img-fluid rounded" src="@/assets/img/busstop.png" alt="" />
            </div>
            <div class="ms-sm-4">
              <h4 class="mb-3">가람아파트</h4>
              <span class="text-primary fw-bold">관심 정류소 등록 💌 </span>
            </div>
          </div>
        </div>
        <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
          <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
            <div class="bg-icon flex-shrink-0 mb-3">
              <img class="img-fluid rounded" src="@/assets/img/traffic_img.png" alt="" />
            </div>
            <div class="ms-sm-4">
              <h4 class="mb-3">가목정마을</h4>
              <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
            </div>
          </div>
        </div>
        <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s">
          <div class="service-item d-flex flex-column flex-sm-row bg-white rounded h-100 p-4 p-lg-5">
            <div class="bg-icon flex-shrink-0 mb-3">
              <img class="img-fluid rounded" src="@/assets/img/traffic_img.png" alt="" />
            </div>
            <div class="ms-sm-4">
              <h4 class="mb-3">가수원역</h4>
              <span class="text-primary fw-bold">관심 정류소 등록 💌</span>
            </div>
          </div>
        </div>
      </div> -->
      <!-- 연습끝@@@@@@@@@@@@@@@@@@@@ -->
    </div>
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
</style>
