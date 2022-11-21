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
        v-on:click="tableClick(item.법정동)"
        data-toggle="collapse"
        :href="'#toggle' + i"
        role="button"
        aria-expanded="false"
        :aria-controls="'toggle' + i"
      >
        <div class="col align-self-center">
          <div class="">
            <span class="fs-4 pe-3">{{ item.법정동 }}</span>
            <span style="color: gray">원룸</span>
          </div>
          <div class="collapse" :id="'toggle' + i" data-parent="#accordion">
            <div class="row">
              <div class="col">
                <span class="pe-3" style="color: gray">면적</span>
                <span>{{ item.계약면적 }}</span>
              </div>
              <div class="col">
                <span class="pe-3" style="color: gray">건축년도</span>
                <span>{{ item.건축년도 }}</span>
              </div>
            </div>
            <div class="row">
              <div class="col">
                <span class="pe-3" style="color: gray">월세</span>
                <span>{{ item.월세금액 }}</span>
              </div>
              <div class="col">
                <span class="pe-3" style="color: gray">보증금</span>
                <span>{{ item.보증금액 }}</span>
              </div>
            </div>
            <!-- <div class="row collapse multi-collapse" :id="'toggle' + i">
          <div class="col-auto">
            <span class="pe-3" style="color: gray">지번주소</span>
            <span>대전시 유성구 학하서로</span>
          </div>
          <div class="col">
            <a id="copy" style="color: #8797c7" href="#" onclick="callFunction();">복사</a>
          </div>
        </div> -->
          </div>
        </div>
        <div class="col-3 collapse" :id="'toggle' + i" data-parent="#accordion">
          <img class="img-fluid img-thumbnail rounded" :src="$store.state.houseimg" alt="" />
        </div>
        <div class="col-1 text-right align-self-center collapse" :id="'toggle' + i" data-parent="#accordion">
          <!-- <a href="#" class="golink" v-on:click="goDetail">
          <i class="bi bi-chevron-compact-right fs-1"></i>
        </a> -->
        </div>
      </div>
      <!-- button end -->
      <!-- <table>
      <tr>
        <th>건축년도</th>
        <th>계약면적</th>
        <th>법정동</th>
        <th>월세금액</th>
        <th>보증금액</th>
      </tr>
      <tr v-for="(item, i) in houses" :key="i">
        <td v-html="item.건축년도"></td>
        <td v-html="item.계약면적"></td>
        <td v-html="item.법정동"></td>
        <td v-html="item.월세금액"></td>
        <td v-html="item.보증금액"></td>
      </tr>
    </table> -->
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
    };
  },
  computed: {
    ...mapState(["houses"]),
    filteredList() {
      return this.houses.filter((post) => {
        return post.법정동.toLowerCase().includes(this.search.toLowerCase());
      });
    },
  },
  methods: {
    ...mapActions(["getTitleImg"]),
    ...mapMutations([]),

    tableClick(title) {
      console.log("table click");
      this.getTitleImg(title + "빌라");
    },
    goDetail() {
      console.log("go detail view");
      this.$router.push({ name: "detail", params: { lat: "0", lng: "0" } });
    },
  },
};
</script>

<style></style>
