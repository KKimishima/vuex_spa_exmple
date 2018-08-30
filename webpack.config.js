const {VueLoaderPlugin} = require('vue-loader')
var webpack = require('webpack')

// webpack.config.js
module.exports = {
  // メインとなるソースファイル
  entry: './src/main/js/index.js',
  // 出力設定
  // この場合はdest/bundle.jsというファイルが生成される
  output: {
    // 出力先のファイル名
    filename: 'bundle.js',
    // 出力先のファイルパス
    path: `${__dirname}/src/main/resources/static/js`,
  },
  watch: true,
  devServer: {
    contentBase: 'dist',
    open: true,
    port: 3003
  },
  module: {
    rules: [
      {
        test: /\.vue$/,
        loader: 'vue-loader',
      },
      {
        test: /\.js$/,
        loader: 'babel-loader?presets=es2015',
      },
      {
        test: /\.css$/,
        use: ['style-loader', 'css-loader']
      },
    ]
  },
  resolve: {
    extensions: ['.js', '.vue'],
    alias: {
      vue$: 'vue/dist/vue.esm.js',
    },
  },
  plugins: [
    // make sure to include the plugin for the magic
    new VueLoaderPlugin(),
    new webpack.ProvidePlugin({
      $: 'jquery',
      jQuery: 'jquery',
      'window.jQuery': 'jquery',
      Popper: ['popper.js', 'default'],
    })
  ]
}