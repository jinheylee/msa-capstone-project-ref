<template>

<v-data-table
    :headers="headers"
    :items="orderView"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'OrderView',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "id", value: "id" },
            { text: "productId", value: "productId" },
            { text: "productName", value: "productName" },
            { text: "qty", value: "qty" },
            { text: "orderStatus", value: "orderStatus" },
            { text: "deliveryStatus", value: "deliveryStatus" },
            { text: "address", value: "address" },
        ],
        orderView : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/orderviews')

      this.orderView = temp.data._embedded.orderviews;

    },
    methods: {
    }
  }
</script>

