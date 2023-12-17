<script setup>

import {computed, reactive, ref} from "vue";
import {addItem} from "@/api/user";
import {useRouter} from "vue-router";

const inventoryData = ref({})
const orderData = ref({})

const calcTotalPrice = computed(() => {
  if (orderData.unitPrice?.length > 0 && orderData.qty?.length > 0) {
    return Number(orderData.unitPrice) * Number(orderData.qty)
  }

  return 0
})

const clearOnClick = () => {
  inventoryData.value = {}
  orderData.value = {}
}

const router = useRouter()

const submitOnClick = async () => {
  const data = {
    inventory: inventoryData.value,
    order: orderData.value,
  }

  const res = await addItem(data)

  if (res.success) {
    router.back()
  }
}
</script>

<template>
  <div class="p-4 bg-white">
    <h1 class="text-center mb-4">Add Request</h1>
    <el-row :gutter="32">
      <el-col :span="12">
        <el-form label-position="top" style="width: 500px">
          <el-form-item label="Item">
            <el-input v-model="inventoryData.item"/>
          </el-form-item>

          <el-form-item label="Full Name">
            <el-input v-model="inventoryData.fullName" type="textarea" :rows="3"/>
          </el-form-item>

          <el-form-item label="Vendor">
            <el-input v-model="inventoryData.vendor"/>
          </el-form-item>

          <el-form-item label="Distributor">
            <el-input v-model="orderData.distributor"/>
          </el-form-item>

          <el-form-item label="Channel">
            <el-select v-model="inventoryData.channel">
              <el-option label="B2P" value="B2P"/>
              <el-option label="Amazon" value="Amazon"/>
            </el-select>
          </el-form-item>

          <el-form-item label="Catalog">
            <el-input v-model="inventoryData.catalog"/>
          </el-form-item>

          <el-form-item label="Link">
            <el-input v-model="orderData.link "/>
          </el-form-item>
        </el-form>
      </el-col>
      <el-col :span="12">
        <el-form label-position="top" style="width: 500px">
          <el-row :gutter="16">
            <el-col :span="12">
              <el-form-item label="Unit Size">
                <el-input v-model="orderData.unit"/>
              </el-form-item>
            </el-col>

            <el-col :span="12">
              <el-form-item label="Quantity">
                <el-input v-model="orderData.qty"/>
              </el-form-item>
            </el-col>
          </el-row>

          <el-form-item label="Unit Price">
            <el-input v-model="orderData.unitPrice"/>
          </el-form-item>

          <el-form-item label="Total Price">
            <p>${{ calcTotalPrice }}</p>
          </el-form-item>

          <el-form-item label="Date Request">
            <el-date-picker v-model="orderData.dateRequest"/>
          </el-form-item>

          <el-form-item label="Notes">
            <el-input v-model="orderData.notes" type="textarea" :rows="3"/>
          </el-form-item>
        </el-form>

        <div>
          <el-button @click="clearOnClick">Clear</el-button>
          <el-button type="primary" @click="submitOnClick">Submit</el-button>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<style scoped>

</style>
