<script setup lang="ts">
import { ref } from "vue";
import {useRouter} from "vue-router";
import { bg, avatar, illustration } from "@/views/login/utils/static";

defineOptions({
  name: "Welcome"
});

const router = useRouter()

const keyword = ref("");

const addItemOnClick = () => {
  router.push({name: "add-item"})
}

const inventoryOnClick = () => {
  router.push({name: "Inventory"})
}

const searchHandler = () => {
  router.push({name: "Inventory", query: {
    keyword: keyword.value
    }})
}
</script>

<template>
  <div class=" flex justify-center p-4 bg-white">
    <div class="w-[800px] flex flex-col items-center">
      <avatar class="avatar mb-4" />
      <p class="p-4 text-[38px] font-semibold">Search History Item</p>
      <p class="mb-4">Use the Item, Full Name, Vendor, Catalog or Date</p>
      <el-input style="width: 500px"
                v-model="keyword"
                @keyup.enter.native="searchHandler"
                placeholder="human NFAT engineered"/>

      <div class="flex gap-4 p-4">
        <div>
          <el-button type="primary" @click="addItemOnClick">Add Request</el-button>
        </div>

        <div>
          <el-button @click="inventoryOnClick">Inventory & Request</el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>

</style>
