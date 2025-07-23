const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      '/api': {  // 所有以 /api 开头的请求
        target: 'http://localhost:8081',  // 后端地址
        changeOrigin: true,              // 绕过跨域
        pathRewrite: { '^/api': '' },      // 移除 /api 前缀
      }
    }
}})
