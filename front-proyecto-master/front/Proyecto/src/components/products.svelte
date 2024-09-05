
 <script lang="ts">
  import { onMount } from "svelte";
  import { instance, showProdcts } from "../stores/Stores";

  let isActiveCrud = true;
  let errorMessage = "";
  let id: number | null = null;
  let precio: number | null = null;
  let dimencion_id: number | null = null;
  let gama_producto_id: number | null = null;
  let proveedor_id: number | null = null;
  let stock_id: number | null = null;
  let descripcion: string = "";
  let nombre: string = "";
  let ElementSearch: string = "";
  let error: string = "";
  let loading: boolean = true;
  let info: any[] = [];
  let showSearch: boolean = true;
  let showUpdate: boolean = true;
  let showDelete: boolean = true;
  let isActiveCreate: boolean = true;

  // Funciones para cambiar la visibilidad de los formularios
  function toggleProduct() {
    isActiveCrud = !isActiveCrud;
  }

  function createToggle() {
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

  async function createProduct() {
    try {
      const token = localStorage.getItem('token'); // Obtiene el token del local storage

      if (!token) {
        console.error('Token de autenticación no encontrado');
        errorMessage = 'Token de autenticación no encontrado';
        return;
      }

      const producto = {
        nombre: nombre,
        gamaProducto: { id: gama_producto_id }, // Aquí solo se pasa el ID
        dimension: { id: dimencion_id }, // Aquí solo se pasa el ID
        proveedor: { id: proveedor_id }, // Aquí solo se pasa el ID
        descripcion: descripcion,
        stock: { id: stock_id }, // Aquí solo se pasa el ID
        precio: precio
      };

      const response = await fetch('http://localhost:8091/api/productos', {
        method: 'POST',
        body: JSON.stringify(producto),
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}` // Agrega el token en el encabezado
        }
      });

      if (!response.ok) {
        let errorData;
        try {
          errorData = await response.json();
        } catch (e) {
          console.error('Error de análisis de respuesta:', e);
          errorData = { message: 'Error desconocido' };
        }
        console.error('Error al crear producto:', errorData);
        errorMessage = `Error ${response.status}: ${JSON.stringify(errorData)}`;
        return;
      }

      const newProduct = await response.json();
      console.log('Producto creado:', newProduct);
      // Actualiza la UI o redirige según sea necesario

    } catch (error) {
      console.error('Error de red:', error);
      errorMessage = 'Error de red: ' + error;
    }
  }

  async function deleteProduct() {
  try {
    const token = localStorage.getItem('token');

    if (!token) {
      console.error('Token de autenticación no encontrado');
      errorMessage = 'Token de autenticación no encontrado';
      return;
    }

    const response = await fetch(`http://localhost:8091/api/productos/${id}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      }
    });

    if (!response.ok) {
      let errorData;
      try {
        errorData = await response.json();
      } catch (e) {
        console.error('Error de análisis de respuesta:', e);
        errorData = { message: 'Error desconocido' };
      }
      console.error('Error al eliminar producto:', errorData);
      errorMessage = `Error ${response.status}: ${JSON.stringify(errorData)}`;
      return;
    }

    console.log('Producto eliminado');
    // Actualiza la UI o redirige según sea necesario

  } catch (error) {
    console.error('Error de red:', error);
    errorMessage = 'Error de red: ' + error;
  }
}
async function save() {
  try {
    const token = localStorage.getItem('token');

    if (!token) {
      console.error('Token de autenticación no encontrado');
      errorMessage = 'Token de autenticación no encontrado';
      return;
    }

    const producto = {
      nombre: nombre,
      gamaProducto: { id: gama_producto_id },
      dimension: { id: dimencion_id },
      proveedor: { id: proveedor_id },
      descripcion: descripcion,
      stock: { id: stock_id },
      precio: precio
    };

    const response = await fetch(`http://localhost:8091/api/productos/${id}`, {
      method: 'PUT',
      body: JSON.stringify(producto),
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      }
    });

    if (!response.ok) {
      let errorData = { message: 'Error desconocido' };

      try {
        // Intenta analizar la respuesta JSON si está disponible
        errorData = await response.json();
      } catch (e) {
        console.error('Error de análisis de respuesta:', e);
      }

      console.error('Error al actualizar producto:', errorData);
      errorMessage = `Error ${response.status}: ${errorData.message || 'Error desconocido'}`;
      return;
    }

    // Si la respuesta es exitosa, puedes tratar con los datos de respuesta aquí
    console.log('Producto actualizado');
    // Actualiza la UI o redirige según sea necesario

  } catch (error) {
    console.error('Error de red:', error);
    errorMessage = 'Error de red: ' + error;
  }
}

</script>

<div class="cpw gcc">
  {#if isActiveCrud}
    <div>
      <button class="cp3" on:click={createToggle}>Crear</button>
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
        placeholder="ID del producto"
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
        <label for="id">Nombre encuenta </label>
        <input id="id" type="number" bind:value={id} placeholder="Ingrese un ID" />
      </section>
      <section class="fcc">
        <label for="precio">Pregunta</label>
        <input
          id="precio"
          type="number"
          bind:value={precio}
          placeholder="Ingrese el precio"
        />
      </section>
      <section class="fcc">
        <label for="dimencion_id">Dimensión ID</label>
        <input
          id="dimencion_id"
          type="number"
          bind:value={dimencion_id}
          placeholder="Ingrese ID de dimensión"
        />
      </section>
      <section class="fcc">
        <label for="gama_producto_id">Gama Producto ID</label>
        <input
          id="gama_producto_id"
          type="number"
          bind:value={gama_producto_id}
          placeholder="Ingrese ID de gama de producto"
        />
      </section>
      <section class="fcc">
        <label for="proveedor_id">Proveedor ID</label>
        <input
          id="proveedor_id"
          type="number"
          bind:value={proveedor_id}
          placeholder="Ingrese ID de proveedor"
        />
      </section>
      <section class="fcc">
        <label for="stock_id">Stock ID</label>
        <input
          id="stock_id"
          type="number"
          bind:value={stock_id}
          placeholder="Ingrese ID de stock"
        />
      </section>
      <section class="fcc">
        <label for="descripcion">Descripción</label>
        <textarea
          id="descripcion"
          bind:value={descripcion}
          placeholder="Ingrese una descripción"
        ></textarea>
      </section>
      <section class="fcc">
        <label for="nombre">Nombre</label>
        <input
          id="nombre"
          bind:value={nombre}
          placeholder="Ingrese el nombre"
        />
      </section>
    </div>
    {#if !isActiveCreate}
      <button class="cp2" on:click={createToggle}>Volver</button>
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
    grid-template-columns: repeat(3, 1fr);
    gap: 1rem;
  }

  .fcc {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .cp {
    margin-top: 10px;
    height: 50px;
    width: 100%;
    background-color: green;
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

  .cp3 {
    margin-top: 10px;
    height: 50px;
    width: 100%;
    background-color: gray;
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

  .gcc {
    display: grid;
    grid-template-columns: 1fr;
    gap: 1rem;
    padding: 1rem;
  }

  .f {
    display: flex;
    align-items: center;
    gap: 1rem;
  }

  .cpw {
    width: 100%;
  }
</style>
