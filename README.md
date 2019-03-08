# spring-vue-element

### 配置 node 环境

- 去网站https://nodejs.org/en/download/，下载对应的安装程序，并安装

- 配置node

1.配置“NODE_HOME”

2.配置“NODE_PATH”

3.配置Path，追加 ;%NODE_HOME%\;%NODE_PATH%\; 这两项

4.检测环境
```jshelllanguage
node -v

npm -v
```

### 配置 Vue 环境

- 安装cnpm淘宝镜像

```jshelllanguage
npm install -g cnpm --registry=https://registry.npm.taobao.org
```

- 安装Vue脚手架

```jshelllanguage
cnpm install -g webpack

cnpm install -g vue-cli
```

### 访问项目

- 进入node/admin/index.js文件夹，修改访问地址

```xml
proxyTable: {
  '/api': {
    target: 'http://localhost:8099/',
    changeOrigin: true,
    pathRewrite: {
      '^/api': '/'
    }
  }
}

```

- 进入node/admin 文件夹，安装组件

1.安装axios，用于调用http请求

```jshelllanguage
cnpm install --save axios
```

2.安装element-ui库

```jshelllanguage
cnpm install --save element-ui
```

3.安装font-awesome图标库

```jshelllanguage
cnpm install --save font-awesome
```

4.安装sass库

```jshelllanguage
cnpm install --save-dev node-sass
cnpm install --save-dev sass-loader
```

5.安装mock.js，其中，axios-mock-adapter能拦截http请求的同时模拟需要的数据　

```jshelllanguage
cnpm install --save-dev mockjs
cnpm install --save-dev axios-mock-adapter
```

- 启动后台项目

- 启动前台项目，进入node\admin

```jshelllanguage
npm run dev
```

- 浏览器访问 http://localhost:18099/#/member/data


