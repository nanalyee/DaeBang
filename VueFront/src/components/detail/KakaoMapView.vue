<template>
  <div>
    <!-- Kakao Map start -->
    <div class="container bg-white border px-0">
      <div id="map" style="width: 100%; height: 600px"></div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      map: null,
    };
  },
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(37.2429362, 131.8624647, 16),
        level: 5,
      };
      this.map = new kakao.maps.Map(container, options);
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
      console.log("이미 로딩됨:", window.kakao);
      this.initMap();
    }
  },
};
</script>

<style></style>
