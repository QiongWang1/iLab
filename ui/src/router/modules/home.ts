import { $t } from "@/plugins/i18n";
const { VITE_HIDE_HOME } = import.meta.env;
const Layout = () => import("@/layout/index.vue");

export default {
  path: "/",
  name: "Home",
  component: Layout,
  redirect: "/welcome",
  meta: {
    icon: "homeFilled",
    title: $t("menus.hshome"),
    rank: 0
  },
  children: [
    {
      path: "/welcome",
      name: "Welcome",
      component: () => import("@/views/welcome/index.vue"),
      meta: {
        title: $t("menus.hshome"),
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/inventory",
      name: "Inventory",
      component: () => import("@/views/inventory/index.vue"),
      meta: {
        title: "Inventory",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/add-item",
      name: "add-item",
      component: () => import("@/views/add-item/index.vue"),
      meta: {
        title: "add-item",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/order",
      name: "order",
      component: () => import("@/views/order/index.vue"),
      meta: {
        title: "order",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
  ]
} as RouteConfigsTable;
