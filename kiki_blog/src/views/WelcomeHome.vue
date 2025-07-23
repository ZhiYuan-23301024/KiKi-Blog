<template>
    <div class="welcome-container">
      <!-- 名言展示区 -->
      <div class="quote-card">
        <div class="quote-content">
          <h2 class="quote-text">"{{ currentQuote.text }}"</h2>
          <p class="quote-author">—— {{ currentQuote.author }}</p>
        </div>
        
        <!-- 跳转按钮 -->
        <button 
          class="enter-button"
          @click="navigateToPosts"
        >
          WELCOME
        </button>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        name: "WelcomeHome",
        // 名言库（可根据需要扩展）
        quotes: [
          { text: "做人就应该要好好学习，不然你对得起农民伯伯吗", author: "刘铎" },
          { text: "我不可能像爱孩子一样爱学生，我闺女犯错我都是拿戒尺教育的", author: "刘铎" },
          { text: "上讲台写，第十二遍", author: "刘铎" }
        ],
        currentQuote: {}
      }
    },
    mounted() {
      // 初始化随机名言
      this.getRandomQuote();
    },
    methods: {
      getRandomQuote() {
        const index = Math.floor(Math.random() * this.quotes.length);
        this.currentQuote = this.quotes[index];
      },
      navigateToPosts() {
        // 路由跳转（参考网页9/10/11的路由跳转方案）
        this.$router.push('/1');
      }
    }
  }
  </script>
  
  <style scoped>
  .welcome-container {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background: #f8f9fa;
    padding: 2rem;
  }
  
  .quote-card {
    background: white;
    padding: 3rem 4rem;
    border-radius: 12px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    text-align: center;
    max-width: 600px;
    transition: transform 0.3s ease;
  }
  
  .quote-card:hover {
    transform: translateY(-5px);
  }
  
  .quote-content {
    margin-bottom: 2rem;
  }
  
  .quote-text {
    font-size: 1.8rem;
    color: #212529;
    line-height: 1.6;
    margin-bottom: 1.5rem;
  }
  
  .quote-author {
    font-size: 1.2rem;
    color: #6c757d;
    font-style: italic;
  }
  
  .enter-button {
    padding: 12px 36px;
    background: #007bff;
    color: white;
    border: none;
    border-radius: 25px;
    font-size: 1.1rem;
    cursor: pointer;
    transition: all 0.3s ease;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
  
  .enter-button:hover {
    background: #0056b3;
    transform: translateY(-2px);
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
  }
  
  /* 响应式设计 */
  @media (max-width: 768px) {
    .quote-card {
      padding: 2rem;
      margin: 0 1rem;
    }
    
    .quote-text {
      font-size: 1.4rem;
    }
    
    .enter-button {
      padding: 10px 28px;
    }
  }
  </style>