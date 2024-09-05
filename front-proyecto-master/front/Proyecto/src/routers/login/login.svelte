<script>
    import { onMount } from "svelte";
    import { navigate } from "svelte-routing";
    import { showUser } from "../../stores/Stores";
    import "./Login.less";
    let username = "";
    let password = "";
    let token = "";
   function toggShouUser(){
    showUser.update( value => !value);
   }
    async function login() {
        navigate("/Dashboard"); 
        if ( username === "admin"){
                        showUser.update( value => !value);
                        alert("putito tu");
                        alert(showUser);
                    }
        
        if (username == "") {
            alert("Ingrese un usuario ");
         
        } else if (password == "") {
            alert("Ingrese una contraseña");
        } else {
            try {

                const response = await fetch("http://localhost:8091/auth/login", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    
                    body: JSON.stringify({ username, password }),
                    
                });

                if (!response.ok) {
                    const errorData = await response.json();
                    console.error("Error:", errorData.message);
                    return;
                }

                const data = await response.json();
                if (data.token) {
                    token = data.token;
                    localStorage.setItem("token", token); 
                    console.log("JWT Token:", token);

             
                    navigate("/Dashboard"); 
                } else {
                    console.error("Token no encontrado en la respuesta");
                }
            } catch (error) {
                console.error("Error en la solicitud:", error);
            }
        }
    }
    onMount(() => {
        token = localStorage.getItem("token") || "";
    });
</script>




<section class="vh-100 gradient-custom">
    <div class="container py-5">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card login-card">
                    <div class="card-body p-5 text-center">
                        <div class="mb-md-5 mt-md-4 pb-5">
                            <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                            <p class="text-white-50 mb-5">Please enter your login and password!</p>

                            <div class="form-outline form-white mb-4">
                                <label class="form-label" for="typeEmailX">Username</label>
                                <input type="text" id="typeEmailX" bind:value={username} class="form-control form-control-lg" />
                            </div>

                            <div class="form-outline form-white mb-4">
                                <label class="form-label" for="typePasswordX">Password</label>
                                <input type="password" bind:value={password} id="typePasswordX" class="form-control form-control-lg" />
                            </div>

                            <p class="small mb-5 pb-lg-2"><a class="text-white-50" href="#!">Forgot password?</a></p>

                            <button class="btn btn-outline-light btn-lg px-5" on:click={login} type="submit">Login</button>

                        </div>

                        <div>
                            <p class="mb-0">Don't have an account? <a href="#!" class="text-white-50 fw-bold">Sign Up</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

