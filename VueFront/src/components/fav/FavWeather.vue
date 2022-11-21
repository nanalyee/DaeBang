<template>
  <!-- 테스트용 관광 -->
  <div>
    <b-container>
      <div class="row g-4">
        <div class="col-lg-12 portfolio-item first">
          <div class="border portfolio-img rounded overflow-hidden">
            <div class="col-lg-12 text-center">
              <h1 class="display-7 my-4 mb-10">{{ this.hours }}시 현재 기온</h1>
            </div>
            <br />
            <table class="table table-bordered" style="table-layout: fixed">
              <thead>
                <tr>
                  <th>시각</th>
                  <th v-for="(item, i) in hourslist()" :key="i">{{ item + 1 }} 시</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>기온</td>
                  <td v-for="(item, i) in tempnum()" :key="i">
                    <span class="text-danger fw-bold"> {{ weathertable[item].fcstValue }} °C</span>
                  </td>
                </tr>
                <tr>
                  <td>풍향</td>
                  <td v-for="(item, i) in tempnum()" :key="i">
                    {{ weathertable[item + 3].fcstValue }}
                  </td>
                </tr>
                <tr>
                  <td>풍속</td>
                  <td v-for="(item, i) in tempnum()" :key="i">{{ weathertable[item + 4].fcstValue }} m/s</td>
                </tr>
                <tr>
                  <td>하늘상태</td>
                  <td v-for="(item, i) in tempnum()" :key="i">
                    {{ weathertable[item + 5].fcstValue }}
                  </td>
                </tr>
                <tr>
                  <td>강수형태</td>
                  <td v-for="(item, i) in tempnum()" :key="i">
                    {{ weathertable[item + 6].fcstValue }}
                  </td>
                </tr>
                <tr>
                  <td>강수확률</td>
                  <td v-for="(item, i) in tempnum()" :key="i">{{ weathertable[item + 7].fcstValue }} %</td>
                </tr>
                <tr>
                  <td>1시간 강수량</td>
                  <td v-for="(item, i) in tempnum()" :key="i">{{ weathertable[item + 9].fcstValue }} mm</td>
                </tr>
                <tr>
                  <td>습도</td>
                  <td v-for="(item, i) in tempnum()" :key="i">{{ weathertable[item + 10].fcstValue }} %</td>
                </tr>
                <tr>
                  <td>1시간 적설량</td>
                  <td v-for="(item, i) in tempnum()" :key="i">
                    {{ weathertable[item + 11].fcstValue }}
                  </td>
                </tr>
              </tbody>
            </table>
            <div class="portfolio-btn">
              <b-button v-b-toggle.sidebar-right><i class="bi bi-chat-right-dots-fill"></i></b-button>
            </div>
          </div>
        </div>
      </div>
    </b-container>
  </div>
  <!-- 관광 끝 -->
</template>

<script>
import http from "@/util/http"; // 버스 정류소 불러오기용
export default {
  name: "FavWeather",

  data() {
    return {
      hours: new Date().getHours(),
      hourlist: [],
      weathertable: [],
      temp: "",
    };
  },
  created() {
    let today = new Date();
    let year = today.getFullYear(); // 년도
    let month = today.getMonth() + 1; // 월
    let date = today.getDate(); // 날짜
    let basedate = String(year) + String(month) + String(date);
    let hours = "";
    let basetime = "";
    let nx = 55;
    let ny = 127;
    let temp = 0;

    if (today.getHours() < 10) {
      hours = "0" + today.getHours() + "00";
    } else {
      hours = today.getHours() + "00";
    }
    if (hours == "2300" || hours == "0000" || hours == "0100") {
      if (hours == "0000") {
        temp = 12;
      } else if (hours == "0100") {
        temp = 24;
      }
      basedate -= 1;
      basetime = "2300";
    } else if (hours == "0200" || hours == "0300" || hours == "0400") {
      if (hours == "0300") {
        temp = 12;
      } else if (hours == "0400") {
        temp = 24;
      }
      basetime = "0200";
    } else if (hours == "0500" || hours == "0600" || hours == "0700") {
      if (hours == "0600") {
        temp = 12;
      } else if (hours == "0700") {
        temp = 24;
      }
      basetime = "0500";
    } else if (hours == "0800" || hours == "0900" || hours == "1000") {
      if (hours == "0900") {
        temp = 12;
      } else if (hours == "1000") {
        temp = 24;
      }
      basetime = "0800";
    } else if (hours == "1100" || hours == "1200" || hours == "1300") {
      if (hours == "1200") {
        temp = 12;
      } else if (hours == "1300") {
        temp = 24;
      }
      basetime = "1100";
    } else if (hours == "1400" || hours == "1500" || hours == "1600") {
      if (hours == "1500") {
        temp = 12;
      } else if (hours == "1600") {
        temp = 24;
      }
      basetime = "1400";
    } else if (hours == "1700" || hours == "1800" || hours == "1900") {
      if (hours == "1800") {
        temp = 12;
      } else if (hours == "1900") {
        temp = 24;
      }
      basetime = "1700";
    } else if (hours == "2000" || hours == "2100" || hours == "2200") {
      if (hours == "2100") {
        temp = 12;
      } else if (hours == "2200") {
        temp = 24;
      }
      basetime = "2000";
    }
    this.temp = temp;
    console.log(hours);
    console.log(basedate);
    console.log(basetime);

    //단기예보
    // - Base_time : 0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 (1일 8회)
    //- API 제공 시간(~이후) : 02:10, 05:10, 08:10, 11:10, 14:10, 17:10, 20:10, 23:10

    //spring에서 비동기로 날씨 불러오기
    http.get(`/traffic/getweather/${basedate}/${basetime}/${nx}/${ny}`).then(({ data }) => {
      this.weathertable = data.response.body.items.item;
      console.log(data.response.body.items.item[temp].fcstValue);
      console.log(temp);
      console.log(this.weathertable);
    });
    console.log(this.weathertable);
  },

  methods: {
    hourslist() {
      var list = [];
      for (var i = this.hours; i < this.hours + 10; i++) {
        if (i >= 24) {
          list.push("0" + i - 24);
        } else {
          list.push(i);
        }
      }
      return list;
    },
    tempnum() {
      var list = [];
      console.log(this.temp);
      for (var i = this.temp; i < this.temp + 120; i = i + 12) {
        if (this.weathertable[i].category == "TMX" || this.weathertable[i].category == "TMN") {
          i++;
        }
        list.push(i);
      }
      console.log(list);
      return list;
    },
  },
};
</script>

<style></style>
