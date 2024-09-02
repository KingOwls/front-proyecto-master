<script lang="ts">
  import userImage from "../assets/user.png";
  import { show } from "../stores/Stores";
  import "../styles/global.css";
  import logoCampus from "../assets/logocampus.webp";
  import { showProdcts } from "../stores/Stores";
  let isVisible: boolean = false;

  function toggProduct() {
    showProdcts.update((value) => !value);
  }
  function toggShow() {
    show.update((value) => !value);
  }
  function toggleSidebar() {
    isVisible = !isVisible;
  }
</script>

<!-- 
  <div class="nav ">
    <div>
      <button class="bl fcc cp"  on:click={toggShow}>
        <img class="lu" src={logoCampus} alt="User Image" />
      </button>
    </div>
    <div>Dashboard</div>
    <div>
      <button class="bl fcc cp " on:dblclick={toggleSidebar}>
        <img class="lu"src={userImage} alt="User Image" />
      </button>
    </div>
  </div>


<style lang="less">
  .nav {
    background-color: var(--color1);
    height: 10vh;
    display: flex;
    width: 100%

  }

  .lu {
    height: 5rem;
    width: auto;
  }

  .bl {


    width: 3rem;
    margin: 0.8rem;
    margin-left: 2rem;
    background-color: white;
    border: none;
   
  } -->


<!-- </style> -->
