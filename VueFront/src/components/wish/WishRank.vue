<template>
  <div class="container">
    <div class="row g-5 mb-5 wow fadeInUp" data-wow-delay="0.1s">
      <div class="col text-center">
        <h1 class="display-5 mb-0">{{ userInfo.username }} 님의 관심 지역 랭킹</h1>
      </div>
      <!-- <div class="col-lg-6 text-lg-end">
        <a class="btn btn-primary py-3 px-5" href="https://www.data.go.kr/">공공데이터 포털</a>
      </div> -->
    </div>
    <div class="row justify-content-center">
      <div class="col-lg-7 pr-0">
        <div class="container mb-3 row" id="stage">
          <div class="col" style="height: 500px; overflow: auto">
            <div class="row" style="height: 230px; overflow: auto">
              <div class="col align-self-end text-center">
                <img
                  src="@/assets/img/marker/second.png"
                  alt=""
                  class="img img-fluid display-block"
                  style="width: 100px"
                />
              </div>
            </div>
            <div class="row-6">
              <div class="col align-self-end px-3">
                <div
                  id="second"
                  type="button"
                  class="btn btn-outline-primary col"
                  style="height: 250px; overflow: auto"
                >
                  <div class="fs-4 pt-3">{{ this.wishhouse[this.scoreboard[1][1]].wishname }}</div>
                  <div class="fs-5">{{ this.wishhouse[this.scoreboard[1][1]].wishtype }}</div>
                  <div class="fs-5 pt-2" style="color: #5f5f5f">{{ this.scoreboard[1][0] }}점</div>
                </div>
              </div>
            </div>
          </div>

          <div class="col" style="height: 500px; overflow: auto">
            <div class="row" style="height: 120px; overflow: auto">
              <div class="col align-self-end text-center">
                <img
                  src="@/assets/img/marker/first.png"
                  alt=""
                  class="img img-fluid display-block"
                  style="width: 100px"
                />
              </div>
            </div>
            <div class="row-6">
              <div class="col align-self-end px-3">
                <div id="first" type="button" class="btn btn-outline-primary col" style="height: 360px; overflow: auto">
                  <div class="fs-4 pt-3">{{ this.wishhouse[this.scoreboard[0][1]].wishname }}</div>
                  <div class="fs-5">{{ this.wishhouse[this.scoreboard[0][1]].wishtype }}</div>
                  <div class="fs-5 pt-2" style="color: #5f5f5f">{{ this.scoreboard[0][0] }}점</div>
                </div>
              </div>
            </div>
          </div>
          <div class="col" style="height: 500px; overflow: auto">
            <div class="row" style="height: 300px; overflow: auto">
              <div class="col align-self-end text-center">
                <img
                  src="@/assets/img/marker/third.png"
                  alt=""
                  class="img img-fluid display-block"
                  style="width: 100px"
                />
              </div>
            </div>
            <div class="row-6">
              <div class="col align-self-end px-3">
                <div id="third" type="button" class="btn btn-outline-primary col" style="height: 180px; overflow: auto">
                  <div class="fs-4 pt-3">{{ this.wishhouse[this.scoreboard[2][1]].wishname }}</div>
                  <div class="fs-5">{{ this.wishhouse[this.scoreboard[2][1]].wishtype }}</div>
                  <div class="fs-5 pt-2" style="color: #5f5f5f">{{ this.scoreboard[2][0] }}점</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-5 pl-0">
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
          <div class="container mb-3 p-3 bg-white border-left" style="height: 500px; overflow: auto">
            <div
              v-for="(item, i) in wishhouse"
              :key="i"
              type="button"
              :id="'wishinfo' + i"
              class=""
              data-toggle="collapse"
              :href="'#wishtoggle' + i"
              role="button"
              aria-expanded="false"
              :aria-controls="'wishtoggle' + i"
            >
              <div
                class="p-2 my-3 border rounded py-2 my-2 mx-0 row"
                v-if="i > 2"
                :style="'width: ' + ((scoreboard[i][0] * 100) / scoreboard[0][0]) * 5 + 'px'"
              >
                <div class="col-auto align-self-center">
                  <span class="fs-4 pe-3" style="color: gray">{{ i + 1 }}</span>
                  <span class="fs-4 pe-3">{{ item.wishname }}</span>
                  <span class="pe-3" style="color: gray">{{ item.wishtype }}</span>
                  <span class="pe-3" style="color: gray">{{ scoreboard[i][0] }}점</span>
                </div>
                <!-- <div class="col">
                  <div class="collapse" :id="'wishtoggle' + i" data-parent="#accordion">
                  </div>
                </div> -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http"; // 관심지역 순위 정하기
import { mapState, mapGetters } from "vuex";
const memberStore = "memberStore";
export default {
  name: "wishRank",
  data() {
    return {
      example: [
        { wishname: "아파트1" },
        { wishname: "아파트2" },
        { wishname: "아파트3" },
        { wishname: "아파트4" },
        { wishname: "아파트5" },
        { wishname: "아파트6" },
      ],
      category: ["MT1", "CS2", "SW8", "FD6", "CE7", "HP8", "PM9", "BK9"],
      wishhouse: [],
      scoreboard: [],
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },

  created() {
    http.get(`/wish/listwishid/${this.userInfo.userid}`).then(({ data }) => {
      this.wishhouse = data;
      console.log("스코어보드 보여줘");
      console.log(this.scoreboard);
      console.log(this.wishhouse);
      this.calculateWishList();
    });
  },

  methods: {
    async calculateWishList() {
      // 대형마트 : MT1 , 편의점 : CS2 , 지하철역: SW8 , 음식점 : FD6 , 카페 : CE7 , 병원 : HP8 , 약국 : PM9, 은행 : BK9
      for (let i = 0; i < this.wishhouse.length; i++) {
        let sumscore = 0;
        for (let j = 0; j < 8; j++) {
          await http
            .get(`/wish/searchcategory/${this.wishhouse[i].lng}/${this.wishhouse[i].lat}/${this.category[j]}/500`)
            .then(({ data }) => {
              console.log(data.documents);
              console.log(data.documents.length);
              if (data.documents.length >= 1) {
                if (this.category[j] == "MT1") {
                  sumscore += parseInt(this.$store.state.cd_score["market"]) * 10;
                  sumscore += data.documents.length;
                } else if (this.category[j] == "CS2") {
                  sumscore += parseInt(this.$store.state.cd_score["convenience"]) * 10;
                  sumscore += data.documents.length;
                } else if (this.category[j] == "SW8") {
                  sumscore += parseInt(this.$store.state.cd_score["subway"]) * 10;
                  sumscore += data.documents.length;
                } else if (this.category[j] == "FD6") {
                  sumscore += parseInt(this.$store.state.cd_score["food"]) * 10;
                  sumscore += data.documents.length;
                } else if (this.category[j] == "CE7") {
                  sumscore += parseInt(this.$store.state.cd_score["cafe"]) * 10;
                  sumscore += data.documents.length;
                } else if (this.category[j] == "HP8") {
                  sumscore += parseInt(this.$store.state.cd_score["hospital"]) * 10;
                  sumscore += data.documents.length;
                } else if (this.category[j] == "PM9") {
                  sumscore += parseInt(this.$store.state.cd_score["pharmacy"]) * 10;
                  sumscore += data.documents.length;
                } else if (this.category[j] == "BK9") {
                  sumscore += parseInt(this.$store.state.cd_score["bank"]) * 10;
                  sumscore += data.documents.length;
                }
              }
            });
        }
        const score = [sumscore, i];
        this.scoreboard.push(score);
      }

      console.log("스코어 보여줘");
      this.scoreboard.sort((a, b) => b[0] - a[0]);
      console.log(this.scoreboard);

      this.scoreboard[0][1];
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

#first {
  background-color: #f7bd0c;
  border: none;
  border-radius: 5px 5px 0px 0px;
  color: #000000;
  font-weight: 600;
}
#first:hover {
  background-color: #fed22c;
}

#second {
  background-color: #cacaca;
  border: none;
  border-radius: 5px 5px 0px 0px;
  color: #000000;
  font-weight: 600;
}
#second:hover {
  background-color: #d3d3d3;
}

#third {
  background-color: #dd9f1a;
  border: none;
  border-radius: 5px 5px 0px 0px;
  color: #000000;
  font-weight: 600;
}
#third:hover {
  background-color: #ecab1f;
}

#stage {
  background-image: url("@/assets/img/effect2.png");
  background-repeat: no-repeat;
  background-position: center;
  background-size: 800px 400px;
}
</style>
