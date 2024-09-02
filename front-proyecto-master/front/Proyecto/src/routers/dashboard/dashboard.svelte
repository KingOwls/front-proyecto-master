<!-- About.svelte -->
<script>
  import { link } from "svelte-spa-router";
  import Navbar from "../../components/nav.svelte";
  import { show } from "../../stores/Stores";
  import Sidebar from "../../components/Sidebar.svelte";
  import { rol } from "../../stores/Stores";
  import { showCustomer } from "../../stores/Stores"
  import { showProdcts } from "../../stores/Stores";

  //IMPORTACION DE LAS IMAGENES
  import magnifyingglass from "../../assets/magnifyingglass.svg";
  import productLogo from "../../assets/logoProducto.webp";
  import payMethod from "../../assets/pay.webp";
  import office from "../../assets/ofice.webp";
  import employe from "../../assets/jobgroup.webp";
  
  

  //IMPORTACION DE LOS COMPONENTES
  import Customer from "../../components/customer.svelte";
  import Employe from "../../components/Employes.svelte";
  import Office from "../../components/office.svelte";
  import Orders from "../../components/order.svelte";
  import Pay from "../../components/pays.svelte";
  import Product from "../../components/products.svelte";

  let asf = true;
  let showModal = false;

  function toggProduct() {
    showModal = !showModal;
    showProdcts.set(true); // Show products modal when toggling
  }

  function closeModal() {
    showModal = false; // Close modal
    showCustomer.set(false); // Ensure showCustomer is set to false when closing
    showProdcts.set(false); // Ensure showProdcts is set to false when closing
  }

  function toggCustomer() {
    showCustomer.update((value) => !value);
  }


  import "./Dashboard.css";
</script>

<div>
  <div class="input-group">
    <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
    <button type="button" class="btn btn-outline-primary" data-mdb-ripple-init>search</button>
  </div>

  <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
    <div class="row">
      <h2 class="my-title"> Ecommerce page </h2>
    </div>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <div class="d-flex">
          <div class="card card-slide cp" on:click={toggProduct}>
            <img class="card-img-top" src={productLogo} alt="Card image cap" />
            <div class="card-body">
              <h5 class="card-title">Productos</h5>
            </div>
          </div>
          <div class="card card-slide cp" on:click={toggCustomer}>
            <img class="card-img-top" src={productLogo} alt="Card image cap" />
            <div class="card-body">
              <h5 class="card-title">Clientes</h5>
            </div>
          </div>
          <div class="card card-slide">
            <img
              class="card-img-top"
              src={productLogo}
              alt="Card image cap"
              on:click={toggCustomer}
            />
            <div class="card-body">
              <h5 class="card-title">Pedidos</h5>
            </div>
          </div>
          <div class="card card-slide">
            <img
              class="card-img-top"
              src={payMethod}
              alt="Card image cap"
              on:click={toggProduct}
            />
            <div class="card-body">
              <h5 class="card-title">Pagos</h5>
            </div>
          </div>
          <div class="card card-slide">
            <img
              class="card-img-top"
              src={employe}
              alt="Card image cap"
              on:click={toggProduct}
            />
            <div class="card-body">
              <h5 class="card-title">Empleados</h5>
            </div>
          </div>
          <div class="card card-slide">
            <img
              class="card-img-top"
              src={office}
              alt="Card image cap"
              on:click={toggProduct}
            />
            <div class="card-body">
              <h5 class="card-title">Oficinas</h5>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- 
{#if showModal}
  Overlay to blur background 
  <div class="overlay" on:click={closeModal}></div>

  <div class="content">
    <button class="close-btn" on:click={closeModal}>×</button>
    {#if showProdcts}
      <Employe />
    {/if}
    {#if !asf}
      <Customer />
      <Employe />
      <Office />
      <Orders />
      <Pay />
      <Product />
    {/if}
  </div>
{/if}
 -->


{#if showModal}
  <!-- Overlay to blur background -->
  <div class="overlay" on:click={closeModal}></div>

  <!-- Modal content -->
  <div class="content">
    <button class="close-btn" on:click={closeModal}>×</button>
    {#if $showCustomer}
      <Customer />
    {:else if $showProdcts}
      <Product />
    {/if}
    {#if !asf}
      <Employe />
      <Office />
      <Orders />
      <Pay />
    {/if}
  </div>
{/if}


<!-- 
{#if showCustomer}

  <div class="overlay" on:click={toggCustomer}></div>


  <div class="content">
    <button class="close-btn" on:click={toggCustomer}>×</button>
    {#if showProdcts}
      <Employe />
    {:else if showCustomer}
      <Customer />
    {/if}
    {#if !asf}
      <Employe />
      <Office />
      <Orders />
      <Pay />
      <Product />
    {/if}
  </div>
{/if} -->
