import { http } from "@/utils/http";

export type UserResult = {
  success: boolean;
  data: {
    /** 用户名 */
    username: string;
    /** 当前登陆用户的角色 */
    roles: Array<string>;
    /** `token` */
    accessToken: string;
    /** 用于调用刷新`accessToken`的接口时所需的`token` */
    refreshToken: string;
    /** `accessToken`的过期时间（格式'xxxx/xx/xx xx:xx:xx'） */
    expires: Date;
  };
};

export type RefreshTokenResult = {
  success: boolean;
  data: {
    /** `token` */
    accessToken: string;
    /** 用于调用刷新`accessToken`的接口时所需的`token` */
    refreshToken: string;
    /** `accessToken`的过期时间（格式'xxxx/xx/xx xx:xx:xx'） */
    expires: Date;
  };
};

export type TInventoryItem = {
  id?:               number;
  item?:             string;
  fullName?:         string;
  vendor?:           string;
  catalog?:          string;
  lastOrderedDate?:  string;
  lastReceivedDate?: string;
}

export type ServiceResponse<T> = {
  msg?: string;
  code?: number;
  data?: T;
  success?: boolean
}

/** 登录 */
export const getLogin = (data?: object) => {
  return http.request<UserResult>("post", "/api/login", { data });
};

/** 刷新token */
export const refreshTokenApi = (data?: object) => {
  return http.request<RefreshTokenResult>("post", "/api/refreshToken", { data });
};

export const getInventoryList = () => {
  return http.get("/api/inventories")
}

export const getInventorySearchList = (keyword: string) => {
  return http.get("/api/inventories/search", {
    params: {keyword}
  })
}

export const getInventoryById = (id: number) => {
  return http.get(`/api/inventory/${id}`)
}

export const getOrdersByInventoryId = (id: number) => {
  return http.get("/api/orders", {params: {id: id}})
}

export const addItem = (data: any) => {
  return http.post("/api/add-item", {data})
}
