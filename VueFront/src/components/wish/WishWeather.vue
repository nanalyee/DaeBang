<template>
  <!-- 테스트용 관광 -->
  <div>
    <b-container v-if="this.weathertable.length > 0">
      <div class="row g-4">
        <div
          id="weather-container"
          :style="{ backgroundImage: `url(${require('@/assets/img/weather/' + this.bgimage)})` }"
        >
          <div class="col-lg-6">
            <h1 class="display-7 ml-5 my-4 mb-10">
              <br />
              <img id="thermometer" src="@/assets/img/weather/thermometer.png" alt="" />
              <span class="ml-5"></span> "_________아파트"
              <br />
              {{ this.hours }}시 현재 기온
              <span v-if="weathertable[this.startdata].fcstValue" class="text-danger fw-bold">
                {{ weathertable[this.startdata].fcstValue }} °C
              </span>
              <img
                v-if="weathertable[this.startdata + 5].fcstValue == '4'"
                class="img-fluid"
                src="@/assets/img/weather/cloudfog.png"
                id="title_weather"
              />
              <img
                v-if="weathertable[this.startdata + 5].fcstValue == '3'"
                class="img-fluid"
                src="@/assets/img/weather/cloud.png"
                id="title_weather"
              />
              <img
                v-if="weathertable[this.startdata + 5].fcstValue == '1'"
                class="img-fluid"
                src="@/assets/img/weather/sun.png"
                id="title_weather"
              />
            </h1>
          </div>

          <div class="col-lg-6 ml-5">
            <h4 v-if="weathertable[this.startdata + 7].fcstValue" class="display-7 my-4 mb-10">
              강수확률 {{ weathertable[this.startdata + 7].fcstValue }}%
            </h4>
            <h4 v-if="weathertable[this.startdata + 10].fcstValue" class="display-7 my-4 mb-10">
              습도 {{ weathertable[this.startdata + 10].fcstValue }}%
            </h4>
          </div>
          <br />
        </div>
        <table class="table table-bordered text-center" style="table-layout: fixed">
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
                <img
                  v-if="weathertable[item + 5].fcstValue == '4'"
                  class="img-fluid"
                  src="@/assets/img/weather/cloudfog.png"
                  id="weather_img"
                />
                <img
                  v-if="weathertable[item + 5].fcstValue == '3'"
                  class="img-fluid"
                  src="@/assets/img/weather/cloud.png"
                  id="weather_img"
                />
                <img
                  v-if="weathertable[item + 5].fcstValue == '1'"
                  class="img-fluid"
                  src="@/assets/img/weather/sun.png"
                  id="weather_img"
                />
                <!-- {{ weathertable[item + 5].fcstValue }} -->
              </td>
            </tr>
            <tr>
              <td>강수형태</td>
              <td v-for="(item, i) in tempnum()" :key="i">
                <img
                  v-if="weathertable[item + 6].fcstValue == '0'"
                  class="img-fluid"
                  src="@/assets/img/weather/cloudx.png"
                  id="weather_img"
                />
                <img
                  v-if="weathertable[item + 6].fcstValue == '1'"
                  class="img-fluid"
                  src="@/assets/img/weather/rain.png"
                  id="weather_img"
                />
                <img
                  v-if="weathertable[item + 6].fcstValue == '2'"
                  class="img-fluid"
                  src="@/assets/img/weather/snowing.png"
                  id="weather_img"
                />
                <img
                  v-if="weathertable[item + 6].fcstValue == '3'"
                  class="img-fluid"
                  src="@/assets/img/weather/snow.png"
                  id="weather_img"
                />
                <img
                  v-if="weathertable[item + 6].fcstValue == '4'"
                  class="img-fluid"
                  src="@/assets/img/weather/rainshower.png"
                  id="weather_img"
                />
                <!-- {{ weathertable[item + 6].fcstValue }} -->
              </td>
            </tr>
            <tr>
              <td>강수확률</td>
              <td v-for="(item, i) in tempnum()" :key="i">{{ weathertable[item + 7].fcstValue }} %</td>
            </tr>
            <tr>
              <td>1시간 강수량(mm)</td>
              <td v-for="(item, i) in tempnum()" :key="i">{{ weathertable[item + 9].fcstValue }}</td>
            </tr>
            <tr>
              <td>습도</td>
              <td v-for="(item, i) in tempnum()" :key="i">{{ weathertable[item + 10].fcstValue }} %</td>
            </tr>
            <tr>
              <td>1시간 적설량(mm)</td>
              <td v-for="(item, i) in tempnum()" :key="i">
                {{ weathertable[item + 11].fcstValue }}
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </b-container>
  </div>
  <!-- 관광 끝 -->
</template>

<script>
import http from "@/util/http"; // 버스 정류소 불러오기용
export default {
  name: "WishWeather",

  data() {
    return {
      hours: new Date().getHours(),
      hourlist: [],
      weathertable: [],
      temp: "",
      startdata: "",
      bgimage: "sunny.gif",
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
    //console.log(hours);
    //console.log(basedate);
    //console.log(basetime);
    //단기예보
    // - Base_time : 0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 (1일 8회)
    //- API 제공 시간(~이후) : 02:10, 05:10, 08:10, 11:10, 14:10, 17:10, 20:10, 23:10

    //spring에서 비동기로 날씨 불러오기
    http.get(`/wish/getweather/${basedate}/${basetime}/${nx}/${ny}`).then(({ data }) => {
      this.weathertable = data.response.body.items.item;
      //console.log(data.response.body.items.item[temp].fcstValue);
      //console.log(temp);
      //console.log(this.weathertable);
      if (this.weathertable[this.temp].category == "TMX" || this.weathertable[this.temp].category == "TMN") {
        this.startdata = temp + 1;
      } else {
        this.startdata = temp;
      }
      //console.log(this.weathertable[this.startdata + 6].fcstValue);

      if (this.weathertable[this.startdata + 6].fcstValue == "0") {
        if (this.weathertable[this.startdata + 5].fcstValue == "3") {
          this.bgimage = "cloud.gif";
        } else if (this.weathertable[this.startdata + 5].fcstValue == "4") {
          this.bgimage = "cloud.gif";
        } else if (this.weathertable[this.startdata + 5].fcstValue == "1") {
          if (this.hours <= 18 || this.hours >= 6) {
            this.bgimage = "sunny.gif";
          } else {
            this.bgimage = "night.gif";
          }
        }
      } else if (this.weathertable[this.startdata + 6].fcstValue == "1") {
        this.bgimage = "rain.gif";
      } else if (this.weathertable[this.startdata + 6].fcstValue == "2") {
        this.bgimage = "rain.gif";
      } else if (this.weathertable[this.startdata + 6].fcstValue == "3") {
        this.bgimage = "snow.gif";
      } else if (this.weathertable[this.startdata + 6].fcstValue == "4") {
        this.bgimage = "rain.gif";
      }
    });
    //console.log(this.weathertable);
  },

  methods: {
    hourslist() {
      var list = [];
      for (var i = this.hours; i < this.hours + 9; i++) {
        if (i >= 24) {
          list.push("0" + i - 24);
        } else {
          list.push(i);
        }
      }
      return list;
    },
    startnum() {
      var list = [];
      // console.log(this.temp);
      for (var i = this.temp; i < this.temp + 10; i = i + 12) {
        if (this.weathertable[i].category == "TMX" || this.weathertable[i].category == "TMN") {
          i++;
        }
        list.push(i);
      }
      //console.log(list);
      return list;
    },
    tempnum() {
      var list = [];
      //console.log(this.temp);
      for (var i = this.temp + 12; i < this.temp + 120; i = i + 12) {
        if (this.weathertable[i].category == "TMX" || this.weathertable[i].category == "TMN") {
          i++;
        } else if (this.weathertable[i].category == "SNO") {
          i = i + 2;
        }
        list.push(i);
      }
      //console.log(list);
      return list;
    },
  },
};
</script>

<style>
#thermometer {
  width: 7%;
}
#title_weather {
  width: 10%;
}
#weather_img {
  width: 60%;
}

#weather-container {
  background-size: cover;
  /* background-image: url(@/assets/img/weather/rain.gif); */
  /* background-color: rgb(207, 243, 248); */
}

#weatherhomepage {
  width: 30%;
}
</style>
