<template>
  <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
    <h3>아파트 컴포넌트</h3>
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
      <div class="col-1 text-right align-self-center collapse" :id="'toggle' + i" data-parent="#accordion">
        <a href="#" class="golink" v-on:click="goDetail">
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
      test: "toggle",
    };
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
      this.getTitleImg(title + "아파트");
    },
    goDetail() {
      console.log("go detail view");
    },
  },
};
</script>

<style></style>
