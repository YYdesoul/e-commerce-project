export default {
  /**
   * @description 配置显示在浏览器标签的title
   */
  title: '码神之路电商',
  /**
   * @description token在Cookie中存储的天数，默认1天
   */
  cookieExpires: 1,
  /**
   * @description 是否使用国际化，默认为false
   *              如果不使用，则需要在路由中给需要在菜单中展示的路由设置meta: {title: 'xxx'}
   *              用来在菜单中显示文字
   */
  useI18n: true,
  /**
   * @description api请求基础路径
   */
  api_dev: {
    common: 'http://localhost:9990',
    buyer: 'http://localhost:9991',
    seller: 'http://localhost:9992',
    manager: 'http://localhost:9993'
  },
  api_prod: {
    common: 'https://mall.mszlu.com/common',
    buyer: 'https://mall.mszlu.com/buyer',
    seller: 'https://mall.mszlu.com/seller',
    manager: 'https://mall.mszlu.com/admin'
  },
  /**
   *  @description api请求基础路径前缀
   */
  baseUrlPrefix: '/buyer',
  /**
   * @description 需要加载的插件
   */
  plugin: {
    'error-store': {
      showInHeader: true, // 设为false后不会在顶部显示错误日志徽标
      developmentOff: true // 设为true后在开发环境不会收集错误信息，方便开发中排查错误
    }
  }
};
