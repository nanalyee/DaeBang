<template>
  <!-- 지하철 서비스 시작 -->
  <div v-if="this.subwayListInfo.length > 0" class="container-xxl py-6" id="train">
    <div class="container">
      <div class="row g-6 mb-2 wow fadeInUp" data-wow-delay="0.1s">
        <div class="col-lg-6">
          <h1 class="display-5 mb-0">지하철<img src="@/assets/img/traingif.gif" alt="" id="traingif" /></h1>
          <br />
          <h5 class="text-success fw-bold mb-4">클릭 시 역 상세 정보를 보여줍니다.</h5>
        </div>
      </div>

      <!-- 지하철 캐러셀 시작   -->
      <div id="carouselTrain" class="carousel carousel-dark slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li id="indicator" data-target="#carouselTrain" data-slide-to="0" class="active text-center">
            <div class=""><div class=""></div></div>
            {{ subwayListInfo[0].stationName }}
          </li>
          <li
            v-for="(item, i) in 21"
            id="indicator"
            :key="i"
            data-target="#carouselTrain"
            :data-slide-to="item"
            class="text-center"
          >
            <div class=""><div class=""></div></div>
            {{ subwayListInfo[i + 1].stationName }}
          </li>
        </ol>

        <div class="carousel-inner">
          <div id="carousel_train_speed" class="carousel-item active rounded">
            <div class="row g-4">
              <img
                id="daejeon_subway"
                class="img-fluid rounded"
                src="@/assets/img/daejeon_subway_1.png"
                alt=""
                @click="showSubwayInfo(0)"
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
                @click="showSubwayInfo(item)"
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
      </div>
      <!-- 지하철 캐러셀 끝   -->
      <br />
      <br />
      <div class="row" id="test">
        <div class="col-lg-6 align-self-end text-center" style="height: 400px">
          <!-- <div class="d-flex align-items-center mb-3">
            <h3 class="border-end pe-3 me-3 ml-2 mb-0">역 시간표</h3>
            <h2 class="text-primary fw-bold mb-0" data-toggle="counter-up">상행</h2>
          </div> -->
          <div class="row" style="height: 140px; overflow: auto">
            <div class="col align-self-end text-center"></div>
          </div>
          <img id="daejeon_subway_all" class="img img-fluid display-block" src="@/assets/img/subwayall.png" alt="" />
          <!-- <p class="ml-2 mb-4">지하철지하철지하철</p>
          <p class="ml-2 mb-3">
            <i class="bi bi-check-circle-fill text-primary me-3"></i>언제일까용?
          </p> -->
        </div>
        <div class="col-lg-6 wow fadeInUp" style="height: 300px">
          <div class="row" style="height: 140px; overflow: auto">
            <div class="col align-self-end text-center"></div>
          </div>
          <div class="d-flex align-items-center mt-5 mb-3">
            <h3 class="border-end pe-3 me-3 mb-0">지하철 일 평균 이용 승객 수</h3>
            <h2 class="text-danger fw-bold mb-0" data-toggle="counter-up">74,920</h2>
          </div>
          <p class="mb-4">2021년 기준</p>
          <p class="mb-3"><i class="bi bi-check-circle-fill text-primary me-3"></i>대전의 통계</p>
        </div>
      </div>
    </div>

    <!-- Video Modal Start -->
    <b-modal v-model="subwaymodalShow" hide-footer title="대전 지하철 역 상세정보">
      <div class="col-lg-12 text-center">
        <h3 class="text-success display-7 my-4 mb-10">{{ subwayInfo.stationName }}</h3>
      </div>
      <h5 class="display-7 mb-4">역 정보</h5>
      <table class="table caption-top">
        <tbody>
          <tr>
            <th>주소</th>
            <td>{{ subwayInfo.stationAddr }}</td>
          </tr>
          <tr>
            <th>번호</th>
            <td>{{ subwayInfo.stationTel }}</td>
          </tr>
          <tr>
            <th>구조</th>
            <td>{{ subwayInfo.stationStruct }}</td>
          </tr>
          <tr>
            <th>면적</th>
            <td>{{ subwayInfo.stationArea }}</td>
          </tr>
          <tr>
            <th>승강시설</th>
            <td>{{ subwayInfo.elevatorFac }}</td>
          </tr>
          <tr>
            <th>출입구</th>
            <td>{{ subwayInfo.stationExit }}</td>
          </tr>
        </tbody>
      </table>
      <h5 class="display-7 mb-4 mt-5">편의 시설 유무</h5>
      <table class="table caption-top">
        <tbody>
          <tr>
            <th>자전거보관소</th>
            <td>{{ subwayInfo.bikeStorageYn }}</td>
          </tr>
          <tr>
            <th>E/V 유무</th>
            <td>{{ subwayInfo.elevatorYn }}</td>
          </tr>
          <tr>
            <th>물품보관실</th>
            <td>{{ subwayInfo.supplyRoomYn }}</td>
          </tr>
          <tr>
            <th>유실물센터</th>
            <td>{{ subwayInfo.lostPropertyCenterYn }}</td>
          </tr>
          <tr>
            <th>수유실</th>
            <td>{{ subwayInfo.lactationRoomYn }}</td>
          </tr>
          <tr>
            <th>휠체어 충전</th>
            <td>{{ subwayInfo.wheelchairChargingYn }}</td>
          </tr>
        </tbody>
      </table>
    </b-modal>
    <!-- Video Modal End -->
  </div>
  <!-- 지하철 서비스 끝 -->
</template>

<script>
import http from "@/util/http"; // 지하철 역 정보 불러오기용

export default {
  name: "TrainView",

  created() {
    // spring에서 비동기로 지하철 불러오기
    http.get(`/traffic/getsubway`).then(({ data }) => {
      this.subwayListInfo = data;
      //console.log(this.subwayListInfo);
    });
  },
  data() {
    return {
      subwaymodalShow: false,
      subwayListInfo: [],
      // 버스 불러오기 테스트용
      subwayInfo: {
        stationCode: "",
        stationName: "",
        elevatorFac: "",
        stationAddr: "",
        stationExit: "",
        stationStruct: "",
        stationTel: "",
        stationArea: "",
        bikeStorageYn: "",
        elevatorYn: "",
        lactationRoomYn: "",
        lostPropertyCenterYn: "",
        wheelchairChargingYn: "",
        supplyRoomYn: "",
      },
    };
  },

  methods: {
    showSubwayInfo(idx) {
      //console.log(idx);
      this.subwayInfo.stationName = this.subwayListInfo[idx].stationName;
      this.subwayInfo.elevatorFac = this.subwayListInfo[idx].elevatorFac;
      this.subwayInfo.stationAddr = this.subwayListInfo[idx].stationAddr;
      this.subwayInfo.stationExit = this.subwayListInfo[idx].stationExit;
      this.subwayInfo.stationStruct = this.subwayListInfo[idx].stationStruct;
      this.subwayInfo.stationTel = this.subwayListInfo[idx].stationTel;
      this.subwayInfo.stationArea = this.subwayListInfo[idx].stationArea;
      this.subwayInfo.bikeStorageYn = this.subwayListInfo[idx].bikeStorageYn;
      this.subwayInfo.elevatorYn = this.subwayListInfo[idx].elevatorYn;
      this.subwayInfo.lactationRoomYn = this.subwayListInfo[idx].lactationRoomYn;
      this.subwayInfo.lostPropertyCenterYn = this.subwayListInfo[idx].lostPropertyCenterYn;
      this.subwayInfo.wheelchairChargingYn = this.subwayListInfo[idx].wheelchairChargingYn;
      this.subwayInfo.supplyRoomYn = this.subwayListInfo[idx].supplyRoomYn;
      this.subwayInfo.stationCode = this.subwayListInfo[idx].stationCode;
      this.subwaymodalShow = !this.subwaymodalShow;
    },
    printbuslist() {
      var list = [];
      for (var i = 4; i < this.busstops.length; i += 4) list.push(i);
      return list;
    },
    getBusInfo(name, id, idx) {
      //console.log(name);
      this.busstop_info.stopname = name;
      this.busstop_info.stopid = id;
      this.busstop_info.stopindex = idx;

      http.get(`/traffic/getbusinfo/${id}`).then(({ data }) => {
        console.log(data.ServiceResult.msgBody);
        this.busstop_info_list = data.ServiceResult.msgBody.itemList;
        //console.log(this.busstop_info_list);
      });
    },
  },
};
</script>

<style>
#daejeon_subway {
  width: 800px;
  margin: auto;
  margin-top: 30px;
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
  background-color: #ca0c0c;
}

#traingif {
  width: 15%;
}

#daejeon_subway_all {
  width: 100%;
}

#carouselTrain ol li {
  background-color: #ffffff !important;
  width: 22px;
  height: 22px;
  margin: 12px;
  letter-spacing: 0.5px !important;
}

#carouselTrain ol li div {
  width: 20px;
  height: 20px;
  background-color: #007448 !important;
  border-radius: 20px 20px 20px 20px !important;
  padding-top: 3px;
}

#carouselTrain ol li div div {
  width: 14px;
  height: 14px;
  background-color: #ffffff !important;
  border-radius: 15px 15px 15px 15px !important;
  margin-left: 3px;
}

#carouselTrain .carousel-indicators {
  margin-bottom: -4em !important;
}
</style>
