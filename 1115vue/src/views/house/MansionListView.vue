<template>
  <div>
    <h3>맨션 컴포넌트</h3>
    <!-- button start -->
    <div
      type="button"
      id="storeinfo"
      class="p-2 my-3 border rounded row"
      v-on:click="tableClick(item.도로명)"
      data-toggle="collapse"
      href="#multiCollapseExample2"
      role="button"
      aria-expanded="false"
      aria-controls="multiCollapseExample2"
    >
      <div class="col align-self-center">
        <div class="">
          <span class="fs-4 pe-3">싸피맨션</span>
          <span style="color: gray">연립주택</span>
        </div>

        <div class="row collapse multi-collapse" id="multiCollapseExample2">
          <div class="col-auto">
            <span class="pe-1" style="color: gray">면적</span>
            <span>39평</span>
          </div>
          <div class="col">
            <span class="pe-1" style="color: gray">층수</span>
            <span>4층</span>
          </div>
        </div>
        <div class="row collapse multi-collapse" id="multiCollapseExample2">
          <div class="col-auto">
            <span class="pe-3" style="color: gray">도로명주소</span>
            <span>대전시 유성구 학하서로</span>
          </div>
          <div class="col">
            <a id="copy" style="color: #8797c7" href="#" onclick="callFunction();">복사</a>
          </div>
        </div>
        <div class="row collapse multi-collapse" id="multiCollapseExample2">
          <div class="col-auto">
            <span class="pe-3" style="color: gray">지번주소</span>
            <span>대전시 유성구 학하서로</span>
          </div>
          <div class="col">
            <a id="copy" style="color: #8797c7" href="#" onclick="callFunction();">복사</a>
          </div>
        </div>
      </div>
      <div class="col-3 collapse multi-collapse" id="multiCollapseExample2">
        <img class="img-fluid img-thumbnail rounded" :src="$store.state.houseimg" alt="" />
      </div>
      <div class="col-1 text-right align-self-center collapse multi-collapse" id="multiCollapseExample2">
        <a href="#" class="golink" v-on:click="goDetail">
          <i class="bi bi-chevron-compact-right fs-1"></i>
        </a>
      </div>
    </div>
    <!-- button end -->
    <table>
      <tr>
        <th>거래유형</th>
        <th>거래금액</th>
        <th>도로명</th>
        <th>건축년도</th>
      </tr>
      <tr v-for="(item, i) in houses" :key="i">
        <td v-html="item.거래유형"></td>
        <td v-html="item.거래금액"></td>
        <td v-html="item.도로명"></td>
        <td v-html="item.건축년도"></td>
      </tr>
    </table>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  name: "AppSearch",
  data() {
    return {};
  },
  created() {
    console.log(this.$route.params.gugun);
  },
  computed: {
    ...mapState(["houses"]),
  },
  methods: {
    ...mapActions(["getTitleImg"]),
    ...mapMutations([]),

    tableClick(title) {
      console.log("table click");
      this.getTitleImg(title + "주택");
    },
    goDetail() {
      console.log("go detail view");
    },
  },
};
</script>

<style></style>
