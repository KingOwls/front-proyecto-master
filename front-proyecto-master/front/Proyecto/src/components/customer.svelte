<script lang="ts">
  import axios from "axios";
  import { onMount } from "svelte";
  import { showProdcts } from "../stores/Stores";

  let showod;
  let isActiveCrud: boolean = true;
  let errorMessage = "";
  let id: number;
  let credito: number;
  let cuenta: number;
  let empleado: number;
  let ubicacion: number;
  let nombres: string;
  let apellidos: string;
  let ElementSearch: string = "";
  let error: string = "";
  let loading: boolean = true;
  let info: any[] = [];
  let showSearch: boolean = true;
  let showUpdate: boolean = true;
  let showdelte: boolean = true;

  function toggProdcto() {
    isActiveCrud = !isActiveCrud;
  }

  let isActiveCreate: boolean = true;
  function createCustomer() {
    isActiveCreate = !isActiveCreate;
  }

  function searchCustomer() {
    showSearch = !showSearch;
  }

  function updateCustomer() {
    showUpdate = !showUpdate;
  }

  function deleteCustomer() {
    showdelte = !showdelte;
  }

  function exit() {
    $showProdcts = !$showProdcts;
  }

//CREAR CLIENTE
async function GenerateCustomer() {
    loading = true;
    const url = `http://localhost:8091/api/clientes`;
    const newCustomer = {
      id: id,
      credito: credito,
      cuenta: cuenta,
      empleado: empleado,
      ubicacion: ubicacion,
      nombres: nombres,
      apellidos: apellidos
    };
    try {
      await axios.post(url, newCustomer);
      alert("Cliente creado exitosamente");
    } catch (error) {
      console.error("Error al crear el cliente:", error);
      errorMessage = "Error al crear el cliente";
      alert(errorMessage);
    } finally {
      loading = false;
    }
  }
//BUSCAR CLIENTE
  async function filterCustomer() {
    onMount(async () => {
      try {
        const response = await axios.get(
          `http://localhost:8091/api/clientes/${id}`
        );
        info = response.data.map((data: any) => ({
          id: data.id,
          credito: data.credito,
          cuenta: data.cuenta,
          empleado: data.empleado,
          ubicacion: data.ubicacion,
          nombres: data.nombres,
          apellidos: data.apellidos,
        }));
      } catch (erro) {
        error = "fail";
      } finally {
        loading = false;
      }
      console.log("Busqueda exitosa!!!");
    });
  }

//ACTUALIZA CLIENTE
  async function upgradeCustomer() {
    loading = true;
    const url = "http://localhost:8091/api/clientes/${id}";
    const updatedData = {
      id: id,
      credito: credito,
      cuenta: cuenta,
      empleado: empleado,
      ubicacion: ubicacion,
      nombres: nombres,
      apellidos: apellidos,
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

  //ELIMINA CLIENTE
  async function removeCustomer() {
    loading = true;
    try {
      await axios.delete(`http://localhost:8091/api/clientes/${id}`);
      alert("Cliente eliminado exitosamente");
    } catch (error) {
      console.error("Error al eliminar al cliente:", error);
      errorMessage = "Error al eliminar al cliente";
      alert(errorMessage);
    } finally {
      loading = false;
    }
  }
</script>

<div class="cpw gcc">
  {#if isActiveCrud}
    <div>
      <button class="cp" on:click={createCustomer}>Crear</button>
      <button class="cp" on:click={searchCustomer}>Buscar</button>
      <button class="cp" on:click={updateCustomer}>Actualizar</button>
      <button class="cp" on:click={deleteCustomer}>Eliminar</button>
      <button class="cp" on:click={exit}>salir</button>
    </div>
  {/if}

  {#if !showSearch || !showdelte}
    <div class="f">
      <input
        class="wh"
        placeholder="Elemento a buscar"
        bind:value={id}
      />
      <nav class="navbar bg-body-tertiary">
        <div class="container-fluid">
          <a class="navbar-brand">Navbar</a>
          <form class="d-flex" role="search">
            <input
              class="form-control me-2"
              type="search"
              placeholder="Search"
              aria-label="Search"
            />
          </form>
        </div>
      </nav>

      {#if !showSearch}
        <button class="cp" on:click={searchCustomer}>volver</button>
        <button class="cp" on:click={filterCustomer}>buscar</button>
      {/if}

      {#if !showdelte}
        <button class="cp" on:click={deleteCustomer}>volver</button>
        <button class="cp" on:click={removeCustomer}>borrar</button>
      {/if}
    </div>
  {/if}

  {#if !showUpdate || !isActiveCreate}
    <div class="modal-dialog modal-dialog-centered">
      <p>Clientes</p>
      <section class="fcc">
        <label for="id">ID</label>
        <input
          id="id"
          bind:value={id}
          placeholder="Ingrese un el Id del cliente"
        />
      </section>
      <section class="fcc">
        <label for="credito">Credito</label>
        <input
          id="credito"
          bind:value={credito}
          placeholder="Ingrese el id del credito"
        />
      </section>
      <section class="fcc">
        <label for="nombres">Nombres</label>
        <input
          id="nombres"
          bind:value={nombres}
          placeholder="Ingrese nombres"
        />
      </section>
      <section class="fcc">
        <label for="apellidos">Apellidos</label>
        <input
          id="apellidos"
          bind:value={apellidos}
          placeholder="Ingrese apellidos"
        />
      </section>
      <section class="fcc">
        <label for="cuenta">Cuenta</label>
        <input
          id="cuenta"
          bind:value={cuenta}
          placeholder="Ingrese cuenta"
        />
      </section>
      <section class="fcc">
        <label for="empleado">Empleado</label>
        <input
          id="empleado"
          bind:value={empleado}
          placeholder="Ingrese empleado encargado"
        />
      </section>
      <section class="fcc">
        <label for="ubicacion">Ubicacion</label>
        <input
          id="ubicacion"
          bind:value={ubicacion}
          placeholder="Ingrese ubicacion"
        />
      </section>
      {#if !isActiveCreate}
        <button class="cp" on:click={createCustomer}>Volver</button>
        <button class="cp" on:click={GenerateCustomer}>Guardar</button>
      {/if}
      {#if !showUpdate}
        <button class="cp" on:click={updateCustomer}>Volver</button>
        <button class="cp" on:click={upgradeCustomer}>Guardar</button>
      {/if}
    </div>
  {/if}
</div>

<style lang="less">
  .wh {
    width: 15rem;
    height: 1rem;
  }
  .cpw {
    background-color: aqua;
    height: auto;
    width: 50rem;
    margin: auto;
  }
</style>
