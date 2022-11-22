<template>
  <div>
    <div id="map"></div>
  </div>
</template>

<script>
import http from "@/util/http"; // 타슈 불러오기
export default {
  name: "TashuMap",
  data() {
    return {
      map: null,
      markerPositions1: [],
      markerPositions2: [
        [37.499590490909185, 127.0263723554437],
        [37.499427948430814, 127.02794423197847],
        [37.498553760499505, 127.02882598822454],
        [37.497625593121384, 127.02935713582038],
        [37.49629291770947, 127.02587362608637],
        [37.49754540521486, 127.02546694890695],
        [37.49646391248451, 127.02675574250912],
      ],
      markers: [],
      infowindow: null,
      stationList: [], // 대여소 모든 정보
      markerStationList: [], // 대여소 위치 정보 배열
    };
  },
  created() {},
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=915cffed372954b7b44804ed422b9cf0&libraries=services,clusterer,drawing";
      document.head.appendChild(script);
    }

    http.get(`/traffic/tashu`).then(({ data }) => {
      //console.log(data);
      this.stationList = data.results;
      //console.log(this.stationList);

      for (let i = 0; i < this.stationList.length; i++) {
        this.markerPositions1.push({
          title: this.stationList[i].name,
          address: this.stationList[i].address,
          parking_count: this.stationList[i].parking_count,
          latlng: new kakao.maps.LatLng(this.stationList[i].x_pos, this.stationList[i].y_pos),
        });
      }

      this.displayMarkers(this.markerPositions1);
      //console.log(this.markers);
    });
  },
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(36.34994034353652, 127.38878670350663),
        level: 4,
      };

      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options);
    },
    displayMarkers(positions) {
      // 1. 현재 표시되어있는 marker들이 있다면 marker에 등록된 map을 없애준다.
      if (this.markers.length > 0) {
        this.markers.forEach((item) => {
          item.setMap(null);
        });
      }

      // 2. 마커 이미지 커스터마이징 하기
      // javascript 영역에서 assets의 정보 가져오기
      //const imgSrc = require("@/assets/img/marker/store.png");
      //const imgSize = new kakao.maps.Size(24, 35);
      //const markerImage = new kakao.maps.MarkerImage(imgSrc, imgSize);

      // 3. 마커 표시하기
      positions.forEach((position) => {
        // information window 생성
        const infowindow = new kakao.maps.InfoWindow({
          removable: true,
          content: `
          <div style="padding:5px;">이름 ${position.title}<br/>
          주소 ${position.address}<br/>
          대여 가능 대수 ${position.parking_count}</div>
          `,
        });

        const marker = new kakao.maps.Marker({
          map: this.map,
          position: position.latlng,
          //image: markerImage,
        });
        // 이벤트 등록
        //  kakao.maps.event.addListener(marker, "click", () => {infowindow.open(this.map, marker);});
        kakao.maps.event.addListener(marker, "mouseover", () => {
          infowindow.open(this.map, marker);
        });
        kakao.maps.event.addListener(marker, "mouseout", () => {
          infowindow.close(this.map, marker);
        });

        this.markers.push(marker);
      });

      // 4. 지도를 이동시켜주기
      // 배열.reduce( (누적값, 현재값, 인덱스, 요소)=>{ return 결과값}, 초기값);
      const bounds = positions.reduce(
        (bounds, position) => bounds.extend(position.latlng),
        new kakao.maps.LatLngBounds()
      );

      this.map.setBounds(bounds);
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#map {
  width: auto;
  height: 500px;
}

.button-group {
  margin: 10px 30px;
}

button {
  margin: 0 3px;
}
</style>
