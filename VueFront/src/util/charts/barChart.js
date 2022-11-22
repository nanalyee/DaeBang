import "@/util/charts/global";
import { Bar } from "vue-chartjs";

export default {
  extends: Bar,
  props: ["chartData", "options"],
  watch: {
    chartData: {
      handler() {
        this.renderChart(this.chartData, this.options);
      },
      deep: true,
    },
  },
  mounted() {
    this.renderChart(this.chartData, this.options);
  },
};
