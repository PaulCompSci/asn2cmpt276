
//display current gpa for gpa slider 

    var get = document.getElementById("gpa") ;
    get.oninput= (()=>{
        value = get.value ; 
        document.getElementById("currGPA").textContent = value  ;
    });

    window.addEventListener('DOMContentLoaded', function() {
        document.getElementById("addStudentForm").addEventListener("submit", function(event) {
            event.preventDefault(); // prevent the form from submitting

            // Perform any additional logic or validation here
            // ...

            // Display success message
            alert("User added successfully!");

            // Submit the form
            document.getElementById("addStudentForm").submit();
        });
    });

