/*
 * @Author: fan2IST fanISTREC2DX@outlook.com
 * @Date: 2023-09-19 16:22:59
 * @LastEditors: fan2IST fanISTREC2DX@outlook.com
 * @LastEditTime: 2023-09-19 21:25:38
 * @FilePath: /VUE_test/src/main.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/global.css'

Vue.config.productionTip = false

Vue.use(ElementUI, { size: "mini" });
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
