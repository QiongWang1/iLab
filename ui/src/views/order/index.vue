<script setup lang="ts">

import {onMounted, reactive, ref} from "vue";
import {useRoute} from "vue-router";
import {getInventoryById, getOrdersByInventoryId} from "@/api/user";
import dayjs from "dayjs";

const inventoryItem = ref()

const currentOrder = ref()

const editInventory = ref({})

const editItem = ref({})

const tableData = ref([])

const state = reactive({
  drawerVisible: false
})

const route = useRoute()

const id = route?.query?.id

const linkOnClick = () => {

}

const detailOnClick = (row: any) => {
  state.drawerVisible = true
  currentOrder.value = row;
  editItem.value = {...row}
}

const requestOnClick = () => {

}

onMounted(async () => {
  if (id !== undefined) {
    const res1 = await getInventoryById(Number(id))
    if (res1.success) {
      inventoryItem.value = res1.data
      editInventory.value = res1.data
    }

    const res2 = await getOrdersByInventoryId(Number(id))
    if (res2.success) {
      console.log(res2.data)
      tableData.value = res2.data
    }

  }
})

const formatDate = (str) => {
  if (str === undefined || str === null) {
    return "-"
  }
  return dayjs(str).format("YYYY-MM-DD")
}

</script>

<template>
  <div class="bg-white p-4">
    <el-descriptions direction="vertical">
      <el-descriptions-item label="Item">
        {{inventoryItem?.item ?? "-"}}
      </el-descriptions-item>
    </el-descriptions>
    <el-descriptions direction="vertical">
      <el-descriptions-item label="Full Name">
        {{inventoryItem?.fullName ?? "-"}}
      </el-descriptions-item>

      <el-descriptions-item label="Vendor">
        {{inventoryItem?.vendor ?? "-"}}

      </el-descriptions-item>

      <el-descriptions-item label="Available Units">
        {{inventoryItem?.item ?? "-"}}

      </el-descriptions-item>
    </el-descriptions>

    <el-table :data="tableData">
      <el-table-column prop="owner" label="OWNER"></el-table-column>
      <el-table-column prop="distributor" label="DISTRIBUTOR"></el-table-column>
      <el-table-column prop="channel" label="CHANNEL"></el-table-column>
      <el-table-column prop="qty" label="UNIT QTY"></el-table-column>
      <el-table-column prop="unitPrice" label="UNIT PRICE"></el-table-column>
      <el-table-column prop="totalPrice" label="TOTAL PRICE"></el-table-column>
      <el-table-column prop="location" label="LOCATION"></el-table-column>
      <el-table-column prop="dateRequest" label="DATE REQUEST">
        <template #default="{row}">
          <p>{{formatDate(row.dateRequest)}}</p>
        </template>
      </el-table-column>
      <el-table-column prop="dateOrder" label="DATE ORDER">
        <template #default="{row}">
          <p>{{formatDate(row.dateOrder)}}</p>
        </template>
      </el-table-column>
      <el-table-column prop="dateReceived" label="DATE RECEIVED">
        <template #default="{row}">
          <p>{{formatDate(row.dateReceived)}}</p>
        </template>
      </el-table-column>
      <el-table-column width="260px">
        <template #default="{row}">
          <el-button type="primary" link @click="linkOnClick">Link</el-button>
          <el-button type="primary" link @click="detailOnClick(row)">Detail</el-button>
          <el-button type="primary" @click="requestOnClick">Request Again</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-drawer v-model="state.drawerVisible" size="50%">
      <div>
        <el-row :gutter="16">
          <el-col :span="18">
            <div>
              <h1>{{ inventoryItem?.item ?? "-"  }}</h1>
              <div>
                <el-tag>OWNER</el-tag>
                <span>{{ currentOrder?.owner ?? "-" }}</span>
              </div>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="flex flex-col gap-4">
              <el-button  type="primary" @click="requestOnClick">Request Again</el-button>
              <el-button  @click="requestOnClick">Update</el-button>
            </div>
          </el-col>
        </el-row>
        <h2>Item</h2>
        <el-form label-position="top">
          <el-form-item label="Full Name">
            <p>{{inventoryItem?.fullName ?? "-"}}</p>
          </el-form-item>

          <el-form-item label="Vendor">
            <el-input v-model="editInventory.vendor" />
          </el-form-item>

          <el-form-item label="Distributor">
            <el-input v-model="editItem.distributor"/>
          </el-form-item>

          <el-form-item label="Channel">
            <el-select v-model="editItem.channel">
              <el-option label="B2P" value="B2P"/>
              <el-option label="Amazon" value="Amazon"/>
            </el-select>
          </el-form-item>

          <el-form-item label="Catalog">
            <el-input v-model="editInventory.catalog"/>

          </el-form-item>

          <el-form-item label="Unit Size">
            <el-input v-model="editItem.unit"/>

          </el-form-item>

          <el-form-item label="Quantity">
            <el-input v-model="editItem.qty"/>
          </el-form-item>

          <el-form-item label="Unit Price">
            <el-input v-model="editItem.unitPrice"/>
          </el-form-item>

        </el-form>

        <div>
          <h2>Received</h2>
          <el-form label-position="top">

            <el-form-item label="Purchase Order">
              <el-input v-model="editInventory.purchaseOrder" />
            </el-form-item>

            <el-form-item label="Date Request">
              <el-date-picker v-model="editItem.dateRequest"/>
            </el-form-item>

            <el-form-item label="Ordered By">
              <el-input v-model="editItem.orderedBy"/>
            </el-form-item>

            <el-form-item label="Link">
              <el-input v-model="editItem.link"/>

            </el-form-item>

            <el-form-item label="Lab Location">
              <el-input v-model="editItem.location"/>

            </el-form-item>

            <el-form-item label="Date Received">
              <el-date-picker v-model="editItem.dateReceived"/>
            </el-form-item>

            <el-form-item label="Received By">
              <el-input v-model="editItem.receivedBy"/>
            </el-form-item>

            <el-form-item label="Notes">
              <el-input v-model="editItem.notes"/>
            </el-form-item>
          </el-form>
        </div>
      </div>
    </el-drawer>
  </div>
</template>

<style scoped>

</style>
