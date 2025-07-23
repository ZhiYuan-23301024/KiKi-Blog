<template>
  <!-- 修正背景层与内容容器结构 -->
  <div class="global-bg"></div>
  <div class="blog_container">
    <div v-if="loading" class="loading">加载中...</div>
    <div v-else-if="error" class="error">内容加载失败</div>
    <div v-else v-html="renderedContent"></div>
    
  </div>
</template>

<script>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import axios from 'axios'
import markdownit from 'markdown-it'
import hljs from 'highlight.js'
import 'highlight.js/styles/github.css'
import javascript from 'highlight.js/lib/languages/javascript'
import python from 'highlight.js/lib/languages/python'
import { nextTick } from 'vue'

hljs.registerLanguage('javascript', javascript)
hljs.registerLanguage('python', python)

export default {
  setup() {
    const route = useRoute()
    const post = ref({})
    const renderedContent = ref('')
    const md = markdownit({
      html: true,
      linkify: true,
      typographer:true,
      highlight: function (str, lang) {
        if (lang && hljs.getLanguage(lang)) {
          try {
            return `<pre class="hljs"><code class="language-${lang}">${
              hljs.highlight(lang, str, true).value
            }</code></pre>`
          } catch (err) {
            console.error(err)
          }
        }
        return `<pre class="hljs"><code>${md.utils.escapeHtml(str)}</code></pre>`
      }
    })

    onMounted(async () => {
      try {
        const response = await axios.get(
          `http://localhost:8081/posthome?id=${route.params.id}`
        )
        const rawMarkdown = response.data?.content || ''
        renderedContent.value = md.render(rawMarkdown)
        await nextTick()
        document.querySelectorAll('pre code').forEach(el => {
          hljs.highlightElement(el)
        })
        console.log(md.render('​**加粗测试**​')); 
      } catch (err) {
        console.error('数据加载失败:', err)
      }
    })

    return { post, renderedContent }
  }
}
</script>

<style scoped>
/* 修正背景层样式 */
.global-bg {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  z-index: -1;
  background-image: url('..\\src\\assets\\background.jpeg'); 
  background-size: cover;
  background-position: center;
  background-attachment: fixed;
  background-repeat: no-repeat;
}

/* 修正内容容器样式 */
.blog_container {
  z-index: -1;
  top: 40px;
  min-height: 100vh;
  position: relative;
  max-width: 800px;
  margin: 0 auto;
  padding: 2rem 3rem;
  line-height: 1.6;
  background: rgba(255, 255, 255, 0.6);
  backdrop-filter: blur(2px);
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen, Ubuntu;
  color: #333;

  /* 修正媒体查询语法 */
  @media (max-width: 768px) {
    padding: 1rem 1.5rem;
    font-size: 15px;
    
    :deep(pre.hljs) {
      margin-left: -1rem;
      margin-right: -1rem;
      border-radius: 0;
    }
  
  }
  :deep() {
    h1, h2, h3 {
      margin: 1.5em 0 0.8em;
      color: #2c3e50;
      font-weight: 600;
    }

    h1 { font-size: 2.2em }
    h2 { font-size: 1.8em }
    h3 { font-size: 1.4em }
    strong{
      font-weight: 600;
      color: #2c3e50;
    }
    p {
      margin: 1em 0;
    }

    pre.hljs {
      background-color: #f5f5f5 !important;
      border: 1px solid #e0e0e0;
      margin: 1.5em -1.5em;
      
      code {
        color: #333;
        background-color: transparent !important;
      }
    }

    code:not(.hljs) {
      background-color: #f0f0f0;
      padding: 0.2em 0.4em;
      border-radius: 3px;
      font-size: 0.9em;
    }

    img {
      max-width: 100%;
      height: auto;
      border-radius: 6px;
      margin: 1.5em 0;
    }

    ul, ol {
      padding-left: 1.8em;
      margin: 1em 0;
    }

    li {
      margin: 0.5em 0;
    }
  }
}
</style>