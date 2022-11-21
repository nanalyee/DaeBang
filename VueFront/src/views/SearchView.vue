<template>
  <div class="search">
    <!-- Header Start -->
    <div class="container-fluid bg-light my-6 mt-0" id="home">
      <div class="container">
        <div class="row g-5 pt-5 align-items-center">
          <div class="col-lg-7 pb-5 pr-0">
            <img class="img-fluid text-center" src="@/assets/img/houseSearch.png" alt="" />
          </div>
          <div class="col-lg-5 py-6 pb-0 pt-lg-0">
            <h4 class="text-primary mb-3">국토교통부 공공데이터 기반</h4>
            <h1 class="display-5 mb-3">대전 매매 검색</h1>
            <h2 class="typed-text-output d-inline"></h2>
            <div class="typed-text">
              2018~2022년의 구군별 매달 대전시 매매 기록을 모았습니다.<br />
              오피스텔, 아파트, 다세대주택, 원룸 원하는 타입별로<br />
              한눈에 확인해보세요.<br />
            </div>
            <div class="d-flex align-items-center pt-5">
              <!-- <button @click="modalShow = !modalShow">Open Modal</b-button> -->
              <!-- <b-button @click="show" type="button" class="btn-play"> -->
              <b-button type="button" class="btn-play">
                <span></span>
              </b-button>
              <h5 class="ms-4 mb-0 d-none d-sm-block">소개영상</h5>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Header End -->
    <div class="container py-5">
      <div class="row">
        <div class="col-3">
          <div class="m-2 border">
            <div class="m-3 pb-3 border-bottom">
              <h5 class="form-label pt-3">타입</h5>
              <div>원하는 타입을 골라주세요.</div>
              <template>
                <div class="my-2">
                  <b-form-radio-group
                    class="col-auto px-1"
                    id="type"
                    v-model="typeSelected"
                    :options="typeOptions"
                    @change="resetGugun"
                    name="radio-options"
                    switches
                  ></b-form-radio-group>
                </div>
              </template>
              <div>타입 선택 후 지역 재선택 필수!!</div>
            </div>
            <div class="m-3 pb-3 border-bottom">
              <h5 class="form-label pt-3">지역</h5>
              <div>원하는 구군, 동을 선택해주세요.</div>
              <div class="form-group my-2">
                <b-form-select
                  class="form-select col-auto"
                  id="gugun"
                  v-model="gugunSelected"
                  :options="gugunOptions"
                  @change="resetYear"
                >
                </b-form-select>
              </div>
              <!-- <div class="form-group my-2">
                <b-form-select class="form-select col-auto" id="dong" v-model="dongSelected" :options="dongOptions">
                </b-form-select>
              </div> -->
            </div>
            <div class="m-3 pb-3">
              <h5 class="form-label pt-3">기간</h5>
              <div>원하는 년도, 월을 선택해주세요.</div>
              <div class="form-group my-2">
                <b-form-select
                  class="form-select col-auto"
                  id="gugun"
                  v-model="yearSelected"
                  :options="yearOptions"
                  @change="resetMonth"
                >
                </b-form-select>
              </div>
              <div class="form-group my-2">
                <b-form-select class="form-select col-auto" id="gugun" v-model="monthSelected" :options="monthOptions">
                </b-form-select>
              </div>
            </div>
          </div>
          <div class="d-grid gap-2 p-2">
            <button type="button" id="list-btn" class="btn btn-primary" @click="searchApt">검색</button>
          </div>
        </div>
        <div class="col px-4 mx-4">
          <!-- <div>
            <h5 class="text-right mt-4">검색결과 총 {{ $store.state.count }}건</h5>
          </div> -->
          <div class="text-center" v-if="!showList">
            <img class="img-fluid text-center" src="@/assets/img/empty.gif" alt="" style="width: 500px" />
            <p>타입, 지역, 기간을 설정해주세요</p>
          </div>
          <router-view v-else></router-view>
        </div>
        <div id="searchtype">
          {{ searchType }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapMutations } from "vuex";

export default {
  name: "AppSearch",
  data() {
    return {
      sidoCode: "3000000000",
      startPage: 1,
      currPage: 1,
      totalPage: 1,
      endPage: 1,
      apts: [], // 아파트 목록 저장할 배열
      showList: false,

      // gugun
      gugunSelected: null,
      gugunOptions: [
        { value: null, text: "구군선택" },
        { value: "30230", text: "대덕구" },
        { value: "30110", text: "동구" },
        { value: "30170", text: "서구" },
        { value: "30200", text: "유성구" },
        { value: "30140", text: "중구" },
      ],
      // dong
      dongSelected: null,
      dongOptions: [
        { value: null, text: "동선택" },
        { value: "1", text: "This is First option" },
        { value: "2", text: "Selected Option" },
        { value: "3", text: "This is an option with object value" },
        { value: "4", text: "This one is disabled" },
      ],
      // type
      typeSelected: null,
      typeOptions: [
        { value: "searchOffice", text: "오피스텔" },
        { value: "searchApt", text: "아파트" },
        { value: "searchMansion", text: "다세대주택" },
        { value: "searchRoom", text: "원룸" },
      ],
      // year
      yearSelected: null,
      yearOptions: [
        { value: null, text: "년도선택" },
        { value: "2018", text: "2018년" },
        { value: "2019", text: "2019년" },
        { value: "2020", text: "2020년" },
        { value: "2021", text: "2021년" },
        { value: "2022", text: "2022년" },
      ],
      // month
      monthSelected: null,
      monthOptions: [
        { value: null, text: "월선택" },
        { value: "1", text: "1월" },
        { value: "2", text: "2월" },
        { value: "3", text: "3월" },
        { value: "4", text: "4월" },
        { value: "5", text: "5월" },
        { value: "6", text: "6월" },
        { value: "7", text: "7월" },
        { value: "8", text: "8월" },
        { value: "9", text: "9월" },
        { value: "10", text: "10월" },
        { value: "11", text: "11월" },
        { value: "12", text: "12월" },
      ],
    };
  },
  computed: {
    // ...mapState(["sidos", "guguns", "houses"]),
    searchType() {
      console.log(this.typeSelected);
      //return this.$router.push({ name: this.typeSelected });
      this.searchBtn(this.typeSelected);
      return this.typeSelected;
    },
  },
  methods: {
    ...mapActions(["getHouseList"]),
    ...mapMutations(["SET_HOUSE_TYPE", "CLEAR_APT_LIST", "SET_DATE_TYPE"]),

    resetGugun() {
      this.gugunSelected = null;
      this.CLEAR_APT_LIST();
      this.showList = false;
    },
    resetYear() {
      this.yearSelected = null;
      this.monthSelected = null;
      this.showList = false;
    },
    resetMonth() {
      this.monthSelected = null;
      this.CLEAR_APT_LIST();
      this.showList = false;
    },
    searchApt() {
      console.log(this.gugunSelected);
      //// mutations에서 type set 해주기
      //this.SET_HOUSE_TYPE(this.$route.query.name);
      this.SET_HOUSE_TYPE(this.typeSelected);
      if (this.monthSelected < 10) {
        //this.monthSelected = "0" + this.monthSelected;
        this.SET_DATE_TYPE(this.yearSelected + "0" + this.monthSelected);
      } else {
        this.SET_DATE_TYPE(this.yearSelected + this.monthSelected);
      }
      this.getHouseList(this.gugunSelected);
      this.showList = true;
    },
    searchBtn(link) {
      console.log("search btn click");
      if (!this.gugunSelected || !this.typeSelected) {
        //alert("선택해주세요");
      } else {
        console.log(this.gugunSelected + "\n" + this.dongSelected + "\n" + this.typeSelected);
        this.$router
          .push({ name: link, params: { gugun: this.gugunSelected, dong: this.dongSelected } })
          .catch(() => {});
      }
    },
  },
};
</script>

<style>
#storeinfo:hover {
  background-color: rgba(211, 211, 211, 0.373);
}

.bi-chevron-compact-right {
  color: lightgray;
}

.golink > i:hover {
  color: #a4b4e2;
}

#searchtype {
  display: none;
}
</style>
