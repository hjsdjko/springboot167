"use strict";(self["webpackChunkvue3_nb0"]=self["webpackChunkvue3_nb0"]||[]).push([[639],{51639:(e,l,n)=>{n.r(l),n.d(l,{default:()=>_});n(63134),n(10307),n(39524);var a=n(67377),o=n(91370),t=n(98479),u=n(51290),r=function(e){return(0,a.dD)("data-v-27727658"),e=e(),(0,a.Cn)(),e},i={class:"login_view"},s=r((function(){return(0,a._)("div",{class:"title_view"},"基于springboot的租房系统登录",-1)})),v={key:0,class:"list_item"},d={key:1,class:"list_item"},c=["onKeydown"],p={key:2,class:"list_type"},f={class:"btn_view"};const m={__name:"login",setup:function(e){var l,n=(0,u.iH)([]),r=(0,u.iH)([]),m=(0,u.iH)({role:"",username:"",password:""}),g=(0,u.iH)(""),w=(0,u.iH)(1),_=null===(l=(0,a.FN)())||void 0===l?void 0:l.appContext.config.globalProperties,k=function(e){null===_||void 0===_||_.$router.push("/".concat(e,"Register"))},h=function(){if(m.value.username)if(m.value.password){if(n.value.length>1){if(!m.value.role)return null===_||void 0===_||_.$toolUtil.message("请选择角色","error"),void verifySlider.value.reset();for(var e=0;e<r.value.length;e++)r.value[e].roleName==m.value.role&&(g.value=r.value[e].tableName)}else g.value=n.value[0].tableName,m.value.role=n.value[0].roleName;y()}else null===_||void 0===_||_.$toolUtil.message("请输入密码","error");else null===_||void 0===_||_.$toolUtil.message("请输入用户名","error")},y=function(){null===_||void 0===_||_.$http({url:"".concat(g.value,"/login?username=").concat(m.value.username,"&password=").concat(m.value.password),method:"post"}).then((function(e){null===_||void 0===_||_.$toolUtil.storageSet("Token",e.data.token),null===_||void 0===_||_.$toolUtil.storageSet("role",m.value.role),null===_||void 0===_||_.$toolUtil.storageSet("sessionTable",g.value),null===_||void 0===_||_.$toolUtil.storageSet("adminName",m.value.username),null===_||void 0===_||_.$router.push("/")}),(function(e){}))},b=function(){var e={page:1,limit:1,sort:"id"};null===_||void 0===_||_.$http({url:"menu/list",method:"get",params:e}).then((function(e){r.value=JSON.parse(e.data.data.list[0].menujson);for(var l=0;l<r.value.length;l++)"是"==r.value[l].hasBackLogin&&n.value.push(r.value[l]);m.value.role=n.value[0].roleName,null===_||void 0===_||_.$toolUtil.storageSet("menus",JSON.stringify(r.value))}))},U=function(){b()};return(0,a.bv)((function(){U()})),function(e,l){var u=(0,a.up)("el-radio"),r=(0,a.up)("el-button"),g=(0,a.up)("el-form");return(0,a.wg)(),(0,a.iD)("div",null,[(0,a._)("div",i,[(0,a.Wm)(g,{model:m.value,class:"login_form"},{default:(0,a.w5)((function(){return[s,1==w.value?((0,a.wg)(),(0,a.iD)("div",v,[(0,a.wy)((0,a._)("input",{class:"list_inp","onUpdate:modelValue":l[0]||(l[0]=function(e){return m.value.username=e}),placeholder:"请输入账号"},null,512),[[o.nr,m.value.username]])])):(0,a.kq)("",!0),1==w.value?((0,a.wg)(),(0,a.iD)("div",d,[(0,a.wy)((0,a._)("input",{class:"list_inp","onUpdate:modelValue":l[1]||(l[1]=function(e){return m.value.password=e}),type:"password",placeholder:"请输入密码",onKeydown:(0,o.D2)(h,["enter","native"])},null,40,c),[[o.nr,m.value.password]])])):(0,a.kq)("",!0),n.value.length>1?((0,a.wg)(),(0,a.iD)("div",p,[((0,a.wg)(!0),(0,a.iD)(a.HY,null,(0,a.Ko)(n.value,(function(e,n){return(0,a.wg)(),(0,a.j4)(u,{key:n,modelValue:m.value.role,"onUpdate:modelValue":l[2]||(l[2]=function(e){return m.value.role=e}),label:e.roleName},{default:(0,a.w5)((function(){return[(0,a.Uk)((0,t.zw)(e.roleName),1)]})),_:2},1032,["modelValue","label"])})),128))])):(0,a.kq)("",!0),(0,a._)("div",f,[1==w.value?((0,a.wg)(),(0,a.j4)(r,{key:0,class:"login",type:"success",onClick:h},{default:(0,a.w5)((function(){return[(0,a.Uk)("登录")]})),_:1})):(0,a.kq)("",!0),(0,a.Wm)(r,{class:"register",type:"primary",onClick:l[3]||(l[3]=function(e){return k("fangdong")})},{default:(0,a.w5)((function(){return[(0,a.Uk)("注册房东")]})),_:1})])]})),_:1},8,["model"])])])}}};var g=n(57326);const w=(0,g.Z)(m,[["__scopeId","data-v-27727658"]]),_=w}}]);
//# sourceMappingURL=639.02f48ea8.js.map