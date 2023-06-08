
//display current gpa for gpa slider 

    var get = document.getElementById("gpa") ;
    get.oninput= (()=>{
        value = get.value ; 
        document.getElementById("currGPA").textContent = value  ;
    });


