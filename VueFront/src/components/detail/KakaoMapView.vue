<template>
  <div class="row">
    <div class="col-6">
      <!-- Kakao Map start -->
      <div class="container bg-white border px-0">
        <div id="map" style="width: 100%; height: 600px"></div>
      </div>
    </div>

    <div class="col-6">
      <div
        class="container mb-3 p-5 bg-white border rounded-3 searchTableBox"
        style="height: 600px; overflow: auto"
      >
        <!-- 버튼 -->
        <div
          v-show="isNearList"
          id="buttonList"
          class="mt-4 mb-2 row text-center justify-content-md-center"
        >
          <h3 class="text-center">찾고 싶은 상권을 선택해 주세요</h3>
          <button
            type="button"
            id="Q"
            class="col-5 m-2 btn btn-outline-primary btn-lg"
            @click="nearSearchShow('Q')"
          >
            <img src="@/assets/img/nearlist_food.png" alt="" class="m-2 img-fluid" />
            <br />음식
          </button>
          <button
            type="button"
            id="O"
            class="col-5 m-2 btn btn-outline-primary btn-lg"
            @click="nearSearchShow('O')"
          >
            <img src="@/assets/img/nearlist_accomodation.png" alt="" class="m-2 img-fluid" />
            <br />숙박
          </button>
          <button
            type="button"
            id="P"
            class="col-5 m-2 btn btn-outline-primary btn-lg"
            @click="nearSearchShow('P')"
          >
            <img src="@/assets/img/nearlist_sport.png" alt="" class="m-2 img-fluid" />
            <br />스포츠
          </button>
          <button
            type="button"
            id="N"
            class="col-5 m-2 btn btn-outline-primary btn-lg"
            @click="nearSearchShow('N')"
          >
            <img src="@/assets/img/nearlist_tour.png" alt="" class="m-2 img-fluid" />
            <br />관광/여가/오락
          </button>
          <button
            type="button"
            id="G"
            class="col-5 m-2 btn btn-outline-primary btn-lg"
            @click="nearSearchShow('G')"
          >
            <img src="@/assets/img/nearlist_realestate.png" alt="" class="m-2 img-fluid" />
            <br />부동산
          </button>
          <button
            type="button"
            id="F"
            class="col-5 m-2 btn btn-outline-primary btn-lg"
            @click="nearSearchShow('F')"
          >
            <img src="@/assets/img/nearlist_service.png" alt="" class="m-2 img-fluid" />
            <br />생활서비스
          </button>
          <button
            type="button"
            id="D"
            class="col-5 m-2 btn btn-outline-primary btn-lg"
            @click="nearSearchShow('D')"
          >
            <img src="@/assets/img/nearlist_retail.png" alt="" class="m-2 img-fluid" />
            <br />소매
          </button>
          <button
            type="button"
            id="R"
            class="col-5 m-2 btn btn-outline-primary btn-lg"
            @click="nearSearchShow('R')"
          >
            <img src="@/assets/img/nearlist_education.png" alt="" class="m-2" />
            <br />학문/교육
          </button>
        </div>

        <!-- 리스트 -->
        <div
          id="accordion"
          role="tablist"
          class="panel-group"
          aria-multiselectable="true"
          v-show="!isNearList"
        >
          <button type="button" class="btn btn-outline-primary col" @click="buttonShow">
            돌아가기
          </button>
          <!-- button start -->
          <div
            v-for="(item, i) in nearList"
            :key="i"
            type="button"
            :id="'storeinfo' + i"
            class="p-2 my-3 border rounded row"
            data-toggle="collapse"
            :href="'#toggle' + i"
            role="button"
            aria-expanded="false"
            :aria-controls="'toggle' + i"
          >
            <div class="col align-self-center">
              <div class="">
                <span class="fs-4 pe-3">{{ item.bizesNm }}</span>
              </div>

              <div class="collapse" :id="'toggle' + i" data-parent="#accordion">
                <div class="row">
                  <div class="col">
                    <span class="pe-3" style="color: gray">전용면적</span>
                    <span>{{ item.indsSclsNm }}</span>
                  </div>
                  <div class="col">
                    <span class="pe-3" style="color: gray">층수</span>
                    <span>{{ item.lnoAdr }}</span>
                  </div>
                </div>
                <div class="row">
                  <div class="col">
                    <span class="pe-3" style="color: gray">보증금액</span>
                    <span>{{ item.rdnmAdr }}</span>
                  </div>
                  <div class="col">
                    <span class="pe-3" style="color: gray">월세</span>
                    <span>{{ item.lat }} {{ item.lon }}</span>
                  </div>
                </div>

                <div class="row">
                  <div class="col">
                    <span class="pe-3" style="color: gray">법정동</span>
                    <span>{{ item.법정동 }}</span>
                  </div>
                  <div class="col">
                    <span class="pe-3" style="color: gray">건축년도</span>
                    <span>{{ item.건축년도 }}</span>
                  </div>
                  <!-- <div class="col">
              <a id="copy" style="color: #8797c7" href="#" onclick="callFunction();">복사</a>
            </div> -->
                </div>
              </div>
            </div>
          </div>
          <!-- button end -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http"; // 게시판 테스트용
export default {
  data() {
    return {
      isNearList: true,
      map: null,
      markers: [],
      nearList: [],
    };
  },
  created() {},
  methods: {
    nearSearchShow(id) {
      let _this = this;
      this.nearList = [];
      console.log("near search show");
      this.isNearList = !this.isNearList;
      http
        .get(`/map/store/${this.$route.params.lng}/${this.$route.params.lat}/` + id)
        .then(({ data }) => {
          //console.log(data);
          console.log(data.response.body.items.item);
          this.nearList = data.response.body.items.item;
          console.log(this.nearList);
          for (let i = 0; i < _this.nearList.length; i++) {
            let marker = new kakao.maps.Marker({
              map: this.map, // 마커를 표시할 지도
              position: new kakao.maps.LatLng(this.nearList[i].lat, this.nearList[i].lng), // 마커를 표시할 위치
              title: this.nearList[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            });
            this.markers.push(marker);
          }
          console.log(this.markers);
          _this.displayMarker(this.markers);
        });
    },
    buttonShow() {
      console.log("button show");
      this.isNearList = !this.isNearList;
    },
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
      this.displayMarker([[this.$route.params.lat, this.$route.params.lng]]);
    },
    displayMarker(markerPositions) {
      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }

      const positions = markerPositions.map((position) => new kakao.maps.LatLng(...position));

      if (positions.length > 0) {
        this.markers = positions.map(
          (position) =>
            new kakao.maps.Marker({
              map: this.map,
              position,
            })
        );

        const bounds = positions.reduce(
          (bounds, latlng) => bounds.extend(latlng),
          new kakao.maps.LatLngBounds()
        );

        this.map.setBounds(bounds);
      }
    },
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
};
</script>

<style></style>
