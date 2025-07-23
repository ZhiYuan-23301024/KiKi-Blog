import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import MarkdownIt from 'markdown-it'
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';

createApp(App).use(ElementPlus).use(MarkdownIt).use(router).mount('#app')
