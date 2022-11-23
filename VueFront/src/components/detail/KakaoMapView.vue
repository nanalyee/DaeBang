<template>
  <div class="row m-0">
    <div :class="size">
      <!-- Kakao Map start -->
      <div class="container bg-white border px-0 position-relative">
        <div id="map" style="width: 100%; height: 700px"></div>
        <b-button
          name="showBtn"
          v-show="status"
          v-b-toggle.list-collapse
          type="button"
          class="btn btn-outline-primary text-center p-0 m-0 py-1 open position-absolute float-right blink"
          @click="showList"
          style="width: 41px; height: 41px"
        >
          <i class="bi bi-shop fs-4"></i>
        </b-button>
      </div>
    </div>

    <div class="col-6">
      <b-collapse id="list-collapse">
        <div class="container mb-3 p-5 bg-white border rounded-3 searchTableBox" style="height: 700px; overflow: auto">
          <!-- 버튼 -->
          <div v-show="isNearList" id="buttonList">
            <div class="mb-2 row text-center justify-content-md-center">
              <h3 class="text-center">찾고 싶은 상권을 선택해 주세요</h3>
              <button
                type="button"
                id="Q"
                class="col-5 m-2 btn btn-outline-primary btn-lg"
                @click="nearSearchShow('Q', 'restaurant.png')"
              >
                <img src="@/assets/img/nearlist_food.png" alt="" class="m-2 img-fluid" />
                <br />음식
              </button>
              <button
                type="button"
                id="O"
                class="col-5 m-2 btn btn-outline-primary btn-lg"
                @click="nearSearchShow('O', 'bed.png')"
              >
                <img src="@/assets/img/nearlist_accomodation.png" alt="" class="m-2 img-fluid" />
                <br />숙박
              </button>
              <button
                type="button"
                id="P"
                class="col-5 m-2 btn btn-outline-primary btn-lg"
                @click="nearSearchShow('P', 'gym.png')"
              >
                <img src="@/assets/img/nearlist_sport.png" alt="" class="m-2 img-fluid" />
                <br />스포츠
              </button>
              <button
                type="button"
                id="N"
                class="col-5 m-2 btn btn-outline-primary btn-lg"
                @click="nearSearchShow('N', 'tour.png')"
              >
                <img src="@/assets/img/nearlist_tour.png" alt="" class="m-2 img-fluid" />
                <br />관광/여가/오락
              </button>
              <button
                type="button"
                id="G"
                class="col-5 m-2 btn btn-outline-primary btn-lg"
                @click="nearSearchShow('G', 'realestate.png')"
              >
                <img src="@/assets/img/nearlist_realestate.png" alt="" class="m-2 img-fluid" />
                <br />부동산
              </button>
              <button
                type="button"
                id="F"
                class="col-5 m-2 btn btn-outline-primary btn-lg"
                @click="nearSearchShow('F', 'life.png')"
              >
                <img src="@/assets/img/nearlist_service.png" alt="" class="m-2 img-fluid" />
                <br />생활서비스
              </button>
              <button
                type="button"
                id="D"
                class="col-5 m-2 btn btn-outline-primary btn-lg"
                @click="nearSearchShow('D', 'store.png')"
              >
                <img src="@/assets/img/nearlist_retail.png" alt="" class="m-2 img-fluid" />
                <br />소매
              </button>
              <button
                type="button"
                id="R"
                class="col-5 m-2 btn btn-outline-primary btn-lg"
                @click="nearSearchShow('R', 'study.png')"
              >
                <img src="@/assets/img/nearlist_education.png" alt="" class="m-2" />
                <br />학문/교육
              </button>
            </div>
            <div class="text-center">
              <v-button
                v-b-toggle.list-collapse
                type="button"
                class="btn btn-sm col-auto border-none p-0 text-center justify-self-center"
                @click="showList"
                >목록접기</v-button
              >
            </div>
          </div>

          <!-- 리스트 -->

          <div id="accordion" role="tablist" class="panel-group" aria-multiselectable="true" v-show="!isNearList">
            <div class="row">
              <v-button v-b-toggle.list-collapse type="button" class="btn btn-outline-primary col m-1" @click="showList"
                >목록접기</v-button
              >
              <button type="button" class="btn btn-outline-primary col m-1" @click="buttonShow">돌아가기</button>
            </div>
            <div class="row" style="height: 550px; overflow: auto">
              <!-- button start -->
              <div
                v-for="(item, i) in nearList"
                :key="i"
                type="button"
                :id="'storeinfo' + i"
                class="p-0 m-0 py-1 my-2 border rounded row"
                data-toggle="collapse"
                :href="'#toggle' + i"
                role="button"
                aria-expanded="false"
                :aria-controls="'toggle' + i"
                @click="nearDetail(i, item.lat, item.lon)"
              >
                <div class="col align-self-center">
                  <div class="">
                    <span class="fs-4 pe-3">{{ item.bizesNm }}</span>
                    <span class="pe-3" style="color: lightgray">{{ item.indsSclsNm }}</span>
                  </div>

                  <div class="collapse" :id="'toggle' + i" data-parent="#accordion">
                    <div class="row">
                      <div class="col-2">
                        <span class="" style="color: gray">지번주소</span>
                      </div>
                      <div class="col">
                        <span>{{ item.lnoAdr }}</span>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-2">
                        <span class="" style="color: gray">도로명</span>
                      </div>
                      <div class="col">
                        <span>{{ item.rdnmAdr }}</span>
                      </div>
                    </div>

                    <!-- <div class="row">
                  <div class="col">
                    <span class="pe-3" style="color: gray">법정동</span>
                    <span>{{ item.법정동 }}</span>
                  </div>
                  <div class="col">
                    <span class="pe-3" style="color: gray">건축년도</span>
                    <span>{{ item.건축년도 }}</span>
                  </div>
                  <span>{{ item.lat }} {{ item.lon }}</span>
                </div> -->
                  </div>
                </div>
              </div>
              <!-- button end -->
            </div>
          </div>
        </div>
      </b-collapse>
    </div>
  </div>
</template>

<script>
import http from "@/util/http"; // 게시판 테스트용
export default {
  data() {
    return {
      isNearList: true, // 주변 상권 정보 탭 끄고켜기
      map: null, // 지도
      startMarkers: [], // 시작점 마커 저장 배열
      nearMarkers: [], // 주변 상권 마커 저장 배열
      nearList: [], // 주변 상권 모든 정보 저장 배열
      nearCoord: [], // 주변 상권 위치 좌표 저장 배열
      overlay: null, // 커스텀 오버레이

      home: {
        imageSrc: require(`@/assets/img/marker/home.png`),
        imageSize: new kakao.maps.Size(64, 64),
        imageOption: { offset: new kakao.maps.Point(30, 69) },
      },
      homeImg: null,
      nearImg: null,

      size: "",
      status: true,
    };
  },
  mounted() {
    if (!window.kakao || !window.kakao.maps) {
      const script = document.createElement("script");
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=a3e55c472179c8eccedf2df013b0480a&libraries=services";
      // script.src = "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey="+process.env.VUE_APP_KAKAOMAP_KEY; 추후 이렇게 수정합니다.
      document.head.appendChild(script);

      /* global kakao */
      script.addEventListener("load", () => {
        kakao.maps.load(this.initMap);
      });
    } else {
      //console.log("이미 로딩됨:", window.kakao);
      this.initMap();
    }
  },
  methods: {
    // 맵을 처음 생성하고 시작지점을 찍음 ------------------------------------------------------
    initMap() {
      // 파라미터에서 위도경도를 불러오자
      console.log("lat: " + this.$route.params.lat);
      console.log("lng: " + this.$route.params.lng);

      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(this.$route.params.lat, this.$route.params.lng),
        level: 5,
      };
      this.map = new kakao.maps.Map(container, options);

      // 마커를 생성합니다
      this.startMarkers = [];
      this.homeImg = new kakao.maps.MarkerImage(this.home.imageSrc, this.home.imageSize, this.home.imageOption);

      console.log([[this.$route.params.lat, this.$route.params.lng]]);
      var coord = new kakao.maps.LatLng(this.$route.params.lat, this.$route.params.lng);
      var marker = new kakao.maps.Marker({
        position: coord,
        image: this.homeImg,
      });
      marker.setMap(this.map);
      this.startMarkers.push(marker);
    },

    // 상권 선택 버튼을 눌러 주변 상권을 보여줌 -------------------------------------------
    nearSearchShow(id, img) {
      let _this = this;
      this.nearList = [];
      this.nearCoord = [];
      console.log("near search show");
      this.isNearList = !this.isNearList;
      http.get(`/map/store/${this.$route.params.lng}/${this.$route.params.lat}/` + id).then(({ data }) => {
        //console.log(data);
        console.log(data.response.body.items.item);
        this.nearList = data.response.body.items.item;
        console.log(this.nearList);
        for (let i = 0; i < this.nearList.length; i++) {
          this.nearCoord.push([this.nearList[i].lat, this.nearList[i].lon]);
        }
        console.log(this.nearCoord);
        _this.displayMarker(this.nearCoord, img);
      });
    },

    // 돌아가기 버튼 눌러서 상권 선택창으로 돌아감 ---------------------------------------------------
    buttonShow() {
      this.nearCoord = [];
      console.log("button show");
      this.isNearList = !this.isNearList;
      // 주변 상권 마커들을 초기화한다.
      if (this.nearMarkers.length > 0) {
        this.nearMarkers.forEach((marker) => marker.setMap(null));
      }
      // 원래 위치로 되돌아간다
      this.initMap();
    },

    // 상권을 선택해 자세한 정보를 확인하고 해당 위치로 이동함 -------------------------------------------
    nearDetail(index, lat, lng) {
      if (this.overlay !== null) this.overlay.setMap(null);
      console.log(index + "번째 항목을 클릭했습니다." + lat + " " + lng);
      var moveLatLng = new kakao.maps.LatLng(lat, lng);
      this.map.panTo(moveLatLng);

      var box =
        `<div class="border rounded p-2 m-2 row justify-content-between bg-white">
          <div class="col">` +
        this.nearList[index].bizesNm +
        `</div>` +
        // <div class="col text-end">
        //   <a href="https://map.kakao.com/link/map/11394059">
        //     <i class="bi bi-chevron-compact-right"></i>
        //   </a>
        // </div>
        `</div>`;
      // `<div class="card" style="max-width: 18rem;">
      //   <div class="card-header">
      //     <div class="row">
      //       <h5 class="block col m-0">Header</h5>

      //       <div class="col text-lg-end">
      //         <button type="button float-right" class="btn-close"></button>
      //       </div>
      //     </div>
      //   </div>

      //   <div class="row">
      //     <div class="col-md-4 text-center align-self-center pl-4 pr-0">
      //       <img src="@/assets/img/nearlist_food.png" class="img-fluid rounded-start" alt="..." />
      //     </div>
      //     <div class="col-md-8">
      //       <div class="card-body pl-0">
      //         <h5 class="card-title">Card title</h5>
      //         <p class="card-text">
      //           This is a wider card with supporting text below as a natural lead-in to additional
      //           content. This content is a little bit longer.
      //         </p>
      //         <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
      //       </div>
      //     </div>
      //   </div>
      // </div>`;

      // 마커 위에 커스텀오버레이를 표시합니다
      this.overlay = new kakao.maps.CustomOverlay({
        content: box,
        map: this.map,
        position: this.nearMarkers[index].getPosition(),
        xAnchor: 0.5, // 커스텀 오버레이의 x축 위치입니다. 1에 가까울수록 왼쪽에 위치합니다. 기본값은 0.5 입니다
        yAnchor: 2.2, // 커스텀 오버레이의 y축 위치입니다. 1에 가까울수록 위쪽에 위치합니다. 기본값은 0.5 입니다
      });
      console.log(this.overlay);
      this.overlay.setMap(this.map);
    },

    // 상권마커!!! 위치좌표배열을 바탕으로 마커를 찍음 -------------------------------------------
    displayMarker(markerPositions, img) {
      if (this.nearMarkers.length > 0) {
        this.nearMarkers.forEach((marker) => marker.setMap(null));
      }

      this.nearImg = new kakao.maps.MarkerImage(
        require(`@/assets/img/marker/${img}`),
        this.home.imageSize,
        this.home.imageOption
      );

      const positions = markerPositions.map((position) => new kakao.maps.LatLng(...position));
      if (positions.length > 0) {
        this.nearMarkers = positions.map(
          (position) =>
            new kakao.maps.Marker({
              map: this.map,
              position,
              image: this.nearImg,
            })
        );
        const bounds = positions.reduce((bounds, latlng) => bounds.extend(latlng), new kakao.maps.LatLngBounds());
        this.map.setBounds(bounds);
      }
    },

    // 리스트를 펼치고 접음 --------------------------------------------------------------------------------------
    showList() {
      let mapDiv = document.getElementById("map");
      var _this = this;
      if (!this.status) {
        this.status = true;
        setTimeout(function () {
          _this.size = "";
          var position = _this.map.getCenter();
          mapDiv.style.width = "1272px";
          _this.map.relayout();
          _this.map.setCenter(position);
        }, 300);
      } else {
        this.status = false;
        setTimeout(function () {
          _this.size = "col-6";
          var position = _this.map.getCenter();
          mapDiv.style.width = "624px";
          _this.map.relayout();
          _this.map.setCenter(position);
        }, 50);
        //mapDiv.setAttribute("style", "width: 100%;  height: 700px");
      }
    },
  },
};
</script>

<style>
.row::-webkit-scrollbar {
  padding-left: 8px;
  width: 8px; /* 스크롤바의 너비 */
}

.row::-webkit-scrollbar-thumb {
  height: 30%; /* 스크롤바의 길이 */
  background: #6b799e62; /* 스크롤바의 색상 */

  border-radius: 10px;
}

.row::-webkit-scrollbar-track {
  background: #6b799e0c; /*스크롤바 뒷 배경 색상*/
}

.btn-lg > img {
  width: 50px;
}

.open {
  top: 30px;
  right: 30px;
  z-index: 999;
}

@keyframes blink-effect {
  50% {
    opacity: 0.8;
  }
}

.blink {
  animation: blink-effect 1s step-end infinite;

  /*
  animation-name: blink-effect;
  animation-duration: 1s;
  animation-iteration-count:infinite;
  animation-timing-function:step-end;
  */
}
</style>
