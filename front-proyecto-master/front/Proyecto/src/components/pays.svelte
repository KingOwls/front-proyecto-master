<script lang="ts">
  import axios from "axios";
  import { onMount } from "svelte";
  import { showProdcts } from "../stores/Stores";

  let isActiveCrud: boolean = true;
  let errorMessage = "";
  let id: number;
  let monto: number;
  let fecha_pago: string;
  let pedido: string;
  let ElementSearch: string = "";
  let error: string = "";
  let loading: boolean = true;
  let info: any[] = [];
  let showSearch: boolean = true;
  let showUpdate: boolean = true;
  let showDelete: boolean = true;
  let isActiveCreate: boolean = true;

  function toggleProduct() {
    isActiveCrud = !isActiveCrud;
  }

  function crate() {
    isActiveCreate = !isActiveCreate;
  }

  function search() {
    showSearch = !showSearch;
  }

  function update() {
    showUpdate = !showUpdate;
  }

  function deleteToggle() {
    showDelete = !showDelete;
  }

  function exit() {
    $showProdcts = !$showProdcts;
  }

  async function filterItem() {
    loading = true;
    try {
      const response = await axios.get(`http://localhost:8091/api/pagos/${id}`);
      info = response.data.map((data: any) => ({
        id: data.id,
        monto: data.monto,
        fecha_pago: data.fecha_pago,
        pedido: data.pedido,
      }));
    } catch (error) {
      error = "Error al buscar el pago.";
    } finally {
      loading = false;
    }
  }

  async function save() {
    loading = true;
    const url = `http://localhost:8091/api/pagos/${id}`;
    const updatedData = {
      id: id,
      monto: monto,
      fecha_pago: fecha_pago,
      pedido: pedido,
    };
    try {
      const response = await axios.put(url, updatedData);
      info = response.data;
      alert("Datos actualizados con éxito");
    } catch (error) {
      console.error("Error al actualizar los datos:", error);
      errorMessage = "Error al guardar los datos";
      alert(errorMessage);
    } finally {
      loading = false;
    }
  }

  async function deleteProduct() {
    loading = true;
    try {
      await axios.delete(`http://localhost:8091/api/pagos/${id}`);
      alert("Pago eliminado exitosamente");
    } catch (error) {
      console.error("Error al eliminar el pago:", error);
      errorMessage = "Error al eliminar el pago";
      alert(errorMessage);
    } finally {
      loading = false;
    }
  }

  async function createProduct() {
    loading = true;
    const url = `http://localhost:8091/api/pagos`;
    const newPayment = {
      monto: monto,
      fecha_pago: fecha_pago,
      pedido: pedido,
    };
    try {
      await axios.post(url, newPayment);
      alert("Pago creado exitosamente");
    } catch (error) {
      console.error("Error al crear el pago:", error);
      errorMessage = "Error al crear el pago";
      alert(errorMessage);
    } finally {
      loading = false;
    }
  }
</script>

<div class="cpw gcc">
  {#if isActiveCrud}
    <div>
      <button class="cp3" on:click={crate}>Crear</button>
      <button class="cp3" on:click={search}>Buscar</button>
      <button class="cp3" on:click={update}>Actualizar</button>
      <button class="cp3" on:click={deleteToggle}>Eliminar</button>
      <button class="cp3" on:click={exit}>Salir</button>
    </div>
  {/if}
  
  {#if !showSearch || !showDelete}
    <div class="f">
      <input
        class="form-control me-2"
        bind:value={id}
        type="search"
        placeholder="ID del pago"
        aria-label="Search"
      />

      {#if !showSearch}
        <button class="cp2" on:click={search}>Volver</button>
        <button class="cp" on:click={filterItem}>Buscar</button>
      {/if}
      {#if !showDelete}
        <button class="cp2" on:click={deleteToggle}>Volver</button>
        <button class="cp" on:click={deleteProduct}>Eliminar</button>
      {/if}
    </div>
  {/if}

  {#if !showUpdate || !isActiveCreate}
    <div class="crud">
      <section class="fcc">
        <label for="id">ID</label>
        <input id="id" bind:value={id} placeholder="Ingrese un ID" />
      </section>
      <section class="fcc">
        <label for="monto">Monto</label>
        <input
          id="monto"
          type="number"
          bind:value={monto}
          placeholder="Ingrese el monto"
        />
      </section>
      <section class="fcc">
        <label for="fecha_pago">Fecha de Pago</label>
        <input
          id="fecha_pago"
          type="date"
          bind:value={fecha_pago}
          placeholder="Ingrese la fecha de pago"
        />
      </section>
      <section class="fcc">
        <label for="pedido">Pedido</label>
        <input
          id="pedido"
          bind:value={pedido}
          placeholder="Ingrese el pedido"
        />
      </section>
    </div>
    {#if !isActiveCreate}
      <button class="cp2" on:click={crate}>Volver</button>
      <button class="cp2" on:click={save}>Guardar</button>
    {/if}
    {#if !showUpdate}
      <button class="cp2" on:click={update}>Volver</button>
      <button class="cp2" on:click={save}>Guardar</button>
    {/if}
  {/if}
</div>

<style lang="less">
  .cp2 {
    margin-top: 10px;
    height: 50px;
    width: 100%;
    background-color: #007bff;
    display: flex;
    align-items: center;
    justify-content: center;
    border: none;
    border-radius: 5px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    cursor: pointer;
    font-size: 1rem;
    transition:
      background-color 0.3s,
      box-shadow 0.3s;
  }

  .crud {
    overflow: hidden;
    margin-top: 20px;
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    gap: 1rem;
  }

  .fcc {
    display: flex;
    flex-direction: column;
  }

  .fcc label {
    font-size: 1rem;
    margin-bottom: 0.5rem;
  }

  .fcc input {
    overflow: hidden;
    padding: 0.75rem;
    border: 1px solid #ced4da;
    border-radius: 0.25rem;
    font-size: 1rem;
    color: #495057;
    background-color: #fff;
    box-sizing: border-box;
  }

  .fcc input:focus {
    border-color: #007bff;
    outline: none;
    box-shadow: 0 0 0 0.2rem rgba(38, 143, 255, 0.25);
  }

  .cp3 {
    flex: 1;
    margin: 0 5px;
    padding: 10px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 1rem;
    transition:
      background-color 0.3s,
      box-shadow 0.3s;
    text-align: center;
    overflow-y: hidden;
  }

  .cp3:hover,
  .cp2:hover {
    background-color: #0056b3;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
  }

  @media (max-width: 768px) {
    .crud {
      grid-template-columns: 1fr;
    }

    .cp2,
    .cp3 {
      height: 40px;
      font-size: 0.875rem;
    }

    .fcc {
      flex-direction: column;
    }
  }

  @media (min-width: 769px) and (max-width: 992px) {
    .crud {
      grid-template-columns: repeat(2, 1fr);
    }

    .cp2,
    .cp3 {
      height: 45px;
      font-size: 0.95rem;
    }
  }

  @media (min-width: 993px) {
    .crud {
      grid-template-columns: repeat(2, 1fr);
    }

    .cp2,
    .cp3 {
      height: 50px;
      font-size: 1rem;
    }
  }
</style>
