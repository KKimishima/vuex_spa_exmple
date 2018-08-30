// ルート用のコンポーネントを読み込む
import Home from './view/home/Home'
import New from "./view/new/New"

export default[
  {path: '/', component: Home},
  {path: "/New", component: New},
]