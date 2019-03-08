# spring-vue-element

#### 配置 node 环境

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

#### 配置 Vue 环境

- 安装cnpm淘宝镜像

```jshelllanguage
npm install -g cnpm --registry=https://registry.npm.taobao.org
```

- 安装Vue脚手架

```jshelllanguage
cnpm install -g webpack

cnpm install -g vue-cli
```

#### 前后端分离 访问项目

- 进入node/admin/index.js文件夹，修改访问地址

```xml
proxyTable: {
  '/': {
    target: 'http://localhost:8099/',
    changeOrigin: true,
    pathRewrite: {
      '^/': ''
    }
  }
}

```

- 进入node/admin 文件夹，安装组件

```jshelllanguage
cnpm install
```

- 启动后台项目

- 启动前台项目，进入node\admin

```jshelllanguage
npm run dev
```

- 浏览器访问 http://localhost:18099/#/member/data


#### 后台部署访问项目

- 前端项目打包

```jshelllanguage
npm run bulid
```

- 把dist项目的文件拷贝到后台static文件夹下

- 启动SpringBoot项目

- 浏览器访问 http://localhost:8099/#/member/data