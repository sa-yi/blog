import { createApp } from 'vue';
import App from './App.vue';
import router from './router'; // 导入路由配置

import '@fortawesome/fontawesome-free/css/all.css'

// 创建 Vue 应用实例
const app = createApp(App);

// 使用路由
app.use(router);

// 挂载应用
app.mount('#app');