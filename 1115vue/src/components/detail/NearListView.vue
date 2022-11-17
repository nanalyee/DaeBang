<template>
  <div>
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
          @click="nearSearchShow"
        >
          <img src="@/assets/img/nearlist_food.png" alt="" class="m-2 img-fluid" />
          <br />음식
        </button>
        <button
          type="button"
          id="O"
          class="col-5 m-2 btn btn-outline-primary btn-lg"
          @click="nearSearchShow"
        >
          <img src="@/assets/img/nearlist_accomodation.png" alt="" class="m-2 img-fluid" />
          <br />숙박
        </button>
        <button
          type="button"
          id="P"
          class="col-5 m-2 btn btn-outline-primary btn-lg"
          @click="nearSearchShow"
        >
          <img src="@/assets/img/nearlist_sport.png" alt="" class="m-2 img-fluid" />
          <br />스포츠
        </button>
        <button
          type="button"
          id="N"
          class="col-5 m-2 btn btn-outline-primary btn-lg"
          @click="nearSearchShow"
        >
          <img src="@/assets/img/nearlist_tour.png" alt="" class="m-2 img-fluid" />
          <br />관광/여가/오락
        </button>
        <button
          type="button"
          id="G"
          class="col-5 m-2 btn btn-outline-primary btn-lg"
          @click="nearSearchShow"
        >
          <img src="@/assets/img/nearlist_realestate.png" alt="" class="m-2 img-fluid" />
          <br />부동산
        </button>
        <button
          type="button"
          id="F"
          class="col-5 m-2 btn btn-outline-primary btn-lg"
          @click="nearSearchShow"
        >
          <img src="@/assets/img/nearlist_service.png" alt="" class="m-2 img-fluid" />
          <br />생활서비스
        </button>
        <button
          type="button"
          id="D"
          class="col-5 m-2 btn btn-outline-primary btn-lg"
          @click="nearSearchShow"
        >
          <img src="@/assets/img/nearlist_retail.png" alt="" class="m-2 img-fluid" />
          <br />소매
        </button>
        <button
          type="button"
          id="R"
          class="col-5 m-2 btn btn-outline-primary btn-lg"
          @click="nearSearchShow"
        >
          <img src="@/assets/img/nearlist_education.png" alt="" class="m-2" />
          <br />학문/교육
        </button>
      </div>

      <!-- 리스트 -->
      <div id="nearSearch" class="" v-show="!isNearList">
        <button type="button" class="btn btn-outline-primary col" @click="buttonShow">
          돌아가기
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isNearList: true,
    };
  },
  methods: {
    nearSearchShow() {
      console.log("near search show");
      this.isNearList = !this.isNearList;
    },
    buttonShow() {
      console.log("button show");
      this.isNearList = !this.isNearList;
    },
  },
};
</script>

<style></style>
