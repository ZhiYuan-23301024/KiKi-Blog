<template> 
  <div class="global-bg">
  <div class="blog-container" style="text-align: center;">
    <!-- 左侧个人信息区域 -->
    <div class="profile-section" text-allign="center">
      <div class="avatar-wrapper">
        <img 
          src="@/assets/avatar.jpg" 
          alt="个人头像"
          class="avatar"
          @error="handleImageError"
        >
      </div>
      <div class="bio-content">
        <h1 class="name">ZhiYuan</h1>
        <div class="social-links">
          <a href="https://github.com/ZhiYuan-23301024" class="icon github">my github location</a>
        </div>
        <p class="description">
          抽象SE学生
        </p>
        <p class="description">
          刘铎老师的狂热粉丝
        </p>
        <p class="description">
          不定期更新学习笔记
        </p>
        <p></p>
      </div>
    </div>

    <!-- 右侧帖子列表区域 -->
    <div class="posts-section">
      <post-card 
        v-for="post in posts" 
        :key="post.id"
        :post="post"
        @view-detail="handleViewDetail"
      />
      <div class="pagination">
    <button 
      @click="changePage(currentPage - 1)"
      :disabled="currentPage === 1"
    >上一页</button>
    
    <span>第 {{ currentPage }} 页</span>
    
    <button 
      @click="changePage(currentPage + 1)"
      :disabled="currentPage === totalPages"
    >下一页</button>
  </div>
    </div>
  </div>
  </div>
</template>

<script>
import PostCard from '@/components/PostCard.vue'
import axios from 'axios'
export default {
  data(){
    return{
      posts:[],
      test_posts:[],
      currentPage:1,
      totalPages:1,
      loading: false
    }
  },
  components: { PostCard},
  props: ['current_page'], // 自动接收路由参数
  mounted(){
    this.currentPage=Number(this.current_page) || 1
    console.log("当前页码",this.currentPage)
    this.fetchPosts()
  },
  methods: {

    //查看博客内容
    handleViewDetail(postId) {
      console.log('查看详情:', postId)
      this.$router.push(`/posthome/${postId}`) 
    },

    //请求博客卡片数据
    async fetchPosts(){
      if (this.loading) return
      this.loading=true
      try {
        const response = await axios.get(
                `http://localhost:8081/postcardlist`,
                { params: { currentpage: this.currentPage } } // 参数规范写法
            )
        this.posts = response.data.data.postcardlist
        this.totalPages=response.data.data.pageNum
        console.log(this.posts)
      } catch (error) {
        console.error('获取数据失败:', error)
      }finally{
      this.loading=false
      }
    },

    //页面更换函数
    changePage(newPage) {
      console.log(newPage)
      this.$router.push(`/${newPage}`)
      console.log('success')
}
  }
}
</script>

<style scoped>
.global-bg{
  display: table-column;
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  z-index: -1;
  background-size: cover;
  background-position: center;
  background-attachment: fixed;
  background-repeat: no-repeat;
  overflow-y: auto;
  background-image: url('..\\src\\assets\\background.jpeg'); 
  @media (max-width: 768px) {
    overflow-y: scroll;
    overflow-x: hidden;
    
  }
}
.blog-container {
  display: flex;
  gap: 2rem;
  max-width: 1400px;
  
  margin: 2rem auto;
  padding: 0 1rem;
}

.profile-section {
  flex: 0 0 250px;    /* 禁止伸缩+固定250px宽度 */
  margin-right: 0;    /* 移除右侧间距 */
  margin-left: -1rem; /* 抵消父容器padding-left */
  box-shadow: 0 2px 8px rgba(0,0,0,0.1);
  background: rgba(255, 255, 255, 0.75);
  padding: 2rem;
  border-radius: 12px;
  @media (max-width: 768px) {
    padding: 1rem 1.5rem;
    font-size: 15px;
  }
}

.avatar-wrapper {
  width: 180px;       /* 原200px调整为180px(适配250px容器) */
  height: 180px;
  margin: 0 auto 1.5rem;
}
.avatar {
  width: 100%;
  height: 100%;
  border-radius: 50%;
  object-fit: cover;
  border: 3px solid #e9ecef;
}

.posts-section {
  flex: 1;
}

.post-card {
  background: rgba(255, 255, 255, 0.6);
  padding: 1.5rem;
  margin-bottom: 1.5rem;
  border-radius: 8px;
  box-shadow: 0 1px 3px rgba(0,0,0,0.1);
  transition: transform 0.2s;
}

.post-card:hover {
  transform: translateY(-2px);
}

.post-header {
  margin-bottom: 1rem;
}

.post-updateTime {
  color: #6c757d;
  font-size: 0.9rem;
}

.post-title {
  color: #212529;
  margin: 0.5rem 0;
}

.tag {
  display: inline-block;
  background: #e9ecef;
  padding: 0.25rem 0.75rem;
  border-radius: 20px;
  margin-right: 0.5rem;
  font-size: 0.85rem;
}

.read-more {
  background: #007bff;
  color: white;
  border: none;
  padding: 0.5rem 1rem;
  border-radius: 4px;
  cursor: pointer;
}

/* 响应式布局 */
@media (max-width: 768px) {
  .blog-container {
    flex-direction: column;
  }
  
  .profile-section {
    flex: none;
    width: 100%;
  }
}
.pagination {
  margin-top: 2rem;
  display: flex;
  gap: 1rem;
  justify-content: center;
  align-items: center;
}

button {
  padding: 8px 16px;
  border: 1px solid #00ff88;
  background: white;
  cursor: pointer;
  border-radius: 4px;
}

button:disabled {
  opacity: 0.5;
  cursor: not-allowed;
}

.description {
  font-size: 1.2rem;
    color: #6c757d;
    font-style: italic;
  }
  .global-bg::-webkit-scrollbar{
    display: none;
  }
</style>