<script lang="ts">
    import axios from "axios";
    import { onMount } from "svelte";
    import { showProdcts } from "../stores/Stores";
    let showod;
    let isActiveCrud: boolean = true;
    let errorMessage = "";
    let id: number;
    let cliente: number;
    let estado:number;
    let fecha_entregada:Date;
    let fecha_esperada:Date;
    let fecha_pedido:Date;
    let comentarios:string;
    let metodo_pago:string;
    let ElementSearch: string = "";
    let error: string = "";
    let loading: boolean = true;
    let info: any[] = [];
    let showSearch: boolean = true;
    let showUpdate:boolean=true;
    let showdelte:boolean=true;

    function toggProdcto() {
        isActiveCrud = !isActiveCrud;
    }
    let isActiveCreate:boolean=true;
    function crate(){
      isActiveCreate = !isActiveCreate;
    }

    function search() {
        showSearch = !showSearch;
    }
function update(){
    showUpdate = !showUpdate;
}
function deletle(){
  showdelte = !showdelte;
}

function exit(){
  $showProdcts = !$showProdcts;
}
    async function filterItem() {
        onMount(async () => {
            try {
                const response = await axios.get(
                    `https://jsonplaceholder.typicode.com/posts/${ElementSearch}`,
                );
                info = response.data.map((data: any) => ({

                    id: data.id,
                    cliente: data.cliente,
                    estado:data.estado,
                    fecha_entregada:data.fecha_entregada,
                    fecha_esperada:data.fecha_esperada,
                    fecha_pedido: data.fecha_pedido,
                    comentarios:data.comentarios,
                    metodo_pago:data.metodo_pago
                }));
            } catch (erro) {
                error = "fail";
            } finally {
                loading = false;
            }
            console.log("logrado");
        });
    }

    async function save() {
        loading = true;
        const url = "https://jsonplaceholder.typicode.com/posts/1";
        const updatedData = {
            id: id,
            cliente:cliente,
            estado:estado,
            fecha_entregada:fecha_entregada,
            fecha_esperada:fecha_esperada,
            fecha_pedido:fecha_pedido,
            comentarios:comentarios,
            metodo_pago:metodo_pago
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

    
</script>

<div class="cpw gcc">
  {#if isActiveCrud}
    <div>
    <button class="cp" on:click={crate}>Crear</button>
    <button class="cp" on:click={search}>Buscar</button>
    <button class="cp" on:click={update}>Actualizar</button>
    <button class="cp" on:click={deletle}>Eliminar</button>
    <button class="cp" on:click={exit}>salir</button>
  </div>
  {/if}
  {#if !showSearch || !showdelte}
        <div class="f">
    <!--       <input
            class="wh"
            placeholder="Elemento a buscar"
            on:input={filterItem}
            bind:value={ElementSearch}
           -->
          
           <nav class="navbar bg-body-tertiary">
            <div class="container-fluid">
              <a class="navbar-brand">Navbar</a>
              <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
              </form>
            </div>
          </nav>

          
          {#if !showSearch} 
          <button class="cp" on:click={search}>volver</button>
          <button class="cp" >buscar</button>
          {/if}
          {#if !showdelte}
          <button class="cp" on:click={deletle}>volver</button>
          <button class="cp" >borrar</button>
          {/if}
        </div>
      {/if}




<!-- Vertically centered modal -->








  {#if !showUpdate || !isActiveCreate }
  <div class="modal-dialog modal-dialog-centered">
  <p>Productos</p>
  <section class="fcc">
    <label for="id">ID</label>
    <input id="id" bind:value={id} placeholder="Ingrese un el Id del cliente" />
  </section>
  <section class="fcc">
    <label for="cliente">Cliente</label>
    <input
      id="cliente"
      bind:value={cliente}
      on:change={filterItem}
      placeholder="Ingrese el id del cliente dueño del pedido"
    />
  </section>
  <section class="fcc">
    <label for="estado">Estado</label>
    <input
      id="estado"
      bind:value={estado}
      on:change={filterItem}
      placeholder="Ingrese estado del pedido"
    />
  </section>
  <section class="fcc">
    <label for="fecha_entregada">Fecha de entrega</label>
    <input
      id="fecha_entregada"
      bind:value={fecha_entregada}
      on:change={filterItem}
      placeholder="Ingrese la fecha de entrega "
    />
  </section>
  <section class="fcc">
    <label for="fecha_esperada">Fecha esperada</label>
    <input
      id="fecha_esperada"
      bind:value={fecha_esperada}
      on:change={filterItem}
      placeholder="Ingrese la fecha esperada de entrega del pedido"
    />
  </section>
  <section class="fcc">
    <label for="fecha_pedido">Fecha de pedido</label>
    <input
      id="fecha_pedido"
      bind:value={fecha_pedido}
      on:change={filterItem}
      placeholder="Ingrese la fecha de realizacion del pedido"
    />
  </section>
  <section class="fcc">
    <label for="comentarios">comentarios</label>
    <input
      id="comentarios"
      bind:value={comentarios}
      on:change={filterItem}
      placeholder="Ingrese comentarios"
    />
  </section>
  <section class="fcc">
    <label for="metodo_pago">metodo_pago</label>
    <input
      id="metodo_pago"
      bind:value={metodo_pago}
      on:change={filterItem}
      placeholder="Ingrese metodo de pago"
    />
  </section>
</div>
{#if !isActiveCreate}
<button class="cp" on:click={crate}>Volver</button>
<button class="cp" >Guardar</button>
{/if}
{#if !showUpdate}
<button class="cp" on:click={update}>Volver</button>
<button class="cp" >Guardar</button>
{/if}

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
