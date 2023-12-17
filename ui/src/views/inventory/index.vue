<script setup>

import {onMounted, ref} from "vue";
import {getInventoryList, getInventorySearchList} from "../../api/user";
import {useRoute, useRouter} from "vue-router";
import dayjs from "dayjs";

const tableData = ref([])

const router = useRouter()

const route = useRoute()

const keyword = ref("")

const orderOnClick = (row) => {
  router.push({
    name: "order",
    query: {
      id: row.id
    }
  })
}

const requestListData = async () => {
  const res = await getInventoryList()
  tableData.value = res.data
}

const requestSearchData = async () => {
  const res = await getInventorySearchList(keyword.value)
  tableData.value = res.data
}

onMounted(() => {
  const k = route.query?.keyword
  if (k) {
    keyword.value = k
    requestSearchData()
  } else {
    requestListData()
  }
})

const formatDate = (str) => {
  if (str === undefined || str === null) {
    return "-"
  }
  return dayjs(str).format("YYYY-MM-DD")
}

const resetOnClick = () => {
  keyword.value = ""
  requestListData()
}

const searchOnClick = () => {
  requestSearchData()
}
</script>

<template>
  <div>
    <el-form inline>
      <el-row>
        <el-col :span="18">
          <el-form-item label="搜索">
            <el-input v-model="keyword" placeholder="please input"/>
          </el-form-item>
        </el-col>
        <el-button @click="resetOnClick">reset</el-button>
        <el-button type="primary" @click="searchOnClick">search</el-button>
      </el-row>
    </el-form>
    <el-table :data="tableData">
      <el-table-column prop="item" label="ITEM"></el-table-column>
      <el-table-column prop="fullName" label="FULL NAME"></el-table-column>
      <el-table-column prop="vendor" label="VENDOR"></el-table-column>
      <el-table-column prop="catalog" label="CATALOG"></el-table-column>
      <el-table-column prop="lastOrderedDate" label="LAST ORDERED DATE">
        <template #default="{row}">
          <p>{{formatDate(row.lastOrderedDate)}}</p>
        </template>
      </el-table-column>
      <el-table-column prop="lastReceivedDate" label="LAST RECEIVED DATE">
        <template #default="{row}">
          <p>{{formatDate(row.lastReceivedDate)}}</p>
        </template>
      </el-table-column>
      <el-table-column>
        <template #default="{row}">
          <el-button type="primary" link @click="orderOnClick(row)"
            >All Order</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped>

</style>
