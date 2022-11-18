<template>
  <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
    <h3>아파트 컴포넌트</h3>
    <div>
      <!-- Kakao Map start -->
      <div class="container bg-white border px-0">
        <div id="map" style="width: 100%; height: 200px"></div>
        <div id="clickLatlng"></div>
      </div>
    </div>
    <!-- button start -->
    <div
      v-for="(item, i) in houses"
      :key="i"
      type="button"
      :id="'storeinfo' + i"
      class="p-2 my-3 border rounded row"
      v-on:click="tableClick(item.아파트)"
      data-toggle="collapse"
      :href="'#toggle' + i"
      role="button"
      aria-expanded="false"
      :aria-controls="'toggle' + i"
    >
      <div class="col align-self-center">
        <div class="">
          <span class="fs-4 pe-3" v-html="item.아파트"></span>
          <span style="color: gray">아파트</span>
        </div>

        <div class="collapse" :id="'toggle' + i" data-parent="#accordion">
          <div class="row">
            <div class="col">
              <span class="pe-3" style="color: gray">전용면적</span>
              <span>{{ item.전용면적 }}</span>
            </div>
            <div class="col">
              <span class="pe-3" style="color: gray">층수</span>
              <span>{{ item.층 }}</span>
            </div>
          </div>
          <div class="row">
            <div class="col">
              <span class="pe-3" style="color: gray">보증금액</span>
              <span>{{ item.보증금액 }}</span>
            </div>
            <div class="col">
              <span class="pe-3" style="color: gray">월세</span>
              <span>{{ item.월세금액 }}</span>
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
      <div class="col-3 collapse" :id="'toggle' + i" data-parent="#accordion">
        <img class="img-fluid img-thumbnail rounded" :src="$store.state.houseimg" alt="" />
      </div>
      <div
        class="col-1 text-right align-self-center collapse"
        :id="'toggle' + i"
        data-parent="#accordion"
      >
        <a href="#" class="golink" v-on:click="goDetail(i)">
          <i class="bi bi-chevron-compact-right fs-1"></i>
        </a>
      </div>
    </div>
    <!-- button end -->
    <!-- <table>
      <tr>
        <th>아파트</th>
        <th>거래금액</th>
        <th>도로명</th>
        <th>건축년도</th>
      </tr>
      <tr v-for="(item, i) in houses" :key="i">
        <td v-html="item.아파트"></td>
        <td v-html="item.보증금액"></td>
        <td v-html="item.법정동"></td>
        <td v-html="item.건축년도"></td>
      </tr>
    </table> -->
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  name: "AppSearch",
  data() {
    return {
      map: null,
      markers: [],
      latitude: 0,
      longitude: 0,
      test: "toggle",
      code: "",
      gugun: "",
      gugunOptions: [
        { value: "30230", text: "대덕구" },
        { value: "30110", text: "동구" },
        { value: "30170", text: "서구" },
        { value: "30200", text: "유성구" },
        { value: "30140", text: "중구" },
      ],
    };
  },
  created() {
    console.log("파라미터를 불러옵니다" + this.$route.params.gugun);
    this.code = this.$route.params.gugun;
    if (!("geolocation" in navigator)) {
      return;
    }

    // 현재 위치 테스트 get position
    navigator.geolocation.getCurrentPosition(
      (pos) => {
        this.latitude = pos.coords.latitude;
        this.longitude = pos.coords.longitude;

        if (window.kakao && window.kakao.maps) {
          this.initMap();
        } else {
          const script = document.createElement("script");
          /* global kakao */
          script.onload = () => kakao.maps.load(this.initMap);
          script.src =
            "//dapi.kakao.com/v2/maps/sdk.js?appkey=a3e55c472179c8eccedf2df013b0480a&libraries=services&autoload=false";
          document.head.appendChild(script);
        }
      },
      (err) => {
        alert(err.message);
      }
    );
  },
  computed: {
    ...mapState(["houses"]),
  },
  watch: {
    gugunText() {},
  },
  methods: {
    ...mapActions(["getTitleImg"]),
    ...mapMutations([]),

    tableClick(title) {
      console.log("table click");
      this.getTitleImg(title + "아파트");

      console.log(this.code + "파라미터로 불러온 코드");
      // 구군코드를 한글로 바꾸는 노가다
      for (let i = 0; i < 5; i++) {
        //console.log("반복문" + i + " " + this.gugunOptions[i].value + " " + this.code);
        if (this.gugunOptions[i].value == this.code) {
          //console.log("같습니다");
          this.gugun = this.gugunOptions[i].text;
          break;
        }
      }
    },

    goDetail(index) {
      // console.log(this.houses[index]);
      var _this = this;
      var keywords =
        "대전시 " +
        this.gugun +
        " " +
        this.houses[index].법정동 +
        " " +
        this.houses[index].아파트 +
        " 아파트";
      console.log("검색할 주소 : " + keywords);

      // 장소 검색 객체를 생성합니다
      var ps = new kakao.maps.services.Places();
      ps.keywordSearch(keywords, placesSearchCB);
      function placesSearchCB(data, status) {
        if (status === kakao.maps.services.Status.OK) {
          // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
          // LatLngBounds 객체에 좌표를 추가합니다
          var bounds = new kakao.maps.LatLngBounds();
          _this.displayMarker([[data[0].y, data[0].x]]);
          bounds.extend(new kakao.maps.LatLng(data[0].y, data[0].x));
          // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
          _this.map.setBounds(bounds);

          let lat = data[0].y;
          let lng = data[0].x;
          //console.log(lat + "," + lng + "의 좌표로 이동합니다");
          _this.$router.push({
            // 파라미터로 위도 경도를 보냅니다.
            name: "detail",
            params: { lat: lat, lng: lng },
          });
        }
      }
    },
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 5,
      };
      this.map = new kakao.maps.Map(container, options);
      this.displayMarker([[this.latitude, this.longitude]]);
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
};
</script>

<style></style>
