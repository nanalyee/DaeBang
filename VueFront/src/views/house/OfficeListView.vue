<template>
  <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
    <div class="search-wrapper row justify-content-between">
      <h5 class="mt-4 mb-2 col-auto">검색결과 총 {{ $store.state.count }}건</h5>
      <div class="col-auto align-self-end mb-2">
        <label></label>
        <input class="form-control" type="text" v-model="search" placeholder="이름으로 검색하기" />
      </div>
    </div>
    <div class="p-0 m-0 list" style="height: 700px; overflow: auto">
      <div class="text-center" v-if="$store.state.count == 0">
        <img class="img-fluid text-center" src="@/assets/img/empty.gif" alt="" style="width: 500px" />
        <p>검색 결과가 없습니다.</p>
      </div>
      <!-- button start -->
      <div
        v-for="(item, i) in filteredList"
        :key="i"
        type="button"
        id="storeinfo"
        class="py-2 my-2 mx-0 border rounded row"
        v-on:click="tableClick(item.단지)"
        data-toggle="collapse"
        :href="'#toggle' + i"
        role="button"
        aria-expanded="false"
        :aria-controls="'toggle' + i"
      >
        <div class="col align-self-center">
          <div class="">
            <span class="fs-4 pe-3">{{ item.단지 }}단지</span>
            <span style="color: gray">오피스텔</span>
          </div>

          <div class="collapse" :id="'toggle' + i" data-parent="#accordion">
            <div class="row">
              <div class="col">
                <span class="pe-3" style="color: gray">면적</span>
                <span>{{ item.전용면적 }}</span>
              </div>
              <div class="col">
                <span class="pe-3" style="color: gray">층수</span>
                <span>{{ item.층 }}층</span>
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
            </div>

            <div class="row">
              <div class="col">
                <span class="pe-3" style="color: gray">월세</span>
                <span>{{ item.월세 }}</span>
              </div>
              <div class="col">
                <span class="pe-3" style="color: gray">보증금</span>
                <span>{{ item.보증금 }}</span>
              </div>
            </div>
          </div>
        </div>
        <div class="col-3 collapse" :id="'toggle' + i" data-parent="#accordion">
          <img class="img-fluid img-thumbnail rounded" :src="$store.state.houseimg" alt="" />
        </div>
        <div class="col-1 text-right align-self-center collapse" :id="'toggle' + i" data-parent="#accordion">
          <a href="#" class="golink" v-on:click="goDetail(i)">
            <i class="bi bi-chevron-compact-right fs-1"></i>
          </a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  name: "AppSearch",
  data() {
    return {
      search: "",
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

    const script = document.createElement("script");
    /* global kakao */
    script.onload = () => kakao.maps.load(this.initMap);
    script.src =
      "//dapi.kakao.com/v2/maps/sdk.js?appkey=a3e55c472179c8eccedf2df013b0480a&libraries=services&autoload=false";
    document.head.appendChild(script);
  },
  computed: {
    ...mapState(["houses"]),
    filteredList() {
      return this.houses.filter((post) => {
        return post.단지.toLowerCase().includes(this.search.toLowerCase());
      });
    },
  },
  methods: {
    ...mapActions(["getTitleImg"]),
    ...mapMutations([]),

    tableClick(title) {
      console.log("table click");
      this.getTitleImg(title + "단지");

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
      var _this = this;
      var keywords =
        "대전시 " + this.gugun + " " + this.houses[index].법정동 + " " + this.houses[index].단지 + "오피스텔";
      console.log("검색할 주소 : " + keywords);

      // 장소 검색 객체를 생성합니다
      var ps = new kakao.maps.services.Places();
      ps.keywordSearch(keywords, placesSearchCB);
      function placesSearchCB(data, status) {
        if (status === kakao.maps.services.Status.OK) {
          let lat = data[0].y;
          let lng = data[0].x;
          //console.log(lat + "," + lng + "의 좌표로 이동합니다");
          _this.$router.push({
            // 파라미터로 위도 경도를 보냅니다.
            name: "detail",
            params: {
              wishname: _this.houses[index].아파트,
              wishtype: "오피스텔",
              gugunname: _this.gugun,
              dongname: _this.houses[index].법정동,
              lat: lat,
              lng: lng,
            },
          });
        } else console.log("해당 주소로 검색할 수 없음");
      }
    },
  },
};
</script>

<style>
.list::-webkit-scrollbar {
  padding-left: 8px;
  width: 8px; /* 스크롤바의 너비 */
}

.list::-webkit-scrollbar-thumb {
  height: 30%; /* 스크롤바의 길이 */
  background: #6b799e62; /* 스크롤바의 색상 */

  border-radius: 10px;
}

.list::-webkit-scrollbar-track {
  background: #6b799e0c; /*스크롤바 뒷 배경 색상*/
}
</style>
