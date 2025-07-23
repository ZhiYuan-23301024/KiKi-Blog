import { createRouter, createWebHistory } from "vue-router"; // 导入 createRouter 和 createWebHistory 函数
import PostHome from "@/views/PostHome.vue"; // 导入 PostHome 组件
import HelloWorld from "@/views/HelloWorld.vue"; // 导入 HelloWorld 组件
import WelcomeHome from "@/views/WelcomeHome.vue"; // 导入 WelcomeHome 组件

// 配置信息中需要页面的相关配置
const myroutes = [
    {
        path: '/:current_page', // 动态参数捕获 /2 这类路径
        name: 'BlogPage', // 命名路由
        component: HelloWorld, // 使用 HelloWorld 组件
        props: true // 启用 props 接收参数（推荐）
    },
    {
        path: '/', // 根路径
        component: WelcomeHome // 使用 WelcomeHome 组件
    },
    {
        path: "/posthome/:id", // 动态参数捕获 /posthome/123 这类路径
        component: PostHome // 使用 PostHome 组件
    }
];

// 创建路由器实例
const router = createRouter({
    routes: myroutes, // 将路由配置信息传递给路由器
    history: createWebHistory() // 使用 HTML5 的 history 模式，URL 不带 # 符号
});

// 导出路由器实例，使其可以在其他地方使用
export default router;
