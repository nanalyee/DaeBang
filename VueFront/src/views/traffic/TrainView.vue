<template>
  <!-- 지하철 서비스 시작 -->
  <div class="container-xxl py-6" id="train">
    <div class="container">
      <div class="row g-6 mb-5 wow fadeInUp" data-wow-delay="0.1s">
        <div class="col-lg-6">
          <h1 class="display-5 mb-0">지하철</h1>
          <br />
          <h5 class="text-success fw-bold mb-4">
            대전 도시철도 1호선은
            <br />
            2021년 기준 하루 평균 <span class="text-danger">74,920</span>명이 이용합니다.
          </h5>
        </div>
      </div>

      <!-- 지하철 캐러셀 시작   -->
      <div id="carouselTrain" class="carousel carousel-dark slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li id="indicator" data-target="#carouselTrain" data-slide-to="0" class="active"></li>
          <li
            id="indicator"
            v-for="(item, i) in 21"
            :key="i"
            data-target="#carouselTrain"
            :data-slide-to="item"
          ></li>
        </ol>

        <div class="carousel-inner">
          <div id="carousel_train_speed" class="carousel-item active rounded">
            <div class="row g-4">
              <img
                id="daejeon_subway"
                class="img-fluid rounded"
                src="@/assets/img/daejeon_subway_1.png"
                alt=""
              />
            </div>
          </div>
          <div v-for="(item, i) in 21" :key="i" id="carousel_train_speed" class="carousel-item">
            <div class="row g-4">
              <img
                id="daejeon_subway"
                class="img-fluid rounded"
                :src="require(`@/assets/img/daejeon_subway_${item + 1}.png`)"
                alt=""
              />
            </div>
          </div>
        </div>

        <button
          id="carousel-subway-prev"
          class="carousel-control-prev"
          type="button"
          data-target="#carouselTrain"
          data-slide="prev"
        >
          <img id="subway_array_icon" src="@/assets/img/subway_prev.png" alt="" />
          <!-- <span class="carousel-control-prev-icon" aria-hidden="true"></span> -->
          <!-- <span class="sr-only">Previous</span> -->
        </button>
        <button
          id="carousel-subway-next"
          class="carousel-control-next"
          type="button"
          data-target="#carouselTrain"
          data-slide="next"
        >
          <img id="subway_array_icon" src="@/assets/img/subway_next.png" alt="" />
          <!-- <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span> -->
        </button>
        <br />
        <br />
      </div>
      <!-- 지하철 캐러셀 끝   -->
      <br />
      <div class="row g-5">
        <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
          <!-- <div class="d-flex align-items-center mb-5">
                        <div class="years flex-shrink-0 text-center me-4">
                            <h1 class="display-1 mb-0">5</h1>
                            <h5 class="mb-0">Years</h5>
                        </div>
                        <h3 class="lh-base mb-0">2015~2020년간<br> 전국 아파트 실거래 <br> 공공데이터 사용</h3>
                    </div>
                    <p class="mb-4">부동산 거래신고에 관한 법률에 따라 신고된 주택의 실거래 자료</p>
                    <p class="mb-3"><i class="far fa-check-circle text-primary me-3"></i>국토교통부</p>
                    <p class="mb-3"><i class="far fa-check-circle text-primary me-3"></i>High Quality Product</p>
                    <p class="mb-3"><i class="far fa-check-circle text-primary me-3"></i>On Time Project Delivery</p>
                    <a class="btn btn-primary py-3 px-5 mt-3" href="">Read More</a> -->
          <div class="d-flex align-items-center mb-3">
            <h3 class="border-end pe-3 me-3 mb-0">지하철 정보 넣을거야@@@@@@</h3>
            <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">23124124</h2>
          </div>
          <p class="mb-4">지하철지하철지하철</p>
          <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>train~</p>
        </div>
        <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
          <!-- <div class="row g-3 mb-4">
                        <div class="col-sm-6">
                            <img class="img-fluid rounded" src="${root}/img/about-1.jpg" alt="">
                        </div>
                        <div class="col-sm-6">
                            <img class="img-fluid rounded" src="${root}/img/about-2.jpg" alt="">
                        </div>
                    </div> -->
          <div class="d-flex align-items-center mb-3">
            <h3 class="border-end pe-3 me-3 mb-0">지하철 정보 넣을거야@@@@@@</h3>
            <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">1000</h2>
          </div>
          <p class="mb-4">
            지하철지하철지하철<br />
            지하철지하철지하철
          </p>
          <p class="mb-3">
            <i class="bi bi-check-circle-fill text-primary me-3"></i>지하철지하철지하철
          </p>
        </div>
      </div>
    </div>
  </div>
  <!-- 지하철 서비스 끝 -->
</template>

<script>
export default {
  name: "TrainView",
  data() {
    return {};
  },
};
</script>

<style>
#daejeon_subway {
  width: 900px;
  margin: auto;
  margin-top: 30px;
  text-align: center;
}

#carousel_train_speed {
  transition: 0.3s !important;
}

#subway_array_icon {
  width: 20%;
  margin-bottom: 40px;
}

#carousel-subway-prev {
  margin-left: 0px;
}

#carousel-subway-next {
  margin-right: 20px;
}
#indicator.active {
  background-color: #541cbd;
}
</style>
