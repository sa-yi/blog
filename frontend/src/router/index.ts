import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';
import HomeView from '@/views/HomeView.vue'; // 导入主页组件

// 定义路由类型
const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
  },
  {
    path: '/post/:id',
    name: 'post',
    component: () => import('../views/PostView.vue'),
    props: true
  }
];

// 创建路由实例
const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;