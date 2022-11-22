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
            <div class="row" style="height: 200px; overflow: auto">
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
                  style="height: 280px; overflow: auto"
                  @click="select = 1"
                >
                  <div id="bcon" class="rounded">
                    <div class="fs-4 pt-3">
                      {{ this.wishhouse[this.scoreboard[1][1]].wishname }}
                    </div>
                    <div class="fs-5">{{ this.wishhouse[this.scoreboard[1][1]].wishtype }}</div>
                    <div class="fs-5 pt-2" style="color: #5f5f5f">
                      {{ this.scoreboard[1][0] }}점
                    </div>
                  </div>
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
                <div
                  id="first"
                  type="button"
                  class="btn btn-outline-primary col"
                  style="height: 360px; overflow: auto"
                  @click="select = 0"
                >
                  <div id="bcon" class="rounded">
                    <div class="fs-4 pt-3">
                      {{ this.wishhouse[this.scoreboard[0][1]].wishname }}
                    </div>
                    <div class="fs-5">{{ this.wishhouse[this.scoreboard[0][1]].wishtype }}</div>
                    <div class="fs-5 pt-2" style="color: #5f5f5f">
                      {{ this.scoreboard[0][0] }}점
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col" style="height: 500px; overflow: auto">
            <div class="row" style="height: 240px; overflow: auto">
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
                <div
                  id="third"
                  type="button"
                  class="btn btn-outline-primary col"
                  style="height: 240px; overflow: auto"
                  @click="select = 2"
                >
                  <div id="bcon" class="rounded">
                    <div class="fs-4 pt-3">
                      {{ this.wishhouse[this.scoreboard[2][1]].wishname }}
                    </div>
                    <div class="fs-5">{{ this.wishhouse[this.scoreboard[2][1]].wishtype }}</div>
                    <div class="fs-5 pt-2" style="color: #5f5f5f">
                      {{ this.scoreboard[2][0] }}점
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-5 pl-0">
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
          <div class="container mb-3 p-3 bg-white" style="height: 600px; overflow: auto">
            <div>
              <h6 class="text-center">
                점수 집계 방식 : 선호 상권 유/무 + 반경500m 해당 상권 개수
              </h6>
            </div>
            <div>
              <apexcharts
                type="bar"
                height="450"
                :options="chartOptions"
                :series="series"
              ></apexcharts>
            </div>
          </div>
        </div>
      </div>
      <div class="row justify-content-center p-2 m-2" v-if="select || select == 0">
        <h4 class="text-center my-2 py-2">
          {{ this.wishhouse[this.scoreboard[select][1]].wishname }}
          {{ this.wishhouse[this.scoreboard[select][1]].wishtype }} 상세 결과
        </h4>
        <table class="table align-middle">
          <thead>
            <tr class="text-center">
              <th style="width: 12.5%">대형마트</th>
              <th style="width: 12.5%">편의점</th>
              <th style="width: 12.5%">지하철역</th>
              <th style="width: 12.5%">음식점</th>
              <th style="width: 12.5%">카페</th>
              <th style="width: 12.5%">병원</th>
              <th style="width: 12.5%">약국</th>
              <th style="width: 12.5%">은행</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td v-for="(near, i) in 8" :key="i" class="text-center">
                <div class="box" style="height: 300px; overflow: auto">
                  <button
                    v-for="(item, j) in detailBoard[select][i]"
                    :key="j"
                    class="btn btn-sm btn-primary m-1"
                    :style="{
                      backgroundColor: btnColor[Math.floor(Math.random() * 4)],
                      border: 'none',
                      color: 'black',
                    }"
                  >
                    {{ detailBoard[select][i][j].place_name }}
                  </button>
                </div>
              </td>
            </tr>
          </tbody>

          <!-- <tbody v-if="select >= 0">
            <tr v-for="(near, i) in 8" :key="i" class="text-center">
              <th style="width: 10%" class="align-middle">{{ categoryName[i] }}</th>
              <td class="box text-start">
                <button
                  v-for="(item, j) in detailBoard[select][i]"
                  :key="j"
                  class="btn btn-sm btn-primary m-1"
                  :style="{
                    backgroundColor: btnColor[Math.floor(Math.random() * 4)],
                    border: 'none',
                    color: 'black',
                    fontWeight: 'light',
                    fontFamily: 'Pretendard-Regular',
                  }"
                >
                  {{ detailBoard[select][i][j].place_name }}
                </button>
              </td>
            </tr>
          </tbody> -->
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import VueApexCharts from "vue-apexcharts";
import http from "@/util/http"; // 관심지역 순위 정하기
import { mapState, mapGetters } from "vuex";
const memberStore = "memberStore";

export default {
  name: "wishRank",
  components: { apexcharts: VueApexCharts }, // 차트 관련
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
      categoryName: ["대형마트", "편의점", "지하철역", "음식점", "카페", "병원", "약국", "은행"],
      wishhouse: [],
      scoreboard: [],
      detailBoard: [],
      select: 0,
      btnColor: ["#6dc0ff8c", "#3fce9e8a", "#ffc95da1", "#ed82928c", "#9584d09c"],

      // 차트 관련 시작
      series: [
        {
          data: [
            //400, 430, 448, 470, 540, 580, 690, 1100, 1200, 1380
          ],
        },
      ],
      chartOptions: {
        chart: {
          type: "bar",
          height: 450,
        },
        plotOptions: {
          bar: {
            borderRadius: 4,
            horizontal: true,
            fontFamily: "LINESeedKR-Bd, sans-serif",
          },
        },
        dataLabels: {
          enabled: false,
        },
        xaxis: {
          categories: [
            // "South Korea",
            // "Canada",
            // "United Kingdom",
            // "Netherlands",
            // "Italy",
            // "France",
            // "Japan",
            // "United States",
            // "China",
            // "Germany",
          ],
        },
      },
      //차트 끝
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },

  created() {
    http.get(`/wish/listwishid/${this.userInfo.userid}`).then(({ data }) => {
      this.wishhouse = data;
      //console.log("스코어보드 보여줘");
      //console.log(this.scoreboard);
      //console.log(this.wishhouse);
      this.calculateWishList();
    });
  },

  methods: {
    async calculateWishList() {
      // 대형마트 : MT1 , 편의점 : CS2 , 지하철역: SW8 , 음식점 : FD6 , 카페 : CE7 , 병원 : HP8 , 약국 : PM9, 은행 : BK9
      for (let i = 0; i < this.wishhouse.length; i++) {
        let nearDetail = [];
        let sumscore = 0;
        for (let j = 0; j < 8; j++) {
          await http
            .get(
              `/wish/searchcategory/${this.wishhouse[i].lng}/${this.wishhouse[i].lat}/${this.category[j]}/500`
            )
            .then(({ data }) => {
              console.log(data.documents);
              nearDetail.push(data.documents);
              //console.log(data.documents.length);
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
        // console.log(nearDetail);
        this.detailBoard.push(nearDetail);
        console.log(this.detailBoard);
      }

      console.log("스코어 보여줘");
      window.dispatchEvent(new Event("resize"));
      this.scoreboard.sort((a, b) => b[0] - a[0]);
      console.log(this.scoreboard);
      for (let i = 0; i < this.scoreboard.length; i++) {
        this.chartOptions.xaxis.categories.push(this.wishhouse[this.scoreboard[i][1]].wishname);
        this.series[0].data.push(this.scoreboard[i][0]);
      }

      console.log(this.chartOptions.xaxis.categories);
      console.log(this.series[0].data);
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
  background-image: url("@/assets/img/rank/gold.png");
  background-size: cover;
  /* background-color: #f7bd0c; */
  border: none;
  border-radius: 5px 5px 0px 0px;
  color: #000000;
  font-weight: 600;
}
#first:hover {
  background-color: #fed22c;
}

#second {
  background-image: url("@/assets/img/rank/silver.png");
  background-size: cover;
  /* background-color: #cacaca; */
  border: none;
  border-radius: 5px 5px 0px 0px;
  color: #000000;
  font-weight: 600;
}
#second:hover {
  background-color: #d3d3d3;
}

#third {
  background-image: url("@/assets/img/rank/bronze.png");
  background-size: cover;
  /* background-color: #dd9f1a; */
  border: none;
  border-radius: 5px 5px 0px 0px;
  color: #000000;
  font-weight: 600;
}
#third:hover {
  background-color: #ecab1f;
}

#stage {
  background-image: url("@/assets/img/gif/podium2.gif");
  background-repeat: no-repeat;
  background-position: center;
  background-size: 800px 400px;
}

#bcon {
  margin-top: 70px;
  background-color: rgb(255, 255, 255, 0.3);
}

.box {
  -ms-overflow-style: none; /* IE and Edge */
  scrollbar-width: none; /* Firefox */
}
.box::-webkit-scrollbar {
  display: none; /* Chrome, Safari, Opera*/
}
</style>
