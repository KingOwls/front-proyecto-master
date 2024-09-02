<script lang="ts">

   import { showProdcts } from "../stores/Stores";


   function toggProduct() {
      showProdcts.update((value) => !value);
   }
   function isShowEm() {
      alert("empleados");
   }
</script>

<div class="pgi hlc">
      <p class="cp lb" on:click={toggProduct}>Productos</p>
      <p class="cp lb" on:click={isShowEm}>Clientes</p>
      <p class="cp lb" on:click={isShowEm}>Pedidos</p>
      <p class="cp lb" on:click={isShowEm}>Pagos</p>
      <p class="cp lb " on:click={isShowEm}>Empleados</p>
      <p class="cp lb" on:click={isShowEm}>Oficinas</p>
</div>

<style lang="less">
   .hlc{
      width: 13.5%;
      background-color: black;
      color: white;
     height: auto;
   }
   .lb{
      text-align: center;

   }
   .lb:hover{
      border: 1px solid white;

   }
   


</style>
