<script lang="ts">
    import axios from "axios";
    import { onMount } from "svelte";
    import { instance, showProdcts } from "../stores/Stores";

    let showod;
    let isActiveCrud: boolean = true;
    let errorMessage = "";
    let id: number;
    let contacto: number;
    let ubicacion: number;
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

    function crate() {
        isActiveCreate = !isActiveCreate;
    }

    function search() {
        showSearch = !showSearch;
    }

    function update() {
        showUpdate = !showUpdate;
    }

    function deletle() {
        showdelte = !showdelte;
    }

    function exit() {
        $showProdcts = !$showProdcts;
    }


    async function filterItem() {
        onMount(async () => {
            try {
                const response = await instance.get(
                    `https://jsonplaceholder.typicode.com/posts/${ElementSearch}`,
                );
                info = response.data.map((data: any) => ({
                    id: data.id,
                    contacto: data.contacto,
                    ubicacion: data.ubicacion
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
            contacto: contacto,
            ubicacion: ubicacion
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
      <input
        class="wh"
        placeholder="Elemento a buscar"
        on:input={filterItem}
        bind:value={ElementSearch}
      />
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
        <button class="cp">buscar</button>
      {/if}

      {#if !showdelte}
        <button class="cp" on:click={deletle}>volver</button>
        <button class="cp">borrar</button>
      {/if}
    </div>
  {/if}

  {#if !showUpdate || !isActiveCreate}
    <div class="crud">
      <p>Productos</p>
      <section class="fcc">
        <label for="id">ID</label>
        <input id="id" bind:value={id} placeholder="Ingrese el Id de la oficina" />
      </section>
      <section class="fcc">
        <label for="contacto">Contacto</label>
        <input
          id="contacto"
          bind:value={contacto}
          on:change={filterItem}
          placeholder="Ingrese el contacto de la oficina"
        />
      </section>
      <section class="fcc">
        <label for="ubicacion">Ubicacion</label>
        <input
          id="ubicacion"
          bind:value={ubicacion}
          on:change={filterItem}
          placeholder="Ingrese la ubicacion de la oficina"
        />
      </section>

      {#if !isActiveCreate}
        <button class="cp" on:click={crate}>Volver</button>
        <button class="cp" on:click={save}>Guardar</button>
      {/if}

      {#if !showUpdate}
        <button class="cp" on:click={update}>Volver</button>
        <button class="cp" on:click={save}>Guardar</button>
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
      height: auto;
      width: 50rem;
      margin: auto;
  }
  .cp {
    border-style: none;
    background-color: pink;
  }
  .fcc {
    display: flex;
    flex-direction: column;
  }
  /* Etiquetas */
  .fcc label {
    font-size: 1rem; /* Tamaño de fuente de las etiquetas */
    margin-bottom: 0.5rem; /* Espacio entre la etiqueta y el campo de entrada */
    color: #333; /* Color del texto de las etiquetas */
  }
  /* Campos de entrada */
  .fcc input {
    padding: 0.75rem; /* Espaciado interno del campo de entrada */
    border: 1px solid #ced4da; /* Borde del campo de entrada */
    border-radius: 0.25rem; /* Bordes redondeados */
    font-size: 1rem; /* Tamaño de fuente del texto del campo de entrada */
    color: #495057; /* Color del texto en el campo de entrada */
    background-color: #fff; /* Fondo blanco para los campos de entrada */
    width: 100%; /* Campo de entrada ocupa todo el ancho del contenedor */
    box-sizing: border-box; /* Incluye el padding y el borde en el ancho total del elemento */
  }
  /* Campo de entrada con enfoque */
  .fcc input:focus {
    border-color: #007bff; /* Color del borde al tener el foco */
    outline: none; /* Elimina el contorno predeterminado del navegador */
    box-shadow: 0 0 0 0.2rem rgba(38, 143, 255, 0.25); /* Sombra de enfoque */
  }
  /* Espaciado general del formulario */
  .container {
    padding: 2rem; /* Espacio interno del contenedor del formulario */
    background-color: #f8f9fa; /* Fondo claro para el contenedor */
    border-radius: 0.5rem; /* Bordes redondeados del contenedor */
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Sombra del contenedor */
  }
  /* Añadir un poco de espaciado al principio del contenedor */
  body {
    padding-top: 2rem; /* Espacio superior del body para evitar el contacto con la parte superior de la ventana */
  }
</style>
